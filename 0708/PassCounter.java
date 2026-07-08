public class PassCounter {
    public static void main(String[] args) {
        int score1 = 80;
        int score2 = 55;
        int score3 = 70;

        int count = 0;

        if (score1 >= 60) {
            count++;
        }

        if (score2 >= 60) {
            count++;
        }

        if (score3 >= 60) {
            count++;
        }

        // 輸出結果
        System.out.println("Pass count: " + count);
    }
}