package com.example.booking_apartments.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@JsonIgnoreProperties(ignoreUnknown = true, value = {"error"})
public class ThirdScopeComponentsBean {

/*    @JsonProperty("_category")
    private String category;
    @JsonProperty("_normalized_city")
    private String _normalized_city;
    @JsonProperty("_type")
    private String _type;*/
    @JsonProperty("city")
    private String city;
   /* @JsonProperty("continent")
    private String continent;
    @JsonProperty("country")
    private String country;
    @JsonProperty("country_code")
    private String country_code;
    @JsonProperty("house_number")
    private String house_number;
    @JsonProperty("postcode")
    private String postcode;
    @JsonProperty("region")
    private String region;
    @JsonProperty("road")
    private String road;
    @JsonProperty("shop")
    private String shop;
    @JsonProperty("state")
    private String state;
    @JsonProperty("suburb")
    private String suburb;*/
}
