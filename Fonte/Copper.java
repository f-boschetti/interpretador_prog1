import java.util.Scanner;
import java.io.*;

class Copper {

	public static void main(String[] args) throws Exception, Erro{
		 
		 File file;
		 Scanner sc;
		 String id_line[] = new String[1500];

		 
	        try {
	        	file = new File(args[0]);
	            sc = new Scanner(file);          
	   		 	Funcoes func= new Funcoes();
	            int l= 0;
	           
	            while(sc.hasNextLine()) {
	            	
	            	id_line[l]= sc.nextLine();
	            	
	            	id_line[l] = id_line[l].trim();
	            		
	            		if (id_line[l].length() > 0 && !id_line[l].endsWith("")){
	            			if(id_line[l].startsWith("if") || id_line[l].startsWith("for")){

	    					}else{
	    						throw new Erro(1, l,"");
	    					}
	    				}

	    				l++;
	                }
	            
	            func.interpreta(id_line);
	            
	        
	        	}	  catch (IOException e) {      
	        	
	        }

		}
	}

//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0 *tentar arrumar (ou achar outra maneira)