package cn.qdgxy.tr.po;

import java.io.Serializable;
import java.util.Date;

public class Question implements Serializable {

    private Integer qid;

    private String problem;

    private String image;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private String rightOption;

    private String analysis;

    private String teachLink;

    private Boolean grade;

    private Date createTime;

    private Boolean isDel;

    private Integer cid;

    private static final long serialVersionUID = 1L;

    public Question(Integer qid, String problem, String image, String optionA, String optionB, String optionC, String optionD, String rightOption, String analysis, String teachLink, Boolean grade, Date createTime, Boolean isDel, Integer cid) {
        this.qid = qid;
        this.problem = problem;
        this.image = image;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.rightOption = rightOption;
        this.analysis = analysis;
        this.teachLink = teachLink;
        this.grade = grade;
        this.createTime = createTime;
        this.isDel = isDel;
        this.cid = cid;
    }

    public Question() {
        super();
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem == null ? null : problem.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA == null ? null : optionA.trim();
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB == null ? null : optionB.trim();
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC == null ? null : optionC.trim();
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD == null ? null : optionD.trim();
    }

    public String getRightOption() {
        return rightOption;
    }

    public void setRightOption(String rightOption) {
        this.rightOption = rightOption == null ? null : rightOption.trim();
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis == null ? null : analysis.trim();
    }

    public String getTeachLink() {
        return teachLink;
    }

    public void setTeachLink(String teachLink) {
        this.teachLink = teachLink == null ? null : teachLink.trim();
    }

    public Boolean getGrade() {
        return grade;
    }

    public void setGrade(Boolean grade) {
        this.grade = grade;
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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}