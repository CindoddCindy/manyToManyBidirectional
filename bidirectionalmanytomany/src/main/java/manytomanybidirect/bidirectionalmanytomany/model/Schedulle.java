package manytomanybidirect.bidirectionalmanytomany.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SCHEDULLE")
public class Schedulle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schedulle_sequence")
    @SequenceGenerator(name = "schedulle_sequence", sequenceName = "schedulle_sequence")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "schedulles")
    @JsonIgnore
    private Set<Student> students;
}
