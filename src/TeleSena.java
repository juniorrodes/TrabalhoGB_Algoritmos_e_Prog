import java.util.Arrays;

public class TeleSena {
    private static int retailValue = 10;
    private int[][] numbers = new int[2][25];

    public static int getRetailValue() {
        return retailValue;
    }

    public int[][] getNumbers() {
        return numbers;
    }

    public TeleSena(int[][] numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "TeleSena{" +
                "numbers[0]=" + Arrays.toString(numbers[0]) + '\n' +
                "numbers[1]=" + Arrays.toString(numbers[1]) + '\n' +
                '}';
    }
}
