import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava{
    public ArrayList<Integer> sumAndReturn(int[] array){
        ArrayList<Integer> greaterThan10List = new ArrayList<Integer>();
        int sum = 0;

        for(int i = 0; i < array.length; i++){
            if(array[i] > 10){
                greaterThan10List.add(array[i]);
            }
            sum += array[i];
        }
        
        System.out.println("Sum: " + sum);

        return greaterThan10List;
    }
    public ArrayList<String> shuffleStrings(ArrayList<String> arrayList){
        Collections.shuffle(arrayList);

        System.out.println(arrayList.toString());
        
        ArrayList<String> longerThanFive = new ArrayList<String>();

        for(int i = 0; i < arrayList.size(); i++){
            if(arrayList.get(i).length() > 5){
                longerThanFive.add(arrayList.get(i));
            }
        }

        return longerThanFive;
    }
    public void shuffleChars(char[] charArr){
        ArrayList<Character> charList = new ArrayList<Character>();
        
        for(int i = 0; i < charArr.length; i++){
            charList.add(charArr[i]);
        }

        Collections.shuffle(charList);
        String checkVowelMessage;
        char lastValue = charList.get(charList.size() - 1);
        char firstValue = charList.get(0);

        if(firstValue == 'a' || firstValue == 'e' || firstValue == 'i' || firstValue == 'o' || firstValue == 'u'){
            checkVowelMessage = "First letter is a vowel";
        }
        else{
            checkVowelMessage = "First letter is not a vowel";
        }

        System.out.println("Last Letter: " + lastValue);
        System.out.println("First Letter: " + firstValue);
        System.out.println(checkVowelMessage);
    }
    public int[] randomArray(){
        int[] array = new int[10];
        Random rand = new Random();

        for(int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(45) + 55;
        }

        return array;
    }
    public ArrayList<Integer> randomSortedArray(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Random rand = new Random();

        for(int i = 0; i < 10; i++){
            arrayList.add(rand.nextInt(45) + 55);
        }

        int minimum = arrayList.get(0);
        int maximum = arrayList.get(0);

        for(int i = 0; i < arrayList.size(); i++){
            if(arrayList.get(i) < minimum){
                minimum = arrayList.get(i);
            }
            else if(arrayList.get(i) > maximum){
                maximum = arrayList.get(i);
            }
        }

        System.out.println("Minimum: " + minimum);
        System.out.println("Maximum: " + maximum);

        Collections.sort(arrayList);

        return arrayList;
    }
    public String randomString(){
        String stringAlphabet = "abcdefghijklmnopqrstuvwxyz";
        Random rand = new Random();
        String endString = "";

        for(int i = 0; i < 5; i++){
            endString += stringAlphabet.charAt(rand.nextInt(stringAlphabet.length()));
        }

        return endString;
    }
    public String[] randomStringArray(){
        String stringAlphabet = "abcdefghijklmnopqrstuvwxyz";
        Random rand = new Random();
        String[] endArray = new String[10];
        String temp = "";

        for(int i = 0; i < endArray.length; i++){
            for(int j = 0; j < 5; j++){
                temp += stringAlphabet.charAt(rand.nextInt(stringAlphabet.length()));
            }
            endArray[i] = temp;
            temp = "";
        }

        return endArray;
    }
}