package screenmatch;

import br.com.screenmatch.calculos.CalculadoraDeTempo;
import br.com.screenmatch.modelos.Filme;
import br.com.screenmatch.modelos.Serie;

public class Principal {

	public static void main(String[] args) {

		Filme meuFilme = new Filme(); // Tipo referência, objeto na memória, variável de referênciar

		meuFilme.setNome("O Poderoso Chefão");
		meuFilme.setAnoDeLancamento(1970);
		meuFilme.setDuracaoEmMinutos(180);
		System.out.println("Duração do Filme: " + meuFilme.getDuracaoEmMinutos());

		meuFilme.exibeFichaTecnica();
		meuFilme.avalia(8);
		meuFilme.avalia(10);
		meuFilme.avalia(5);

		System.out.println("Total de Avaliações: " + meuFilme.getTotalDeAvaliacao());
		System.out.println(meuFilme.pegaMedia());

		Serie lost = new Serie();

		lost.setNome("Lost");
		lost.setAnoDeLancamento(2000);
		lost.exibeFichaTecnica();
		lost.setTemporadas(10);
		lost.setEpisodiosPorTemporada(10);
		lost.setMinutosPorEpisodio(50);
		System.out.println("Duração para maratornar Lost: " + lost.getDuracaoEmMinutos());

		Filme outroFilme = new Filme(); // Tipo referência, objeto na memória, variável de referênciar

		outroFilme.setNome("Avatar");
		outroFilme.setAnoDeLancamento(2023);
		outroFilme.setDuracaoEmMinutos(200);

		CalculadoraDeTempo calculadora = new CalculadoraDeTempo();

		calculadora.inclui(meuFilme);
		calculadora.inclui(outroFilme);
		calculadora.inclui(lost);

		System.out.println(calculadora.getTempoTotal());

	}

}
