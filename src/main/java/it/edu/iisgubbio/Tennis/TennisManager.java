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
	
	//TUTTI I CAMPI
	@GetMapping("/campi")
	public List<Campo> mostraCampo(){
		return archivioCampo.findAll();
		}
	
	//TUTTE LE PRENOTAZIONI
	@GetMapping("/prenotazioni")
	public List<Prenotazione> mostraPrenotazione(){
		return archivioPrenotazione.findAll();
		}
	
	//UN CAMPO
	@GetMapping("/campo/{id}")
	public Optional<Campo> mostraCampo(@PathVariable Integer id) {
		
		return archivioCampo.findById(id);
	}
	
	//d
	@GetMapping("/campo/{id}/prenotazione")
	public List<Prenotazione> mostraPrenData(
			@PathVariable Integer id,
			@RequestParam String data
			) {
		
		return archivioPrenotazione.cercaPrenotazione(id,data);
	}
	
	@GetMapping("/giocatori")
	public List<Giocatore> mostraGiocatori(){
		return archivioGiocatore.findAll();
		}
	
	@GetMapping("/giocatore")
	public List<Giocatore> mostraGiocatoreNome(
			@RequestParam(required = false) String nome ,
			@RequestParam(required = false) String cognome
			){
		
		return archivioGiocatore.cercaGiocatore(nome,cognome);
		}
}
