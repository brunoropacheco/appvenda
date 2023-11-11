package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity //determina que eh uma classe entidade como o Integer, String, etc
@Table(name = "TVestuario")
public class Vestuario extends Produto {
	@Size(min = 2, max = 20, message = "A cor deve ter entre {min} e {max} caracteres.")
    private String cor;
	@NotNull
	//@Size(min = 1, max = 1, message = "O tamanho deve ter somente um caracter.")
	@Pattern(regexp = "^[A-Z]", message = "O tamanho deve ter somente um caracter maiusculo.")
    private String tamanho;
    
    @Override
    public String toString() { // esse metodo determina oq ue vai ser impresso quando chamarmos o objeto puro
    	// TODO Auto-generated method stub
    	return String.format("%s - %s - %s", super.toString(), cor, tamanho); //assim ele puxa o toString da classe mae
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
}