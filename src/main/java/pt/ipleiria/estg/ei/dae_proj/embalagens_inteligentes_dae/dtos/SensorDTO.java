package pt.ipleiria.estg.ei.dae_proj.embalagens_inteligentes_dae.dtos;

public class SensorDTO {

    private long id;
    private String name;


    public SensorDTO() {
    }

    public SensorDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
