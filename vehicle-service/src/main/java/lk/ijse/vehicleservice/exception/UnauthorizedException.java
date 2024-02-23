package lk.ijse.vehicleservice.exception;


public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException(String error){
        super(error);
    }
}
