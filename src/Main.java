import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {


    public static void main(String[] args) {
        char[] charsOfText = text.toLowerCase().toCharArray();
        Map<Character, Integer> symbol = new HashMap<>();

        countingSymbols(charsOfText, symbol);

        System.out.println("Больше всего встречается символ:");
        Integer maxMin = getMax(symbol);
        printValue(symbol, maxMin);

        System.out.println("Меньше всего встречается символ:");
        maxMin = getMin(symbol);
        printValue(symbol, maxMin);

        WordsChecker textSeparation = new WordsChecker(text);
        System.out.println("Есть ли в тексте слово \"aute\"? " + textSeparation.hasWord("aute"));
        System.out.println("Есть ли в тексте слово \"ide\"? " + textSeparation.hasWord("ide"));
    }

    private static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
            "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
            "laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate " +
            "velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt " +
            "in culpa qui officia deserunt mollit anim id est laborum. W";

    private static void countingSymbols(char[] charsOfText, Map<Character, Integer> symbol) {
        for (int i = 0; i < charsOfText.length; i++) {
            if (Character.isLetter(charsOfText[i])) {
                Integer count = symbol.get(charsOfText[i]);
                if (count == null) {
                    symbol.put(charsOfText[i], 1);
                } else {
                    symbol.put(charsOfText[i], ++count);
                }
            }
        }
    }

    private static Integer getMin(Map<Character, Integer> symbol) {
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> s : symbol.entrySet()) {
            if (min > s.getValue()) {
                min = s.getValue();
            }
        }
        return min;
    }

    private static Integer getMax(Map<Character, Integer> symbol) {
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> s : symbol.entrySet()) {
            if (s.getValue() > max) {
                max = s.getValue();
            }
        }
        return max;
    }

    private static void printValue(Map<Character, Integer> symbol, Integer maxMin) {
        for (Map.Entry<Character, Integer> s : symbol.entrySet()) {
            if (Objects.equals(s.getValue(), maxMin)) {
                System.out.println(s.getKey() + " - " + s.getValue() + " шт.");
            }
        }
    }
}
