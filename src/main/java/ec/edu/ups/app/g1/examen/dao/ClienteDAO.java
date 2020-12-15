package ec.edu.ups.app.g1.examen.dao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import ec.edu.ups.app.g1.examen.modelo.Cliente;

@Stateless
public class ClienteDAO {
	private EntityManager em;
	
	public ClienteDAO(){
	}
	
	public boolean insert(Cliente c) throws Exception {
		boolean bandera = true;
		try {
			em.persist(c);
		}catch(Exception e) {
			bandera = false;
		}
		return bandera;
	}
		
	public Cliente read(String dni) throws Exception{
		try {
			return em.find(Cliente.class, dni);
		}catch(Exception e) {
			throw new Exception("Error al leer Cliente");
		}
	}
	
	public List<Cliente> listarClienteDNI(String dni){
		String jpql = "SELECT u FROM Cliente u WHERE u.dni = ?1";
		Query q = em.createNativeQuery(jpql, Cliente.class);
		q.setParameter(1, dni);
		return (List<Cliente>) q.getResultList();
	}
}
