package lk.ijse.gdse.aad.vehicleservice.service;

import lk.ijse.gdse.aad.vehicleservice.dto.VehicleDTO;
import lk.ijse.gdse.aad.vehicleservice.entity.Vehicle;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VehicleService {
    public VehicleDTO saveVehicle(VehicleDTO dto, List<MultipartFile> imageList) throws IOException;
    public void deleteVehicle(String vehicleID);
    public void updateVehicle(VehicleDTO dto);
    public VehicleDTO searchVehicle(String vehicleID);
    public List<VehicleDTO> getAllVehicles();
}
