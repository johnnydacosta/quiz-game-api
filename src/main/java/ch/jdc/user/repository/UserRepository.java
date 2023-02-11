package ch.jdc.user.repository;

import ch.jdc.user.entity.UserEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheRepository<UserEntity> {

    public Optional<UserEntity> findByName(String username) {
        return this.find("username", username).firstResultOptional();
    }
}
