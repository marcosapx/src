package dataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.*;



public class BancoDeDados<T> {
	private String url = "jdbc:postgresql://localhost:5432/Loja";
	private String banco = "postgres";
	private String senha = "1234";
	private String driver = "org.postgresql.Driver";
	private Connection con;

	public BancoDeDados() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, banco, senha);
		} catch (ClassNotFoundException objErroDriver) {
			System.err.println("Erro: Carregamento do Driver JDBC");
		} catch (SQLException objErroConexao) {
			System.err.println("Erro: Abertura da Conexao");
		}
	}

	List<T> lista = new ArrayList<T>();

	public List<T> selecionaTodos(String tipoDB) {
		String select = "SELECT * FROM \"" + tipoDB + "\";";
		System.out.println(select);
		try {
			T f = null;
			Statement stmt = con.createStatement();
			ResultSet r = stmt.executeQuery(select);
			while (r.next()) {
				switch (tipoDB) {
				case "Funcionarios":
					f = (T) new Funcionarios(r.getInt(1), r.getString(2),
							r.getString(3), r.getString(4), r.getString(5),
							r.getString(6), r.getString(7));
					break;

				}
				lista.add(f);
			}
			stmt.close();
			return lista;
		} catch (SQLException e) {
			System.err.println("Erro: na Seleção-Todos");
			return null;
		}
	}

	public T seleciona(String tipoDB, T func) {
		String select = "";
		switch (tipoDB) {
		case "Funcionarios":
			select = "SELECT * FROM \" Funcionarios \" WHERE id = " + "'"
					+ ((Funcionarios) func).getid() + "'" + ";";
			break;


		}
		System.out.println(select);
		try {
			T f = null;
			Statement stmt = con.createStatement();
			ResultSet r = stmt.executeQuery(select);
			switch (tipoDB) {
			case "Funcionarios":
				f = (T) new Funcionarios(r.getInt(1), r.getString(2),
						r.getString(3), r.getString(4), r.getString(5),
						r.getString(6), r.getString(7));
				break;
			}
			stmt.close();
			return (T) f;
		} catch (SQLException e) {
			System.err.println("Erro: na Seleção");
			return null;
		}
	}

	public boolean insere(String tipoDB, T f) {
		String insert = "";
		switch (tipoDB) {
		case "Funcionarios":
			insert = "INSERT INTO \"Funcionarios\" (nome,cpf,sexo,tipo,\"user\",senha) VALUES ('"
					+ ((Funcionarios) f).getnome()
					+ "','"
					+ ((Funcionarios) f).getcpf()
					+ "','"
					+ ((Funcionarios) f).getsexo()
					+ "','"
					+ ((Funcionarios) f).gettipo()
					+ "','"
					+ ((Funcionarios) f).getuser()
					+ "','"
					+ ((Funcionarios) f).getsenha() + "')";
			break;

		}
		try {
			PreparedStatement stmt = con.prepareStatement(insert);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.err.println("Erro: na Inserção");
			return false;
		}
	}

	public boolean atualiza(String tipoDB, Funcionarios f) {
		String atualiza = "";
		try {
			switch (tipoDB) {
			case "Funcionarios":
				atualiza = "UPDATE \"Funcionarios\" " +
						"SET nome = " +"'"+ f.getnome()+"', " +
						"cpf = "+ "'"+ f.getcpf()+"'" +
						"sexo = "+ "'"+ f.getsexo()+"'" +
						"tipo = "+ "'"+ f.gettipo()+"'" +
						"\"user\" = "+ "'"+ f.getuser()+"'" +
						"senha = "+ "'"+ f.getsenha()+"'" +
						"WHERE id = "+ "'"+f.getid()+"'";
				break;

			}
			System.out.println(atualiza);
			PreparedStatement stmt = con.prepareStatement(atualiza);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.err.println("Erro: na Atualização");
			return false;
		}
	}

	public boolean deleta(String tipoDB, Funcionarios f) {
		String deleta = "";
		try {
			switch (tipoDB) {
			case "Funcionarios":
					deleta = "DELETE FROM \"Funcionarios\" WHERE id = " + "'"+ f.getid() + "'";
				break;

			default:
				break;
			}
			System.out.println(deleta);
			PreparedStatement stmt = con.prepareStatement(deleta);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.err.println("Erro: na Deleção");
			return false;
		}
	}

	public Funcionarios Login(String user, String senha) {
		try {
			String login = "SELECT * FROM \"Funcionarios\" WHERE \"user\"= '"
					+ user + "' and senha='" + senha + "';";
			System.out.println(login);

			Statement stmt = con.createStatement();
			ResultSet r = stmt.executeQuery(login);

			if (r.next()) {
				System.out.println(" Logado");
				Funcionarios f = new Funcionarios(r.getInt(1), r.getString(2),
						r.getString(3), r.getString(4), r.getString(5),
						r.getString(6), r.getString(7));
				stmt.close();
				return f;
			} else {
				System.out.println("login ou senha incorretos");
				stmt.close();
				return null;
			}
		} catch (SQLException e) {
			System.err.println("Erro: no login");
			return null;
		}
	}

}