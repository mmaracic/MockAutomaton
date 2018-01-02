
package hr.mmaracic.mockautomaton.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
 * Automaton
 * <p>
 * Main schema that describes a json automaton
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "path",
    "name",
    "states",
    "history"
})
public class AutomatonSchema {

    /**
     * Unique id of the automaton instance
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Unique id of the automaton instance")
    private Double id;
    /**
     * Url path to which this automaton will respond
     * (Required)
     * 
     */
    @JsonProperty("path")
    @JsonPropertyDescription("Url path to which this automaton will respond")
    private String path;
    /**
     * Unique name of the automaton
     * (Required)
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Unique name of the automaton")
    private String name;
    /**
     * List of automaton states
     * (Required)
     * 
     */
    @JsonProperty("states")
    @JsonPropertyDescription("List of automaton states")
    private List<State> states = new ArrayList<State>();
    /**
     * History of automaton's transitions during operation
     * 
     */
    @JsonProperty("history")
    @JsonPropertyDescription("History of automaton's transitions during operation")
    private List<Transition> history = new ArrayList<Transition>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Unique id of the automaton instance
     * 
     */
    @JsonProperty("id")
    public Double getId() {
        return id;
    }

    /**
     * Unique id of the automaton instance
     * 
     */
    @JsonProperty("id")
    public void setId(Double id) {
        this.id = id;
    }

    /**
     * Url path to which this automaton will respond
     * (Required)
     * 
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * Url path to which this automaton will respond
     * (Required)
     * 
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Unique name of the automaton
     * (Required)
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Unique name of the automaton
     * (Required)
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * List of automaton states
     * (Required)
     * 
     */
    @JsonProperty("states")
    public List<State> getStates() {
        return states;
    }

    /**
     * List of automaton states
     * (Required)
     * 
     */
    @JsonProperty("states")
    public void setStates(List<State> states) {
        this.states = states;
    }

    /**
     * History of automaton's transitions during operation
     * 
     */
    @JsonProperty("history")
    public List<Transition> getHistory() {
        return history;
    }

    /**
     * History of automaton's transitions during operation
     * 
     */
    @JsonProperty("history")
    public void setHistory(List<Transition> history) {
        this.history = history;
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
        return new ToStringBuilder(this).append("id", id).append("path", path).append("name", name).append("states", states).append("history", history).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(path).append(name).append(id).append(history).append(additionalProperties).append(states).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AutomatonSchema) == false) {
            return false;
        }
        AutomatonSchema rhs = ((AutomatonSchema) other);
        return new EqualsBuilder().append(path, rhs.path).append(name, rhs.name).append(id, rhs.id).append(history, rhs.history).append(additionalProperties, rhs.additionalProperties).append(states, rhs.states).isEquals();
    }

}
