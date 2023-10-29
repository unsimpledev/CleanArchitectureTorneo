package configuration;

import adapter.persistence.TorneoRepositoryInMemory;
import adapter.view.console.Consola;
import adapter.view.console.MenuConsola;
import core.ports.input.IBuscarTorneosUseCase;
import core.ports.input.ICrearTorneoUseCase;
import core.ports.output.ITorneoRepository;
import core.usecases.BuscarTorneosUseCase;
import core.usecases.CrearTorneoUseCase;

/**
 * Punto de entrada Es el archivo "sucio" Instancia e inyecta los objetos
 * Inicializa la consola
 */
public class Init {

	public static void main(String[] args) {
		// Repositorios
		ITorneoRepository torneoRepository = new TorneoRepositoryInMemory();

		// Casos de uso
		ICrearTorneoUseCase crearTorneoUseCase = new CrearTorneoUseCase(torneoRepository);
		IBuscarTorneosUseCase buscarTorneosUseCase = new BuscarTorneosUseCase(torneoRepository);

		// Diseño MVC
		Consola consola = new Consola();
		MenuConsola menu = new MenuConsola(consola, buscarTorneosUseCase, crearTorneoUseCase);
		menu.iniciar();
		consola.cerrar();
	}
}
