package com.bohuanshi.oj.dao;

import com.bohuanshi.oj.model.Language;
import com.bohuanshi.oj.model.User;
import com.bohuanshi.oj.model.UserGroup;
import org.apache.ibatis.annotations.*;

public interface UserDAO {
    String TABLE_NAME = "users";

    /**
     * 通过用户名获取用户对象.
     *
     * @param username - 用户名
     * @return 预期的用户对象或空引用
     */
    @Select({"SELECT * FROM", TABLE_NAME, "WHERE username = #{username}"})
    @Results(value = {
            @Result(property = "userGroup", column = "user_group_id", javaType = UserGroup.class, one = @One(select = "com.bohuanshi.oj.dao.UserGroupDAO.getUserGroupUsingId")),
            @Result(property = "preferLanguage", column = "prefer_language_id", javaType = Language.class, one = @One(select = "com.bohuanshi.oj.dao.LanguageDAO.getLanguageUsingId"))
    })
    User getUserByUserName(@Param("username") String username);
}
