package be.bstorm.tf_java2024_demospringsecuritymvc.dal.repositories;

import be.bstorm.tf_java2024_demospringsecuritymvc.dl.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select u from User u where u.email ilike :email")
    Optional<User> findByEmail(@Param("email") String email);
}
