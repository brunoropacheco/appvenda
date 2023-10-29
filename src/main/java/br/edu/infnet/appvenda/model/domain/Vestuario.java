package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity //determina que eh uma classe entidade como o Integer, String, etc
@Table(name = "TVestuario")
public class Vestuario extends Produto {
    private String cor;
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