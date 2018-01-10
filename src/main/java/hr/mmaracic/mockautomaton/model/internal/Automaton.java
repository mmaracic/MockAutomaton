/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mmaracic.mockautomaton.model.internal;

import hr.mmaracic.mockautomaton.InputMatcher;
import hr.mmaracic.mockautomaton.OutputGenerator;
import hr.mmaracic.mockautomaton.model.AutomatonSchema;
import hr.mmaracic.mockautomaton.model.State;
import hr.mmaracic.mockautomaton.model.Transition;
import hr.mmaracic.mockautomaton.model.Variable;
import hr.mmaracic.mockautomaton.model.Variable.VariableType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.Getter;
import org.apache.log4j.Logger;

/**
 *
 * @author Marijo
 */
@Getter
public class Automaton extends AutomatonSchema{
    
    private final static Logger logger = Logger.getLogger(Automaton.class);

    private final List<Transition> transitionHistorys = new ArrayList<>();
    private final List<InputHistory> inputHistorys = new ArrayList<>();
    private Map<String, Object> internalVariables = new HashMap<>();
    private State currentState;
    
    private AutomatonExecutionState automatonExecutionState;
        
    public Automaton(AutomatonSchema automatonDefinition){
        UUID id = UUID.randomUUID();
        this.setId(id.toString());
        
        this.setName(automatonDefinition.getName());
        this.setPath(automatonDefinition.getPath());
        this.setStates(new ArrayList<State>(automatonDefinition.getStates()));
        
        //fill internal variables
        internalVariables = fillInternalVariables();
        
        //find initial state
        this.currentState = null;        
        currentState = findInitialState();
        
        //validate automaton structure
        checkStatesAndTransitions();
        
        automatonExecutionState = AutomatonExecutionState.WORKING;
    }
    
    public void reset(){
        transitionHistorys.clear();
        inputHistorys.clear();
        
        currentState = findInitialState();
        internalVariables = fillInternalVariables();        
    }
    
    public String executeTransitionForInput(String subpath, String input){
        inputHistorys.add(new InputHistory(subpath, input, null));
        for(Transition transition: this.currentState.getTransitions()){
            if(transition.getSubpath().compareTo(subpath)==0 && InputMatcher.compareInputs(input, transition.getInput())){
                String transitionOutput = OutputGenerator.generateOutput(inputHistorys, internalVariables, transition.getOutput().getTemplate());
                this.transitionHistorys.add(transition);
                String targetStateId = transition.getTarget();
                String stateOutput = changeState(targetStateId);
                return (transitionOutput != null || stateOutput != null) ? transitionOutput + stateOutput : null;
            }
        }
        String errorMessage = "Input data with subpath: "+subpath+" could not find transition";
        logger.info(errorMessage);
        return errorMessage;
    }
    
    public String executeTransitionForDelay(String transitionId){
        for(Transition transition: this.currentState.getTransitions()){
            if(transition.getId().compareTo(transitionId)==0){
                String transitionOutput = OutputGenerator.generateOutput(inputHistorys, internalVariables, transition.getOutput().getTemplate());
                this.transitionHistorys.add(transition);
                String targetStateId = transition.getTarget();
                String stateOutput = changeState(targetStateId);
                return (transitionOutput != null || stateOutput != null) ? transitionOutput + stateOutput : null;
            }
        }
        String errorMessage = "Transition with id: "+transitionId+" could not be found on the state with id: "+currentState.getId();
        logger.info(errorMessage);
        return errorMessage;        
    }
    
    public String changeState(String targetStateId){
        State newState = getStates().stream().filter(state -> state.getId().compareToIgnoreCase(targetStateId)==0)
                .collect(Collectors.toList()).get(0);
        currentState = newState;
        if (currentState.getEnding()){
            automatonExecutionState = AutomatonExecutionState.STOPPED;
        }
        String stateOutput = null;
        return stateOutput;
    }
    
    private List<Transition> checkForDelayTransitions(){
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
    
    private State findInitialState(){
        List<State> startingStates = getStates().stream().filter(state -> {
            return state.getStarting();
        }).collect(Collectors.toList());
        
        if (startingStates.size() != 1){
            String errorMsg = "Automaton "+this.getName()+" has "+startingStates.size()+" starting states.";
            logger.error(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        } else {
            return startingStates.get(0);
        }        
    }
    
    private Map<String, Object> fillInternalVariables(){
        HashMap<String, Object> variableMap = new HashMap();
        List<Variable> variables = this.getVariables();
        for(Variable variable: variables){
            String name = variable.getName();
            VariableType t = variable.getVariableType();
            Object value = null;
            switch(t){
                case NUMBER:
                    value = ((Number) variable.getValue()).longValue(); break;
                case STRING:
                    value = String.valueOf(variable.getValue()); break;
                default:
                    throw new IllegalArgumentException("Variable: "+name+" has an unallowed type: "+t.toString());
            }
            variableMap.put(name, value);
        }
        return variableMap;
    }
    
    private void checkStatesAndTransitions(){
        Set<String> stateIds = new HashSet<>();
        //if there are states with duplicate ids throw exception
        getStates().stream().forEach(state -> {if (!stateIds.add(state.getId())) throw new IllegalArgumentException("State with duplicate id: "+state.getId());});
        
        //check if all transitions have valid target state ids
        for(State s:getStates()){
            s.getTransitions().stream().forEach(transition -> {
                if (!stateIds.contains(transition.getId())){
                    throw new IllegalArgumentException("Transition "+transition.getId()+"of state with id "+s.getId()+" has invalid target state id "+transition.getTarget());
                }
            });
        }
    }
}
