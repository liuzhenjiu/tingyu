package com.bjsxt.controller;


import com.bjsxt.pojo.Host;
import com.bjsxt.pojo.HostCondition;
import com.bjsxt.pojo.PageResult;
import com.bjsxt.service.IHostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-01-25
 */
@Controller
@RequestMapping("/host")
public class HostController {
    //声明业务层属性
    @Autowired
    private IHostService hostService;
    //声明单元方法:分页加载主持人信息
    /**
     * dataGrid的数据格式：
     *   要求响应一个json数据，并且有total和rows两个属性
     *   total表示符合要求的总的数据量
     *   rows为当前请求页的数据的list集合
     *   注意:
     *      创建实体类，实体类中有两个属性，属性名必须为total，rows
     *
     * 单元方法的形参:
     *      请求的页码： page
     *      每页显示的数量: rows
     *      筛选条件:HostCondition
     */
    @ResponseBody
    @RequestMapping("hostInfo")
    public PageResult<Host> hostInfo(Integer page, Integer rows, HostCondition hostCondition){
        //处理请求
        PageResult<Host> pageResult=hostService.selHostInfoService(page,rows,hostCondition);
        //响应结果
        return pageResult;
    }

}

