package it.edu.iisgubbio.Tennis;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface GiocatoreRepository extends JpaRepository<Giocatore, Integer> {

    @Query(value = "SELECT * FROM giocatore " +
                   "WHERE (:nome IS NULL OR nome = :nome) " +
                   "AND (:cognome IS NULL OR cognome = :cognome)",
           nativeQuery = true)
    List<Giocatore> cercaGiocatore(
            @Param("nome") String nome,
            @Param("cognome") String cognome
    );
    
    /*@Query(value = "INSERT INTO giocatore(nome,cognome,data_nascita,email,telefono)\n"
    				+"VALUES(:nome,:cognome,:data_nascita,:email,:telefono)",
    				nativeQuery = true)
    Void inserisciGiocatore(
    		@Param("nome") String nome,
            @Param("cognome") String cognome,
            @Param("data_nascita") String data_nascita,
            @Param("email") String email,
            @Param("telefono") String telefono
    		);*/
}
