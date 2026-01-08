package com.qin.catcat.unite.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qin.catcat.unite.popo.entity.UserRole;

import java.util.List;

/**
 * 用户角色关联服务接口
 */
public interface UserRoleService extends IService<UserRole> {
    
    /**
     * 为用户分配角色
     * @param userId 用户ID
     * @param roleIds 角色ID列表
     * @return 是否分配成功
     */
    boolean assignRoles(Integer userId, List<Integer> roleIds);
    
    /**
     * 移除用户的角色
     * @param userId 用户ID
     * @param roleId 角色ID
     * @return 是否移除成功
     */
    boolean removeRole(Integer userId, Integer roleId);
    
    /**
     * 获取用户的角色ID列表
     * @param userId 用户ID
     * @return 角色ID列表
     */
    List<Integer> getRoleIdsByUserId(Integer userId);
    
    /**
     * 检查用户是否有指定角色
     * @param userId 用户ID
     * @param roleId 角色ID
     * @return 是否有该角色
     */
    boolean hasRole(Integer userId, Integer roleId);
} 