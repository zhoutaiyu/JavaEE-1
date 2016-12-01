package cn.qdgxy.tr.po;

import java.io.Serializable;

public class RecordItem implements Serializable {

    private Integer riid;

    private Integer qid;

    private String answer;

    private Boolean isRight;

    private Boolean isDel;

    private Integer cid;

    private Integer rid;

    private static final long serialVersionUID = 1L;

    public RecordItem(Integer riid, Integer qid, String answer, Boolean isRight, Boolean isDel, Integer cid, Integer rid) {
        this.riid = riid;
        this.qid = qid;
        this.answer = answer;
        this.isRight = isRight;
        this.isDel = isDel;
        this.cid = cid;
        this.rid = rid;
    }

    public RecordItem() {
        super();
    }

    public Integer getRiid() {
        return riid;
    }

    public void setRiid(Integer riid) {
        this.riid = riid;
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

    public Boolean getIsRight() {
        return isRight;
    }

    public void setIsRight(Boolean isRight) {
        this.isRight = isRight;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}