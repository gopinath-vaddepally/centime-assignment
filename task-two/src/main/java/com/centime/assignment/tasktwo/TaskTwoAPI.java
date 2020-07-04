package com.centime.assignment.tasktwo;

import com.centime.assignment.tasktwo.exception.AssignmentException;
import com.centime.assignment.tasktwo.pojo.RelationshipTableDTO;
import com.centime.assignment.tasktwo.pojo.ResponseDTO;
import com.centime.assignment.tasktwo.service.RelationshipTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.centime.assignment.tasktwo.utils.AssignmentUtilities.msg;

/**
 * @author gvaddepally on 04/07/20
 */
@RestController
@RequestMapping(value = "/api/v1/assignment/task2")
public class TaskTwoAPI {
    private static final Logger logger = LoggerFactory.getLogger(TaskTwoAPI.class);

    @Autowired
    private RelationshipTableService relationshipTableService;

    @PostMapping
    public ResponseEntity<List<RelationshipTableDTO>> insert(@RequestBody  List<RelationshipTableDTO> relationshipTableDTOS){
        try{
            List<RelationshipTableDTO> relationshipTableDTOList = relationshipTableService.insert(relationshipTableDTOS);
            return new ResponseEntity<List<RelationshipTableDTO>>(relationshipTableDTOList, HttpStatus.CREATED);
        }catch (AssignmentException ex){
            throw ex;
        }catch (Exception ex){
            String message = msg("Error occured while saving the records due to {} ",ex.getMessage());
            logger.error(message,ex);
            throw new AssignmentException(message,ex);
        }
    }

    public List<ResponseDTO> fetchById(@RequestParam long id){
        try{
            return relationshipTableService.fetchById(id);
        }catch (AssignmentException ex){
            throw ex;
        }catch (Exception ex){
            String message = msg("Error occured while fetching the records due to {} ",ex.getMessage());
            logger.error(message,ex);
            throw new AssignmentException(message,ex);
        }
    }
}
