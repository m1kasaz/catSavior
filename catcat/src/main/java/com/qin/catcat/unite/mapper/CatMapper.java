package com.qin.catcat.unite.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qin.catcat.unite.popo.entity.Cat;
import com.qin.catcat.unite.popo.vo.CatListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CatMapper extends BaseMapper<Cat>{
    
    //查找全部猫猫信息
    @Select("Select * from cat")
    List<Cat> findAll();

    //搜索猫猫信息，匹配猫猫名字和catId
    @Select("select * from cat where catname like concat('%',#{words},'%') or id like concat('%',#{words},'%')")
    List<Cat> selectCatByCatWords(String words);

    // 查询猫咪列表及其评论数量
    List<CatListVO> selectCatList();
}