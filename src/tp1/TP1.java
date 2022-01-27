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
	            case 2 -> GerenciarPalavras();
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
	
	public static void GerenciarTemas(String[][] dados, int qtemas, int[] qpalavras) {
		
		
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
	            case 2 -> ExcluirTema(dados,qtemas);
	            case 3 -> {}
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
				}else repetido = false;
			}
		}while(repetido);
		
		dados[qtemas][0] = nome;
		qtemas++;
		
		System.out.println("\nTema cadastrado com sucesso\n");
		
		
	}
	
	public static void ExcluirTema(String[][] dados, int qtemas) {
		String nome;
		int i;
		boolean achei = false;
		boolean cheio = false;
		
		ler.nextLine();
		
		System.out.print("Nome do Tema: ");
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
			}
		}	
	}
	
	public static void BuscaTema(String[][] dados, int qtemas) {
		String nome;
		
		ler.nextLine();
		
		for(int i = 0; i < qtemas; i++) {
			
		}
	}
	
	public static void GerenciarPalavras() {
		
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


