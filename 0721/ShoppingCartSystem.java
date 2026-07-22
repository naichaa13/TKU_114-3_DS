import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<CartItem> cart = new ArrayList<>();
        boolean running = true;

        // 預先加入測試商品
        cart.add(new CartItem("P01", "Keyboard", 890, 1));
        cart.add(new CartItem("P02", "Mouse", 490, 2));

        while (running) {
            printMenu();
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    addItemToCart(cart, sc);
                    break;
                case "2":
                    updateItemQuantity(cart, sc);
                    break;
                case "3":
                    removeItemFromCart(cart, sc);
                    break;
                case "4":
                    listCartItems(cart);
                    break;
                case "5":
                    calculateTotal(cart);
                    break;
                case "0":
                    running = false;
                    System.out.println("購物車系統已結束。");
                    break;
                default:
                    System.out.println("無效的選擇，請重新輸入。");
            }
            System.out.println();
        }
        sc.close();
    }

    private static void printMenu() {
        System.out.println("=== 購物車管理系統 ===");
        System.out.println("1. 加入商品到購物車");
        System.out.println("2. 修改商品數量");
        System.out.println("3. 移除購物車商品");
        System.out.println("4. 顯示購物車清單");
        System.out.println("5. 計算並顯示總金額");
        System.out.println("0. 結束");
        System.out.print("請選擇功能：");
    }

    public static void addItemToCart(ArrayList<CartItem> cart, Scanner sc) {
        System.out.print("請輸入商品代碼 (例如 P03)：");
        String code = sc.nextLine().trim();

        if (code.isEmpty()) {
            System.out.println("加入失敗：代碼不得為空白！");
            return;
        }

        CartItem existing = findItemByCode(cart, code);
        if (existing != null) {
            System.out.print("該商品已在購物車中，請輸入要增加的數量：");
            int addQty = sc.nextInt();
            sc.nextLine(); // 清除緩衝區

            if (addQty <= 0) {
                System.out.println("加入失敗：增加的數量必須大於 0！");
                return;
            }

            existing.addQuantity(addQty);
            System.out.println("商品已存在，已成功將數量增加！目前數量：" + existing.getQuantity());
            return;
        }

        System.out.print("請輸入商品名稱：");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("加入失敗：名稱不得為空白！");
            return;
        }

        System.out.print("請輸入單價：");
        int price = sc.nextInt();
        if (price <= 0) {
            System.out.println("加入失敗：單價必須大於 0！");
            sc.nextLine();
            return;
        }

        System.out.print("請輸入數量：");
        int qty = sc.nextInt();
        sc.nextLine(); // 清除緩衝區
        if (qty <= 0) {
            System.out.println("加入失敗：數量必須大於 0！");
            return;
        }

        cart.add(new CartItem(code, name, price, qty));
        System.out.println("成功加入購物車！");
    }

    public static void updateItemQuantity(ArrayList<CartItem> cart, Scanner sc) {
        System.out.print("請輸入要修改數量的商品代碼：");
        String code = sc.nextLine().trim();

        CartItem target = findItemByCode(cart, code);
        if (target == null) {
            System.out.println("修改失敗：找不到該代碼的商品。");
            return;
        }

        System.out.print("目前數量為 [" + target.getQuantity() + "]，請輸入新數量：");
        int newQty = sc.nextInt();
        sc.nextLine(); // 清除緩衝區

        if (target.setQuantity(newQty)) {
            System.out.println("數量修改成功！");
        } else {
            System.out.println("修改失敗：數量小於或等於 0，不予接受！");
        }
    }

    public static void removeItemFromCart(ArrayList<CartItem> cart, Scanner sc) {
        System.out.print("請輸入要移除的商品代碼：");
        String code = sc.nextLine().trim();

        CartItem target = findItemByCode(cart, code);
        if (target != null) {
            cart.remove(target);
            System.out.println("移除成功！已將「" + target.getName() + "」從購物車中刪除。");
        } else {
            System.out.println("移除失敗：找不到該代碼的商品。");
        }
    }

    public static void listCartItems(ArrayList<CartItem> cart) {
        if (cart.isEmpty()) {
            System.out.println("目前購物車是空的。");
            return;
        }
        System.out.println("--- 購物車商品清單（共 " + cart.size() + " 項）---");
        for (CartItem item : cart) {
            System.out.println(item);
        }
    }

    public static void calculateTotal(ArrayList<CartItem> cart) {
        long total = 0;
        for (CartItem item : cart) {
            total += item.getSubTotal();
        }
        System.out.println(">>> 購物車商品總金額：$" + total);
    }

    private static CartItem findItemByCode(ArrayList<CartItem> cart, String code) {
        for (CartItem item : cart) {
            if (item.getCode().equalsIgnoreCase(code)) {
                return item;
            }
        }
        return null;
    }
}