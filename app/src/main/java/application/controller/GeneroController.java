package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.GeneroRepository;
import application.model.Genero;

@Controller
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepo;

    @RequestMapping("/genero")
    public String listGenero(Model model) {
        model.addAttribute("generos", generoRepo.findAll());
        return "WEB-INF/genero/listGenero.jsp";
    }

    @RequestMapping("/insertGenero")
    public String insertGenero() {
        return "WEB-INF/genero/insertGenero.jsp";
    }

    @RequestMapping(value = "/insertGenero", method = RequestMethod.POST)
    public String insertGenero(@RequestParam("nome") String nome) {
        Genero genero = new Genero();
        genero.setNome(nome);
        generoRepo.save(genero);
        return "redirect:/listGenero";
    }

    @RequestMapping("/updateGenero")
    public String updateGenero(Model model, @RequestParam("id") int id) {
        Optional<Genero> genero = generoRepo.findById(id);

        if(!genero.isPresent()) {
            return "redirect:/genero";
        }

        model.addAttribute("genero", genero.get());
        return "WEB-INF/genero/updateGenero.jsp";
    }

    @RequestMapping(value = "/updateGenero", method = RequestMethod.POST)
    public String updateGenero(
        @RequestParam("nome") String nome,
        @RequestParam("id") int id
    ) {
        Optional<Genero> genero = generoRepo.findById(id);
        if(!genero.isPresent()) {
            return "redirect:/genero";
        }

        genero.get().setNome(nome);
        
        generoRepo.save(genero.get());
        return "redirect:/genero";
    }

    @RequestMapping("/deleteGenero")
    public String deleteGenero(Model model, @RequestParam("id") int id) {
        Optional<Genero> genero = generoRepo.findById(id);

        if(!genero.isPresent()) {
            return "redirect:/genero";
        }

        model.addAttribute("genero", genero.get());
        return "WEB-INF/genero/deleteGenero.jsp";
    }

    @RequestMapping(value = "/deleteGenero", method = RequestMethod.POST)
    public String deleteGenero(@RequestParam("id") int id) {
        generoRepo.deleteById(id);
        return "redirect:/genero";
    }
}
