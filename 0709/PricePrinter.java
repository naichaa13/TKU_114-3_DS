public class PricePrinter {
    public static void main(String[] args) {
        printItem("Banana", 2);
        printItem("Orange", 4);
    }

    public static void printItem(String itemName, int price) {
        System.out.println("Price: $" + price);

    }
}
