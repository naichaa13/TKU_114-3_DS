import java.util.ArrayList;
import java.util.Scanner;

public class NameListManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        boolean running = true;

        while (running) {
            printMenu();
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    addName(names, sc);
                    break;
                case "2":
                    searchName(names, sc);
                    break;
                case "3":
                    updateName(names, sc);
                    break;
                case "4":
                    removeName(names, sc);
                    break;
                case "5":
                    listAll(names);
                    break;
                case "0":
                    running = false;
                    System.out.println("系統已結束。");
                    break;
                default:
                    System.out.println("無效的選擇，請重新輸入。");
            }
            System.out.println();
        }
        sc.close();
    }

    // --- 輔助方法區 (CRUD 與選單) ---

    private static void printMenu() {
        System.out.println("=== 名單管理系統 ===");
        System.out.println("1. 新增姓名");
        System.out.println("2. 搜尋姓名");
        System.out.println("3. 修改姓名");
        System.out.println("4. 刪除姓名");
        System.out.println("5. 列出全部");
        System.out.println("0. 結束");
        System.out.print("請選擇功能：");
    }

    private static void addName(ArrayList<String> names, Scanner sc) {
        System.out.print("請輸入要新增的姓名：");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("錯誤：姓名不得為空白！");
            return;
        }

        if (findNameIndex(names, name) != -1) {
            System.out.println("錯誤：該姓名已存在名單中！");
            return;
        }

        names.add(name);
        System.out.println("新增成功！");
    }

    private static void searchName(ArrayList<String> names, Scanner sc) {
        System.out.print("請輸入要搜尋的姓名：");
        String keyword = sc.nextLine().trim();

        int index = findNameIndex(names, keyword);
        if (index != -1) {
            System.out.println("找到了！該姓名位於索引 " + index + "（原始紀錄：" + names.get(index) + "）");
        } else {
            System.out.println("查無此姓名。");
        }
    }

    private static void updateName(ArrayList<String> names, Scanner sc) {
        System.out.print("請輸入想要修改的舊姓名：");
        String oldName = sc.nextLine().trim();

        int index = findNameIndex(names, oldName);
        if (index == -1) {
            System.out.println("修改失敗：找不到舊姓名「" + oldName + "」。");
            return;
        }

        System.out.print("請輸入新姓名：");
        String newName = sc.nextLine().trim();

        if (newName.isEmpty()) {
            System.out.println("修改失敗：新姓名不得為空白！");
            return;
        }

        int duplicateIndex = findNameIndex(names, newName);
        if (duplicateIndex != -1 && duplicateIndex != index) {
            System.out.println("修改失敗：該新姓名已存在於名單中！");
            return;
        }

        names.set(index, newName);
        System.out.println("修改成功！");
    }

    private static void removeName(ArrayList<String> names, Scanner sc) {
        System.out.print("請輸入要刪除的姓名：");
        String target = sc.nextLine().trim();

        int index = findNameIndex(names, target);
        if (index != -1) {
            String removed = names.remove(index);
            System.out.println("刪除成功！已移除：「" + removed + "」");
        } else {
            System.out.println("刪除失敗：找不到該姓名。");
        }
    }

    private static void listAll(ArrayList<String> names) {
        if (names.isEmpty()) {
            System.out.println("目前名單為空。");
            return;
        }
        System.out.println("--- 目前完整名單（共 " + names.size() + " 筆）---");
        for (int i = 0; i < names.size(); i++) {
            System.out.println("[" + i + "] " + names.get(i));
        }
    }

    private static int findNameIndex(ArrayList<String> names, String target) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }
}