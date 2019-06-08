package com.bohuanshi.oj.service;


import com.bohuanshi.oj.dao.LangageDAO;
import com.bohuanshi.oj.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {
    /**
     * 获取支持的编程语言.
     *
     * @return 编程语言列表(List < Language > 对象)
     */
    public List<Language> getAllLanguages() {
        return langageDAO.getAllLanguages();
    }

    /**
     * 通过编程语言的唯一标识符获取编程语言对象.
     *
     * @param languageId - 编程语言的唯一标识符
     * @return 预期的编程语言对象或空引用
     */
    public Language getLanguageById(int languageId) {
        return langageDAO.getLanguageById(languageId);
    }


    /**
     * 通过编程语言的唯一英文缩写获取编程语言对象.
     *
     * @param languageSlug - 编程语言的唯一英文缩写
     * @return 预期的编程语言对象或空引用
     */
    public Language getLanguageUsingSlug(String languageSlug) {
        return langageDAO.getLanguageUsingSlug(languageSlug);
    }


    @Autowired
    private LangageDAO langageDAO;

}
