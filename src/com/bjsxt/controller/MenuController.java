package com.bjsxt.controller;


import com.bjsxt.pojo.Admin;
import com.bjsxt.pojo.TreeResult;
import com.bjsxt.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-01-25
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    //声明业务属性
    @Autowired
    private IMenuService menuService;
    /**
     * 声明方法,加载菜单异步树信息
     */
    @ResponseBody
    @RequestMapping("menuInfo")
    public List<TreeResult> menuInfo(@RequestParam(defaultValue="0") String id, HttpSession httpSession){ //配置父菜单的默认值0
        //处理请求
        //获取seession中的用户id信息
        Admin admin= (Admin)httpSession.getAttribute("admin");
        Integer aid = admin.getAid();
        //调取业务层获取当前登录用户的菜单信息
        List<TreeResult> list = menuService.selMenuInfoService(id,aid);
        //响应结果
        return list;
    }


}

