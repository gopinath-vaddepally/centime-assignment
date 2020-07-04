package com.centime.assignment.tasktwo.service;

import com.centime.assignment.tasktwo.pojo.RelationshipTableDTO;
import com.centime.assignment.tasktwo.pojo.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gvaddepally on 04/07/20
 */
public interface RelationshipTableService {
    List<RelationshipTableDTO> insert(List<RelationshipTableDTO> relationshipTableDTOList);
    List<ResponseDTO> fetchById(long id);
    List<ResponseDTO> fetchAll();
}
