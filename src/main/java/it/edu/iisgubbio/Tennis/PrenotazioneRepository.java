package it.edu.iisgubbio.Tennis;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer>{
	@Query(value="SELECT prenotazione.* "
			+ "FROM prenotazione,campo "
			+ "WHERE prenotazione.campo_id=campo.id "
			+ "AND prenotazione.data=:dataPre "
			+ "AND campo.id=:idCampo",
			nativeQuery=true)
			List<Prenotazione>cercaPrenotazione(
					@Param("idCampo") Integer idCampo,
					@Param("dataPre") String dataPre);
	
	
	@Query(value="SELECT prenotazione.* "
			+ "FROM prenotazione,campo "
			+ "WHERE prenotazione.campo_id=campo.id "
			+ "AND prenotazione.data=:dataPre "
			+ "AND (prenotazione.ora_inizio > :aInter AND prenotazione.ora_inizio < :zInter) "
			+ "OR (prenotazione.ora_fine > :aInter AND prenotazione.ora_fine < :zInter) "
			+ "AND campo.id=:idCampo ",
			nativeQuery=true)
			List<Prenotazione>cercaPrenotazioneOra(
					@Param("idCampo") Integer idCampo,
					@Param("dataPre") String dataPre,
					@Param("aInter") Integer aInter,
					@Param("zInter") Integer zInter);
	
	@Query(value = "INSERT INTO prenotazione(campo_id,giocatore_id,data,ora_inizio,ora_fine)\n"
					+"VALUES(:campo_id,:giocatore_id,:data,:ora_inizio,:ora_fine)",
			nativeQuery = true)
		Void inserisciPrenotazione(
				@Param("campo_id") Integer campo_id,
		        @Param("giocatore_id") Integer giocatore_id,
		        @Param("data") String data,
		        @Param("ora_inizio") Integer ora_inizio,
		        @Param("ora_fine") Integer ora_fine
			);
}
