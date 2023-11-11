package br.edu.infnet.appvenda.model.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;
//import javax.persistence.Transient;
import javax.validation.constraints.Size;

//import org.hibernate.validator.constraints.UniqueElements;

@Entity
//@Table(name = "TVendedor")
@Table(name = "TVendedor", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"cpf"}), 
		@UniqueConstraint(columnNames = {"email"})
		}
)


public class Vendedor {

	@Id //define que essa eh a chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //facilitar a comunicacao entre as classes
	@Size(min = 2, max = 50)
	private String nome;
	@Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
	@Column(unique = true)//para nao podr ter cpf repetido nos vendedores
    private String cpf; // eh o identificador do vendedor
    @Size(min = 2, max = 50)
    @Column(unique = true)
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
