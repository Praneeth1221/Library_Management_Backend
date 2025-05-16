package edu.icet.library.service.Impl;

import edu.icet.library.entity.UserEntity;
import edu.icet.library.model.User;
import edu.icet.library.repository.UserRepository;
import edu.icet.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    final UserRepository repository;
    final ModelMapper mapper;

    @Override
    public void addUser(User user) {
        repository.save(mapper.map(user,UserEntity.class));
    }
}
