public class NumberHistoryList {
    private IntNode head;
    private int size;

    public NumberHistoryList() {
        this.head = null;
        this.size = 0;
    }

    // 1. 前端新增 (addFirst)
    public void addFirst(int value) {
        IntNode newNode = new IntNode(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // 2. 尾端新增 (addLast)
    public void addLast(int value) {
        IntNode newNode = new IntNode(value);
        if (head == null) {
            head = newNode;
        } else {
            IntNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // 3. 搜尋 (contains)
    public boolean contains(int target) {
        IntNode current = head;
        while (current != null) {
            if (current.data == target) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // 4. 刪除指定值 (removeValue)
    public boolean removeValue(int target) {
        if (head == null) {
            return false;
        }
        // 若刪除的是 head 節點
        if (head.data == target) {
            head = head.next;
            size--;
            return true;
        }

        IntNode previous = head;
        IntNode current = head.next;
        while (current != null) {
            if (current.data == target) {
                previous.next = current.next;
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false; // 找不到目標
    }

    // 5. 輸出完整串列
    public void printList() {
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

    // 6. 統計：取得 size
    public int size() {
        return size;
    }

    // 7. 統計：總和 (Sum)
    public int getSum() {
        if (head == null)
            return 0;
        int sum = 0;
        IntNode current = head;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }

    // 8. 統計：最大值 (Max)
    public Integer getMax() {
        if (head == null)
            return null; // 空串列明確回傳 null
        int max = head.data;
        IntNode current = head.next;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        return max;
    }

    // 9. 統計：最小值 (Min)
    public Integer getMin() {
        if (head == null)
            return null; // 空串列明確回傳 null
        int min = head.data;
        IntNode current = head.next;
        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }
        return min;
    }

    public static void main(String[] args) {
        NumberHistoryList history = new NumberHistoryList();

        System.out.println("=== 初始狀態（空串列統計測試） ===");
        printStatistics(history);

        // 操作 1：尾端新增 20
        history.addLast(20);
        System.out.println("\n[操作 1] 尾端新增 20：");
        history.printList();
        printStatistics(history);

        // 操作 2：前端新增 10
        history.addFirst(10);
        System.out.println("\n[操作 2] 前端新增 10：");
        history.printList();
        printStatistics(history);

        // 操作 3：尾端新增 40
        history.addLast(40);
        System.out.println("\n[操作 3] 尾端新增 40：");
        history.printList();
        printStatistics(history);

        // 操作 4：在中間插入/尾端新增 30 (此處用 addLast)
        history.addLast(30);
        System.out.println("\n[操作 4] 尾端新增 30：");
        history.printList();
        printStatistics(history);

        // 操作 5：搜尋數值 30 是否存在
        System.out.println("\n[操作 5] 搜尋數值 30：" + history.contains(30));

        // 操作 6：搜尋不存在的數值 99
        System.out.println("\n[操作 6] 搜尋數值 99（找不到測試）：" + history.contains(99));

        // 操作 7：刪除中間節點 (20)
        boolean removed20 = history.removeValue(20);
        System.out.println("\n[操作 7] 刪除節點 20 成功：" + removed20);
        history.printList();
        printStatistics(history);

        // 操作 8：刪除頭節點 (10)
        boolean removed10 = history.removeValue(10);
        System.out.println("\n[操作 8] 刪除頭節點 10 成功：" + removed10);
        history.printList();
        printStatistics(history);

    }

    private static void printStatistics(NumberHistoryList list) {
        System.out.println("  -> [統計] 節點數(Size): " + list.size());
        if (list.size() == 0) {
            System.out.println("  -> [統計] 總和: 0 | 最大值: 無 (空串列) | 最小值: 無 (空串列)");
        } else {
            System.out.println("  -> [統計] 總和: " + list.getSum() +
                    " | 最大值: " + list.getMax() +
                    " | 最小值: " + list.getMin());
        }
    }
}