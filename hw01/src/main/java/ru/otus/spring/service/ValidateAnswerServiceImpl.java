package ru.otus.spring.service;

import org.springframework.stereotype.Service;

@Service
public class ValidateAnswerServiceImpl implements ValidateAnswerService {
    @Override
    public boolean validate(String rightAnswer, String answer) {
        return answer.equalsIgnoreCase(rightAnswer);
    }
}
