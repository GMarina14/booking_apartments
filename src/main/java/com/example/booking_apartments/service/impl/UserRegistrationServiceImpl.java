package com.example.booking_apartments.service.impl;

import com.example.booking_apartments.mapper.UserRegistrationMapper;
import com.example.booking_apartments.model.dto.UserRegistrationFormDto;
import com.example.booking_apartments.model.entity.UserRegistrationFormEntity;
import com.example.booking_apartments.repository.UserRegistrationRepository;
import com.example.booking_apartments.service.UserRegistrationService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.booking_apartments.constant.BookingApplicationConstant.*;
import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private final UserRegistrationRepository userRegistrationRepository;
    private final UserRegistrationMapper userRegistrationMapper;

    private final EntityManager entityManager;

    @Override
    public String saveNewUser(UserRegistrationFormDto userRegistrationFormDto) {

        //  UserRegistrationFormEntity userByNickname = userRegistrationRepository.findUserByNickname(userRegistrationFormDto.getNickname());

        UserRegistrationFormEntity userByNickname = findUserByNickNameWithCriteria(userRegistrationFormDto.getNickname());

        //userRegistrationRepository.findUserRegistrationFormEntityByNickname(userRegistrationFormDto.getNickname());

        if (!isNull(userByNickname)) {
            return NON_UNIQUE_NICKNAME;
        }

        UserRegistrationFormEntity userByUsername = userRegistrationRepository.findUserByUsername(userRegistrationFormDto.getUsername());

        //userRegistrationRepository.findUserRegistrationFormEntityByUsername(userRegistrationFormDto.getUsername());

        if (!isNull(userByUsername)) {
            return NON_UNIQUE_USERNAME;
        }

        UserRegistrationFormEntity userRegistrationForm = userRegistrationMapper.userFormDtoUserForm(userRegistrationFormDto);
        userRegistrationRepository.save(userRegistrationForm);

        return USER_REGISTRATION_SUCCESSFUL;
    }


    private UserRegistrationFormEntity findUserByNickNameWithCriteria(String nickName) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserRegistrationFormEntity> query = criteriaBuilder.createQuery(UserRegistrationFormEntity.class);
        Root<UserRegistrationFormEntity> root = query.from(UserRegistrationFormEntity.class);
        query.select(root)
                .where(criteriaBuilder.equal(root.get("nickname"), nickName));

        List<UserRegistrationFormEntity> resultList = entityManager.createQuery(query).getResultList();
        if (resultList.isEmpty()) {
            return null;
        }

        return resultList.get(0);
    }

}
