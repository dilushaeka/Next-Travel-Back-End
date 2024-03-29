package lk.ijse.packageservice.repository;

import lk.ijse.packageservice.entity.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Integer> {

    void deleteByPackageId(String packageId);

    Optional<PaymentDetails> findByPackageId(String packageId);

    @Query(value = "select p from PaymentDetails p where p.status = ?1")
    List<PaymentDetails> getAllPayment(String status);
}
