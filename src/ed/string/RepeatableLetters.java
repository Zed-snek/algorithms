package ed.string;

public class RepeatableLetters {

    private static boolean isLetter(char ch) {
        return ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122;
    }
    private static String removeLettersFromString(String s, char letter) {
        s = s.toLowerCase();
        StringBuilder newS = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != letter) {
                newS.append(s.charAt(i));
            }
        }
        return newS.toString();
    }
    private static boolean isRepeat(String s, char letter) {
        s = s.toLowerCase();
        int amount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter)
                amount ++;
        }
        return amount > 1;
    }

    public static void repeatableLetters(String s) {
        int maxRepeat = 0;
        String maxWord = "";
        int currentRepeat = 0;
        StringBuilder currentWord = new StringBuilder();
        String helpingString;

        for (int i = 0; i < s.length(); i++) {
            if (!isLetter(s.charAt(i)) || i == s.length() - 1) {
                helpingString = currentWord.toString().toLowerCase();
                for (int j = 0; j < currentWord.length(); j++) {
                    char letter = currentWord.toString().toLowerCase().charAt(j);
                    if (isRepeat(helpingString, letter)) {
                        currentRepeat++;
                    }
                    helpingString = removeLettersFromString(helpingString, letter);
                }
                if (currentRepeat > maxRepeat) {
                    maxRepeat = currentRepeat;
                    maxWord = currentWord.toString();
                }
                currentWord = new StringBuilder();
                currentRepeat = 0;
            }
            else {
                currentWord.append(s.charAt(i));
            }
        }
        System.out.println("Word with most repeatable letters: " + maxWord);

    }

}
