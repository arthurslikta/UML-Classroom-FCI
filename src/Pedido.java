import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private int quantidade;
    private Cliente cliente;
    private Produto produto;
    private Entrega entrega;
    private Drone drone;
    private Date dataPedido;
    private Pagamento pagamento;

    private static List<Pedido> pedidos = new ArrayList<>();

    public Pedido(int id, Cliente cliente, Produto produto, int quantidade, Entrega entrega, Drone drone) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade inválida.");
        }
        if (!drone.validarPeso(produto.getPeso() * quantidade)) {
            throw new IllegalArgumentException("Peso do pedido excede capacidade do drone.");
        }
        this.id = id;
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        this.entrega = entrega;
        this.drone = drone;
        this.dataPedido = new Date();
    }

    public int getId() { return id; }
    public int getQuantidade() { 
        return quantidade;
     }
    public Cliente getCliente() { 
        return cliente; 
    }
    public Produto getProduto() {
         return produto; 
        }
    public Entrega getEntrega() { 
        return entrega; 
    }
    public Drone getDrone() {
         return drone; 
        }
    public Pagamento getPagamento() { 
        return pagamento; 
    }

    public void setPagamento(Pagamento pagamento) { 
        this.pagamento = pagamento; 
    }

    public float valorTotal() { 
        return produto.getPreco() * quantidade; 
    }

    public static void addPedido(Pedido p) {
        pedidos.add(p); 
    }

    public static List<Pedido> listarPedidos() { 
        return pedidos; 
    }
}
