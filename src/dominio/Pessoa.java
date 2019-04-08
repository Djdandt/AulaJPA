package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Define a classe como uma entidade
//Cria na tabela de dados com o mesmo nome da classe e metodos
@Entity
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//Define que será único
	@Id
	//Será criado automaticamente no banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	
	public Pessoa(){
		
	}
	
	public Pessoa(Integer id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Pessoa [id = " + id + ", nome  = " + nome + ", e-mail = " + email + "]";
	}
	
}
