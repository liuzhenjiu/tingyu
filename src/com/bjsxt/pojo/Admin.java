package com.bjsxt.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 * 对应MybatisPlus的AutoRecord模式:实体类-继承Model<Admin>
 * @author ${author}
 * @since 2021-01-25
 */
@TableName("t_admin")
public class Admin extends Model<Admin> {

    private static final long serialVersionUID=1L;
    //设置表中“主键”所对应的字段名以及自增的方式
    @TableId(value = "aid", type = IdType.AUTO)
    private Integer aid;
    //@TableField("a_aname")
    private String aname;

    private String apwd;

    private String aphone;

    private LocalDateTime starttime;


    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApwd() {
        return apwd;
    }

    public void setApwd(String apwd) {
        this.apwd = apwd;
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone;
    }

    public LocalDateTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalDateTime starttime) {
        this.starttime = starttime;
    }

    /**
     * 对应MybatisPlus的AutoRecord模式:实体类-重写pkVal()方法
     */
    @Override
    protected Serializable pkVal() {
        return this.aid;
    }

    @Override
    public String toString() {
        return "Admin{" +
        "aid=" + aid +
        ", aname=" + aname +
        ", apwd=" + apwd +
        ", aphone=" + aphone +
        ", starttime=" + starttime +
        "}";
    }
}
