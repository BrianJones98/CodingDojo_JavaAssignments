public class FizzBuzzTester {
    public static void main(String[] args){
        FizzBuzz tester = new FizzBuzz();
        
        String five = tester.fizzBuzz(5);
        String three = tester.fizzBuzz(3);
        String fifteen = tester.fizzBuzz(15);
        String two = tester.fizzBuzz(2);
        
        System.out.println(three);
        System.out.println(five);
        System.out.println(fifteen);
        System.out.println(two);
    }
}