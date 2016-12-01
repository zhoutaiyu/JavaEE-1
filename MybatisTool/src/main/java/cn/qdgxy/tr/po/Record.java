package cn.qdgxy.tr.po;

import java.io.Serializable;
import java.util.Date;

public class Record implements Serializable {

    private Integer rid;

    private Boolean status;

    private Integer answerNumber;

    private Integer rightNumber;

    private Date createTime;

    private Boolean idDel;

    private Integer uid;

    private static final long serialVersionUID = 1L;

    public Record(Integer rid, Boolean status, Integer answerNumber, Integer rightNumber, Date createTime, Boolean idDel, Integer uid) {
        this.rid = rid;
        this.status = status;
        this.answerNumber = answerNumber;
        this.rightNumber = rightNumber;
        this.createTime = createTime;
        this.idDel = idDel;
        this.uid = uid;
    }

    public Record() {
        super();
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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

    public Boolean getIdDel() {
        return idDel;
    }

    public void setIdDel(Boolean idDel) {
        this.idDel = idDel;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}