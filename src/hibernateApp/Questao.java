package hibernateApp;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Questao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	@Basic(fetch= FetchType.LAZY)
	private Character[] enunciado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Character[] getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(Character[] enunciado) {
		this.enunciado = enunciado;
	}
		
}
