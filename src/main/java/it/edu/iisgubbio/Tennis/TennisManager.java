package it.edu.iisgubbio.Tennis;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class TennisManager {
	@Autowired
	CampoRepository archivioCampo;
	@Autowired 
	GiocatoreRepository archivioGiocatore;
	@Autowired 
	PrenotazioneRepository archivioPrenotazione;
	
	@GetMapping("/campi")
	public List<Campo> mostraCampo(){
		return archivioCampo.findAll();
		}
	

	@GetMapping("/prenotazione")
	public List<Prenotazione> mostraPrenotazione(){
		return archivioPrenotazione.findAll();
		}
	
	
}
