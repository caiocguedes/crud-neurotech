package br.com.crud.aplicacao;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.crud.dao.DAO;
import br.com.crud.model.User;

public class Main {

		public static void main(String[] args) throws SQLException {
			DAO userDAO = new DAO(); //chamando a classe para executar os m�todos setados nela
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);//fazendo leitura do que � digitado no teclado 
			System.out.println("CRUD System\n");
			
			String input = "";
			
			for(int i = 0; ; ) {
				//menu do usu�rio
				System.out.println("|    Option    | Meaning |");
				System.out.println("|------------------------|");
				System.out.println("|      C       | Create  |");
				System.out.println("|      R       | Read    |");
				System.out.println("|      U       | Update  |");
				System.out.println("|      D       | Delete  |");
				System.out.println("|      E       | Exit    |");
				

				System.out.println("\n\nChoose one option = ");
				input = sc.next();
				sc.nextLine();
				
				
				if(input.contentEquals("C")) {//verifica se a op��o digitada equivale ao create e inicia a cria��o do user
					System.out.println("Creating a new user...");
					User user1 = new User();
					System.out.println("Insert name: ");
					String nome = sc.nextLine();//mostra a linha atual e avan�a para a pr�xima
					System.out.println("Insert birth date: ");
					String dataNascimento = sc.nextLine();
					System.out.println("Insert gender: ");
					String sexo = sc.next();//retorna a pr�xima informa��o do scanner
					user1.setNome(nome);
					user1.setDataNascimento(dataNascimento);
					user1.setSexo(sexo);
					
					userDAO.save(user1);//chama o m�todo e salva
					
				} else if(input.contentEquals("R")) {
					for(User u : userDAO.getUsers()) {//para cada usu�rio existente no banco, mostra as informa��es solicitadas com os getters
						System.out.println("ID:" + u.getId());
						System.out.println("User:" + u.getNome());
						System.out.println("User:" + u.getDataNascimento());
						System.out.println("User:" + u.getSexo());
						System.out.println("---------------------------");
					}
				} else if(input.contentEquals("U")) {
					DAO updateDAO = new DAO();
					
			
					System.out.println("Please insert the user ID: ");
					int id = sc.nextInt();
					sc.nextLine();

					System.out.println("Insert name: ");
					String nome = sc.nextLine();
					System.out.println("Insert the birth date: ");
					String dataNascimento = sc.nextLine();
					System.out.println("Insert gender: ");
					String sexo = sc.next();
					
										
					updateDAO.update(nome, dataNascimento, sexo, id);//faz o update de acordo com os valores passados
					
				} else if(input.contentEquals("D")) {
					System.out.println("Please insert the user ID: ");
					int id = sc.nextInt();
					
					DAO deleteDAO = new DAO();
					
					deleteDAO.delete(id);
				} else if(input.contentEquals("E")){
					System.out.println("Your request has finished.");
					break;
				}
				
				i++;
			}
			
			System.out.println("Thank you for using the system.");

		}
	
	
}
	


