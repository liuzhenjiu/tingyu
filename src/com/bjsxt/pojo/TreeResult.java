package com.bjsxt.pojo;

import java.util.Map;
import java.util.Objects;

/**
 * @Auther: liuzhenjiu
 * @Date: 2021-01-27 - 01 - 27 - 17:12
 * @Description: com.bjsxt.pojo
 * @version: 1.0
 */
public class TreeResult {
    private int id;
    private String text;
    private String state;
    private Map<String,Object> attributes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeResult)) return false;
        TreeResult that = (TreeResult) o;
        return getId() == that.getId() &&
                getText().equals(that.getText()) &&
                getState().equals(that.getState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getText(), getState());
    }

    @Override
    public String toString() {
        return "TreeResult{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", state='" + state + '\'' +
                ", attributes=" + attributes +
                '}';
    }

    public TreeResult(int id, String text, String state) {
        this.id = id;
        this.text = text;
        this.state = state;
    }

    public TreeResult(int id, String text, String state, Map<String, Object> attributes) {
        this.id = id;
        this.text = text;
        this.state = state;
        this.attributes = attributes;
    }

    public TreeResult() {
    }
}
