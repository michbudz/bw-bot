/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb.queue;

import mb.RunActionInterface;
import mb.exception.BWException;

/**
 *
 * @author xxx
 */
public class QueueElement {
    

    public long sleep;
    private String name;
    public RunActionInterface object;
    
    public QueueElement(RunActionInterface o ){
        object=o;
    }
    
    public long run() throws BWException{
        object.run();
       return  object.getTime(); 
    }
    
    public String toString()
    {
        return  object.getName();
        
    }
    public long getTime(){
        return object.getTime();
    }
    
}
