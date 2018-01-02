/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mmaracic.mockautomaton;

import lombok.Getter;

/**
 *
 * @author Marijo
 */
@Getter
public class AutomatonParameterDescriptor {
    private final String name;
    private final String description;
    private final boolean compulsory;
    private final Class valueClass;
    private final boolean hasValue;
    
    public AutomatonParameterDescriptor(String name, String description, boolean compulsory, Class valueClass){
        this.name = name;
        this.description = description;
        this.compulsory = compulsory;
        if (valueClass == null){
            throw new IllegalArgumentException("Parameter class can not be null");
        }
        this.valueClass = valueClass;
        this.hasValue = true;
    }
    
    public AutomatonParameterDescriptor(String name, String description, boolean compulsory){
        this.name = name;
        this.description = description;
        this.compulsory = compulsory;
        this.valueClass = null;
        this.hasValue = false;
    }

    protected AutomatonParameterDescriptor(AutomatonParameterDescriptor existing){
        this.name = existing.name;
        this.description = existing.description;
        this.compulsory = existing.compulsory;
        this.valueClass = existing.valueClass;
        this.hasValue = existing.hasValue;
    }
    
    @Override
    public String toString(){
        return "Name: "+name+" Description: "+description+" Compulsory: "+compulsory+" HasValue: "+hasValue+" Class: "+valueClass.getSimpleName();
    }
}