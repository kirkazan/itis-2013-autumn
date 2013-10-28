package ru.kirkazan.itis.poker.auth;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;


/**
 * @author esadykov
 * @since 27.10.13 23:06
 */
@RunWith(MockitoJUnitRunner.class)
public class SignInTest {

    @InjectMocks
    private SignInService signInService = new SignInService();

    @Mock
    private UserStorage userStorage;

    @Test
    public void signIn(){

        SignInForm signInForm = new SignInForm();

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

        /*
        todo

        Не искать в базе при пустых значениях имени пользователя или пароля
         */
        signInForm.username = "";
        signInForm.password = "";

        signInService.singIn(signInForm);
        verify(userStorage, never()).getUser(signInForm.username, signInForm.password);

    }
}
