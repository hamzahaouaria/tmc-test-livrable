public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            StringBuffer result = new StringBuffer();

            if (i % 3 == 0) {
                result.append("Chausettes");
            }

            if (i % 5 == 0) {
                result.append("Sales");
            }

            System.out.println(result.length() > 0 ? result.toString() : i);
        }
    }
}
