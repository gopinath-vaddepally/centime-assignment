package com.centime.assignment.tasktwo.service;

import com.centime.assignment.tasktwo.dao.RelationshipTableRepository;
import com.centime.assignment.tasktwo.exception.AssignmentException;
import com.centime.assignment.tasktwo.pojo.RelationshipTableDTO;
import com.centime.assignment.tasktwo.utils.AssignmentUtilities;
import com.centime.assignment.tasktwo.utils.GraphNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.centime.assignment.tasktwo.utils.AssignmentUtilities.msg;

/**
 * @author gvaddepally on 04/07/20
 */
@Service
public class RelationshipTableServiceImpl implements  RelationshipTableService{

    private static final Logger logger = LoggerFactory.getLogger(RelationshipTableServiceImpl.class);

    @Autowired
    RelationshipTableRepository relationshipTableRepository;

    @Override
    public List<RelationshipTableDTO> insert(List<RelationshipTableDTO> relationshipTableDTOList) {
        try{
            return relationshipTableRepository.saveAll(relationshipTableDTOList);
        }catch (Exception ex){
            String message = msg("error occred while saving records due to {}",ex.getMessage());
            logger.error("error occred while saving records",ex);
            throw  new AssignmentException(message);
        }
    }

    @Override
    public GraphNode fetchById(long id) {
        GraphNode graphNode = new GraphNode();
        Optional<RelationshipTableDTO> optionalRelationshipTableDTO = relationshipTableRepository.findById(id);
        if(optionalRelationshipTableDTO.isPresent()){
            RelationshipTableDTO relationshipTableDTO = optionalRelationshipTableDTO.get();
            List<RelationshipTableDTO> relationshipTableDTOList = relationshipTableRepository.findAll();
            Map<Long, GraphNode> graphNodeMap = AssignmentUtilities.buildGraphNodes(relationshipTableDTOList);
            AssignmentUtilities.createRelationships(relationshipTableDTOList,graphNodeMap);
            graphNode = graphNodeMap.get(relationshipTableDTO.getId());
        }
        return graphNode;
    }

    @Override
    public Collection<GraphNode> fetchAll() {
        List<RelationshipTableDTO> relationshipTableDTOList = relationshipTableRepository.findAll();
        Map<Long, GraphNode> graphNodeMap = AssignmentUtilities.buildGraphNodes(relationshipTableDTOList);
        AssignmentUtilities.createRelationships(relationshipTableDTOList,graphNodeMap);
        return graphNodeMap.values();
    }

}
