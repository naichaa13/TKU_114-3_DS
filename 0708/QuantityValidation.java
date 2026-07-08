import java.util.Scanner;

public class QuantityValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入商品數量（>0): ");
        int quantity = sc.nextInt();

        while (quantity <= 0) {
            System.out.print("數量錯誤！請重新輸入大於 0 的數字：");
            quantity = sc.nextInt();
        }

        System.out.println("數量為：" + quantity);

        sc.close();
    }
}