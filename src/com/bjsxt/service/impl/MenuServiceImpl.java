package com.bjsxt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjsxt.mapper.AdminMapper;
import com.bjsxt.mapper.AdminRoleMapper;
import com.bjsxt.mapper.RoleMenuMapper;
import com.bjsxt.pojo.AdminRole;
import com.bjsxt.pojo.Menu;
import com.bjsxt.mapper.MenuMapper;
import com.bjsxt.pojo.RoleMenu;
import com.bjsxt.pojo.TreeResult;
import com.bjsxt.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-01-25
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    //声明用户角色表的mapper
    @Autowired
    private AdminRoleMapper adminRoleMapper;
    //声明角色菜单表的mapper
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    //声明角色菜单表的mapper
    @Autowired
    private MenuMapper menuMapper;
    //加载当前用户的菜单信息
    public List<TreeResult> selMenuInfoService(String pid, Integer aid){
        //1获取当前用户的角色id集合
        QueryWrapper<AdminRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("aid",aid).select("rid");
        List<Object> rids = adminRoleMapper.selectObjs(queryWrapper);
        //2获取角色对应的菜单id集合
        QueryWrapper<RoleMenu> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.in("rid",rids).select("mid");
        List<Object> mids = roleMenuMapper.selectObjs(queryWrapper2);
        //3获取上级id为pid的菜单信息
        QueryWrapper<Menu> queryWrapper3 = new QueryWrapper<>();
        queryWrapper3.in("mid",mids).eq("pid",pid);
        List<Menu> menus = menuMapper.selectList(queryWrapper3);
        //4将List<Menu>转换为List<TreeResult>
        List<TreeResult> results = new ArrayList<TreeResult>();
        for(Menu menu:menus){
            TreeResult result = new TreeResult();
            result.setId(menu.getMid());
            result.setText(menu.getMname());
            result.setState("1".equals(menu.getIsparent())?"closed":"open");
            //创建map集合存储自定义数据
            Map<String,Object> map = new HashMap<>();
            map.put("isparent",menu.getIsparent());
            map.put("url",menu.getUrl());
            result.setAttributes(map);
            results.add(result);
        }
        return results;
    }
}
