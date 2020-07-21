//classe de conexão com o SGBD

package br.com.crud.factory;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String USERNAME = "root"; //usuário do banco
	private static final String PASSWORD = "Unibratec#1"; //senha do banco
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/crud?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";//caminho do banco
	
	
	//conexão com o banco
	
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver"); //Faz com que a JVM carregue a classe
		
		
		//criando a conexão com o banco utilizando um casting
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	//verificando se a conexão está ativa para que não sejam criadas novas conexões com o banco desnecessariamente
	public static void main(String[] args) throws Exception {
		Connection con = createConnectionToMySQL();//recuperando a conexão com o banco de dados
	
		if(con!=null) {
			System.out.println("Conectado com sucesso.");
			((java.sql.Connection)con).close();
		}
		
		
	}
}
