import java.util.Scanner;
import java.util.ArrayList;

public class Moto extends Veiculo {
    private boolean possuiPartidaEletrica;

    public Moto(String marca, String modelo, int ano, boolean possuiPartidaEletrica) {
        super(marca, modelo, ano);
        this.possuiPartidaEletrica = possuiPartidaEletrica;
    }

    public boolean isPossuiPartidaEletrica() {
        return possuiPartidaEletrica;
    }

    public void setPossuiPartidaEletrica(boolean possuiPartidaEletrica) {
        this.possuiPartidaEletrica = possuiPartidaEletrica;
    }

    public void atualizarMoto(Scanner scanner) {
        System.out.print("Nova marca da moto: ");
        setMarca(scanner.nextLine());

        System.out.print("Novo modelo da moto: ");
        setModelo(scanner.nextLine());

        System.out.print("Novo ano da moto: ");
        setAno(inputInteiro(scanner, "Número de ano deve ser um valor inteiro. Tente novamente."));

        System.out.print("A moto possui partida elétrica? (sim/nao): ");
        setPossuiPartidaEletrica(inputBoolean(scanner, "Responda com 'sim' se a moto possui partida elétrica ou 'nao' caso contrário. Tente novamente."));
    }

    public static Moto criarMoto(Scanner scanner) {
        System.out.print("Digite a marca da moto: ");
        String marcaMoto = scanner.nextLine();

        System.out.print("Digite o modelo da moto: ");
        String modeloMoto = scanner.nextLine();

        System.out.print("Digite o ano da moto: ");
        int anoMoto = inputInteiro(scanner, "Número de ano deve ser um valor inteiro. Digite novamente.");

        System.out.print("A moto possuí partida eletrica (sim/nao):  ");
        boolean possuiPartidaEletricaMoto = inputBoolean(scanner, "Responda com 'sim' se a moto possui partida elétrica ou 'nao' caso contrário. Digite novamente.");

        return new Moto(marcaMoto, modeloMoto, anoMoto, possuiPartidaEletricaMoto);
    }

    private static int inputInteiro(Scanner scanner, String errorMessage) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erro: " + errorMessage);
            }
        }
    }

    private static boolean inputBoolean(Scanner scanner, String errorMessage) {
        while (true) {
            try {
                String entrada = scanner.nextLine().toLowerCase();
                if (entrada.equals("sim")) {
                    return true;
                } else if (entrada.equals("nao")) {
                    return false;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + errorMessage);
            }
        }
    }

    @Override
    public void exibirInfo() {
        System.out.println("Moto");
        super.exibirInfo();
        System.out.println("Possui Partida Elétrica: " + (possuiPartidaEletrica ? "Sim" : "Não"));
    }

    public static void listarMotos(ArrayList<Veiculo> veiculos) {
        int numeroVeiculo = 1;
        for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof Moto) {
                System.out.println(numeroVeiculo + ". " + veiculo.getMarca() + " " + veiculo.getModelo());
                numeroVeiculo++;
            }
        }
    }
}
