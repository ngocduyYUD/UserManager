package com.intern.fresher.DAL;

import com.intern.fresher.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into \"user\"(username, fullname, avatar)\n" +
            "values(?1 , ?2, ?3);", nativeQuery = true)
    void insertUser(String username, String fullname, String avatar);
//@Modifying
//@Query("insert into \"user\"(username, fullname, avatar)\n + " +
//        "select :username,:fullname,:avatar from Dual")
//public int modifyingQueryInsertUser(@Param("username")String username, @Param("fullname")String fullname, @Param("avatar")String avatar);
}
