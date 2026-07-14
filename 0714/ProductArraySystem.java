import java.util.Scanner;

public class ProductArraySystem {
    static String[] names = { "Keyboard", "Mouse", "Monitor", "USB Cable", "Headset" };
    static int[] prices = { 890, 490, 5200, 250, 1290 };
    static int[] stocks = { 12, 20, 5, 30, 8 };
    static int transactionCount = 0; // 用於操作摘要

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- 商品管理系統 ---");
            System.out.println("1. 顯示全部商品 | 2. 查詢商品 | 3. 購買商品 | 4. 補充庫存");
            System.out.println("5. 低庫存警示 | 6. 總價值查詢 | 0. 結束系統");
            System.out.print("請選擇功能：");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    queryProduct(sc);
                    break;
                case 3:
                    purchaseProduct(sc);
                    break;
                case 4:
                    restockProduct(sc);
                    break;
                case 5:
                    showLowStock();
                    break;
                case 6:
                    showTotalValue();
                    break;
                case 0:
                    System.out.println("結束系統，共進行了 " + transactionCount + " 次操作。");
                    break;
                default:
                    System.out.println("無效選擇！");
            }
        } while (choice != 0);
        sc.close();
    }

    public static void displayProducts() {
        System.out.println("編號\t名稱\t\t價格\t庫存");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%d\t%-12s\t%d\t%d\n", (i + 1), names[i], prices[i], stocks[i]);
        }
    }

    public static void queryProduct(Scanner sc) {
        int id = getValidIndex(sc);
        System.out.printf("商品名稱：%s, 價格：%d, 當前庫存：%d\n", names[id], prices[id], stocks[id]);
        transactionCount++;
    }

    public static void purchaseProduct(Scanner sc) {
        int id = getValidIndex(sc);
        System.out.print("請輸入購買數量：");
        int qty = sc.nextInt();
        if (qty > 0 && qty <= stocks[id]) {
            stocks[id] -= qty;
            System.out.println("購買成功！剩餘庫存：" + stocks[id]);
            transactionCount++;
        } else {
            System.out.println("購買失敗（數量不足或無效）。");
        }
    }

    public static void restockProduct(Scanner sc) {
        int id = getValidIndex(sc);
        System.out.print("請輸入補貨數量：");
        int qty = sc.nextInt();
        if (qty > 0) {
            stocks[id] += qty;
            System.out.println("補貨成功！目前庫存：" + stocks[id]);
            transactionCount++;
        }
    }

    public static void showLowStock() {
        System.out.println("以下商品庫存低於 10：");
        for (int i = 0; i < stocks.length; i++) {
            if (stocks[i] < 10) {
                System.out.println(names[i] + " (剩餘：" + stocks[i] + ")");
            }
        }
        transactionCount++;
    }

    public static void showTotalValue() {
        long total = 0;
        for (int i = 0; i < prices.length; i++) {
            total += (long) prices[i] * stocks[i];
        }
        System.out.println("全部庫存總價值為：" + total);
        transactionCount++;
    }

    public static int getValidIndex(Scanner sc) {
        int id;
        do {
            System.out.print("請輸入商品編號 (1-" + names.length + ")：");
            id = sc.nextInt() - 1;
        } while (id < 0 || id >= names.length);
        return id;
    }
}