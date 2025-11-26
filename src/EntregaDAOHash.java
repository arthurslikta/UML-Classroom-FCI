public class EntregaDAOHash {

    public void salvar(Entrega e) {
        HashDatabase.entregas.put(e.getId(), e);
    }

    public Entrega buscar(int id) {
        return HashDatabase.entregas.get(id);
    }
}
