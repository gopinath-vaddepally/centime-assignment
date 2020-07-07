package com.centime.assignment.tasktwo.service;

import com.centime.assignment.tasktwo.pojo.RelationshipTableDTO;
import com.centime.assignment.tasktwo.utils.GraphNode;

import java.util.Collection;
import java.util.List;

/**
 * @author gvaddepally on 04/07/20
 */
public interface RelationshipTableService {
    List<RelationshipTableDTO> insert(List<RelationshipTableDTO> relationshipTableDTOList);
    GraphNode fetchById(long id);
    Collection<GraphNode> fetchAll();
}
