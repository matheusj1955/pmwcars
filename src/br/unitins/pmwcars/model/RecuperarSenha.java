package br.unitins.pmwcars.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RecuperarSenha extends DefaultEntity<RecuperarSenha>{

	private static final long serialVersionUID = -389537380117963235L;
	
	private String codigo;
	private LocalDateTime dataLimite;
	private boolean utilizado;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDateTime getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(LocalDateTime dataLimite) {
		this.dataLimite = dataLimite;
	}

	public boolean isUtilizado() {
		return utilizado;
	}

	public void setUtilizado(boolean utilizado) {
		this.utilizado = utilizado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}