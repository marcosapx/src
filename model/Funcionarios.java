package model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Funcionarios {
	
	private final IntegerProperty id;
	private final StringProperty nome;
	private final StringProperty cpf;
	private final StringProperty sexo;
	private final StringProperty tipo;
	private final StringProperty user;
	private final StringProperty senha;

	

	
	public Funcionarios(Integer id,String nome,String cpf,String sexo,String tipo,String user,String senha) {
		this.id = new SimpleIntegerProperty(id);
		this.nome = new SimpleStringProperty(nome);
		this.cpf = new SimpleStringProperty(cpf);
		this.sexo = new SimpleStringProperty(sexo);
		this.tipo = new SimpleStringProperty(tipo);
		this.user = new SimpleStringProperty(user);
		this.senha = new SimpleStringProperty(senha);
	}
	
	public Integer getid() {
		return id.get();
	}

	public void setid(Integer id) {
		this.id.set(id);
	}
	
	public IntegerProperty idProperty() {
		return id;
	}
	
	public String getnome() {
		return nome.get();
	}

	public void setnome(String nome) {
		this.nome.set(nome);
	}
	
	public StringProperty nomeProperty() {
		return nome;
	}
	
	public String getcpf() {
		return cpf.get();
	}

	public void setcpf(String cpf) {
		this.cpf.set(cpf);
	}
	
	public StringProperty cpfProperty() {
		return cpf;
	}
	
	public String getsexo() {
		return sexo.get();
	}

	public void setsexo(String sexo) {
		this.sexo.set(sexo);
	}
	
	public StringProperty sexoProperty() {
		return sexo;
	}
	
	public String gettipo() {
		return tipo.get();
	}

	public void settipo(String tipo) {
		this.tipo.set(tipo);
	}
	
	public StringProperty tipoProperty() {
		return tipo;
	}
	
	public String getuser() {
		return user.get();
	}

	public void setuser(String user) {
		this.user.set(user);
	}
	
	public StringProperty userProperty() {
		return user;
	}
	
	public String getsenha() {
		return senha.get();
	}

	public void setsenha(String senha) {
		this.senha.set(senha);
	}
	
	public StringProperty senhaProperty() {
		return senha;
	}

}