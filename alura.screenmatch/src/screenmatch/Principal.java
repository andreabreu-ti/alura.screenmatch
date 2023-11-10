package screenmatch;

import br.com.screenmatch.modelos.Filme;

public class Principal {

	public static void main(String[] args) {

		Filme meuFilme = new Filme(); // Tipo referência, objeto na memória, variável de referênciar

		meuFilme.setNome("O Poderoso Chefão");
		meuFilme.setAnoDeLancamento(1970);
		meuFilme.setDuracaoEmMinutos(180);

		meuFilme.exibeFichaTecnica();

		meuFilme.avalia(8);
		meuFilme.avalia(10);
		meuFilme.avalia(5);

		System.out.println("Total de Avaliações: " + meuFilme.getTotalDeAvaliacao());
		System.out.println(meuFilme.pegaMedia());

	}

}
