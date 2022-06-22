package com.example.academicsearch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Researcher {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    @Relationship(type = "PUBLICATION WRITER", direction = Relationship.Direction.INCOMING)
    private List<Publication> publications;
    //@Relationship(type = "WORKING TOGETHER", direction = Relationship.Direction.INCOMING)
    //private List<String> researchers;
}
