package persistencia;

import hibernateApp.Produto;

import java.util.List;

public interface ProdutoDAO {

	boolean insereProduto(Produto produto);
	boolean alteraProduto(Produto produto);
	boolean excluiProduto(Produto produto);
	Produto procurarProduto(Produto produto);
	List<Produto> procurarTodosProdutos();
	
}
