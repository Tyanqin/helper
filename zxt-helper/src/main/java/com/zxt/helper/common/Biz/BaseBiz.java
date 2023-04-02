package com.zxt.helper.common.Biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxt.helper.common.msg.TableResultResponse;
import com.zxt.helper.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author:TanXiao
 * @date:2023/3/17
 */

public abstract class BaseBiz<M extends Mapper<T>,T> {

    @Autowired
    protected M mapper;

    public void setMapper(M mapper) {
        this.mapper = mapper;
    }

    public T selectOne(T entity) {
        return mapper.selectOne(entity);
    }

    public T selectById(Object id) {
        return mapper.selectByPrimaryKey(id);
    }

    public List<T> selectList(T entity) {
        return mapper.select(entity);
    }

    public List<T> selectListAll() { return mapper.selectAll(); }

    public Long selectCount(T entity) {
        return new Long(mapper.selectCount(entity));
    }

    public void insertSelective(T entity) {
        mapper.insertSelective(entity);
    }

    public void updateById(T entity) { mapper.updateByPrimaryKey(entity); }

    public void updateSelectiveById(T entity) { mapper.updateByPrimaryKeySelective(entity); }


    public TableResultResponse<T> selectPage(Query query){
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        PageHelper.startPage(query.getPage(),query.getLimit());
        List<T> list=this.selectListAll();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        return new TableResultResponse<T>(pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getList());
    }
}
