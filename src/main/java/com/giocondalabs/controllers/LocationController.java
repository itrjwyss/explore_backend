package com.giocondalabs.controllers;

import com.giocondalabs.objects.data.CountryData;
import com.giocondalabs.services.structure.CountryService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("api/location")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LocationController extends BaseController {

    @Inject
    CountryService countryService;

    @GET
    @Path("/countries")
    public Response getCountries() {
        List<CountryData> countries = new ArrayList<>();
        countryService.findAll().forEach(country ->
            countries.add(
                new CountryData(
                    country.getId(),
                    country.getName()
                )
            )
        );
        return Response.ok(countries).build();
    }
}
