package view;

import java.util.ArrayList;
import java.util.Scanner;

import helper.Utils;
import model.Cliente;
import model.Conta;

public class Banco {

	static String nome = "Digital Java Bank";
	static Scanner teclado = new Scanner(System.in);
	static ArrayList<Conta> contas;
	
	
	public static void main(String[] args) {
		
		Banco.contas = new ArrayList<Conta>();
		Banco.menu();
		
	}
	
	public static void menu() {
		
		int opcao = 0;
		Banco.cabecalho();
		System.out.println();
		System.out.println("Selecione uma opção no menu: ");
		System.out.println("1 - Criar conta");
		System.out.println("2 - Sacar");
		System.out.println("3 - Depositar");
		System.out.println("4 - Transferir");
		System.out.println("5 - Listar contas");
		System.out.println("6 - Sair do " + Banco.nome + "");
		
		try {
			opcao = Integer.parseInt(Banco.teclado.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Informe uma opção válida.");
			Utils.pausar(1);
			Banco.menu();
		}
		
		switch (opcao) {
		case 1: 
			Banco.criarConta();
			break;
		case 2: 
			Banco.sacar();
			break;
		case 3: 
			Banco.depositar();
			break;
		case 4: 
			Banco.transferir();
			break;
		case 5: 
			Banco.listarContas();
			break;
		case 6: 
			System.out.println(Banco.nome + "finalizado.");
			Utils.pausar(2);
			System.exit(0);
			break;
		default:
			System.out.println("Opção inválida.");
			Utils.pausar(2);
			Banco.menu();
			break;
		}
	}

	private static void listarContas() {
		// TODO Auto-generated method stub
		
	}

	private static void transferir() {
		// TODO Auto-generated method stub
		
	}

	private static void depositar() {
		// TODO Auto-generated method stub
		
	}

	private static void sacar() {
		// TODO Auto-generated method stub
		
	}

	private static void criarConta() {

		System.out.println("Informe os dados do cliente: ");
		
		System.out.println("Nome do cliente: ");
		String nome = Banco.teclado.nextLine();
		
		System.out.println("E-mail do cliente: ");
		String email = Banco.teclado.nextLine();
		
		System.out.println("CPF do cliente: ");
		String cpf = Banco.teclado.nextLine();
		
		System.out.println("Data de nascimento do cliente: ");
		String dataNascimento = Banco.teclado.nextLine();
		
		Cliente cliente = new Cliente(nome, email, cpf, Utils.stringParaData(dataNascimento));
		Conta conta = new Conta(cliente);
		
		Banco.contas.add(conta);
		
		System.out.println();
		System.out.println("Conta criada com sucesso.");
		System.out.println();
		System.out.println("Dados da conta criada: ");
		System.out.println();
		System.out.println(conta);
		System.out.println();
		Utils.pausar(2);
		Banco.menu();
	}
	
	private static void cabecalho () {
		System.out.println("----------------------------------------");
		System.out.println("-------------------ATM------------------");
		System.out.println("------------"+ Banco.nome +"-----------");
		System.out.println("----------------------------------------");
	}
	

}
