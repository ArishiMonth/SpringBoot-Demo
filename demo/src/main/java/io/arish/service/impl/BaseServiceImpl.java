package io.arish.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author ArishiMonth
 * @since 2018-09-29
 *原有分页封装有bug，自己封装分页
 * */
public abstract class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements IService<T> {
    @Autowired
    protected M baseMapper;
    @Override
    public Page<T> selectPage(Page<T> page, Wrapper<T> wrapper) {
        SqlHelper.fillWrapper(page, wrapper);
        page.setTotal(baseMapper.selectCount(wrapper));
        page.setRecords(baseMapper.selectPage(page, wrapper));
        return page;
    }

}
