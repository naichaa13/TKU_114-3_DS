import java.util.Scanner;

public class DrinkOrderSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int blackTeaCount = 0, greenTeaCount = 0, milkTeaCount = 0, coffeeCount = 0;
        int totalItems = 0;
        int totalAmount = 0;

        while (true) {
            printMenu();
            System.out.print("請輸入選項：");
            int option = sc.nextInt();

            if (option == 0)
                break;

            if (option >= 1 && option <= 4) {
                int price = getPrice(option);
                int qty = readValidQuantity(sc);

                totalItems += qty;
                totalAmount += calculateSubtotal(price, qty);

                if (option == 1)
                    blackTeaCount += qty;
                else if (option == 2)
                    greenTeaCount += qty;
                else if (option == 3)
                    milkTeaCount += qty;
                else if (option == 4)
                    coffeeCount += qty;

                System.out.println(getItemName(option) + " x " + qty);
                System.out.println("Subtotal: " + calculateSubtotal(price, qty) + "\n");
            } else {
                System.out.println("無效選項，請重新選擇。\n");
            }
        }

        int finalAmount = calculateDiscountedTotal(totalAmount);
        printReceipt(blackTeaCount, greenTeaCount, milkTeaCount, coffeeCount, totalItems, totalAmount, finalAmount);

        sc.close();
    }

    public static void printMenu() {
        System.out.println("=== Drink Menu ===");
        System.out.println("1. Black tea  $30");
        System.out.println("2. Green tea  $35");
        System.out.println("3. Milk tea   $45");
        System.out.println("4. Coffee     $50");
        System.out.println("0. Checkout");
    }

    public static int getPrice(int option) {
        switch (option) {
            case 1:
                return 30;
            case 2:
                return 35;
            case 3:
                return 45;
            case 4:
                return 50;
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
                return "Milk tea";
            case 4:
                return "Coffee";
            default:
                return "Unknown";
        }
    }

    public static int readValidQuantity(Scanner sc) {
        int qty = 0;
        while (qty <= 0) {
            System.out.print("請輸入數量：");
            qty = sc.nextInt();
            if (qty <= 0)
                System.out.println("數量必須大於 0！");
        }
        return qty;
    }

    public static int calculateSubtotal(int price, int quantity) {
        return price * quantity;
    }

    public static int calculateDiscountedTotal(int totalAmount) {
        if (totalAmount >= 300) {
            return (int) (totalAmount * 0.9);
        }
        return totalAmount;
    }

    public static void printReceipt(int bCount, int gCount, int mCount, int cCount, int items, int amount,
            int finalAmount) {
        System.out.println("=== Receipt ===");
        System.out.println("Black tea: " + bCount);
        System.out.println("Green tea: " + gCount);
        System.out.println("Milk tea: " + mCount);
        System.out.println("Coffee: " + cCount);
        System.out.println("Total items: " + items);
        System.out.println("Original amount: " + amount);
        System.out.println("Discount: " + (amount >= 300 ? "Yes (10% off)" : "No"));
        System.out.println("Final amount: " + finalAmount);
    }
}