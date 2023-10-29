package core.usecases;

import java.util.List;

import core.entities.Torneo;
import core.ports.input.IBuscarTorneosUseCase;
import core.ports.output.ITorneoRepository;

public class BuscarTorneosUseCase implements IBuscarTorneosUseCase{

	private final ITorneoRepository torneoRepository;
	
	public BuscarTorneosUseCase(ITorneoRepository torneoRepository) {
		this.torneoRepository = torneoRepository;
	}

	@Override
	public Torneo buscarPorId(int id) {
		return torneoRepository.buscarPorId(id);
	}
	
	@Override
	public List<Torneo> buscarTodos() {
		return torneoRepository.buscarTodos();
	}
	
}
