package com.bohuanshi.oj.model;


import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户的Model.
 * 对应数据库中的voj_users数据表.
 */
@Entity
@Data
public class User implements Serializable {
    /**
     * 用户的默认构造函数.
     */
    public User() {
    }

    /**
     * 用户的构造函数.
     *
     * @param username  - 用户名
     * @param password  - 密码
     * @param email     - 电子邮件地址
     * @param userGroup - 用户组
     */
    public User(String username, String password, String email,
                UserGroup userGroup) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userGroup = userGroup;
    }

    /**
     * User类的构造函数.
     *
     * @param uid       - 用户唯一标识符
     * @param username  - 用户名
     * @param password  - 密码
     * @param email     - 电子邮件地址
     * @param userGroup - 用户组
     */
    public User(int uid, String username, String password, String email,
                UserGroup userGroup) {
        this(username, password, email, userGroup);
        this.uid = uid;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return String.format("User: [Uid=%s, Username=%s, Password=%s, Email=%s, UserGroup={%s}, Language={%s}]",
                new Object[]{uid, username, password, email, userGroup});
    }

    /**
     * 用户的唯一标识符.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint")
    private long uid;

    /**
     * 用户名.
     */
    @NotNull
    private String username;

    /**
     * 密码(已采用MD5加密).
     */
    @NotNull
    private String password;

    /**
     * 电子邮件地址.
     */
    private String email;

    /**
     * 用户组对象.
     */
    private UserGroup userGroup;

    /**
     * 唯一的序列化标识符.
     */
    private static final long serialVersionUID = 2264535351943252507L;
}
