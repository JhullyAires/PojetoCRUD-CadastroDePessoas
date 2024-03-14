package org.aires.model;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity //Declarar para Framework
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	private String nome;
	private Date idade;
	private String sexo;

	//Entidade UM PARA UM
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Endereco endereco = new Endereco();

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getIdade() {
		return idade;
	}
	public void setIdade(Date idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return id == other.id;
	}
}
