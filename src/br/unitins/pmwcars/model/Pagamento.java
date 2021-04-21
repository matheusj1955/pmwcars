package br.unitins.pmwcars.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pagamento extends DefaultEntity<Pagamento>{
	
	private static final long serialVersionUID = 656842782852629889L;
	
//	@ManyToOne
//	@JoinColumn(name="idforma", nullable = false)
//	private FormaPagamento forma;
	
	private double valor;
	private Date dataPagamento;
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
}
