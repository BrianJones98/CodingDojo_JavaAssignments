import java.util.ArrayList;
import java.util.Arrays;

public class PuzzleJavaTest {
    public static void main(String[] args){
        int[] arr = {3, 5, 1, 2, 7, 9, 8, 13, 25, 32};
        ArrayList<String> strList = new ArrayList<String>();
        strList.add("Nancy");
        strList.add("Jinichi");
        strList.add("Fujibayashi");
        strList.add("Momochi");
        strList.add("Ishikawa");
        PuzzleJava test = new PuzzleJava();
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        System.out.println(test.sumAndReturn(arr).toString());
        ArrayList<String> strListGreaterThan10 = test.shuffleStrings(strList);
        System.out.println(strListGreaterThan10.toString());

        test.shuffleChars(alphabet);

        System.out.println(Arrays.toString(test.randomArray()));
        System.out.println(test.randomSortedArray().toString());
        System.out.println(test.randomString());
        System.out.println(Arrays.toString(test.randomStringArray()));
    }
}