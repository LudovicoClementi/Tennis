package it.edu.iisgubbio.Tennis;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public List<Campo> campoOra(
			@RequestParam(required = false) Integer ora
			){
		if(ora!=null) {
			return archivioCampo.vediOra(ora);
		}else {
		return archivioCampo.findAll();
		}
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
	
	
	@GetMapping("/campo/{id}/prenotazione")
	public List<Prenotazione> mostraPrenData(
			@PathVariable Integer id,
			@RequestParam String data,
			@RequestParam(name="inizio", required = false) Integer aInter,
			@RequestParam(name="fine" ,required = false) Integer zInter
			) {
		if(aInter!=null) {
			return archivioPrenotazione.cercaPrenotazioneOra(id,data,aInter,zInter);

		}else {
			return archivioPrenotazione.cercaPrenotazione(id,data);
		}
	}
	
	@GetMapping("/tuttigiocatori")
	public List<Giocatore> mostraGiocatori(){
		return archivioGiocatore.findAll();
		}
	
	@GetMapping("/giocatori")
	public List<Giocatore> mostraGiocatoreNome(
			@RequestParam(required = false) String nome ,
			@RequestParam(required = false) String cognome
			){
		
		return archivioGiocatore.cercaGiocatore(nome,cognome);
		}
	
	
	 @PostMapping("/giocatore")
	    public void inserisciGiocatore(@RequestBody Giocatore td) {
	        archivioGiocatore.save( td );
	    }

	/*@PostMapping("/giocatore")
	public void insertGiocatore(
	        @RequestParam String nome,
	        @RequestParam String cognome,
	        @RequestParam String data_nascita,
	        @RequestParam String email,
	        @RequestParam String telefono
	) {
	    telefono = "+" + telefono;
	    archivioGiocatore.inserisciGiocatore(nome, cognome, data_nascita, email, telefono);
	}*/
	 
	 @PostMapping("/campo/{campo_id}/prenotazione")
	 public void insertPrenotazione(
		        @PathVariable Integer campo_id,
		        @RequestParam Integer giocatore_id,
		        @RequestParam String data,
		        @RequestParam Integer ora_inizio,
		        @RequestParam Integer ora_fine
		) {
		    archivioPrenotazione.inserisciPrenotazione(campo_id, giocatore_id, data, ora_inizio, ora_fine);
		}
}
