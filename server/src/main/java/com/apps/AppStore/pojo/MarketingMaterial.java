
package com.apps.AppStore.pojo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "documents",
    "domecunt"
})
@Document(collection="marketingmaterial")
public class MarketingMaterial {

    @JsonProperty("document")
    private Documents documents;
    @JsonProperty("domecunt")
    private Domecunt domecunt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("documents")
    public Documents getDocuments() {
        return documents;
    }

    @JsonProperty("documents")
    public void setDocuments(Documents documents) {
        this.documents = documents;
    }

    @JsonProperty("domecunt")
    public Domecunt getDomecunt() {
        return domecunt;
    }

    @JsonProperty("domecunt")
    public void setDomecunt(Domecunt domecunt) {
        this.domecunt = domecunt;
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
		return "MarketingMaterial [documents=" + documents + ", domecunt=" + domecunt + ", additionalProperties="
				+ additionalProperties + "]";
	}

   

}
