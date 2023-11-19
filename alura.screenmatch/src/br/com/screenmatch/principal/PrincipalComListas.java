package br.com.screenmatch.principal;

import java.util.ArrayList;

import br.com.screenmatch.modelos.Filme;
import br.com.screenmatch.modelos.Serie;
import br.com.screenmatch.modelos.Titulo;

public class PrincipalComListas {

	
	public static void main(String[] args) {
		
		Filme meuFilme = new Filme("O Poderoso Chefão", 1970);
		meuFilme.avalia(9);
		Filme outroFilme = new Filme("Avatar", 2023);
		outroFilme.avalia(6);
		var filmeDoPaulo = new Filme("Dogville", 2023);
		filmeDoPaulo.avalia(10);
		Serie lost = new Serie("Lost", 2000);
		
		Filme f1 = filmeDoPaulo;
		
		ArrayList<Titulo> lista = new ArrayList<>();
		lista.add(filmeDoPaulo);
		lista.add(meuFilme);
		lista.add(outroFilme);
		lista.add(lost);
		
		for (Titulo item : lista) {
			System.out.println(item.getNome());
			
			if (item instanceof Filme filme && filme.getClassificacao() > 2) {  //Palavra chave instanceof
				
				System.out.println("Classificação: " + filme.getClassificacao());	
			}
			
		}
		
	}
	
}