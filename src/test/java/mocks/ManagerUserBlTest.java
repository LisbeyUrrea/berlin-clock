package mocks;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class ManagerUserBlTest {

    private ManagerUserBl managerUserBl;

    @Mock
    IUserConfigRepository userConfigRepository;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        managerUserBl = new ManagerUserBl(userConfigRepository);
    }

    @Test
    @Parameters({
            "12345678, false",
            "1Ai, false",
            "asdfghjk, false",
            "ATHGFDER, false",
            "w3Unpocodet0d0, true"
    })
    public void methodValidatePasswordShouldValidateIfPasswordIsCorrect(String password, boolean expect) {
        when(userConfigRepository.passwordRegExp()).thenReturn("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");

        boolean result = managerUserBl.validatePassword(password);

        Assert.assertEquals(expect, result);
        verify(userConfigRepository, times(1)).passwordRegExp();

    }

    @Test
    @Parameters({
            "lisbey, false",
            "lisbey@, false",
            "lisbey@hotmail, false",
            "@hotmail.com, false",
            "lisbey@hotmail.com, true",
            "lisbey@hotmail.com.co, true",
    })
    public void methodValidateEmailShouldValidateIfEmailIsCorrect(String email, boolean expect) {
        when(userConfigRepository.emailRegExp()).thenReturn("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$");

        boolean result = managerUserBl.validateEmail(email);

        Assert.assertEquals(expect, result);
        verify(userConfigRepository, times(1)).emailRegExp();

    }

    @Test
    public void methodValidateEmailShouldValidateIfEmailIsCorrect() {
        String email = "urlisbey@hotmail,com";
        boolean expect = false;

        when(userConfigRepository.emailRegExp()).thenReturn("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$");

        boolean result = managerUserBl.validateEmail(email);

        Assert.assertEquals(expect, result);
        verify(userConfigRepository, times(1)).emailRegExp();

    }

    @Test
    @Parameters({
            "12345, false",
            "lisbey*urrea, false",
            "lisbey urrea, false",
            "lisbey45, false",
            "lisbeyUrrea, true",
    })
    public void methodValidateNickNameShouldValidateIfNickNameIsCorrect(String nickName, boolean expect) {
        when(userConfigRepository.nickNameRegExp()).thenReturn("^[a-zA-Z]*$");

        boolean result = managerUserBl.validateNickName(nickName);

        Assert.assertEquals(expect, result);
        verify(userConfigRepository, times(1)).nickNameRegExp();

    }



    @Test
    @Parameters({
            " , false",
            ", false",
            "lisbey, true",
            "1123456789, true"
    })
    public void methodValidateNullOrEmptyShouldValidateIfTheParamIsNullOrEmpty(String param, boolean expect) {
        boolean result = managerUserBl.validateNullOrEmpty(param);
        assertEquals(expect,result);
    }

    @Test
    @Parameters({
            "lisbey, false",
            "1587*, false",
            "1587 4512, false",
            "1587?, false",
            "1123456789, true"
    })
    public void methodIsNumberShouldValidateIfTheParamIsANumber(String number, boolean expect) {
        boolean result = managerUserBl.isNumber(number);
        assertEquals(expect,result);
    }


    @Test
    public void methodRegisterUserShouldReturnUsuarioResgistradoExitosamenteWhenAllParamsAreCorrect() {
        UserManager user = new UserManager("Lisbey",
                "Urrea",
                "urlisbey@hotmail.com",
                "3137189233",
                "w3Unpocodet0d0",
                "lisbeyUrrea");

        String expect = "¡Usuario resgistrado exitosamente!";
        when(userConfigRepository.registerUser(user)).thenReturn(expect);
        when(userConfigRepository.emailRegExp()).thenReturn("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$");
        when(userConfigRepository.passwordRegExp()).thenReturn("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
        when(userConfigRepository.nickNameRegExp()).thenReturn("^[a-zA-Z]*$");

        String result = managerUserBl.registerUser(user);

        assertEquals(expect,result);
        verify(userConfigRepository,times(1)).registerUser(user);
        verify(userConfigRepository,times(1)).emailRegExp();
        verify(userConfigRepository,times(1)).passwordRegExp();
        verify(userConfigRepository,times(1)).nickNameRegExp();

    }

    @Test(expected = IllegalArgumentException.class)
    public void methodIsValidUserShouldReturnIllegalArgumentExceptionWhenSomeLastNameIsEmpty() {

        UserManager user = new UserManager("", null, "lisbey@hotmail.com","3137189233","password", "lisbeyUrrea");
        String expect = "¡Usuario resgistrado exitosamente!";
        when(userConfigRepository.registerUser(user)).thenReturn(expect);
        when(userConfigRepository.emailRegExp()).thenReturn("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$");
        when(userConfigRepository.passwordRegExp()).thenReturn("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");

        managerUserBl.registerUser(user);
        verify(userConfigRepository,times(0)).registerUser(user);
        verify(userConfigRepository,times(0)).emailRegExp();
        verify(userConfigRepository,times(0)).passwordRegExp();
    }

    @Test(expected = IllegalArgumentException.class)
    public void methodIsValidUserShouldReturnIllegalArgumentExceptionWhenSomeMobileIsEmpty() {

        UserManager user = new UserManager("Lisbey", "Urrea", "",null,"password", "lisbeyUrrea");
        String expect = "¡Usuario resgistrado exitosamente!";
        when(userConfigRepository.registerUser(user)).thenReturn(expect);
        when(userConfigRepository.emailRegExp()).thenReturn("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$");
        when(userConfigRepository.passwordRegExp()).thenReturn("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");

        managerUserBl.registerUser(user);
        verify(userConfigRepository,times(0)).registerUser(user);
        verify(userConfigRepository,times(0)).emailRegExp();
        verify(userConfigRepository,times(0)).passwordRegExp();
    }

    @Test(expected = IllegalArgumentException.class)
    public void methodIsValidUserShouldReturnIllegalArgumentExceptionWhenSomePasswordIsEmpty() {

        UserManager user = new UserManager("Lisbey", "Urrea", "lisbey@hotmail.com","3137189233","", null);
        String expect = "¡Usuario resgistrado exitosamente!";
        when(userConfigRepository.registerUser(user)).thenReturn(expect);
        when(userConfigRepository.emailRegExp()).thenReturn("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$");
        when(userConfigRepository.passwordRegExp()).thenReturn("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");

        managerUserBl.registerUser(user);
        verify(userConfigRepository,times(0)).registerUser(user);
        verify(userConfigRepository,times(0)).emailRegExp();
        verify(userConfigRepository,times(0)).passwordRegExp();
    }

    @Test(expected = IllegalArgumentException.class)
    public void methodRegisterUserShouldReturnIllegalArgumentExceptionWhenEmailIsIncorrect() {

        UserManager user = new UserManager("Lisbey", "Urrea", "@hotmail.com","3137189233","w3Unpocodet0d0", "lisbeyUrrea");
        String expect = "¡Usuario resgistrado exitosamente!";
        when(userConfigRepository.registerUser(user)).thenReturn(expect);
        when(userConfigRepository.emailRegExp()).thenReturn("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$");

        managerUserBl.registerUser(user);
        verify(userConfigRepository,times(0)).registerUser(user);
        verify(userConfigRepository,times(1)).emailRegExp();
    }

    @Test(expected = IllegalArgumentException.class)
    public void methodRegisterUserShouldReturnIllegalArgumentExceptionWhenPasswordIsIncorrect() {

        UserManager user = new UserManager("Lisbey", "Urrea", "lisbey@hotmail.com","3137189233","password", "lisbeyUrrea");
        String expect = "¡Usuario resgistrado exitosamente!";
        when(userConfigRepository.registerUser(user)).thenReturn(expect);
        when(userConfigRepository.emailRegExp()).thenReturn("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$");
        when(userConfigRepository.passwordRegExp()).thenReturn("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");

        managerUserBl.registerUser(user);
        verify(userConfigRepository,times(0)).registerUser(user);
        verify(userConfigRepository,times(1)).emailRegExp();
        verify(userConfigRepository,times(1)).passwordRegExp();

    }

    @Test(expected = IllegalArgumentException.class)
    public void methodRegisterUserShouldReturnIllegalArgumentExceptionWhenNickNameIsIncorrect() {

        UserManager user = new UserManager("Lisbey", "Urrea", "lisbey@hotmail.com","3137189233","w3Unpocodet0d0", "lisbey Urrea");
        String expect = "¡Usuario resgistrado exitosamente!";
        when(userConfigRepository.registerUser(user)).thenReturn(expect);
        when(userConfigRepository.emailRegExp()).thenReturn("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$");
        when(userConfigRepository.passwordRegExp()).thenReturn("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
        when(userConfigRepository.nickNameRegExp()).thenReturn("^[a-zA-Z]*$");

        managerUserBl.registerUser(user);
        verify(userConfigRepository,times(0)).registerUser(user);
        verify(userConfigRepository,times(1)).emailRegExp();
        verify(userConfigRepository,times(1)).passwordRegExp();
        verify(userConfigRepository,times(1)).nickNameRegExp();
    }

    @Test(expected = IllegalArgumentException.class)
    public void methodRegisterUserShouldReturnIllegalArgumentExceptionWhenMobileIsNotANumber() {

        UserManager user = new UserManager("Lisbey", "Urrea", "lisbey@hotmail.com","3137189233*","w3Unpocodet0d0", "lisbeyUrrea");
        String expect = "¡Usuario resgistrado exitosamente!";
        when(userConfigRepository.registerUser(user)).thenReturn(expect);
        when(userConfigRepository.emailRegExp()).thenReturn("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$");
        when(userConfigRepository.passwordRegExp()).thenReturn("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
        when(userConfigRepository.nickNameRegExp()).thenReturn("^[a-zA-Z]*$");

        managerUserBl.registerUser(user);
        verify(userConfigRepository,times(0)).registerUser(user);
        verify(userConfigRepository,times(1)).emailRegExp();
        verify(userConfigRepository,times(1)).passwordRegExp();
        verify(userConfigRepository,times(1)).nickNameRegExp();
    }

    @Test
    public void methodFindUsersShouldReturnAListOfUser() {
        List<UserManager> expect = new ArrayList<>();
        expect.add(new UserManager("Lisbey","Urrea","urlisbey@hotmail.com","3137189233","w3Unpocodet0d0","lisbeyUrrea"));
        expect.add(new UserManager("Pedro","perez","pedro@hotmail.com","3105897456","w3Unpocodet0d0","pedroPerez"));
        expect.add(new UserManager("Jian","Gallego","jian@gmail.com","3215889756","w3Unpocodet0d0","jianGallego"));

        when(userConfigRepository.findAll()).thenReturn(expect);

        List<UserManager> result = managerUserBl.findUsers();

        assertEquals(expect,result);
        verify(userConfigRepository,times(1)).findAll();
    }

    @Test
    public void methodFindUserByIdShouldReturnAUserWhenTheIdIs1() {
        UserManager expect = new UserManager("Lisbey","Urrea","urlisbey@hotmail.com","3137189233","w3Unpocodet0d0","lisbeyUrrea");
        when(userConfigRepository.findUser(1)).thenReturn(expect);

        UserManager result = managerUserBl.findUserById(1);

        assertEquals(expect,result);
        verify(userConfigRepository, times(1)).findUser(1);


    }

    @Test(expected = IllegalArgumentException.class)
    public void methodFindUserByIdShouldReturnIllegalArgumentExceptionWhenTheUserIsNoFound() {
        when(userConfigRepository.findUser(0)).thenReturn(null);

        managerUserBl.findUserById(1);

        verify(userConfigRepository, times(1)).findUser(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void methodFindUserByIdShouldReturnIllegalArgumentExceptionWhenTheIdIsNull() {
        when(userConfigRepository.findUser(null)).thenReturn(null);

        managerUserBl.findUserById(1);

        verify(userConfigRepository, times(1)).findUser(1);
    }
}