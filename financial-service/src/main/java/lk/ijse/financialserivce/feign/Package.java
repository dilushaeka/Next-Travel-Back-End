package lk.ijse.financialserivce.feign;

import lk.ijse.financialserivce.dto.PackageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;



@FeignClient("PACKAGE-SERVICE")
public interface Package {

    @GetMapping(value = "nexttravel/api/v1/package/getAllPackages", produces = {MediaType.APPLICATION_JSON_VALUE})
    List<PackageDTO> getAllPackages();
}
