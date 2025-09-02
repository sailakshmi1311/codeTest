package com.passwordvalidation;

public class PwdVerification {

    private static boolean minLengthCheck(String pwd){
        return pwd!=null && pwd.length()>8;
    }
    private static boolean nullCheck(String pwd){
        return pwd!=null;
    }
    private static boolean uppercaseCheck(String pwd){
        if(pwd == null) return false;
        for(char c:pwd.toCharArray()){
            if(Character.isUpperCase(c))
                return true;
        }
        return false;
    }
    private static boolean lowercaseCheck(String pwd){
        if(pwd == null) return false;
        for(char c:pwd.toCharArray()){
            if(Character.isLowerCase(c))
                return true;
        }
        return false;
    }
    private static boolean hasNumerics(String pwd){
        if(pwd == null) return false;
        for(char c:pwd.toCharArray()){
            if(Character.isDigit(c))
                return true;
        }
        return false;
    }

    public static boolean passwordValidation(String pwd){

        int c=0;
        if(!minLengthCheck(pwd)){
            return false;
        }
        if(!nullCheck(pwd))
            c++;
        if(uppercaseCheck(pwd))
            c++;
        if(lowercaseCheck(pwd))
            c++;
        if(hasNumerics(pwd))
            c++;

        c++;
        return c>=3;
    }

}
