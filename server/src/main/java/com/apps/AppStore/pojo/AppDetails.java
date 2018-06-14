
package com.apps.AppStore.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonParser;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    //"appCode",
    "name",
    "description",
    "createdby",
    "categories",
    "dashboard",
    "industry",
    "tags",
    "marketingmaterial",
    "logo",
    "inProduction",
    "null",
    "version",
    "appAddedTime",
    "lastVisitedTime"
})
@Document(collection="AppsInfo")
public class AppDetails {

    @JsonProperty("id")
    private String id;
   // @JsonProperty("appCode")
   // private String appCode ;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("createdby")
    private String createdby;
    @JsonProperty("categories")
    private List<String> categories = null;
    @JsonProperty("dashboard")
    private String dashboard;   
	@JsonProperty("industry")
    private List<String> industry = null;
    @JsonProperty("tags")
    private List<String> tags = null;
    @JsonProperty("marketingmaterial")
    private List<MarketingMaterial> marketingMaterial = null;
    @JsonProperty("logo")
    private Logo logo;
    @JsonProperty("inProduction")
    private Boolean inProduction;
    @JsonProperty("null")
    private Object _null;
    @JsonProperty("version")
    private Integer version;    
    @JsonProperty("appAddedTime")
   /* private DateTime appAddedTime;
    @JsonProperty("lastVisitedTime")
    private DateTime lastVisitedTime; */
    
   /* public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}*/

	/*public Date getAppAddedTime() {
		return appAddedTime;
	}

	public void setAppAddedTime(Date appAddedTime) {
		this.appAddedTime = appAddedTime;
	}

	public Date getLastVisitedTime() {
		return lastVisitedTime;
	}

	public void setLastVisitedTime(Date lastVisitedTime) {
		this.lastVisitedTime = lastVisitedTime;
	}*/

	@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

   

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("createdby")
    public String getCreatedby() {
        return createdby;
    }

    @JsonProperty("createdby")
    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    @JsonProperty("categories")
    public List<String>  getCategories() {
        return categories;
    }

    @JsonProperty("categories")
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @JsonProperty("dashboard")
    public String getDashboard() {
        return dashboard;
    }

    @JsonProperty("dashboard")
    public void setDashboard(String dashboard) {
        this.dashboard = dashboard;
    }

    @JsonProperty("industry")
    public List<String> getIndustry() {
        return industry;
    }

    @JsonProperty("industry")
    public void setIndustry(List<String> industry) {
        this.industry = industry;
    }

    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonProperty("marketingmaterial")
    public List<MarketingMaterial> getMarketingMaterial() {
        return marketingMaterial;
    }

    @JsonProperty("marketingmaterial")
    public void setMarketingMaterial(List<MarketingMaterial> marketingMaterial) {
        this.marketingMaterial = marketingMaterial;
    }

    @JsonProperty("logo")
    public Logo getLogo() {
        return logo;
    }

    @JsonProperty("logo")
    public void setLogo(Logo logo) {
        this.logo = logo;
    }

    @JsonProperty("inProduction")
    public Boolean getInProduction() {
        return inProduction;
    }

    @JsonProperty("inProduction")
    public void setInProduction(Boolean inProduction) {
        this.inProduction = inProduction;
    }

    @JsonProperty("null")
    public Object getNull() {
        return _null;
    }

    @JsonProperty("null")
    public void setNull(Object _null) {
        this._null = _null;
    }

    @JsonProperty("version")
    public Integer getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Integer version) {
        this.version = version;
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
		return "AppResponse [id=" + id + ", name=" + name + ", description=" + description + ", createdby=" + createdby
				+ ", categories=" + categories + ", dashboard=" + dashboard + ", industry="
				+ industry + ", tags=" + tags + ", marketingMaterial=" + marketingMaterial + ", logo=" + logo +  ","
				+ ", inProduction=" + inProduction + ", _null=" + _null + ", version=" + version
				+ ", additionalProperties=" + additionalProperties + "]";
	}


   

}
