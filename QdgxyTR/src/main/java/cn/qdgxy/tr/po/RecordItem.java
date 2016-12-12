package cn.qdgxy.tr.po;

import java.io.Serializable;
import java.util.Date;

public class RecordItem implements Serializable {

    private Long id;

    private Integer qid;

    private String answer;

    private String rightOption;

    private Date createTime;

    private Date modifiedTime;

    private Boolean isDel;

    private Long cid;

    private Long rid;

    private static final long serialVersionUID = 1L;

    public RecordItem(Long id, Integer qid, String answer, String rightOption, Date createTime, Date modifiedTime, Boolean isDel, Long cid, Long rid) {
        this.id = id;
        this.qid = qid;
        this.answer = answer;
        this.rightOption = rightOption;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
        this.isDel = isDel;
        this.cid = cid;
        this.rid = rid;
    }

    public RecordItem() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getRightOption() {
        return rightOption;
    }

    public void setRightOption(String rightOption) {
        this.rightOption = rightOption == null ? null : rightOption.trim();
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

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
}