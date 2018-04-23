package cursor.rybak.character;

public enum RacesVariants {
    R1("Elf", "Here will be the description of the race 1", 15, 10, 25, 22, 18),
    R2("Human", "Here will be the description of the race 2", 10, 30, 20, 15, 15),
    R3("Dwarf", "Here will be the description of the race 3", 5, 45, 15, 20, 5);

    public final String name;
    public final String description;
    public final int charisma;
    public final int stamina;
    public final int intellect;
    public final int agility;
    public final int concentration;

    RacesVariants(String name, String description, int charisma, int stamina, int intellect, int agility,
                  int concentration) {
        this.name = name;
        this.description = description;
        this.charisma = charisma;
        this.stamina = stamina;
        this.intellect = intellect;
        this.agility = agility;
        this.concentration = concentration;
    }
}
