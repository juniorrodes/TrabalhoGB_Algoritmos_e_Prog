import java.util.Arrays;

public class Principal {

    public static void main(String[] args) {
        ControleTeleSena controleTeleSena = new ControleTeleSena();

        controleTeleSena.SellTeleSena();

        controleTeleSena.Draw();

        System.out.println("Números sorteados na Tele Sena: " + Arrays.toString(controleTeleSena.getDraw()));

        System.out.println("Quantidade de Tele Senas vendidas: " + controleTeleSena.getTotalSold());

        System.out.println("Quantidade de ganhadores: " + controleTeleSena.getTotalWinners());

        System.out.println("\nNome dos ganhadores: ");
        for (int i = 0; i < 20; i++) {
            if (controleTeleSena.getPessoas()[i].getTotalTeleSenasWon() > 0) {
                System.out.println(controleTeleSena.getPessoas()[i].getName());
            }
        }
        System.out.println("");

        System.out.println("Valor do prêmio para cada ganhador: " + String.format("%.2f", controleTeleSena.getWinnersPrize()));

        System.out.println("Valor total das Tele Senas vendidas: " + String.format("%.2f", (double)(controleTeleSena.getTotalSold() * TeleSena.getRetailValue())));

        System.out.println("Lucro: " + String.format("%.2f", controleTeleSena.getReturnValue()));
    }
}
