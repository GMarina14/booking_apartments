package com.example.booking_apartments.repository;

import com.example.booking_apartments.model.entity.UserRegistrationFormEntity;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository






public interface UserRegistrationRepository extends JpaRepository<UserRegistrationFormEntity, Long> {

    UserRegistrationFormEntity findUserRegistrationFormEntityByNickname(String nickName);
// todo native
  //  @Query(nativeQuery = true, value = "select * from user_registration_form where nickname = :nickName")
//    UserRegistrationFormEntity findUserByNickname(String nickName);

 //   @Query(nativeQuery = true, value = "select * from user_registration_form  where username = :userName")
  //  UserRegistrationFormEntity findUserByUsername(String userName);

    // todo JPQL
    @Query(value = "select u from UserRegistrationFormEntity u where u.nickname = :nickName")
    UserRegistrationFormEntity findUserByNickname(String nickName);

    @Query(value = "select u from UserRegistrationFormEntity u where u.username = :userName")
    UserRegistrationFormEntity findUserByUsername(String userName);


    UserRegistrationFormEntity findUserRegistrationFormEntityByUsername(String userName);
}
