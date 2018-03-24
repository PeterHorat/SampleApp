package controllers;

import models.Track;
import models.User;
import services.UserService;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserController {
    @Inject
    private UserService userService;

    @Path("/all")
    @GET
    @Produces("application/json")
    public JsonArray getAll() {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (User user : userService.getAll()) {
            builder.add(Json.createObjectBuilder().add("email", user.getEmail()));
        }
        return builder.build();
    }

    @Path("/user")
    @GET
    public Response getUser() {
        String json = "{etwas: jaja}";
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/track")
    @Produces(MediaType.APPLICATION_JSON)
    public Track getTrackInJSON() {

        Track track = new Track();
        track.setTitle("Enter Sandman");
        track.setSinger("Metallica");

        return track;

    }

}
