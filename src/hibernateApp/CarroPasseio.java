package hibernateApp;

import javax.persistence.Entity;

@Entity
public class CarroPasseio extends Carro {
	private int capacidade;

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
}
