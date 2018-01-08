/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mmaracic.mockautomaton.model.internal;

import hr.mmaracic.mockautomaton.model.AutomatonSchema;
import hr.mmaracic.mockautomaton.model.State;
import hr.mmaracic.mockautomaton.model.Transition;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

/**
 *
 * @author Marijo
 */
@Getter
public class Automaton extends AutomatonSchema{
    
    private final static Logger logger = Logger.getLogger(Automaton.class);

    private List<Transition> history;
    private State currentState;
    
    public Automaton(AutomatonSchema automatonDefinition){
        UUID id = UUID.randomUUID();
        this.setId(id.toString());
        
        this.setName(automatonDefinition.getName());
        this.setPath(automatonDefinition.getPath());
        this.setStates(new ArrayList<State>(automatonDefinition.getStates()));
        
        this.currentState = null;
        this.history = new ArrayList<>();
        
        List<State> states = this.getStates();

        //find initial state
        List<State> startingStates = states.stream().filter(state -> {
            return state.getStarting();

        }).collect(Collectors.toList());
        if (startingStates.size() != 1){
            logger.error("Automaton "+this.getName()+" has "+startingStates.size()+" starting states.");
        } else {
            currentState = startingStates.get(0);
        }
    }
    
    Transition changeState(String subpath, Object input){
        Transition transition = null;
        
        if (transition != null){
            this.history.add(transition);
        }
        return transition;
    }
    
    List<Transition> checkForDelayTransitions(){
        List<Transition> transitions = this.currentState.getTransitions();
        List<Transition> delayTransitions = transitions.stream().filter(transition -> {
            if (transition.getDelay() != null && transition.getDelay()>0){
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());
        return delayTransitions;
    }
}
