package hibernateApp;

import java.io.Serializable;

public class EmpregoId implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6163525290956723986L;
		
	private Long empregado;
	private Long empresa;
	
	public Long getEmpregado() {
		return empregado;
	}
	
	public void setEmpregado(Long empregado) {
		this.empregado = empregado;
	}
	
	public Long getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Long empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((empregado == null) ? 0 : empregado.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		EmpregoId other = (EmpregoId) obj;
		if (empregado == null) {
			if (other.empregado != null) {
				return false;
			}
		} else if (!empregado.equals(other.empregado)) {
			return false;
		}
		if (empresa == null) {
			if (other.empresa != null) {
				return false;
			}
		} else if (!empresa.equals(other.empresa)) {
			return false;
		}
		return true;
	}
	
}
