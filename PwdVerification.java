package com.demo.passwordcustomtest.validation;

import com.demo.passwordcustomtest.exception.PwdCustomException;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PwdVerification {

    /*
     Performs password validation operations
     If any one rule fails throws respective custom exception
     */
    public static void validate(String pwd) throws PwdCustomException {

        if(pwd == null )
            throw new PwdCustomException.NullException();
        if( pwd != null && pwd.length() <= 8)
            throw new PwdCustomException.MinLengthException();
        if( pwd.matches(".*[A-Z].*"))
            throw new PwdCustomException.UppercaseException();
        if( pwd.matches(".*[a-z].*"))
            throw new PwdCustomException.LowercaseException();
        if( pwd.matches(".*[0-9].*"))
            throw new PwdCustomException.NumericException();

    }

    /*
     Performs operations on password to check
     If 3 of the conditions are true
     and has at least one lowercase letter
     */
    public static boolean pwdValidation(String pwd) {

        int c=0;
        if(pwd == null) return false;
        if(pwd.length() > 8)
            c++;
        if(pwd.matches(".*[A-Z].*"))
            c++;
        if(pwd.matches(".*[a-z].*"))
            c++;
        if(pwd.matches(".*[0-9].*"))
            c++;

        //Check : Should always have onw lowercase
        if(!pwd.matches(".*[a-z].*")) return false;
        return c>=3;
    }

    /*
     Performs password validation parallelly to run faster
     using thread pool to invoke all checks at once
     */
    public static boolean pwdValidationFast(String pwd) throws Exception{

        ExecutorService ex = Executors.newFixedThreadPool(4);
        Callable<Boolean> minlen = () -> {
            Thread.sleep(1000);
            return pwd.length()>8;
        };
        Callable<Boolean> uppercase = () -> {
            Thread.sleep(1000);
            return pwd.matches(".*[A-Z].*");
        };
        Callable<Boolean> lowercase = () -> {
            Thread.sleep(1000);
            return pwd.matches(".*[a-z].*");
        };
        Callable<Boolean> numericcheck = () -> {
            Thread.sleep(1000);
            return pwd.matches(".*[0-9].*");
        };

        var res = ex.invokeAll(List.of(minlen,uppercase,lowercase,numericcheck));
        ex.shutdown();

        int c=0;
        for(Future<Boolean> f : res){
            if(f.get()) c++;
        }

        //Check : Should always have one lowercase
        if(!res.get(2).get()) return false;

        return c>=3;
    }

}
