
package hr.mmaracic.mockautomaton.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    "type",
    "name",
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
    /**
     * Type of the automaton - Json or Xml
     * (Required)
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Type of the automaton - Json or Xml")
    private AutomatonSchema.Type type;
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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    /**
     * Type of the automaton - Json or Xml
     * (Required)
     * 
     */
    @JsonProperty("type")
    public AutomatonSchema.Type getType() {
        return type;
    }

    /**
     * Type of the automaton - Json or Xml
     * (Required)
     * 
     */
    @JsonProperty("type")
    public void setType(AutomatonSchema.Type type) {
        this.type = type;
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
        return new ToStringBuilder(this).append("id", id).append("path", path).append("type", type).append("name", name).append("states", states).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(path).append(name).append(id).append(additionalProperties).append(type).append(states).toHashCode();
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
        return new EqualsBuilder().append(path, rhs.path).append(name, rhs.name).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(type, rhs.type).append(states, rhs.states).isEquals();
    }

    public enum Type {

        JSON("JSON"),
        XML("XML");
        private final String value;
        private final static Map<String, AutomatonSchema.Type> CONSTANTS = new HashMap<String, AutomatonSchema.Type>();

        static {
            for (AutomatonSchema.Type c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Type(String value) {
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
        public static AutomatonSchema.Type fromValue(String value) {
            AutomatonSchema.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
