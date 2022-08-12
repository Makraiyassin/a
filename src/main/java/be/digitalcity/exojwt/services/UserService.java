package be.digitalcity.exojwt.services;

import be.digitalcity.exojwt.models.entities.Utilisateur;
import be.digitalcity.exojwt.models.forms.UserForm;
import be.digitalcity.exojwt.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;


    public UserService(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public void register(UserForm form){
        Utilisateur user = new Utilisateur();
        user.setUsername(form.getUsername());
        user.setPassword( encoder.encode( form.getPassword() ) );
        user.setAuthorities(List.of("ROLE_USER"));

        repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username);
    }
}
