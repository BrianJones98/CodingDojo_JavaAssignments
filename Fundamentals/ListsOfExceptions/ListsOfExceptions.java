import java.util.ArrayList;

public class ListsOfExceptions{
    public static void main(String[] args){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for(int i = 0; i < myList.size(); i++){
            try{
                Integer castedValue = (Integer) myList.get(i);
                System.out.println(castedValue);
            } catch(ClassCastException exception){
                System.out.println("Exception at index: " + i + " with value: " + myList.get(i));
                System.out.println("Exception type: " + exception + "\n");
            }
        }
    }
}