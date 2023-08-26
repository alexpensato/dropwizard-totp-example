package com.pensatocode.example.resources;

import com.pensatocode.example.db.UserRepository;
import com.pensatocode.example.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    private final UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
        LOGGER.info("############## UserResource Constructor ##############");
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response combineUserData(User user) {
        LOGGER.info("############## User: " + user.toString());
        // Combine user object data
        String result = String.format("User name is %s and username is %s.",
                user.getPersonalData().getName(),
                user.getCredentials().getUsername());
        return Response.status(200).entity(result).build();
    }

    @POST
    @Path("/foreign")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response foreignUserData(User user) {
        LOGGER.info("############## Foreign User: " + user.toString());
        // Combine user object data
        String result = String.format("[Foreign] User name is %s and username is %s.",
                user.getPersonalData().getName(),
                user.getCredentials().getUsername());
        return Response.status(200).entity(result).build();
    }
}
