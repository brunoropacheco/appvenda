package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TMecanico") //apesar de colocar essas anotacoes, ele vai criar somente a
							//tabela da mae e colocar todas as colunas e uma coluna type
//entretanto, nao queremos desse jeito, e vamos definir a heranca na classe mae para criar
// uma tabela pra cada tipo e as tabelas filhas trazerem os dados da tabela mae
public class Mecanico extends Produto {
	
	@Size(min = 2, max = 30, message = "O material deve ter entre {min} e {max} caracteres.")
    private String material;
    @NotNull
    private boolean maleavel;
    
    @Override
    public String toString() { // esse metodo determina oq ue vai ser impresso quando chamarmos o objeto puro
    	// TODO Auto-generated method stub
    	return String.format("%s - %s - %s", super.toString(), material, maleavel); //assim ele puxa o toString da classe mae
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isMaleavel() {
        return maleavel;
    }

    public void setMaleavel(boolean maleavel) {
        this.maleavel = maleavel;
    }
}