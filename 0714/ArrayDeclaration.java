public class ArrayDeclaration {
    public static void main(String[] args) {
        int[] scores = { 80, 75, 92, 68, 88 };

        String[] products = { "Keyboard", "Mouse", "Monitor" };

        System.out.println("第一筆成績：" + scores[0]);
        System.out.println("成績陣列長度：" + scores.length);
        System.out.println("第一項商品：" + products[0]);
    }
}