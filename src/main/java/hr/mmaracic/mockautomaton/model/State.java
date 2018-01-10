
package hr.mmaracic.mockautomaton.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * Automaton states
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "description",
    "starting",
    "ending",
    "output",
    "transitions"
})
public class State {

    /**
     * Unique id of the state
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Unique id of the state")
    private String id;
    @JsonProperty("description")
    private String description;
    /**
     * True if this is a starting state
     * (Required)
     * 
     */
    @JsonProperty("starting")
    @JsonPropertyDescription("True if this is a starting state")
    private Boolean starting;
    /**
     * True if this is an ending state
     * (Required)
     * 
     */
    @JsonProperty("ending")
    @JsonPropertyDescription("True if this is an ending state")
    private Boolean ending;
    /**
     * Transition/State output object
     * 
     */
    @JsonProperty("output")
    @JsonPropertyDescription("Transition/State output object")
    private Output output;
    /**
     * Outgoing transitions of this state
     * (Required)
     * 
     */
    @JsonProperty("transitions")
    @JsonPropertyDescription("Outgoing transitions of this state")
    private List<Transition> transitions = new ArrayList<Transition>();

    /**
     * Unique id of the state
     * (Required)
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Unique id of the state
     * (Required)
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * True if this is a starting state
     * (Required)
     * 
     */
    @JsonProperty("starting")
    public Boolean getStarting() {
        return starting;
    }

    /**
     * True if this is a starting state
     * (Required)
     * 
     */
    @JsonProperty("starting")
    public void setStarting(Boolean starting) {
        this.starting = starting;
    }

    /**
     * True if this is an ending state
     * (Required)
     * 
     */
    @JsonProperty("ending")
    public Boolean getEnding() {
        return ending;
    }

    /**
     * True if this is an ending state
     * (Required)
     * 
     */
    @JsonProperty("ending")
    public void setEnding(Boolean ending) {
        this.ending = ending;
    }

    /**
     * Transition/State output object
     * 
     */
    @JsonProperty("output")
    public Output getOutput() {
        return output;
    }

    /**
     * Transition/State output object
     * 
     */
    @JsonProperty("output")
    public void setOutput(Output output) {
        this.output = output;
    }

    /**
     * Outgoing transitions of this state
     * (Required)
     * 
     */
    @JsonProperty("transitions")
    public List<Transition> getTransitions() {
        return transitions;
    }

    /**
     * Outgoing transitions of this state
     * (Required)
     * 
     */
    @JsonProperty("transitions")
    public void setTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("description", description).append("starting", starting).append("ending", ending).append("output", output).append("transitions", transitions).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(output).append(ending).append(description).append(id).append(starting).append(transitions).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof State) == false) {
            return false;
        }
        State rhs = ((State) other);
        return new EqualsBuilder().append(output, rhs.output).append(ending, rhs.ending).append(description, rhs.description).append(id, rhs.id).append(starting, rhs.starting).append(transitions, rhs.transitions).isEquals();
    }

}
