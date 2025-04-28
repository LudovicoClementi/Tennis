package it.edu.iisgubbio.Tennis;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer>{
	@Query(value="SELECT prenotazione.* "
			+ "FROM prenotazione,campo "
			+ "WHERE prenotazione.campo_id=campo.id "
			+ "AND prenotazione.data=:dataPre "
			+ "AND campo.id=:idCampo",
			nativeQuery=true)
			List<Prenotazione>cerca(
					@Param("idCampo") Integer idCampo,
					@Param("dataPre") String dataPre)
					;
}
//SISTEMARE QUERY SOPRA