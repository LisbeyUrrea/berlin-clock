
import static jdk.nashorn.internal.objects.Global.Infinity;
import static jdk.nashorn.internal.objects.Global.NaN;

public class Calculator {


    public int sum(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public int subtraction(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    public int multiplication(int multiplying, int multiplier) {
        return multiplying * multiplier;
    }

    public double division(int dividend, int divider) {
        double result = 0;
        try {

            result =  dividend / divider;

        }catch (ArithmeticException e ){
            throw new ArithmeticException("Error: No se puede dividir entre cero");
        }

        return (double)  dividend / divider;

    }
}
