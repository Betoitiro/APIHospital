package itiroBeto.com.github.APIHospital.v2.user;

import itiroBeto.com.github.APIHospital.v2.config.TokenService;
import itiroBeto.com.github.APIHospital.v2.user.dto.LoginResponseDTO;
import itiroBeto.com.github.APIHospital.v2.user.dto.RegisterDTO;
import itiroBeto.com.github.APIHospital.v2.user.dto.UserAuthenticationDTO;
import itiroBeto.com.github.APIHospital.v2.user.jpa.User;
import itiroBeto.com.github.APIHospital.v2.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Validated UserAuthenticationDTO dto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Validated RegisterDTO registerDTO) {
        if (this.repository.findByLogin(registerDTO.getLogin()) != null) {
            return ResponseEntity.badRequest().body("Username already exists"); // Melhor mensagem de erro
        }

        var encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.getPassword());
        var newUser = new User(registerDTO.getLogin(), encryptedPassword, registerDTO.getRole());

        this.repository.save(newUser);

        return ResponseEntity.ok("User registered successfully"); // Mensagem de sucesso mais clara
    }
}
