public class DigitalClock {
    public static final String NO_TIME_ERROR = "La fecha no debe ser nula";
    public static final String INVALID_TIME_ERROR = "El formato de la hora del reloj de Berlin debe tener 24 caracteres";
    public static final String TWO_POINTS = ":";
    public static final int MAXIMUM_OF_MINUTES = 55;
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int FIVE = 5;
    public static final int NINE = 9;
    public static final int TWENTY = 20;
    public static final int TWENTY_FOUR = 24;


    public String convertingBerlinTimeToDigitalTime(String time) {

        if (!validateTime(time))  throw new IllegalArgumentException(NO_TIME_ERROR);


    return (getHours(time)+TWO_POINTS+getMinutes(time)+TWO_POINTS+getSeconds(time));

    }


    public String getSeconds(String time) {
        return time.substring(ZERO,ONE).equals("Y") ? "00" : "59";
    }

    public String getMinutes(String time) {

        String fiveMinutesTop = time.substring(NINE,TWENTY);
        String singleMinutesBottom = time.substring(TWENTY,TWENTY_FOUR);

        int minutesTop = MAXIMUM_OF_MINUTES - getCantOfRepeated(fiveMinutesTop, "O") * FIVE;
        int minutesBottom = getCantOfRepeated(singleMinutesBottom, "Y");
        int TotalMinutes = ( minutesTop+ minutesBottom) ;
        return TotalMinutes > 9 ? String.valueOf(TotalMinutes) : "0"+TotalMinutes;
    }

    public String getHours(String time) {
        String fiveHourTop = time.substring(ONE,FIVE);
        String singleHourBottom =time.substring(FIVE,NINE);
        int totalHours = (getCantOfRepeated(fiveHourTop, "R") * FIVE) + (getCantOfRepeated(singleHourBottom, "R")) ;
        return totalHours > NINE ? String.valueOf(totalHours) : "0"+totalHours;
    }

    private int getCantOfRepeated(String stringToSearch, String valueToFind) {
        int counter = 0;

        while (stringToSearch.indexOf(valueToFind) > -1) {
            stringToSearch = stringToSearch.substring(stringToSearch.indexOf( valueToFind)+ valueToFind.length(),stringToSearch.length());
            counter++;
        }

        return counter;
    }


    public boolean validateTime(String time) {

        if(time == null) throw new IllegalArgumentException(NO_TIME_ERROR);

        int size = time.length();
        if(size != 24){
            throw new IllegalArgumentException(INVALID_TIME_ERROR);
        }

        return true;

    }
}
