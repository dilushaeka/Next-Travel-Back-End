package lk.ijse.gdse.aad.vehicleservice.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Vehicle {
    @Id
    private String vehicleID;
    private String vehicleBrand;
    private String vehicleCategory; //Rconomy,Mid-range,Luxury,Super Luxury
    private String vehicleType; //van,car,suv

//    private String vehicleSearchType; // P/A,P/M,D/A,D/M
//    private String vehicleHybridOrNot;
//    private String vehicleFuelType;
//    private int    vehicleFuelUsage;
//    private int    vehicleSeatCapacity;
//    private double vehicleFee_for_1km;
//    private double vehicleFee_for_Day;
//    private String vehicleStatus;
//    private String vehicleTransmissionType;//auto/manual
//    private String vehicleDriverName;
//    private String vehicleDriverContact;
//
//    private byte[] vehicleDriverLicense;
//    private byte[] frontImage;
//    private byte[] rearImage;
//    private byte[] sideImage;
//    private byte[] frontInteriorImage;
//    private byte[] rearInteriorImage;
}
