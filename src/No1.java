import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No1 {
    public static void main(String[] args) {
        // input 'Sample Case'
        // output
        /*
         * Vowel Characters:
         * aaee
         *
         * Consonant Characters:
         * ssmplc
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input one line of words (S) : ");
        String input = scanner.nextLine();
        String procVowels = procVowels(input);
        String procConsonants = procConsonants(input);

        System.out.println("Vowel Characters : ");
        System.out.println(procVowels);
        System.out.println("Consonants Characters : ");
        System.out.println(procConsonants);

    }

    public static String procVowels(String input) {
        char[] inputArray = stringToCharArr(input);
        List<Character> vowelChars = List.of('a', 'i', 'u', 'e', 'o');

        StringBuilder sb = new StringBuilder();
        List<Character> inputVowels = new ArrayList<>();

        for (char c : inputArray) {
            if (vowelChars.contains(c)) {
                // ngecek index terakhirnya di list hasil filter (inputVowels)
                int firstAppearIndex = inputVowels.indexOf(c);
                // jika character belum ada di list maka indexnya bernilai -1, di add saja. s
                if (firstAppearIndex == -1) {
                    inputVowels.add(c);
                } else {
                    // jika sudah ada atau firstAppearIndex != -1 maka ditambahin di sebelah index kemunculan terakhirnya
                    inputVowels.add(firstAppearIndex + 1, c);
                }
            }
        }

        for (Character c : inputVowels) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static String procConsonants(String input) {

        char[] inputArray = stringToCharArr(input);
        List<Character> consonantChars = List.of('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k',
                'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z');

        StringBuilder sb = new StringBuilder();
        List<Character> inputConsonants = new ArrayList<>();

        for (char c : inputArray) {
            if (consonantChars.contains(c)) {
                // ngecek index terakhirnya di list hasil filter (inputConsonants)
                int appearanceIndex = inputConsonants.indexOf(c);
                // jika character belum ada di list maka indexnya bernilai -1, di add saja. s
                if (appearanceIndex == -1) {
                    inputConsonants.add(c);
                } else {
                    // jika sudah ada atau != -1 maka ditambahin di sebelah index kemunculan terakhirnya
                    inputConsonants.add(appearanceIndex + 1, c);
                }
            }
        }

        for (Character c : inputConsonants) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static char[] stringToCharArr(String input) {
        String inputToLower = input.toLowerCase().replaceAll("\\s+", "");
        return inputToLower.toCharArray();
    }
}