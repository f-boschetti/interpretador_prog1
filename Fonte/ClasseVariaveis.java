public class ClasseVariaveis{		
			
			private String variaveis[] = new String [1000];
			private String conteudos[] = new String [1000];
			private int indice;
			
			// procura no vetor de variaveis a variavel recebida como parametro
			public int indiceVariavel(String variavel) {
				return java.util.Arrays.asList(this.variaveis).indexOf(variavel);
			}
			
			// retorna o valor da vari�vel no indice x
			public String getConteudo(int x){
				return this.conteudos[x];
			}
			
			// retorna o conteudo da vari�vel com o nome recebido
			public String getConteudo(String variavel){
				return this.conteudos[indiceVariavel(variavel)];
			}
			
			// guarda o nome da variavel e seu conteudo em dois vetores no mesmo indice
			public void setVariavel(String variavel, String conteudo){
				this.variaveis[this.indice] = variavel;
				this.conteudos[this.indice] = conteudo;
				this.indice++;
			}
			
			// atribui um novo valor a variavel existente
			public void setConteudo(String variavel, String conteudo){
				this.conteudos[indiceVariavel(variavel)] = conteudo;
			}
			
			// imprime o nome da variavel e seu valor
			public void imprimeVariavel(int index){
				System.out.println("Variavel: " + this.variaveis[index]);
				System.out.println("Conteudo: " + this.conteudos[index]);
			}
			
	public static void main(String[] args) {
		//##################
		//TESTE DOS METODOS#   FUNCIONANDO COMO O ESPERADO!!
		//##################
		ClasseVariaveis teste = new ClasseVariaveis();
				
		teste.setVariavel("a", "2");
		teste.setVariavel("b", "5");
		teste.setVariavel("c", "a + b");
		teste.setVariavel("s", "'a + b'");
		teste.setVariavel("print", "s + c");
		teste.setVariavel("print", "'s + c'");
				
		
		teste.imprimeVariavel(teste.indiceVariavel("s"));
		System.out.println(teste.getConteudo(1));
		teste.setConteudo("b", "novo");
		System.out.println(teste.getConteudo("b"));
			}
}
