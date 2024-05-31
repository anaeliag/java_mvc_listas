package org.bedu.todo.controller;

import org.bedu.todo.entity.Task;
import org.bedu.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @GetMapping
    public String index(Model model) {
        //obtener la lista de todas las tareas en la base de datos
        model.addAttribute("list", repository.findAll());
        //tarea vacia para rellenar con la informacion del formulario
        model.addAttribute("task", new Task());
        return "index.html";
    }

    @PostMapping("guardar")
    public String save(@ModelAttribute("task") Task data){
        //System.out.println("Description: " + data.getDescription());
        repository.save(data);
        return "redirect:/";
    }

    @PostMapping("eliminar")
    public String delete(@ModelAttribute("task") Task data){
        System.out.println("Description: " + data.getId());
        repository.deleteById(data.getId());
        return "redirect:/";
    }
    
}