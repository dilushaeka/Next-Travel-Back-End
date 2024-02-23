package lk.ijse.identityserver.exception;


public class DuplicateException extends RuntimeException{
    public DuplicateException(String error) {
        super(error);
    }
}
