package com.bjsxt.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjsxt.mapper.AdminMapper;
import com.bjsxt.pojo.Admin;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: liuzhenjiu
 * @Date: 2021-01-26 - 01 - 26 - 10:45
 * @Description: com.bjsxt.test
 * @version: 1.0
 */
public class TestMybatisPlus {
    /**
     * 测试MybatisPlus的基本操作
     */
    @Test
    public void testSelAllStudents(){
        //获取Spring容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationcontext-mp.xml");
        //获取StudentMapper接口的实例化对象
        AdminMapper adminMapper =(AdminMapper)ac.getBean("adminMapper");
        //List<Admin> list = adminMapper.selectList(null);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("aid","1");
        List<Admin> list = adminMapper.listResult(map);
        //打印输出结果
        System.out.println("____________________________"+list);
    }
    /**
     * 测试MybatisPlus的Wrapper条件构造器
     */
    @Test
    public void testSelWrapper(){
        //获取Spring容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationcontext-mp.xml");
        //获取StudentMapper接口的实例化对象
        AdminMapper adminMapper =(AdminMapper)ac.getBean("adminMapper");
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        //方式1
        //wrapper.eq("aid",1);
        //wrapper.or();
        //wrapper.eq("aname","admin");
        //方式2
        wrapper.eq("aid",1).or().eq("aname","admin");
        List<Admin> list = adminMapper.selectList(wrapper);
        System.out.println("*********************"+list);
    }
    /**
     * 测试MybatisPlus的分页查询插件
     */
    @Test
    public void testPage(){
        //获取Spring容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationcontext-mp.xml");
        //获取AdminMapper接口的实例化对象
        AdminMapper adminMapper =(AdminMapper)ac.getBean("adminMapper");
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        //方式1
        //wrapper.eq("aid",1);
        //wrapper.or();
        //wrapper.eq("aname","admin");
        //方式2
        wrapper.eq("aid",1).or().eq("aname","admin");
        //第几页
        int pageNo = 1;
        //每页条数
        int pageSize = 2;
        IPage<Admin> page = new Page<Admin>(pageNo,pageSize);
        IPage<Admin> adminIPage = adminMapper.selectPage(page,wrapper);
        //分页总共的数据量
        adminIPage.getTotal();
        //分页查询结果
        adminIPage.getRecords();
        //分页总共的页码数
        adminIPage.getPages();
        System.out.println("*********************"+adminIPage);
    }

    /**
     * 测试MybatisPlus的AR模式
     */
    @Test
    public void testAR(){
        //获取Spring容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationcontext-mp.xml");
        //获取AdminMapper接口的实例化对象
        AdminMapper adminMapper =(AdminMapper)ac.getBean("adminMapper");
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        //方式1
        //wrapper.eq("aid",1);
        //wrapper.or();
        //wrapper.eq("aname","admin");
        //方式2
        wrapper.eq("aid",1).or().eq("aname","admin");
        //第几页
        int pageNo = 1;
        //每页条数
        int pageSize = 2;
        IPage<Admin> page = new Page<Admin>(pageNo,pageSize);
        IPage<Admin> adminIPage = adminMapper.selectPage(page,wrapper);
        //分页总共的数据量
        adminIPage.getTotal();
        //分页查询结果
        adminIPage.getRecords();
        //分页总共的页码数
        adminIPage.getPages();
        System.out.println("*********************"+adminIPage);
    }

}
