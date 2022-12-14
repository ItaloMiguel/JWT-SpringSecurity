package br.com.api.curso.service.impl;

import br.com.api.curso.data.MyUserDetails;
import br.com.api.curso.model.UserModel;
import br.com.api.curso.repository.UserModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final static String USERNAME_NOT_FOUND = "User %s not found";

    private final UserModelRepository userRepository;

    public UserDetailsServiceImpl(UserModelRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> user = userRepository.findByUsername(username);
        if(user.isEmpty()) {
            throw new UsernameNotFoundException(String.format(USERNAME_NOT_FOUND, username));
        }
        return new MyUserDetails(user);
    }
}
