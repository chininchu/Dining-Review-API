package com.codeup.diningreviewapi.repositories;

import com.codeup.diningreviewapi.models.DiningUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiningUserRepository extends JpaRepository<DiningUser, Long> {

    DiningUser findByDisplayName(String displayName);

    boolean existsByDisplayName(String displayName);

    @Query("SELECT u FROM DiningUser u WHERE u.city = :city AND u.state = :state")
    List<DiningUser> findDiningUserByCityAndState(@Param("city") String city, @Param("state") String state);


}
