import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BerlinClockTest {

   private BerlinClock berlinClock;

    @Before
    public void beforeClass() throws Exception {
        berlinClock = new BerlinClock();
    }



    @Test
    public void methodGetSingleMinutesBottomShouldReturnOOOOWhenParamIs00_00_00() {
        String time = "00:00:00";
        String expected = "OOOO";

        String result = berlinClock.getSingleMinutesBottom(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetSingleMinutesBottomShouldReturnYYYYWhenParamIs23_59_59() {
        String date = "23:59:59";
        String expected = "YYYY";

        String result = berlinClock.getSingleMinutesBottom(date);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetSingleMinutesBottomShouldReturnYYOOWhenParamIs12_32_00() {
        String date = "12:32:00";
        String expected = "YYOO";

        String result = berlinClock.getSingleMinutesBottom(date);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetSingleMinutesBottomShouldReturnYYYYWhenParamIs12_34_00() {
        String date = "12:34:00";
        String expected = "YYYY";

        String result = berlinClock.getSingleMinutesBottom(date);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetSingleMinutesBottomShouldReturnOOOOWhenParamIs12_35_00() {
        String date = "12:35:00";
        String expected = "OOOO";

        String result = berlinClock.getSingleMinutesBottom(date);

        Assert.assertEquals(expected,result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void methodValidateTimeShouldReturnIllegalArgumentExceptionWhenParamsArenull() {
        String time = null;
        berlinClock.validateTime(time);
    }

    @Test(expected = IllegalArgumentException.class)
    public void methodValidateDateShouldReturnIllegalArgumentExceptionWhenParamHaveMoreThanHoursMinutesAndSeconds() {
        String time = "00:00:00:00";
        berlinClock.validateTime(time);
    }

    @Test(expected = IllegalArgumentException.class)
    public void methodGetSingleMinutesBottomShouldReturnIllegalArgumentExceptionWhenParamIsAInvalidDate12_gg_00() {
        String time = "12:gg:00";
        berlinClock.getSingleMinutesBottom(time);
    }

    @Test(expected = IllegalArgumentException.class)
    public void methodGetSingleMinutesBottomShouldReturnIllegalArgumentExceptionWhenParamIsAInvalidDate12_00_ww() {
        String time = "12:00:ww";
        berlinClock.getSingleMinutesBottom(time);
    }

    @Test
    public void methodGetFiveMinutesTopShouldReturnOOOOOOOOOOOWhenParamIs00_00_00() {
        String date = "00:00:00";
        String expected = "OOOOOOOOOOO";

        String result = berlinClock.getFiveMinutesTop(date);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetFiveMinutesTopShouldReturnYYRYYRYYRYYWhenParamIs23_59_59() {
        String date = "23:59:59";
        String expected = "YYRYYRYYRYY";

        String result = berlinClock.getFiveMinutesTop(date);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodIsNumberMultipleOf3ShouldReturnTrueWhenParamIs6() {
        int param = 6;
        boolean expected = true;
        boolean result = berlinClock.isNumberMultipleOf3(param);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetFiveMinutesTopShouldReturnOOOOOOOOOOOWhenParamIs12_04_00() {
        String time = "12:04:00";
        String expected = "OOOOOOOOOOO";

        String result = berlinClock.getFiveMinutesTop(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetFiveMinutesTopShouldReturnYYRYOOOOOOOWhenParamIs12_23_00() {
        String time = "12:23:00";
        String expected = "YYRYOOOOOOO";

        String result = berlinClock.getFiveMinutesTop(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetFiveMinutesTopShouldReturnYYRYYRYOOOOWhenParamIs12_35_00() {
        String time = "12:35:00";
        String expected = "YYRYYRYOOOO";

        String result = berlinClock.getFiveMinutesTop(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetSingleHoursBottomSholdReturnOOOOWhenParameterIs00_00_00() {
        String time = "00:00:00";
        String expected = "OOOO";

        String result = berlinClock.getSingleHoursBottom(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetSingleHoursBottomShouldReturnRRROWhenParameterIs23_59_59() {
        String time = "23:59:59";
        String expected = "RRRO";

        String result = berlinClock.getSingleHoursBottom(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetSingleHoursBottomShouldReturnRROOWhenParameterIs02_04_00() {
        String time = "02:04:00";
        String expected = "RROO";

        String result = berlinClock.getSingleHoursBottom(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetSingleHoursBottomShouldReturnRRROWhenParameterIs08_23_00() {
        String time = "08:23:00";
        String expected = "RRRO";

        String result = berlinClock.getSingleHoursBottom(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetSingleHoursBottomShouldReturnRRRRWhenParameterIs14_35_00() {
        String time = "14:35:00";
        String expected = "RRRR";

        String result = berlinClock.getSingleHoursBottom(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetFiveHoursTopShouldReturnOOOOWhenParameterIs00_00_00() {
        String time = "00:00:00";
        String expected = "OOOO";

        String result = berlinClock.getFiveHoursTop(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetFiveHoursTopShouldReturnRRRRWhenParameterIs23_59_59() {
        String time = "23:59:59";
        String expected = "RRRR";

        String result = berlinClock.getFiveHoursTop(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetFiveHoursTopShouldReturnOOOOWhenParameterIs02_04_00() {
        String time = "02:04:00";
        String expected = "OOOO";

        String result = berlinClock.getFiveHoursTop(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetFiveHoursTopShouldReturnROOOWhenParameterIs08_23_00() {
        String time = "08:23:00";
        String expected = "ROOO";

        String result = berlinClock.getFiveHoursTop(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetFiveHoursTopShouldReturnRRROWhenParameterIs16_35_00() {
        String time = "16:35:00";
        String expected = "RRRO";

        String result = berlinClock.getFiveHoursTop(time);
        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetSecondsShouldReturnYWhenParameterIs00_00_00() {

        String time = "00:00:00";
        String expected = "Y";

        String result = berlinClock.getSeconds(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodGetSecondsShouldReturnOWhenParameterIs23_59_59() {

        String time = "23:59:59";
        String expected = "O";

        String result = berlinClock.getSeconds(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodBerlinClockShouldReturnYOOOOOOOOOOOOOOOOOOOOOOOWhenParameterIs00_00_00() {

        String time = "00:00:00";
        String expected = "YOOOOOOOOOOOOOOOOOOOOOOO";

        String result = berlinClock.berlinClock(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodBerlinClockShouldReturnORRRRRRROYYRYYRYYRYYYYYYWhenParameterIs23_59_59() {

        String time = "23:59:59";
        String expected = "ORRRRRRROYYRYYRYYRYYYYYY";

        String result = berlinClock.berlinClock(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodBerlinClockShouldReturnYRRROROOOYYRYYRYYRYOOOOOWhenParameterIs16_50_06() {

        String time = "16:50:06";
        String expected = "YRRROROOOYYRYYRYYRYOOOOO";

        String result = berlinClock.berlinClock(time);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodBerlinClockShouldReturnORROOROOOYYRYYRYOOOOYYOOWhenParameterIs11_37_01() {

        String time = "11:37:01";
        String expected = "ORROOROOOYYRYYRYOOOOYYOO";

        String result = berlinClock.berlinClock(time);

        Assert.assertEquals(expected,result);
    }
}