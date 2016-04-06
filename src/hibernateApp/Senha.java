package hibernateApp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Senha")
public class Senha implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
		
	@Column(name="Codigo", nullable=false ,length=15)
	private String codigo;
	
	@OneToOne(mappedBy="senha")
	private Usuario usuario;
			
	public Long getId() {
		return id;
	}

	public void setId(Long Id){
		this.id=Id;
	}

	public void setCodigo(String codigo){
		this.codigo=codigo;
	}
	
	public String getCodigo(){
		return codigo;
	}
		
}
