package edu.icet.library.service.Impl;

import edu.icet.library.entity.UserEntity;
import edu.icet.library.model.User;
import edu.icet.library.repository.UserRepository;
import edu.icet.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    final UserRepository repository;
    final ModelMapper mapper;

    @Override
    public void addUser(User user) {
        repository.save(mapper.map(user,UserEntity.class));
    }

    @Override
    public List<User> all() {
        ArrayList<User> objects = new ArrayList<>();
        repository.findAll().forEach(userEntity -> {
            objects.add(mapper.map(userEntity, User.class));
        });
        return objects;
    }

    @Override
    public void update(User user) {
        Optional<UserEntity> existingEmployee = repository.findById(user.getId());
        if(existingEmployee.isPresent()) {
            UserEntity entityToUpdate = existingEmployee.get();
            entityToUpdate.setName(user.getName());
            entityToUpdate.setEmail(user.getEmail());
            entityToUpdate.setCreateAt(user.getCreateAt());
            repository.save(entityToUpdate);
        } else {
            throw new RuntimeException("Employee with ID " + user.getId() + " not found.");
        }
    }
}
