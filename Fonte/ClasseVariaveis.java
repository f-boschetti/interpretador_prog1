class ClasseVariaveis{
		
			
	static private String variaveis[] = new String [1000];
	static private String conteudos[] = new String [1000];
	static private int indice;
	
	// procura no vetor de variaveis a variavel recebida como parametro
	public int indiceVariavel(String variavel) {
		return java.util.Arrays.asList(variaveis).indexOf(variavel);
	}
	
	// retorna o valor da variável no indice x
	static public String getConteudo(int x){
		return conteudos[x];
	}
			
	// retorna o conteudo da variável com o nome recebido
	public String getConteudo(String variavel){
		return conteudos[indiceVariavel(variavel)];
	}
			
	// guarda o nome da variavel e seu conteudo em dois vetores no mesmo indice
	public void setVariavel(String variavel, String conteudo){
		variaveis[indice] = variavel;
		conteudos[indice] = conteudo;
		indice++;
	}
			
	// atribui um novo valor a variavel existente
	public void setConteudo(String variavel, String conteudo){
		conteudos[indiceVariavel(variavel)] = conteudo;
	}
			
	// imprime o nome da variavel e seu valor
	public void imprimeVariavel(int index){
		System.out.println("Variavel e Conteudo (" + variaveis[index] + "|" + conteudos[index] + ")");
	}

	//verifica se a variavel dada como parâmetro existe
	public boolean existeVariavel(String variavel){
		if (indiceVariavel(variavel) > -1){
			return true;
		}else {
			return false;
		}
	}
}
