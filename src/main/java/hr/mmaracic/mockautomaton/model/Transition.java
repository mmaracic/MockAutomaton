
package hr.mmaracic.mockautomaton.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    "path",
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
    private Double id;
    /**
     * Input data that can trigger this transition, has to match all existing items
     * 
     */
    @JsonProperty("input")
    @JsonPropertyDescription("Input data that can trigger this transition, has to match all existing items")
    private Input input;
    /**
     * Subpath that can trigger this transition, has to be matched perfectly
     * 
     */
    @JsonProperty("path")
    @JsonPropertyDescription("Subpath that can trigger this transition, has to be matched perfectly")
    private String path;
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
    private Double target;
    /**
     * Transition/State output object
     * 
     */
    @JsonProperty("output")
    @JsonPropertyDescription("Transition/State output object")
    private Output output;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Unique id of the state
     * (Required)
     * 
     */
    @JsonProperty("id")
    public Double getId() {
        return id;
    }

    /**
     * Unique id of the state
     * (Required)
     * 
     */
    @JsonProperty("id")
    public void setId(Double id) {
        this.id = id;
    }

    /**
     * Input data that can trigger this transition, has to match all existing items
     * 
     */
    @JsonProperty("input")
    public Input getInput() {
        return input;
    }

    /**
     * Input data that can trigger this transition, has to match all existing items
     * 
     */
    @JsonProperty("input")
    public void setInput(Input input) {
        this.input = input;
    }

    /**
     * Subpath that can trigger this transition, has to be matched perfectly
     * 
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * Subpath that can trigger this transition, has to be matched perfectly
     * 
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
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
    public Double getTarget() {
        return target;
    }

    /**
     * Id of the state that is the destination of this transition
     * (Required)
     * 
     */
    @JsonProperty("target")
    public void setTarget(Double target) {
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("input", input).append("path", path).append("delay", delay).append("target", target).append("output", output).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(output).append(input).append(path).append(delay).append(id).append(additionalProperties).append(target).toHashCode();
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
        return new EqualsBuilder().append(output, rhs.output).append(input, rhs.input).append(path, rhs.path).append(delay, rhs.delay).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(target, rhs.target).isEquals();
    }

}
