package com.bjsxt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

public class HostCondition {
    private String hname;
    private String status;
    private String strong;
    private String hpstar;
    private String hpdiscount;

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStrong() {
        return strong;
    }

    public void setStrong(String strong) {
        this.strong = strong;
    }

    public String getHpstar() {
        return hpstar;
    }

    public void setHpstar(String hpstar) {
        this.hpstar = hpstar;
    }

    public String getHpdiscount() {
        return hpdiscount;
    }

    public void setHpdiscount(String hpdiscount) {
        this.hpdiscount = hpdiscount;
    }

    public HostCondition() {
    }

    public HostCondition(String hname, String status, String strong, String hpstar, String hpdiscount) {
        this.hname = hname;
        this.status = status;
        this.strong = strong;
        this.hpstar = hpstar;
        this.hpdiscount = hpdiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HostCondition)) return false;
        HostCondition that = (HostCondition) o;
        return getHname().equals(that.getHname()) &&
                getStatus().equals(that.getStatus()) &&
                getStrong().equals(that.getStrong()) &&
                getHpstar().equals(that.getHpstar()) &&
                getHpdiscount().equals(that.getHpdiscount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHname(), getStatus(), getStrong(), getHpstar(), getHpdiscount());
    }

    @Override
    public String toString() {
        return "HostCondition{" +
                "hname='" + hname + '\'' +
                ", status='" + status + '\'' +
                ", strong='" + strong + '\'' +
                ", hpstar='" + hpstar + '\'' +
                ", hpdiscount='" + hpdiscount + '\'' +
                '}';
    }
}
