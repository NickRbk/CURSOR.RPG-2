package cursor.rybak.model.race.kind;

import lombok.Getter;

@Getter
public enum Races {
    Dwarf("dwarf", 5, 45, 15, 20, 5),
    Elf("elf", 15, 10, 25, 22, 18),
    Human("human", 10, 30, 20, 15, 15);

    String name;
    int charisma;
    int stamina;
    int intellect;
    int agility;
    int concentration;

    Races(String name, int charisma, int stamina, int intellect, int agility, int concentration) {
        this.name = name;
        this.charisma = charisma;
        this.stamina = stamina;
        this.intellect = intellect;
        this.agility = agility;
        this.concentration = concentration;
    }
}
