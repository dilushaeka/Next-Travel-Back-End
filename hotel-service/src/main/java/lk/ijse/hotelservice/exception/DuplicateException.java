package lk.ijse.hotelservice.exception;


public class DuplicateException extends RuntimeException{
    public DuplicateException(String error) {
        super(error);
    }
}
