import java.util.*;

public class Consonants {
    public static void main(String[] args) {
        System.out.print("Please enter a sentence: ");
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        String result = sentence;
        int counter = 0;
        for (int i = 0 ; i < sentence.length(); i++){
            char letter = sentence.charAt(i);
            char ch = Character.toUpperCase(letter);
            if(!(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') && ch >= 65 && ch <= 90){
                counter++;
                result = result.replace(letter,'*');
            }
        }
        System.out.println("The number of consonants in your sentence is " + counter);
        System.out.println("The modified sentence should be " + result);
    }
}