package home.danil.myboot.PP312.repositories;



import home.danil.myboot.PP312.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
}
