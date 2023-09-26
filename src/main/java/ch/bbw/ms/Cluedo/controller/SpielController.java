package ch.bbw.ms.Cluedo.controller;


import ch.bbw.ms.Cluedo.model.*;
import ch.bbw.ms.Cluedo.service.SpielService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class SpielController {
    private SpielService spielService = new SpielService();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/start")
    public String startSpiel(Model model) {
        List<Verdachtiger> verdachtige = Arrays.asList(
                new Verdachtiger("Sherlock", "/bilder/Sherlock.jpg"),
                new Verdachtiger("Watson", "/bilder/watson.jpg"),
                new Verdachtiger("Ahmed", "/bilder/Ahmed.jpg"),
                new Verdachtiger("Zaki", "/bilder/Zaki.jpg")
        );
        List<Waffe> waffen = Arrays.asList(
                new Waffe("Pistole", "/bilder/pistole.jpg"),
                new Waffe("Messer", "/bilder/messer.jpg")
        );
        List<Zimmer> zimmer = Arrays.asList(
                new Zimmer("Wohnzimmer", "/bilder/wohnzimmer.jpg"),
                new Zimmer("Küche", "/bilder/kueche.jpg")
        );

        spielService.startNeuesSpiel(verdachtige, waffen, zimmer);

        model.addAttribute("spiel", spielService.getAktuellesSpiel());
        String geschichte = spielService.generiereGeschichte();
        model.addAttribute("geschichte", geschichte);

        return "spiel";
    }

    @PostMapping("/vermutung")
    public String verarbeiteVermutung(@RequestParam String verdachtiger, @RequestParam String waffe,
            @RequestParam String zimmer, Model model) {
        ch.bbw.ms.Cluedo.model.VermutungErgebnis ergebnis = spielService.pruefeVermutung(verdachtiger, waffe,
                zimmer);

        String nachricht = "Hinweise: ";
        if (ergebnis.isVerdachtigerRichtig()) {
            nachricht += "Der Verdächtige ist korrekt! ";
        } else {
            nachricht += "Der Verdächtige ist falsch. ";
        }

        if (ergebnis.isWaffeRichtig()) {
            nachricht += "Die Waffe ist korrekt! ";
        } else {
            nachricht += "Die Waffe ist falsch. ";
        }

        if (ergebnis.isZimmerRichtig()) {
            nachricht += "Das Zimmer ist korrekt! ";
        } else {
            nachricht += "Das Zimmer ist falsch. ";
        }

        model.addAttribute("nachricht", nachricht);
        model.addAttribute("spiel", spielService.getAktuellesSpiel());

        model.addAttribute("ausgewaehlterVerdachtiger", verdachtiger);
        model.addAttribute("ausgewaehlteWaffe", waffe);
        model.addAttribute("ausgewaehltesZimmer", zimmer);

        if (spielService.getAktuellesSpiel().isMehrspielerModus()) {
            spielService.wechsleSpieler();
        }

        model.addAttribute("spiel", spielService.getAktuellesSpiel());
        model.addAttribute("gewinner", spielService.getGewinner());

        return "spiel";

    }

    @GetMapping("/mehrspielerStart")
    public String starteMehrspielerModus(Model model) {
        spielService.starteMehrspielerModus();
        model.addAttribute("spiel", spielService.getAktuellesSpiel());

        model.addAttribute("spiel", spielService.getAktuellesSpiel());
        String geschichte = spielService.generiereGeschichte();
        model.addAttribute("geschichte", geschichte);
        return "spiel";
    }

    @GetMapping("/einzelspielerStart")
    public String starteEinzelspielerModus(Model model) {
        spielService.beendeMehrspielerModus();
        model.addAttribute("spiel", spielService.getAktuellesSpiel());
        
        model.addAttribute("spiel", spielService.getAktuellesSpiel());
        String geschichte = spielService.generiereGeschichte();
        model.addAttribute("geschichte", geschichte);
        return "spiel";
    }

}
