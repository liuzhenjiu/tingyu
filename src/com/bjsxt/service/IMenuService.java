package com.bjsxt.service;

import com.bjsxt.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bjsxt.pojo.TreeResult;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2021-01-25
 */
public interface IMenuService extends IService<Menu> {
    //加载当前用户的菜单信息
    List<TreeResult> selMenuInfoService(String id, Integer aid);
}
