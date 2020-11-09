package org.mc.randomizer.address.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "address")
@Getter
@Setter
public class AddressData {

    private List<String> stateCodes;
    private List<String> countryCodes;

    private List<String> house;
    private List<String> street;
    private List<String> city;
    private List<String> county;
    private Map<String, String> state;
    private Map<String, String> country;

    @PostConstruct
    public void postConstructProcessing(){

        Assert.notNull(state, "States Not Populated");
        Assert.notNull(country, "Countries Not Populated");

        stateCodes = new ArrayList<>(state.keySet());
        countryCodes = new ArrayList<>(country.keySet());
    }
}
