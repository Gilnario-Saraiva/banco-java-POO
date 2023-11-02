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
			System.out.println(Banco.nome + " finalizado.");
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

		if(Banco.contas.size() > 0) {
			Banco.cabecalho();
			System.out.println("Lista de contas: ");
			
			for(Conta conta : Banco.contas) {
				System.out.println(conta);
				System.out.println();
				Utils.pausar(1);
			}
			
			System.out.println();
			
		}else {
			System.out.println("Ainda não há contas cadastradas");
		}
		
		Utils.pausar(3);
		Banco.menu();
	}

	private static void transferir() {

		Banco.cabecalho();
		System.out.println();
		System.out.println("Digite o número da sua conta: ");
		int numeroOrigem = Banco.teclado.nextInt();
		Conta contaOrigem = Banco.buscarContaPorNumero(numeroOrigem);
		
		if(contaOrigem != null) {
			
			System.out.println("Digite o número da conta favorecida: ");
			int numeroDestino = Banco.teclado.nextInt();
			Conta contaDestino = Banco.buscarContaPorNumero(numeroDestino);
			
			if(contaDestino != null) {
				System.out.println("Digite o valor a transferir: ");
				Double valor = Banco.teclado.nextDouble();
				
				contaOrigem.transferir(contaDestino, valor);
			}else {
				System.out.println("Conta número " + numeroDestino + " não foi encontrada.");
				Utils.pausar(3);
				Banco.menu();
			}
			
		}else {
			System.out.println("Conta número " + numeroOrigem + " não foi encontrada.");
		}
		Banco.teclado.nextLine();
		Utils.pausar(3);
		Banco.menu();
	}

	private static void depositar() {
		Banco.cabecalho();
		System.out.println();
		System.out.println("Digite o número da sua conta: ");
		int numero = Banco.teclado.nextInt();
		Conta conta = Banco.buscarContaPorNumero(numero);
		
		if(conta != null) {
			System.out.println("Digite o valor a depositar: ");
			Double valor = Banco.teclado.nextDouble();
			
			conta.depositar(valor);
		}else {
			System.out.println("Conta número " + numero + " não foi encontrada.");
		}
		Banco.teclado.nextLine();
		Utils.pausar(3);
		Banco.menu();
	}

	private static void sacar() {

		Banco.cabecalho();
		System.out.println();
		System.out.println("Digite o número da sua conta: ");
		int numero = Banco.teclado.nextInt();
		Conta conta = Banco.buscarContaPorNumero(numero);
		
		if(conta != null) {
			System.out.println("Digite o valor a sacar: ");
			Double valor = Banco.teclado.nextDouble();
			
			conta.sacar(valor);
		}else {
			System.out.println("Conta número " + numero + " não foi encontrada.");
		}
		Banco.teclado.nextLine();
		Utils.pausar(3);
		Banco.menu();
	}

	private static void criarConta() {
		
		Banco.cabecalho();
		System.out.println();
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
		Utils.pausar(3);
		Banco.menu();
	}
	
	private static Conta buscarContaPorNumero(int numero) {
		Conta c = null;
		if(Banco.contas.size() > 0) {
			for (Conta conta : Banco.contas) {
				if(conta.getNumero() == numero) {
					c = conta;
				}
			}
		}
		return c;
	}
	
	private static void cabecalho () {
		System.out.println("----------------------------------------");
		System.out.println("-------------------ATM------------------");
		System.out.println("------------"+ Banco.nome +"-----------");
		System.out.println("----------- GILNARIO B SARAIVA ---------");
		System.out.println("----------------------------------------");
	}
	

}
