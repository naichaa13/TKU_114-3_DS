import java.util.Scanner;

public class OrderSystemRefactor_demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalItems = 0;
        int totalAmount = 0;
        boolean isRunning = true;

        while (isRunning) {
            printMenu();
            System.out.print("請選擇功能 (0 結帳): ");
            int option = sc.nextInt();

            if (option == 0) {
                isRunning = false;
            } else if (option >= 1 && option <= 3) {
                int price = getPrice(option);
                int quantity = readValidQuantity(sc);

                totalItems += quantity;
                totalAmount += calculateSubtotal(price, quantity);

                System.out.println("成功加入: " + getItemName(option) + " x " + quantity);
            } else {
                System.out.println("無效選項，請重新輸入。");
            }
        }

        printReceipt(totalItems, totalAmount);
        sc.close();
    }

    public static void printMenu() {
        System.out.println("\n=== 點餐系統 ===");
        System.out.println("1. 紅茶 ($20)");
        System.out.println("2. 綠茶 ($20)");
        System.out.println("3. 咖啡 ($50)");
        System.out.println("0. 結帳");
    }

    public static int getPrice(int option) {
        switch (option) {
            case 1:
                return 20;
            case 2:
                return 20;
            case 3:
                return 50;
            default:
                return 0;
        }
    }

    public static String getItemName(int option) {
        switch (option) {
            case 1:
                return "紅茶";
            case 2:
                return "綠茶";
            case 3:
                return "咖啡";
            default:
                return "未知商品";
        }
    }

    public static int readValidQuantity(Scanner sc) {
        int quantity = 0;
        while (quantity <= 0) {
            System.out.print("請輸入數量 (需大於 0): ");
            quantity = sc.nextInt();
            if (quantity <= 0) {
                System.out.println("數量錯誤，請重新輸入。");
            }
        }
        return quantity;
    }

    public static int calculateSubtotal(int price, int quantity) {
        return price * quantity;
    }

    public static void printReceipt(int totalItems, int totalAmount) {
        System.out.println("\n=== 結帳收據 ===");
        System.out.println("Total items: " + totalItems);
        System.out.println("Total amount: $" + totalAmount);
    }
}