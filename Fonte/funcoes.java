import java.util.Scanner;

public class teste {
	//tem a main pra testar os comandos!!!
	public static void main(String[] args) {
		//UM JEITO DE PASSAR O ARQUIVO PRO ARGS LINHA POR LINHA
		String a = "testeiriri   := 10"
				+ "\nb := 15"
				+ "\nc := testeiriri + b     "
				+ "\ns := '    a soma'     "
				+ "\nv :=     True"
				+ "\nif a+b == c:"
				+ "\n	if c += 25:"
				+ "\n		imprime(s + c)"
				+ "\n	else:"
				+ "\n		while 25> c:"
				+ "\n			c++";
		//System.out.println(a);
		
		String programa[] = new String[1000];

		Scanner sc = new Scanner(a);
		int i = 0;
        while(sc.hasNextLine()) {
        	programa[i] = sc.nextLine();
        	i++;
        }
        
		
		// ESTOU PENSANDO COMO SE TIVESSE 2 OU MAIS OBJEOTS "VARIAVEIS", UM COMO BACKUP
		// UM PARA STRING E OUTRO PARA FLOAT, POREM TODOS COM OS MESMOS VALORES
		class Funcoes{
			private String atribuicao = ":=";
			
			public void interpreta(String programa[]) {

				//para todas as linhas que não forem null
				for (int linha = 0 ; programa[linha] != null; linha ++) {

					//identifica uma atribuição
					if (programa[linha].contains(this.atribuicao)){
						
						programa[linha].trim();
						int inicioAtribuicao = programa[linha].indexOf(atribuicao);// o indexOf() passa o indice do PRIMEIRO caracter
						String nomeDaVariavel = programa[linha].substring(0, inicioAtribuicao).replace(" ", ""); //nome da variavel sem NENHUM ESPAÇO
						Double valor = 0.0;
						
						//tenta passar para double
						try{
				        	valor = Double.parseDouble(programa[linha].split("=")[1]);
				        	System.out.print(nomeDaVariavel + "|");
				        	System.out.println(valor);
				        	//System.out.println(programa[linha].split("'")[1]);
				        } 
						//resolve o erro se nao for double
						catch (NumberFormatException e) {
				        	//Se tiver um + é atribuicao TRATAR MELHOR ISSO
							if (programa[linha].split("=")[1].contains("+")) {
				        		System.out.print(nomeDaVariavel + "|");
				        		System.out.println(programa[linha].split("=")[1].trim());
				        	}
							//se tiver ' é string JA RESOLVIDO
							else if (programa[linha].split("=")[1].contains("'")) {
				        		System.out.print(nomeDaVariavel + "|");
				        		System.out.println(programa[linha].split("=")[1].trim());
				        	}
							//Verifica se é booleano, TRATAR
							else if (programa[linha].split("=")[1].toLowerCase().contains("true") || 
				        			  programa[linha].split("=")[1].toLowerCase().contains("false")) {
				        		System.out.print(programa[linha].substring(0, programa[linha].indexOf(":=") ).replace(" ", "") + "|");
				        		System.out.println("bool");
				        	}

				        	//Double valor = Double.parseDouble(programa[2].split("=")[1]);
				        	//System.out.println(valor);
				        }
						

						
						
						
					}
				}
			}

		}
		
		//####################
		//#TESTE DO PROGRAMA #
		//####################
		
		
		Funcoes teste = new Funcoes(); 
		teste.interpreta(programa);

		sc.close();
        }
        
	}
