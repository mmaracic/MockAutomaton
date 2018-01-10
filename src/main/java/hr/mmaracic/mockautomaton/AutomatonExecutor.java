/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mmaracic.mockautomaton;

import hr.mmaracic.mockautomaton.model.AutomatonSchema;
import hr.mmaracic.mockautomaton.model.internal.Automaton;
import hr.mmaracic.mockautomaton.model.internal.AutomatonExecutionState;
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
    
    public String processDataEvent(String automatonId, String transitionId){
        for(Automaton automaton: automatons.values()){
            if (automaton.getAutomatonExecutionState() == AutomatonExecutionState.STOPPED) continue;
            if (automaton.getId().compareTo(automatonId) == 0){
                return automaton.executeTransitionForDelay(transitionId);
            }           
        }
        String errMessage = "Delay defined by automatonId: "+automatonId+" and transitionId: "+transitionId+" was not processed by existing automatons!";
        logger.log(Level.ERROR, errMessage);
        return errMessage;
    }

    public String processDelayEvent(String path, String body){
        for(Automaton automaton: automatons.values()){
            if (automaton.getAutomatonExecutionState() == AutomatonExecutionState.STOPPED) continue;
            String basePath = automaton.getPath();
            if (path.startsWith(path)){
                String subpath = path.substring(basePath.length());
                if (subpath.startsWith("/")){
                    subpath = subpath.substring(1);
                }
                return automaton.executeTransitionForInput(subpath, body);
            }
        }
        String errMessage = "Input event defined by path: "+path+" was not processed by existing automatons!";
        logger.log(Level.ERROR, errMessage);
        return errMessage;
    }
}
