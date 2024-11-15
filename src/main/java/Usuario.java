import java.util.HashMap;
import java.util.Map;

public class Usuario {
    private String nome;
    private String cpf;
    private String senha;
    private Map<String, Conta> contas;

    public Usuario(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.contas = new HashMap<>();
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void adicionarConta(Conta conta) {
        contas.put(conta.getNumero(), conta);
    }

    public Map<String, Conta> getContas() {
        return contas;
    }
}
