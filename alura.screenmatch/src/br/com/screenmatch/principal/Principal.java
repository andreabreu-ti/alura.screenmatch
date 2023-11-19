package br.com.screenmatch.principal;

import java.util.ArrayList;

import br.com.screenmatch.calculos.CalculadoraDeTempo;
import br.com.screenmatch.calculos.FiltroRecomendacao;
import br.com.screenmatch.modelos.Episodio;
import br.com.screenmatch.modelos.Filme;
import br.com.screenmatch.modelos.Serie;

public class Principal {

	public static void main(String[] args) {

		Filme meuFilme = new Filme("O Poderoso Chefão", 1970); // Tipo referência, objeto na memória, variável de referênciar
		meuFilme.setDuracaoEmMinutos(180);
		System.out.println("Duração do Filme: " + meuFilme.getDuracaoEmMinutos());
		meuFilme.exibeFichaTecnica();
		meuFilme.avalia(8);
		meuFilme.avalia(10);
		meuFilme.avalia(5);
		System.out.println("Total de Avaliações: " + meuFilme.getTotalDeAvaliacao());
		System.out.println(meuFilme.pegaMedia());

		
		Serie lost = new Serie("Lost", 2000);
		lost.exibeFichaTecnica();
		lost.setTemporadas(10);
		lost.setEpisodiosPorTemporada(10);
		lost.setMinutosPorEpisodio(50);
		System.out.println("Duração para maratornar Lost: " + lost.getDuracaoEmMinutos());

		
		Filme outroFilme = new Filme("Avatar", 2023); // Tipo referência, objeto na memória, variável de referênciar
		outroFilme.setDuracaoEmMinutos(200);
		CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
		calculadora.inclui(meuFilme);
		calculadora.inclui(outroFilme);
		calculadora.inclui(lost);
		System.out.println(calculadora.getTempoTotal());
		FiltroRecomendacao filtro = new FiltroRecomendacao();
		filtro.filtra(meuFilme);

		Episodio episodio = new Episodio();

		episodio.setNumero(1);
		episodio.setSerie(lost);
		episodio.setTotalDeVisualizacoes(300);
		filtro.filtra(episodio);
		
		
		var filmeDoPaulo = new Filme("Dogville", 2023);
		filmeDoPaulo.setDuracaoEmMinutos(200);
		filmeDoPaulo.avalia(10);
		ArrayList<Filme> listaDeFilmes = new ArrayList<>();
		listaDeFilmes.add(filmeDoPaulo);
		listaDeFilmes.add(meuFilme);
		listaDeFilmes.add(outroFilme);
		System.out.println("Tamanho da Lista: " + listaDeFilmes.size());
		System.out.println("Primeiro Filme: " + listaDeFilmes.get(0).getNome());
		System.out.println(listaDeFilmes);
		System.out.println("toString do Filme: " + listaDeFilmes.get(0).toString());

	}

}
