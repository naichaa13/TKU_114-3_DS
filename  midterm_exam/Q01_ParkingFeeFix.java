public class Q01_ParkingFeeFix {
    public static void main(String[] args) {
        int[] testMinutes = { -20, 30, 31, 60, 61, 120, 121, 420 };
        for (int minutes : testMinutes) {
            int fee = calculateFee(minutes);
            System.out.println("停車 " + minutes + " 分鐘，費用：" + fee + " 元");
        }
    }

    public static int calculateFee(int minutes) {
        if (minutes < 0) {
            return -1;
        }
        if (minutes <= 30) {
            return 0;
        }

        int fee;
        if (minutes <= 120) {
            int blocks = (minutes - 30 + 29) / 30;
            fee = blocks * 20;
        } else {
            int blocks = (minutes - 120 + 59) / 60;
            fee = 60 + blocks * 30;
        }

        if (fee > 180) {
            fee = 180;
        }
        return fee;
    }
}