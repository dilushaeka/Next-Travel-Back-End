package lk.ijse.packageservice.exception;


public class NotFoundException extends RuntimeException{
    public NotFoundException(String error) {
        super(error);
    }
}
