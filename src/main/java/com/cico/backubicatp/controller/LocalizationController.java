package com.cico.backubicatp.controller;

import com.cico.backubicatp.service.LocalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class LocalizationController {

    private final LocalizationService localizationService;

    @Autowired
    public LocalizationController(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    @GetMapping("/localization")
    public String getLocalization(@RequestParam(value = "lang", defaultValue = "en") String lang) {
        Locale locale = localizationService.getLocale(lang);
        String currency = localizationService.getCurrency(lang);
        return "Language: " + locale.getLanguage() + ", Currency: " + currency;
    }

    @GetMapping("/localization/supported")
    public String[] getSupportedLocales() {
        return localizationService.getSupportedLocales();
    }
}
