import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        try {
            do {
                System.out.println("\nSISTEMA DE VEÍCULOS:");
                System.out.println("1. Adicionar Carro");
                System.out.println("2. Adicionar Moto");
                System.out.println("3. Atualizar Carro");
                System.out.println("4. Atualizar Moto");
                System.out.println("5. Exibir Lista de Carros e Motos");
                System.out.println("6. Sair");

                System.out.print("Escolha uma opção (1-6): ");

                try {
                    opcao = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.print("Erro: Insira um valor numérico de 1 a 6. Tente novamente.");
                    scanner.nextLine(); // Limpa o buffer do scanner
                    continue;
                }
                scanner.nextLine(); // Consumir a quebra de linha após o número
                System.out.println(" ");

                switch (opcao) {
                    case 1:
                        Carro novoCarro = Carro.criarCarro(scanner);
                        if (novoCarro != null) {
                            veiculos.add(novoCarro);
                            System.out.println("Carro adicionado com sucesso!");
                        }
                        break;

                    case 2:
                        Moto novaMoto = Moto.criarMoto(scanner);
                        if (novaMoto != null) {
                            veiculos.add(novaMoto);
                            System.out.println("Moto adicionada com sucesso!");
                        }
                        break;

                    case 3:
                        // Atualizar Carro
                        Carro.listarCarros(veiculos);
                        System.out.print("Escolha o número do Carro a ser atualizado: ");
                        int numeroCarroAtualizar = scanner.nextInt();
                        scanner.nextLine();

                        if (numeroCarroAtualizar > 0 && numeroCarroAtualizar <= veiculos.size()) {
                            Carro carroAtualizar = (Carro) veiculos.get(numeroCarroAtualizar - 1);
                            carroAtualizar.atualizarCarro(scanner);
                            System.out.println("Carro atualizado com sucesso!");
                        } else {
                            System.out.println("Número inválido. Tente novamente.");
                        }
                        break;

                    case 4:
                        // Atualizar Moto
                        Moto.listarMotos(veiculos); 
                        System.out.print("Escolha o número da Moto a ser atualizada: ");
                        int numeroMotoAtualizar = scanner.nextInt();
                        scanner.nextLine();

                        List<Moto> motos = veiculos.stream()
                                .filter(Moto.class::isInstance)
                                .map(Moto.class::cast)
                                .collect(Collectors.toList());

                        if (numeroMotoAtualizar > 0 && numeroMotoAtualizar <= motos.size()) {
                            Moto motoAtualizar = motos.get(numeroMotoAtualizar - 1);
                            motoAtualizar.atualizarMoto(scanner);
                            System.out.println("Moto atualizada com sucesso!");
                        } else {
                            System.out.println("Número inválido. Tente novamente.");
                        }
                        break;

                    case 5:
                        System.out.println("Lista de Carros e Motos:");
                        for (Veiculo veiculo : veiculos) {
                            System.out.println("------------------------");
                            veiculo.exibirInfo();
                        }
                        break;

                    case 6:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } while (opcao != 6);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
