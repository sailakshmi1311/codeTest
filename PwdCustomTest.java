package com.demo.pwdcustomtest;
import com.exception.PwdCustomException;
import com.validation.passwordvalidation.PwdVerification;
import java.util.Scanner;

public class PwdCustomTest {
    public static void main(String[] args) {

        Scanner sc =  new Scanner(System.in);
        while(true) {
            System.out.println("Enter password : ");
            String pwd = sc.nextLine();
            try{
                //Initial pwd validation
                PwdVerification.validate(pwd);
                System.out.println("Password entered is valid..");
            } catch(PwdCustomException e){
                System.out.println("Exception occured in password validation.." + e.getMessage());
            }
            //Password validation checks for 3 rules and at least 1 lower case
            boolean b = PwdVerification.pwdValidation(pwd);
            if(b)
                System.out.println(" Password is OK - 3 rules are passed" );
            else System.out.println(" Password is not OK ");

            // Password parallel fast validation
            try{
                boolean t = PwdVerification.pwdValidationFast(pwd);
                if(t)
                    System.out.println("Password is OK (Fast parallel check) - 3 rules are passed ");
            }catch(Exception e){
                System.out.println("Exception occured in parallel check ");
            }

           //sc.close();


        }

    }

}
