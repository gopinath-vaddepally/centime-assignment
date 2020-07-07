package com.centime.assignment.tasktwo.dao;

import com.centime.assignment.tasktwo.pojo.RelationshipTableDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gvaddepally on 04/07/20
 */
@Repository
public interface RelationshipTableRepository extends JpaRepository<RelationshipTableDTO,Long> {
}
