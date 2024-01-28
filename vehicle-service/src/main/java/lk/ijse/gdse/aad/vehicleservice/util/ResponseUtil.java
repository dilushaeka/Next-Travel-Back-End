package lk.ijse.gdse.aad.vehicleservice.util;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class ResponseUtil {
    private int code;
    private String message;
    private Object data;
}
