package br.com.crud.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.crud.dao.DAO;
import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.User;

public class DAOTest {

	DAO testeDao = new DAO();
	User tester = new User();
	
	String nome = "Test";
	String dataNascimento = "23/07/2020";
	String sexo = "M";
	int id = 1;
	String nomeUpdate = "Test Update";
	String dataNascimentoUpdate = "20/07/2020";
	String sexoUpdate = "F";
	int idDelete = 1;
	
	@Test
	public final void testSave() throws SQLException {
		String sql = "INSERT INTO users(nome, dataNascimento, sexo) VALUES (?, ?, ?)"; 
		
		Connection conn = null;
		PreparedStatement pstm = null;//preparação da estrutura de execução do java com o SQL
		
		
		try {
			//cria uma conexão com o banco de dados
			conn = (Connection) ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);//executa uma query
			//passando os valores esperados pela query
			
			pstm.setString(1, nome);
			pstm.setString(2, dataNascimento);
			pstm.setString(3, sexo);
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//fechando conexões
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
					e.printStackTrace();
					 
				}
			}
		}

	@Test
	public final void testGetUsers() {
		for(User u : testeDao.getUsers()) {
			System.out.println("ID:" + u.getId());
			System.out.println("User:" + u.getNome());
			System.out.println("User:" + u.getDataNascimento());
			System.out.println("User:" + u.getSexo());
			System.out.println("---------------------------");
		}
	}
	
	@Test
	public final void testUpdate() throws SQLException {
		testeDao.update(nomeUpdate, dataNascimentoUpdate, sexoUpdate, id);
		assertNotEquals(nomeUpdate, nome);
	}
	
	@Test
	public final void testDelete() throws SQLException {
		testeDao.delete(id);
	}
}
