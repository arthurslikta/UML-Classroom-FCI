public class Produto {

    private int IDproduto;
    private String nome;
    private double preco;
    private double peso;

    public Produto(int id, String nome, double preco, double peso) {
        this.IDproduto = id;
        this.nome = nome;
        this.preco = preco;
        this.peso = peso;
    }

    public void addProduto() {
        BancoDeDados.salvarProduto(this);
    }

    public void atualizarEstoque(int qtd) {
    }

    public double getPreco() { return preco; }
    public double getPeso() { return peso; }
}
