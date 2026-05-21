package br.com.alura.screenmatch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.screenmatch.model.Categoria;
import br.com.alura.screenmatch.model.Serie;

public interface SerieRepository extends JpaRepository<Serie, Long> {

	Optional<Serie> findByTituloContainingIgnoreCase(String nomeSeire);

	/*
	 * GreaterThanEquals --> Representação do Maior ou igual <parametro>
	 */
	List<Serie> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String nomeAtor, Double avaliacao);

	List<Serie> findTop5ByOrderByAvaliacaoDesc();

	List<Serie> findByGenero(Categoria categoria);
	
	List<Serie> findByTotalTemporadasLessThanEqualAndAvaliacaoGreaterThanEqual(int totalTemporadas, double avaliacao);
	
	
//	@Query(value = "select * from series where series.total_temporadas <= 5 and series.avaliacao >= 7.5", nativeQuery = true)
//	List<Serie> seriesPorTemoradaEAvaliacao();
	
	@Query("select s from Serie s where s.totalTemporadas <= :totalTemporadas and s.avaliacao >= :avaliacao")
	List<Serie> seriesPorTemoradaEAvaliacao(int totalTemporadas, double avaliacao);
	
	
	
	

}