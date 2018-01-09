
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
 * Transition/State output object
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "host",
    "port",
    "path",
    "data"
})
public class Output {

    /**
     * Target host
     * 
     */
    @JsonProperty("host")
    @JsonPropertyDescription("Target host")
    private String host;
    /**
     * Target host port
     * 
     */
    @JsonProperty("port")
    @JsonPropertyDescription("Target host port")
    private String port;
    /**
     * Target host path
     * 
     */
    @JsonProperty("path")
    @JsonPropertyDescription("Target host path")
    private String path;
    @JsonProperty("data")
    private Data data;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Target host
     * 
     */
    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    /**
     * Target host
     * 
     */
    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Target host port
     * 
     */
    @JsonProperty("port")
    public String getPort() {
        return port;
    }

    /**
     * Target host port
     * 
     */
    @JsonProperty("port")
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * Target host path
     * 
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * Target host path
     * 
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
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
        return new ToStringBuilder(this).append("host", host).append("port", port).append("path", path).append("data", data).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(host).append(path).append(additionalProperties).append(data).append(port).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Output) == false) {
            return false;
        }
        Output rhs = ((Output) other);
        return new EqualsBuilder().append(host, rhs.host).append(path, rhs.path).append(additionalProperties, rhs.additionalProperties).append(data, rhs.data).append(port, rhs.port).isEquals();
    }

}
