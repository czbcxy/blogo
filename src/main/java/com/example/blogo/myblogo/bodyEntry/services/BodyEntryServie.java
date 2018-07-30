package com.example.blogo.myblogo.bodyEntry.services;

import com.example.blogo.myblogo.bodyEntry.dao.BodyEntryDao;
import com.example.blogo.myblogo.bodyEntry.dao.TopicEntryDao;
import com.example.blogo.myblogo.bodyEntry.dto.BodyEntry;
import com.example.blogo.myblogo.bodyEntry.dto.TopicTypeEntry;
import com.example.blogo.myblogo.utils.RetEntry;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Predicate;

/**
 * @描述
 * @参数 $params$
 * @返回值 $return$
 * @创建人 czb
 * @创建时间 $date$
 * @修改人和其它信息
 */
@Service
public class BodyEntryServie {

    @Autowired
    private BodyEntryDao bodyEntryDao;
    @Autowired
    private TopicEntryDao topicEntryDao;

    public RetEntry queryBody(int pageSize, int currentPage) {
        RetEntry retEntry = new RetEntry();
        try {
            long totalount = bodyEntryDao.count();
            if (totalount > 0) {
                List<BodyEntry> allSortOrder = bodyEntryDao.findAllSortOrder(pageSize * currentPage - 1, currentPage);
                for (int i = 0; i < allSortOrder.size(); i++) {
                    allSortOrder.get(i).setCreatetime(allSortOrder.get(i).getCreatetime().substring(0, 10));
                }
                retEntry.setRetList(allSortOrder);
                retEntry.setTotalCount((int) totalount);
            } else {
                retEntry.setTotalCount(0);
            }
            retEntry.setStatus("200");
        } catch (Exception e) {
            retEntry.setStatus("500");
        }
        return retEntry;
    }

    public RetEntry insertData(BodyEntry bodyEntry) {
        RetEntry retEntry = new RetEntry();
        try {
            bodyEntryDao.save(bodyEntry);
            retEntry.setStatus("200");
        } catch (Exception e) {
            retEntry.setStatus("500");
            e.printStackTrace();
        }
        return retEntry;
    }

    public RetEntry saveTopic(String topic) {

        HashMap<String, String> map = new HashMap<>();
        map.put("java".hashCode() + "", "java");
        map.put("c++".hashCode() + "", "c++");
        map.put("python".hashCode() + "", "python");
        map.put("html".hashCode() + "", "html");
        map.put("javascript".hashCode() + "", "javascript");
        map.put("vb".hashCode() + "", "vb");
        map.put("go".hashCode() + "", "go");
        map.put("vue".hashCode() + "", "vue");


        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        RetEntry retEntry = new RetEntry();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            String key = next.getKey();
            String value = next.getValue();
            TopicTypeEntry topicTypeEntry = new TopicTypeEntry();
            topicTypeEntry.setTopicId(UUID.randomUUID().toString().substring(0, 16));
            topicTypeEntry.setAsnum(key);
            topicTypeEntry.setTopic(value);
            topicEntryDao.save(topicTypeEntry);
            retEntry.setStatus("200");
        }
        return retEntry;

//        TopicTypeEntry topicTypeEntry = new TopicTypeEntry();
//        RetEntry retEntry = new RetEntry();
//        topicTypeEntry.setTopicId(UUID.randomUUID().toString().substring(0, 16));
//        topicTypeEntry.setAsnum(String.valueOf(topic.hashCode()));
//        topicTypeEntry.setTopic(topic);
//        topicEntryDao.save(topicTypeEntry);
//        retEntry.setStatus("200");
//        return retEntry;
    }

    public RetEntry findall() {
        List<TopicTypeEntry> all = topicEntryDao.findAll();
        return new RetEntry("200", all, 0, 0);
    }
}
