package fi.academy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class Kontrolleri {


    @Autowired
    CountryRepository cr;

    @RequestMapping("/Capital")
    public String palautaPaakaupunki(Model model) {
        model.addAttribute("capitals", cr.findAll());
        return "countryCity";
    }

    @RequestMapping(value = "/sivutus", params = {"page", "size"})
    public String palautaSivut(Model model, @RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "name");
        model.addAttribute("capitals", cr.findAll(pageable));
        return "countryCity";
    }
    private int nykyinensivu;
    @RequestMapping (value = "/seuraavasivu")
    public String vaihdaSivua(Model model)  {
                Pageable next = PageRequest.of(++nykyinensivu, 20, Sort.Direction.ASC, "name");
            Page <Country> sivu = cr.findAll(next);
        model.addAttribute("capitals", sivu);
            return "countryCity";
    }

    @RequestMapping (value = "/edellinensivu")
    public String edellinenSivu(Model model)  {
        Pageable previous = PageRequest.of(--nykyinensivu, 20, Sort.Direction.ASC, "name");
        Page <Country> sivu = cr.findAll(previous);
        model.addAttribute("capitals", sivu);
        return "countryCity";
    }

    @GetMapping("sivut")
    public String naytaMaat (Pageable pageable, Model model) {
        Page <Country> sivu = cr.findAll(pageable);
        model.addAttribute("sivu", sivu);
        return "countryCity";
    }



//luontiJoukolla - cascade täytyy olla persist
    //

}
