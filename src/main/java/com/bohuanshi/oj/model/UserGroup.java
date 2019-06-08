package com.bohuanshi.oj.model;

import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * 用户组的Model.
 * 对应数据库中的voj_user_groups数据表.
 */

@Entity
@Data
public class UserGroup implements Serializable {
    /**
     * 用户组的默认构造函数.
     */
    public UserGroup() {
    }

    /**
     * 用户组的构造函数.
     *
     * @param userGroupId   - 用户组的唯一标识符
     * @param userGroupSlug - 用户组的唯一英文简称
     * @param userGroupName - 用户组名称
     */
    public UserGroup(int userGroupId, String userGroupSlug, String userGroupName) {
        this.userGroupId = userGroupId;
        this.userGroupSlug = userGroupSlug;
        this.userGroupName = userGroupName;
    }

    @Override
    public String toString() {
        return String.format("UserGroup [ID=%d, Slug=%s, Name=%s]",
                new Object[]{userGroupId, userGroupSlug, userGroupName});
    }

    /**
     * 用户组唯一标识符.
     */
    private int userGroupId;

    /**
     * 用户组唯一英文简称.
     */
    private String userGroupSlug;

    /**
     * 用户组名称.
     */
    private String userGroupName;

    /**
     * 唯一的序列化标识符.
     */
    private static final long serialVersionUID = -4267702283058634035L;
}
