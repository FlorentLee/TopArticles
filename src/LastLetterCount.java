import java.util.*;

public class LastLetterCount {
    public static void main(String[] args) {
        System.out.print("Please enter a sentence: ");
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        int counter = 0;
        int len = sentence.length();

        for (int i = 0 ; i < len; i++){
            char letter = sentence.charAt(i);
            if(letter == 's' || letter == 'y'){
                if (i < len - 1 && !Character.isLetter(sentence.charAt(i+1)))
                    counter++;
                else if (i == len-1)
                    counter++;
            }
        }
        System.out.println("The number of words that ends in 's' or 'y' is " + counter);

        String[] words = sentence.split("[^a-zA-Z0-9']+", 0);
        String result = sentence;
        boolean flag_s = true;
        boolean flag_y = true;
        String temp_s = "";
        String temp_y = "";

        for (String word : words){
            if (word.endsWith("s") && flag_s){
                temp_s = word;
                flag_s = false;
                result = result.replaceFirst(temp_s,"###sss!!!");
            }
            if (word.endsWith("y") && flag_y){
                temp_y = word;
                flag_y = false;
                result = result.replaceFirst(temp_y,"###yyy!!!");
            }
        }
        result = result.replace("###sss!!!",temp_y);
        result = result.replace("###yyy!!!",temp_s);

        System.out.println("The modified sentence should be " + result);
    }
}