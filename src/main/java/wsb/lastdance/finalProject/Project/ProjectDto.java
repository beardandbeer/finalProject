package wsb.lastdance.finalProject.Project;



import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Builder
@Data
public class ProjectDto {
    private Long id;
    @NotEmpty(message = "Nazwa nie powinna być pusta")
    private String name;
    @NotEmpty(message = "Cod nie powinna być pusty")
    private String code;
    @NotEmpty(message = "Opis nie powinna być pusta")
    private String description;
    private Boolean enabled;
    private Date dateCreated;

  /*  public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "creator_id" ,nullable = false)
    private Person creator;

     */
}

