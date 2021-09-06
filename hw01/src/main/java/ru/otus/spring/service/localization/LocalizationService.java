package ru.otus.spring.service.localization;

import org.springframework.lang.Nullable;

public interface LocalizationService {

    String getMessage(String bundleName, @Nullable Object[] args);

}
