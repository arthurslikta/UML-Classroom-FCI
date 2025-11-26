public class ProdutoDAOHash {

    public void salvar(Produto p) {
        HashDatabase.produtos.put(p.getId(), p);
    }

    public Produto buscar(int id) {
        return HashDatabase.produtos.get(id);
    }
}
