import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private String login;
    private int idade;
    private String endereco;
    private String senha;

    private static List<Cliente> clientes = new ArrayList<>();


    
    public Cliente(int id, String nome, String login, int idade, String senha, String endereco) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.idade = idade;
        this.senha = senha;
        this.endereco = endereco;
    }

    public int getId() {
         return id; 
        }
    public String getNome() {
         return nome; 
        }

    public String getLogin() { 
        return login; 
    }
    public String getSenha() { 
        return senha; 
    }
    public String getEndereco() { 
        return endereco; 
    }

    public static void addCliente(Cliente c) {
        clientes.add(c);
    }

    public static List<Cliente> listarClientes() {
        return clientes;
    }
}