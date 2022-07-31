
package com.mycompany.doublelinkedlist;

public class linkedlist {
//data feilds 
    node head;
    node tail;
    int counter;
    //dufult 
    public linkedlist(){
        head=tail=null;
        counter++;
    }
//method cheak to empty
    public boolean isEmpty(){
        if (head==null) {
          return true;
        }else {
          return false;
        }
    }
    
//method insert to head 
    public void InsertToHead(int value){
          if (isEmpty()) {
              head=new node();
              head.data=value;
              head.next=null;
              head.prev=null;
              tail=head;
              counter++;
          }
          else{
              node nn=new node();
              nn.data=value;
              nn.next=head;
              head.prev=nn;
              nn.prev=null;
              head=nn;
              counter++;
          }
      }
//method insert to tail
    public void InsertToTail(int value){
        if (isEmpty()) {
            InsertToHead(counter);
        }
        else{
            node nn=new node();
            nn.data=value;
            nn.next=null;
            nn.prev=tail;
            tail.next=nn;
            tail=tail.next;
            counter++;                                                                                  
        }
    }
//method insert to pos
    public void insertToPos(int value , int pos){
        if (pos<1 || pos>counter) {
            System.out.println("error");
        } else if(pos==1){
            InsertToHead(value);
        }else if(pos==counter){
            InsertToTail(value);
        }else{
            node t=head;
            for (int i = 1; i < pos-1; i++) {
                t=t.next;
            }
            node nn=new node();
            nn.data=value;
            nn.next=t.next;
            t.next.prev=nn;
            nn.prev=t;
            t.next=nn;
            counter++;
        }
    }
    
//method delete head
    public void deleteFromHead(){
        if(head==tail){
            head=tail=null;
            counter--;
        }else{
            head=head.next;
            head.prev=null;
            counter--;
        }
    }
    
//method print all
   public void PrintAll(){
        node n=head;
        while (n!=null) {            
            System.out.println(n.data);
            n=n.next;
        }
    }
}
