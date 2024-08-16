import java.util.Random;

public class Campeonato {
    private Clube[] clubes;
    private int numeroClubes;

    public Campeonato(int quantidadeClubes) {
        clubes = new Clube[quantidadeClubes];
        numeroClubes = 0;
    }

    public void adicionarClube(Clube clube) {
        clubes[numeroClubes] = clube;
        numeroClubes++;
    }

    public void jogarCampeonato() {
        System.out.println("\n>>>>>>>>>>>>><<<<<<<<<<<<<");
        System.out.println("Confrontos do Campeonato:");
        System.out.println(">>>>>>>>>>>>><<<<<<<<<<<<<\n");
        System.out.println("--------------------------------");

        for (int i = 0; i < numeroClubes; i++) {
            for (int j = i + 1; j < numeroClubes; j++) {
                jogarPartida(clubes[i], clubes[j]);
                jogarPartida(clubes[j], clubes[i]);
                System.out.println("--------------------------------");
            }
        }

        System.out.println(getClassificacao());
        System.out.println("       {}     ");
        System.out.println("      /__\\    ");
        System.out.println("    /|    |\\  ");
        System.out.println("   (_|    |_) ");
        System.out.println("      \\  /    ");
        System.out.println("       )(     ");
        System.out.println("     _|__|_   ");
        System.out.println("   _|______|_ ");
        System.out.println("  |__________|\n");
        System.out.println("GRANDE CAMPEÃO: " + getCampeao() + ".");
    }

    private void jogarPartida(Clube primeiroClube, Clube segundoClube) {
        Random random = new Random();
        int golsPrimeiroClube = random.nextInt(6);
        int golsSegundoClube = random.nextInt(6);

        System.out.println(primeiroClube.nome + " " + golsPrimeiroClube + " x " + golsSegundoClube + " " + segundoClube.nome);

        if (golsPrimeiroClube > golsSegundoClube) {
            primeiroClube.ganhar(golsPrimeiroClube - golsSegundoClube);
            segundoClube.perder(golsPrimeiroClube - golsSegundoClube);
        } else if (golsSegundoClube > golsPrimeiroClube) {
            segundoClube.ganhar(golsSegundoClube - golsPrimeiroClube);
            primeiroClube.perder(golsSegundoClube - golsPrimeiroClube);
        } else {
            primeiroClube.empatar();
            segundoClube.empatar();
        }
    }

    public String getClassificacao() {
        Clube[] clubesOrdenados = new Clube[numeroClubes];

        for (int i = 0; i < numeroClubes; i++) {
            clubesOrdenados[i] = clubes[i];
        }

        for (int i = 0; i < clubesOrdenados.length - 1; i++) {
            for (int j = 0; j < clubesOrdenados.length - 1 - i; j++) {
                Clube clubeX = clubesOrdenados[j];
                Clube clubeY = clubesOrdenados[j + 1];

                if (clubeX.pontos < clubeY.pontos || (clubeX.pontos == clubeY.pontos && clubeX.saldoGols < clubeY.saldoGols)) {
                    Clube liderTemporario = clubesOrdenados[j];
                    clubesOrdenados[j] = clubesOrdenados[j + 1];
                    clubesOrdenados[j + 1] = liderTemporario;
                }
            }
        }

        String resultado = "\n>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<\n" + "Classificação Final do Campeonato:" + "\n>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<\n\n";

        for (int i = 0; i < clubesOrdenados.length; i++) {
            Clube clube = clubesOrdenados[i];
            resultado += clube.nome + " - Pontos: " + clube.pontos + ", Saldo de Gols: " + clube.saldoGols + "\n------------------------------------------\n";
        }

        return resultado;
    }

    public String getCampeao() {
        Clube campeao = clubes[0];

        for (int i = 1; i < numeroClubes; i++) {
            if (clubes[i].pontos > campeao.pontos || (clubes[i].pontos == campeao.pontos && clubes[i].saldoGols > campeao.saldoGols)) {
                campeao = clubes[i];
            }
        }

        return campeao.nome;
    }
}