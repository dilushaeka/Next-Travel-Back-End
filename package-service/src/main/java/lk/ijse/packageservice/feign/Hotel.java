package lk.ijse.packageservice.feign;

import feign.Headers;
import lk.ijse.packageservice.util.ResponseUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("HOTEL-SERVICE")
public interface Hotel {

    @GetMapping(value = "nexttravel/api/v1/hotel/getAllWithCategory", params = {"page", "count", "category"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseUtil getHotelWithCategory(@RequestParam Integer page,
                                             @RequestParam Integer count,
                                             @RequestParam Integer category);

    @GetMapping(value = "nexttravel/api/v1/hotel/get", params = {"hotelId"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseUtil getHotelById(@RequestParam Integer hotelId);

}
