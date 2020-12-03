import java.util.Arrays;

public class BasicJavaTest {
    public static void main(String[] args){
        BasicJava test = new BasicJava();
        
        System.out.println("\n1-255:");
        test.oneTo255();
        
        System.out.println("\nOdd 1-255:");
        test.printOdds();

        System.out.println("\nPrint sum:");
        test.printSum();

        System.out.println("\nIterate array:");
        int[] array = {1, 2, 3, 4, 5};
        test.iterateArray(array);

        System.out.println("\nFind Max:");
        int[] array2 = {3, 56, 2, -1, 35, -38};
        int[] array3 = {-56, -5, -1, -24, -3};
        System.out.println(test.findMax(array));
        System.out.println(test.findMax(array2));
        System.out.println(test.findMax(array3));

        System.out.println("\nFind Average:");
        System.out.println(test.findAverage(array2));

        System.out.println("\nArray with Odd Numbers:");
        System.out.println(Arrays.toString(test.oddArray()));

        System.out.println("\nGreater than Y:");
        System.out.println(test.greaterThanY(array2, 6));

        System.out.println("\nSquare the Values:");
        System.out.println(Arrays.toString(test.squareValues(array3)));

        System.out.println("\nEliminate Negative Numbers:");
        System.out.println(Arrays.toString(test.eliminateNegatives(array2)));

        int[] array4 = {2, 5, 3, 664, 33, -25};
        System.out.println("\nMax, Min, and Average:");
        System.out.println(Arrays.toString(test.minMaxAvg(array4)));

        System.out.println("\nShift Values in Array:");
        System.out.println(Arrays.toString(test.shiftValues(array4)));
    }
}