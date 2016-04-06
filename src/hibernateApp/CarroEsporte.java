package hibernateApp;

import javax.persistence.Entity;

@Entity
public class CarroEsporte extends Carro {
	private int velocidade;

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	
}
