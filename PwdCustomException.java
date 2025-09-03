package com.demo.pwdcustomtest.exception;

//Base class for all exception classes
public  class PwdCustomException extends Exception{

    public PwdCustomException(String msg){
        super(msg);
    }

    //Throws exception when pwd is null
     public static class NullException extends PwdCustomException{
        public NullException(){ super("Password should not be null value");}
     }

     //throws exception when pwd length is not greater than 8
    public static class MinLengthException extends PwdCustomException{
        public MinLengthException(){ super("Password should contain minimum length of 8");}
    }

    //throws exception when pwd does not contain one uppercase letter
    public static class UppercaseException extends PwdCustomException{
        public UppercaseException(){ super("Password should contain at least one uppercase character");}
    }

    //throws exception when pwd does not contain one lowercase letter
    public static class LowercaseException extends PwdCustomException{
        public LowercaseException(){ super("Password should contain at least one lowercase character");}
    }

    //throws exception when pwd does not contain one numeric
    public static class NumericException extends PwdCustomException{
        public NumericException(){ super("Password should contain one numeric value ");}
    }

}
