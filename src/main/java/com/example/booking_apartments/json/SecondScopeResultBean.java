package com.example.booking_apartments.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class SecondScopeResultBean {



    @JsonProperty("components")
    private List<ThirdScopeComponentsBean> components;
}
