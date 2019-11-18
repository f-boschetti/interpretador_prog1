import java.util.Scanner;

//Quase certeza que não precisa do extends
//Sei que os metodos operacoesMat e operacoesLogicas não estão erientadas p/ objetos, mas n consegui fazer melhor
public class Funcoes extends ClasseVariaveis{
	private String atribuicao = ":=";
	private String[] operadoresMatematicos = {"+", "-", "*", "/", "%"};
	private String[] operadoresBooleanos = {"#", "$", ">", "<", "<#", ">#"}; 
	
	static private ClasseVariaveis memoria = new ClasseVariaveis();
			
			
	public void interpreta(String programa[]) {
		//para todas as linhas que não forem null
		for (int linha = 0 ; programa[linha] != null; linha ++) {

		//identifica uma atribuição
			if (programa[linha].contains(this.atribuicao)){
				programa[linha].trim();
				int inicioAtribuicao = programa[linha].indexOf(this.atribuicao);// o indexOf() passa o indice do PRIMEIRO caracter
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
			        		if(memoria.indiceVariavel(nomeDaVariavel) == -1) {
			        			memoria.setVariavel(nomeDaVariavel, operacoesLogicas(programa[linha].split("=")[1].replace(" ", "")));
			        		}else {
			        			memoria.setConteudo(nomeDaVariavel, operacoesLogicas(programa[linha].split("=")[1].replace(" ", "")));
			        		}
						}
					}

					//Reconhece qualquer string dentro dos operadoresMatematicos, descobri o "for each" :)
					for(String l : operadoresMatematicos){
						if (programa[linha].split("=")[1].contains(l)) {
							if(memoria.indiceVariavel(nomeDaVariavel) == -1) {
								memoria.setVariavel(nomeDaVariavel, operacoesMat(programa[linha].split("=")[1].replace(" ", "")));
							}else {
								memoria.setConteudo(nomeDaVariavel, operacoesMat(programa[linha].split("=")[1].replace(" ", "")));
							}
						}
					}

					//se tiver ' é string
					if (programa[linha].split("=")[1].contains("'")) {
		        		if(memoria.indiceVariavel(nomeDaVariavel) == -1){
		        			memoria.setVariavel(nomeDaVariavel, programa[linha].split("=")[1].replace("'", ""));
		        		}else {
			        		memoria.setVariavel(nomeDaVariavel, programa[linha].split("=")[1].replace("'", ""));
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
		        }//fim do catch
			}// fim atribuição
			
			if (programa[linha].trim().startsWith("imprime:")) {
				this.imprime(programa[linha].trim());
			}
		}				
	}
	
	//SOMENTE DOIS NUMEROS POR VEZ
	public String operacoesMat(String expressao){
		String numeros[];
		String operadores[];
		//Double com "D" para poder converter para string depois
		Double resultado = 0.0;
		
		numeros		= expressao.split("\\+|\\-|\\*|\\/|\\%");
		operadores	= expressao.split("((\\w+|\\.+)+)");
		//troca os valores das variaveis pelos valores armazenados
		for(int i=0; i<numeros.length; i++) {
			if(memoria.existeVariavel(numeros[i])) {
				numeros[i] = memoria.getConteudo(numeros[i]);
			}
		}
		
		Double valor1	= Double.parseDouble(numeros[0].trim());
		Double valor2 	= Double.parseDouble(numeros[1].trim());
		String operador		= operadores[1].trim();
		
		switch(operador){
		case "+": resultado = valor1 + valor2; break; //soma
		case "-": resultado = valor1 - valor2; break; //subtração
		case "*": resultado = valor1 * valor2; break; //multiplicação
		case "/": resultado = valor1 / valor2; break; //divisão
		case "%": resultado = valor1 % valor2; break; //mod
		}
		return resultado.toString();
	}
		
	
	//SOMENTE DOIS POR VEZ
	//Exatamente igual as operaçoes matematicas
	public String operacoesLogicas(String expressao) {
		String operandos[];
		String operadores[];
		
		//Double com "D" para poder converter para string depois
		Boolean resultado = null;
		operadores	= expressao.split("((\\w+|\\.+)+)"); 
		operandos = expressao.split("\\#|\\$|\\<\\#|\\>\\#|\\<|\\>");//letras e numeros que possam ser variaveis
		
		for (int i=0; i<operandos.length; i++){
			if(memoria.existeVariavel(operandos[i])){
				operandos[i] = memoria.getConteudo(operandos[i]);
			}
		}
		
		Double valor1	= Double.parseDouble(operandos[0].trim());
		Double valor2 	= Double.parseDouble(operandos[1].trim());
		String operador		= operadores[1].trim();

		switch (operador){
		case "#": resultado = valor1 == valor2; break; // igual
		case "$": resultado = valor1 != valor2; break; // diferente
		case "<": resultado = valor1 < valor2; break; // menor
		case ">": resultado = valor1 > valor2; break; // maior
		case "<#": resultado = valor1 <= valor2; break; // menor igual
		case ">#": resultado = valor1 >= valor2; break; // maior igual
		}
		return resultado.toString();
	}
	
	
	public void imprime(String imprimir) {
		
		//linha em branco
		if(imprimir.replace(" ", "").equals("imprime:")) {
			System.out.println("");
		}
		//Imprime texto simples
		else if(imprimir.contains("'")) {
			String texto = imprimir.split("'")[1].replace("|m", "\n");
			System.out.print(texto);
		}
		else{
			boolean novaLinha = false;
			String variavel = imprimir.replace(" ", "").replace("imprime:", "");
			if(variavel.contains("|m")) {
				novaLinha = true;
				variavel = variavel.replace("|m", "");
			}
			System.out.print(memoria.getConteudo(variavel));
			if(novaLinha) {
				System.out.println();
			}
			}

	}

	public void se(String condicional) {
		
		
	}
}//fim da classe funçoes
