package core.usecases.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adapter.persistence.mock.TorneoRepositoryMock;
import core.entities.Torneo;
import core.ports.input.IBuscarTorneosUseCase;
import core.ports.output.ITorneoRepository;
import core.usecases.BuscarTorneosUseCase;

public class BuscadorTorneosUseCaseTest {
	private ITorneoRepository torneoRepository;
	private IBuscarTorneosUseCase buscarTorneosUseCase;

	@BeforeEach
	public void setUp() {
		torneoRepository = new TorneoRepositoryMock();
		buscarTorneosUseCase = new BuscarTorneosUseCase(torneoRepository);
	}

	@Test
	public void testBuscarPorId() {
		int id = 1;
		Torneo torneoMock = new Torneo(1, "Torneo de Ejemplo");

		// Agregar un torneo al simulador de repositorio
		((TorneoRepositoryMock) torneoRepository).agregarTorneo(torneoMock);

		// Ejecutar el caso de uso
		Torneo resultado = buscarTorneosUseCase.buscarPorId(id);

		// Verificar que el resultado es el esperado
		assertEquals(torneoMock, resultado);
	}

	@Test
	public void testBuscarTodos() {
		List<Torneo> torneosMock = new ArrayList<>();
		torneosMock.add(new Torneo(1, "Torneo 1"));
		torneosMock.add(new Torneo(2, "Torneo 2"));
		torneosMock.add(new Torneo(3, "Torneo 3"));

		// Agregar torneos al simulador de repositorio
		TorneoRepositoryMock simulador = (TorneoRepositoryMock) torneoRepository;
		for (Torneo torneo : torneosMock) {
			simulador.agregarTorneo(torneo);
		}

		// Ejecutar el caso de uso
		List<Torneo> resultados = buscarTorneosUseCase.buscarTodos();

		// Verificar que la lista de resultados coincide con la lista de torneos mock
		assertEquals(torneosMock, resultados);
	}

}
