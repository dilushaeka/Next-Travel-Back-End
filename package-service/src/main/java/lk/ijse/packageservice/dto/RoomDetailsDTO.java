package lk.ijse.packageservice.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomDetailsDTO {

    @NotNull(message = "Room type cannot be null !")
    @NotEmpty(message = "Room type cannot be empty !")
    private String RoomType;

    @Positive
    @Min(1)
    private Integer qty;

    @Positive
    private Double price;
}
