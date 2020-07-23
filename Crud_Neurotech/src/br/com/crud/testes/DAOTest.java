package br.com.crud.testes;

import br.com.crud.model.User;
import java.sql.SQLException;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.crud.dao.DAO;

public class DAOTest extends DAO {
	DAO testeDAO;
	@BeforeClass

	@Before
	public void setUp() throws Exception {
		testeDAO = new DAO();
	}

	@Test
	public void testSave()  {
		TestClassForMock mockObject = Mockito.mock(TestClassForMock.class);
		Mockito.when(DAO.save(user)).thenReturn();
		Mockito.doCallRealMethod().when(DAO.save(user).thenReturn(user);
	}

	@Test
	public void testGetUsers() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		
	}

	@Test
	public void testDelete() {
		when(DAO.save(user)).thenReturn(user);
		Mockito.doCallRealMethod().when(DAO.delete(id)).delete(user);
	}

}
