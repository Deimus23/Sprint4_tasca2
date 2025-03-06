package cat.itacademy.s04.t02.n01.S04T02N01.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"fruits\"")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "kilos_quantity", nullable = false)
    private int kilosQuantity;
    public Fruit() {}

    public Fruit(int kilosQuantity, String name) {
        this.kilosQuantity = kilosQuantity;
        this.name = name;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKilosQuantity() {
        return kilosQuantity;
    }

    public void setKilosQuantity(int kilosQuantity) {
        this.kilosQuantity = kilosQuantity;
    }
}
