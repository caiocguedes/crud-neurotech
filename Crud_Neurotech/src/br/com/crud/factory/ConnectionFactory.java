//classe de conex�o com o SGBD

package br.com.crud.factory;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory { //classe de conex�o com o banco
	private static final String USERNAME = "root"; //usu�rio do banco
	private static final String PASSWORD = "root"; //senha do banco
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/crud?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";//caminho do banco
	
	
	//conex�o com o banco
	
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver"); //Faz o apontamento do driver para que a JVM carregue a classe
		
		
		//criando a conex�o com o banco utilizando um casting
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);//busca a conex�o de acordo com os dado passados acima
		
		return connection;
	}
	
	//verificando se a conex�o est� ativa para que n�o sejam criadas novas conex�es com o banco desnecessariamente
	public static void main(String[] args) throws Exception {
		Connection con = createConnectionToMySQL();//recuperando a conex�o com o banco de dados
	
		//testando a conex�o
		if(con!=null) {
			System.out.println("Connected successfully.");
			((java.sql.Connection)con).close();
		}
		
		
	}
}
