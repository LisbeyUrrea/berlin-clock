

public class BerlinClock {
    public static final String NO_TIME_ERROR = "No se a enviado una fecha";
    public static final String INVALID_TIME_ERROR = "Fecha invalida";
    public static final String TWO_POINTS = ":";
    public static final Character Y_TYPE = 'Y';
    public static final Character R_TYPE = 'R';
    public static final Character O_TYPE = 'O';
    public static final int NUMBER_FIVE = 5;
    public static final int POSITION_ONE = 0;
    public static final int POSITION_TWO = 1;
    public static final int POSITION_THREE = 2;
    public static final int ZERO = 0;
    public static final int TWO = 2;
    public static final int THREE = 3;

    public String getSingleMinutesBottom(String time) {
        int minutes =   validateTime(time)[POSITION_TWO];
        int timesToChange = minutes % NUMBER_FIVE;
        return  replaceCharactersOnStringANumberOfTimes(new StringBuilder("OOOO"), Y_TYPE,timesToChange);
    }

    public int[] validateTime(String time) {

        if(time == null) throw new IllegalArgumentException(NO_TIME_ERROR);

        String[] timeArray = time.split(TWO_POINTS);

        if(timeArray.length != THREE ) throw new IllegalArgumentException(INVALID_TIME_ERROR);

        int[] newTimeArray = new int[THREE];

        for (int i = ZERO; i < timeArray.length; i++){
            newTimeArray[i] = Integer.parseInt(timeArray[i]);
        }

        return newTimeArray;
    }

    public String replaceCharactersOnStringANumberOfTimes(StringBuilder stringToChange, Character character, int timesToRepeat){

        for(int i = 0; i < timesToRepeat; i++){
            stringToChange.setCharAt(i,character);
        }

        return  stringToChange.toString();
    }

    public String getFiveMinutesTop(String time) {
        int timesToChange =   (validateTime(time)[POSITION_TWO]) / NUMBER_FIVE;
        StringBuilder stringToChange = new StringBuilder("OOOOOOOOOOO");

        for(int i = ZERO; i < timesToChange; i++){
            if(isNumberMultipleOf3(i+1)){
                stringToChange.setCharAt(i,R_TYPE);
            }else{
                stringToChange.setCharAt(i,Y_TYPE);
            }
        }
        return  stringToChange.toString();
    }

    public boolean isNumberMultipleOf3(int number){
        return (number % THREE == ZERO);
    }

    public String getSingleHoursBottom(String param) {
        int minutes =   validateTime(param)[POSITION_ONE];
        int timesToChange = minutes % NUMBER_FIVE;

        return  replaceCharactersOnStringANumberOfTimes(new StringBuilder("OOOO"), R_TYPE,timesToChange);
    }

    public String getFiveHoursTop(String hour) {
        int minutes =   validateTime(hour)[POSITION_ONE];
        int timesToChange = minutes / NUMBER_FIVE;
        return  replaceCharactersOnStringANumberOfTimes(new StringBuilder("OOOO"), R_TYPE,timesToChange);
    }

    public String getSeconds(String hour) {
        int minutes =   validateTime(hour)[POSITION_THREE];
        return isEvenNumber(minutes) ? Y_TYPE.toString(): O_TYPE.toString();
    }

    public boolean isEvenNumber(int number){
        return (number % TWO == ZERO);
    }

    public String berlinClock(String time) {

        return getSeconds(time)
                .concat(getFiveHoursTop(time))
                .concat(getSingleHoursBottom(time))
                .concat(getFiveMinutesTop(time))
                .concat(getSingleMinutesBottom(time));
    }
}


