package itiroBeto.com.github.APIHospital.v2.user.repository;

import itiroBeto.com.github.APIHospital.v2.user.jpa.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    //UserDetails vai ser usado pelo SpringSecurity depois
    UserDetails findByLogin(String login);
}
