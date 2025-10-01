import java.util.ArrayList;
import java.util.List;

public class Drone {
    private int id;
    private int bateria;
    private float capacidadePeso;
    private boolean disponibilidade;

    private static List<Drone> drones = new ArrayList<>();

    public Drone(int id, float capacidadePeso, boolean disponibilidade, int bateria) {
        if (capacidadePeso <= 0) throw new IllegalArgumentException("Capacidade deve ser maior que zero.");
        this.id = id;
        this.bateria = bateria;
        this.capacidadePeso = capacidadePeso;
        this.disponibilidade = disponibilidade;
    }

    public boolean validarPeso(double peso) {
        if (!disponibilidade) {
            throw new IllegalStateException("Drone indisponível para entrega.");
        }
        return peso <= capacidadePeso;
    }

    public int getId() {
         return id;
         }
    public boolean getDisponibilidade() { 
        return disponibilidade; 
    }

    public static void addDrone(Drone d) {
        drones.add(d);
    }

    public static List<Drone> listarDrones() {
        return drones;
    }
}