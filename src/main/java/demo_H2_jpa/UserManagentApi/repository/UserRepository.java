package demo_H2_jpa.UserManagentApi.repository;

import demo_H2_jpa.UserManagentApi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for UserModel entities.
 * Extends JpaRepository to provide standard CRUD operations and query methods.
 *
 * <p>This interface leverages Spring Data JPA to manage UserModel persistence
 * with Integer as the ID type.</p>
 */
public interface UserRepository extends JpaRepository<UserModel, Integer> {


}
