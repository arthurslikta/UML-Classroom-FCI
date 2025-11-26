public class PedidoDAOHash {

    public void salvar(Pedido p) {
        HashDatabase.pedidos.put(p.getId(), p);
    }

    public Pedido buscar(int id) {
        return HashDatabase.pedidos.get(id);
    }
}
