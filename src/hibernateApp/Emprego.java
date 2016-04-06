package hibernateApp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(EmpregoId.class)
public class Emprego {

	@Id
	@ManyToOne
	@JoinColumn(name="empregado_id")
	private Empregado empregado;
	
	@Id
	@ManyToOne
	@JoinColumn(name="empresa_id")
	private Empresa empresa;
	
	private String salario;

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}
		
}
