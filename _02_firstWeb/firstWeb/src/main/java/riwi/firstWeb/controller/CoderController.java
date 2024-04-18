package riwi.firstWeb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import riwi.firstWeb.entity.Coder;
import riwi.firstWeb.services.CoderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/coders")
public class CoderController {
    @Autowired
    private CoderService objCoderService;

    // Metodo para mostrar vista y enviar lista de coders

    @GetMapping()
    public String showViewGetAll(Model objModel) {
        // Llamo el servicio con la lista de coders
        List<Coder> list = this.objCoderService.findAll();
        System.out.println(list);
        objModel.addAttribute("CoderList", list);
        // Se retorna el nombre exacto de la vista HTML, ej: "viewCoder"
        return "viewCoder";
    }

    @GetMapping("/viewInsert")
    public String showCreateView(Model objModel) {
        objModel.addAttribute("coder", new Coder());
        objModel.addAttribute("action", "/coders/insert");
        return "viewInsert";
    }

    @GetMapping("/viewUpdate/{id}")
    public String showUpdateView(@PathVariable Long id,Model objModel) {
        objModel.addAttribute("coder", objCoderService.findById(id));
        objModel.addAttribute("action", "/coders/update/"+id);
        return "viewUpdate";
    }

    @PostMapping("update/{id}")
    public String putMethodName(@PathVariable Long id, @ModelAttribute Coder coder, Model model) {
        Coder currentCoder = objCoderService.findById(id);

        currentCoder.setName(coder.getName());
        currentCoder.setAge(coder.getAge());
        currentCoder.setClan(coder.getClan());

        this.objCoderService.create(currentCoder);
        return "redirect:/coders";

    }

    @PostMapping("/insert")
    public String create(@ModelAttribute Coder objCoder) {
        this.objCoderService.create(objCoder);
        return "redirect:/coders";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        this.objCoderService.delete(id);
        return "redirect:/coders";
    }

}
