package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Column;

//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
//import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
//@Table(name = "TProduto")
@Table(name = "TProduto", uniqueConstraints = {@UniqueConstraint(columnNames = {"codigo"})})

@Inheritance(strategy = InheritanceType.JOINED)
public class Produto {
	
	@Id //define que essa eh a chave primaria que vai ser incrementado desde 1
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // so vai existir essa chave primaria na classe mae; nas classes filhas vai herdar
	@NotNull
	@Column(unique = true)
    private int codigo;
	private String descricao;
	@Positive
	private float preco;
	@NotNull
	@Column(columnDefinition = "boolean default false")
    private boolean estoque;
    @ManyToOne
    @JoinColumn(name="idVendedor")
    private Vendedor vendedor;

	@Override
    public String toString() { // esse metodo determina oq ue vai ser impresso quando chamarmos o objeto puro
    	// TODO Auto-generated method stub
    	//return String.format("%d - %s - %d - %.2f - %s - %s", id, descricao, codigo, preco, estoque, vendedor.getNome());
		return String.format("id (%d) - descricao (%s) - codigo (%d) - preco (%.2f) - estoque (%s) - vendedor [%s]", 
				id, descricao, codigo, preco, estoque, vendedor);
    }
    
	//Ctrl3 para ggas
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public boolean isEstoque() {
		return estoque;
	}
	public void setEstoque(boolean estoque) {
		this.estoque = estoque;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}
