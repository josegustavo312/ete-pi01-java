package ProjetoIntegradorI;

import java.util.Scanner;

public class SOFT_F5_PI {

	// Arrays #######################################################

	static int[] id = new int[100];
	static String[] marca = new String[100];
	static String[] processador = new String[100];
	static int[] memoria = new int[100];
	static int[] hd = new int[100];
	static double[] preco = new double[100];
	static int[] idCliente = new int[100];
	static String[] cpf = new String[100];
	static String[] nome = new String[100];
	static String[] sobrenome = new String[100];
	static String[] cidade = new String[100];
	static String[] bairro = new String[100];
	static String[] logradouro = new String[100];
	static int[] numero = new int[100];

	// Metodo para mostrar o Logotipo
	// #######################################################

	public static void logo() {
		
		System.out.println("\t #####################################################");
		System.out.println("\t #######               ######               ##########");
		System.out.println("\t #######   ##################   ######################");
		System.out.println("\t #######   ##################   ######################");
		System.out.println("\t #######       ##############               ##########");
		System.out.println("\t #######   ##############################   ##########");
		System.out.println("\t #######   ##############################   ##########");
		System.out.println("\t #######   #################                ##########");
		System.out.println("\t #####################################################");

	}

	// Fim do Método para mostrar o Logotipo
	// #######################################################

	// Metodo para mostrar o Menu Principal
	// #######################################################

	static int mostrarMenu() {

		int saida, opcao;

		Scanner entrada = new Scanner(System.in);

		do {
			System.out.println("\n\t ###   SOFT F5 - ATUALIZANDO A SUA EMPRESA   ###\n");
			System.out.println("\t\t ###   MENU PRINCIPAL   ###\n");
			System.out.print(
					"\t 1 - VENDAS							#####################################################\n");
			System.out
					.print("\t								#######               ######               ##########\n");
			System.out.print(
					"\t 2 - LISTA DOS COMPUTADORES					#######               ######               ##########\n");
			System.out
					.print("\t 								#######      ###############      ###################\n");
			System.out.print(
					"\t 3 - CADASTRAR COMPUTADORES					#######      ###############      ###################\n");
			System.out
					.print("\t								#######      ###############      ###################\n");
			System.out.print(
					"\t 4 - ATUALIZAR O PREÇO DOS COMPUTADORES				#######      ###############      ###################\n");
			System.out
					.print("\t								#######            #########               ##########\n");
			System.out.print(
					"\t 5 - CONSULTAR COMPUTADOR					#######            #########               ##########\n");
			System.out
					.print("\t 								#######      ########################      ##########\n");
			System.out.print(
					"\t 6 - EXCLUIR COMPUTADOR						#######      ########################      ##########\n");
			System.out
					.print("\t 								#######      ########################      ##########\n");
			System.out.print(
					"\t 7 - LISTAR CLIENTE						#######      ########################      ##########\n");
			System.out
					.print("\t 								#######      ##############                ##########\n");
			System.out.print(
					"\t 8 - CONSULTAR CLIENTE						#######      ##############                ##########\n");
			System.out
					.print("\t 								#######      ##############                ##########\n");
			System.out.println(
					"\t 9 - CADASTRAR CLIENTE						#####################################################\n");
			System.out.println(
					"\t 10 - ATUALIZAR O ENDEREÇO					 	 SOFT F5 - ATUALIZANDO A SUA EMPRESA\n");
			System.out.println("\t 11 - EXCLUIR CLIENTE\n");
			System.out.println("\t 12 - SAIR DO PROGRAMA\n");
			System.out.print("\t ESCOLHA A OPÇÃO: ");
			opcao = entrada.nextInt();

			saida = 1;

			if (opcao < 1) {
				System.out.println("\n\t XXX  OPÇAO INVÁLIDA!  XXX\n");
				saida = 0;
			}
			if (opcao > 12) {
				System.out.println("\n\t XXX  OPÇAO INVÁLIDA!  XXX\n");
				saida = 0;
			}
		} while (saida == 0);

		return opcao;

	}

	// fim do metodo Menu Principal
	// ################################################################

	// Metodo Listar todos os Computadores
	// #################################################

	static void listar(int indice) {
		int i = 0;

		System.out.print("\n\t\t\t #####   LISTA DOS COMPUTADORES   #####");

		System.out.println("\n\n\tID -  MARCA    -    PROCESSADOR    -    MEMÓRIA    -     HD       -       PREÇO  ");

		while (i < indice) {

			if (id[i] >= 0)
				System.out.printf(
						"\n\t" + id[i] + "  -   " + marca[i] + "     -       " + processador[i] + "      -       "
								+ memoria[i] + " Gb" + "     -     " + hd[i] + " Gb" + "     -     " + "R$ %.2f\n",
						preco[i]);
			i++;
		}

	}

	// Fim do método Listar Computador
	// #################################################

	// Metodo Listar todos os Clientes
	// #################################################

	static void listarCliente(int indiceCliente) {
		int ic = 0;

		System.out.print("\n\t\t #####   LISTA DOS CLIENTES   ##### \n");

		while (ic < indiceCliente) {

			if (idCliente[ic] >= 0)
				System.out.println("\n\tID: " + idCliente[ic] + " - NOME: " + nome[ic] + " " + sobrenome[ic]
						+ " - CPF: " + cpf[ic] + " - CIDADE: " + cidade[ic] + " - BAIRRO: " + bairro[ic]
						+ " - LOGRAUDORO: " + logradouro[ic] + "  -  Nº: " + numero[ic]);
			ic++;
		}

	}

	// Fim Listar Cliente

	// Método Vendas

	static void vendas(int indice, int indiceCliente) {

		String continuar;
		int id_produto, id_Cliente, sinalizador = 0;
		double quantidade, subtotal, total = 0;
		Scanner entrada = new Scanner(System.in);
		System.out.println("\n\n\t ###  CAIXA - F5 ATUALIZANDO A SUA EMPRESA  ###");

		do {

			System.out.print("\n\t DIGITE O ID DO CLIENTE: ");
			id_Cliente = entrada.nextInt();
			sinalizador = procuraIndiceIDCliente(indiceCliente, id_Cliente);

			for (int ic = 0; ic < indiceCliente; ic++) {
				if (id_Cliente == idCliente[ic]) {
					System.out.println("\n\tID: " + idCliente[ic] + " - NOME: " + nome[ic] + " " + sobrenome[ic]
							+ " - CPF: " + cpf[ic] + " - CIDADE: " + cidade[ic] + " - BAIRRO: " + bairro[ic]
							+ " - LOGRAUDORO: " + logradouro[ic] + "  -  Nº: " + numero[ic]);

				}
			}

			System.out.print("\n\t DIGITE O ID DO COMPUTADOR: ");
			id_produto = entrada.nextInt();
			sinalizador = procuraIndiceID(indice, id_produto);

			for (int i = 0; i < indice; i++) {
				if (id_produto == id[i]) {
					System.out.printf("\n\tID: " + id[i] + " - MARCA: " + marca[i] + " - PROCESSADOR: " + processador[i]
							+ " - MEMÓRIA: " + memoria[i] + " Gb" + " - HD: " + hd[i] + " Gb" + "  -  PREÇO: R$ "
							+ "%.2f\n", preco[i]);
				}
			}

			if (sinalizador == -1) {
				System.out.println("\n\n\t COMPUTADOR NÃO CADASTRADO!!!\n\n");

			} else {
				System.out.print("\n\t DIGITE A QUANTIDADE: ");
				quantidade = entrada.nextDouble();
				subtotal = quantidade * preco[sinalizador];
				total = total + subtotal;

			}

			System.out.print("\n\t DESEJA REALIZAR OUTRA COMPRA? (S/N): ");
			continuar = entrada.next();
		} while (continuar.equals("S"));

		System.out.printf("\n\t\t ### O TOTAL FOI: R$ %.2f ###\n\n", total);

	}

	// Fim Metodo Vendas
	// #############################################################################

	// Método Cadastrar Produtos
	// ###########################################################

	static void cadastrarProdutos(int indice, String produto, String cpu, int memoria_ram, int disco,
			double preco_produto) {

		id[indice] = indice;
		marca[indice] = produto;
		processador[indice] = cpu;
		memoria[indice] = memoria_ram;
		hd[indice] = disco;
		preco[indice] = preco_produto;

	}

	// Fim do Método Cadastro de Computador
	// #################################################

	// Método Cadastrar Clietne
	// ###########################################################

	static void cadastrarCliente(int indiceCliente, String nomeCliente, String cpfCliente, String sobrenomeCliente,
			String cidadeCliente, String bairroCliente, String logradouroCliente, int numeroCliente) {

		idCliente[indiceCliente] = indiceCliente;
		cpf[indiceCliente] = cpfCliente;
		nome[indiceCliente] = nomeCliente;
		sobrenome[indiceCliente] = sobrenomeCliente;
		cidade[indiceCliente] = cidadeCliente;
		bairro[indiceCliente] = bairroCliente;
		logradouro[indiceCliente] = logradouroCliente;
		numero[indiceCliente] = numeroCliente;

	}

	// Fim do Método Cadastro de Cliente
	// #################################################

	// Método Consultar Computador
	// ###########################################################

	static void consultarCodigo(int indice) {

		Scanner entrada = new Scanner(System.in);
		int codigo;

		System.out.print("\n\t DIGITE O CÓDIGO DO COMPUTADOR: ");
		codigo = entrada.nextInt();
		int ind = -1;

		for (int i = 0; i < indice; i++) {
			if (codigo == id[i]) {
				System.out.printf("\n\tID: " + id[i] + " - MARCA: " + marca[i] + " - PROCESSADOR: " + processador[i]
						+ " - MEMÓRIA: " + memoria[i] + " Gb" + " - HD: " + hd[i] + " Gb" + "  -  PREÇO: R$ "
						+ "%.2f\n\n", preco[i]);
				ind = 1;

			}

		}
		if (ind == -1) {
			System.out.println("\n\n\t CÓDIGO NÃO CADASTRADO!!! \n\n");

		}
	}

	// Fim do Método Consultar de PC
	// #################################################

	// Método Consultar Marca
	// ###########################################################

	static void consultarMarca(int indice) {

		Scanner entrada = new Scanner(System.in);
		String nome_produto;

		System.out.print("\n\t DIGITE A MARCA DO COMPUTADOR: ");
		nome_produto = entrada.next();
		int ind = -1;

		for (int i = 0; i < indice; i++) {
			if (nome_produto.equals(marca[i])) {
				System.out.printf("\n\tID: " + id[i] + " - MARCA: " + marca[i] + " - PROCESSADOR: " + processador[i]
						+ " - MEMÓRIA: " + memoria[i] + " Gb" + " - HD: " + hd[i] + " Gb" + "  -  PREÇO: R$ "
						+ "%.2f\n\n", preco[i]);
				ind = 1;

			}

		}
		if (ind == -1) {
			System.out.println("\n\n\tMARCA NÃO CADASTRADA!!!\n\n");

		}
	}

	// Fim do Método Consultar Marca
	// #################################################

	// Método Consultar Processador
	// ###########################################################

	static void consultarProcessador(int indice) {

		Scanner entrada = new Scanner(System.in);
		String empresa;

		System.out.print("\n\t DIGITE A MARCA DO PROCESSADOR: ");
		empresa = entrada.next();
		int ind = -1;

		for (int i = 0; i < indice; i++) {
			if (empresa.equals(processador[i])) {
				System.out.printf("\n\tID: " + id[i] + " - MARCA: " + marca[i] + " - PROCESSADOR: " + processador[i]
						+ " - MEMÓRIA: " + memoria[i] + " Gb" + " - HD: " + hd[i] + " Gb" + "  -  PREÇO: R$ "
						+ "%.2f\n\n", preco[i]);
				ind = 1;

			}

		}
		if (ind == -1) {
			System.out.println("\n\n\tPROCESSADOR NÃO CADASTRADO!!!\n\n");

		}
	}

	// Fim do Método Consultar Marca
	// #################################################

	// Método Consultar Memória
	// ###########################################################

	static void consultarMemoria(int indice) {

		Scanner entrada = new Scanner(System.in);
		int ram;

		System.out.print("\n\t DIGITE O TAMANHO DA MEMÓRIA RAM: ");
		ram = entrada.nextInt();
		int ind = -1;

		for (int i = 0; i < indice; i++) {
			if (ram == memoria[i]) {
				System.out.printf("\n\tID: " + id[i] + " - MARCA: " + marca[i] + " - PROCESSADOR: " + processador[i]
						+ " - MEMÓRIA: " + memoria[i] + " Gb" + " - HD: " + hd[i] + " Gb" + "  -  PREÇO: R$ "
						+ "%.2f\n\n", preco[i]);
				ind = 1;

			}

		}
		if (ind == -1) {
			System.out.println("\n\n\tMEMÓRIA NÃO CADASTRADA!!!\n\n");

		}
	}

	// Fim do Método consultar Memória
	// #################################################

	// Método Consultar HD
	// ###########################################################

	static void consultarHD(int indice) {

		Scanner entrada = new Scanner(System.in);
		int disco;

		System.out.print("\n\t DIGITE O TAMANHO DO HD: ");
		disco = entrada.nextInt();
		int ind = -1;

		for (int i = 0; i < indice; i++) {
			if (disco == hd[i]) {
				System.out.printf("\n\tID: " + id[i] + " - MARCA: " + marca[i] + " - PROCESSADOR: " + processador[i]
						+ " - MEMÓRIA: " + memoria[i] + " Gb" + " - HD: " + hd[i] + " Gb" + "  -  PREÇO: R$ "
						+ "%.2f\n\n", preco[i]);
				ind = 1;

			}

		}
		if (ind == -1) {
			System.out.println("\n\n\t HD NÃO CADASTRADO!!!\n\n");

		}
	}

	// Fim do Método Consultar HD #################################################

	// Método Consultar Preço
	// ###########################################################

	static void consultarPreco(int indice) {

		Scanner entrada = new Scanner(System.in);
		int valor;

		System.out.print("\n\t DIGITE O PREÇO: R$ ");
		valor = entrada.nextInt();
		int ind = -1;

		for (int i = 0; i < indice; i++) {
			if (valor == preco[i]) {
				System.out.printf("\n\tID: " + id[i] + " - MARCA: " + marca[i] + " - PROCESSADOR: " + processador[i]
						+ " - MEMÓRIA: " + memoria[i] + " Gb" + " - HD: " + hd[i] + " Gb" + "  -  PREÇO: R$ "
						+ "%.2f\n\n", preco[i]);
				ind = 1;

			}

		}
		if (ind == -1) {
			System.out.println("\n\n\tPREÇO NÃO CADASTRADO!!!\n");

		}
	}

	// Fim do Método Consultar Preço
	// #####################################################

	// Método Consultar ID Cliente
	// ###########################################################

	static void consultarIDCliente(int indiceCliente) {

		Scanner entrada = new Scanner(System.in);
		int codigo;

		System.out.print("\n\t DIGITE O CÓDIGO DO CLIENTE: ");
		codigo = entrada.nextInt();
		int ind = -1;

		for (int ic = 0; ic < indiceCliente; ic++) {
			if (codigo == idCliente[ic]) {
				System.out.println("\n\tID: " + idCliente[ic] + " - CPF: " + cpf[ic] + " - NOME: " + nome[ic] + " "
						+ sobrenome[ic] + " - CIDADE: " + cidade[ic] + " - BAIRRO: " + bairro[ic] + " - LOGRAUDORO: "
						+ logradouro[ic] + "  -  Nº: " + numero[ic]);
				ind = 1;

			}

		}
		if (ind == -1) {
			System.out.println("\n\n\t CLIENTE NÃO CADASTRADO!!! \n");

		}
	}
	// Fim do Método Consultar ID Cliente
	// #################################################

	// Método Consultar Nome #################################################

	static void consultarNome(int indiceCliente) {

		Scanner entrada = new Scanner(System.in);
		String nome_cliente;

		System.out.print("\n\t DIGITE O NOME DO CLIENTE: ");
		nome_cliente = entrada.next();
		int ind = -1;

		for (int ic = 0; ic < indiceCliente; ic++) {
			if (nome_cliente.equals(nome[ic])) {
				System.out.println("\n\tID: " + idCliente[ic] + " - CPF: " + cpf[ic] + " - NOME: " + nome[ic] + " "
						+ sobrenome[ic] + " - CIDADE: " + cidade[ic] + " - BAIRRO: " + bairro[ic] + " - LOGRAUDORO: "
						+ logradouro[ic] + "  -  Nº: " + numero[ic]);
				ind = 1;

			}

		}
		if (ind == -1) {
			System.out.println("\n\t CLIENTE NÃO CADASTRADO!!!\n");

		}
	}

	// Fim do Método Consultar Nome
	// #################################################

	// Método Consultar Sobrenome #################################################

	static void consultarSobrenome(int indiceCliente) {

		Scanner entrada = new Scanner(System.in);
		String sobrenome_cliente;

		System.out.print("\n\t DIGITE O SOBRENOME DO CLIENTE: ");
		sobrenome_cliente = entrada.next();
		int ind = -1;

		for (int ic = 0; ic < indiceCliente; ic++) {
			if (sobrenome_cliente.equals(sobrenome[ic])) {
				System.out.println("\n\tID: " + idCliente[ic] + " - CPF: " + cpf[ic] + " - NOME: " + nome[ic] + " "
						+ sobrenome[ic] + " - CIDADE: " + cidade[ic] + " - BAIRRO: " + bairro[ic] + " - LOGRAUDORO: "
						+ logradouro[ic] + "  -  Nº: " + numero[ic]);
				ind = 1;

			}

		}
		if (ind == -1) {
			System.out.println("\n\t CLIENTE NÃO CADASTRADO!!!\n");

		}
	}

	// Fim do Método Consultar Sobrenome
	// #################################################

	// Método Consultar Cidade #################################################

	static void consultarCidade(int indiceCliente) {

		Scanner entrada = new Scanner(System.in);
		String lugar;

		System.out.print("\n\t DIGITE A CIDADE DO CLIENTE: ");
		lugar = entrada.next();
		int ind = -1;

		for (int ic = 0; ic < indiceCliente; ic++) {
			if (lugar.equals(cidade[ic])) {
				System.out.println("\n\tID: " + idCliente[ic] + " - CPF: " + cpf[ic] + " - NOME: " + nome[ic] + " "
						+ sobrenome[ic] + " - CIDADE: " + cidade[ic] + " - BAIRRO: " + bairro[ic] + " - LOGRAUDORO: "
						+ logradouro[ic] + "  -  Nº: " + numero[ic]);
				ind = 1;

			}

		}
		if (ind == -1) {
			System.out.println("\n\t CIDADE NÃO CADASTRADA!!!\n");

		}
	}

	// Fim do Método Consultar Cidade
	// #################################################

	// Método Atualizar Preço
	// ################################################################

	static void atualizarPreco(int indice) {
		int id_pc;
		double preco_produto;
		int ind = -1, ic = 0;
		Scanner entrada = new Scanner(System.in);
		System.out.println("\n\t ###  ATUALIZAR O PREÇO DOS COMPUTADORES  ###\n");
		System.out.print("\t DIGITE O ID DO COMPUTADOR:");
		id_pc = entrada.nextInt();

		while (ic < indice) {
			if (id_pc == id[ic]) {
				System.out.printf("\n\tID: " + id[ic] + " - MARCA: " + marca[ic] + " - PROCESSADOR: " + processador[ic]
						+ " - MEMÓRIA: " + memoria[ic] + " Gb" + " - HD: " + hd[ic] + " Gb" + "  -  PREÇO: R$ "
						+ "%.2f\n\n", preco[ic]);
				System.out.print("\n\t DIGITE O NOVO PREÇO: R$ ");
				preco_produto = entrada.nextDouble();
				preco[ic] = preco_produto;
				System.out.println("\n\t### PREÇO ALTERADO COM SUCESSO!!! ###");
				ind = 1;
				break;
			}
			ic++;
		}
		if (ind == -1) {
			System.out.println("\n\n\tCOMPUTADOR NÃO CADASTRADO!!!\n\n");
		}
	}

	// Fim do Método Atualizar Preço
	// #################################################

	// Método Atualizar Cliente
	// ###########################################################

	static void atualizarCliente(int indiceCliente) {
		int id_cliente;
		String cidadeAtualizar, bairroAtualizar, logradouroAtualizar;
		int numeroAtualizar;
		int ind = -1, ic = 0;
		Scanner entrada = new Scanner(System.in);
		System.out.println("\n\t ###  ATUALIZAR O ENDEREÇO DO CLIENTE  ###\n");
		System.out.print("\t DIGITE O ID DO CLIENTE: ");
		id_cliente = entrada.nextInt();

		while (ic < indiceCliente) {
			if (id_cliente == idCliente[ic]) {
				System.out.println("\n\tID: " + idCliente[ic] + " - NOME: " + nome[ic] + " " + sobrenome[ic]
						+ " - CPF: " + cpf[ic] + " - CIDADE: " + cidade[ic] + " - BAIRRO: " + bairro[ic]
						+ " - LOGRAUDORO: " + logradouro[ic] + "  -  Nº: " + numero[ic]);

				System.out.print("\n\t DIGITE A NOVA CIDADE: ");
				cidadeAtualizar = entrada.next();
				cidade[ic] = cidadeAtualizar;

				System.out.print("\n\t DIGITE O NOVO BAIRRO: ");
				bairroAtualizar = entrada.next();
				bairro[ic] = bairroAtualizar;

				System.out.print("\n\t DIGITE O NOVO LOGRADOURO: ");
				logradouroAtualizar = entrada.next();
				logradouro[ic] = logradouroAtualizar;

				System.out.print("\n\t DIGITE O NOVO Nº DA CASA: ");
				numeroAtualizar = entrada.nextInt();
				numero[ic] = numeroAtualizar;

				System.out.println("\n\t### ENDEREÇO ALTERADO COM SUCESSO!!! ###");
				ind = 1;
				break;
			}
			ic++;
		}
		if (ind == -1) {
			System.out.println("\n\t### CLIENTE NÃO CADASTRADO!!! ###\n");
		}
	}

	// Fim Métdo Atualizar Preço
	// #############################################################

	// Método Excluir Produto
	// ###############################################################

	static int excluirProduto(int indice) {

		Scanner entrada = new Scanner(System.in);
		int sinalizador = -1;
		int retorno = indice, cod, id_produto;
		String op;

		System.out.println("\n\t ###   EXCLUIR O COMPUTADOR   ###");
		System.out.print("\n\tDIGITE O ID DO COMPUTADOR: ");
		id_produto = entrada.nextInt();
		sinalizador = procuraIndiceID(indice, id_produto);

		for (int i = 0; i < indice; i++) {
			if (id_produto == id[i]) {
				System.out.printf("\n\tID: " + id[i] + " - MARCA: " + marca[i] + " - PROCESSADOR: " + processador[i]
						+ " - MEMÓRIA: " + memoria[i] + " Gb" + " - HD: " + hd[i] + " Gb" + "  -  PREÇO: R$ "
						+ "%.2f\n\n", preco[i]);
			}
		}

		if (sinalizador == -1) {
			System.out.println("\n\t### ID NÃO CADASTRADO!!! ###\n");
			retorno = indice;
			return retorno;

		}

		System.out.print("\n\t TEM CERTEZA QUE DESEJA EXCLUIR ESSE COMPUTADOR? (S/N): ");
		op = entrada.next();

		if (op.equals("S")) {

			int i = id_produto;

			for (cod = 0; cod < indice; cod++) {
				if (cod == id[i]) {
					id[i] = id[i] - 100;
					marca[i] = "NULL";
					processador[i] = "NULL";
					memoria[i] = 00;
					hd[i] = 00;
					preco[i] = 00;
					retorno = indice - 0;
					sinalizador = 1;

					System.out.println("\n\t### OPERAÇÃO REALIZADA COM SUCESSO! ###");

				}

			}
		}
		return retorno;
	}

	// Fim Metodo Excluir Produto
	// ##########################################################

	// Começo do Metodo Excluir Cliente
	// ##########################################################

	static int excluirCliente(int indiceCliente) {

		Scanner entrada = new Scanner(System.in);
		int sinalizador = 100;
		int retorno = indiceCliente, cod, id_cliente;
		String op;

		System.out.println("\n\t ###   EXCLUIR CLIENTE   ###");
		System.out.print("\n\tDIGITE O ID DO CLIENTE: ");
		id_cliente = entrada.nextInt();
		sinalizador = procuraIndiceID(indiceCliente, id_cliente);

		for (int ic = 0; ic < indiceCliente; ic++) {
			if (id_cliente == idCliente[ic]) {
				System.out.println("\n\tID: " + idCliente[ic] + " - NOME: " + nome[ic] + " " + sobrenome[ic]
						+ " - CPF: " + cpf[ic] + " - CIDADE: " + cidade[ic] + " - BAIRRO: " + bairro[ic]
						+ " - LOGRAUDORO: " + logradouro[ic] + "  -  Nº: " + numero[ic]);
			}
		}

		if (sinalizador == 100) {
			System.out.println("\n\t### ID NÃO CADASTRADO!!! ###\n");
			retorno = indiceCliente;
			return retorno;

		}

		System.out.print("\n\t TEM CERTEZA QUE DESEJA EXCLUIR ESSE CLIENTE? (S/N): ");
		op = entrada.next();

		if (op.equals("S")) {

			int ic = id_cliente;

			for (cod = 0; cod < indiceCliente; cod++) {
				if (cod == idCliente[ic]) {

					idCliente[ic] = idCliente[ic] - 100;
					cpf[ic] = "NULL";
					nome[ic] = "NULL";
					sobrenome[ic] = "NULL";
					cidade[ic] = "NULL";
					bairro[ic] = "NULL";
					logradouro[ic] = "NULL";
					numero[ic] = 00;

					retorno = indiceCliente - 0;
					sinalizador = 2;

					System.out.println("\n\t### OPERAÇÃO REALIZADA COM SUCESSO! ###");

				}

			}
		}
		return retorno;
	}

	// Fim do Método Excluir Cliente
	// #################################################

	// Metodo Consultar ID
	// ###############################################################

	static int procuraIndiceID(int indice, int id_produto) {

		int ic, retorno = -1;

		for (ic = 0; ic < indice; ic++) {

			if (id_produto == id[ic])
				retorno = ic;
		}

		return retorno;
	}

	// Fim do método procurar id
	// ###############################################################

	// Metodo Consultar ID
	// ###############################################################

	static int procuraIndiceIDCliente(int indiceCliente, int id_cliente) {

		int ic, retorno = -1;

		for (ic = 0; ic < indiceCliente; ic++) {

			if (id_cliente == idCliente[ic])
				retorno = ic;
		}

		return retorno;
	}

	// Fim Método Procurar id do cliente
	// ###########################################################

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Criação das variáveis no MAIN

		Scanner entrada = new Scanner(System.in);
		int indice = 10, menuCadastro = 0;
		int indiceCliente = 10, menuCadastroCliente;
		int opcao;
		String menuPrincipal;
		int op = 0;

		/*
		 * Populando os Arrays
		 * 
		 * Populando os id
		 */

		for (int ic = 0; ic < 10; ic++) {
			idCliente[ic] = ic;
		}
		// CPF dos Clientes

		cpf[0] = "088.232.123-23";
		cpf[1] = "078.214.550-30";
		cpf[2] = "079.345.459-15";
		cpf[3] = "081.342.789-43";
		cpf[4] = "079.878.689-48";
		cpf[5] = "078.566.323-98";
		cpf[6] = "074.324.187-98";
		cpf[7] = "089.456.432-21";
		cpf[8] = "084.897.567-89";
		cpf[9] = "085.675.459-06";

		// Nome

		nome[0] = "JOSE";
		nome[1] = "MARIA";
		nome[2] = "ANTONIO";
		nome[3] = "FERNANDO";
		nome[4] = "ANA";
		nome[5] = "PAULO";
		nome[6] = "SANDRA";
		nome[7] = "ERICA";
		nome[8] = "ROBERTO";
		nome[9] = "LEO";

		// Sobrenome

		sobrenome[0] = "AUGUSTO";
		sobrenome[1] = "SOARES";
		sobrenome[2] = "LUIS";
		sobrenome[3] = "SOUZA";
		sobrenome[4] = "PRISCILA";
		sobrenome[5] = "VIERA";
		sobrenome[6] = "GOMES";
		sobrenome[7] = "FREITAS";
		sobrenome[8] = "TAVARES";
		sobrenome[9] = "ALMEDIA";

		// Cidade

		cidade[0] = "CARPINA";
		cidade[1] = "LIMOEIRO";
		cidade[2] = "PAUDALHO";
		cidade[3] = "NAZARE";
		cidade[4] = "CARPINA";
		cidade[5] = "CARPINA";
		cidade[6] = "NAZARE";
		cidade[7] = "RECIFE";
		cidade[8] = "PAUDALHO";
		cidade[9] = "RECIFE";

		// Bairro

		bairro[0] = "CAJA";
		bairro[1] = "CENTRO";
		bairro[2] = "CENTRO";
		bairro[3] = "CENTRO";
		bairro[4] = "CENTRO";
		bairro[5] = "CAJA";
		bairro[6] = "JUA";
		bairro[7] = "CENTRO";
		bairro[8] = "CENTRO";
		bairro[9] = "CENTRO";

		// Logradouro

		logradouro[0] = "RUA DAS FLORES";
		logradouro[1] = "RUA B";
		logradouro[2] = "AV. FREITAS";
		logradouro[3] = "AV. BOM JESUS";
		logradouro[4] = "AV. ALUISO DE MELO";
		logradouro[5] = "RUA A";
		logradouro[6] = "LOT. VILA";
		logradouro[7] = "AV. CELTO MELO";
		logradouro[8] = "AV. FREITAS";
		logradouro[9] = "AV. MORAIS";

		// Número do estabelecimento

		numero[0] = 456;
		numero[1] = 354;
		numero[2] = 343;
		numero[3] = 497;
		numero[4] = 980;
		numero[5] = 232;
		numero[6] = 976;
		numero[7] = 180;
		numero[8] = 289;
		numero[9] = 676;

		// Fim dos clientes ###########################################################

		for (int i = 0; i < 10; i++) {
			id[i] = i;
		}
		// Marca dos computadores

		marca[0] = "HP";
		marca[1] = "HP";
		marca[2] = "VAIO";
		marca[3] = "VAIO";
		marca[4] = "ACER";
		marca[5] = "ACER";
		marca[6] = "QEBEK";
		marca[7] = "QEBEK";
		marca[8] = "CCE";
		marca[9] = "CCE";

		// Processador

		processador[0] = "INTEL";
		processador[1] = "AMD";
		processador[2] = "INTEL";
		processador[3] = "AMD";
		processador[4] = "INTEL";
		processador[5] = "AMD";
		processador[6] = "INTEL";
		processador[7] = "AMD";
		processador[8] = "INTEL";
		processador[9] = "AMD";

		// Memória RAM

		memoria[0] = 4;
		memoria[1] = 2;
		memoria[2] = 4;
		memoria[3] = 1;
		memoria[4] = 2;
		memoria[5] = 4;
		memoria[6] = 1;
		memoria[7] = 2;
		memoria[8] = 3;
		memoria[9] = 4;

		// HD

		hd[0] = 500;
		hd[1] = 250;
		hd[2] = 500;
		hd[3] = 250;
		hd[4] = 300;
		hd[5] = 500;
		hd[6] = 250;
		hd[7] = 500;
		hd[8] = 300;
		hd[9] = 500;

		// Preço dos precos

		preco[0] = 1300;
		preco[1] = 900;
		preco[2] = 1500;
		preco[3] = 1250;
		preco[4] = 1100;
		preco[5] = 1400;
		preco[6] = 800;
		preco[7] = 1100;
		preco[8] = 1000;
		preco[9] = 1200;

		// Fim dos computadores
		// ###########################################################

		// Menu Principal

		while (op == 0) {

			op = mostrarMenu();

			switch (op) {

			case 1:

				vendas(indice, indiceCliente);

				System.out.print("\n\t DESEJA VOLTAR AO MENU PRINCIPAL? (S/N): ");
				menuPrincipal = entrada.next();

				if (menuPrincipal.equals("S")) {

					op = 0;
				}

				else if (menuPrincipal.equals("N")) {

					System.out.println("\n\t ###  OBRIGADO POR UTILIZAR O SOFTWARE DA EMPRESA F5  ###\n");

					logo();
				}

				break;

			case 2:

				listar(indice);

				System.out.print("\n\t DESEJA VOLTAR AO MENU PRINCIPAL? (S/N): ");
				menuPrincipal = entrada.next();

				if (menuPrincipal.equals("S")) {

					op = 0;
				}

				else if (menuPrincipal.equals("N")) {

					System.out.println("\n\t ###  OBRIGADO POR UTILIZAR O SOFTWARE DA EMPRESA F5  ###\n");

					logo();
				}

				break;

			case 3:

				System.out.println("\n\n\t ###   CADASTRAR COMPUTADORES   ####");
				System.out.print("\n\tDIGITE A MARCA DO COMPUTADOR: ");
				String nome_produto;
				nome_produto = entrada.next();
				System.out.print("\n\tDIGITE A MARCA DO PROCESSADOR: ");
				String cpu;
				cpu = entrada.next();
				System.out.print("\n\tDIGITE O TAMANHO DA MEMÓRIA RAM: ");
				int memoria_ram;
				memoria_ram = entrada.nextInt();
				System.out.print("\n\tDIGITE O TAMANHO DO HD: ");
				int disco;
				disco = entrada.nextInt();
				System.out.print("\n\tDIGITE O PREÇO: R$ ");
				double preco_produto;
				preco_produto = entrada.nextDouble();
				cadastrarProdutos(indice, nome_produto, cpu, memoria_ram, disco, preco_produto);
				indice++;

				System.out.print("\n\t DESEJA VOLTAR AO MENU PRINCIPAL? (S/N): ");
				menuPrincipal = entrada.next();

				if (menuPrincipal.equals("S")) {

					op = 0;
				}

				else if (menuPrincipal.equals("N")) {

					System.out.println("\n\t ###  OBRIGADO POR UTILIZAR O SOFTWARE DA EMPRESA F5  ###\n");

					logo();
				}

				break;

			case 4:

				atualizarPreco(indice);

				System.out.print("\n\t DESEJA VOLTAR AO MENU PRINCIPAL? (S/N): ");
				menuPrincipal = entrada.next();

				if (menuPrincipal.equals("S")) {

					op = 0;
				}

				else if (menuPrincipal.equals("N")) {

					System.out.println("\n\t ###  OBRIGADO POR UTILIZAR O SOFTWARE DA EMPRESA F5  ###\n");

					logo();
				}

				break;

			case 5:

				do {

					System.out.println("\n\t\t ###  CONSULTA DE COMPUTADORES  ###");
					System.out.println("\n\tVOCÊ DESEJA CONSULTAR POR:");
					System.out.println("\n\t 1 - CÓDIGO");
					System.out.println("\n\t 2 - MARCA");
					System.out.println("\n\t 3 - PROCESSADOR");
					System.out.println("\n\t 4 - MEMÓRIA");
					System.out.println("\n\t 5 - HD");
					System.out.println("\n\t 6 - PREÇO");
					System.out.print("\n\t DIGITE A OPÇÃO: ");
					opcao = entrada.nextInt();

					if (opcao == 1) {

						consultarCodigo(indice);
						break;
					}

					else if (opcao == 2) {

						consultarMarca(indice);
						break;
					}

					else if (opcao == 3) {

						consultarProcessador(indice);
						break;
					}

					else if (opcao == 4) {

						consultarMemoria(indice);
						break;
					}

					else if (opcao == 5) {

						consultarHD(indice);
						break;
					}

					else if (opcao == 6) {

						consultarPreco(indice);
						break;
					}

					else

						System.out.println("\n\t XXX  OPÇÃO INVÁLIDA!  XXX\n");

				} while (menuCadastro == 0);

				System.out.print("\n\t DESEJA VOLTAR AO MENU PRINCIPAL? (S/N): ");
				menuPrincipal = entrada.next();

				if (menuPrincipal.equals("S")) {

					op = 0;
				}

				else if (menuPrincipal.equals("N")) {

					System.out.println("\n\t ###  OBRIGADO POR UTILIZAR O SOFTWARE DA EMPRESA F5  ###\n");

					logo();
				}

				break;

			case 6:
				indice = excluirProduto(indice);

				System.out.print("\n\t DESEJA VOLTAR AO MENU PRINCIPAL? (S/N): ");
				menuPrincipal = entrada.next();

				if (menuPrincipal.equals("S")) {

					op = 0;
				}

				else if (menuPrincipal.equals("N")) {

					System.out.println("\n\t ###  OBRIGADO POR UTILIZAR O SOFTWARE DA EMPRESA F5  ###\n");

					logo();
				}

				break;

			case 7:

				listarCliente(indiceCliente);

				System.out.print("\n\t DESEJA VOLTAR AO MENU PRINCIPAL? (S/N): ");
				menuPrincipal = entrada.next();

				if (menuPrincipal.equals("S")) {

					op = 0;
				}

				else if (menuPrincipal.equals("N")) {

					System.out.println("\n\t ###  OBRIGADO POR UTILIZAR O SOFTWARE DA EMPRESA F5  ###\n");

					logo();
				}

				break;

			case 8:

				do {

					System.out.println("\n\t\t ###  CONSULTA CLIENTE  ###");
					System.out.println("\n\tVOCÊ DESEJA CONSULTAR POR:");
					System.out.println("\n\t 1 - ID");
					System.out.println("\n\t 2 - NOME");
					System.out.println("\n\t 3 - SOBRENOME");
					System.out.println("\n\t 4 - CIDADE");
					System.out.print("\n\t DIGITE A OPÇÃO: ");
					menuCadastroCliente = entrada.nextInt();

					if (menuCadastroCliente == 1) {

						consultarIDCliente(indiceCliente);

						break;
					}

					else if (menuCadastroCliente == 2) {

						consultarNome(indiceCliente);

						break;
					}

					else if (menuCadastroCliente == 3) {

						consultarSobrenome(indiceCliente);

						break;
					}

					else if (menuCadastroCliente == 4) {

						consultarCidade(indice);

						break;
					}

				} while (menuCadastroCliente == 0);

				System.out.print("\n\t DESEJA VOLTAR AO MENU PRINCIPAL? (S/N): ");
				menuPrincipal = entrada.next();

				if (menuPrincipal.equals("S")) {

					op = 0;
				}

				else if (menuPrincipal.equals("N")) {

					System.out.println("\n\t ###  OBRIGADO POR UTILIZAR O SOFTWARE DA EMPRESA F5  ###\n");

					logo();
				}

				break;

			case 9:

				System.out.println("\n\n\t ###   CADASTRAR CLIENTE   ####");
				System.out.print("\n\tDIGITE O NOME: ");
				String nomeCliente;
				nomeCliente = entrada.next();
				System.out.print("\n\tDIGITE O SOBRENOME: ");
				String sobrenomeCliente;
				sobrenomeCliente = entrada.next();
				System.out.print("\n\tDIGITE O CPF: ");
				String cpfCliente;
				cpfCliente = entrada.next();
				System.out.print("\n\tDIGITE A CIDADE: ");
				String cidadeCliente;
				cidadeCliente = entrada.next();
				System.out.print("\n\tDIGITE O BAIRRO: ");
				String bairroCliente;
				bairroCliente = entrada.next();
				System.out.print("\n\tDIGITE O LOGRADOURO: ");
				String logradouroCliente;
				logradouroCliente = entrada.next();
				System.out.print("\n\tDIGITE O Nº DA CASA: ");
				int numeroCliente;
				numeroCliente = entrada.nextInt();
				cadastrarCliente(indiceCliente, nomeCliente, cpfCliente, sobrenomeCliente, cidadeCliente, bairroCliente,
						logradouroCliente, numeroCliente);
				indiceCliente++;

				System.out.print("\n\t #### CADASTRO REALIZADO COM SUCESSO ### \n");

				System.out.print("\n\t DESEJA VOLTAR AO MENU PRINCIPAL? (S/N): ");
				menuPrincipal = entrada.next();

				if (menuPrincipal.equals("S")) {

					op = 0;
				}

				else if (menuPrincipal.equals("N")) {

					System.out.println("\n\t ###  OBRIGADO POR UTILIZAR O SOFTWARE DA EMPRESA F5  ###\n");

					logo();
				}

				break;

			case 10:

				atualizarCliente(indiceCliente);

				System.out.print("\n\t DESEJA VOLTAR AO MENU PRINCIPAL? (S/N): ");
				menuPrincipal = entrada.next();

				if (menuPrincipal.equals("S")) {

					op = 0;
				}

				else if (menuPrincipal.equals("N")) {

					System.out.println("\n\t ###  OBRIGADO POR UTILIZAR O SOFTWARE DA EMPRESA F5  ###\n");

					logo();
				}

				break;

			case 11:

				indiceCliente = excluirCliente(indiceCliente);

				System.out.print("\n\t DESEJA VOLTAR AO MENU PRINCIPAL? (S/N): ");
				menuPrincipal = entrada.next();

				if (menuPrincipal.equals("S")) {

					op = 0;
				}

				else if (menuPrincipal.equals("N")) {

					System.out.println("\n\t ###  OBRIGADO POR UTILIZAR O SOFTWARE DA EMPRESA F5  ###\n");

					logo();
				}

				break;

			case 12:

				System.out.println("\n\t ###  OBRIGADO POR UTILIZAR O SOFTWARE DA EMPRESA F5  ###\n");
				logo();

				break;

			default:
				break;

			}

		}

	}

}
