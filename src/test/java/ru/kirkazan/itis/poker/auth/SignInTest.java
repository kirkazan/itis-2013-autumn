package ru.kirkazan.itis.poker.auth;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;
import org.junit.Test;


/**
 * @author esadykov
 * @since 27.10.13 23:06
 */
public class SignInTest {

    @Test
    public void signIn(){

        SignInForm signInForm = mock(SignInForm.class);
        SignInService signInService = spy(new SignInService());
        UserStorage userStorage = mock(UserStorage.class);
        when(signInService.getUserStorage()).thenReturn(userStorage);

        User resultUser;
        User forResultUser = new User();
        when(userStorage.getUser(signInForm.username, signInForm.password)).thenReturn(forResultUser);
        resultUser = signInService.singIn(signInForm);

        verify(userStorage, times(1)).getUser(signInForm.username, signInForm.password);
        assertTrue(forResultUser == resultUser);

        when(userStorage.getUser(signInForm.username, signInForm.password)).thenReturn(null);
        resultUser = signInService.singIn(signInForm);

        verify(userStorage, times(2)).getUser(signInForm.username, signInForm.password);
        assertNull(resultUser);
    }
}
