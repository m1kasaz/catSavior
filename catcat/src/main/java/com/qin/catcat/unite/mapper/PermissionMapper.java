package com.qin.catcat.unite.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qin.catcat.unite.popo.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

/**
 * 权限Mapper接口
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
    
} 