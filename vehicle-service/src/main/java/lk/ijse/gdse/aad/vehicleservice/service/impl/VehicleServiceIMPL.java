package lk.ijse.gdse.aad.vehicleservice.service.impl;

import lk.ijse.gdse.aad.vehicleservice.dto.VehicleDTO;
import lk.ijse.gdse.aad.vehicleservice.entity.Vehicle;
import lk.ijse.gdse.aad.vehicleservice.exception.NotFoundException;
import lk.ijse.gdse.aad.vehicleservice.repo.VehicleRepo;
import lk.ijse.gdse.aad.vehicleservice.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class VehicleServiceIMPL implements VehicleService {

    @Autowired
    private VehicleRepo repo;

    @Autowired
    private ModelMapper mapper;

    private final String mainPath="C\\Images\\Vehicle\\";

    @Override
    public VehicleDTO saveVehicle(VehicleDTO dto,List<MultipartFile> imageList) throws IOException {
        if (imageList.size()!=7)throw new NotFoundException("Vehicle All Images not found !");

        String folderPath=mainPath+ UUID.randomUUID();
        File file =new File(folderPath);
        if (file.mkdir())throw new NotFoundException("vehicle Image DirectoryCreation failed  !");


        if (!repo.existsById(dto.getVehicleID())){
            Vehicle entity=mapper.map(dto,Vehicle.class);
            entity.setFolderLocation(folderPath);

            entity.setFrontImage(saveAndGetPath(folderPath,"1", imageList.get(0)));
            entity.setFrontInteriorImage(saveAndGetPath(folderPath,"2", imageList.get(1)));
            entity.setRearImage(saveAndGetPath(folderPath,"3", imageList.get(2)));
            entity.setRearInteriorImage(saveAndGetPath(folderPath,"4", imageList.get(3)));
            entity.setSideImage(saveAndGetPath(folderPath,"5", imageList.get(4)));
            entity.setVehicleDriverLicenseImg1(saveAndGetPath(folderPath,"6", imageList.get(5)));
            entity.setVehicleDriverLicenseImg2(saveAndGetPath(folderPath,"7", imageList.get(6)));

            return mapper.map(repo.save(entity),VehicleDTO.class);
    }else {
            throw new RuntimeException("this vehicle is all Ready Added..!");
        }

}

private String saveAndGetPath(String folderPath,String name,MultipartFile file) throws IOException{
        String imgPath = folderPath + "\\"+name+file.getOriginalFilename();
        file.transferTo(Paths.get(imgPath));
        return imgPath;
}

    @Override
    public void deleteVehicle(String vehicleID){
        if (repo.existsById(vehicleID)) {
            repo.deleteById(vehicleID);
        }else {
            throw new RuntimeException("please check the vehicle id... No Such Vehicle...!");
        }
    }
    @Override
    public void updateVehicle(VehicleDTO dto){
        if (repo.existsById(dto.getVehicleID())){
            Vehicle entity = mapper.map(dto, Vehicle.class);
            repo.save(entity);
        }else {
            throw new RuntimeException("dont have this Vehicle...! please Check IT");
        }
    }
    @Override
    public VehicleDTO searchVehicle(String vehicleID){
        if (repo.existsById(vehicleID)) {
            Vehicle vehicle= repo.findById(vehicleID).get();
            return mapper.map(vehicle,VehicleDTO.class);
        }else {
            throw new RuntimeException("No Customer for "+vehicleID+"..!");
        }

    }
    @Override
    public List<VehicleDTO> getAllVehicles(){
        List<Vehicle> all=repo.findAll();
        return mapper.map(all, new TypeToken<List<VehicleDTO>>(){}.getType());
    }
}
