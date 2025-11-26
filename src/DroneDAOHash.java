public class DroneDAOHash {

    public void salvar(Drone d) {
        HashDatabase.drones.put(d.getId(), d);
    }

    public Drone buscar(int id) {
        return HashDatabase.drones.get(id);
    }
}