public class ClienteDAOHash {

    public void salvar(Cliente c) {
        HashDatabase.clientes.put(c.getId(), c);
    }

    public Cliente buscar(int id) {
        return HashDatabase.clientes.get(id);
    }
}
