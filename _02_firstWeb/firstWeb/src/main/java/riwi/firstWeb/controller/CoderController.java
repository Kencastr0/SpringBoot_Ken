package riwi.firstWeb.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import riwi.firstWeb.entity.Coder;
import riwi.firstWeb.services.CoderService;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/coders")
public class CoderController {
    @Autowired
    private CoderService objCoderService;

    // Metodo para mostrar vista y enviar lista de coders

    @GetMapping
    public String showViewGetAll(Model objModel, @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "3") int size) {
        // LLamo el servicio y guardo la lista de coders
        Page<Coder> list = this.objCoderService.fingPaginated(page - 1, size);
        objModel.addAttribute("coderList", list); // Llave- valor
        objModel.addAttribute("currentPage", page); // Llave- valor
        objModel.addAttribute("totalPages", list.getTotalPages()); // Llave- valor
        System.out.println(list);

        // Se debe retornar el nombre exacto de la vista html
        return "viewCoder";
    }
    // @GetMapping("/form")
    // public String showViewGetAll(Model objModel) {
    //     // Llamo el servicio con la lista de coders
    //     List<Coder> list = this.objCoderService.findAll();
    //     System.out.println(list);
    //     objModel.addAttribute("CoderList", list);
    //     // Se retorna el nombre exacto de la vista HTML, ej: "viewCoder"
    //     return "viewCoder";
    // }

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
