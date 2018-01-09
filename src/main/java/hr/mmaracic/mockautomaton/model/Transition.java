
package hr.mmaracic.mockautomaton.model;

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
    "input",
    "subpath",
    "delay",
    "target",
    "output"
})
public class Transition {

    /**
     * Unique id of the state
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Unique id of the state")
    private String id;
    @JsonProperty("input")
    private String input;
    /**
     * Subpath that can trigger this transition, has to be matched perfectly
     * 
     */
    @JsonProperty("subpath")
    @JsonPropertyDescription("Subpath that can trigger this transition, has to be matched perfectly")
    private String subpath;
    /**
     * Time period that will triger this transition
     * 
     */
    @JsonProperty("delay")
    @JsonPropertyDescription("Time period that will triger this transition")
    private Double delay;
    /**
     * Id of the state that is the destination of this transition
     * (Required)
     * 
     */
    @JsonProperty("target")
    @JsonPropertyDescription("Id of the state that is the destination of this transition")
    private String target;
    /**
     * Transition/State output object
     * 
     */
    @JsonProperty("output")
    @JsonPropertyDescription("Transition/State output object")
    private Output output;

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

    @JsonProperty("input")
    public String getInput() {
        return input;
    }

    @JsonProperty("input")
    public void setInput(String input) {
        this.input = input;
    }

    /**
     * Subpath that can trigger this transition, has to be matched perfectly
     * 
     */
    @JsonProperty("subpath")
    public String getSubpath() {
        return subpath;
    }

    /**
     * Subpath that can trigger this transition, has to be matched perfectly
     * 
     */
    @JsonProperty("subpath")
    public void setSubpath(String subpath) {
        this.subpath = subpath;
    }

    /**
     * Time period that will triger this transition
     * 
     */
    @JsonProperty("delay")
    public Double getDelay() {
        return delay;
    }

    /**
     * Time period that will triger this transition
     * 
     */
    @JsonProperty("delay")
    public void setDelay(Double delay) {
        this.delay = delay;
    }

    /**
     * Id of the state that is the destination of this transition
     * (Required)
     * 
     */
    @JsonProperty("target")
    public String getTarget() {
        return target;
    }

    /**
     * Id of the state that is the destination of this transition
     * (Required)
     * 
     */
    @JsonProperty("target")
    public void setTarget(String target) {
        this.target = target;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("input", input).append("subpath", subpath).append("delay", delay).append("target", target).append("output", output).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(output).append(input).append(delay).append(subpath).append(id).append(target).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Transition) == false) {
            return false;
        }
        Transition rhs = ((Transition) other);
        return new EqualsBuilder().append(output, rhs.output).append(input, rhs.input).append(delay, rhs.delay).append(subpath, rhs.subpath).append(id, rhs.id).append(target, rhs.target).isEquals();
    }

}
