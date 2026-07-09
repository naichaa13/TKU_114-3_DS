import java.util.Scanner;

public class OrderSystemRefactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalItems = 0;
        int totalAmount = 0;
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("請選擇功能：");
            int option = sc.nextInt();

            if (option == 0) {
                running = false;
            } else if (option >= 1 && option <= 3) {
                int price = getPrice(option);
                int quantity = readValidQuantity(sc);

                totalItems += quantity;
                totalAmount += calculateSubtotal(price, quantity);

                System.out.println("已加入 " + getItemName(option) + " x " + quantity);
            } else {
                System.out.println("無效選項，請重新選擇。");
            }
        }

        printReceipt(totalItems, totalAmount);
        sc.close();
    }

    public static void printMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Black tea ($20)");
        System.out.println("2. Green tea ($25)");
        System.out.println("3. Coffee ($40)");
        System.out.println("0. Checkout");
    }

    public static int getPrice(int option) {
        switch (option) {
            case 1:
                return 20;
            case 2:
                return 25;
            case 3:
                return 40;
            default:
                return 0;
        }
    }

    public static String getItemName(int option) {
        switch (option) {
            case 1:
                return "Black tea";
            case 2:
                return "Green tea";
            case 3:
                return "Coffee";
            default:
                return "Unknown";
        }
    }

    public static int readValidQuantity(Scanner sc) {
        int quantity = -1;
        while (quantity <= 0) {
            System.out.print("請輸入數量：");
            quantity = sc.nextInt();
            if (quantity <= 0) {
                System.out.println("數量錯誤！請重新輸入大於 0 的數字。");
            }
        }
        return quantity;
    }

    public static int calculateSubtotal(int price, int quantity) {
        return price * quantity;
    }

    public static void printReceipt(int totalItems, int totalAmount) {
        System.out.println("\n=== Receipt ===");
        System.out.println("Total items: " + totalItems);
        System.out.println("Total amount: $" + totalAmount);
    }
}