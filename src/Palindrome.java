import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        System.out.print("Please enter a string: ");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        StringBuilder buffer = new StringBuilder(string);
        String result = buffer.reverse().toString();
        if(string.equals(result)){
            System.out.println("Your String is a palindrome.");
        }else{
            System.out.println("Your String is not a palindrome.");
        }
    }
}