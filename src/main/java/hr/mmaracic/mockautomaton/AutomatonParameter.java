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
public class AutomatonParameter extends AutomatonParameterDescriptor {
    
    private Object value;
    
    AutomatonParameter(AutomatonParameterDescriptor descriptor, Object value){
        super(descriptor);
        
        if (this.isHasValue()){
            if (!(value.getClass() != this.getValueClass())){
                throw new IllegalArgumentException("Value is of type "+value.getClass().getSimpleName()+" instead of "+this.getValueClass().getSimpleName());
            } else if (value == null){
                throw new IllegalArgumentException("Parameter requires value");
            } else {
                this.value = value;
            }
        } else {
            this.value = null;
        }
    }
    
    AutomatonParameter(AutomatonParameterDescriptor descriptor){
        this(descriptor, null);
    }
}
