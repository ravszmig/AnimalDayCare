package pl.animaldaycare.ravsky.animaldaycare.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.request.AnimalRequest;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.response.AnimalResponse;
import pl.animaldaycare.ravsky.animaldaycare.service.AnimalService;

@RestController
@RequestMapping("api/v1/animals")
public class AnimalController {

    final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PutMapping("/new")
    public ResponseEntity<Long> newAnimal(@RequestBody AnimalRequest animalRequest) {
       return new ResponseEntity<>(animalService.saveAnimal(animalRequest), HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<AnimalResponse> getAnimal(@PathVariable Long id) {
        return new ResponseEntity<>(animalService.getAnimal(id), HttpStatus.OK);
    }

}
