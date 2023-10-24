package br.edu.infnet.appvenda.model.domain;

public class Mecanico extends Produto {
	
    private String material;
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