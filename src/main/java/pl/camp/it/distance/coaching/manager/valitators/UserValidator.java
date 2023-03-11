package pl.camp.it.distance.coaching.manager.valitators;

import pl.camp.it.distance.coaching.manager.exceptions.UserValidationException;
import pl.camp.it.distance.coaching.manager.model.User;

public class UserValidator {
    public static void validateLogin(String login) {
        String regex = "^[a-zA-Z0-9]{4,}$";
        if(!login.matches(regex)) {
            throw new UserValidationException();
        }
    }

    public static void validatePassword(String password) {
        String regex = "^[a-zA-Z0-9]{5,}$";
        if(!password.matches(regex)) {
            throw new UserValidationException();
        }
    }

    public static void validateName(String name) {
        String regex = "^[A-Z]{1}[a-z]+$";
        if(!name.matches(regex)) {
            throw new UserValidationException();
        }
    }

    public static void validateSurname(String surname) {
        String regex = "^[A-Z]{1}[a-z]+(-[A-Z]{1}[a-z]+)?$";
        if(!surname.matches(regex)) {
            throw new UserValidationException();
        }
    }

    public static void validateEmail(String email) {
        String regex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
        if(!email.matches(regex)) {
            throw new UserValidationException();
        }
    }

    public static void validatePasswordsEquality(String password1, String password2) {
        if(!password1.equals(password2)) {
            throw new UserValidationException();
        }
    }

    public static void validateUser(User user, String password2){
        validateLogin(user.getLogin());
        validateLogin(user.getName());
        validateLogin(user.getSurname());
        validateEmail(user.getEmail());
        validatePassword(user.getPassword());
        validatePasswordsEquality(user.getPassword(), password2);
    }
}
