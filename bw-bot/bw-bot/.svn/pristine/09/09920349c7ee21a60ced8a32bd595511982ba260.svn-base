/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb.queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mb.exception.BWException;
import mb.exception.NoMoneyException;
import mb.exception.NoQuestException;
import mb.queue.QueueElement;

/**
 *
 * @author xxx
 */
public class Queue {
    
    private java.util.Queue<QueueElement> q = new LinkedList<QueueElement>();
    
    private long currentTime;
    private boolean queueExecuted;
    private Runnable head;
   
    public Queue()
    {
        
    }
    
    public long getTime(){
        return currentTime;
    }
    
    public boolean isExecuted(){
        return queueExecuted;
    }
    
    public QueueElement[] toList()
    {   
       Iterator<QueueElement> it=  q.iterator();
       int i = 0 ; 
       QueueElement[] list = new QueueElement[q.size()];
       while( it.hasNext()){
           list[i] = it.next();
           i++;
       }
       System.out.println("list size  : " + list.length);
       return list;
    }
    
    public void add(QueueElement e)
    {
        q.add(e);
    }
    
    
    
    public boolean execute() throws BWException 
    {
        QueueElement el;
        long time=0;
        System.out.println("queue size: " + q.size());
 
          System.out.println(" start ");
          
        while((el=q.peek())!=null)
        {
            try {
                
                el.run();    
                currentTime = el.getTime();
                head.run();
                Thread.sleep(currentTime);
                 System.out.println(" quest over ");
                q.poll();
            }catch (NoMoneyException ex) {

                Logger.getLogger(Queue.class.getName()).log(Level.SEVERE, null, ex);
            }catch (InterruptedException ex) {
                    Logger.getLogger(Queue.class.getName()).log(Level.SEVERE, null, ex);
           }  
        }     
        
        return true;
    }
    
 
    
    public void setHeader(Runnable r){
        this.head=r;
    }
    
}
