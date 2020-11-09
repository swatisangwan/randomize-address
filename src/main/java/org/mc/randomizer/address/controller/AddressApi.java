package org.mc.randomizer.address.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.mc.randomizer.address.model.Address;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-07T20:47:58.172Z")

@Api(value = "address", description = "the address API")
@RequestMapping(value = "/randomizer", produces = "application/json")
public interface AddressApi {

    @ApiOperation(value = "Generate Random address by country", nickname = "addressGet", notes = "", response = Address.class, tags={ "address", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Address.class),
        @ApiResponse(code = 500, message = "Internal server error", response = Error.class) })
    @RequestMapping(value = "/address",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Address> addressGet();

}
