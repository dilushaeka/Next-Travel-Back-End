package lk.ijse.guideservice.exception;


public class DuplicateException extends RuntimeException{
    public DuplicateException(String error) {
        super(error);
    }
}
