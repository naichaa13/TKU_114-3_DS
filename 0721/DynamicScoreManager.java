import java.util.ArrayList;
import java.util.Scanner;

public class DynamicScoreManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();

        System.out.println("請輸入成績（輸入 -1 結束）：");
        while (true) {
            System.out.print("輸入成績: ");
            int input = sc.nextInt();

            if (input == -1) {
                break;
            }

            if (input >= 0 && input <= 100) {
                scores.add(input);
            } else {
                System.out.println("錯誤：成績必須介於 0 到 100 之間，請重新輸入。");
            }
        }
        sc.close();

        if (scores.isEmpty()) {
            System.out.println("\n未輸入任何有效成績。");
            return;
        }

        System.out.println("\n--- 成績統計結果 ---");
        System.out.println("總筆數：" + scores.size());
        System.out.printf("平均分數：%.2f%n", calculateAverage(scores));
        System.out.println("最高分：" + findMax(scores));
        System.out.println("最低分：" + findMin(scores));

        ArrayList<Integer> passedScores = filterPassingScores(scores, 60);
        System.out.println("及格名單（>= 60）：" + passedScores);
    }

    public static double calculateAverage(ArrayList<Integer> values) {
        int total = 0;
        for (int score : values) {
            total += score;
        }
        return (double) total / values.size();
    }

    public static int findMax(ArrayList<Integer> values) {
        int max = values.get(0);
        for (int score : values) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    public static int findMin(ArrayList<Integer> values) {
        int min = values.get(0);
        for (int score : values) {
            if (score < min) {
                min = score;
            }
        }
        return min;
    }

    public static ArrayList<Integer> filterPassingScores(ArrayList<Integer> values, int threshold) {
        ArrayList<Integer> passed = new ArrayList<>();
        for (int score : values) {
            if (score >= threshold) {
                passed.add(score);
            }
        }
        return passed;
    }
}