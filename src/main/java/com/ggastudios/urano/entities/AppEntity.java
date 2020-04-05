package com.ggastudios.urano.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@EqualsAndHashCode
@Document(collection = "application")
public class AppEntity implements BaseEntity {

    @Id
    private String id;
    private String name;
    private String description;
    private String version;
    private String owner;
    private String startDate;
    private String updateDate;

}

