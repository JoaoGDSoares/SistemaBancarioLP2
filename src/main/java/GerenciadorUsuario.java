public class GerenciadorUsuario {
    private Banco banco;

    public GerenciadorUsuario(Banco banco) {
        this.banco = banco;
    }

    public Usuario cadastrarUsuario(String nome, String cpf, String senha) {
        Usuario usuario = new Usuario(nome, cpf, senha);
        banco.adicionarUsuario(usuario);
        return usuario;
    }

    public Usuario autenticarUsuario(String cpf, String senha) {
        Usuario usuario = banco.buscarUsuarioPorCpf(cpf);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        }
        return null;
    }
}
