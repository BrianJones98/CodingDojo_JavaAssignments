public class StringManipulatorTesting {
    public static void main(String[] args){
        StringManipulator manipulator = new StringManipulator();

        System.out.println(manipulator.trimAndConcat("   Hello   ", "   World   "));
        
        System.out.println(manipulator.getIndexOrNull("Just some sentence", 's'));
        System.out.println(manipulator.getIndexOrNull("Just some sentence", 'z'));

        System.out.println(manipulator.getIndexOrNull("Just some other sentence", "some"));
        System.out.println(manipulator.getIndexOrNull("Just some other sentence", "cheesecake"));

        System.out.println(manipulator.concatSubstring("First string", 0, 6, "and another string"));
    }
}