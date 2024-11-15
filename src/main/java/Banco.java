import java.util.HashMap;
import java.util.Map;

public class Banco {
    private Map<String, Usuario> usuarios;

    public Banco() {
        this.usuarios = new HashMap<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.put(usuario.getCpf(), usuario);
    }

    public Usuario buscarUsuarioPorCpf(String cpf) {
        return usuarios.get(cpf);
    }

    public void adicionarConta(Usuario usuario, Conta conta) {
        usuario.adicionarConta(conta);
    }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }
}
