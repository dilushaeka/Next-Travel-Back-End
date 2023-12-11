package lk.ijse.gdse.aad.vehicleservice.api;


//import lk.ijse.gdse.aad.vehicleservice.dto.VehicleDTO;
import lk.ijse.gdse.aad.vehicleservice.dto.VehicleDTO;
import lk.ijse.gdse.aad.vehicleservice.entity.Vehicle;
import lk.ijse.gdse.aad.vehicleservice.service.VehicleService;
import lk.ijse.gdse.aad.vehicleservice.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequestMapping("api/v1/vehicle")
@CrossOrigin
public class VehicleController {
    @Autowired
    VehicleService vehicleService;


//    @GetMapping(params = {"param1","param2"})
//    public String get(String param1,String param2){
//        return "this is vehicle get1"+"  "+param1+" "+param2;
//    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllVehicles(){
        return new ResponseUtil(200,"All Vehicle are came",vehicleService.getAllVehicles());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveVehicle(@ModelAttribute VehicleDTO vehicle){
        System.out.println(vehicle);
        vehicleService.saveVehicle(vehicle);
        return new ResponseUtil(200,"Vehicle Saved", vehicle);
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
