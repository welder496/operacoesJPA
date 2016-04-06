package hibernateUtils;

import hibernateApp.Endereco;
import hibernateApp.Produto;
import hibernateApp.Senha;
import hibernateApp.Usuario;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.jboss.logging.Logger;

public class GerarTabelas {

	private static final Logger logger=Logger.getLogger(GerarTabelas.class);
	
	public static void main(String[] args) {
		/*
		 * Using hibernate to generaty Usuario Table
		 */
		AnnotationConfiguration conf = new AnnotationConfiguration().configure("hibernate.cfg.xml");
		conf.addAnnotatedClass(Usuario.class);
		
		SchemaExport sE = new SchemaExport(conf);
		sE.create(true,true);
		
		logger.info("Tabela "+Usuario.class.getName()+" foi criada!!");
		logger.info("Tabela "+Produto.class.getName()+" foi criada!!");		
		logger.info("Tabela "+Senha.class.getName()+" foi criada!!");		
		logger.info("Tabela "+Endereco.class.getName()+" foi criada!!");	}

}
