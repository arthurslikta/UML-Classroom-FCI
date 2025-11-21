import java.util.Date;

public class Pedido {

    private int IDpedido;
    private Date dataPedido = new Date();
    private int quantidade;
    private double valorTotal;

    private Produto produto;
    private String status = "pendente";

    public Pedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        calcularValorTotal();
    }

    public double calcularValorTotal() {
        this.valorTotal = produto.getPreco() * quantidade;
        return valorTotal;
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }

    public Produto getProduto() { return produto; }
    public double getValorTotal() { return valorTotal; }
}
