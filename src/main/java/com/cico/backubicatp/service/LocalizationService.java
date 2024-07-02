package com.cico.backubicatp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class LocalizationService {

    @Value("${localization.default.currency}")
    private String defaultCurrency;

    @Value("${localization.default.language}")
    private String defaultLanguage;

    @Value("${localization.supported.locales}")
    private String[] supportedLocales;

    @Value("#{${localization.currency}}")
    private Map<String, String> currencyMap;

    private Map<String, Locale> localeMap = new HashMap<>();

    @PostConstruct
    public void init() {
        for (String lang : supportedLocales) {
            localeMap.put(lang, new Locale(lang));
        }
    }

    public String getCurrency(String language) {
        return currencyMap.getOrDefault(language, defaultCurrency);
    }

    public Locale getLocale(String language) {
        return localeMap.getOrDefault(language, new Locale(defaultLanguage));
    }

    public String[] getSupportedLocales() {
        return supportedLocales;
    }
}
