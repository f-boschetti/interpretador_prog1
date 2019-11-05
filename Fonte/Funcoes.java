import java.util.Scanner;

//os print's são para testar o codigo, apagar depois!!!!
public class Funcoes extends ClasseVariaveis{
	private String atribuicao = ":=";
	private String[] operadoresMatematicos = {"+", "-", "*", "/", "%"};
	private String[] operadoresBooleanos = {"==", "!=", "@or", "@and", ">", "<"}; //não sei oq fazer com a or e a and
	
	static private ClasseVariaveis interpretador = new ClasseVariaveis();
			
			
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
		        	if (interpretador.indiceVariavel(nomeDaVariavel) == -1){
		        		interpretador.setVariavel(nomeDaVariavel, valor.toString());
		        	}else {interpretador.setConteudo(nomeDaVariavel, valor.toString());
		        		}
		        	interpretador.imprimeVariavel(interpretador.indiceVariavel(nomeDaVariavel));
	        		//System.out.println(interpretador.getConteudo(nomeDaVariavel).getClass());
		        }
				//resolve o erro se nao for double
				catch (NumberFormatException e) {
					//Reconhece qualquer string dentro dos operadoresBooleanos, descobri o "for each" :)
					for(String k : operadoresBooleanos) {
						if (programa[linha].split("=")[1].contains(k)) {
			        		String Booleano = "Booleano";
			        		interpretador.setVariavel(nomeDaVariavel, Booleano);
			        		interpretador.imprimeVariavel(interpretador.indiceVariavel(nomeDaVariavel));
						}
					}
					//Reconhece qualquer string dentro dos operadoresMatematicos, descobri o "for each" :)
					//TRATAR
					for(String l : operadoresMatematicos){
						if (programa[linha].split("=")[1].contains(l)) {
							interpretador.setVariavel(nomeDaVariavel, "Equação a resolver, STRING");
			        		interpretador.imprimeVariavel(interpretador.indiceVariavel(nomeDaVariavel));
						}
					}
					//se tiver ' é string JA RESOLVIDO
					if (programa[linha].split("=")[1].contains("'")) {
		        		//codigo final
		        		interpretador.setVariavel(nomeDaVariavel, programa[linha].split("=")[1].trim().replace("'", ""));
		        		interpretador.imprimeVariavel(interpretador.indiceVariavel(nomeDaVariavel));

		        	}
					//Verifica se é booleano, resolver com o IF
					else if (programa[linha].split("=")[1].toLowerCase().contains("true")) {
						interpretador.setVariavel(nomeDaVariavel, "true");
		        	}
					else if (programa[linha].split("=")[1].toLowerCase().contains("false")) {
						interpretador.setVariavel(nomeDaVariavel, "false");
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
	String a = "a   := 10"
				+ "\nb := 15"
				+ "\nc := a + b     "
				+ "\nc := a> b     "
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
	System.out.println(ClasseVariaveis.getConteudo(3));
	sc.close();
	}//fim da main
}//fim da classe funçoes
