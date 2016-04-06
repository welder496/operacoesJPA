package persistencia;

import hibernateApp.Produto;
import hibernateUtils.HibernateUtilArcade;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProdutoDAOImp implements ProdutoDAO {

	private Session session = null;
	private Transaction transaction = null;
	
	public boolean insereProduto(Produto produto) {
		boolean retorno=false;
		
		try {
			session = HibernateUtilArcade.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(produto);
			transaction.commit();
			retorno = true;
		}catch (HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return retorno;		
	}

	public boolean alteraProduto(Produto produto) {
		boolean retorno=false;
		
		try {
			session = HibernateUtilArcade.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(produto);
			transaction.commit();
			retorno = true;
		}catch (HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return retorno;		
	}

	public boolean excluiProduto(Produto produto) {
		boolean retorno=false;
		
		try {
			session = HibernateUtilArcade.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(session.get(Produto.class,produto.getId()));
			transaction.commit();
			retorno = true;
		}catch (HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return retorno;			
	}

	public Produto procurarProduto(Produto produto) {
		Produto p=null;
		
		try {
			session = HibernateUtilArcade.getSessionFactory().openSession();
			p = (Produto) session.get(Produto.class, produto.getId());
		}catch (HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return p;	
	}

	public List<Produto> procurarTodosProdutos() {
		List<Produto> list =null;
		
		try {
			session = HibernateUtilArcade.getSessionFactory().openSession();
			list = session.createQuery("select p from Produto p").list();
		}catch (HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;	
	}

	/*
	 * Consultas com HQL e Criteria
	 */
	public Produto getProdutoByName(String name){
		Produto temp = null;
		try{
			session = HibernateUtilArcade.getSessionFactory().openSession();
			Query query = session.createQuery("from Produto p where p.descricao like :descricao");
			query.setParameter("descricao","%"+name+"%");
			temp = (Produto) query.uniqueResult();
		}catch (NonUniqueResultException e){
			return null;
		}catch (HibernateException e){
		    e.printStackTrace();
		}finally{
			session.close();
		}
		return temp;
	}
	
	
	public List<Produto> getProdutosByName(String name){
		List<Produto> produtos = null;
		try {
			session = HibernateUtilArcade.getSessionFactory().openSession();
			Query query = session.createQuery("from Produto p where p.descricao like :descricao");
			query.setParameter("descricao","%"+name+"%");
			produtos = query.list();
		}catch (HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return produtos;
	}
}
