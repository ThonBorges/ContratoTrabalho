package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String nome;
	private WorkerLevel nivel;
	private Double salarioBase;
	
	private Department departamento;
	private List<HourContract> contratos = new ArrayList<>();
	
	public Worker () {
		
	}

	public Worker(String nome, WorkerLevel nivel, Double salarioBase, Department departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public WorkerLevel getNivel() {
		return nivel;
	}

	public void setNivel(WorkerLevel nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Department getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Department departamento) {
		this.departamento = departamento;
	}

	public List<HourContract> getContratos() {
		return contratos;
	}
	
	public void addContracts (HourContract contrato) {
		contratos.add(contrato);
	}
	
	public void removeContracts (HourContract contrato) {
		contratos.remove(contrato);
	}
	
	public double income(int ano, int mes) {
		double sum = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : contratos) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			if (ano == c_ano && mes == c_mes) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
}
