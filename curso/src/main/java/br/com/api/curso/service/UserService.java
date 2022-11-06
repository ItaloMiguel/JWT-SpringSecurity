package br.com.api.curso.service;

import br.com.api.curso.model.UserModel;
import br.com.api.curso.model.dto.UserModelDTO;

import java.util.List;

public interface UserService {
    List<UserModelDTO> findByAll();

    UserModelDTO save(UserModel userModel);
}
