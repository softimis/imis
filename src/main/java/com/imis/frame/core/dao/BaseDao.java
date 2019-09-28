package com.imis.frame.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imis.frame.core.entity.BaseEntity;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T extends BaseEntity> extends BaseMapper {

    /**
     * Description: 批量物理删除
     * Author: zcx
     * Date: Created in 2019-08-16 21:11:07
     * Version: 1.0
     */
    public void batchDelete(List<Serializable> ids);

    /***
     * Description: 逻辑删除
     * Author: zcx
     * Date: Created in 2019-08-16 21:11:40
     * Version: 1.0
     */
    public boolean remove(T BaseEntity);

    /**
     * Description: 批量逻辑删除
     * Author: zcx
     * Date: Created in 2019-08-16 21:12:41
     * Version: 1.0
     */
    public boolean batchRemove(List<T> entitys);

    /**
     * Description: 列表查询
     * Author: zcx
     * Date: Created in 2019-08-10 23:12:42
     * Version: 1.0
     */
    public List<T> pageQuery(Page page,@Param("param") Map map);
}
