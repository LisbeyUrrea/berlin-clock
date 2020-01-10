import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class DigitalClockTest {
    
    DigitalClock digitalClock;

    @Before
    public void setUp() throws Exception {
        digitalClock = new DigitalClock();
    }

    @Test
    public void methodConvertingBerlinTimeToDigitalTimeSouldReturn_00_00_00WhenParameterIsYOOOOOOOOOOOOOOOOOOOOOOO() {
        String time  = "YOOOOOOOOOOOOOOOOOOOOOOO";
        String expected = "00:00:00";

        String result = digitalClock.convertingBerlinTimeToDigitalTime(time);

        Assert.assertEquals(expected,result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void methodConvertingBerlinTimeToDigitalTimeReturnIllegalArgumentExceptionWhenParamDoNoHave24Characters() {
        String time = "YRRROROO";
        digitalClock.convertingBerlinTimeToDigitalTime(time);
    }

    @Test(expected = IllegalArgumentException.class)
    public void methodConvertingBerlinTimeToDigitalTimeReturnIllegalArgumentExceptionWhenParamIsNull() {
        String time = null;
        digitalClock.convertingBerlinTimeToDigitalTime(time);
    }

    @Test
    public void methodConvertingBerlinTimeToDigitalTimeSouldReturn23_59_59WhenParameterIsORRRRRRROYYRYYRYYRYYYYYY() {
        String time = "ORRRRRRROYYRYYRYYRYYYYYY";
        String expected = "23:59:59";

        String result = digitalClock.convertingBerlinTimeToDigitalTime(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodConvertingBerlinTimeToDigitalTimeSouldReturn16_50_00WhenParameterIsYRRROROOOYYRYYRYYRYOOOOO() {
        String time = "YRRROROOOYYRYYRYYRYOOOOO";
        String expected = "16:50:00";

        String result = digitalClock.convertingBerlinTimeToDigitalTime(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodConvertingBerlinTimeToDigitalTimeSouldReturn11_37_59WhenParameterIsORROOROOOYYRYYRYOOOOYYOO() {
        String time = "ORROOROOOYYRYYRYOOOOYYOO";
        String expected = "11:37:59";

        String result = digitalClock.convertingBerlinTimeToDigitalTime(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetSeconsSouldRetun00WhenTheParameterisYRRROROOOYYRYYRYYRYOOOOO() {

        String time = "YRRROROOOYYRYYRYYRYOOOOO";
        String expected = "00";

        String result = digitalClock.getSeconds(time);

        Assert.assertEquals(expected,result);

    }


    @Test
    public void methodGetSecondsShouldReturn59WhenTheParamIsORROOROOOYYRYYRYOOOOYYOO() {

        String time = "ORROOROOOYYRYYRYOOOOYYOO";
        String expected = "59";

        String result = digitalClock.getSeconds(time);

        Assert.assertEquals(expected,result);

    }

    @Test
    public void methodGetMinutesShouldReturn50WhenParamIsYRRROROOOYYRYYRYYRYOOOOO() {

        String time = "YRRROROOOYYRYYRYYRYOOOOO";
        String expected = "50";

        String result = digitalClock.getMinutes(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetMinutesShouldReturn37WhenParamIsORROOROOOYYRYYRYOOOOYYOO() {

        String time = "ORROOROOOYYRYYRYOOOOYYOO";
        String expected = "37";

        String result = digitalClock.getMinutes(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetHoursShouldReturn11WhenParamIsORROOROOOYYRYYRYOOOOYYOO() {

        String time = "ORROOROOOYYRYYRYOOOOYYOO";
        String expected = "11";

        String result = digitalClock.getHours(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetHoursShouldReturn16WhenParamIsYRRROROOOYYRYYRYYRYOOOOO() {

        String time = "YRRROROOOYYRYYRYYRYOOOOO";
        String expected = "16";

        String result = digitalClock.getHours(time);

        Assert.assertEquals(expected,result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void methodValidateTimeShouldReturnIllegalArgumentExceptionWhenParameterDoNoHave24Characters() {
        String time = "YRRROROOOYYRYYRYYRYOOOOO--OOO";
        digitalClock.validateTime(time);
    }

    @Test(expected = IllegalArgumentException.class)
    public void methodValidateTimeShouldReturnIllegalArgumentExceptionWhenParameterIsNull() {
        String time = null;
        digitalClock.validateTime(time);
    }
}