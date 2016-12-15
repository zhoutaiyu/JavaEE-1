package cn.qdgxy.tr.po;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 问题记录条目
 * </p>
 *
 * @author liXin
 * @since 2016-12-15
 */
@TableName("record_item")
public class RecordItem extends Model<RecordItem> {

    private static final long serialVersionUID = 1L;

    /**
     * 问题记录条目id
     */
    private Long id;
    /**
     * 题目id
     */
    private Integer qid;
    /**
     * 回答选项
     */
    private String answer;
    /**
     * 是否正确
     */
    @TableField(value = "right_option")
    private String rightOption;
    /**
     *
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
     * 章节ID
     */
    private Long cid;
    /**
     * 问题记录id
     */
    private Long rid;


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
        this.answer = answer;
    }

    public String getRightOption() {
        return rightOption;
    }

    public void setRightOption(String rightOption) {
        this.rightOption = rightOption;
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

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
