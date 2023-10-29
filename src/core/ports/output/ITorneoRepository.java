package core.ports.output;

import java.util.List;

import core.entities.Torneo;

public interface ITorneoRepository {

	public Torneo buscarPorId(int id);

	public List<Torneo> buscarTodos();

	public void guardar(Torneo torneo);
	
}
