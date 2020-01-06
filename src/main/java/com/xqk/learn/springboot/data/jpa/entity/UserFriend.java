package com.xqk.learn.springboot.data.jpa.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * The type DatasourceUser friend.
 *
 * @author Aviator
 */
@Entity
@Data
@Table(name = "USER_FRIEND")
public class UserFriend {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    private Long userId;

    @Column(name = "FRIEND_ID")
    private Long friendId;
}
