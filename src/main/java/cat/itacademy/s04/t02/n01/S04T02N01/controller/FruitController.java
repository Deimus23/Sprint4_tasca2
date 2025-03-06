package cat.itacademy.s04.t02.n01.S04T02N01.controller;

import cat.itacademy.s04.t02.n01.S04T02N01.exception.FruitNotFoundException;
import cat.itacademy.s04.t02.n01.S04T02N01.model.Fruit;
import cat.itacademy.s04.t02.n01.S04T02N01.repository.FruitRepository;
import cat.itacademy.s04.t02.n01.S04T02N01.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
public class FruitController {
    private final FruitService service;
public FruitController(FruitService service ){
    this.service=service;
}
    @PostMapping("/fruit/add")
    public ResponseEntity<Fruit> add(@RequestParam(defaultValue = "UNKNOWN")String name,@RequestParam(defaultValue = "0")int kilos){
      Fruit fruit=service.addFruit(name,kilos);
      return ResponseEntity.ok(fruit);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>>getAll(){
    return  ResponseEntity.ok(service.getAllFruits());
    }
    @Autowired
    private FruitRepository fruitRepository;
    @PutMapping("/update")
    public ResponseEntity<Fruit> updateFruit(@RequestBody Fruit fruit) throws URISyntaxException {
        if (fruit.getId() == 0) {
            throw new FruitNotFoundException("Fruit not found with id: " + fruit.getId());
        }
        Fruit updatedFruit = service.updateFruit(fruit);
        return ResponseEntity.ok().body(updatedFruit);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseEntity<String>> deleteFruit(@PathVariable("id")Long id){
        return ResponseEntity.ok(service.deleteFruit(id));
    }
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getOne(@PathVariable Long id) {
        return service.getOne(id);
    }
    }

