package com.centime.assignment.tasktwo.utils;

import com.centime.assignment.tasktwo.pojo.RelationshipTableDTO;
import com.fasterxml.jackson.annotation.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GraphNode {
    private String Name;
    @JsonIgnore
    private RelationshipTableDTO relationshipTableDTO;
    @JsonIgnore
    private boolean visited = false;
    @JsonProperty("Sub Classes")
    private List<GraphNode> neighbours;
    @JsonIgnore
    private GraphNode parent;

    public RelationshipTableDTO getRelationshipTableDTO() {
        return relationshipTableDTO;
    }

    public GraphNode setRelationshipTableDTO(RelationshipTableDTO relationshipTableDTO) {
        this.relationshipTableDTO = relationshipTableDTO;
        return this;
    }

    public boolean isVisited() {
        return visited;
    }

    public GraphNode setVisited(boolean visited) {
        this.visited = visited;
        return this;
    }

    public List<GraphNode> getNeighbours() {
        return neighbours;
    }

    public GraphNode setNeighbours(List<GraphNode> neighbours) {
        this.neighbours = neighbours;
        return this;
    }

    public GraphNode getParent() {
        return parent;
    }

    public GraphNode setParent(GraphNode parent) {
        this.parent = parent;
        return this;
    }

    public String getName() {
        return Name;
    }

    public GraphNode setName(String name) {
        Name = name;
        return this;
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "Name='" + Name + '\'' +
                ", relationshipTableDTO=" + relationshipTableDTO +
                ", visited=" + visited +
                ", neighbours=" + neighbours +
                ", parent=" + parent +
                '}';
    }
}
