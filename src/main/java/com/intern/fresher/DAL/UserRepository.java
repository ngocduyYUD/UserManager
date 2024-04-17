package com.intern.fresher.DAL;

import com.intern.fresher.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUserid(UUID id);
    List<User> findByUsernameContaining(String name);
    UUID deleteByUserid(UUID id);
    List<User> findByAddressContaining(String address);

    @Query(value = "SELECT * FROM \"user_data\" OFFSET ((SELECT COUNT(*) FROM \"user_data\" )-1)", nativeQuery = true)
    User findLastRecord();
}
