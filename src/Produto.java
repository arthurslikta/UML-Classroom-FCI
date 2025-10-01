import java.util.ArrayList;
import java.util.List;

public class Produto {
    private int id;
    private String nome;
    private float preco;
    private double peso;

    private static List<Produto> produtos = new ArrayList<>();

    public Produto(int id, String nome, float preco, double peso) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.peso = peso;
    }

    public int getId(){ 
        return id; 
    }
    public float getPreco() { 
        return preco; 
    }
    public String getNome() { 
        return nome; 
    }
    public double getPeso() { 
        return peso; 
    }

    public static void addProduto(Produto p) {
        produtos.add(p);
    }

    public static List<Produto> listarProdutos() {
        return produtos;
    }
}