//criação do DAO para aplicação das regras de negócio
package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.User;

public class DAO {
	
	//criação do CRUD
	
	public void save(User user) {
		//inserindo parsing para que os parâmetros inseridos substituam as interrogações
		String sql = "INSERT INTO users(nome, dataNascimento, sexo) VALUES (?, ?, ?)"; 
		
		Connection conn = null;
		PreparedStatement pstm = null;//preparação da estrutura de execução do java com o SQL
		
		try {
			//cria uma conexão com o banco de dados
			conn = (Connection) ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);//executa uma query
			//passando os valores esperados pela query
			pstm.setString(1, user.getNome());
			pstm.setString(2, user.getDataNascimento());
			pstm.setString(3, user.getSexo());
			
			pstm.execute();
			
			System.out.println("Usuário inserido com sucesso na base de dados.");
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
	
	@SuppressWarnings("finally")
	public List<User> getUsers() {
		
		String sql = "SELECT * FROM USERS";
		
		List<User> users = new ArrayList<User>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				User user = new User();
				
				//recupera o id
				user.setId(rset.getInt("id"));
				//recupera o nome
				user.setNome(rset.getString("nome"));
				//recupera a data de nascimento
				user.setDataNascimento(rset.getString("dataNascimento"));
				//recupera o sexo
				user.setSexo(rset.getString("sexo"));
				
				users.add(user);
			
			}
		}catch(Exception e) {
			e.printStackTrace();
			}finally {
			try {
				if(rset!=null) {
					rset.close();
				}
				
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch(final Exception e) {
				e.printStackTrace();	
			}
			
				
			return users;	
			}
			
		}
	
	public void update(String nome, String dataNascimento, String sexo, int id) throws SQLException {
				String sql = "UPDATE users SET nome=?, dataNascimento=?, sexo=? WHERE id=?";//query de atualização do banco 
				
				Connection conn = null;
				PreparedStatement pstm = null;//preparação da estrutura de execução do java com o SQL
				
				try {
					//cria uma conexão com o banco de dados
					conn = (Connection) ConnectionFactory.createConnectionToMySQL();
					
					pstm = conn.prepareStatement(sql);//executa uma query
					//passando os valores de atualização da query de acordo com os parâmetros do método update
					pstm.setString(1, nome);
					pstm.setString(2, dataNascimento);
					pstm.setString(3, sexo);
					pstm.setInt(4, id);
					
					pstm.executeUpdate();//executa o update
					
					System.out.println("Dados alterados com sucesso.");
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

	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM users WHERE id=?";//query de delete do banco 
		
		Connection conn = null;
		PreparedStatement pstm = null;//preparação da estrutura de execução do java com o SQL
		
		try {
			//cria uma conexão com o banco de dados
			conn = (Connection) ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);//executa uma query
			//passando os valores do delete de acordo com o id do usuário em questão
			pstm.setInt(1, id);
			
			pstm.executeUpdate();//executa o update
			
			System.out.println("Dados deletados.");
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
}
