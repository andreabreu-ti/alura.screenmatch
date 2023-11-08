package screenmatch;

public class Principal {

	public static void main(String[] args) {

		Filme meuFilme = new Filme(); // Tipo referência, objeto na memória, variável de referênciar

		meuFilme.nome = "O Poderoso Chefão";
		meuFilme.anoDeLancamento = 1970;
		meuFilme.duracaoEmMinutos = 180;

		meuFilme.exibeFichaTecnica();

		meuFilme.avalia(8);
		meuFilme.avalia(10);
		meuFilme.avalia(5);

		System.out.println(meuFilme.somaAvaliacao);
		System.out.println(meuFilme.totalDeAvaliacao);
		
		System.out.println(meuFilme.pegaMedia());

	}

}
