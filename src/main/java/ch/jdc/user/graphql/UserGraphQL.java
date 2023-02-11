package ch.jdc.user.graphql;

import ch.jdc.user.dto.UserDto;
import ch.jdc.user.mapper.UserMapper;
import ch.jdc.user.service.UserService;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@GraphQLApi
public class UserGraphQL {

    @Inject
    UserService userService;

    @Query("allUsers")
    @Description("Get all user microprofile graphql")
    public List<UserDto> findUsers() {
        return userService.findAll().stream().map(UserMapper.INSTANCE::mapToDto).collect(Collectors.toList());
    }
}
