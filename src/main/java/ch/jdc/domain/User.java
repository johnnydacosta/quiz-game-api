package ch.jdc.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    String id;
    String username;

    String firstname;

    String lastname;

    String email;
}
