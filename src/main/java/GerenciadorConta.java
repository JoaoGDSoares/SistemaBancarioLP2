public class GerenciadorConta {
    private Banco banco;

    public GerenciadorConta(Banco banco) {
        this.banco = banco;
    }

    public Conta cadastrarConta(String cpfUsuario, String tipoConta, double saldoInicial, String numeroConta) {
        Usuario usuario = banco.buscarUsuarioPorCpf(cpfUsuario);
        if (usuario != null) {
            Conta conta = new Conta(tipoConta, saldoInicial, numeroConta, usuario);
            banco.adicionarConta(usuario, conta);
            return conta;
        }
        return null;
    }

    public Conta buscarConta(String numeroConta) {
        for (Usuario usuario : banco.getUsuarios().values()) {
            for (Conta conta : usuario.getContas().values()) {
                if (conta.getNumero().equals(numeroConta)) {
                    return conta;
                }
            }
        }
        return null;
    }

    public boolean realizarDeposito(String numeroConta, double valor) {
        Conta conta = buscarConta(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
            return true;
        }
        return false;
    }

    public boolean realizarSaque(String numeroConta, double valor) {
        Conta conta = buscarConta(numeroConta);
        if (conta != null && conta.getSaldo() >= valor) {
            conta.sacar(valor);
            return true;
        }
        return false;
    }

    public boolean realizarTransferencia(String numeroContaOrigem, String numeroContaDestino, double valor) {
        Conta contaOrigem = buscarConta(numeroContaOrigem);
        Conta contaDestino = buscarConta(numeroContaDestino);
        if (contaOrigem != null && contaDestino != null && contaOrigem.getSaldo() >= valor) {
            contaOrigem.sacar(valor);
            contaDestino.depositar(valor);
            return true;
        }
        return false;
    }
}
