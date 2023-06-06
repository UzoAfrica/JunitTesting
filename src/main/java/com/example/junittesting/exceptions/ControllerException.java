package com.example.junittesting.exceptions;

public class ControllerException extends RuntimeException{
    private static final long serialVersionUID =1L;
    private String errorCode;
    private String errorMessage;
    private String getErrorCode(){
        return errorCode;
    }

    private void setErrorCode(String errorCode){
        this.errorCode = errorCode;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    private void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
    public static long getSerialVersionUID(){
        return serialVersionUID;
    }
    public ControllerException(String errorCode, String errorMessage){
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    public ControllerException(String errorMessage){
        super();
        this.errorMessage =errorMessage;
    }
    public ControllerException(){

    }
}
