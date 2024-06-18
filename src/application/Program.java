package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		System.out.print("Digite o nome do Departamento: ");
		String nomeDepartamento = sc.nextLine();
		
		System.out.println("Dados do Trabalhador: ");
		System.out.print("Nome: ");
		String nomeTrabalhador = sc.nextLine();
		System.out.print("Nivel: ");
		String nivelTrabalhador = sc.nextLine();
		System.out.print("Salario Base: ");
		double salarioTrabalhador = sc.nextDouble();
		
		Worker trabalhador = new Worker(nomeTrabalhador, WorkerLevel.valueOf(nivelTrabalhador), salarioTrabalhador, new Department(nomeDepartamento));
		
		System.out.print("Quantos contratos esse trabalho vai ter: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Contrato #" + i + ": ");
			System.out.print("Data Contrato (dd/MM/yyyy): ");
			Date contratoData = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Duração (Horas): ");
			int horas = sc.nextInt();
			
			HourContract contrato = new HourContract (contratoData, valorPorHora, horas);
			trabalhador.addContracts(contrato);
		}
		
		System.out.println();
		System.out.print("Digite o mes e ano para calcular o salario (MM/yyyy): ");
		String mesEAno = sc.next();
		int mes = Integer.parseInt(mesEAno.substring(0, 2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Renda de " + mesEAno + ": " + String.format("%.2f", trabalhador.income(ano, mes)));
		
		sc.close();

	}

}
