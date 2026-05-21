package br.com.alura.screenmatch.principal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.alura.screenmatch.model.Categoria;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.repository.SerieRepository;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

public class Principal {

	private Scanner leitura = new Scanner(System.in);
	private ConsumoApi consumo = new ConsumoApi();
	private ConverteDados conversor = new ConverteDados();
	private final String ENDERECO = "https://www.omdbapi.com/?t=";
	private final String API_KEY = "&apikey=b21ebf4a";

	private List<DadosSerie> dadosSeries = new ArrayList<>();

	private SerieRepository repositorio;

	private List<Serie> series = new ArrayList<>();

	public Principal(SerieRepository repositorio) {

		this.repositorio = repositorio;
	}

	public void exibeMenu() {

		var opcao = -1;
		while (opcao != 0) {

			var menu = """
					1 - Buscar Séries
					2 - Buscar Episódios
					3 - Listar Séries
					4 - Busca Série por Título
					5 - Buscar Série por Ator
					6 - Top 5 Séries
					7 - Buscar Séries Por Categoria
					8 - Filtrar séries

					0 - Sair
					""";

			System.out.println(menu);
			opcao = leitura.nextInt();
			leitura.nextLine();

			switch (opcao) {
			case 1:
				buscarSerieWeb();
				break;
			case 2:
				buscarEpisodioPorSerie();
				break;
			case 3:
				listarSeriesBuscadas();
				break;
			case 4:
				buscarSeriesPorTitulo();
				break;
			case 5:
				buscarSeriesPorAtor();
				break;
			case 6:
				buscarop5Series();
				break;
			case 7:
				buscarSeriePorCategoria();
				break;
			case 8:
				filtrarSeriesPorTemporadaEAvaliacao();
				break;
			case 0:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção inválida");
			}
		}
	}

	private void buscarSerieWeb() {
		DadosSerie dados = getDadosSerie();
		// dadosSeries.add(dados);

		Serie serie = new Serie(dados);
		repositorio.save(serie);
		System.out.println(dados);
	}

	private DadosSerie getDadosSerie() {
		System.out.println("Digite o nome da série para busca");
		var nomeSerie = leitura.nextLine();
		var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		return dados;
	}

	private void buscarEpisodioPorSerie() {

		listarSeriesBuscadas();
		System.out.println("Escolha uma série pelo nome:");
		var nomeSerie = leitura.nextLine();

		Optional<Serie> serie = repositorio.findByTituloContainingIgnoreCase(nomeSerie);

		if (serie.isPresent()) {

			var serieEncontrada = serie.get();
			List<DadosTemporada> temporadas = new ArrayList<>();

			for (int i = 1; i <= serieEncontrada.getTotalTemporadas(); i++) {
				var json = consumo.obterDados(
						ENDERECO + serieEncontrada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
				DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
				temporadas.add(dadosTemporada);
			}
			temporadas.forEach(System.out::println);

			List<Episodio> episodios = temporadas.stream()
					.flatMap(d -> d.episodios().stream().map(e -> new Episodio(d.numero(), e)))
					.collect(Collectors.toList());

			serieEncontrada.setEpisodios(episodios);
			repositorio.save(serieEncontrada);

		} else {

			System.out.println("Série não encontrada!");
		}

	}

	private void listarSeriesBuscadas() {

		series = repositorio.findAll();
		series.stream().sorted(Comparator.comparing(Serie::getGenero)).forEach(System.out::println);
		;
	}

	private void buscarSeriesPorTitulo() {

		System.out.println("Escolha uma série pelo nome");
		var nomeSerie = leitura.nextLine();
		Optional<Serie> serieBuscada = repositorio.findByTituloContainingIgnoreCase(nomeSerie);

		if (serieBuscada.isPresent()) {

			System.out.println("Dados da serie: " + serieBuscada.get());
		} else {

			System.out.println("Série não encontrada!");
		}
	}

	private void buscarSeriesPorAtor() {

		System.out.println("Qual o nome do Ator?");
		var nomeAtor = leitura.nextLine();
		System.out.println("Avaliações a partir de que valor");

		var avaliacao = leitura.nextDouble();

		List<Serie> seriesEncontradas = repositorio
				.findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(nomeAtor, avaliacao);

		System.out.println("Séries em que o " + nomeAtor + " trabalho!");
		seriesEncontradas.forEach(s -> System.out.println(s.getTitulo() + " - Avaliação " + s.getAvaliacao()));

	}

	private void buscarop5Series() {

		List<Serie> serieTop = repositorio.findTop5ByOrderByAvaliacaoDesc();

		serieTop.forEach(s -> System.out.println(s.getTitulo() + " - Avaliação " + s.getAvaliacao()));
	}

	private void buscarSeriePorCategoria() {

		System.out.println("Deseja buscar série de que categoria/genero?");
		var nomeGenero = leitura.nextLine();
		Categoria categoria = Categoria.fromPortugues(nomeGenero);
		List<Serie> seriesPorCategoria = repositorio.findByGenero(categoria);
		System.out.println("Séries da categoria " + nomeGenero);
		seriesPorCategoria.forEach(System.out::println);
	}

	 private void filtrarSeriesPorTemporadaEAvaliacao(){
	        System.out.println("Filtrar séries até quantas temporadas? ");
	        var totalTemporadas = leitura.nextInt();
	        leitura.nextLine();
	        System.out.println("Com avaliação a partir de que valor? ");
	        var avaliacao = leitura.nextDouble();
	        leitura.nextLine();
//	        List<Serie> filtroSeries = repositorio.findByTotalTemporadasLessThanEqualAndAvaliacaoGreaterThanEqual(totalTemporadas, avaliacao);
	       
	        List<Serie> filtroSeries = repositorio.seriesPorTemoradaEAvaliacao(totalTemporadas, avaliacao);
	        
	        System.out.println("*** Séries filtradas ***");
	        filtroSeries.forEach(s ->
	                System.out.println(s.getTitulo() + "  - avaliação: " + s.getAvaliacao()));
	    }
}
