/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mmaracic.mockautomaton;

import org.eclipse.jetty.server.Server;

/**
 *
 * @author Marijo
 */
public class MockAutomaton extends Object{
    
    private Server server;
    
    public static void main(String [] args){
        
    }

    public MockAutomaton(int port) {
        this.server = new Server(port);
    }
    
    public void start() throws Exception{
        this.server.start();
    }
    
    public void stop() throws Exception{
        this.server.stop();
    }
    
    protected void finalize() throws Throwable {
        this.stop();
    }
}
