package entities;

import java.util.Date;

public class HourContract {
	
	private Date data;
	private Double valorPorHora;
	private Integer horas;
	
	public HourContract () {
		
	}
	
	public HourContract (Date data, Double valorPorHora, Integer horas) {
		this.data = data;
		this.horas = horas;
		this.valorPorHora = valorPorHora;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(Double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
	public double totalValue () {
		return valorPorHora * horas;
	}
	
}
