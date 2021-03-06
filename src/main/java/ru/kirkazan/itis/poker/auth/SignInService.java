package ru.kirkazan.itis.poker.auth;

/**
 * @author esadykov
 * @since 27.10.13 23:20
 */
public class SignInService {

    private UserStorage userStorage;

    public User singIn(SignInForm signInForm) {

        User user = userStorage.getUser(signInForm.username, signInForm.password);
        return user;
    }

}
