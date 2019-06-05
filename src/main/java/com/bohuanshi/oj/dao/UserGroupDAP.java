package com.bohuanshi.oj.dao;

import com.bohuanshi.oj.model.UserGroup;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserGroupDAP {
    String TABLE_NAME = "user_group";

    /**
     * 通过用户组的唯一标识符获取用户组对象.
     *
     * @param userGroupId - 用户组的唯一标识符
     * @return 预期的用户组对象或空引用
     */
    @Select({"SELECT * FROM", TABLE_NAME, "WHERE user_group_id = #{userGroupId}"})
    @Results({
            @Result(property = "userGroupId", column = "user_group_id"),
            @Result(property = "userGroupSlug", column = "user_group_slug"),
            @Result(property = "userGroupName", column = "user_group_name")
    })
    UserGroup getUserGroupUsingId(@Param("userGroupId") int userGroupId);
}
