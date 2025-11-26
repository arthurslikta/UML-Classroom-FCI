public class ProdutoPedidoDAOHash {

    public void salvar(ProdutoPedido pp) {
        HashDatabase.produtoPedidos.put(pp.getId(), pp);
    }
}
