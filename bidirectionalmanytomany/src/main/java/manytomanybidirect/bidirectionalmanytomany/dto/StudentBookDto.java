package manytomanybidirect.bidirectionalmanytomany.dto;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentBookDto {

    private Integer id;
    private String name;
    private Set<String> books = new HashSet<>();


}
