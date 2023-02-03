package com.golden.examen.Controller;

import org.springframework.http.HttpStatus;
import com.golden.examen.repos.tagRepository;
import com.golden.examen.model.tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/proj_AR")
public class tagController {
    @Autowired
    private tagRepository tagrepos;
    @GetMapping("get")
    List<tag> index(){
        return tagrepos.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("post")
    tag create(@RequestBody tag Tag){
        return tagrepos.save(Tag);
    }

    @PutMapping("{id}")
    tag update(@PathVariable String id,@RequestBody tag Tag){
        tag tagFromDb=tagrepos.findById(id).orElseThrow(RuntimeException::new);

        tagFromDb.setEmail(Tag.getEmail());
        tagFromDb.setActive(Tag.getActive());
        tagFromDb.setPhone(Tag.getPhone());
        tagFromDb.setCreatedAt(Tag.getCreatedAt());
        tagFromDb.setTag(Tag.getTag());
        tagFromDb.setMailPass(Tag.getMailPass());
        tagFromDb.setCountryPhone(Tag.getCountryPhone());
       return tagrepos.save(tagFromDb);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable String id){
        tag Tags=tagrepos.findById(id).orElseThrow(RuntimeException::new);

        tagrepos.delete(Tags);
    }
}
