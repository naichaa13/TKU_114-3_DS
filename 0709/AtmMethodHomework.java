import java.util.Scanner;

public class AtmMethodHomework {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 1000;
        int option = -1;

        while (option != 0) {
            printMenu();
            System.out.print("請輸入選項：");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    printBalance(balance);
                    break;
                case 2:
                    int dep = readPositiveAmount(sc, "請輸入存款金額：");
                    balance = deposit(balance, dep);
                    System.out.println("存款成功！目前餘額為：" + balance);
                    break;
                case 3:
                    int wit = readPositiveAmount(sc, "請輸入提款金額：");
                    if (wit > balance) {
                        System.out.println("餘額不足！");
                    } else {
                        balance = withdraw(balance, wit);
                        System.out.println("提款成功！目前餘額為：" + balance);
                    }
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

    public static void printMenu() {
        System.out.println("\n=== ATM Menu ===");
        System.out.println("1. 查詢餘額");
        System.out.println("2. 存款");
        System.out.println("3. 提款");
        System.out.println("0. 離開");
    }

    public static int readPositiveAmount(Scanner sc, String message) {
        int amount = 0;
        while (amount <= 0) {
            System.out.print(message);
            amount = sc.nextInt();
            if (amount <= 0) {
                System.out.print("金額錯誤！");
            }
        }
        return amount;
    }

    public static int deposit(int balance, int amount) {
        return balance + amount;
    }

    public static int withdraw(int balance, int amount) {
        return balance - amount;
    }

    public static void printBalance(int balance) {
        System.out.println("目前餘額為：" + balance);
    }
}