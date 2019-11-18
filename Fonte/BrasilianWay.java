import java.util.Scanner;
import java.io.*;


public class BrasilianWay{
	public static void main(String args[]) {
		
		//Cria um objeto "funçoes"
		Funcoes interpretador = new Funcoes();
		
		
		try {
			//Passa os comandos para o args, como sugerido nas dicacs			
			File programa = new File(args[0]);
			Scanner programaEscaneado = new Scanner(programa);
			
			//passamos o args para um vetor de strings
			//e o metodo "interpreta" se encarrega do resto
			//talvez fosse melhor um arrayList
			String linhasPrograma[] = new String[1000];
			int x = 0;
			while (programaEscaneado.hasNextLine()) {
				linhasPrograma[x] = programaEscaneado.nextLine();
				x++;
			}
			interpretador.interpreta(linhasPrograma);
			
			
			/*
			for(String y : linhasPrograma) {
				if(y != null) {
					System.out.println(y);
				}
			}*/
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Não foi possivel encontrar o arquivo");
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}