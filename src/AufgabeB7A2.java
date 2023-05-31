import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class AufgabeB7A2 {

        public static void main(String[] args) {

            int[] input = getInput(new Scanner(System.in));

            int[]temp = new int[(input.length)/2];
            int[]temp2 = new int[(input.length)/2];

            int count = 0;

            for (int i = 0; i < input.length; i++) {
                if (i < (input.length / 2)) {
                    temp[i] = input[i];
                } else {
                    temp2[count] = input[i];
                    count++;
                }
            }
            knapsack(temp,temp2,Integer.parseInt(args[0]));
        }

        public static int[] getInput(Scanner scanner) throws NumberFormatException {

            ArrayList<String> dataList = new ArrayList<>();
            String temp;
            while (scanner.hasNext()) {
                temp = scanner.nextLine();
                if (temp.equals("")) {
                    dataList.add(null);
                } else {
                    try {
                    Integer.parseInt(temp);
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("Keine Ganzzahl Eingabe");
                    }
                    dataList.add(temp);
                }
            }
            scanner.close();

            if (dataList.size() == 0) {
                throw new NumberFormatException();
            }

            String[] data = new String[dataList.size()];
            for (int i = 0; i < dataList.size(); i++) {
                data[i] = dataList.get(i);
            }

            System.out.println(Arrays.toString(data));

            boolean whitespace = false;

            for (int i = 0; i < data.length; i++) {
                if (data[i] == null) {
                    if (whitespace) {
                        throw new IllegalArgumentException(" Input did not end after second list");
                    } else {
                        whitespace = true;
                    }
                }
            }
            int count = 0;
            while (data[count] != null) {
                count++;
            }

            if ((data.length - 1)/2 != count) {
                throw new IllegalArgumentException("The number of values does not match the number of weights.");
            }

            int[] integerData = new int[data.length - 1];

            whitespace = false;

            for (int i = 0; i < data.length; i++) {
                if (data[i] == null) {
                    whitespace = true;
                } else if (!whitespace) {
                    integerData[i] = Integer.parseInt(data[i]);
                } else {
                    integerData[i - 1] = Integer.parseInt(data[i]);
                }
            }

            System.out.println(Arrays.toString(integerData));

            return integerData;
        }

        public static int[][] knapsack (int[] values, int[] weights, int capacity) {
            int[][] result = new int[values.length + 1][capacity + 1];
            for (int i = 0; i <= values.length; i++) {
                for (int j = 0; j <= capacity; j++) {
                    if (i == 0 || j == 0) {
                        result[i][j] = 0;
                    } else if (weights[i - 1] <= j) {
                        result[i][j] = Math.max(values[i-1] + result[i-1][j - weights[i - 1]],result[i - 1][j]);
                    } else {
                        result[i][j] = result[i - 1][j];
                    }
                }
            }

            for (int i = 0; i <= weights.length; i++) {
                System.out.println(Arrays.toString(result[i]));
            }
            System.out.println(result[values.length][capacity]);

            return result;
        }
}