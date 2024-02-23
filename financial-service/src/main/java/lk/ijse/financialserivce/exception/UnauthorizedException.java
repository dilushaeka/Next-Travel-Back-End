package lk.ijse.financialserivce.exception;


public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException(String error){
        super(error);
    }
}
