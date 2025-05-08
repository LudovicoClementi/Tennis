package it.edu.iisgubbio.Tennis;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CampoRepository extends JpaRepository<Campo, Integer>{
	@Query(
			value="SELECT campo.* "
					+ "FROM campo "
					+ "WHERE campo.apertura <= :ora  "
					+ "AND :ora <= campo.chiusura ",
					nativeQuery= true)
	List<Campo> vediOra(
            @Param("ora") Integer ora
    );
	
}
