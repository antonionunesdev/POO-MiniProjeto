import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        int quantidadeClubes;
        Scanner entrada = new Scanner(System.in);

        System.out.println("\nInsira a quantidade de clubes que o seu campeonato terá:");
        quantidadeClubes = entrada.nextInt();
        entrada.nextLine();

        Campeonato campeonato = new Campeonato(quantidadeClubes);

        for (int i = 0; i < quantidadeClubes; i++) {
            System.out.println("Insira o nome do " + (i + 1) + "° clube do seu campeonato:");
            String nomeClube = entrada.nextLine();
            Clube clube = new Clube(nomeClube);
            campeonato.adicionarClube(clube);
        }

        entrada.close();

        System.out.println("\n   ____    _    __  __ ____  _____ ___  _   _    _  _____ ___  ");
        System.out.println("  / ___|  / \\  |  \\/  |  _ \\| ____/ _ \\| \\ | |  / \\|_   _/ _ \\ ");
        System.out.println(" | |     / _ \\ | |\\/| | |_) |  _|| | | |  \\| | / _ \\ | || | | |");
        System.out.println(" | |___ / ___ \\| |  | |  __/| |__| |_| | |\\  |/ ___ \\| || |_| |");
        System.out.println("  \\____/_/   \\_\\_|  |_|_|   |_____\\___/|_| \\_/_/   \\_\\_| \\___/ \n");

        campeonato.jogarCampeonato();
    }
}
