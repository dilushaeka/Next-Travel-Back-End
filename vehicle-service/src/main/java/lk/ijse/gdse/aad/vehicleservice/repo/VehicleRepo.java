package lk.ijse.gdse.aad.vehicleservice.repo;

import lk.ijse.gdse.aad.vehicleservice.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface VehicleRepo extends JpaRepository<Vehicle,String> {
}
