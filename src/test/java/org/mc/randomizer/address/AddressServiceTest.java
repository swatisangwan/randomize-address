package org.mc.randomizer.address;

import com.google.common.collect.ImmutableMap;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mc.randomizer.address.config.AddressData;
import org.mc.randomizer.address.model.Address;
import org.mc.randomizer.address.service.AddressService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest {

    @Mock
    private AddressData addressData;

    @InjectMocks
    private AddressService addressService;

    /**
     * Test case to check House in response address is correct
     */
    @Test
    public void test_HappyScenario_HouseAddress() {
        Mockito.when(addressData.getHouse()).thenReturn(Collections.singletonList("House One"));
        Address address = addressService.generateAddress();
        Assert.assertNotNull(address);
        Assert.assertEquals("House One", address.getHouse());
    }

    /**
     * Test case to check null house address in response
     */
    @Test
    public void test_NegativeScenario_NullHouseAddress() {
        Mockito.when(addressData.getHouse()).thenReturn(null);
        Address address = addressService.generateAddress();
        Assert.assertNotNull(address);
        Assert.assertNull(address.getHouse());
    }

    /**
     * Test case to check Street is correct in response address
     */
    @Test
    public void test_HappyScenario_StreetAddress() {
        Mockito.when(addressData.getStreet()).thenReturn(Collections.singletonList("Street One"));
        Address address = addressService.generateAddress();
        Assert.assertNotNull(address);
        Assert.assertEquals("Street One", address.getStreet());
    }

    /**
     * Test case to check City is correct in response address
     */
    @Test
    public void test_HappyScenario_CityAddress() {
        Mockito.when(addressData.getCity()).thenReturn(Collections.singletonList("City One"));
        Address address = addressService.generateAddress();
        Assert.assertNotNull(address);
        Assert.assertEquals("City One", address.getCity());
    }

    /**
     * Test case to check County is correct in response address
     */
    @Test
    public void test_HappyScenario_CountyAddress() {
        Mockito.when(addressData.getCounty()).thenReturn(Collections.singletonList("County One"));
        Address address = addressService.generateAddress();
        Assert.assertNotNull(address);
        Assert.assertEquals("County One", address.getCounty());
    }

    /**
     * Test case to check State Code is correct in response address
     */
    @Test
    public void test_HappyScenario_StateCode() {
        Mockito.when(addressData.getStateCodes()).thenReturn(Collections.singletonList("State One"));

        Address address = addressService.generateAddress();
        Assert.assertNotNull(address);
        Assert.assertEquals("State One", address.getStateCode());
    }

    /**
     * Test case to check length of Postal code in response address
     */
    @Test
    public void testPostalCodeSize() {
        Address address = addressService.generateAddress();
        Assert.assertEquals(5, address.getPostalCode().length());
        Assert.assertTrue(address.getPostalCode().matches("^[0-9]{5}$"));
    }

    /**
     * Test case to check Country Code and its Size is correct in response address
     */
    @Test
    public void test_HappyScenario_CountryCodes() {
        List<String> countryCodes = Arrays.asList("USA", "MEX", "CAN", "NDL");
        Mockito.when(addressData.getCountryCodes()).thenReturn(countryCodes);

        Address address = addressService.generateAddress();
        Assert.assertNotNull(address);
        Assert.assertEquals(3, address.getCountryCode().length());
        Assert.assertTrue(countryCodes.contains(address.getCountryCode()));
    }

    /**
     * Test case to check State Code and its Size is correct in response address
     */
    @Test
    public void testStateCodeSize() {
        Mockito.when(addressData.getStateCodes()).thenReturn(Arrays.asList("AL", "AK", "TX", "WA"));

        Address address = addressService.generateAddress();
        Assert.assertNotNull(address);
        Assert.assertEquals(2, address.getStateCode().length());
    }

    /**
     * Test case to check Country name is correct in response address
     */
    @Test
    public void testCountry() {
        Map<String, String> countryCodeAndCountries = ImmutableMap.of(
                "USA", "United States of America",
                "MEX", "Mexico",
                "CAN", "Canada",
                "NDL", "Netherland");
        Mockito.when(addressData.getCountryCodes()).thenReturn(Arrays.asList("USA", "MEX", "CAN", "NDL"));
        Mockito.when(addressData.getCountry()).thenReturn(countryCodeAndCountries);

        Address address = addressService.generateAddress();
        Assert.assertNotNull(address);
        Assert.assertNotNull(address.getCountryCode());
        Assert.assertEquals(countryCodeAndCountries.get(address.getCountryCode()), address.getCountry());
    }

    /**
     * Test case to check State name is correct in response address
     */
    @Test
    public void testState() {
        Map<String, String> stateCodeAndStates = ImmutableMap.of(
                "AL", "Alaska",
                "AK", "Arkansas",
                "TX", "Texas",
                "WA", "Washington");
        Mockito.when(addressData.getStateCodes()).thenReturn(Arrays.asList("AL", "AK", "TX", "WA"));
        Mockito.when(addressData.getState()).thenReturn(stateCodeAndStates);

        Address address = addressService.generateAddress();
        Assert.assertNotNull(address);
        Assert.assertNotNull(address.getStateCode());
        Assert.assertEquals(stateCodeAndStates.get(address.getStateCode()), address.getState());
    }

    /**
     * Test case to check null country code and country name in response address
     */
    @Test
    public void test_NegativeScenario_Country() {
        Map<String, String> countryCodeAndCountries = ImmutableMap.of(
                "USA", "United States of America",
                "MEX", "Mexico",
                "CAN", "Canada",
                "NDL", "Netherland");
        Mockito.when(addressData.getCountry()).thenReturn(countryCodeAndCountries);

        Address address = addressService.generateAddress();
        Assert.assertNotNull(address);
        Assert.assertNull(address.getCountryCode());
        Assert.assertNull(address.getCountry());
    }

    /**
     * Test case to check null State code and State name in response address
     */
    @Test
    public void test_NegativeScenario_State() {
        Map<String, String> stateCodeAndStates = ImmutableMap.of(
                "AL", "Alaska",
                "AK", "Arkansas",
                "TX", "Texas",
                "WA", "Washington");
        Mockito.when(addressData.getState()).thenReturn(stateCodeAndStates);

        Address address = addressService.generateAddress();
        Assert.assertNotNull(address);
        Assert.assertNull(address.getStateCode());
        Assert.assertNull(address.getState());
    }
}