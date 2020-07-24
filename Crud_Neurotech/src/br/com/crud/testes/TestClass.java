package br.com.crud.testes;

import java.sql.SQLException;

import org.junit.Test;
import java.util.Scanner;

import br.com.crud.dao.DAO;
import br.com.crud.model.User;
import junit.framework.TestCase;

public class TestClass extends TestCase {
	DAO userDAO = new DAO();
	Scanner sc = new Scanner(System.in);
	
	
	@Test
	public void TestCase1() {
		System.out.println("Creating a new user...");
		User user1 = new User();
		System.out.println("Insert name: ");
		String nome = sc.nextLine();
		System.out.println("Insert birth date: ");
		String dataNascimento = sc.nextLine();
		System.out.println("Insert gender: ");
		String sexo = sc.next();
		user1.setNome(nome);
		user1.setDataNascimento(dataNascimento);
		user1.setSexo(sexo);
		
		userDAO.save(user1);
		
		assertEquals("User successfully created", true, user1.getId());
	}
	
	
	
}

