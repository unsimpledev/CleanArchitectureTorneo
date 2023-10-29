package core.usecases.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adapter.persistence.mock.TorneoRepositoryMock;
import core.entities.Torneo;
import core.ports.input.ICrearTorneoUseCase;
import core.ports.output.ITorneoRepository;
import core.usecases.CrearTorneoUseCase;

public class CrearTorneoUseCaseTest {
	private ITorneoRepository torneoRepository;
	private ICrearTorneoUseCase crearTorneoUseCase;
	
	@BeforeEach
	public void setUp() {
		torneoRepository = new TorneoRepositoryMock();
		crearTorneoUseCase = new CrearTorneoUseCase(torneoRepository);
	}

	@Test
	public void testBuscarPorId() {
		String nombre = "Torneo de Ejemplo";
		Torneo torneoMock = new Torneo(4, nombre);

		// Agregar un torneo al simulador de repositorio
		((TorneoRepositoryMock) torneoRepository).agregarTorneo(torneoMock);

		// Ejecutar el caso de uso
		Torneo resultado = crearTorneoUseCase.crearTorneo(nombre);

		// Verificar que el resultado es el esperado
		assertEquals(torneoMock.getNombre(), resultado.getNombre());
	}

}
