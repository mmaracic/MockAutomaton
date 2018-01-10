
package hr.mmaracic.mockautomaton.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * Main schema that describes a json automaton
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "path",
    "params",
    "automatonType",
    "name",
    "variables",
    "states"
})
public class AutomatonSchema {

    /**
     * Unique id of the automaton instance
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Unique id of the automaton instance")
    private String id;
    /**
     * Url path to which this automaton will respond
     * (Required)
     * 
     */
    @JsonProperty("path")
    @JsonPropertyDescription("Url path to which this automaton will respond")
    private String path;
    @JsonProperty("params")
    private List<Param> params = new ArrayList<Param>();
    /**
     * Type of the automaton - Json or Xml
     * 
     */
    @JsonProperty("automatonType")
    @JsonPropertyDescription("Type of the automaton - Json or Xml")
    private AutomatonSchema.AutomatonType automatonType;
    /**
     * Unique name of the automaton
     * (Required)
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Unique name of the automaton")
    private String name;
    @JsonProperty("variables")
    private List<Variable> variables = new ArrayList<Variable>();
    /**
     * List of automaton states
     * (Required)
     * 
     */
    @JsonProperty("states")
    @JsonPropertyDescription("List of automaton states")
    private List<State> states = new ArrayList<State>();

    /**
     * Unique id of the automaton instance
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Unique id of the automaton instance
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
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

    @JsonProperty("params")
    public List<Param> getParams() {
        return params;
    }

    @JsonProperty("params")
    public void setParams(List<Param> params) {
        this.params = params;
    }

    /**
     * Type of the automaton - Json or Xml
     * 
     */
    @JsonProperty("automatonType")
    public AutomatonSchema.AutomatonType getAutomatonType() {
        return automatonType;
    }

    /**
     * Type of the automaton - Json or Xml
     * 
     */
    @JsonProperty("automatonType")
    public void setAutomatonType(AutomatonSchema.AutomatonType automatonType) {
        this.automatonType = automatonType;
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

    @JsonProperty("variables")
    public List<Variable> getVariables() {
        return variables;
    }

    @JsonProperty("variables")
    public void setVariables(List<Variable> variables) {
        this.variables = variables;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("path", path).append("params", params).append("automatonType", automatonType).append("name", name).append("variables", variables).append("states", states).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(path).append(variables).append(name).append(id).append(params).append(automatonType).append(states).toHashCode();
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
        return new EqualsBuilder().append(path, rhs.path).append(variables, rhs.variables).append(name, rhs.name).append(id, rhs.id).append(params, rhs.params).append(automatonType, rhs.automatonType).append(states, rhs.states).isEquals();
    }

    public enum AutomatonType {

        JSON("JSON"),
        XML("XML");
        private final String value;
        private final static Map<String, AutomatonSchema.AutomatonType> CONSTANTS = new HashMap<String, AutomatonSchema.AutomatonType>();

        static {
            for (AutomatonSchema.AutomatonType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private AutomatonType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static AutomatonSchema.AutomatonType fromValue(String value) {
            AutomatonSchema.AutomatonType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
