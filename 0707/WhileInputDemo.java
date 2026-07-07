import java.util.Scanner;

public class WhileInputDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入數字：");

        while (true) {
            int input = sc.nextInt();
            if (input == 0) {
                System.out.println("輸入了 0，程式結束。");
                break;
            }
            System.out.println(input);
        }
        sc.close();
    }
}