public class AufgabeB7A1 {

    public static int fibDyn(int n) {

        if (n == 0) return 0;
        if (n < 3) return 1;

        int x = 1;
        int temp = 1;
        int temp2;

        for (int i = 0; i < n - 2; i++) {
            temp2 = x;
            x += temp;
            temp = temp2;
        }

        return x;
    }

    public static void main(String[] args) {

        try {
            if (args.length == 1) {
                int k = Integer.parseInt(args[0]);
                System.out.println(fibDyn(k));
            }
        } catch (NumberFormatException e) {
            System.err.println("Test");
        }
    }
}
