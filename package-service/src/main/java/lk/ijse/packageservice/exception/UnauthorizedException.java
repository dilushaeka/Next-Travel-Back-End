package lk.ijse.packageservice.exception;


public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException(String error){
        super(error);
    }
}
