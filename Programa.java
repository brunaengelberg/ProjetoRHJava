package Programa;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Entidades.*;

public class Programa {

	public static void main(String[] args) {
		Empresa empresa;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Bem vindo ao sistema da sua empresa");
		System.out.print("Favor digitar o nome da empresa: ");

		String nomeEmpresa = scanner.nextLine();

		System.out.println("Sua empresa é: " + nomeEmpresa);

		System.out.print("Gostaria de inaugurar a empresa com funcionarios pré cadastrados? [s] ou [n]: ");

		char s_n = scanner.nextLine().charAt(0);

		while (true) {
			if (s_n == 's')
				break;
			else if (s_n == 'n')
				break;

			System.out.println("Opção inválida digite [s] ou [n]");
			System.out.print("Gostaria de inaugurar a empresa com funcionarios pré cadastrados?[s] ou [n]: ");
			s_n = scanner.nextLine().charAt(0);
		}

		if (s_n == 's') {
			System.out.println("Beleza, vamos inciar com funcionarios");

			ArrayList<Funcionario> fun = new ArrayList<Funcionario>();
			fun.add(new Funcionario("Joao", "TI", 2000, 2));
			fun.add(new Funcionario("Pedro", "RH", 3000, 4));
			fun.add(new Funcionario("Maria", "Diretoria", 20000, 8));
			fun.add(new Funcionario("Rute", "Administrativo", 2000, 1));

			empresa = new Empresa(nomeEmpresa, fun);
		} else {
			System.out.println("Ok, vamos inciar sem funcionarios então");

			ArrayList<Funcionario> fun = new ArrayList<Funcionario>();

			empresa = new Empresa(nomeEmpresa, fun);

		}

		boolean executando = true;

		while (executando) {
			System.out.println("\nSistema de RH da Empresa");
			System.out.println("1. Cadastrar funcionário");
			System.out.println("2. Demitir funcionário");
			System.out.println("3. Reajustar salário de todos os funcionários");
			System.out.println("4. Reajustar salário de um setor");
			System.out.println("5. Imprimir lista de funcionários acima da média salarial");
			System.out.println("6. Imprimir lista de funcionários por setor");
			System.out.println("7. Imprimir lista de funcionários por anos na empresa");
			System.out.println("8. Sair");
			System.out.print("Escolha uma opção: ");
			int opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				scanner.nextLine();
				System.out.print("Nome do funcionário: ");
				String nome = scanner.nextLine();
				System.out.print("Setor do funcionário: ");
				String setor = scanner.nextLine();
				System.out.print("Salário do funcionário: ");
				double salario = scanner.nextDouble();
				System.out.print("Anos na empresa do funcionário: ");
				int anosNaEmpresa = scanner.nextInt();

				Funcionario novoFuncionario = new Funcionario(nome, setor, salario, anosNaEmpresa);
				empresa.adicionarFuncionario(novoFuncionario);
				System.out.println("Funcionário cadastrado com sucesso!");
				break;

			case 2:
				scanner.nextLine(); 
				System.out.print("Nome do funcionário a ser demitido: ");
				String nomeFuncionarioDemitido = scanner.nextLine();
				Funcionario funcionarioDemitido = null;

				for (Funcionario funcionario : empresa.getFuncionarios()) {
					if (funcionario.getNome().equalsIgnoreCase(nomeFuncionarioDemitido)) {
						funcionarioDemitido = funcionario;
						break;
					}
				}

				if (funcionarioDemitido != null) {
					empresa.removerFuncionario(funcionarioDemitido);
					System.out.println("Funcionário demitido com sucesso!");
				} else {
					System.out.println("Funcionário não encontrado!");
				}
				break;

			case 3:
				System.out.print("Percentual de aumento para todos os funcionários: ");
				double percentualAumentoTodos = scanner.nextDouble();
				empresa.reajustarSalario(percentualAumentoTodos);
				System.out.println("Salário de todos os funcionários reajustado com sucesso!");
				break;

			case 4:
				scanner.nextLine(); 
				System.out.print("Setor dos funcionários a terem o salário reajustado: ");
				String setorReajuste = scanner.nextLine();
				System.out.print("Percentual de aumento para os funcionários do setor " + setorReajuste + ": ");
				double percentualAumentoSetor = scanner.nextDouble();
				empresa.reajustarSalario(setorReajuste, percentualAumentoSetor);
				System.out.println("Salário dos funcionários do setor " + setorReajuste + " reajustado com sucesso!");
				break;

			case 5:
				empresa.imprimirFuncionariosAcimaMedia();
				break;

			case 6:
				scanner.nextLine(); 
				System.out.print("Setor dos funcionários a serem listados: ");
				String setorLista = scanner.nextLine();
				empresa.imprimirFuncionariosPorSetor(setorLista);
				break;

			case 7:
				scanner.nextLine(); 
				System.out.print("Número de anos na empresa dos funcionários a serem listados: ");
				int anosLista = scanner.nextInt();
				empresa.imprimirFuncionariosPorAnosNaEmpresa(anosLista);
				break;

			case 8:
				executando = false;
				break;

			default:
				System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
			}
		}

		System.out.println("Encerrando o Sistema de RH da Empresa "+ nomeEmpresa +". Obrigado!");
	}

}
