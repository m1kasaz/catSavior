package com.catcat.entity;

import java.time.LocalDateTime;

@Data
public static class UserFollow {
    /**
     * 主键ID
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    /**
     * 关注人ID
     */
    private Long userId;

    /**
     * 被关注人ID
     */
    private Long followedUserId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    private Integer isDeleted;
}
