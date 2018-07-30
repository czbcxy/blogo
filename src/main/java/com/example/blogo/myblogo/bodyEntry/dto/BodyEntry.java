package com.example.blogo.myblogo.bodyEntry.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @描述
 * @参数 $params$
 * @返回值 $return$
 * @创建人 czb
 * @创建时间 $date$
 * @修改人和其它信息
 */
@Entity
@Table(name = "BodyEntryTbl")
public class BodyEntry implements Serializable {

    @Id
    @Column(name = "BodyId",length = 225)
    private String BodyId;
    //分类
    @Column(name = "category", nullable = false, length = 225)
    private String category;
    //创建时间
    @Column(name = "createtime", nullable = false, length = 225)
    private String createtime;
    //作者
    @Column(name = "author", nullable = false, length = 225)
    private String author;
    //标题
    @Column(name = "title", nullable = false, length = 225)
    private String title;
    //正文
    @Column(name = "mainbody", nullable = false, length = 225)
    private String mainbody;

    //浏览量
    @Column(name = "",nullable = false,length = 225)
    private Integer lookCount;

    //状态
    @Column(name = "status",  nullable = false, length = 225)
    private String status;

    public Integer getLookCount() {
        return lookCount;
    }

    public void setLookCount(Integer lookCount) {
        this.lookCount = lookCount;
    }

    @Override
    public String toString() {
        return "BodyEntry{" +
                "BodyId='" + BodyId + '\'' +
                ", category='" + category + '\'' +
                ", createtime=" + createtime +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", mainbody='" + mainbody + '\'' +
                ", lookCount=" + lookCount +
                ", status='" + status + '\'' +
                '}';
    }

    public BodyEntry(String bodyId, String category, String createtime, String author, String title, String mainbody, Integer lookCount, String status) {
        BodyId = bodyId;
        this.category = category;
        this.createtime = createtime;
        this.author = author;
        this.title = title;
        this.mainbody = mainbody;
        this.lookCount = lookCount;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BodyEntry() {
    }

    public BodyEntry(String bodyId, String category, String createtime, String author, String title, String mainbody) {
        BodyId = bodyId;
        this.category = category;
        this.createtime = createtime;
        this.author = author;
        this.title = title;
        this.mainbody = mainbody;
    }

    public String getBodyId() {
        return BodyId;
    }

    public void setBodyId(String bodyId) {
        BodyId = bodyId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainbody() {
        return mainbody;
    }

    public void setMainbody(String mainbody) {
        this.mainbody = mainbody;
    }

}
