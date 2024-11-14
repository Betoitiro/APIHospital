package itiroBeto.com.github.APIHospital.v2.user.dto;

import itiroBeto.com.github.APIHospital.v2.user.jpa.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO{
    private String login;
    private String password;
    private UserRole role;
}
