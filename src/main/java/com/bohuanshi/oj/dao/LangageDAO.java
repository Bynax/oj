package com.bohuanshi.oj.dao;


import com.bohuanshi.oj.model.Language;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 对language表进行CRUD操作
 */

public interface LangageDAO {
    String TABLE_NAME = "languages";
    String INSERT_FIELD = "language_id,language_slug,language_name,language_compile_command,language_run_command";
    String SELECTED_FIELD = "language_id, " + INSERT_FIELD;


    /**
     * 通过编程语言的唯一标识符获取编程语言对象.
     *
     * @param languageId - 编程语言的唯一标识符
     * @return 预期的编程语言对象或空引用
     */
    @Select({"SELECT * FROM", TABLE_NAME, "WHERE language_id = #{languageId}"})
    @Results({
            @Result(property = "languageId", column = "language_id"),
            @Result(property = "languageSlug", column = "language_slug"),
            @Result(property = "languageName", column = "language_name"),
            @Result(property = "compileCommand", column = "language_compile_command"),
            @Result(property = "runCommand", column = "language_run_command"),
    })
    Language getLanguageById(@Param("languageId") int languageId);

    /**
     * 通过编程语言的唯一英文缩写获取编程语言对象.
     *
     * @param languageSlug - 编程语言的唯一英文缩写
     * @return 预期的编程语言对象或空引用
     */
    @Select({"SELECT * FROM ", TABLE_NAME, "WHERE language_slug = #{languageSlug}"})
    @Results({
            @Result(property = "languageId", column = "language_id"),
            @Result(property = "languageSlug", column = "language_slug"),
            @Result(property = "languageName", column = "language_name"),
            @Result(property = "compileCommand", column = "language_compile_command"),
            @Result(property = "runCommand", column = "language_run_command"),
    })
    Language getLanguageUsingSlug(@Param("languageSlug") String languageSlug);

    /**
     * 获取支持的编程语言.
     *
     * @return 编程语言列表(List < Language > 对象)
     */
    @Select({"SELECT * FROM", TABLE_NAME})
    @Results({
            @Result(property = "languageId", column = "language_id"),
            @Result(property = "languageSlug", column = "language_slug"),
            @Result(property = "languageName", column = "language_name"),
            @Result(property = "compileCommand", column = "language_compile_command"),
            @Result(property = "runCommand", column = "language_run_command"),
    })
    List<Language> getAllLanguages();

}
