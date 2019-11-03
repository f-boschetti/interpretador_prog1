public class Funcao{
	
public static void main(String[] args) {

class Variaveis{

			
			private String variaveis[] = new String [1000];
			private String conteudos[] = new String [1000];
			private int indice;
			
			// procura no vetor de variaveis a variavel recebida como parametro
			public int indiceVariavel(String variavel) {
				return java.util.Arrays.asList(this.variaveis).indexOf(variavel);
			}
			
			// retorna o valor da variável no indice x
			public String getConteudo(int x){
				return this.conteudos[x];
			}
			
			// retorna o conteudo da variável com o nome recebido
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
	}// fim class variaveis

		//##################
		//TESTE DOS METODOS#   FUNCIONANDO COMO O ESPERADO!!
		//##################
		Variaveis teste = new Variaveis();
		
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
		
		
		/*
		//funciona e retorna null
		teste.imprimeVariavel(0);
		teste.imprimeVariavel(1);
		teste.imprimeVariavel(2);
		teste.imprimeVariavel(3);
		teste.imprimeVariavel(4);
		teste.imprimeVariavel(5);
		teste.imprimeVariavel(6);
		*/
}//fim da main
}//fim da classe temporaria 