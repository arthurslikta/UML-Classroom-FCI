public class Pedido {
    private int id;
    private int idCliente;
    private double valorTotal;

    public Pedido(int id, int idCliente) {
        this.id = id;
        this.idCliente = idCliente;
    }

    public int getId() { return id; }
    public int getIdCliente() { return idCliente; }
    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double v) { valorTotal = v; }
}
