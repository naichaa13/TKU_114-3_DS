import java.util.ArrayList;
import java.util.Scanner;

public class ContactBookSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();
        boolean running = true;

        contacts.add(new Contact("C01", "Amy", "0912-345678", "amy@example.com"));
        contacts.add(new Contact("C02", "Ben", "0923-456789", "ben@example.com"));

        while (running) {
            printMenu();
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    addContact(contacts, sc);
                    break;
                case "2":
                    searchContact(contacts, sc);
                    break;
                case "3":
                    updateContactPhone(contacts, sc);
                    break;
                case "4":
                    removeContact(contacts, sc);
                    break;
                case "5":
                    listAllContacts(contacts);
                    break;
                case "0":
                    running = false;
                    System.out.println("聯絡人管理系統已結束。");
                    break;
                default:
                    System.out.println("無效的選擇，請重新輸入。");
            }
            System.out.println();
        }
        sc.close();
    }

    private static void printMenu() {
        System.out.println("=== 聯絡人管理系統 ===");
        System.out.println("1. 新增聯絡人");
        System.out.println("2. 搜尋聯絡人 (依代碼或姓名)");
        System.out.println("3. 修改聯絡人電話");
        System.out.println("4. 刪除聯絡人");
        System.out.println("5. 顯示完整清單");
        System.out.println("0. 結束");
        System.out.print("請選擇功能：");
    }

    public static void addContact(ArrayList<Contact> list, Scanner sc) {
        System.out.print("請輸入聯絡人代碼 (例如 C03)：");
        String code = sc.nextLine().trim();

        if (code.isEmpty()) {
            System.out.println("新增失敗：代碼不得為空白！");
            return;
        }

        if (findContactByCode(list, code) != null) {
            System.out.println("新增失敗：該代碼已存在！");
            return;
        }

        System.out.print("請輸入姓名：");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("新增失敗：姓名不得為空白！");
            return;
        }

        System.out.print("請輸入電話：");
        String phone = sc.nextLine().trim();

        System.out.print("請輸入電子郵件：");
        String email = sc.nextLine().trim();

        list.add(new Contact(code, name, phone, email));
        System.out.println("新增聯絡人成功！");
    }

    public static void searchContact(ArrayList<Contact> list, Scanner sc) {
        System.out.print("請輸入要搜尋的「代碼」或「姓名」關鍵字：");
        String keyword = sc.nextLine().trim();

        if (keyword.isEmpty()) {
            System.out.println("搜尋失敗：關鍵字不得為空白。");
            return;
        }

        boolean found = false;
        System.out.println("--- 搜尋結果 ---");
        for (Contact c : list) {
            if (c.getCode().equalsIgnoreCase(keyword) || c.getName().equalsIgnoreCase(keyword)) {
                System.out.println(c);
                found = true;
            }
        }

        if (!found) {
            System.out.println("查無符合的聯絡人。");
        }
    }

    public static void updateContactPhone(ArrayList<Contact> list, Scanner sc) {
        System.out.print("請輸入要修改電話的聯絡人代碼：");
        String code = sc.nextLine().trim();

        Contact target = findContactByCode(list, code);
        if (target == null) {
            System.out.println("修改失敗：找不到該代碼的聯絡人。");
            return;
        }

        System.out.print("目前電話為 [" + target.getPhone() + "]，請輸入新電話：");
        String newPhone = sc.nextLine().trim();

        if (newPhone.isEmpty()) {
            System.out.println("修改失敗：新電話不得為空白！");
            return;
        }

        target.setPhone(newPhone);
        System.out.println("電話修改成功！");
    }

    public static void removeContact(ArrayList<Contact> list, Scanner sc) {
        System.out.print("請輸入要刪除的聯絡人代碼：");
        String code = sc.nextLine().trim();

        Contact target = findContactByCode(list, code);
        if (target != null) {
            list.remove(target);
            System.out.println("刪除成功！已移除聯絡人：" + target.getName());
        } else {
            System.out.println("刪除失敗：找不到該代碼的聯絡人。");
        }
    }

    public static void listAllContacts(ArrayList<Contact> list) {
        if (list.isEmpty()) {
            System.out.println("目前通訊錄為空。");
            return;
        }
        System.out.println("--- 完整聯絡人清單（共 " + list.size() + " 筆）---");
        for (Contact c : list) {
            System.out.println(c);
        }
    }

    private static Contact findContactByCode(ArrayList<Contact> list, String code) {
        for (Contact c : list) {
            if (c.getCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }
}