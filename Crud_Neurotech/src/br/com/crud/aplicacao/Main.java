package br.com.crud.aplicacao;

import java.sql.SQLException;

import br.com.crud.dao.DAO;
import br.com.crud.model.User;

public class Main {

	//inser��o de dados no banco - CREATE
	public static void main(String[] args) throws SQLException {
		
		/*DAO userDAO = new DAO();

		User user1 = new User();
		user1.setNome("Maria da Silva");
		//user1.setId(01);  || alterado para auto_increment
		user1.setDataNascimento("25/06/1984");
		user1.setSexo("F");
		
		userDAO.save(user1);*/
		
	//visualiza��o de dados do banco - READ
		
		/*for(User u : userDAO.getUsers()) {
			System.out.println("ID:" + u.getId());
			System.out.println("Usu�rio:" + u.getNome());
			System.out.println("Usu�rio:" + u.getDataNascimento());
			System.out.println("Usu�rio:" + u.getSexo());
			System.out.println("---------------------------");
			
		}*/
		
	//atualiza��o dos dados do banco - UPDATE
		/*DAO updateDAO = new DAO();
		
		updateDAO.update("Joao Oliveira", "28/10/1995", "M", 7);*/
		
	//elimina��o de dados do banco - DELETE
		DAO deleteDAO = new DAO();
				
		deleteDAO.delete(2);
	}
	
	
}