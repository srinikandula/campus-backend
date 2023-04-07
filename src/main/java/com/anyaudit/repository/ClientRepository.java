package com.anyaudit.repository;

import com.anyaudit.models.Client;
import com.anyaudit.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
  Optional<User> findByName(String name);

  Boolean existsByName(String username);

  @Query(value = "SELECT COUNT(*) FROM Client", nativeQuery = true)
  Long getClientCount();
}
