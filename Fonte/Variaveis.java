import java.util.Scanner;
public class Variaveis {

	public static void main(String[] args) {
		
		class Variaveis{
			
			private String variaveis[] = new String [1000];
			private String conteudos[] = new String [1000];
			private int indice;
			
			// procura no vetor de variaveis a variavel recebida como parametro
			public int indiceVariavel(String variavel) {
				return java.util.Arrays.asList(variaveis).indexOf(variavel);
			}
			
			// retorna o valor da variável no indice x
			public String getConteudo(int x){
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
				System.out.println("Variavel: " + variaveis[index]);
				System.out.println("Valor: " + conteudos[index]);
			}			
			
		}
		
		//##################
		//TESTE DOS METODOS#   FUNCIONANDO COMO O ESPERADO!!
		//##################
		Variaveis teste = new Variaveis();
		
		teste.setVariavel("a", "2");
		teste.setVariavel("b", "5");
		teste.setVariavel("c", "a + b");
		teste.setVariavel("s", "'a + b'");
		teste.setVariavel("peint", "s + c");
		
		
		System.out.println(teste.indiceVariavel("s"));
		System.out.println(teste.getConteudo(1));
		teste.setConteudo("b", "novo");
		System.out.println(teste.getConteudo(1));
		teste.imprimeVariavel(0);
		
		
		//UM JEITO DE PASSAR O ARQUIVO PRO ARGS LINHA POR LINHA
		/*
		Variaveis teste = new Variaveis();
		
		String a = "a = 2"
				+ "\nb = 3"
				+ "\nc = a + b"
				+ "\ns = 'a soma"
				+ "\nimprime(s + c)";
		System.out.println(a);
		
		// a partir daqui começa a classe variaveis

		Scanner sc = new Scanner(a);
		int i = 0;
        while(sc.hasNextLine()) {
        	
        }*/
        
		
		
	}

}
