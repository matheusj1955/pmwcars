package br.unitins.pmwcars.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Venda extends DefaultEntity<Venda>{
	
	private static final long serialVersionUID = -1408961887041249252L;

//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "Venda_Pagamento", joinColumns = @JoinColumn(name = "idvenda"),
//	inverseJoinColumns = @JoinColumn(name = "idpagamento"))
//	private List<Pagamento> listapagamento;
	
	private LocalDateTime data;
	
	private String numeroCartao;
	private String nomeCartao;
	private String validadeCartao;
	private Integer parcelas;
	private String codigoCartao;
	private Usuario usuario;
	
	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getNomeCartao() {
		return nomeCartao;
	}

	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}

	
	public String getValidadeCartao() {
		return validadeCartao;
	}

	public void setValidadeCartao(String validadeCartao) {
		this.validadeCartao = validadeCartao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	public String getCodigoCartao() {
		return codigoCartao;
	}

	public void setCodigoCartao(String codigoCartao) {
		this.codigoCartao = codigoCartao;
	}


	private Carro carro;

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public LocalDateTime getData() {
		return data;
	}


	public void setData(LocalDateTime data) {
		this.data = data;
	}


//	public List<Pagamento> getListapagamento() {
//		return listapagamento;
//	}
//
//
//	public void setListapagamento(List<Pagamento> listapagamento) {
//		this.listapagamento = listapagamento;
//	}


	
	
	

}
