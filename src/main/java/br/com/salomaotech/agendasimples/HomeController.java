package br.com.salomaotech.agendasimples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    AgendaRepository agendaRepository;

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/cadastrar")
    public String cadastrarForm(Model modelo){
        modelo.addAttribute("agenda", new Agenda());
        return "cadastrarForm";
    }

    @RequestMapping("/listar")
    public String listar(Model modelo){

        modelo.addAttribute("agendas", agendaRepository.findAll());

        return "listar";
    }

    @PostMapping("/process")
    public String processForm(Agenda agenda){
        agendaRepository.save(agenda);
        return "redirect:/listar";

    }

}
