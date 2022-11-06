package br.com.api.curso.service.impl;

import br.com.api.curso.model.UserModel;
import br.com.api.curso.model.dto.UserModelDTO;
import br.com.api.curso.repository.UserRepository;
import br.com.api.curso.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserModelDTO> findByAll() {
        return userRepository.findAll().stream().map(this::toUserModelDTO).collect(Collectors.toList());
    }

    @Override
    public UserModelDTO save(UserModel userModel) {
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepository.save(userModel);
        return toUserModelDTO(userModel);
    }

    private UserModelDTO toUserModelDTO(UserModel userModel) {
        return modelMapper.map(userModel, UserModelDTO.class);
    }
}
