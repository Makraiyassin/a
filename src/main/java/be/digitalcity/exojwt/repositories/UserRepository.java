package be.digitalcity.exojwt.repositories;


import be.digitalcity.exojwt.models.entities.Utilisateur;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Utilisateur,Long> {

    Utilisateur findByUsername(String username);
}
