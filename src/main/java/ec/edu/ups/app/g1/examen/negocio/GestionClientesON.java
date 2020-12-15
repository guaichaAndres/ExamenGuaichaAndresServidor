package ec.edu.ups.app.g1.examen.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.app.g1.examen.dao.ClienteDAO;
import ec.edu.ups.app.g1.examen.modelo.Cliente;

@Stateless
public class GestionClientesON implements GestionClientesONRemoto {
	@Inject
	private ClienteDAO daoCliente;

	public boolean registrarCliente(Cliente cliente) throws Exception {
		// validado procesado
		try {
			daoCliente.insert(cliente);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error al registrar");
		}
		return true;
	}
	public List<Cliente> listarClienteDNI(String dni) {
		return daoCliente.listarClienteDNI(dni);
	}
}
