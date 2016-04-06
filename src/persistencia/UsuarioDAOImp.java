package persistencia;

import hibernateApp.Usuario;
import hibernateUtils.HibernateUtilArcade;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class UsuarioDAOImp implements UsuarioDAO {
	
	private Session session = null;
	private Transaction transaction = null;

	public boolean insereUsuario(Usuario usuario) {
		boolean retorno=false;
		
		try {
			session = HibernateUtilArcade.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(usuario);
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

	public boolean alteraUsuario(Usuario usuario) {
		boolean retorno=false;
		
		try {
			session = HibernateUtilArcade.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(usuario);
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

	public boolean excluiUsuario(Usuario usuario) {
		boolean retorno=false;
		
		try {
			session = HibernateUtilArcade.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(session.get(Usuario.class,usuario.getUsuarioId()));
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

	public Usuario procurarUsuario(Usuario usuario) {
		Usuario u =null;
		
		try {
			session = HibernateUtilArcade.getSessionFactory().openSession();
			u = (Usuario) session.get(Usuario.class, usuario.getUsuarioId());	
		}catch (HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return u;
	}

	public List<Usuario> procurarTodosUsuario() {
		List<Usuario> list = null;
		
		try {
			session = HibernateUtilArcade.getSessionFactory().openSession();
			list = session.createQuery("select o from Usuario o").list();
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
	public List<Usuario> procurarPorUsuarioWithCriteria(String name){
		List<Usuario> list = null;
		
		try {
			session = HibernateUtilArcade.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(Usuario.class);
			criteria.add(Restrictions.like("nome", name));
			criteria.setFirstResult(0);
			criteria.setMaxResults(2);
			list = criteria.list();
		}catch (HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
	/*
	 * Counting number of rows with Projections
	 */
	public List<?> contarUsuariosWithCriteria(){
		List<?> count=null;
		try {
			session = HibernateUtilArcade.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(Usuario.class);
			criteria.setProjection(Projections.rowCount());
			count = criteria.list();
		}catch (HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return count;
	}
}
