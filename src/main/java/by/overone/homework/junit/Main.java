package by.overone.homework.junit;

public class Main {
    public int amountWordsInLine(String str) {
        int amount = 0;
        for (char ch : str.toCharArray()) {
            if (ch == ' ') {
                amount++;
            }
        }
        return ++amount;
    }

    public String editLine(String str) {
        str = str.trim();
        StringBuilder newStr = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch == 'a') {
                ch = '%';
            }
            newStr.append(ch);
        }
        return newStr.toString();
    }

    public boolean lineIsEmpty(String str) {
        return str.isEmpty();
    }

    public String lineWithoutFirstAndLastWords(String str) {
        str = str.trim();
        if (amountWordsInLine(str) < 2) {
            return "";
        }
        String[] ar = str.split(" ");
        String newStr = "";
        for (int i = 1; i < ar.length - 1; i++) {
            newStr += ar[i];
            if (i != ar.length - 2){
                newStr += " ";
            }
        }
        return newStr;
    }
}
