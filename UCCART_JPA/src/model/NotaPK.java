package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the nota database table.
 * 
 */
@Embeddable
public class NotaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="nota_codestudiante")
	private String notaCodestudiante;

	@Column(name="nota_codcurso")
	private String notaCodcurso;

	public NotaPK() {
	}
	public String getNotaCodestudiante() {
		return this.notaCodestudiante;
	}
	public void setNotaCodestudiante(String notaCodestudiante) {
		this.notaCodestudiante = notaCodestudiante;
	}
	public String getNotaCodcurso() {
		return this.notaCodcurso;
	}
	public void setNotaCodcurso(String notaCodcurso) {
		this.notaCodcurso = notaCodcurso;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NotaPK)) {
			return false;
		}
		NotaPK castOther = (NotaPK)other;
		return 
			this.notaCodestudiante.equals(castOther.notaCodestudiante)
			&& this.notaCodcurso.equals(castOther.notaCodcurso);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.notaCodestudiante.hashCode();
		hash = hash * prime + this.notaCodcurso.hashCode();
		
		return hash;
	}
}