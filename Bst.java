
package avl;
import java.util.ArrayList;
import java.util.Queue;

        public class Bst<A> {
            
                public static ArrayList<Node> clean = new ArrayList<Node>();
                public Queue queue ;  
 
                private Node<A> root = null;
                private Node<A> fentry = null;
                private Node<A> lentry = null;
                private int size = 0; 
                private Node<A> ch_avl = null;
                private Node<A> ch_splay = null;
 
                private Node<A> LastEntry = null;
                private Node<A> FirstEntry = null;


 
 
            public Bst(int key, A data) {
                 this.root=new Node(key, data, null);  
     
    }
 
    
    
            public Node<A> getRoot() {
                return root;
        
    }
  
            public void setRoot(Node<A> Root) {
                this.root = Root;
            
    }

            public Node<A> getLastEntry() {
                return LastEntry;
        
    }

            public void setLastEntry(Node<A> LastEntry) {
                this.LastEntry = LastEntry;
        
    }

            public Node<A> getFirstEntry() {
                return FirstEntry;
        
    }

            public void setFirstEntry(Node<A> FirstEntry) {
                this.FirstEntry = FirstEntry;
        
    }

            public int getSize() {
                return size;
        
    }

            public void setSize(int size) {
                this.size = size;
        
    }

            public Node<A> getCheck_avl() {
                return ch_avl;
        
    }

            public void setCheck_avl(Node<A> check_avl) {
                this.ch_avl = check_avl;
        
    }


            public Node<A> getCheck_splay() {
                return ch_splay;
        
    }

            public void setCheck_splay(Node<A> check_splay) {
                this.ch_splay = check_splay;
        
    }

            public ArrayList<Node> getClean() {
                return clean;
        
    }
            
            public boolean root(Node<A> v){
                return (v.getParent()== null);  
    }
            public boolean internal(Node<A> v){
                return (!(leaf(v)));  
    }    
            
            public void Put(Node v,int key, A data){
                Node<A> temp;
                //if(p.getKey() == key)
                //p.setData(data);

            if(v.getKey() > key){
                    
                if(v.getLeft_child() == null){ 
                    v.setLeft_child(new Node(key, data, v));
                    setSize(getSize()+1);
                    
   }
                
                    Put(v.getLeft_child(), key, data);
                    
                    
}
    
                
        else if(v.getKey() < key){
                
                if(v.getRight_child() == null){
                    
                v.setRight_child(new Node(key, data, v));
                setSize(getSize()+1);  
                
  }
                Put(v.getRight_child(), key, data);
                
}

}
 
 
 

            private void pre_order(Node<A> v){
                
            if( v != null){    
                
                    System.out.println("key:" + v.getKey()+ " --> " + "data:" + v.getData());  
                    
                    pre_order(v.getLeft_child());
                    pre_order(v.getRight_child());
                    
}
}
       

                public void Print_PreOrder(){
    
                    pre_order(getRoot());
    
    }


                public void mark(int key){
            
            
                    Node temp=search (getRoot(), key) ;
            
            
                    clean.add (temp) ;
                
}
                
                
                public Node<A> search(Node<A> v, int key){
                
                    if(leaf(v))
                      
                    return v;
                  
                    if(v.getKey() == key)
                      
                    return v;
                  
                    if(v.getKey() < key){
                      
                    if(v.getRight_child() == null){
                      
                    return v;  
    } 
                  
        else {
                      
                  return search(v.getRight_child(), key);
                  
    }
                  
    }
                  
                  
        else{
                      
                    if(v.getLeft_child() == null){
                     
                        return v;
                      
    }
                 
        else{
                     
                        return search(v.getLeft_child(), key);
                 
    }
                 
}
                  
                  
}
                
                public Node<A> remove(Node<A> v){
                    
                        if (v == null){
                        return null;
                        
                        }
                        else if(height (v.getLeft_child())>height(v.getRight_child())){
                            
                        setCheck_avl(v);
                        setCheck_splay(v);   
                        
                        return(remove_lr(v.getKey()));
}
       else{
                            
                        setCheck_avl(v);
                        setCheck_splay(v);
                        
                        return(remove_rl(v.getKey()));  
                        
                        
}
}
                
                
            public int height(Node<A> v){
                        if(v == null) {
                        return 0;   
                        }
                        
                        else if(leaf(v)) {
                        return 0;
                        }
                        
                else if (v.getRight_child()==null) {
                            
                        return 1+height(v.getLeft_child());
                        
                        }
                        
                else if (v.getLeft_child()==null) {
                            
                        return 1+height(v.getRight_child());
                        
                        }
                        
        else
                        return 1+maximum(height(v.getLeft_child()),height(v.getRight_child())); 
                        
//////////////////
}
                    public int maximum(int first,int last){
                            if(first>last) {
                                
                            return first;
                            }
                    else 
                                
                    return last;    
    
                    }
                    
                    
                    private Node<A> remove_rl(int key){
                        
                            Node<A> t = null;
                            Node<A> v = search(getRoot(), key);
                            Node<A> rl=null;
                            
            if(v.getKey() == key ){ 
                            
                        if(leaf(v)){
                            
                        remove_leaf(v);
                    }
            else{
                            
                        if(v.getRight_child() !=null){
                            
                        rl=RightSubTree_LeftChild(v.getRight_child());
                        
                        v.setData(rl.getData());
                        v.setKey(rl.getKey());
                        
                    if(leaf(rl)){    
                        
                        remove_leaf(rl);
                
                        }
                        
            else{
                        
                        t=rl.getRight_child();
                        
                        rl.setData(t.getData());
                        rl.setKey(t.getKey()); 
                        rl.setRight_child(null);
                        
                        
                                return null;
        }
                        
}

            else{
                            
                    sout("the node doesn't have Right child");
                   
                                return null;  
                                
      }    
    
}
}

            else{
    
                    sout("Error:A node with this key does not exist");
                    
                                return null;    

            }

        return null;
        
}
                    
                    
                    private Node<A> remove_leaf (Node<A> v){
                        
                        Node<A> temp=v.getParent();
                        
                 if(leaf(v)){
                     
                        if(temp.getRight_child() == v) {
                        temp.setRight_child(null);
                        
                        }
        else
                        temp.setLeft_child(null);
      }
                 
             return v;
             
    }
                    public void clean(){
    
    
                   for(int i =0;i<clean.size();i++){
    
                   remove(clean.get(i));
    
    
        }    

            clean.clear();

            
    }





            public boolean leaf(Node<A> v){  
                
                
                    return ((v.getLeft_child() == null) && 
                            
                            (v.getRight_child() == null));  
                    
}

            
           private void balance(Node<A> v){
               
                    Node<A> x=v;
                    Node<A> y=x.getParent();
                    Node<A> z=y.getParent();
                    
            if(z == null){
                
                x.setParent(null);
                setRoot(x);
                
    }
            
        else
                
                
            relink(z, x, (z.getLeft_child() == y));

            if( x == y.getLeft_child()){
                
                
                relink(y, x.getRight_child(), true);
                relink(x, y, false);    
        }

        else{
                relink(y, x.getLeft_child(), false);
                relink(x, y, true);
                
                
        }

            
        }
                 private void post_order(Node<A> v){
                     
                    if(v != null){
                        
                        post_order(v.getLeft_child());
                        post_order(v.getRight_child());
                        
                        sout (v.getKey() + "-->" 
                                + v.getData() + "     ");
                        
} 
}

                public void Print_post_order(){
                    
                        post_order(getRoot());
    }



                public void restruct_bst(Node<A> v){
                    
                    if(height(v.getRight_child()) - height(v.getLeft_child()) > 1 ||
                             height(v.getLeft_child()) - height(v.getRight_child()) > 1){
                        
                    Tri_Node_ResTruct(v);
                    
      
                    
                    }  
                    
}

                    public void Print_one(){
                        
                        Node<A> P = null;
                        this.queue.add(getRoot());
                        
                while(! queue.isEmpty()){
                    
                    
                        P=(Node<A>) queue.poll();
                        
                        sout(P.getKey()+ "-->" +P.getData());
                        
                        if(P.getLeft_child() != null){
                            
                        queue.add(P.getLeft_child());
                        }
                        
            else if(P.getRight_child() != null) {
                        queue.add(P.getRight_child());
            }
 }   
}

                    private Node<A> Tri_Node_ResTruct(Node<A> v){
                        
                        Node<A> X=v;
                        Node<A> Y=X.getParent();
                        Node<A> Z=Y.getParent();
                        
                if((X == Y.getRight_child()) == (Y == Z.getRight_child())){
                    
                  balance(Y);
        return Y;
}
        else{
                 balance(X);
                 balance(X);
                 
        return X;
}
}

                    public void avl_put(Node<A> v, int key, A data){
                    
                        Put(v, key, data);
                         restruct_bst(v);
}

                    
                     private Node<A> RightSubTree_LeftChild(Node<A> v){
    
                if(leaf(v)){
                    
                            return v;
                            
                }

                 if(v.getLeft_child()== null)  {
                     
                
                    return v;  
                    
                 }
                 
            return RightSubTree_LeftChild(v.getLeft_child());

}

                    private Node<A> LeftSubTree_RightChild(Node<A> v){
    
            if(leaf(v)) {
                
                    return v;
            }

            if(v.getRight_child()== null) { 
                
                    return v;  
            
            }

                return LeftSubTree_RightChild(v.getRight_child());

}

   
                      private Node<A>remove_lr(int key){
                          
                          
                            Node<A> temp = null;
                            Node<A> v = search(getRoot(), key);
                            Node<A> Lr=null;
                            
                if(v.getKey() == key ){ 
                    
                    if(leaf(v)){
                        
                        remove_leaf(v);
    }
        else{
                        
                        
                    if(v.getLeft_child() !=null){
                        
                            Lr=LeftSubTree_RightChild(v.getLeft_child());
                            v.setData(Lr.getData());
                            v.setKey(Lr.getKey());
                            
                    if(leaf(Lr)){    
                        
                            remove_leaf(Lr);
    }
            else{
                        
                    temp=Lr.getLeft_child();
                    Lr.setData(temp.getData());
                    Lr.setKey(temp.getKey()); 
                    Lr.setRight_child(null);
                    
                    
                return null;

                    }
}

        else{
                        
                    sout("the node doesn't have left child");
                    
                return null;    
}    
    
}

}

                else{
    
                    sout("Error:A node with this key does not exist");
                    
                    return null;    
}

                return null;
}
 
                private void relink(Node<A> p, Node<A> c,boolean makeleft){
    
                if(makeleft){
                c.setLeft_child(p);
                
                }
        
                else
                    
                c.setRight_child(p);

}

    
        
//////////////
        
                   private static void sout(String msg) {
                     System.out.println(msg);
                    
                   
                   }


    
    
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   
    
    
       
}
