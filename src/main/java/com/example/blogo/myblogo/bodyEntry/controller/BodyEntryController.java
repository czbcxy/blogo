package com.example.blogo.myblogo.bodyEntry.controller;

import com.example.blogo.myblogo.bodyEntry.dto.BodyEntry;
import com.example.blogo.myblogo.bodyEntry.services.BodyEntryServie;
import com.example.blogo.myblogo.utils.RetEntry;
import com.example.blogo.myblogo.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.UUID;

/**
 * @描述
 * @参数 $params$
 * @返回值 $return$
 * @创建人 czb
 * @创建时间 $date$
 * @修改人和其它信息
 */
@Controller
@RequestMapping("/body")
public class BodyEntryController {

    @Autowired
    private BodyEntryServie beServie;

    @RequestMapping(value = "request", method = RequestMethod.POST)
    @ResponseBody
    public RetEntry requestData(String pageSize) {
        if (StringUtils.isEmpty(pageSize)) {
            return beServie.queryBody(1, 5);
        }
        return beServie.queryBody(Integer.parseInt(pageSize), 5);
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public RetEntry insertData(BodyEntry bodyEntry) {
//        String jsondata = "[{\"table\":\"我是table\",\"body\":\"你好，我是内容我是内容\"},{\"table\":\"我是第二个table\",\"body\":\"我是第二个body\"},{\"table\":\"我是第三个table\",\"body\":\"我是第三个body\"},{\"table\":\"我是第四个table\",\"body\":\"我是第四个body\"}]";
        for (int i = 0; i < 100; i++) {
            bodyEntry.setBodyId(UUID.randomUUID().toString());
            bodyEntry.setCategory("java");
            bodyEntry.setCreatetime(new Date().toString());
            bodyEntry.setMainbody("我是主体");
            bodyEntry.setTitle("titlei" + i);
            bodyEntry.setStatus("0");
            bodyEntry.setLookCount(i);
            bodyEntry.setAuthor("czb" + i);
            beServie.insertData(bodyEntry);
        }
        return beServie.insertData(bodyEntry);
    }

    /**
     * 添加分类
     */
    @RequestMapping(value = "saveTopic", method = RequestMethod.POST)
    @ResponseBody
    public RetEntry saveTopic(String topic) {
        if (!StringUtils.isEmpty(topic)) {
            return beServie.saveTopic(topic);
        }
        return new RetEntry("500");
    }

    @RequestMapping(value = "topic")
    @ResponseBody
    public RetEntry topic() {
        return beServie.findall();
    }

}
