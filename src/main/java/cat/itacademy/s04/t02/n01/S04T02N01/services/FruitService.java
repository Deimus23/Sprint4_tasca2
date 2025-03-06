package cat.itacademy.s04.t02.n01.S04T02N01.services;

import cat.itacademy.s04.t02.n01.S04T02N01.exception.GlobalExceptionHandler;
import cat.itacademy.s04.t02.n01.S04T02N01.model.Fruit;
import cat.itacademy.s04.t02.n01.S04T02N01.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService{
    private final FruitRepository repository;
    public FruitService (FruitRepository repository){
        this.repository=repository;
    }

    public Fruit addFruit(String name, int kilos){
        Fruit fruit = new Fruit( kilos,name);
       return repository.save(fruit);
    }
    public List<Fruit>getAllFruits(){
        return repository.findAll();
    }
    @Autowired
    private FruitRepository fruitRepository;

    public Fruit updateFruit(Fruit fruit) {

        Optional<Fruit> existingFruit = fruitRepository.findById(fruit.getId());

        if (existingFruit.isPresent()) {
            Fruit updatedFruit = existingFruit.get();
            updatedFruit.setName(fruit.getName());
            updatedFruit.setKilosQuantity(fruit.getKilosQuantity());
            return fruitRepository.save(updatedFruit);
        } else {
            throw new RuntimeException("Fruit not found with id: " + fruit.getId());
        }
    }
    public ResponseEntity<String> deleteFruit(Long id) {
        if (fruitRepository.existsById(id)) {
            fruitRepository.deleteById(id);
            return ResponseEntity.ok("Fruit with ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fruit with ID " + id + " not found.");
        }
    }
    public ResponseEntity<Fruit> getOne(Long id) {
        return fruitRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
