
package hr.mmaracic.mockautomaton.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "variableType",
    "value"
})
public class Variable {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("variableType")
    private Variable.VariableType variableType;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("value")
    private Object value;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("variableType")
    public Variable.VariableType getVariableType() {
        return variableType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("variableType")
    public void setVariableType(Variable.VariableType variableType) {
        this.variableType = variableType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("value")
    public Object getValue() {
        return value;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("value")
    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("variableType", variableType).append("value", value).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(variableType).append(value).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Variable) == false) {
            return false;
        }
        Variable rhs = ((Variable) other);
        return new EqualsBuilder().append(name, rhs.name).append(variableType, rhs.variableType).append(value, rhs.value).isEquals();
    }

    public enum VariableType {

        NUMBER("number"),
        STRING("string");
        private final String value;
        private final static Map<String, Variable.VariableType> CONSTANTS = new HashMap<String, Variable.VariableType>();

        static {
            for (Variable.VariableType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private VariableType(String value) {
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
        public static Variable.VariableType fromValue(String value) {
            Variable.VariableType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
