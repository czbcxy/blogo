package com.example.blogo.myblogo.bodyEntry.dao;

import com.example.blogo.myblogo.bodyEntry.dto.BodyEntry;
import com.example.blogo.myblogo.bodyEntry.dto.TopicTypeEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @描述
 * @参数 $params$
 * @返回值 $return$
 * @创建人 czb
 * @创建时间 $date$
 * @修改人和其它信息
 */
@Repository
@Transactional
public interface TopicEntryDao extends JpaRepository<TopicTypeEntry, String> {

}
