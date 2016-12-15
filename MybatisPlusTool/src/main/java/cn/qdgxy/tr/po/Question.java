package cn.qdgxy.tr.po;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 问题
 * </p>
 *
 * @author liXin
 * @since 2016-12-15
 */
public class Question extends Model<Question> {

    private static final long serialVersionUID = 1L;

    /**
     * 问题id
     */
    private Long id;
    /**
     * 问题描述
     */
    private String problem;
    /**
     * 问题图片
     */
    private String image;
    /**
     * 选项A
     */
    @TableField(value = "option_a")
    private String optionA;
    /**
     * 选项B
     */
    @TableField(value = "option_b")
    private String optionB;
    /**
     * 选项C
     */
    @TableField(value = "option_c")
    private String optionC;
    /**
     * 选项D
     */
    @TableField(value = "option_d")
    private String optionD;
    /**
     * 正确选项
     */
    @TableField(value = "right_option")
    private String rightOption;
    /**
     * 问题分析
     */
    private String analysis;
    /**
     * 问题教学链接
     */
    @TableField(value = "teach_link")
    private String teachLink;
    /**
     * 问题等级，1-5，5最高
     */
    private Integer grade;
    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;
    /**
     *
     */
    @TableField(value = "modified_time")
    private Date modifiedTime;
    /**
     * 是否删除
     */
    @TableField(value = "is_del")
    private Integer isDel;
    /**
     * 章节id
     */
    private Long cid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getRightOption() {
        return rightOption;
    }

    public void setRightOption(String rightOption) {
        this.rightOption = rightOption;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getTeachLink() {
        return teachLink;
    }

    public void setTeachLink(String teachLink) {
        this.teachLink = teachLink;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
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

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
