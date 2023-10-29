package adapter.persistence.mock;

import java.util.ArrayList;
import java.util.List;

import core.entities.Torneo;
import core.ports.output.ITorneoRepository;

public class TorneoRepositoryMock implements ITorneoRepository {
	
	private List<Torneo> torneos = new ArrayList<>();

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

	// Método para agregar torneos al simulador
	public void agregarTorneo(Torneo torneo) {
		torneos.add(torneo);
	}

	@Override
	public void guardar(Torneo torneo) {
		// TODO Auto-generated method stub

	}

}
