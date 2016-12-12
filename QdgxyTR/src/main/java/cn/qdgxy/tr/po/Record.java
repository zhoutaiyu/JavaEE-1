package cn.qdgxy.tr.po;

import java.io.Serializable;
import java.util.Date;

public class Record implements Serializable {

    private Long id;

    private Integer status;

    private Integer answerNumber;

    private Integer rightNumber;

    private Date createTime;

    private Date modifiedTime;

    private Boolean isDel;

    private Long uid;

    private static final long serialVersionUID = 1L;

    public Record(Long id, Integer status, Integer answerNumber, Integer rightNumber, Date createTime, Date modifiedTime, Boolean isDel, Long uid) {
        this.id = id;
        this.status = status;
        this.answerNumber = answerNumber;
        this.rightNumber = rightNumber;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
        this.isDel = isDel;
        this.uid = uid;
    }

    public Record() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(Integer answerNumber) {
        this.answerNumber = answerNumber;
    }

    public Integer getRightNumber() {
        return rightNumber;
    }

    public void setRightNumber(Integer rightNumber) {
        this.rightNumber = rightNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}