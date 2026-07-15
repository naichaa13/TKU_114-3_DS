import java.util.Scanner;

/**
 * 測試案例 (Test Cases):
 * 1. 正常解析：初始化 5 筆資料並顯示。
 * 2. 完整搜尋：輸入 "Mouse" -> 找到 1 筆。
 * 3. 部分搜尋：輸入 "o" -> 找到 Keyboard, Mouse, Monitor。
 * 4. 低庫存：顯示 Monitor (5), Headset (8)。
 * 5. 總價值：顯示正確的庫存總價值。
 * 6. 新增正確資料："Speaker,600,10" -> 成功加入陣列。
 * 7. 新增格式錯誤："Keyboard,800" -> 捕捉「欄位數量不足」。
 * 8. 新增數字轉換錯誤："Headset,abc,10" -> 捕捉「數值格式錯誤」。
 */
public class ProductDataManager {
    // 加入 static 確保 main 可以存取
    static String[] records = {
            "Keyboard,890,12",
            "Mouse,490,20",
            "Monitor,5200,5",
            "USB Cable,250,30",
            "Headset,1290,8"
    };

    static String[] names = new String[20];
    static int[] prices = new int[20];
    static int[] stocks = new int[20];
    static int count = 0;

    public static void main(String[] args) {
        parseRecords();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- 商品管理系統 ---");
            System.out.println("1.顯示表格 | 2.搜尋 | 3.低庫存 | 4.總價值 | 5.新增資料 | 0.結束");
            System.out.print("選擇：");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    displayTable();
                    break;
                case 2:
                    searchMenu(sc);
                    break;
                case 3:
                    showLowStock();
                    break;
                case 4:
                    showTotalValue();
                    break;
                case 5:
                    addNewProduct(sc);
                    break;
            }
        } while (choice != 0);
        sc.close();
    }

    // 1. 解析資料
    public static void parseRecords() {
        for (String r : records) {
            processLine(r);
        }
    }

    // 2. 處理單行字串
    public static void processLine(String line) {
        try {
            String[] parts = line.split(",");
            if (parts.length != 3)
                throw new Exception("欄位數量不足");

            names[count] = parts[0].trim();
            prices[count] = Integer.parseInt(parts[1].trim());
            stocks[count] = Integer.parseInt(parts[2].trim());
            count++;
        } catch (NumberFormatException e) {
            System.out.println("錯誤：[" + line + "] 數值格式不正確。");
        } catch (Exception e) {
            System.out.println("錯誤：[" + line + "] " + e.getMessage());
        }
    }

    // 3. 顯示表格
    public static void displayTable() {
        System.out.println("名稱\t\t價格\t庫存");
        for (int i = 0; i < count; i++) {
            System.out.printf("%-12s\t%d\t%d\n", names[i], prices[i], stocks[i]);
        }
    }

    // 4. 搜尋
    public static void searchMenu(Scanner sc) {
        System.out.print("輸入關鍵字：");
        String key = sc.nextLine().trim();
        System.out.print("完整搜尋輸入 1，部分搜尋輸入 2：");
        boolean exact = sc.nextLine().trim().equals("1");

        boolean found = false;
        for (int i = 0; i < count; i++) {
            boolean match = exact ? names[i].equalsIgnoreCase(key)
                    : names[i].toLowerCase().contains(key.toLowerCase());
            if (match) {
                System.out.println("找到：" + names[i] + " (價格: " + prices[i] + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("沒有找到符合的商品。");
        }
    }

    // 5. 低庫存與總價值
    public static void showLowStock() {
        for (int i = 0; i < count; i++) {
            if (stocks[i] < 10)
                System.out.println("低庫存商品：" + names[i] + " (" + stocks[i] + ")");
        }
    }

    public static void showTotalValue() {
        long total = 0;
        for (int i = 0; i < count; i++)
            total += (long) prices[i] * stocks[i];
        System.out.println("總庫存價值：" + total);
    }

    public static void addNewProduct(Scanner sc) {
        System.out.print("輸入新資料(格式 Name,Price,Stock)：");
        processLine(sc.nextLine());
    }

}