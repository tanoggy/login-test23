package rebo.vn.logintest23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import rebo.vn.logintest23.model.database.User;

public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

}