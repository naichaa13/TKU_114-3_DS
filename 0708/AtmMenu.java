import java.util.Scanner;

public class AtmMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 1000;
        int option = -1;
        while (option != 0) {
            System.out.println("\n=== ATM Menu ===");
            System.out.println("1. 查詢餘額");
            System.out.println("2. 存款");
            System.out.println("3. 提款");
            System.out.println("0. 離開");
            System.out.print("請輸入選項：");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("目前餘額為：" + balance);
                    break;
                case 2:
                    System.out.print("請輸入存款金額：");
                    int deposit = sc.nextInt();
                    while (deposit <= 0) {
                        System.out.print("存款金額錯誤！請重新輸入大於 0 的數字：");
                        deposit = sc.nextInt();
                    }
                    balance += deposit;
                    System.out.println("存款成功！目前餘額為：" + balance);
                    break;
                case 3:
                    System.out.print("請輸入提款金額：");
                    int withdraw = sc.nextInt();
                    while (withdraw <= 0 || withdraw > balance) {
                        if (withdraw <= 0) {
                            System.out.print("提款金額錯誤！請重新輸入大於 0 且不超過餘額的數字：");
                        } else {
                            System.out.print("餘額不足！請重新輸入不超過餘額的數字：");
                        }
                        withdraw = sc.nextInt();
                    }
                    balance -= withdraw;
                    System.out.println("提款成功！目前餘額為：" + balance);
                    break;
                case 0:
                    System.out.println("謝謝使用，掰掰！");
                    break;
                default:
                    System.out.println("無效選項，請重新選擇");

            }
        }
        sc.close();
    }
}
