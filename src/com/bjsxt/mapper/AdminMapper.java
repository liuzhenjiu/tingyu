package com.bjsxt.mapper;

import com.bjsxt.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 * 对应MybatisPlus的AutoRecord模式:实体类-继承BaseMapper<Admin>
 * @author ${author}
 * @since 2021-01-25
 */
public interface AdminMapper extends BaseMapper<Admin> {
    List<Admin> listResult(Map<String, Object> params);
}
