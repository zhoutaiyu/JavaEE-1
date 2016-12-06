package cn.qdgxy.tr.po;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable {
    private Integer aid;

    private String username;

    private String password;

    private String name;

    private String email;

    private String phone;

    private String sex;

    private Boolean level;

    private Date createTime;

    private Boolean isDel;

    private static final long serialVersionUID = 1L;

    public Admin(Integer aid, String username, String password, String name, String email, String phone, String sex, Boolean level, Date createTime, Boolean isDel) {
        this.aid = aid;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.level = level;
        this.createTime = createTime;
        this.isDel = isDel;
    }

    public Admin() {
        super();
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Boolean getLevel() {
        return level;
    }

    public void setLevel(Boolean level) {
        this.level = level;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }
}