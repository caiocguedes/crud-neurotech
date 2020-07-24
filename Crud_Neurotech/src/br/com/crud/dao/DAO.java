//cria��o do DAO para aplica��o das regras de neg�cio
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
	
	//cria��o do CRUD
	
	public void save(User user) {
		//query de inser��o de dados no banco
		//parsing para que os par�metros inseridos substituam as interroga��es
		String sql = "INSERT INTO users(nome, dataNascimento, sexo) VALUES (?, ?, ?)"; 
		
		Connection conn = null;
		PreparedStatement pstm = null;//vari�vel onde ser� montada a query de acordo com os par�metros passados
		
		try {//verificando a conex�o do banco
			//cria uma conex�o com o banco de dados
			conn = (Connection) ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);//pega a conex�o, prepara o statement e executa a query sql
			//passando os valores esperados pela query
			pstm.setString(1, user.getNome());
			pstm.setString(2, user.getDataNascimento());
			pstm.setString(3, user.getSexo());
			
			
			pstm.execute();//executa a query
			
			System.out.println("User inserted successfully.");
		}catch (Exception e) {//tratamento de exce��o
			e.printStackTrace();
		}finally {//caso d� certo, finaliza as conex�es com o banco
			
			//fechando conex�es
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {//caso a conex�o ainda esteja ativa, fecha a conex�o
					conn.close();
				}
			}catch(Exception e) {//caso mais alguma coisa d� errado, gera uma outra exce��o
					e.printStackTrace();
				}
			}
		}
	
	@SuppressWarnings("finally")
	public List<User> getUsers() {//fazendo uma listagem de contatos
		
		String sql = "SELECT * FROM USERS";
		
		List<User> users = new ArrayList<User>();//criando lista para guardar os dados buscados no banco
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {//conectando com o banco, igual ao m�todo anterior
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			//classe que recupera os dados do banco
			rset = pstm.executeQuery();//recebe os dados que vieram do banco
			
			while (rset.next()) {//enquanto existirem registros no banco...
				
				User user = new User();//...cria uma nova inst�ncia de usu�rio...
				
				//...e seta os dados de acordo com o que ser� passado na execu��o do Main.
				
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
				String sql = "UPDATE users SET nome=?, dataNascimento=?, sexo=? WHERE id=?";//query de atualiza��o do banco 
				
				Connection conn = null;
				PreparedStatement pstm = null;//prepara��o da estrutura de execu��o do java com o SQL
				
				try {
					//cria uma conex�o com o banco de dados
					conn = (Connection) ConnectionFactory.createConnectionToMySQL();
					
					pstm = conn.prepareStatement(sql);//executa uma query
					//passando os valores de atualiza��o da query de acordo com os par�metros do m�todo update
					pstm.setString(1, nome);
					pstm.setString(2, dataNascimento);    //valores ser�o setados para atualiza��o e n�o buscados na classe User!
					pstm.setString(3, sexo);
					pstm.setInt(4, id);
					
					pstm.executeUpdate();//executa o update
					
					System.out.println("Daata changed successfully.");
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					
					//fechando conex�es
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
		PreparedStatement pstm = null;//prepara��o da estrutura de execu��o do java com o SQL
		
		try {
			//cria uma conex�o com o banco de dados
			conn = (Connection) ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);//executa uma query
			//passando os valores do delete de acordo com o id do usu�rio em quest�o
			pstm.setInt(1, id);
			
			pstm.executeUpdate();//executa o update
			
			System.out.println("Data deleted successfully.");
		
		}catch (Exception e) {
			e.printStackTrace();
		
		}finally {
			
			//fechando conex�es
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