import java.util.HashMap;

public class HashDatabase{

    public static HashMap<Integer, Cliente> clientes = new HashMap<>();
    public static HashMap<Integer, Produto> produtos = new HashMap<>();
    public static HashMap<Integer, Pedido> pedidos = new HashMap<>();
    public static HashMap<Integer, ProdutoPedido> produtoPedidos = new HashMap<>();
    public static HashMap<Integer, Drone> drones = new HashMap<>();
    public static HashMap<Integer, Entrega> entregas = new HashMap<>();
}
