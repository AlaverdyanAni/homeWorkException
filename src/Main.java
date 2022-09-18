import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        String login = "Ani_Alaverdyan";
        String password = "1525_Ani";
        String confirmPassword = "1525_Ani";
        System.out.println(logIn(login, password, confirmPassword));

    }
    public static boolean logIn(String login, String password, String confirmPassword) {
        boolean checkLogin;
        boolean checkpassword;
        boolean checkLoginLength;
        boolean checkPasswordLength;
        try {
            checkLogin = checkValidate(login);
            checkpassword = checkValidate(password);
            checkLoginLength = checkLoginLength(login);
            checkPasswordLength = checkPassswordLength(password);
            checkPasswordMatching(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return checkLogin && checkpassword && checkLoginLength && checkPasswordLength;
    }

    public static boolean checkValidate(String word) {
        if (word == null) {
            throw new NullPointerException("Пустое поле!");
        }
        if (word.matches("\\w+")) {
            return true;
        }
        System.out.printf("должен содержать только латинские буквы, цифры и знак подчеркивания! + %s\n", word);
        return false;
    }

    public static boolean checkLoginLength(String login) {
        if (login.length() > 20) {
            throw new WrongLoginException("login длиннее 20 символов!");
        }
        return true;
    }

    public static boolean checkPassswordLength(String password) {
        if (password.length() > 19) {
            System.out.println("password длиннее 19 символов!");
            return false;
        }
        return true;
    }

    public static boolean checkPasswordMatching(String password, String confirmPassword) {
        if (password.equals(confirmPassword)) return true;
        throw new WrongPasswordException("Пороль не совпадает!");
    }
}