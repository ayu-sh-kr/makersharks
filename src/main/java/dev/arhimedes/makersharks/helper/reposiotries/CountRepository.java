package dev.arhimedes.makersharks.helper.reposiotries;

import dev.arhimedes.makersharks.helper.model.CountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CountRepository extends JpaRepository<CountModel, Integer> {

    @Query("select c.userCount from CountModel c where c.id = 1")
    int getCustomerCount();

    @Modifying
    @Transactional
    @Query("update CountModel c set c.userCount = c.userCount + 1 where c.id = 1")
    void incrementUserCount();
}
