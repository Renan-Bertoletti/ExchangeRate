import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("***************************************************************************");
            System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real");
            System.out.println("4) Real =>> Dólar");
            System.out.println("5) Euro =>> Real");
            System.out.println("6) Real =>> Euro");
            System.out.println("7) Sair");
            System.out.println("Escolha uma opção válida:");
            System.out.println("***************************************************************************");

            int opcao = sc.nextInt();

            if (opcao == 7) {
                System.out.println("Programa encerrado.");
                break;
            }

            if (opcao < 1 || opcao > 7) {
                System.out.println("Opção inválida! Tente novamente.\n");
                continue;
            }

            System.out.print("Digite o valor que deseja converter: ");
            double valor = sc.nextDouble();

            try {
                double taxa;
                double convertido;

                switch (opcao) {

                    case 1:
                        taxa = ExchangeRate.getRate("USD", "ARS");
                        convertido = valor * taxa;
                        System.out.printf("%.2f dólares equivalem a %.2f pesos argentinos\n\n", valor, convertido);
                        break;

                    case 2:
                        taxa = ExchangeRate.getRate("ARS", "USD");
                        convertido = valor * taxa;
                        System.out.printf("%.2f pesos argentinos equivalem a %.2f dólares\n\n", valor, convertido);
                        break;

                    case 3:
                        taxa = ExchangeRate.getRate("USD", "BRL");
                        convertido = valor * taxa;
                        System.out.printf("%.2f dólares equivalem a %.2f reais\n\n", valor, convertido);
                        break;

                    case 4:
                        taxa = ExchangeRate.getRate("BRL", "USD");
                        convertido = valor * taxa;
                        System.out.printf("%.2f reais equivalem a %.2f dólares\n\n", valor, convertido);
                        break;

                    case 5:
                        taxa = ExchangeRate.getRate("EUR", "BRL");
                        convertido = valor * taxa;
                        System.out.printf("%.2f euros equivalem a %.2f reais\n\n", valor, convertido);
                        break;

                    case 6:
                        taxa = ExchangeRate.getRate("BRL", "EUR");
                        convertido = valor * taxa;
                        System.out.printf("%.2f reais equivalem a %.2f euros\n\n", valor, convertido);
                        break;

                    default:
                        System.out.println("Opção inválida.\n");
                }

            } catch (Exception e) {
                System.out.println("Erro ao realizar a conversão: " + e.getMessage() + "\n");
            }
        }

        sc.close();
    }
}
