package com.leyou.item.mapper;


import com.leyou.item.pojo.Category;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CategoryMapper extends Mapper<Category>, SelectByIdListMapper<Category, Long> {

    /**
     * 根据品牌id查询商品分类
     * @param bid
     * @return
     */
    @Select("select *  from tb_category where id in(select category_id from tb_category_brand where brand_id = #{bid})")
    List<Category> queryByBrandId(Long bid);


}
