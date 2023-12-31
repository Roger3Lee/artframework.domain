package com.artframework.domain.meta.domain;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * <related table="profile" many="false" fk="uuid:user_uuid"/>
 */
@Getter
public class RelatedTableMetaInfo {
    private String table;
    private Boolean many=false  ;
    private String fk;

    @XmlAttribute(name = "table")
    public void setTable(String table) {
        this.table = table;
    }

    @XmlAttribute(name = "many")
    public void setMany(Boolean many) {
        this.many = many;
    }

    @XmlAttribute(name = "fk")
    public void setFk(String fk) {
        this.fk = fk;
    }
}
