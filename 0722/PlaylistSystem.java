public class PlaylistSystem {
    public static void main(String[] args) {
        PlaylistLinkedList playlist = new PlaylistLinkedList();

        System.out.println("=== 1. 測試空串列狀態 ===");
        playlist.printPlaylist();

        System.out.println("\n=== 2. 測試尾端新增歌曲 (S01, S02, S03, S04) ===");
        playlist.addLast("S01", "周杰倫 - 晴天");
        playlist.addLast("S02", "林俊傑 - 江南");
        playlist.addLast("S03", "五月天 - 溫柔");
        playlist.addLast("S04", "周興哲 - 以後別做朋友");
        playlist.printPlaylist();
        System.out.println("目前清單總數：" + playlist.size());

        System.out.println("\n=== 3. 測試拒絕重複代碼 (嘗試新增 S02) ===");
        boolean addDuplicate = playlist.addLast("S02", "重複的歌曲");
        System.out.println("新增結果 (應為 false)：" + addDuplicate);

        System.out.println("\n=== 4. 測試依代碼搜尋 ===");
        PlaylistNode found = playlist.findByCode("S03");
        if (found != null) {
            System.out.println("搜尋成功：" + found);
        } else {
            System.out.println("查無此歌曲。");
        }

        System.out.println("\n=== 5. 測試刪除第一首 (S01) ===");
        playlist.removeByCode("S01");
        playlist.printPlaylist();

        System.out.println("\n=== 6. 測試刪除最後一首 (S04) ===");
        playlist.removeByCode("S04");
        playlist.printPlaylist();

        System.out.println("\n=== 7. 測試刪除不存在的代碼 (S99) ===");
        boolean removeMissing = playlist.removeByCode("S99");
        System.out.println("刪除結果 (應為 false)：" + removeMissing);

        System.out.println("\n=== 8. 最終播放清單狀態 ===");
        playlist.printPlaylist();
        System.out.println("最終清單總數：" + playlist.size());
    }
}