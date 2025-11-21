import java.util.HashMap;

public class BancoDeDados {

    private static HashMap<String, Cliente> clientes = new HashMap<>();
    private static HashMap<Integer, Produto> produtos = new HashMap<>();

    public static Cliente buscarCliente(String login, String senha) {
        Cliente c = clientes.get(login);
        if (c != null && c.getSenha().equals(senha)) return c;
        return null;
    }

    public static void salvarCliente(Cliente c) {
        clientes.put(c.getLogin(), c);
    }

    public static void salvarProduto(Produto p) {
        produtos.put(p.getIDproduto(), p);
    }
}
