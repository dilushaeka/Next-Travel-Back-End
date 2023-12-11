package lk.ijse.gdse.aad.vehicleservice.service;

import lk.ijse.gdse.aad.vehicleservice.dto.VehicleDTO;
import lk.ijse.gdse.aad.vehicleservice.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    public void saveVehicle(VehicleDTO dto);
    public void deleteVehicle(String vehicleID);
    public void updateVehicle(VehicleDTO dto);
    public VehicleDTO searchVehicle(String vehicleID);
    public List<VehicleDTO> getAllVehicles();
}
