public class Autenticacao {

    public boolean autenticacaoDeUsuario(String email, String senha) {
        return BancoDeDados.buscarCliente(email, senha) != null;
    }
}
