package fi.academy;

import javax.persistence.*;
import java.util.List;

@Entity
public class Country {      //tämä luokka pitää olla samanniminen kuin db:stä löytyy (ei esim. countryEntity) ="Country")
    @Id @Column                    //TAI laittaa @Entityn jälkeen @Table(name="Country")
    private String code;
    private String name;
    private String localname;
    private Integer population;
    private Integer indepyear;      //jos olisi indepYear, etsisi taulusta saraketta indep_year, jota ei ole. Vaihtoehto @Column(name="indepyear")
    private String headofstate;

    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name ="capital")        //hipsuissa oleva sana määrää muuttujan nimen, joka pitää olla sama kuin taulussa
    private City capital;



    public Country() {
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalname() {
        return localname;
    }

    public void setLocalname(String localname) {
        this.localname = localname;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getIndepyear() {
        return indepyear;
    }

    public void setIndepyear(Integer indepyear) {
        this.indepyear = indepyear;
    }

    public String getHeadofstate() {
        return headofstate;
    }

    public void setHeadofstate(String headofstate) {
        this.headofstate = headofstate;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

}
