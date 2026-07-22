public class LinkedListReverse {
    public static void main(String[] args) {
        System.out.println("=== 測試案例 1：多節點反轉 ===");
        IntNode head1 = new IntNode(10);
        head1.next = new IntNode(20);
        head1.next.next = new IntNode(30);
        head1.next.next.next = new IntNode(40);

        System.out.print("反轉前：");
        printList(head1);

        head1 = reverse(head1);

        System.out.print("反轉後：");
        printList(head1);

        // --- 測試案例 2：單一節點反轉 (50 -> null) ---
        System.out.println("\n=== 測試案例 2：單一節點反轉 ===");
        IntNode head2 = new IntNode(50);

        System.out.print("反轉前：");
        printList(head2);

        head2 = reverse(head2);

        System.out.print("反轉後：");
        printList(head2);

        // --- 測試案例 3：空串列反轉 (null) ---
        System.out.println("\n=== 測試案例 3：空串列反轉 ===");
        IntNode head3 = null;

        System.out.print("反轉前：");
        printList(head3);

        head3 = reverse(head3);

        System.out.print("反轉後：");
        printList(head3);
    }

    // --- 核心功能：原地反轉 (Reverse) ---
    public static IntNode reverse(IntNode head) {
        // 邊界處理：若串列為空或只有單一節點，直接回傳原 head 即可
        if (head == null || head.next == null) {
            return head;
        }

        IntNode previous = null;
        IntNode current = head;

        while (current != null) {
            // 1. 暫存下一個節點，避免指針改變後遺失後方資料
            IntNode nextNode = current.next;

            // 2. 將當前節點的 next 指向前方（反轉方向）
            current.next = previous;

            // 3. 將 previous 與 current 依序往前推進
            previous = current;
            current = nextNode;
        }

        // 迴圈結束後，previous 會停在原本的最後一個節點，它就是新的 head
        return previous;
    }

    public static void printList(IntNode head) {
        if (head == null) {
            System.out.println("null (空串列)");
            return;
        }

        IntNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}