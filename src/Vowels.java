import java.util.*;

public class Vowels {
    public static void main(String[] args) {
        System.out.print("Please enter a sentence: ");
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        int counter = 0;
        for (int i = 0 ; i < sentence.length(); i++){
            char letter = sentence.charAt(i);
            char ch = Character.toUpperCase(letter);
            if(ch == 'A'|| ch == 'E'|| ch == 'I' || ch == 'O' || ch == 'U'){
                counter++;
            }
        }
        System.out.println("The number of vowels in your sentence is "+ counter );
    }
}
