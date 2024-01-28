package lk.ijse.gdse.aad.vehicleservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.lang.Nullable;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class VehicleDTO {

    private String vehicleID;
    private String vehicleBrand;
    private String vehicleCategory; //Rconomy,Mid-range,Luxury,Super Luxury
    private String vehicleType; //van,car,suv

    private String vehicleSearchType; // P/A,P/M,D/A,D/M

    private String vehicleHybridOrNot;
    private String vehicleFuelType;
    private int    vehicleFuelUsage;
    private int    vehicleSeatCapacity;
    private double vehicleFee_for_1km;
    private double vehicleFee_for_Day;
    private String vehicleStatus;
    private String vehicleTransmissionType;//auto/manual

    private String vehicleDriverName;
    private String vehicleDriverContact;

    private List<byte[]> imageList;
}
