package cn.qdgxy.tr.po;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 答题记录
 * </p>
 *
 * @author liXin
 * @since 2016-12-15
 */
public class Record extends Model<Record> {

    private static final long serialVersionUID = 1L;

    /**
     * 答题记录id
     */
    private Long id;
    /**
     * 答题记录状态，0未完成，1完成
     */
    private Integer status;
    /**
     * 答题数目
     */
    @TableField(value = "answer_number")
    private Integer answerNumber;
    /**
     * 正确数目
     */
    @TableField(value = "right_number")
    private Integer rightNumber;
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
     * 所属用户
     */
    private Long uid;


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

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
