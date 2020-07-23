package br.com.crud.aplicacao;

import java.sql.SQLException;

import br.com.crud.dao.DAO;
import br.com.crud.model.User;

public class Main {

	//inserção de dados no banco - CREATE
	public static void main(String[] args) throws SQLException {
		
		DAO userDAO = new DAO();

		User user1 = new User();
		user1.setNome("Elias Souza");
		//user1.setId(01);  || alterado para auto_increment
		user1.setDataNascimento("22/02/1982");
		user1.setSexo("M");
		
		userDAO.save(user1);
		
	//visualização de dados do banco - READ
		
		/*for(User u : userDAO.getUsers()) {
			System.out.println("ID:" + u.getId());
			System.out.println("Usuário:" + u.getNome());
			System.out.println("Usuário:" + u.getDataNascimento());
			System.out.println("Usuário:" + u.getSexo());
			System.out.println("---------------------------");
			
		}*/
		
	//atualização dos dados do banco - UPDATE
		/*DAO updateDAO = new DAO();
		
		updateDAO.update("Pepe Legal", "02/10/1955", "M", 7);*/
		
	//eliminação de dados do banco - DELETE
		/*DAO deleteDAO = new DAO();
				
		deleteDAO.delete(5);*/
	}
	

}
