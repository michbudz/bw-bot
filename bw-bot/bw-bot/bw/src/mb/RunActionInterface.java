/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import mb.exception.BWException;

/**
 *
 * @author xxx
 */
public interface RunActionInterface {
    
    public void run()throws BWException;
    public long getTime();
    public String getName();
}
