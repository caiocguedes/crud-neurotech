package br.com.crud.testes;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import br.com.crud.dao.DAO;

public class DAOTestOld extends DAO{
	
	DAO testeDAO;
	@Before
	public void setUp() throws Exception {
		testeDAO = new DAO();
	}

	@Test
	public void testSave() {
		
	}

	@Test
	public void testUpdate() throws SQLException {
		DAO updateDAO = new DAO();
		
		updateDAO.update("Pepe Legal", "02/10/1955", "M", 7);
	}

	@Test
	public void testDelete() throws SQLException {
		DAO deleteDAO = new DAO();
		
		deleteDAO.delete(6);
		
		
	}

}
