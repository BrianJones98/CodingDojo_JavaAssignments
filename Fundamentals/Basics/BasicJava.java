import java.util.ArrayList;

public class BasicJava{
    public void oneTo255(){
        for(int i = 1; i <= 255; i++){
            System.out.print(i + " ");
        }
    }
    public void printOdds(){
        for(int i = 1; i <= 255; i+=2){
            System.out.print(i + " ");
        }
    }
    public void printSum(){
        int sum = 0;
        for(int i = 1; i <= 255; i++){
            sum += i;
            System.out.println("New number: " + i + " Sum: " + sum);
        }
    }
    public void iterateArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public Integer findMax(int[] arr){
        int maximum = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > maximum){
                maximum = arr[i];
            }
        }
        
        return maximum;
    }
    public Double findAverage(int[] arr){
        double avg;
        double sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }

        avg = sum/arr.length;

        return avg;
    }
    public int[] oddArray(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int i = 1; i <= 255; i+=2){
            arrayList.add(i);
        }

        int[] returnedArray;
        returnedArray = new int[arrayList.size()];
        
        for(int i = 0; i < arrayList.size(); i++){
            returnedArray[i] = arrayList.get(i);
        }

        return returnedArray;
    }
    public Integer greaterThanY(int[] arr, int value){
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > value){
                count += 1;
            }
        }

        return count;
    }
    public int[] squareValues(int[] arr){
        for(int i = 0; i < arr.length; i++){
            arr[i] *= arr[i];
        }

        return arr;
    }
    public int[] eliminateNegatives(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0){
                arr[i] = 0;
            }
        }

        return arr;
    }
    public int[] minMaxAvg(int[] arr){
        int sum = 0;
        int minimum = arr[0];
        int maximum = arr[0];
        
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(arr[i] < minimum){
                minimum = arr[i];
            }
            else if(arr[i] > maximum){
                maximum = arr[i];
            }
        }
        int average = sum/arr.length;
        int[] finalValues = {maximum, minimum, average};

        return finalValues;
    }

    public int[] shiftValues(int[] arr){
        int temp = arr[1];
        for(int i = 0; i < arr.length; i++){
            if(i < arr.length - 2){
                arr[i] = temp;
                temp = arr[i + 2];
            }
            else{
                arr[i] = arr[i + 1];
                arr[i + 1] = 0;
                i = arr.length;
            }
        }

        return arr;
    }
}