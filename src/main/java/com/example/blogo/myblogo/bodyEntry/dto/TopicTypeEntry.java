package com.example.blogo.myblogo.bodyEntry.dto;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @描述
 * @参数 $params$
 * @返回值 $return$
 * @创建人 czb
 * @创建时间 $date$
 * @修改人和其它信息
 */
@Table(name = "TopicTypeEntry")
@Entity
@Component
public class TopicTypeEntry {
    @Id
    private String topicId;

    @Column(name = "asnum" ,length = 225)
    private String asnum;

    @Column(name = "topic" ,length = 225)
    private String topic;

    public String getAsnum() {
        return asnum;
    }

    public void setAsnum(String asnum) {
        this.asnum = asnum;
    }

    @Override
    public String toString() {
        return "TopicTypeEntry{" +
                "topicId='" + topicId + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
