package it.edu.iisgubbio.Tennis;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    
    String data;
    Integer ora_inizio;
    Integer ora_fine;

    @ManyToOne
    @JoinColumn(name = "campo_id")
    @JsonBackReference(value = "campo-prenotazioni")
    Campo campo;

    @ManyToOne
    @JoinColumn(name = "giocatore_id")
    @JsonBackReference(value = "giocatore-prenotazioni")
    Giocatore giocatore;

	public Prenotazione() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getOra_inizio() {
		return ora_inizio;
	}

	public void setOra_inizio(Integer ora_inizio) {
		this.ora_inizio = ora_inizio;
	}

	public Integer getOra_fine() {
		return ora_fine;
	}

	public void setOra_fine(Integer ora_fine) {
		this.ora_fine = ora_fine;
	}

	public Campo getCampo() {
		return campo;
	}

	public void setCampo(Campo campo) {
		this.campo = campo;
	}

	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}
    
    
}
