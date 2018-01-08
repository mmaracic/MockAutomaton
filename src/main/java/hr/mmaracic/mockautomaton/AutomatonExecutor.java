/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mmaracic.mockautomaton;

import hr.mmaracic.mockautomaton.model.AutomatonSchema;
import hr.mmaracic.mockautomaton.model.Transition;
import hr.mmaracic.mockautomaton.model.internal.Automaton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Marijo
 */
public class AutomatonExecutor {
    
    private final Map<String, Automaton> automatons;
    
    private final static Logger logger = Logger.getLogger(AutomatonExecutor.class);

    public AutomatonExecutor(List<AutomatonSchema> automatonDefinitions){
        this.automatons = new HashMap<>();
        
        for(AutomatonSchema automatonDefinition: automatonDefinitions){
            Automaton automaton = new Automaton(automatonDefinition);
            this.automatons.put(automaton.getId(), automaton);
        }        
    }
    
    public void processEvent(Automaton automaton, Transition tr){
        try {
            throw new Exception("Not implemented yet!");
        } catch (Exception ex) {
            logger.log(Level.ERROR, null, ex);
        }
    }

    public void processEvent(String path, String body){
        try {
            throw new Exception("Not implemented yet!");
        } catch (Exception ex) {
            logger.log(Level.ERROR, null, ex);
        }
    }
}
