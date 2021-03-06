import java.util.Arrays;

public class ControleTeleSena {
    private Pessoa[] pessoas;
    private static String[] nomes = {"José","Sieg","Camila","Lucas","Daniel","Helena","Isadora","Carolina","Rodrigo","Samuel","Arthur","Vinicius","Renata","Fernanda","Roberta","Marcos","Werner","Tiago","Eduardo","Tiago"};
    private int totalWinners;
    private int totalSold;
    private int draw[];
    private double prizePool;
    private double winnersPrize;
    private double returnValue;

    public Pessoa[] getPessoas() {
        return pessoas;
    }

    public void setPessoas(Pessoa[] pessoas) {
        this.pessoas = pessoas;
    }

    public int getTotalWinners() {
        return totalWinners;
    }

    public void setTotalWinners(int totalWinners) {
        this.totalWinners = totalWinners;
    }

    public int getTotalSold() {
        return totalSold;
    }

    public void setTotalSold(int totalSold) {
        this.totalSold = totalSold;
    }

    public int[] getDraw() {
        return draw;
    }

    public void setDraw(int[] draw) {
        this.draw = draw;
    }

    public double getWinnersPrize() {
        return winnersPrize;
    }

    public void setWinnersPrize(double winnersPrize) {
        this.winnersPrize = winnersPrize;
    }

    public double getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(double returnValue) {
        this.returnValue = returnValue;
    }

    public ControleTeleSena() {
        this.pessoas = new Pessoa[20];
        this.totalWinners = 0;
        this.totalSold = 0;
        this.draw = new int[25];
        this.prizePool = 0;
        this.winnersPrize = 0;
        this.returnValue = 0;
    }

    // Função responsavel pelo controle de venda das telesenas
    public void SellTeleSena() {
        for(int i = 0; i < 20; i++) {
            int nameIndex = (int) (Math.random() * 20);
            int teleSenasOwned = (int) (Math.random() * 15 + 1);
            totalSold += teleSenasOwned;

            pessoas[i] = new Pessoa(nomes[nameIndex], teleSenasOwned);
        }
        // para teste atribui ao atributo de sorteio os valores que alguma pessoa possui
//        this.draw = this.pessoas[2].getTeleSenas()[0].getNumbers()[0];
        this.prizePool = (totalSold * TeleSena.getRetailValue()) * 0.8f;
        this.returnValue = (totalSold * TeleSena.getRetailValue()) * 0.2f;
    }

    // Função que fará o sorteio dos números
    // (Não está gerando nenhuma sequência que alguma pessoa possui)
    public void Draw() {
        for (int i = 0; i < 25; i++) {
            draw[i] = (int) (Math.random() * 60 + 1);
            for (int k = 0; k < i; k++) {
                if (draw[i] == draw[k]) {
                    i -= 1;
                    break;
                }
            }
        }


        for (int i = 0; i < 20; i++) {
            if(pessoas[i].CheckNumbers(draw)) {
                this.totalWinners += 1;
            }
        }
        int i = 0;
        // algum problema com o sorteio de novos numeros
        while (this.totalWinners < 1) {
            draw[i] = (int) (Math.random() * 60 + 1);
            for (int k = 0; k < 25; k++) {
                if ((draw[i] == draw[k]) && (i != k)) {
                    draw[i] = (int) (Math.random() * 60 + 1);
                    k = 0;
                }
            }
            for (int j = 0; j < 20; j++) {
                if(pessoas[j].CheckNumbers(draw)) {
                    this.totalWinners += 1;
                }
            }
            i = i >= 24 ? 0 : i + 1;
        }

        this.winnersPrize = this.prizePool / totalWinners;

        this.SetPrizeMoney();
    }

    private void SetPrizeMoney() {
        for (int i = 0; i < 20; i++) {
            if(this.pessoas[i].getTotalTeleSenasWon() > 0) {
                this.pessoas[i].setPrizeValue(this.winnersPrize);
            }
        }
    }
}
