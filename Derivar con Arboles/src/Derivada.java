
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tadeo
 */



public class Derivada {
    


            // comprueba si un caracter es un operador
        public static boolean isOperator(char c) 
        {
		return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
	}
    
    	public static void postorder(Nodo root)
        {
            
        }
        public static void inorder(Nodo root)
        {
        
        }
        
        
        
        // le mete a la cadena *1 y ^1 si es necesario en x y en seno y cos
        public static String ordenar(String root)
        {
            String ordenada="";
            for(int i=0; i<root.length() ; i++)
            {
                if(root.charAt(i)=='x')
                {
                    if(i==0)
                       ordenada= ordenada +  "1*" + root.charAt(i);
                    else
                    {
                        if(esnumero(root.charAt(i-1)))
                            ordenada= ordenada +  "*" + root.charAt(i);
                        else
                            {
                             if(esnumero(root.charAt(i-2)) && root.charAt(i-1)=='*')
                                 ordenada= ordenada + root.charAt(i);
                             else 
                                ordenada= ordenada +  "1*" + root.charAt(i);
                             }
                    }
                int j= i+1;
                if(j>=root.length())
                    ordenada= ordenada + "^1";
                else
                {
                    if(root.charAt(j)!='^')
                        ordenada= ordenada + "^1";
                }
                    
                    
                }
                  else
                    if((root.charAt(i)=='c' && root.charAt(i+1)=='o'&& root.charAt(i+2)=='s')|| (root.charAt(i)=='s' && root.charAt(i+1)=='i'&& root.charAt(i+2)=='n'))
                    { 
                        if(i==0)
                        ordenada = ordenada +  "1*";
                        else
                    {
                        if(esnumero(root.charAt(i-1)))
                            ordenada= ordenada +  "*";
                        else
                            {
                             if(isOperator( root.charAt(i-1)))
                                 ordenada= ordenada +  "1*" ;
                             if(!esnumero(root.charAt(i-2)) && root.charAt(i-1)!='*')
                                ordenada= ordenada +  "1*" ;
                             }
                    }
                        while(root.charAt(i)!=')'){
                        ordenada = ordenada + root.charAt(i);    
                        i++;
                        }
                        ordenada = ordenada + root.charAt(i);
                    }
                    else
                     ordenada = ordenada + root.charAt(i);
            }
            
        
            return ordenada;
        }
        
        // comprueba si una cadena tiene sus parentesis cerrados
        // https://es.stackoverflow.com/questions/105607/c%C3%B3mo-equilibrar-los-parentesis
        public static boolean procesarCadena(String cadena) 
        {
       
            Stack<Character> stackLetras = new Stack<Character>();

            char arrayDeLetras[] = cadena.toCharArray();
            int i;
            for (i = 0; i < arrayDeLetras.length; i++) {
              if (arrayDeLetras[i] == '(') {
                stackLetras.push(arrayDeLetras[i]);
              }else if (arrayDeLetras[i] == ')') {
                if (!stackLetras.empty() && stackLetras.peek() != ')') {
                  stackLetras.pop();
                }else{
                  stackLetras.push(arrayDeLetras[i]);
                }
              }
            }
          return stackLetras.empty();
        } 
        
        // comprueba si un caracter es un numero
        public static boolean esnumero(char c)
        { String s="" + c ;
                try {
		Integer.parseInt(s);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
                
        
        }
        

        
        
               
         
                

        
        
        public static void main(String[] args)
	{
            String postfix = "5+x+(x^5)+(6)+(x*x)";
            System.out.println("Cadena sin ordenar");
            System.out.println(postfix);
            if(procesarCadena(postfix))
            {
            System.out.println("Cadena ordenada");
            System.out.println(ordenar(postfix));
            
            }
            else
             System.out.println("Cadena tiene un parentesis sin cerrar");
            
            
            

            
            
            
            //
            //
            //
            //
            

        }
        
}
