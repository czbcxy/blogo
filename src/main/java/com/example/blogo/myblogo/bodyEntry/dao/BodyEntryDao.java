package com.example.blogo.myblogo.bodyEntry.dao;

import com.example.blogo.myblogo.bodyEntry.dto.BodyEntry;
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
public interface BodyEntryDao extends JpaRepository<BodyEntry, String> {

    String findsql1 = "select * from Body_Entry_tbl as a  order by a.createtime desc limit ?1 , ?2";

    @Query(value = findsql1, nativeQuery = true)
    List<BodyEntry> findAllSortOrder(@Param("pageSize") int pageSize, @Param("currentSize") int currentSize);
}
