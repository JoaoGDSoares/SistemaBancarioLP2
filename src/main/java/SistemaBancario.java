import java.util.Scanner;
import java.util.Random;

public class SistemaBancario {
    public static void main(String[] args) {
        Banco banco = new Banco();
        GerenciadorUsuario gerenciadorUsuario = new GerenciadorUsuario(banco);
        GerenciadorConta gerenciadorConta = new GerenciadorConta(banco);
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("=== Menu do Sistema Bancário ===");
            System.out.println("1. Cadastrar Usuário e Conta");
            System.out.println("2. Autenticar Usuário");
            System.out.println("3. Consultar Saldo");
            System.out.println("4. Realizar Depósito");
            System.out.println("5. Realizar Saque");
            System.out.println("6. Realizar Transferência");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do usuário: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o CPF do usuário: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Digite a senha do usuário: ");
                    String senha = scanner.nextLine();
                    Usuario usuario = gerenciadorUsuario.cadastrarUsuario(nome, cpf, senha);

                    String numeroConta = String.format("%05d", random.nextInt(100000));
                    System.out.print("Digite o tipo da conta (Corrente/Poupança): ");
                    String tipoConta = scanner.nextLine();
                    System.out.print("Digite o saldo inicial da conta: ");
                    double saldoInicial = scanner.nextDouble();
                    scanner.nextLine(); // Consumir nova linha
                    Conta novaConta = gerenciadorConta.cadastrarConta(cpf, tipoConta, saldoInicial, numeroConta);

                    if (novaConta != null) {
                        System.out.println("Usuário e conta cadastrados com sucesso!");
                        System.out.println("Número da Conta: " + numeroConta);
                    } else {
                        System.out.println("Erro ao cadastrar conta.");
                    }
                    break;
                case 2:
                    System.out.print("Digite o CPF para login: ");
                    String cpfLogin = scanner.nextLine();
                    System.out.print("Digite a senha para login: ");
                    String senhaLogin = scanner.nextLine();
                    Usuario usuarioAutenticado = gerenciadorUsuario.autenticarUsuario(cpfLogin, senhaLogin);
                    if (usuarioAutenticado != null) {
                        System.out.println("Usuário autenticado com sucesso!");
                    } else {
                        System.out.println("CPF ou senha incorretos.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o número da conta: ");
                    String numeroContaConsulta = scanner.nextLine();
                    Conta contaConsulta = gerenciadorConta.buscarConta(numeroContaConsulta);
                    if (contaConsulta != null) {
                        System.out.println("Saldo da conta: " + contaConsulta.getSaldo());
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o número da conta para depósito: ");
                    String numeroContaDeposito = scanner.nextLine();
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine(); // Consumir nova linha
                    if (gerenciadorConta.realizarDeposito(numeroContaDeposito, valorDeposito)) {
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 5:
                    System.out.print("Digite o número da conta para saque: ");
                    String numeroContaSaque = scanner.nextLine();
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine(); // Consumir nova linha
                    if (gerenciadorConta.realizarSaque(numeroContaSaque, valorSaque)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente ou conta não encontrada.");
                    }
                    break;
                case 6:
                    System.out.print("Digite o número da conta de origem: ");
                    String numeroContaOrigem = scanner.nextLine();
                    System.out.print("Digite o número da conta de destino: ");
                    String numeroContaDestino = scanner.nextLine();
                    System.out.print("Digite o valor da transferência: ");
                    double valorTransferencia = scanner.nextDouble();
                    scanner.nextLine(); // Consumir nova linha
                    if (gerenciadorConta.realizarTransferencia(numeroContaOrigem, numeroContaDestino, valorTransferencia)) {
                        System.out.println("Transferência realizada com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente ou conta não encontrada.");
                    }
                    break;
                case 7:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
