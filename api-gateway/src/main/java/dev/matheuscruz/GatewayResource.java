package dev.matheuscruz;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.openapi.quarkus.users_yaml.api.DefaultApi;
import org.openapi.quarkus.users_yaml.model.User;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/info")
public class GatewayResource {

    @Inject
    @RestClient
    DefaultApi usersApi;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> usersInfo() {
        
        List<User> users = usersApi.v1UsersGet();

        // requesting another endpoint to sumarize user info...

        return users;

    }
}
