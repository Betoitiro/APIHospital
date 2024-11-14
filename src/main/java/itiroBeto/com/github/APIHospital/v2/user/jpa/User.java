package itiroBeto.com.github.APIHospital.v2.user.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Ou AUTO
    private Long id;

    private String login;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User(String login, String password, UserRole role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN)
            // Deixa o admin com direito as funcionalidades do user e do admin
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return this.login; // Corrigido para retornar o login do usuário
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Corrigido para permitir que a conta não expire
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Corrigido para permitir que a conta não seja bloqueada
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Corrigido para permitir que as credenciais não expirem
    }

    @Override
    public boolean isEnabled() {
        return true; // Corrigido para permitir que o usuário esteja habilitado
    }
}
