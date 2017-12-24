package br.com.token.communicator;
import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String email;
	private String telefone;

	public void setId(Integer id) { 
		this.id = id; 
	}

	public Integer getId() { 
		return id; 
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefone() {
		return this.telefone;
	}

}