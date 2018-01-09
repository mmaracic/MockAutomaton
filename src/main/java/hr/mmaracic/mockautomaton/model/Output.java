
package hr.mmaracic.mockautomaton.model;

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
    "template"
})
public class Output {

    /**
     * Target host
     * (Required)
     * 
     */
    @JsonProperty("host")
    @JsonPropertyDescription("Target host")
    private String host;
    /**
     * Target host port
     * (Required)
     * 
     */
    @JsonProperty("port")
    @JsonPropertyDescription("Target host port")
    private String port;
    /**
     * Target host path
     * (Required)
     * 
     */
    @JsonProperty("path")
    @JsonPropertyDescription("Target host path")
    private String path;
    @JsonProperty("template")
    private String template;

    /**
     * Target host
     * (Required)
     * 
     */
    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    /**
     * Target host
     * (Required)
     * 
     */
    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Target host port
     * (Required)
     * 
     */
    @JsonProperty("port")
    public String getPort() {
        return port;
    }

    /**
     * Target host port
     * (Required)
     * 
     */
    @JsonProperty("port")
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * Target host path
     * (Required)
     * 
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * Target host path
     * (Required)
     * 
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("template")
    public String getTemplate() {
        return template;
    }

    @JsonProperty("template")
    public void setTemplate(String template) {
        this.template = template;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("host", host).append("port", port).append("path", path).append("template", template).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(host).append(template).append(path).append(port).toHashCode();
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
        return new EqualsBuilder().append(host, rhs.host).append(template, rhs.template).append(path, rhs.path).append(port, rhs.port).isEquals();
    }

}
