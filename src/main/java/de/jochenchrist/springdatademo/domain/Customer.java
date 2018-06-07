package de.jochenchrist.springdatademo.domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(indexes = {@Index(columnList = "emailAddress")})
public class Customer {

    @Id
    String id;

    String sapCustomerId;

    @Size(max = 40)
    @Column(length = 40)
    String name;

    String emailAddress;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<Address> addresses;

    @Temporal(TemporalType.DATE)
    Date birthday;

    @Enumerated(EnumType.STRING)
    Status status;

    @Embedded
    Scoring scoring;

    public String getNameNormalized() {
        if(name == null) {
            return null;
        }
        return name.toLowerCase();
    }

}
