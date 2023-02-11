package ch.jdc.user.api;

import ch.jdc.user.dto.UserDto;
import ch.jdc.user.mapper.UserMapper;
import ch.jdc.user.service.UserService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/users")
public class UserResource {

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDto> findAllUsers() {
        return this.userService
                .findAll()
                .stream()
                .map(UserMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid UserCreateForm userCreateForm) {
        this.userService.create(UserMapper.INSTANCE.mapToDomain(userCreateForm));
        return Response.noContent().build();
    }
}