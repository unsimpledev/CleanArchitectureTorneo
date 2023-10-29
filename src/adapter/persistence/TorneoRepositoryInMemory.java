package adapter.persistence;

import java.util.ArrayList;
import java.util.List;

import core.entities.Torneo;
import core.ports.output.ITorneoRepository;

public class TorneoRepositoryInMemory implements ITorneoRepository {
    private final List<Torneo> torneos;

    public TorneoRepositoryInMemory() {
        this.torneos = new ArrayList<>();
        cargarDatosIniciales();
    }

    @Override
    public Torneo buscarPorId(int id) {
        for (Torneo torneo : torneos) {
            if (torneo.getId() == id) {
                return torneo;
            }
        }
        return null;
    }

    @Override
    public List<Torneo> buscarTodos() {
        return new ArrayList<>(torneos);
    }

    @Override
    public void guardar(Torneo torneo) {
        torneos.add(torneo);
    }

    // Método para cargar datos de ejemplo
    private void cargarDatosIniciales() {
        torneos.add(new Torneo(12345, "Torneo 1"));
        torneos.add(new Torneo(34567, "Torneo 2"));
        torneos.add(new Torneo(45678, "Torneo 3"));
    }

}
