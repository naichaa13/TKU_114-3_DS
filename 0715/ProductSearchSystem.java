
/**
 測試案例 :
  1. 顯示全部：驗證表格輸出與格式。
  2. 完整搜尋：輸入 " mouse " -> 應顯示 Mouse, 490, 20。
  3. 完整搜尋：輸入 "Camera" -> 應顯示找不到。
  4. 部分搜尋：輸入 "o" -> 應顯示 Keyboard, Mouse, Monitor (包含 o)。
  5. 最長名稱：應顯示 Monitor。
  6. 搜尋位置：輸入 "USB" -> 應顯示 USB Cable 的 "USB" 在該字串索引 0。
 */
import java.util.Scanner;

public class ProductSearchSystem {
    // 0714 預設資料
    static String[] names = { "Keyboard", "Mouse", "Monitor", "USB Cable", "Headset" };
    static int[] prices = { 890, 490, 5200, 250, 1290 };
    static int[] stocks = { 12, 20, 5, 30, 8 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- 商品搜尋系統 ---");
            System.out.println("1. 顯示全部 | 2. 完整搜尋 | 3. 部分搜尋 | 4. 最長名稱 | 5. 搜尋位置 | 0. 結束");
            System.out.print("請選擇：");
            choice = sc.nextInt();
            sc.nextLine(); // 讀走換行

            switch (choice) {
                case 1:
                    displayAll();
                    break;
                case 2:
                    searchExact(sc);
                    break;
                case 3:
                    searchPartial(sc);
                    break;
                case 4:
                    showLongestName();
                    break;
                case 5:
                    searchIndex(sc);
                    break;
                case 0:
                    System.out.println("系統結束。");
                    break;
                default:
                    System.out.println("無效選項。");
            }
        } while (choice != 0);
        sc.close();
    }

    // 方法 1：顯示全部
    public static void displayAll() {
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%d. %-12s | 價格: %d | 庫存: %d\n", (i + 1), names[i], prices[i], stocks[i]);
        }
    }

    // 方法 2：完整名稱搜尋
    public static void searchExact(Scanner sc) {
        System.out.print("輸入商品名稱：");
        String key = sc.nextLine().trim();
        boolean found = false;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(key)) {
                System.out.println("找到商品：" + names[i] + "，價格：" + prices[i]);
                found = true;
                break;
            }
        }
        if (!found)
            System.out.println("查無此商品。");
    }

    // 方法 3：部分名稱搜尋
    public static void searchPartial(Scanner sc) {
        System.out.print("輸入搜尋關鍵字：");
        String key = sc.nextLine().trim().toLowerCase();
        for (String name : names) {
            if (name.toLowerCase().contains(key)) {
                System.out.println("符合項目：" + name);
            }
        }
    }

    // 方法 4：顯示名稱最長的商品
    public static void showLongestName() {
        String longest = names[0];
        for (String name : names) {
            if (name.length() > longest.length())
                longest = name;
        }
        System.out.println("名稱最長的商品是：" + longest);
    }

    // 方法 5：顯示商品名稱與搜尋關鍵字第一次出現的位置
    public static void searchIndex(Scanner sc) {
        System.out.print("輸入搜尋關鍵字：");
        String key = sc.nextLine().trim();
        for (String name : names) {
            int index = name.toLowerCase().indexOf(key.toLowerCase());
            if (index != -1) {
                System.out.println("商品 [" + name + "] 在索引 " + index + " 處找到關鍵字 [" + key + "]");
            }
        }
    }
}