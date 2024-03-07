package com.example.booking_apartments.scheduler;

import com.example.booking_apartments.model.entity.UserRegistrationFormEntity;
import com.example.booking_apartments.repository.AuthRepository;
import com.example.booking_apartments.repository.UserRegistrationRepository;
import com.example.booking_apartments.service.impl.B64ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Component
@EnableScheduling
@RequiredArgsConstructor
public class TokenScheduler {

    private final UserRegistrationRepository userRegistrationRepository;
    private final AuthRepository authRepository;

    @Scheduled(fixedDelay = 360000)
    public void checkTokenStatus() {
        log.info("Планировщик проверки токенов начал свою работу");
        List<UserRegistrationFormEntity> tokenList = authRepository.findUserRegistrationFormEntitiesByTokenIsNotNull();
        for (UserRegistrationFormEntity u : tokenList) {
            String uToken = u.getToken();
            String decode = B64ServiceImpl.getDecode(uToken);

            LocalDateTime dateEnd = parseTokenValue(decode);
            if (checkValidDate(dateEnd)) {
                log.info("Токен " + uToken + " просрочен и был удален");
                u.setToken(null);
                userRegistrationRepository.save(u);
            }
        }
        log.info("Планировщик проверки токенов закончил свою работу");
    }

    private LocalDateTime parseTokenValue(String token) {

        int index = token.indexOf("|") + 1;
        String dateTime = token.substring(index);
        return LocalDateTime.parse(dateTime);
    }

    private boolean checkValidDate(LocalDateTime dateEnd) {

        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(dateEnd);
    }
}
