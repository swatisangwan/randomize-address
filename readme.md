## Random Addresses

#### Overview:
This a REST Web Service that returns a random address to the client for 4 countries:
- USA
- CANADA
- MEXICO
- NETHERLANDS.

#### Code style
This project uses standard intelliJ code style formatting.

#### Build
```bash
git clone https://github.com/
mvn clean verify
mvn spring-boot:run
```

#### Tech/Framework used
- Java 8
- SpringBoot 2.3.1
- Maven
- Mockito
- JUnit

#### Features
This program loads data from [application-address-data.yaml](src/main/resources/application-address-data.yaml) file and create a map of in-memory data of **AddressData** object.
Service fetch random data for each property of **Address** (_e.g._ house, street) from **AddressData** and builds **Address** object.
`/randomizer/address` returns **Address** in **JSON** format.

#### API Details

##### Endpoint:
> GET /randomizer/address

All **URI's** are relative to `http://localhost:8080/randomizer`

##### Response Data Format:
- JSON

| Method | HTTP request | Description |
|------- | ------------ | ------------|
| addressGet | GET `/address` | Generate Random address by country |

##### Parameters
This endpoint does not need any parameter.

##### Properties
Name | Type | Description |
------------ | ------------- | ------------- |
**house** | **String** | House or street number. | 
**street** | **String** | Street name (in practice may also contain street number). | 
**postalCode** | **String** | A numeric string included in a postal address to facilitate mail sorting (a.k.a. post code, postcode, or ZIP code). | 
**city** | **String** | The name of the primary locality of the place. | 
**county** | **String**  \[optional\] | A division of a state; typically a secondary-level administrative division of a country or equivalent. | 
**state** | **String**  \[optional\] | A division of a country; typically a first-level administrative division of a country and/or a geographical region. |
**stateCode** | **String**  \[optional\] | A code/abbreviation for the state division of a country. |
**country** | **String** | The localised country name. |
**countryCode** | **String** | A three-letter country code. (ISO 3166-1 alpha-3 code) | 	

##### Sample Response: 
```json
{
    "house": "Apt A107",
    "street": "Laurel, 71",
    "postalCode": "81889",
    "city": "Jacksonville",
    "county": "Madison County",
    "state": "New Mexico",
    "stateCode": "NM",
    "country": "Netherlands",
    "countryCode": "NLD"
}
```

##### How to use?
It will be deployed as a Spring Boot App on port 8080 and expose endpoint: http://localhost:8080/randomizer/address
There are no input parameters needed to get response.

#### Tests
Below scenarios considered as part of unit testing:
- Test to verify that correct value is available in response address for:
    - House
    - street
    - postalCode
    - city
    - county
    - state
    - stateCode
    - country
    - countryCode
- Test to verify NULL in case following values not configured in data set:
    - House
    - street
    - postalCode
    - city
    - county
    - state
    - stateCode
    - country
    - countryCode
- Test to verify in case stateCode data set values are not present in state map.
- Test to verify in case countryCode data set values are not present in country map.

#### Contributor
- [Swati Sangwan](mailto:sangwan.swati@gmail.com)