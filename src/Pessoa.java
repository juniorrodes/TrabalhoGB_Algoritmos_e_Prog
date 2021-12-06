import java.util.Arrays;

public class Pessoa {
    private String name;
    private TeleSena[] teleSenas;
    private double prizeValue;
    private int totalTeleSenasWon;

    public String getName() {
        return name;
    }

    public void setPrizeValue(double prizeValue) {
        this.prizeValue = prizeValue;
    }

    public int getTotalTeleSenasWon() {
        return totalTeleSenasWon;
    }

    public TeleSena[] getTeleSenas() {
        return teleSenas;
    }

    public Pessoa(String name, int size) {
        this.name = name;
        this.teleSenas = new TeleSena[size];
        this.totalTeleSenasWon = 0;
        // para cada posição do vetor de telesenas, sortea valores dessa telesena
        // e checa se os valores são repetidos ou não, se for sortea novamente o valor
        for (int l = 0; l < size; l++) {
            int vec[][] = new int[2][25];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 25; j++) {
                    vec[i][j] = (int) (Math.random() * 60 + 1);
                    for (int k = 0; k < j; k++) {
                        if (vec[i][j] == vec[i][k]) {
                            j -= 1;
                            break;
                        }
                    }
                }
            }
            this.Sort(vec[0], 25);
            this.Sort(vec[1], 25);
            this.teleSenas[l] = new TeleSena(vec);
        }
    }

    // Checa se os numeros sorteados batem com os numeros das telesenas que a pessoa possui
    public boolean CheckNumbers(int drawNumber[]) {
        this.Sort(drawNumber, 25);

        for (int l = 0; l < this.teleSenas.length; l++) {
            boolean win1 = true, win2 = true;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 25; j++) {
                    if ((drawNumber[j] != this.teleSenas[l].getNumbers()[i][j]) && (i == 1)){
                        win2 = false;
                        break;
                    } else if (drawNumber[j] != this.teleSenas[l].getNumbers()[i][j]) {
                        win1 = false;
                        break;
                    }
                }
            }
            if (win1 || win2) {
                this.totalTeleSenasWon += 1;
            }
        }
        return this.totalTeleSenasWon >= 1;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "name='" + name + "\'\n" +
                ", teleSenas=" + Arrays.toString(teleSenas) + "\n" +
                ", prizeValue=" + prizeValue +
                '}';
    }

    // Função para fazer a ordenação de um vetor
    public static void Sort(int arr[], int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++)
        {
            swapped = false;
            for (j = 0; j < n - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    // swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // IF no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }
}
