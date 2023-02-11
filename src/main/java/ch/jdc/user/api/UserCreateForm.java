package ch.jdc.user.api;


import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class UserCreateForm {

    @NotNull
    String username;

    @Min(3)
    String firstname;

    @Min(3)
    String lastname;

    String email;
}
