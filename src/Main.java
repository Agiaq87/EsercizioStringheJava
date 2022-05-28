import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] argc) {
        Scanner reader = new Scanner(System.in);
        String readed = "";

        Map<Character, Integer> vowels = new HashMap<>();

        do {
            System.out.println("Inserire ora una frase da 300 caratteri:");
            readed = reader.nextLine();
        }while(readed.length() <= 20);

        vowels.put('a', alphabeticCounter(readed, 'a'));
        vowels.put('e', alphabeticCounter(readed, 'e'));
        vowels.put('i', alphabeticCounter(readed, 'i'));
        vowels.put('o', alphabeticCounter(readed, 'o'));
        vowels.put('u', alphabeticCounter(readed, 'u'));

        System.out.println(readed);
        System.out.println(revert(readed));
        System.out.println(revertCamelCase(readed));
        System.out.println(toUpperFinal(readed));
        System.out.println(toUpperMiddle(readed));
        System.out.println("Num of blank: " + numOfBlank(readed));
        System.out.println("Num of non alphanumeric: " + numOfNonAlphaNumeric(readed));
        System.out.println("Num of a:" + vowels.get('a'));
        System.out.println("Num of e:" + vowels.get('e'));
        System.out.println("Num of i:" + vowels.get('i'));
        System.out.println("Num of o:" + vowels.get('o'));
        System.out.println("Num of u:" + vowels.get('u'));
    }

    public static String revert(String value) {
        StringBuilder b = new StringBuilder();

        for(int i = value.length()-1; i >= 0; i--) {
            b.append(value.charAt(i));
        }

        return b.toString();
    }

    public static String revertCamelCase(String value) {
        StringBuilder b = new StringBuilder();
        String[] split = value.split(" ");

        for (String s: split) {
            b.append(s.substring(0, 1).toUpperCase()).append(s.substring(1)).append(" ");
        }

        return b.toString();
    }

    public static String toUpperFinal(String value) {
        StringBuilder b = new StringBuilder();
        String[] split = value.split(" ");

        for (String s: split) {
            if (s.length() >= 2) {
                b.append(s, 0, s.length() - 1).append(s.substring(s.length() - 1).toUpperCase()).append(" ");
            } else {
                b.append(s.toUpperCase()).append(" ");
            }

        }

        return b.toString();
    }

    public static String toUpperMiddle(String value) {
        StringBuilder b = new StringBuilder();
        String[] split = value.split(" ");
        int hold = 0;

        for (String s: split) {
            if (s.length() > 2) {
                hold = s.length()/2;
                if (s.length() % 2 != 0) {
                    hold += 1;
                    b.append(s, 0, hold - 1)
                            .append(Character.toUpperCase(s.charAt(hold-1)))
                            .append(s, hold, s.length()).append(" ");
                } else {
                    b.append(s, 0, hold - 1)
                            .append(s.substring(hold - 1, hold + 1).toUpperCase())
                            .append(s.substring(hold + 1)).append(" ");
                }
            } else {
                b.append(s).append(" ");
            }

        }

        return b.toString();
    }

    public static int numOfBlank(String value) {
        int counted = 0;

        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == ' ') {
                counted += 1;
            }
        }

        return counted;
    }

    public static int numOfNonAlphaNumeric(String value) {
        int counted = 0;

        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (
                    !Character.isAlphabetic(c) &&
                            !Character.isDigit(c) &&
                            c != ' '
            ) {
                counted += 1;
            }
        }

        return counted;
    }

    public static int alphabeticCounter(String s, char vowelOrConsonant) {
        int counted =  0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == vowelOrConsonant) {
                counted += 1;
            }
        }

        return counted;
    }
}

