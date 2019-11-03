import java.util.Scanner;

// ESTOU PENSANDO COMO SE TIVESSE 2 OU MAIS OBJEOTS "VARIAVEIS", UM COMO BACKUP
// UM PARA STRING E OUTRO PARA FLOAT, POREM TODOS COM OS MESMOS VALORES
public class Funcoes{
	private String atribuicao = ":=";
	private String[] carecteresReservador = {"==", "!=", "@or", "@and", ">", "<"}; //não sei oq fazer com a or e a and
	
	private ClasseVariaveis numerosEOperacoes = new ClasseVariaveis();
	private ClasseVariaveis textosEBooleanos = new ClasseVariaveis();
	private ClasseVariaveis original = new ClasseVariaveis();
			
			
	public void interpreta(String programa[]) {

		//para todas as linhas que não forem null
		for (int linha = 0 ; programa[linha] != null; linha ++) {

		//identifica uma atribuição
			if (programa[linha].contains(this.atribuicao)){
						
				programa[linha].trim();
				int inicioAtribuicao = programa[linha].indexOf(atribuicao);// o indexOf() passa o indice do PRIMEIRO caracter
				String nomeDaVariavel = programa[linha].substring(0, inicioAtribuicao).replace(" ", ""); //nome da variavel sem NENHUM ESPAÇO
				Double valor = 0.0;
						
				//tenta passar para double E RETORNA UM DOUBLE
				//se tiver ; ele ignora o ; PARA NUMEROS
				try{
					/*
					if (programa[linha].split("=")[1].replace(" ", "").contains(";")){
						programa[linha] = programa[linha].replace(";", "");
					}*/
							
		        	valor = Double.parseDouble(programa[linha].split("=")[1].replace(" ", ""));
		        	//System.out.println(programa[linha].split("=")[1].replace(" ", ""));
		        	//testes
		        	System.out.print(nomeDaVariavel + "|");
		        	System.out.println(valor);
		        	//codigo final
				        	
				        	
		        } 
				//resolve o erro se nao for double
				catch (NumberFormatException e) {
		        	//Se tiver um + é atribuicao TRATAR MELHOR ISSO
					if (programa[linha].split("=")[1].contains("+")) {
						//testes
		        		System.out.print(nomeDaVariavel + "|");
		        		System.out.println(programa[linha].split("=")[1].trim());
		        		//codigo final
				        		
				        		
		        	}
					//se tiver ' é string JA RESOLVIDO
					else if (programa[linha].split("=")[1].contains("'")) {
						//testes
		        		System.out.print(nomeDaVariavel + "|");
		        		System.out.println(programa[linha].split("=")[1].trim());
		        		//codigo final
				        		
				        		
		        	}
					//Verifica se é booleano, TRATAR
					else if (programa[linha].split("=")[1].toLowerCase().contains("true") || 
		        			  programa[linha].split("=")[1].toLowerCase().contains("false")) {
						//testes
		        		System.out.print(programa[linha].substring(0, programa[linha].indexOf(":=") ).replace(" ", "") + "|");
		        		System.out.println("bool");
		        		//codigo final
				        		
				        		
		        	}
					//reconhece se é um numero com ;
					else if ((programa[linha].split("=")[1].indexOf("'") == -1)) {
		        		if (programa[linha].split("=")[1].contains(";")) {
		        			System.out.print(nomeDaVariavel + "|");
		    				System.out.println(Double.parseDouble(programa[linha].split("=")[1].replace(" ", "").replace(";", "")));
		    			}
				        		
		        	}

							
							
		        }//fim do catch
						

						
						
						
			}//fim do if "atribuição"
		}//fim do for para cada linha diferente de null
	}//fim do metodo interpreta

		
		//####################
		//#TESTE DO PROGRAMA #
		//####################
		//tem a main pra testar os comandos
	public static void main(String[] args) {
		//UM JEITO DE PASSAR O ARQUIVO PRO ARGS LINHA POR LINHA
		String a = "testeiriri   := 1   0;"
					+ "\nb := 15   "
					+ "\nc := testeiriri + b     "
					+ "\ns := '  ;  a soma'     "
					+ "\n//um comentario"
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
		
		Funcoes teste = new Funcoes(); 
		teste.interpreta(programa);

		sc.close();
	}//fim da main
}//fim da classe funções
