import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class DigitalClockTestWithParams {

    DigitalClock digitalClock;

    @Before
    public void setUp() throws Exception {
        digitalClock = new DigitalClock();
    }

    @Test
    @Parameters({
            "YOOOOOOOOOOOOOOOOOOOOOOO, 00:00:00",
            "ORRRRRRROYYRYYRYYRYYYYYY, 23:59:59",
            "YRRROROOOYYRYYRYYRYOOOOO, 16:50:00",
            "ORROOROOOYYRYYRYOOOOYYOO, 11:37:59"
    })
    public void methodConvertingBerlinTimeToDigitalTimeShouldReturnAnHourWhenParameterIsBerlinHour(String time, String expected) {
        String result = digitalClock.convertingBerlinTimeToDigitalTime(time);
        Assert.assertEquals(expected,result);
    }
}
