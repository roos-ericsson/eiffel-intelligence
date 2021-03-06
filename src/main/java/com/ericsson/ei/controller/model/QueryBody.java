
package com.ericsson.ei.controller.model;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "criteria",
    "options",
    "filter"
})
public class QueryBody {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("criteria")
    @Valid
    @NotNull
    private Criteria criteria;
    @JsonProperty("options")
    @Valid
    private Options options;
    @JsonProperty("filter")
    private String filter;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("criteria")
    public Criteria getCriteria() {
        return criteria;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("criteria")
    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    @JsonProperty("options")
    public Options getOptions() {
        return options;
    }

    @JsonProperty("options")
    public void setOptions(Options options) {
        this.options = options;
    }

    @JsonProperty("filter")
    public String getFilter() {
        return filter;
    }

    @JsonProperty("filter")
    public void setFilter(String filter) {
        this.filter = filter;
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
        return new ToStringBuilder(this).append("criteria", criteria).append("options", options).append("filter", filter).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(options).append(filter).append(additionalProperties).append(criteria).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof QueryBody) == false) {
            return false;
        }
        QueryBody rhs = ((QueryBody) other);
        return new EqualsBuilder().append(options, rhs.options).append(filter, rhs.filter).append(additionalProperties, rhs.additionalProperties).append(criteria, rhs.criteria).isEquals();
    }

}
