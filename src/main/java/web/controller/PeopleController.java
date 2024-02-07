package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    private PersonDao personDao;
    @GetMapping()
    public String index1(Model model){ // получаем список пользователей
        model.addAttribute("people", personDao.index1());
        return  "people/index1";
    }
    @GetMapping("/{id}") // получаем пользователя по ID
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDao.show(id));
        return "people/show";
    }
    @GetMapping("/new") //форма для ввода данных нового пользователя
    public String newPerson(@ModelAttribute("person")Person person) {
        return "people/new";
    }
    @PostMapping() // добавление нового пользователя
    public String creat(@ModelAttribute("person") Person person) {
        personDao.save(person);
        return "redirect:/people"; // перенаправление на страницу со списком пользователей
    }
    @GetMapping("/{id}/edit")  // редактирование пользователя по id
    public  String edit(Model model, @PathVariable("id") int id) { // получение id из параметров
        model.addAttribute("person", personDao.show(id));
        return "people/edit";
    }
    @PatchMapping("/{id}")  // обнавление пользователя
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
        personDao.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}") // удаление пользователя
    public String delete(@PathVariable("id") int id) {
        personDao.delete(id);
        return "/people";
    }
}
