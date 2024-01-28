package lk.ijse.gdse.aad.vehicleservice.api;

import jakarta.validation.Valid;
//import lk.ijse.gdse.aad.vehicleservice.dto.VehicleDTO;
import lk.ijse.gdse.aad.vehicleservice.dto.VehicleDTO;
import lk.ijse.gdse.aad.vehicleservice.entity.Vehicle;
import lk.ijse.gdse.aad.vehicleservice.service.VehicleService;
import lk.ijse.gdse.aad.vehicleservice.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.Media;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/vehicle")
@CrossOrigin
public class VehicleController {
    @Autowired
    VehicleService vehicleService;


    @GetMapping(path = "save",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllVehicles(){
        return new ResponseUtil(200,"All Vehicle are came",vehicleService.getAllVehicles());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveVehicle(@RequestPart("imageList")List<MultipartFile> imageList,
                                    @Valid @RequestPart("vehicle") VehicleDTO vehicle) throws IOException {
        return ResponseUtil
                .builder().code(200).message("Vehicle Save Successfully").data(vehicleService.saveVehicle(vehicle,imageList)).build();
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateVehicle(@RequestBody VehicleDTO vehicle){
        vehicleService.updateVehicle(vehicle);
        return new ResponseUtil(200,"Vehicle Updated",vehicle);
    }

    @DeleteMapping(params = {"vehicleID"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteVehicle(@RequestParam String vehicleID){
        vehicleService.deleteVehicle(vehicleID);
        return new ResponseUtil(200,"Deleted Vehicle",vehicleID);
    }

    @GetMapping(path = "/{vehicleID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchVehicle(@PathVariable String vehicleID){
        return new ResponseUtil(200,"You searched vehicle is came",vehicleService.searchVehicle(vehicleID));
    }
}
