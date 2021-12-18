package avl;
import java.util.ArrayList;
import java.util.Scanner;

public class Avl<T> {

    public static int mark;
    public static String ans="";
    
    public static void main(String[] args) {
            System.out.println("                        ******************************");
            System.out.println("                               W E L C O M E:");
            System.out.println("                        ******************************");
        Scanner input = new Scanner(System.in);
        //Scanner gN = new Scanner(System.in);
        Bst<String>  b_s_t = null;
        Node node = new Node(null);
        boolean setRoot = false;
        while(true){
           
            System.out.println("---***please select the appropriate option:***---\n");
            System.out.println("  ********************************************************");
            System.out.println("  1=Add:     2=Mark:     3=remove:     4=Clean  "/*   5=Exit"*/);
            System.out.println("  ********************************************************");
            ans=input.next();
        while((!ans.equals("1") && !ans.equals("2") && !ans.equals("3") && !ans.equals("4") && !ans.equals("5"))){  
            System.out.println("---***please select the appropriate option:***---\n");
            System.out.println("  *******************************************************");
            System.out.println("  1=Add:     2=Mark:     3=remove:     4=Clean  "/*   5=Exit"*/);
            System.out.println("  *******************************************************");
            ans=input.next();
            }
        while (true){
            if(ans.equals("1")){
                System.out.println("   ******");
                System.out.println("   1=Add:");
                System.out.println("   ******\n ");
                System.out.println(" Enter the key: ");
                node.setKey(input.nextInt());
                node.setData(input.next());
                if(!setRoot){
                b_s_t = new Bst<String>(node.getKey(),node.getData().toString());
                setRoot = true;
                }
                
                else{
                    
                    
                try{b_s_t.Put(b_s_t.getRoot(),node.getKey(),node.getData().toString());    
                }catch(Exception e){}
                
            
            }
                b_s_t.Print_PreOrder();
                break;
            }
            else if(ans.equals("2")){
                System.out.println("   ******");
                System.out.println("   1=Mark:");
                System.out.println("   ******\n ");
                System.out.println(" Enter the key: ");
                node.setKey(input.nextInt());
                b_s_t.mark(node.getKey());    
                break;
            }
            else if(ans.equals("3")){
                System.out.println("\nRemov:");
                 System.out.println("enter the key");
                System.out.println("   ********");
                System.out.println("   1=Remove:");
                System.out.println("   ********\n ");
                System.out.println(" Enter the key: ");
                node.setKey(input.nextInt());
                node = b_s_t.search(b_s_t.getRoot(),node.getKey());
                b_s_t.remove(node); 
                b_s_t.Print_PreOrder();
                break;  
            }
            
            else if(ans.equals("4")){
                System.out.println("   ********");
                System.out.println("   1=Clean:");
                System.out.println("   ********\n ");
                b_s_t.clean();   
                System.out.println();  
                b_s_t.Print_PreOrder();
                break;
            }
        }
        }
    }
}