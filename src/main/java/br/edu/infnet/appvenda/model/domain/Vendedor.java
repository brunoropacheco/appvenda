package br.edu.infnet.appvenda.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.Transient;

@Entity
@Table(name = "TVendedor")
public class Vendedor {

	@Id //define que essa eh a chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //facilitar a comunicacao entre as classes
	private String nome;
    private String cpf; // eh o identificador do vendedor
    private String email;
    //@Transient //ignora no momento
    @OneToMany //para registrar que esse eh o one  que vai estar associado a many
    @JoinColumn(name="idVendedor")
    private List<Produto> produtos; //precisa criar a relacao entre o produto e o vendedor
    // nesse mommento, o produto nao enxerga o vendedor, somente o vendedor enxerga o produto
    
    @Override
    public String toString() { // esse metodo determina oq ue vai ser impresso quando chamarmos o objeto puro
    	// TODO Auto-generated method stub
    	return String.format("%d - %s - %s - %s", id, nome, cpf, email);
    }

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
