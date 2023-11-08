package screenmatch;

public class Filme {

	/*
	 * Conceito de Classe --> Especificar o que o Filme tem Abstração: O que o filme
	 * tem Tudo que uma classe tem e o que uma classe faz Informações importantes
	 * que a classe precisa / Informações importantes
	 */

	String nome;
	int anoDeLancamento;
	boolean incluidoNoPlano;
	double somaAvaliacao;
	int totalDeAvaliacao;
	int duracaoEmMinutos;

	/*
	 * Métodos - vão fazer alguma coisa
	 */
	void exibeFichaTecnica() {
		System.out.println("Nome do Filme: " + nome);
		System.out.println("Ano de Lançamento: " + anoDeLancamento);
	}

	void avalia(double nota) {
		somaAvaliacao += nota;
		totalDeAvaliacao++;
	}

	double pegaMedia() {
		return somaAvaliacao / totalDeAvaliacao;
	}

}
