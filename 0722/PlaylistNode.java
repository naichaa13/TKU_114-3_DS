public class PlaylistNode {
    private String code;
    private String name;
    public PlaylistNode next;

    public PlaylistNode(String code, String name) {
        this.code = code.trim();
        this.name = name.trim();
        this.next = null;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "歌曲代碼: " + code + " | 歌曲名稱: " + name;
    }
}