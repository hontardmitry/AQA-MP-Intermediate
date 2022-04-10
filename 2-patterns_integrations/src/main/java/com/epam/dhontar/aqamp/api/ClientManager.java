package com.epam.dhontar.aqamp.api;

import static com.epam.dhontar.aqamp.utils.enums.RestEndpoints.AUTHORS;

import com.epam.dhontar.aqamp.utils.enums.RestEndpoints;

public class ClientManager {
    public RestClient createClient(RestEndpoints endpoint) {
        return (endpoint.equals(AUTHORS)) ?
            new AuthorsClient(endpoint.getValue()) : new UsersClient(endpoint.getValue());
    }
}
