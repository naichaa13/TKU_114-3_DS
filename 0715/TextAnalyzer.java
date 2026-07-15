import java.util.Scanner;

public class TextAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = getValidInput(sc);

        showTextInfo(input);

        System.out.println("母音總數 (a, e, i, o, u)：" + countVowels(input));

        System.out.print("請輸入要搜尋的關鍵字：");
        String keyword = sc.nextLine();
        System.out.println("關鍵字出現次數：" + countKeyword(input, keyword));

        sc.close();
    }

    public static String getValidInput(Scanner sc) {
        String input;
        do {
            System.out.print("請輸入一行非空白文字：");
            input = sc.nextLine();
        } while (input.trim().isEmpty());
        return input;
    }

    public static void showTextInfo(String text) {
        System.out.println("原始字元數：" + text.length());
        System.out.println("有效字元數：" + text.trim().length());

        String[] words = text.trim().split("\\s+");
        System.out.println("單字數量：" + words.length);

        String longest = words[0];
        for (String w : words) {
            if (w.length() > longest.length()) {
                longest = w;
            }
        }
        System.out.println("最長單字：" + longest);
    }

    public static int countVowels(String text) {
        int count = 0;
        String lower = text.toLowerCase();
        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

    public static int countKeyword(String text, String keyword) {
        String[] words = text.trim().split("\\s+");
        int count = 0;
        for (String w : words) {
            if (w.equalsIgnoreCase(keyword.trim())) {
                count++;
            }
        }
        return count;
    }

    public static void printWordList(String text) {
        String[] words = text.trim().split("\\s+");
        System.out.print("單字清單：");
        for (String w : words) {
            System.out.print("[" + w + "] ");
        }
        System.out.println();
    }
}