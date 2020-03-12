package com.ggastudios.urano.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;


//import javax.persistence.PrePersist;
//import javax.persistence.PreUpdate;
import java.util.Calendar;

@Data
@EqualsAndHashCode
@Document(collection = "user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEntity implements BaseEntity {

    @Id
    private String id;
    private Calendar dateStart;
    private Calendar dateUpdate;
    @UniqueElements
    private String email;
    private boolean emailConfirmado;
    private String facebookId;
    private String idioma;
    private String name;
    private String pais;

}
