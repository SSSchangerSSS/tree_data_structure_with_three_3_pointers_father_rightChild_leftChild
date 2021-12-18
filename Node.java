
package avl;
public class Node  <A> {
    
        public Node<A> parent=null;
        public int key;
        public Node<A> Right_child=null;
        public Node<A> Left_child=null;
        public A data=null;  

    
    public Node(int key,A data,Node<A> Parent){
      
        this.parent = Parent;
        this.key = key;
        this.Right_child = null;
        this.Left_child = null;
        this.data = data;
  
    }


    public Node<A> getParent() {
        return parent;
    }

    
    public int getKey() {
        return key;
    }
    
    
    public Node<A> getRight_child() {
        return Right_child;
    }
    
    
    public Node<A> getLeft_child() {
        return Left_child;
    }
    
    
    public A getData() {
        return data;
    }

    
    public void setParent(Node<A> parent) {
        this.parent = parent;
    }

   
    public void setKey(int key) {
        this.key = key;
    }
    

    public void setRight_child(Node<A> Right_child) {
        this.Right_child = Right_child;
    }
    
    
    public void setLeft_child(Node<A> Left_child) {
        this.Left_child = Left_child;
    }


    public void setData(A data) {
        this.data = data;
    }   
    
    
    
    public Node(Node <A> parent){
        
        this.parent=parent;    
    }
    
    public String toString(){
        return "AVL: ";
    }
}



  
  

    
       
