package com.bohuanshi.oj.service;


import com.bohuanshi.oj.dao.LangageDAO;
import com.bohuanshi.oj.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {
    public List<Language> getAllLanguages() {
        return langageDAO.getAllLanguages();
    }

    public Language getLanguageUsingSlug(String languageSlug) {
        return langageDAO.getLanguageUsingSlug(languageSlug);
    }


    @Autowired
    private LangageDAO langageDAO;

}
