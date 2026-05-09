//package com.example.resourcehub.repository;
//
//public class UserRepository {
//}
package com.example.resourcehub.repository;

import com.example.resourcehub.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
