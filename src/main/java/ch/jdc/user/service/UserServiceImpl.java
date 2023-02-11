package ch.jdc.user.service;

import ch.jdc.domain.User;
import ch.jdc.user.mapper.UserMapper;
import ch.jdc.user.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return this.userRepository
                .findAll()
                .stream()
                .map(UserMapper.INSTANCE::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void create(User user) {
        this.userRepository.persist(UserMapper.INSTANCE.mapToEntity(user));
    }

    @Override
    public void update(String id, User user) {
    }

    @Override
    public void delete(String id) {
        this.userRepository.delete("id", id);
    }
}
