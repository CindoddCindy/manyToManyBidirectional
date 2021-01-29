package manytomanybidirect.bidirectionalmanytomany.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDtos {
    private Integer id;
    private String name;
    private Set<String> schedulle = new HashSet<>();
}
