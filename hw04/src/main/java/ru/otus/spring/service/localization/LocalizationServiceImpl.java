package ru.otus.spring.service.localization;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocalizationServiceImpl implements LocalizationService {

    private final MessageSource messageSource;

    @Override
    public String getMessage(String bundleName, Object[] args) {
        return messageSource.getMessage(bundleName, args, LocaleContextHolder.getLocale());
    }
}
