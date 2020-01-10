package mocks;

import javafx.beans.binding.When;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
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
}