package dataBase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Funcionarios;



public class InstallDB {
	private String url = "jdbc:postgresql://localhost:5432/Loja";
	private String banco = "postgres";
	private String senha = "1234";
	private String driver = "org.postgresql.Driver";
	private Connection con;
	public InstallDB() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, banco, senha);
		} catch (ClassNotFoundException objErroDriver) {
			System.err.println("Erro: Carregamento do Driver JDBC");
		} catch (SQLException objErroConexao) {
			System.err.println("Erro: Abertura da Conexao");
		}
	}

	public void criarTabelas() {

		
		
		String tabela1 = "CREATE TABLE \"Funcionarios\"(  id bigserial NOT NULL,  nome character varying(80),  cpf character varying(20),  sexo character varying(1),  tipo character varying(1),  \"user\" character varying(50),  senha character varying(50),  CONSTRAINT \"Funcionarios_pkey\" PRIMARY KEY (id))WITH (  OIDS=FALSE);ALTER TABLE \"Funcionarios\"  OWNER TO postgres;";
		String userRoot = "INSERT INTO \"Funcionarios\" (nome,cpf,sexo,tipo,\"user\",senha) VALUES ('"
				+ "marcos"
				+ "','"
				+ "100"
				+ "','"
				+ "m"
				+ "','"
				+ "a"
				+ "','"
				+ "mashiro" + "','" + "1234" + "')";

		try {
			PreparedStatement stmt = con.prepareStatement(tabela1);
			stmt.execute();
			stmt.close();
			stmt = con.prepareStatement(userRoot);
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			System.err.println("Erro: na Inserção");
		}
	}
	

	public static void main(String[] args) {
		InstallDB b = new InstallDB();
		b.criarTabelas();
	}
}