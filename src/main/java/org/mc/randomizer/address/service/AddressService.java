package org.mc.randomizer.address.service;

import org.mc.randomizer.address.config.AddressData;
import org.mc.randomizer.address.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class AddressService {

    private final Random random = new Random();
    private final AddressData addressData;

    public AddressService(AddressData addressData){
        this.addressData = addressData;
    }

    public Address generateAddress(){
        String stateCode = getRandomData(addressData.getStateCodes());
        String countryCode = getRandomData(addressData.getCountryCodes());

        return Address.builder()
                .house(getRandomData(addressData.getHouse()))
                .street(getRandomData(addressData.getStreet()))
                .city(getRandomData(addressData.getCity()))
                .county(getRandomData(addressData.getCounty()))
                .stateCode(stateCode)
                .state(generateState(stateCode))
                .countryCode(countryCode)
                .country(generateCountry(countryCode))
                .postalCode(generatePostalCode())
                .build();
    }

    private String generateState(String stateCode){
        return isNull(stateCode) ? null : addressData.getState().get(stateCode);
    }

    private String generateCountry(String countryCode){
        return isNull(countryCode) ? null : addressData.getCountry().get(countryCode);
    }

    public String getRandomData(List<String> data){
        if(nonNull(data) && !data.isEmpty()){
            return data.get(random.nextInt(data.size()));
        }
        return null;
    }

    public String generatePostalCode() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}