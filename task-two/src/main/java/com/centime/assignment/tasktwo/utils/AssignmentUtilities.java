package com.centime.assignment.tasktwo.utils;

import com.centime.assignment.tasktwo.pojo.RelationshipTableDTO;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gvaddepally on 04/07/20
 */
public class AssignmentUtilities {

    public static String msg(String msg, Object... args) {
        return MessageFormatter.arrayFormat(msg, args).getMessage();
    }

    public static void createRelationships(List<RelationshipTableDTO> relationshipTableDTOList, Map<Long, GraphNode> graphNodeMap) {
        relationshipTableDTOList.stream().forEach(relationshipTableDTO -> {
                    Long id = relationshipTableDTO.getId();
                    Long parentId = relationshipTableDTO.getParentId();
                    if (graphNodeMap.get(parentId) != null) {
                        GraphNode graphNode = graphNodeMap.get(parentId);
                        graphNode.getNeighbours().add(graphNodeMap.get(id));
                    }
                }
        );
    }

    public static Map<Long, GraphNode> buildGraphNodes(List<RelationshipTableDTO> relationshipTableDTOList) {
        Map<Long, GraphNode> graphNodeMap = new LinkedHashMap<>();
        for (RelationshipTableDTO relationshipTableDTO : relationshipTableDTOList) {
            GraphNode graphNode = new GraphNode()
                    .setRelationshipTableDTO(relationshipTableDTO)
                    .setVisited(false)
                    .setNeighbours(new ArrayList<>())
                    .setName(relationshipTableDTO.getName());
            graphNodeMap.put(relationshipTableDTO.getId(), graphNode);
        }
        return graphNodeMap;
    }
}
