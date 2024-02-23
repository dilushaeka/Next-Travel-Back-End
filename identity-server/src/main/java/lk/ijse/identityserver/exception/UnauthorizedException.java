package lk.ijse.identityserver.exception;


public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException(String error){
        super(error);
    }
}
