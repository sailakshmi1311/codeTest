import static com.passwordvalidation.PwdVerification.passwordValidation;

public class Main {
    public static void main(String[] args) {

        String[] randomPasswords = {
                "apple",
                "abcdefghi",
                "123456789",
                "Apple25678",
                "ABCDEFGHI",
                "Banana139786"
        };

        for (String pwd : randomPasswords){
            boolean b = passwordValidation(pwd);
            if(b)
                System.out.println("Password "+pwd+" is Valid..");
            else
                System.out.println("Password "+pwd+" is Invalid..");
        }
    }
}