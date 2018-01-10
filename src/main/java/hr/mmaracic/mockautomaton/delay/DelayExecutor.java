/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mmaracic.mockautomaton.delay;

import java.util.List;
import java.util.Map;

/**
 *
 * @author mmaracic
 */
public class DelayExecutor implements Runnable{
    
    private List<DelayExecutorSubscriber> subscribers;

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void addDelay(long delayMs, Map<String, Object> delayData){
        
    }
    
    public void subscribe(DelayExecutorSubscriber subscriber){
        this.subscribers.add(subscriber);
    }
    
    private void notifySubscribers(){
        for(DelayExecutorSubscriber subscriber: subscribers){
            
        }
    }
}
