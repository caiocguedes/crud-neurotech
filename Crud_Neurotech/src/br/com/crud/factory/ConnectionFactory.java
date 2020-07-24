//classe de conexão com o SGBD

package br.com.crud.factory;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory { //classe de conexão com o banco
	private static final String USERNAME = "root"; //usuário do banco
	private static final String PASSWORD = "root"; //senha do banco
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/crud?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";//caminho do banco
	
	
	//conexão com o banco
	
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver"); //Faz o apontamento do driver para que a JVM carregue a classe
		
		
		//criando a conexão com o banco utilizando um casting
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);//busca a conexão de acordo com os dado passados acima
		
		return connection;
	}
	
	//verificando se a conexão está ativa para que não sejam criadas novas conexões com o banco desnecessariamente
	public static void main(String[] args) throws Exception {
		Connection con = createConnectionToMySQL();//recuperando a conexão com o banco de dados
	
		//testando a conexão
		if(con!=null) {
			System.out.println("Connected successfully.");
			((java.sql.Connection)con).close();
		}
		
		
	}
}
