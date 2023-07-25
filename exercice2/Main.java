public class Main {
    private static final String CHAUSSETTES = "Chausettes";
    private static final String SALES = "Sales";

    public static void main(String[] args) {
        if (args.length > 0) {
            switch (args[0]) {
                case "--help":
                    printUsage();
                    break;
                case "test":
                    runTests();
                    break;
                default:
                    System.out.println("Invalid option. Please refer to the usage information.");
            }
        } else {
            for (int i = 1; i <= 100; i++) {
                System.out.println(checkNumber(i));
            }
        }
    }

    /**
     * Checks a given number for multiples of 3 and 5 and constructs the result string.
     *
     * @param num The number to be checked.
     * @return The result string with "Chausettes" if the number is a multiple of 3,
     *         "Sales" if the number is a multiple of 5, "ChausettesSales" if the number is
     *         a multiple of both 3 and 5, or the number itself as a string.
     */
    public static String checkNumber(int num) {
        StringBuilder result = new StringBuilder();

        if (num % 3 == 0) {
            result.append(CHAUSSETTES);
        }

        if (num % 5 == 0) {
            result.append(SALES);
        }

        return result.length() > 0 ? result.toString() : String.valueOf(num);
    }

    // Test Methods
    public static void runTests() {
        try {
            testMultiplesOf3();
            testMultiplesOf5();
            testMultiplesOfBoth();
            testNonMultiples();
            System.out.println("All tests passed successfully!");
        } catch (AssertionError e) {
            System.err.println("Test failed: " + e.getMessage());
        }
    }

    public static void testMultiplesOf3() {
        assertEquals(CHAUSSETTES, checkNumber(3));
        assertEquals(CHAUSSETTES, checkNumber(6));
        assertEquals(CHAUSSETTES, checkNumber(9));
    }

    public static void testMultiplesOf5() {
        assertEquals(SALES, checkNumber(5));
        assertEquals(SALES, checkNumber(10));
        assertEquals(SALES, checkNumber(20));
    }

    public static void testMultiplesOfBoth() {
        assertEquals(CHAUSSETTES + SALES, checkNumber(15));
        assertEquals(CHAUSSETTES + SALES, checkNumber(30));
        assertEquals(CHAUSSETTES + SALES, checkNumber(45));
    }

    public static void testNonMultiples() {
        assertEquals("1", checkNumber(1));
        assertEquals("2", checkNumber(2));
        assertEquals("4", checkNumber(4));
    }

    private static void assertEquals(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("Expected: " + expected + ", but got: " + actual);
        }
    }

    public static void printUsage() {
        System.out.println("Usage: java Main [option]");
        System.out.println("Options:");
        System.out.println("  --help : Display this usage information");
        System.out.println("  test   : Run the test cases");
        System.out.println("  (none) : Print Chausettes, Sales, ChausettesSales, or the number");
    }
}
