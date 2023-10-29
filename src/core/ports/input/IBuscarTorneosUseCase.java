package core.ports.input;

import java.util.List;

import core.entities.Torneo;

public interface IBuscarTorneosUseCase {

	public Torneo buscarPorId(int id);
	
	public List<Torneo> buscarTodos();

}
