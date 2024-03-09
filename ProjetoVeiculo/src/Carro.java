import java.util.Scanner;
import java.util.ArrayList;

public class Carro extends Veiculo {
    private int numPortas;
    private String tipoCombustivel;

    public Carro(String marca, String modelo, int ano, int numPortas, String tipoCombustivel) {
        super(marca, modelo, ano);
        this.numPortas = numPortas;
        this.tipoCombustivel = tipoCombustivel;
    }

    public int getNumPortas() {
        return numPortas;
    }

    public void setNumPortas(int numPortas) {
        this.numPortas = numPortas;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public void atualizarCarro(Scanner scanner) {
        System.out.print("Nova marca do carro: ");
        setMarca(scanner.nextLine());

        System.out.print("Novo modelo do carro: ");
        setModelo(scanner.nextLine());

        System.out.print("Novo ano do carro: ");
        setAno(inputInteiro(scanner, "Número de ano deve ser um valor inteiro. Tente novamente."));

        System.out.print("Novo número de portas do carro: ");
        setNumPortas(inputInteiro(scanner, "O número de portas deve ser um valor inteiro. Tente novamente."));

        System.out.print("Novo tipo de combustível do carro: ");
        setTipoCombustivel(scanner.nextLine());
    }

    public static Carro criarCarro(Scanner scanner) {
        System.out.print("Digite a marca do carro: ");
        String marcaCarro = scanner.nextLine();

        System.out.print("Digite o modelo do carro: ");
        String modeloCarro = scanner.nextLine();

        System.out.print("Digite o ano do carro: ");
        int anoCarro = inputInteiro(scanner, "Número de ano deve ser um valor inteiro. Digite novamente.");

        System.out.print("Digite o nímero de portas do carro: ");
        int numPortasCarro = inputInteiro(scanner, "O número de portas deve ser um valor inteiro. Digite novamente.");

        System.out.print("Tipo de combustível do carro: ");
        String tipoCombustivelCarro = scanner.nextLine();

        return new Carro(marcaCarro, modeloCarro, anoCarro, numPortasCarro, tipoCombustivelCarro);
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

    @Override
    public void exibirInfo() {
        System.out.println("Carro");
        super.exibirInfo();
        System.out.println("Ano do carro: " + getAno());
        System.out.println("Número de Portas: " + numPortas);
        System.out.println("Tipo de Combustível: " + tipoCombustivel);
    }

    public static void listarCarros(ArrayList<Veiculo> veiculos) {
        System.out.println("Lista de Carros:");
        int numeroCarro = 1;
        for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof Carro) {
                System.out.println(numeroCarro + ". " + veiculo.getMarca() + " " + veiculo.getModelo());
                numeroCarro++;
            }
        }
    }
}
