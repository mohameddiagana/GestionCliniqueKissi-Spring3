package sn.seck.GestionCliniqueKissi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.seck.GestionCliniqueKissi.Model.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Integer> {
    Optional<Users>findByEmail(String email);
}
