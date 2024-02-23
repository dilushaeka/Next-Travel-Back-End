package lk.ijse.vehicleservice.exception;


public class DuplicateException extends RuntimeException{
    public DuplicateException(String error) {
        super(error);
    }
}
