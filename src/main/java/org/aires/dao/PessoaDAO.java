package org.aires.dao;

import org.aires.model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

	EntityManagerFactory sf = Persistence.createEntityManagerFactory("CadastroPessoa");
	EntityManager em2 = sf.createEntityManager();

	private List<Pessoa> todos= new ArrayList<Pessoa>();

	@SuppressWarnings("unchecked")
	public List<Pessoa> getTodasPessoas() {
		return em2.createQuery("From Pessoa").getResultList();
	}
	public void setTodasPessoas(List<Pessoa> todos) {
		this.todos = todos;
	}

	private Pessoa pessoa = new Pessoa();
	private static Pessoa pessoaId = new Pessoa();

	public Pessoa getPessoaId() {
		return em2.find(Pessoa.class, pessoaId.getId());
	}
	@SuppressWarnings("static-access")
	public void setPessoaId(Pessoa pessoaId) {
		this.pessoaId = pessoaId;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> listaPessoas() {
		return todos;
	}

	// CREATE
	public void cadastrarPessoas() {
		System.out.println("[Entrou]\n");
		em2.getTransaction().begin();

		pessoa.setNome(pessoa.getNome());
		pessoa.setIdade(pessoa.getIdade());
		pessoa.setSexo(pessoa.getSexo());

		pessoa.getEndereco().setLogradouro(pessoa.getEndereco().getLogradouro());
		pessoa.getEndereco().setCidade(pessoa.getEndereco().getCidade());
		pessoa.getEndereco().setEstado(pessoa.getEndereco().getEstado());
		pessoa.getEndereco().setNumero(pessoa.getEndereco().getNumero());
		pessoa.getEndereco().setCep(pessoa.getEndereco().getCep());

		em2.persist(pessoa);
		em2.getTransaction().commit();
		em2.close();

		System.out.println("Cadastrado\n");
	}

	// READ
	public void consultarPessoaId() {
		System.out.println("[ENTROU NO CONSULTA]");
		em2.getTransaction().begin();
		Query p = em2.createQuery("From Pessoa");
		@SuppressWarnings("unchecked")
		List<Pessoa> pessoas = p.getResultList();

		for (Pessoa c : pessoas) {
			if(pessoa.getId() == c.getId()) {
				pessoaId = em2.find(Pessoa.class, pessoa.getId());
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> consultarTodasPessas() {
		System.out.println("[Entrou]");
		return em2.createQuery("From Pessoa").getResultList();
	}

	// UPDATE
	public void alterarPessoa () {
		System.out.println("[Entrou]\n");
		em2.getTransaction().begin();
		Query p = em2.createQuery("From Pessoa");
		@SuppressWarnings("unchecked") 
		List<Pessoa> pessoas = p.getResultList();

		for (Pessoa c : pessoas) {
			if(pessoa.getId() == c.getId()) {
				pessoa = em2.find(Pessoa.class, pessoa.getId());

				pessoa.setNome(pessoa.getNome());
				pessoa.setIdade(pessoa.getIdade());
				pessoa.setSexo(pessoa.getSexo());

				pessoa.getEndereco().setLogradouro(pessoa.getEndereco().getLogradouro());
				pessoa.getEndereco().setCidade(pessoa.getEndereco().getCidade());
				pessoa.getEndereco().setEstado(pessoa.getEndereco().getEstado());
				pessoa.getEndereco().setNumero(pessoa.getEndereco().getNumero());
				pessoa.getEndereco().setCep(pessoa.getEndereco().getCep());

				em2.merge(pessoa);
				em2.getTransaction().commit();
				em2.close();
				System.out.println("Alterado\n");
				break;
			}
		}
	}

	// DELETE
	public void excluirUnico () {
		System.out.println("[Entrou]\n");
		em2.getTransaction().begin();
		Query p = em2.createQuery("From Pessoa");
		@SuppressWarnings("unchecked") 
		List<Pessoa> pessoas = p.getResultList();

		for (Pessoa c : pessoas) {
			if(c.getId() == c.getId()) {
				System.out.println("pessoa removida\n");
				em2.remove(pessoa.getId());
				em2.getTransaction().commit();
				em2.close();				
				break;
			}
		}
	}	

	public void excluirTodos () {
		System.out.println("[Entrou]\n");
		em2.getTransaction().begin();
		int quant = em2.createQuery("Delete From Pessoa").executeUpdate();
		em2.getTransaction().commit();
		System.out.println("Quantidade de Pessoas Removidas: " + quant);
		System.out.println("Pessoas Removidas com Sucesso!\n");
	}

}
