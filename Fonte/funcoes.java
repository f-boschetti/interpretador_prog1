import java.util.Scanner;
import java.util.regex.Pattern;

public class teste {

	public static void main(String[] args) {
		
		class funcoes{
			private String atribuicao = ":=";
			public void interpreta(String programa[]) {
				for (int linha = 0 ; programa[linha] != null; linha ++) {
					if (programa[linha].contains(atribuicao)){
						programa[linha].trim();
						programa[linha].indexOf(atribuicao);
						
						
						
					}
					
					
					
					
					/*if (programa[linha].contains("==") ||
						programa[linha].contains("+=") ||
						programa[linha].contains("-=") ||
						programa[linha].contains("!=")){
						
						
						
					}*/	
				}
			}

		}
		
		
		
		
		//UM JEITO DE PASSAR O ARQUIVO PRO ARGS LINHA POR LINHA

		String a = "a := 10"
				+ "\nb := 15"
				+ "\nc := a + b"
				+ "\ns := 'a soma"
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
        	System.out.println(programa[i]);
        	i++;
            //System.out.println(programa[i].getClass().getName());
        }
        /*System.out.println("".isEmpty());
        if (programa[10] != null){
        	System.out.println("".isEmpty());}
        else {
        	System.out.println(-1);
        			
        	}*/
        }
        
	}
