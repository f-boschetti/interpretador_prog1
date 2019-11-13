import java.util.Scanner;

//os print's são para testar o codigo, apagar depois!!!!
//não tenho certeza se precisa do extends, quase certeza que NÃO
public class Funcoes extends ClasseVariaveis{
	private String atribuicao = ":=";
	private String[] operadoresMatematicos = {"+", "-", "*", "/", "%"};
	private String[] operadoresBooleanos = {"==", "!=", "@or", "@and", ">", "<"}; //não sei oq fazer com a or e a and
	
	//talvez um nome melhor para a variavel fosse "m" !?
	static private ClasseVariaveis memoria = new ClasseVariaveis();
			
			
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
				//se tiver ; ele ignora o ; PARA OS NUMEROS
				try{							
		        	valor = Double.parseDouble(programa[linha].split("=")[1].replace(" ", ""));
		        	//GUARDA COMO STRING
		        	if (memoria.indiceVariavel(nomeDaVariavel) == -1){
		        		memoria.setVariavel(nomeDaVariavel, valor.toString());
		        	}else {memoria.setConteudo(nomeDaVariavel, valor.toString());
		        		}
		        }

				//resolve o erro se nao for double
				catch (NumberFormatException e) {
					//Reconhece qualquer string dentro dos operadoresBooleanos, descobri o "for each" :)
					for(String k : operadoresBooleanos) {
						if (programa[linha].split("=")[1].contains(k)) {
							String Booleano = "Booleano";
			        		if(memoria.indiceVariavel(nomeDaVariavel) == -1) {
			        			memoria.setVariavel(nomeDaVariavel, Booleano);
			        		}else {
			        			memoria.setConteudo(nomeDaVariavel, "outro booleano");
			        		}
						}
					}

					//Reconhece qualquer string dentro dos operadoresMatematicos, descobri o "for each" :)
					for(String l : operadoresMatematicos){
						if (programa[linha].split("=")[1].contains(l)) {
							if(memoria.indiceVariavel(nomeDaVariavel) == -1) {
								memoria.setVariavel(nomeDaVariavel, programa[linha].split("=")[1].trim().replace(" ", ""));
							}else {
								memoria.setConteudo(nomeDaVariavel, programa[linha].split("=")[1].trim().replace(" ", ""));
							}
						}
					}

					//se tiver ' é string
					if (programa[linha].split("=")[1].contains("'")) {
		        		if(memoria.indiceVariavel(nomeDaVariavel) == -1){
		        			memoria.setVariavel(nomeDaVariavel, programa[linha].split("=")[1].trim().replace("'", ""));
		        		}else {
			        		memoria.setVariavel(nomeDaVariavel, programa[linha].split("=")[1].trim().replace("'", ""));
		        		}
		        	}

					//Verifica se é booleano, resolver com o IF
					else if (programa[linha].split("=")[1].toLowerCase().contains("true")) {
						if(memoria.indiceVariavel(nomeDaVariavel) == -1) {
							memoria.setVariavel(nomeDaVariavel, "true");
						}else {
							memoria.setConteudo(nomeDaVariavel, "true");
						}
		        	}
					else if (programa[linha].split("=")[1].toLowerCase().contains("false")) {
						if(memoria.indiceVariavel(nomeDaVariavel) == -1) {
							memoria.setVariavel(nomeDaVariavel, "false");
						}else {
							memoria.setConteudo(nomeDaVariavel, "false");
						}
					}
					
					//reconhece se é um numero com ;
					else if ((programa[linha].split("=")[1].indexOf("'") == -1)) {
		        		if (programa[linha].split("=")[1].contains(";")) {
		        			System.out.print(nomeDaVariavel + "|");
		    				System.out.println(Double.parseDouble(programa[linha].split("=")[1].replace(" ", "").replace(";", "")));
		    			}	
		        	}
					/*if (programa[linha].split("=")[1].contains("*")) {
						int arrl= 1
						boolean [] fif = new boolean(arrl);
						boolean allTrue = true;
						for (boolean teste : fif)
						{
						    if (!teste)
						    {
						        allTrue = false;
						        break;
						    }
						}
						}
					}
				
				
				
				}//fim do catch
			}//fim do if "atribuição"
		}//fim do for para cada linha diferente de null
		
		 /*
		int contador = 0;
		System.out.println("________________________________________________________________________");
		for(String x : conteudos) {
			if(x != null) {
				System.out.println(variaveis[contador] + " | " + x);
				contador ++;
			}
		}
		
		System.out.println(conteudos[1]);
		*/
	}//fim do metodo interpreta
	

	public String operacoesMat(String expressao){
		
		return "x";
	}
		
		//####################
		//#TESTE DO PROGRAMA #
		//####################
		//tem a main pra testar os comandos
public static void main(String[] args) {
	String a = "a   := 10"
				+ "\nb := 15"
				+ "\nc := a + b     "
				+ "\nd := a> b     "
				+ "\ns := '  ;  a soma'     "
				+ "\n//um comentario"
				+ "\nv :=     True"
				+ "\nif a+b == c:"
				+ "\n	if c += 25:"
				+ "\n		imprime(s + c)"
				+ "\n	else:"
				+ "\n		while 25> c:"
				+ "\n			c++";
		
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
}//fim da classe funçoes
