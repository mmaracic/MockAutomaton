/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mmaracic.mockautomaton;

import hr.mmaracic.mockautomaton.model.AutomatonSchema;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jetty.server.Server;

/**
 *
 * @author Marijo
 */
public class MockAutomaton{
    static private List<AutomatonParameterDescriptor> parameterDescriptorsList;
            
    private final Server server;
    private final AutomatonSchema automaton;
    
    public MockAutomaton(int port, AutomatonSchema automaton) {
        this.automaton = automaton;
        
        this.server = new Server(port);
    }
    
    public void start() throws Exception{
        this.server.start();
    }
    
    public void stop() throws Exception{
        this.server.stop();
    }
    
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        this.stop();
    }
    
    public static void main(String [] args){
        if (args.length<=0){
            throw new IllegalArgumentException("Argument -path is comuplsory. Argument -help gives list of arguments");
        }
        
        
        
    }
    
    public static List<AutomatonParameter> parseArguments(String[] arguments){
        List<AutomatonParameter> parameters = new ArrayList<>();
        
        boolean stateParameter = true;
        AutomatonParameterDescriptor descriptor = null;
        for(String argument: arguments){
            if (stateParameter){
                String name = null;
                if (argument.startsWith("-")){
                    name = argument.substring(1);
                } else if (argument.startsWith("--")){
                    name = argument.substring(2);
                } else {
                    throw new IllegalArgumentException("Argument "+argument+" should be a parameter name and start with a dash");
                }
                int index = parameterDescriptorsList.indexOf(name);
                if (index<0){
                    throw new IllegalArgumentException("Illegal argument name: "+name+". Parameters are: "+getHelp());
                } else {
                    descriptor = parameterDescriptorsList.get(index);
                    if (descriptor.isHasValue()){
                        stateParameter = false;
                    }
                }
            } else {
                AutomatonParameter parameter = new AutomatonParameter(descriptor, argument);
                parameters.add(parameter);
                stateParameter = true;
            }
        }
        return parameters;
    }
    
    public static String getHelp(){
        return parameterDescriptorsList.toString();
    }
}
