import java.util.*;

public class Words {
    public static void main(String[] args) {
        System.out.print("Please enter a string: ");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        if (string == null || string.isEmpty()) {
            System.out.print("The number of words in your string is 0.");
        }else{
            String[] words = string.split("\\s+");
            System.out.print("The number of words in your string is " + words.length);
        }
    }
}