//Não sei o por que de uma classe erro no nosso projeto
//O colega que começou o projeto nao terminou e perdi completamente o contato com ele
//Felipe

class Erro extends java.lang.Throwable{
	


	private static final long serialVersionUID = 1L;

	public Erro(int e, int linha, String frase){
		
		System.out.println("Na linha: " + (linha+1));
		
	

		switch(e){
			case 1:
				System.out.println("\tNão coloque ; ou outro caractere no final do código!");
				break;
				//pra criar novo erro criar com case + numero q o erro vai lançar *ex no codigo Copper Erro(1, l,"")
		}
	
		
	}
}