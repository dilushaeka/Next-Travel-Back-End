package lk.ijse.packageservice.exception;


public class DuplicateException extends RuntimeException{
    public DuplicateException(String error) {
        super(error);
    }
}
