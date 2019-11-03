package interpretador_prog1;
import java.util.Scanner;
import java.io.*;

public class Copper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String linha[] = new String[2000];
		 File file;
		 Scanner sc;	
		 
	        try {
	            file = new File(args[0]);
	            sc = new Scanner(file);
	            funcoes f = new funcoes();
	            
	            int l= 0;
	           
	            while(sc.hasNextLine()) {
	            	
	            	linha[l]= sc.nextLine();
	            	
	            	linha[l] = linha[l].trim();
	            		
	            		if (linha[l].length() > 0 && !linha[l].endsWith("")){
	            			if(linha[l].startsWith("if") || linha[l].startsWith("for")){

	    					}else{
	    						throw new Erro(1, l,"");
	    					}
	    				}

	    				l++;
	                }
	            
	            //Adicionar interpretador na classe funcoes
	            
	        
	        }	  catch (IOException e) {      
}
}
}