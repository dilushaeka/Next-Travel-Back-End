package lk.ijse.gdse.aad.vehicleservice.service.impl;

import lk.ijse.gdse.aad.vehicleservice.dto.VehicleDTO;
import lk.ijse.gdse.aad.vehicleservice.entity.Vehicle;
import lk.ijse.gdse.aad.vehicleservice.repo.VehicleRepo;
import lk.ijse.gdse.aad.vehicleservice.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class VehicleServiceIMPL implements VehicleService {

    @Autowired
    private VehicleRepo repo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void saveVehicle(VehicleDTO dto) {
        if (!repo.existsById(dto.getVehicleID())){
            //Vehicle entity=mapper.map(dto,Vehicle.class);
            repo.save(mapper.map(dto,Vehicle.class));
    }else {
            throw new RuntimeException("this vehicle is all Ready Added..!");
        }

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
