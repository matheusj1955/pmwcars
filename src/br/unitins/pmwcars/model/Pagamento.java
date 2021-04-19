package br.unitins.pmwcars.model;

import java.util.Date;

public class Pagamento extends DefaultEntity<Pagamento>{
	
	private static final long serialVersionUID = 656842782852629889L;
	
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
