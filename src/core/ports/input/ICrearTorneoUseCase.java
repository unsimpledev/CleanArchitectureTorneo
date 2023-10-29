package core.ports.input;

import core.entities.Torneo;

public interface ICrearTorneoUseCase {

	public Torneo crearTorneo(String nombre);
}
