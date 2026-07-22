public class LinkedListSearchRemove {
    public static void main(String[] args) {
        IntNode head = new IntNode(10);
        head.next = new IntNode(20);
        head.next.next = new IntNode(30);
        head.next.next.next = new IntNode(40);

        System.out.println("=== 初始鏈結串列 ===");
        printList(head);

        // 1. 測試搜尋功能 (contains)
        System.out.println("\n=== 測試搜尋功能 (contains) ===");
        System.out.println("是否包含 30：" + contains(head, 30));
        System.out.println("是否包含 99：" + contains(head, 99));

        // 2. 測試刪除找不到的節點 (99)
        System.out.println("\n=== 測試刪除不存在的值 (99) ===");
        head = removeValue(head, 99);
        printList(head);

        // 3. 測試刪除中間節點 (30)
        System.out.println("\n=== 測試刪除中間節點 (30) ===");
        head = removeValue(head, 30);
        printList(head);

        // 4. 測試刪除最後一個節點 (40)
        System.out.println("\n=== 測試刪除最後一個節點 (40) ===");
        head = removeValue(head, 40);
        printList(head);

        // 5. 測試刪除 head 節點 (10)
        System.out.println("\n=== 測試刪除 head 節點 (10) ===");
        head = removeValue(head, 10);
        printList(head);

        // 6. 測試刪除後剩餘的唯一節點 (20)，以及空串列處理
        System.out.println("\n=== 測試刪除最後剩下的節點 (20) ===");
        head = removeValue(head, 20);
        printList(head);

        // 7. 測試對空串列進行刪除操作
        System.out.println("\n=== 測試對空串列進行刪除操作 (刪除 10) ===");
        head = removeValue(head, 10);
        printList(head);
    }

    // 1：搜尋 (contains)
    public static boolean contains(IntNode head, int target) {
        IntNode current = head;
        while (current != null) {
            if (current.data == target) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // 2：刪除指定值 (removeValue)
    public static IntNode removeValue(IntNode head, int target) {
        // 邊界處理：空串列直接回傳 null
        if (head == null) {
            System.out.println("操作提示：串列為空，無法刪除。");
            return null;
        }

        // 邊界處理：刪除的目標剛好是 head (第一個節點)
        if (head.data == target) {
            System.out.println("成功刪除 Head 節點：" + target);
            return head.next; // 將 head 指向第二個節點
        }

        IntNode previous = head;
        IntNode current = head.next;

        // 尋找目標節點，同時追蹤 previous 與 current
        while (current != null) {
            if (current.data == target) {
                // 跨過 current 節點，完成刪除
                previous.next = current.next;
                System.out.println("成功刪除節點：" + target);
                return head;
            }
            previous = current;
            current = current.next;
        }

        // 找不到目標時的處理
        System.out.println("刪除提示：找不到目標值 " + target + "，串列保持不變。");
        return head;
    }

    public static void printList(IntNode head) {
        if (head == null) {
            System.out.println("鏈結內容：null (空串列)");
            return;
        }

        IntNode current = head;
        System.out.print("鏈結內容：");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}