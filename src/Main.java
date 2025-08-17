import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConectorApi conector = new ConectorApi();
        AnalisadorJson analisador = new AnalisadorJson();
        CalcularConversao calculadora = new CalcularConversao();

        String menu = """
                **************************************************
                Seja bem-vindo(a) ao Conversor de Moedas!
                
                Escolha a moeda de origem:
                1) ARS - Peso argentino
                2) BOB - Boliviano boliviano
                3) BRL - Real brasileiro
                4) CLP - Peso chileno
                5) COP - Peso colombiano
                6) USD - Dólar americano
                **************************************************
                """;

        while (true) {
            System.out.println(menu);
            System.out.println("Digite sua opção: ");
            var opcaoOrigem = scanner.nextInt();

            String moedaOrigem = obterCodigoMoeda(opcaoOrigem);
            if (moedaOrigem == null) continue;

            System.out.println("Escolha a moeda destino: ");
            var opcaoDestino = scanner.nextInt();
            String moedaDestino = obterCodigoMoeda(opcaoDestino);

            if (moedaDestino == null) continue;
            System.out.println("Digite o valor que deseja converter: ");
            double valor = scanner.nextDouble();


            try {
                String json = conector.buscarTaxasDeCambio(moedaOrigem);
                Moeda moeda = analisador.analisar(json);
                double valorConvertido = calculadora.calcular(moeda, moedaDestino, valor);

                System.out.printf("\n**************************************************\n");
                System.out.printf("O valor de %.2f %s corresponde a %.2f %s\n",
                        valor, moedaOrigem, valorConvertido, moedaDestino);
                System.out.printf("**************************************************\n\n");
            } catch (RuntimeException e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Por favor, tente novamente.");
            }

            System.out.println("\nDeseja realizar outra conversão?");
            System.out.print("1 - Continuar | 2 - Sair");
            int continuar = scanner.nextInt();
            if (continuar == 2) {
                System.out.println("Obrigado por usar o conversos. Até a próxima!");
                break;
            }
        }
        scanner.close();
    }

    private static String obterCodigoMoeda(int opcao) {
        return switch (opcao) {
            case 1 -> "ARS";
            case 2 -> "BOB";
            case 3 -> "BRL";
            case 4 -> "CLP";
            case 5 -> "COP";
            case 6 -> "USD";
            default -> {
                System.out.println("Opção inválida, tente novamente.");
                yield null;
            }
        };
    }
}
