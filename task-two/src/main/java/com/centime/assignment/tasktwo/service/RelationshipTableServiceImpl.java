package com.centime.assignment.tasktwo.service;

import com.centime.assignment.tasktwo.dao.RelationshipTableRepository;
import com.centime.assignment.tasktwo.exception.AssignmentException;
import com.centime.assignment.tasktwo.pojo.RelationshipTableDTO;
import com.centime.assignment.tasktwo.pojo.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<ResponseDTO> fetchById(long id) {
        Optional<RelationshipTableDTO> optionalRelationshipTableDTO = relationshipTableRepository.findById(id);
        if(optionalRelationshipTableDTO.isPresent()){
            RelationshipTableDTO relationshipTableDTO = optionalRelationshipTableDTO.get();
            List<RelationshipTableDTO> subClassesList = relationshipTableRepository.findByParentId(relationshipTableDTO.getParentid());
            new ResponseDTO()
                    .setName(relationshipTableDTO.getName())
                    .setSubClasses(subClassesList.stream().map(relationshipTableDTO1 -> {
                        return new ResponseDTO()
                                .setName(relationshipTableDTO1.getName());
                    }).collect(Collectors.toList()));
        }
        return null;
    }

    @Override
    public List<ResponseDTO> fetchAll() {
        return null;
    }
}
