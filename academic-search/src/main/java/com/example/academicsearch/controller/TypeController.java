package com.example.academicsearch.controller;

import com.example.academicsearch.model.Type;
import com.example.academicsearch.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TypeController {
    private TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/types")
    public ResponseEntity<List<Type>> getAll() {
        return ResponseEntity.ok(typeService.findAllTypes());
    }

    @PostMapping("/types")
    public ResponseEntity<Type> save(@RequestBody Type type) {
        return ResponseEntity.ok(typeService.save(type));
    }

    @DeleteMapping("/types/{id}")
    public String delete(@PathVariable Long id) {
        typeService.deleteById(id);
        return "type with "+id+" deleted";
    }
}
