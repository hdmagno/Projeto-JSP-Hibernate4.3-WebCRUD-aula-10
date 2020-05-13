package persistence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import entity.Cliente;

public class ClienteDao extends Dao {

	public void createTableCliente() throws Exception {
		open();
		String bd = "use bd_aula10";
		String sql = "create table cliente (" + "id bigint primary key auto_increment not null,"
				+ "nome varchar(50) not null," + "datanascimento date not null" + ")";
		stmt = con.prepareStatement(bd);
		stmt.execute();
		stmt = con.prepareStatement(sql);
		stmt.execute();
		con.close();
	}

	public void create(Cliente c) throws Exception {
		open();
		String sql = "insert into cliente values (null,?,?)";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, c.getNome());
		stmt.setDate(2, (new java.sql.Date(c.getDataNascimento().getTime())));
		stmt.execute();
		close();
	}

	public List<Cliente> findAll() throws Exception {
		open();
		List<Cliente> clientes = new ArrayList<>();
		String sql = "select * from cliente";
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while (rs.next()) {
			Cliente cliente = new Cliente();
			cliente.setId(rs.getLong("id"));
			cliente.setNome(rs.getString("nome"));
			cliente.setDataNascimento(rs.getDate("dataNascimento"));
			clientes.add(cliente);
		}
		con.close();
		return clientes;

	}

}
