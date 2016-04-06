package hibernateApp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.jboss.logging.Logger;

@Entity
@Table(name="Usuario")
public class Usuario implements Serializable {
	
	private static Logger logger = Logger.getLogger(Usuario.class);	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7163398034219659698L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usuarioid")
	private Long usuarioid;
	
	@Column(name="Nome",nullable=false,length=50)
	private String nome;
	
	@Column(name="Email",nullable=false,length=50,unique=true)
	private String email;

	@OneToOne
	@JoinColumn(name="usuarioid")
    private Senha senha;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name="usuario_produto",
			   joinColumns = @JoinColumn(name="usuario_usuarioid"),
			   inverseJoinColumns = @JoinColumn(name="produtos_id"))
	private List<Produto> produtos=new ArrayList<Produto>();
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinColumn(name="usuario_fk")
	private List<Endereco> enderecos=new ArrayList<Endereco>();
	
	public void addEndereco(Endereco end){
		enderecos.add(end);
		logger.info("endereço adicionado");
	}
	
	public List<Endereco> getEnderecos(){
		return enderecos;
	}
	
	public void addProduto(Produto p){
		produtos.add(p);
	}
	
	public List<Produto> getProdutos(){
		return produtos;
	}
	
	public Senha getSenha() {
		return senha;
	}

	public void setSenha(Senha senha) {
		this.senha = senha;
	}

	public long getUsuarioId() {
		return usuarioid;
	}

	public void setUsuarioId(Long UsuarioId) {
		this.usuarioid = UsuarioId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
