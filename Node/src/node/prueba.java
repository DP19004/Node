/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package node;
import java.util.Stack;

/**
 *
 * @author Tadeo
 */
public class prueba {
  // Function to check if a given token is an operator
	public static boolean isOperator(char c) {
		return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
	}

        public static boolean isOperator(Node root) {
            
            char c = root.data;
		return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
	}
        
        
	// Print the postfix expression for an expression tree
	public static void postorder(Node root)
	{
		if (root == null) {
			return;
		}
                System.out.print(root.data);
                postorder(root.left);
		postorder(root.right);
                
		
	}

	// Print the infix expression for an expression tree
	public static void inorder(Node root)
	{
		if (root == null) {
			return;
		}

		// if the current token is an operator, print open parenthesis
		if (isOperator(root.data)) {
			System.out.print("(");
		}
                
		inorder(root.left);
		System.out.print(root.data);
		inorder(root.right);

		// if the current token is an operator, print close parenthesis
		if (isOperator(root.data)) {
			System.out.print(")");
		}
	}

	// Function to construct an expression tree from the given postfix expression
	public static Node construct(String postfix)
	{
		// base case
		if (postfix == null || postfix.length() == 0) {
			return null;
		}

		// create an empty stack to store tree pointers
		Stack<Node> s = new Stack<>();

		// traverse the postfix expression
		for (char c: postfix.toCharArray())
		{
			// if the current token is an operator
			if (isOperator(c))
			{
				// pop two nodes `x` and `y` from the stack
				Node x = s.pop();
				Node y = s.pop();

				// construct a new binary tree whose root is the operator and whose
				// left and right children point to `y` and `x`, respectively
				Node node = new Node(c, y, x);

				// push the current node into the stack
				s.add(node);
			}
			// if the current token is an operand, create a new binary tree node
			// whose root is the operand and push it into the stack
			else {
				s.add(new Node(c));
			}
		}

		// a pointer to the root of the expression tree remains on the stack
		return s.peek();
	}
        
        //retorna un node
        public static Node Derivada(Node roo)
        {
            Node root;
            if (roo == null) 
                {
	         return roo;
		}
            
            
               switch (roo.data) 
               {

                case '+':
                    if (!isOperator(roo.left) && !Verificar(roo.left))
                    {
                        roo.left = null;
                    }
                    if (!isOperator(roo.right) && !Verificar(roo.right))
                        {
                        roo.right = null;
                        }
                    
  
                    if(roo.left == null && roo.right== null)
                        roo.data = '0';
                    
                    if((roo.left != null && roo.right== null )|| (roo.right!= null && roo.left== null))
                        roo.data = ' ';
                    
                    
                    Derivada(roo.left);
                    Derivada(roo.right);
                    break;
                    
                case '^':
                    if(Verificar(roo.left))
                    {
                     roo.right=Disminuir(roo.right);
                      root = roo;
                     break;
                    }
                    if(Verificar(roo.right))
                    {
                     roo.left=Disminuir(roo.left);
                      root = roo;

                     break;
                    }
                    break;
                    
                    
                case '-':
                    if (!isOperator(roo.left) && !Verificar(roo.left))
                    {
                        roo.left = null;
                    }
                    if (!isOperator(roo.right) && !Verificar(roo.right))
                        {
                        roo.right = null;
                        }
                    
                    
                    if(roo.left == null && roo.right== null)
                        roo.data = '0';
                    
                    if((roo.left != null && roo.right== null )|| (roo.right!= null && roo.left== null))
                        roo.data = ' ';
                    
                    
                    Derivada(roo.left);
                    Derivada(roo.right);
                    break;
                
                    //  tiene errores todavia
               case '*':
                  if (!isOperator(roo.right) && !Verificar(roo.right) || !isOperator(roo.left) && !Verificar(roo.left))
                        {
                            if (!isOperator(roo.right) && !Verificar(roo.right) && !isOperator(roo.left) && !Verificar(roo.left))
                            {
                                roo.data='0';
                                roo.right = null;
                                roo.left=null;
                                break;
                            }                 

                            if (!isOperator(roo.right) && Verificar(roo.left))
                            {
                                roo.left=Derivada(roo.left);
                                break;
                            }
                            if (!isOperator(roo.right) && Verificar(roo.right))
                            {
                                
                            roo.right=Derivada(roo.right);
                            break;
                            }
                            
                        }
                  else
                  {
                    roo.data='+';
                  root = roo;
                  Node x = new Node('*');
                  x.left=Derivada(root.left);
                  x.right= root.right;
                  Node y = new Node('*', roo.left, Derivada(roo.right));
                  y.left=root.left;
                   roo.left=x;
                   roo.right=y;
                    root = roo; 
                    break;
                  } 
                   
                    
               case '/':
                   
                   
                    
                break;
                
                case 'x':
                    roo.data='1';
                break;
                // default se encarga de los numeros si no me equivoco
               default:
                   
                   if(roo.data=='*')
                   {
                  System.out.print("\n Aun no podemos derivar multiplicaciones \n");
                   roo.data = ' ';
                   roo.right = null;
                   roo.left = null;
                   }
                   else
                       if(roo.data=='/')
                           {
                  System.out.print("\n Aun no podemos derivar divisiones  \n");
                   roo.data = ' ';
                   roo.right = null;
                   roo.left = null;
                   }
                   else
                  roo.data = '0';
                   break;
               }
               root=roo;
            
            
            return root;
            
        
        }
                        public static Node Disminuir(Node root)
                        {
                            int a=Character.getNumericValue(root.data);
                            a=a-1;
                            root.data=(char)('0' + a);
                            
                         return root ;
                        }

        
                public static boolean Verificar(Node root)
                {
                return root.data=='x';
                }

	public static void main(String[] args)
	{
		String postfix = "x5^x5^*";
		Node root = construct(postfix);

		System.out.print("Postfix Expression: ");
		postorder(root);
                System.out.print("\n"); 
                
		System.out.print("\nInfix Expression: ");
		inorder(root);
                
                System.out.print("\n");
                System.out.print("\nDerivada: ");
                
		inorder(Derivada(root)); 
                System.out.print("\n");
               

	}  
}

