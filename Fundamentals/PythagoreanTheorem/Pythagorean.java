import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Pythagorean{
    public double calculateHypotenuse(int legA, int legB){
        double Hypotenuse;
        Hypotenuse = sqrt(pow(legA, 2) + pow(legB, 2));

        return Hypotenuse;
    }
}