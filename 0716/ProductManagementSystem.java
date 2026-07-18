/*

| 測試項目 | 輸入指令/操作 | 執行結果 |
| --- | --- | --- |
| 1. 顯示全部    | `1` | 成功列出初始的 Keyboard, Mouse, Monitor, Headset, Webcam 資訊。 |
| 2. 名稱搜尋.   | `2` -> `mouse` | 成功顯示：`Mouse，價格：490，庫存：20` |
| 3. 失敗搜尋.   | `2` -> `iPhone` | 顯示：`查無此商品` |
| 4. 成功新增.   | `3` -> `Tablet 3000 5` | 顯示：`新增成功` (確認顯示於清單中) |
| 5. 測試重複新增 | `3` -> `Mouse 100 1` | 顯示：`名稱重複！` (系統拒絕新增) |
| 6. 測試出售     | `4` -> `Keyboard 2` | 顯示：`出售成功` (庫存更新為 10) |
| 7. 測試超額出售 | `4` -> `Monitor 10` | 顯示：`操作失敗` (庫存僅 5，系統保護機制運作) |
| 8. 測試補貨    | `5` -> `Headset 5` | 顯示：`補貨成功` (Headset 庫存由 8 變 13) |
| 9. 修改價格    | `6` -> `Webcam 999` | 顯示：`改價成功` (價格變更為 999) |
| 10. 低庫存篩選 | `7` | 顯示庫存 < 10 的商品 (如 Monitor 等) |
| 11. 顯示總價值 | `8` | 正確計算並顯示所有商品庫存總價值 |

 */

import java.util.Scanner;

public class ProductManagementSystem {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Product[] products = new Product[10];
        products[0] = new Product("Keyboard", 890, 12);
        products[1] = new Product("Mouse", 490, 20);
        products[2] = new Product("Monitor", 5200, 5);
        products[3] = new Product("Headset", 1200, 8);
        products[4] = new Product("Webcam", 950, 15);

        int count = 5;
        boolean running = true;

        while (running) {
            printMenu();
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    showAll(products);
                    break;
                case "2":
                    findByName(products);
                    break;
                case "3":
                    count = addProduct(products, count);
                    break;
                case "4":
                    sellProduct(products);
                    break;
                case "5":
                    restockProduct(products);
                    break;
                case "6":
                    updatePrice(products);
                    break;
                case "7":
                    showLowStock(products);
                    break;
                case "8":
                    showTotalValue(products);
                    break;
                case "0":
                    running = false;
                    System.out.println("系統結束。");
                    break;
                default:
                    System.out.println("無效選擇，請重新輸入。");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- 商品管理系統 ---");
        System.out.println("1.全部 2.搜尋 3.新增 4.出售 5.補貨 6.改價 7.低庫存 8.總價值 0.結束");
        System.out.print("請選擇：");
    }

    private static void showAll(Product[] p) {
        for (Product item : p)
            if (item != null)
                System.out.println(item);
    }

    private static Product find(Product[] p, String name) {
        for (Product item : p)
            if (item != null && item.getName().equalsIgnoreCase(name.trim()))
                return item;
        return null;
    }

    private static void findByName(Product[] p) {
        System.out.print("輸入完整名稱：");
        Product item = find(p, sc.nextLine());
        System.out.println(item != null ? item : "查無此商品");
    }

    private static int addProduct(Product[] p, int count) {
        if (count >= 10) {
            System.out.println("陣列已滿！");
            return count;
        }
        System.out.print("名稱 價格 庫存：");
        String n = sc.next();
        int pr = sc.nextInt();
        int st = sc.nextInt();
        sc.nextLine();
        if (find(p, n) != null) {
            System.out.println("名稱重複！");
            return count;
        }
        p[count++] = new Product(n, pr, st);
        return count;
    }

    private static void sellProduct(Product[] p) {
        System.out.print("名稱 數量：");
        Product item = find(p, sc.next());
        if (item != null && item.sell(sc.nextInt()))
            System.out.println("出售成功");
        else
            System.out.println("操作失敗");
        sc.nextLine();
    }

    private static void restockProduct(Product[] p) {
        System.out.print("名稱 數量：");
        Product item = find(p, sc.next());
        if (item != null && item.restock(sc.nextInt()))
            System.out.println("補貨成功");
        else
            System.out.println("操作失敗");
        sc.nextLine();
    }

    private static void updatePrice(Product[] p) {
        System.out.print("名稱 新價格：");
        Product item = find(p, sc.next());
        if (item != null && item.setPrice(sc.nextInt()))
            System.out.println("改價成功");
        else
            System.out.println("操作失敗");
        sc.nextLine();
    }

    private static void showLowStock(Product[] p) {
        for (Product item : p)
            if (item != null && item.isLowStock())
                System.out.println(item);
    }

    private static void showTotalValue(Product[] p) {
        long total = 0;
        for (Product item : p)
            if (item != null)
                total += item.getInventoryValue();
        System.out.println("庫存總價值：" + total);
    }
}