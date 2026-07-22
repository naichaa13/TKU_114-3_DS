public class PlaylistLinkedList {
    private PlaylistNode head;
    private int size;

    public PlaylistLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    // 1. 尾端新增 (addLast) - 規則：歌曲代碼不可重複
    public boolean addLast(String code, String name) {
        if (code == null || code.trim().isEmpty() || findByCode(code) != null) {
            return false; // 代碼為空或已存在，拒絕新增
        }

        PlaylistNode newNode = new PlaylistNode(code, name);
        if (head == null) {
            head = newNode;
        } else {
            PlaylistNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    // 2. 依代碼搜尋
    public PlaylistNode findByCode(String code) {
        if (code == null)
            return null;
        PlaylistNode current = head;
        while (current != null) {
            if (current.getCode().equalsIgnoreCase(code.trim())) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // 3. 刪除指定代碼的歌曲 (支援第一首、中間、最後一首與空串列處理)
    public boolean removeByCode(String code) {
        if (head == null || code == null) {
            return false;
        }

        // 情況 A：刪除第一首 (head)
        if (head.getCode().equalsIgnoreCase(code.trim())) {
            head = head.next;
            size--;
            return true;
        }

        // 情況 B：刪除中間或最後一首
        PlaylistNode previous = head;
        PlaylistNode current = head.next;

        while (current != null) {
            if (current.getCode().equalsIgnoreCase(code.trim())) {
                previous.next = current.next; // 跨過當前節點，如果是最後一首，next 會變成 null
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }

        return false; // 找不到對應代碼
    }

    // 4. 顯示完整播放順序
    public void printPlaylist() {
        if (head == null) {
            System.out.println("播放清單目前是空的。");
            return;
        }

        PlaylistNode current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current);
            current = current.next;
            index++;
        }
    }
}