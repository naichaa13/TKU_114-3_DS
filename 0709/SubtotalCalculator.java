public class SubtotalCalculator {
    public static void main(String[] args) {
        int subtotal = calculateSubtotal(10, 5);
        System.out.println("Subtotal: $" + subtotal);
    }

    public static int calculateSubtotal(int price, int quantity) {
        return price * quantity;
    }
}
