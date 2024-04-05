package com.intern.fresher.DAL;

import com.intern.fresher.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into \"user\"(userid, username, fullname, avatar, address)\n" +
            "values(?1 , ?2, ?3, ?4, ?5);", nativeQuery = true)
    void insertUser(String userid, String username, String fullname, String avatar, String address);

    @Transactional
    @Modifying
    @Query(value = "select * from \"user\" where \"user\".userid = '?1';", nativeQuery = true)
    User findById(UUID userId);

    @Transactional
    @Modifying
    @Query(value = "delete from \"user\" where userid = '?1';", nativeQuery = true)
    void deleteById(UUID id);
    @Transactional
    @Modifying
    @Query(value = "select * from \"user\" where username like '%?1%';", nativeQuery = true)
    List<User> findByName(String name);
    @Transactional
    @Modifying
    @Query(value = "select * from \"user\" where address like '%?1%';", nativeQuery = true)
    List<User> findByAddress(String address);
//@Modifying
//@Query("insert into \"user\"(username, fullname, avatar)\n + " +
//        "select :username,:fullname,:avatar from Dual")
//public int modifyingQueryInsertUser(@Param("username")String username, @Param("fullname")String fullname, @Param("avatar")String avatar);
}
