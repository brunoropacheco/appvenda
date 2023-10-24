package br.edu.infnet.appvenda.model.domain;

import java.util.List;

public class Vendedor {
	
	private String nome;
    private String cpf; // eh o identificador do vendedor
    private String email;
    private List<Produto> produto; //precisa criar a relacao entre o produto e o vendedor
    // nesse mommento, o produto nao enxerga o vendedor, somente o vendedor enxerga o produto
    
    @Override
    public String toString() { // esse metodo determina oq ue vai ser impresso quando chamarmos o objeto puro
    	// TODO Auto-generated method stub
    	return String.format("%s - %s - %s", nome, cpf, email);
    }

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
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

}
