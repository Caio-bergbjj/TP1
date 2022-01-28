package tp1;

import java.util.Scanner;

public class TP1 {
	
	static Scanner ler = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		
		int op;
		int qtemas = 5; // Controle de quantidade/posição de temas
		int[] qpalavras = new int[50]; //Controle de quantidade/posição de palavras
		String[][] dados = new String[50][50];
		
		Preencher(dados,qpalavras); // Pre Cadastro de Temas e palavras
		

		do {
			menu();
			System.out.print("Opção -> ");
            op = ler.nextInt();
            switch (op) { // Selecionando a opção inserida
	            case 1 -> GerenciarTemas(dados,qtemas,qpalavras);
	            case 2 -> GerenciarPalavras(dados,qtemas,qpalavras);
	            case 3 -> Jogar();
	            case 4 -> System.out.println("Obrigado por usar o sitema. Fechando...");
	            case 5 -> Imprimir( dados,qtemas,qpalavras);
	            default -> System.out.println("Opção Inválida!");
            }
            
		}while(op != 4);
		
		
	}
	
	private static void menu(){
        System.out.println("\n\t\t=====================================");
        System.out.println("\t\t|     1 - Gerenciar Temas            |");
        System.out.println("\t\t|     2 - Gerenciar Palavras         |");
        System.out.println("\t\t|     3 - Jogar                      |");
        System.out.println("\t\t|     4 - Sair                       |");
        System.out.println("\t\t=====================================\n");

    }
	
	public static void GerenciarTemas(String[][] dados, int qtemas, int [] qpalavras) {
		
		
		int op;
		do {
			System.out.println("\n\t\t=========== Gerenciar Temas =========");
	        System.out.println("\t\t|     1 - Cadastro                  |");
	        System.out.println("\t\t|     2 - Exclusao                  |");
	        System.out.println("\t\t|     3 - Busca                     |");
	        System.out.println("\t\t|     4 - Voltar                    |");
	        System.out.println("\t\t=====================================\n");
        
        
			System.out.print("Opção -> ");
            op = ler.nextInt();
            switch (op) { // Selecionando a opção inserida
	            case 1 -> CadastroTema(dados, qtemas);
	            case 2 -> ExcluirTema(dados,qtemas,qpalavras);
	            case 3 -> BuscaTema(dados, qtemas);
	            case 4 -> {}
	            default -> System.out.println("Opção Inválida!");
            }
            
		}while(op != 4);
		
	}
	
	public static void CadastroTema(String[][] dados, int qtemas) {
		
		String nome;
		boolean repetido = false;
		
		ler.nextLine();
		
		do {
			System.out.print("Nome do Tema: ");
			nome = ler.nextLine();
			
			for (int i = 0; i < qtemas; i++) {
				if(dados[i][0].equalsIgnoreCase(nome)) {
					repetido = true;
					System.out.println("\n Tema ja cadastrado. Cadastre um Tema diferente.\n");
					break;
				}
			}
		}while(repetido);
		
		dados[qtemas][0] = nome;
		qtemas++;
		
		System.out.println("\nTema cadastrado com sucesso\n");
		
		
	}
	
	public static void ExcluirTema(String[][] dados, int qtemas, int[] qpalavras) {
		String nome;
		int i;
		boolean achei = false;
		boolean cheio = false;
		
		ler.nextLine();
		
		System.out.print("Nome do Tema que sera excluído: ");
		nome = ler.nextLine();
			
		for (i = 0; i < qtemas; i++) {
			if(dados[i][0].equalsIgnoreCase(nome)) {
				achei = true;
				if(dados[i][1] != null) {
					System.out.println("Não foi possível excluir o tema. "
							+ "\nVerifique se existem palavras cadastradas nesse tema.");
					cheio = true;
					break;
				}
				break;
			}	
		}
		if(!achei) { 
			System.out.println("Tema não encontrado");
		}else if(!cheio) {
			for(int j = i; j < qtemas; j++) {
				if(qtemas - 1 == j ) dados[j][0] = null;
				else dados[j][0] = dados[j+1][0];
				for(int k = 1; k < qpalavras[j]; k++) {
					if(qpalavras[j] - 1 == k) dados[j][k] = null;
					else dados[j][k] = dados[j+1][k];
				}
			}
			System.out.println("Tema excluído com sucesso");
		}	
	}
	
	public static void BuscaTema(String[][] dados, int qtemas) {
		String nome;
		
		ler.nextLine();
		System.out.println("Digite o nome do tema que quer buscar: ");
		nome = ler.nextLine();
		
		for(int i = 0; i < qtemas; i++) {
			if(dados[i][0].equalsIgnoreCase(nome)) {
				System.out.println("Tema -> " + dados[i][0]);
				break;
			} else System.out.println("Tema não encontrado");
		}
	}
	
	public static void GerenciarPalavras(String[][] dados, int qtemas, int[] qpalavras) {
		int op;
		
		do {
			System.out.println("\n\t\t========= Gerenciar Palavras ========");
	        System.out.println("\t\t|     1 - Cadastro                  |");
	        System.out.println("\t\t|     2 - Exclusao                  |");
	        System.out.println("\t\t|     3 - Busca                     |");
	        System.out.println("\t\t|     4 - Listagem                  |");
	        System.out.println("\t\t|     5 - Voltar                    |");
	        System.out.println("\t\t=====================================\n");
        
        
			System.out.print("Opção -> ");
            op = ler.nextInt();
            switch (op) { // Selecionando a opção inserida
	            case 1 -> CadastroPalavra( dados, qtemas,  qpalavras);
	            case 2 -> ExcluirPalavra(dados, qtemas,qpalavras);
	            case 3 -> BuscaPalavra(dados,qtemas,qpalavras);
	            case 4 -> Listagem(dados, qtemas,qpalavras);
	            case 5 -> {}
	            default -> System.out.println("Opção Inválida!");
            }
            
		}while(op != 5);
		
	}
	
public static void CadastroPalavra(String[][] dados, int qtemas, int[] qpalavras) {
		
		String nomeTema, palavra;
		boolean repetido = false;
		boolean nTema = true;
		int i;
		
		ler.nextLine();
		
		do {
			System.out.println("Digite nome do tema em que a palavra será cadastrada.\nNome do Tema: ");
			nomeTema = ler.nextLine();
			
			for ( i = 0; i < qtemas; i++) {
				if(dados[i][0].equalsIgnoreCase(nomeTema)) {
					nTema = true;
					break;
				}
			}
			
			if(nTema) {
				System.out.println("Tema não encontrado. Digite um tema existente");
			}
		}while(nTema);
		
		do {
			
			System.out.println("Digite a palavra: ");
			palavra = ler.nextLine();
			
			for (int j = 1; j < qpalavras[i]; j++) {
				if(dados[i][j].equalsIgnoreCase(palavra)) {
					repetido = true;
					System.out.println("\n Palavra ja cadastrado. Cadastre uma Palavra diferente.\n");
					break;
				}
			}
		}while(repetido);
		
		dados[i][qpalavras[i]] = palavra;
		qpalavras[i]++;
		
		System.out.println("\nPalavra cadastrado com sucesso\n");
		
		
	}

public static void ExcluirPalavra(String[][] dados, int qtemas, int[] qpalavras) {
	String nome;
	int i;
	int j = 1;
	boolean achei = false;
	
	ler.nextLine();
	
	System.out.print("Palavra que será excluída: ");
	nome = ler.nextLine();
		
	for (i = 0; i < qtemas; i++) {
		for(j = 1; j < qpalavras[i]; j++) {
			if(dados[i][j].equalsIgnoreCase(nome)) {
				achei = true;
				break;
			}
		}
	}	
	
	if(!achei) { 
		System.out.println("Palavra não encontrado.\n");
	}else {
		for(int k = j; k < qtemas; k++) {
			if(qpalavras[i] - 1 == k ) dados[i][k] = null;
			else dados[i][k] = dados[i][k+1];
		}
		System.out.println("Palavra excluída com sucesso.\n");
	}	
}

public static void BuscaPalavra(String[][] dados, int qtemas, int[] qpalavras) {
	String nome;
	
	ler.nextLine();
	System.out.println("Digite a palavra que quer buscar: ");
	nome = ler.nextLine();
	
	for(int i = 0; i < qtemas; i++) {
		for(int j = 1; j < qpalavras[i]; j++) {
			if(dados[i][j].equalsIgnoreCase(nome)) {
				System.out.println("Palavra encontrada no tema " + dados[i][0]);
				break;
			} else System.out.println("Palavra não encontrada");
		}
	}
}

public static void Listagem(String[][] dados, int qtemas, int[] qpalavras) {
	String tema;
	
	System.out.print("Digite o tema que quer listar as palavras: ");
	ler.nextLine();
	tema = ler.nextLine();
	
	for(int i = 0; i < qtemas; i++) {
		if(dados[i][0].equalsIgnoreCase(tema)) {
			System.out.println("Tema: " + dados[i][0]);
			for(int j = 1; j < qpalavras[i]; j++ ) {
				System.out.println(dados[i][j]);
			}
			break;
		}
	}
	
}

	public static void Jogar() {
	
}
	public static void Preencher(String[][] dados, int[] qpalavras) {
		
		for(int i = 0; i < 5; i++ ){
			dados[i][0] ="Tema" + (i+1);
			qpalavras[i] = 11;
			for(int j = 1; j <= 10; j++) 
				dados[i][j] = "Palavra" + (i) + "" + (j-1);
		}
		
	}
	public static void Imprimir(String[][] dados, int qtemas, int[] qpalavras) {
		
		for(int i = 0; i < qtemas; i++) {
			System.out.print(dados[i][0]);
			for(int j = 1; j < qpalavras[i]; j++) {
				System.out.print(" " + dados[i][j]);
			}
		}
	}
	
}


