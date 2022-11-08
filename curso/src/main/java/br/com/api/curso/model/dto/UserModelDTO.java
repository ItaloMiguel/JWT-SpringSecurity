package br.com.api.curso.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModelDTO {

    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private String authorities;
}
