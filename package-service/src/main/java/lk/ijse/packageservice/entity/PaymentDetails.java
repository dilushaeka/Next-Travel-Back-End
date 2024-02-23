package lk.ijse.packageservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "_payment_details")
public class PaymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String packageId;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Double packageValue;

    @Column(nullable = false)
    private Double paidValue;

    private String folderPath;

    private String sliImgPath;
}
