package it.edu.iisgubbio.Tennis;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.edu.iisgubbio.Tennis.Prenotazione;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Campo {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	Integer id;
	String nome;
	Integer apertura;
	Integer chiusura;
	Boolean riscaldato;
	
	@OneToMany(mappedBy = "campo")
	@JsonManagedReference(value = "campo-prenotazioni")
	List<Prenotazione> prenotazioni;

	
	public Campo() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getApertura() {
		return apertura;
	}


	public void setApertura(Integer apertura) {
		this.apertura = apertura;
	}


	public Integer getChiusura() {
		return chiusura;
	}


	public void setChiusura(Integer chiusura) {
		this.chiusura = chiusura;
	}


	public Boolean getRiscaldato() {
		return riscaldato;
	}


	public void setRiscaldato(Boolean riscaldato) {
		this.riscaldato = riscaldato;
	}


	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}


	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}
	
}
