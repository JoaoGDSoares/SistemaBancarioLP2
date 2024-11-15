public class Conta {
    private String tipo;
    private double saldo;
    private String numero;
    private Usuario titular;

    public Conta(String tipo, double saldoInicial, String numero, Usuario titular) {
        this.tipo = tipo;
        this.saldo = saldoInicial;
        this.numero = numero;
        this.titular = titular;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        }
    }
}
