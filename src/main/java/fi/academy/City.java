package fi.academy;



import javax.persistence.*;

@Entity
public class City {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    @OneToOne (mappedBy = "capital")
    public Country tahanKaupunkiinViittaavaMaa;

    private String name;
    private Integer population;
    private String district;



    public City() {
    }

    public Country getTahanKaupunkiinViittaavaMaa() {
        return tahanKaupunkiinViittaavaMaa;
    }

    public void setTahanKaupunkiinViittaavaMaa(Country tahanKaupunkiinViittaavaMaa) {
        this.tahanKaupunkiinViittaavaMaa = tahanKaupunkiinViittaavaMaa;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
