package lk.ijse.hotelservice.exception;


public class NotFoundException extends RuntimeException{
    public NotFoundException(String error) {
        super(error);
    }
}
