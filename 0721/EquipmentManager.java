import java.util.ArrayList;
import java.util.Scanner;

public class EquipmentManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Equipment> equipments = new ArrayList<>();
        boolean running = true;

        equipments.add(new Equipment("E01", "投影機"));
        equipments.add(new Equipment("E02", "筆記型電腦"));
        equipments.add(new Equipment("E03", "簡報筆"));

        while (running) {
            printMenu();
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    addEquipment(equipments, sc);
                    break;
                case "2":
                    searchEquipment(equipments, sc);
                    break;
                case "3":
                    borrowEquipment(equipments, sc);
                    break;
                case "4":
                    returnEquipment(equipments, sc);
                    break;
                case "5":
                    listAvailableEquipments(equipments);
                    break;
                case "6":
                    listAllEquipments(equipments);
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

    private static void printMenu() {
        System.out.println("=== 設備管理系統 ===");
        System.out.println("1. 新增設備");
        System.out.println("2. 依代碼搜尋設備");
        System.out.println("3. 借出設備");
        System.out.println("4. 歸還設備");
        System.out.println("5. 列出所有「可借用」設備");
        System.out.println("6. 列出全部設備");
        System.out.println("0. 結束");
        System.out.print("請選擇功能：");
    }

    private static void addEquipment(ArrayList<Equipment> list, Scanner sc) {
        System.out.print("請輸入設備代碼（例如 E04）：");
        String code = sc.nextLine().trim();

        if (code.isEmpty()) {
            System.out.println("錯誤：設備代碼不得為空白！");
            return;
        }

        if (findByCode(list, code) != null) {
            System.out.println("錯誤：該設備代碼已存在，無法重複新增！");
            return;
        }

        System.out.print("請輸入設備名稱：");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("錯誤：設備名稱不得為空白！");
            return;
        }

        list.add(new Equipment(code, name));
        System.out.println("新增設備成功！");
    }

    private static void searchEquipment(ArrayList<Equipment> list, Scanner sc) {
        System.out.print("請輸入要搜尋的設備代碼：");
        String code = sc.nextLine().trim();

        Equipment eq = findByCode(list, code);
        if (eq != null) {
            System.out.println("查詢結果：" + eq);
        } else {
            System.out.println("查無此代碼的設備。");
        }
    }

    private static void borrowEquipment(ArrayList<Equipment> list, Scanner sc) {
        System.out.print("請輸入要借出的設備代碼：");
        String code = sc.nextLine().trim();

        Equipment eq = findByCode(list, code);
        if (eq == null) {
            System.out.println("借出失敗：找不到該代碼的設備。");
            return;
        }

        if (eq.borrow()) {
            System.out.println("借出成功！已將「" + eq.getName() + "」標記為已借出。");
        } else {
            System.out.println("借出失敗：該設備目前已經被借走了！");
        }
    }

    private static void returnEquipment(ArrayList<Equipment> list, Scanner sc) {
        System.out.print("請輸入要歸還的設備代碼：");
        String code = sc.nextLine().trim();

        Equipment eq = findByCode(list, code);
        if (eq == null) {
            System.out.println("歸還失敗：找不到該代碼的設備。");
            return;
        }

        if (eq.returnEquipment()) {
            System.out.println("歸還成功！「" + eq.getName() + "」已恢復可借用狀態。");
        } else {
            System.out.println("歸還失敗：該設備本來就是在庫（可借用）狀態。");
        }
    }

    private static void listAvailableEquipments(ArrayList<Equipment> list) {
        System.out.println("--- 目前可借用設備清單 ---");
        boolean found = false;
        for (Equipment eq : list) {
            if (eq.isAvailable()) {
                System.out.println(eq);
                found = true;
            }
        }
        if (!found) {
            System.out.println("目前沒有可借用的設備。");
        }
    }

    private static void listAllEquipments(ArrayList<Equipment> list) {
        if (list.isEmpty()) {
            System.out.println("目前系統無任何設備紀錄。");
            return;
        }
        System.out.println("--- 全部設備清單（共 " + list.size() + " 筆）---");
        for (Equipment eq : list) {
            System.out.println(eq);
        }
    }

    private static Equipment findByCode(ArrayList<Equipment> list, String code) {
        for (Equipment eq : list) {
            if (eq.getCode().equalsIgnoreCase(code)) {
                return eq;
            }
        }
        return null;
    }
}