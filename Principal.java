
    import br.com.alura.ConversorDeMoeda.ConversorDeMoeda;

    import java.util.Scanner;

    public class Principal {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("\n*****************************************************");
                System.out.println("Seja bem-vindo/a ao conversor de moeda\n");
                System.out.println("1:) Dólar =>> Peso Argentino");
                System.out.println("2:) Peso Argentino =>> Dólar");
                System.out.println("3:) Dólar =>> Real Brasileiro");
                System.out.println("4:) Real Brasileiro =>> Dólar");
                System.out.println("5:) Dólar =>> Peso Colombiano");
                System.out.println("6:) Peso Colombiano =>> Dólar");
                System.out.println("7:) Sair");
                System.out.println("\nEscolha uma opção válida:");
                System.out.println("*****************************************************");

                int option = scanner.nextInt();

                try {
                    switch (option) {
                        case 1:
                            realizarConversao("USD", "ARS", scanner);
                            break;
                        case 2:
                            realizarConversao("ARS", "USD", scanner);
                            break;
                        case 3:
                            realizarConversao("USD", "BRL", scanner);
                            break;
                        case 4:
                            realizarConversao("BRL", "USD", scanner);
                            break;
                        case 5:
                            realizarConversao("USD", "COP", scanner);
                            break;
                        case 6:
                            realizarConversao("COP", "USD", scanner);
                            break;
                        case 7:
                            System.out.println("Saindo... Obrigado por usar o conversor de moeda!");
                            running = false;
                            break;
                        default:
                            System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    }
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }

            scanner.close();
        }

        private static void realizarConversao(String de, String para, @org.jetbrains.annotations.NotNull Scanner scanner) throws Exception {
            System.out.printf("Digite o valor em %s: ", de);
            double valor = scanner.nextDouble();
            double taxa = ConversorDeMoeda.obterTaxaDeCambio(de, para);
            double convertido = ConversorDeMoeda.converter(valor, taxa);
            System.out.printf("%.2f %s é igual a %.2f %s\n", valor, de, convertido, para);
        }
    }


