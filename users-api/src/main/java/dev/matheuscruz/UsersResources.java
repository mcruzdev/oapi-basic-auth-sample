package dev.matheuscruz;

import java.util.List;
import java.util.Map;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/users")
public class UsersResources {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Map<String, Object>> getAll(@Context HttpHeaders headers) {

        headers.getRequestHeaders().forEach(
            (t, u) -> {
                System.out.println(t + ": " + u);
            }
        );
        
        return List.of(Map.of(
            "id", "1", "name", "John", "email", "john@email.com"
        ));
    }
}
