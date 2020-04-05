package com.ggastudios.urano.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class AppBean implements BaseBean {

    private String id;
    private String name;
    private String description;
    private String version;
    private String owner;

}
