package persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jcommon.encryption.SimpleMD5;

import entity.Usuario;

public class UsuarioDao {

	static Session session;
	static Transaction transaction;
	static Query query;

	public String criptografia(String senha) {
		SimpleMD5 md5 = new SimpleMD5(senha, "hdmagno@gmail.com.www.hdmagno.com.br13052020@");
		return md5.toHexString();
	}

	public void create(Usuario u) throws Exception {
		u.setSenha(criptografia(u.getSenha()));
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(u);
		transaction.commit();
		session.close();
	}

	public Usuario findByLogin(Usuario u) {
		u.setSenha(criptografia(u.getSenha()));
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("select u from Usuario u where u.email=:param1 and u.senha=:param2");
		query.setParameter("param1", u.getEmail());
		query.setParameter("param2", u.getSenha());
		Usuario usuario = (Usuario) query.uniqueResult();
		session.close();
		return usuario;
	}
	
	public static void main(String[] args) {
		
		UsuarioDao dao = new UsuarioDao();
		
		Usuario u = new Usuario(4, "diego@gmail.com", "123456");
		System.out.println(dao.findByLogin(u) + " <-");
	}
}
