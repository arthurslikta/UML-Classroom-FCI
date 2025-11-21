import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private int idade;
    private int IDcliente;
    private String login;
    private String senha; 
    private String endereco;

    private List<Pedido> historico = new ArrayList<>();

    public Pedido solicitarPedido(Produto produto, int quantidade) {
        Pedido p = new Pedido(produto, quantidade);
        historico.add(p);
        return p;
    }

    public List<Pedido> historicoCliente() {
        return historico;
    }

    public boolean atualizarEndereco(String novoEndereco) {
        if (novoEndereco == null || novoEndereco.isBlank()) return false;
        this.endereco = novoEndereco;
        return true;
    }

}
