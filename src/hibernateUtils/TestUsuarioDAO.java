package hibernateUtils;

import hibernateApp.Endereco;
import hibernateApp.Produto;
import hibernateApp.Senha;
import hibernateApp.Usuario;

import java.util.List;

import org.jboss.logging.Logger;

import persistencia.ProdutoDAOImp;
import persistencia.UsuarioDAOImp;

public class TestUsuarioDAO {

	private static final Logger logger = Logger.getLogger(TestUsuarioDAO.class);
	
	public static void main(String[] args) {
		UsuarioDAOImp usuarioDAO = new UsuarioDAOImp();
		ProdutoDAOImp produtoDAO = new ProdutoDAOImp();
		Usuario usuario = new Usuario();
		
		
		//Senha do usuario
		Senha senha=new Senha();
		senha.setCodigo("111111");
		logger.info("senha criada ...");
		
		Endereco endereco1=new Endereco();
		endereco1.setEndereco("Rua 10 nº 200 Vila Mariana-GO");
		Endereco endereco2=new Endereco();
		endereco2.setEndereco("Rua 02 nº 205 Jardim Adriana-GO");
		Endereco endereco3=new Endereco();
		endereco3.setEndereco("Rua 03 nº 500 Santo Amaro-SP");
		Endereco endereco4=new Endereco();
		endereco4.setEndereco("Rua 53 nº 500 Vila Cesário-TO");
		logger.info("Endereços criados ...");
		
		/*
		//Cadastro do produto
		Produto prod1=new Produto();
		prod1.setDescricao("Arroz Parbolizado");
		produtoDAO.insereProduto(prod1);
		
		logger.info("Produto "+prod1.getDescricao()+" criado!!");
		
		Produto prod2=new Produto();
		prod2.setDescricao("Morango");
		produtoDAO.insereProduto(prod2);
		
		logger.info("Produto "+prod2.getDescricao()+" criado!!");		
		
		Produto prod3=new Produto();
		prod3.setDescricao("Cajú");
		produtoDAO.insereProduto(prod3);

		logger.info("Produto "+prod3.getDescricao()+" criado!!");		
		
		Produto prod4=new Produto();
		prod4.setDescricao("Cenoura");
		produtoDAO.insereProduto(prod4);	
		
		logger.info("Produto "+prod4.getDescricao()+" criado!!");
		
		*/
		//Passando os dados para o Usuário
				
		List<Produto> produtos = produtoDAO.procurarTodosProdutos();
		Produto[] prod = new Produto[produtos.size()];
		for (int i=0;i < prod.length; i++){
			prod[i]=produtos.get(i);
		}
		
		usuario.setNome("Marcia Azeredo e Silva");
		usuario.setEmail("azeredomarcio@gmail.com");
		
		usuario.setSenha(senha);
		
		usuario.addEndereco(endereco2);
		usuario.addEndereco(endereco2);
		usuario.addEndereco(endereco3);
		usuario.addEndereco(endereco4);
		
		logger.info("Usuário "+usuario.getNome()+" criado com as todas as informações !!!");
		
		if (usuarioDAO.insereUsuario(usuario)){
			System.out.println("Usuário Cadastrado!!");
		} else {
			System.out.println("Cadastro Falhou!!!");
		}
		
		usuario.addProduto(prod[0]);
		usuario.addProduto(prod[1]);
		usuario.addProduto(prod[2]);
		usuario.addProduto(prod[3]);
		
		usuarioDAO.alteraUsuario(usuario);
		
		logger.info("Produtos adicionados para o usuário: "+usuario.getNome());
		
		
		List<Usuario> usuarios = usuarioDAO.procurarPorUsuarioWithCriteria("%Souza%");
		for (Usuario us: usuarios){
			logger.info("Apresentando as informações do usuário: "+us.getNome());
			System.out.println("\n\n--------------------------------------");
			System.out.println("Nome : "+us.getNome());
			System.out.println("Email: "+us.getEmail());
			System.out.println("Senha: "+us.getSenha().getCodigo());
			System.out.println();
			System.out.println("Endereço(s)----------------------");
			for (Endereco end:us.getEnderecos()){
				System.out.print(end.getId()+": ");
				System.out.println(end.getEndereco());
			}
			System.out.println("Produto(s) ------------------------");
			for (Produto prodis:us.getProdutos()){
				System.out.print(prodis.getId()+": ");
				System.out.println(prodis.getDescricao());
			}
			System.out.println("---------------------------------");
		}
		
		System.out.println("Existem "+usuarioDAO.contarUsuariosWithCriteria().get(0)+" usuários cadastrados");
		
		//Mostrando a informação de um produto.
		
		List<Produto> Produtos = produtoDAO.getProdutosByName("C");
		for (Produto prods:produtos){
			if (prod!=null){
				System.out.println("Produto: "+prods.getDescricao());
			} else {
				System.out.println("Não foi possível localizar o produto");
			}
		}	
		
	}

}
