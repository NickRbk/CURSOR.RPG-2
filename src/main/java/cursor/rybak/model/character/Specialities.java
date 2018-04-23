package cursor.rybak.model.character;

public enum Specialities {
    R1S1("Mage", "imposition of an improvement on the character of his unit can hold wizard Stuff (attack d6)"),
    R1S2("Gunslinger", "Shoot from the bow – regular attack (damage 2d6) attack the enemy with dagger (d6)"),
    R2S1("Spells", "Hand of God(25 mp), cd 2 turns, heals 20 hits (can be cast on itself or other "),
    R2S2("Paladin", "attack with a sword (damage done by 2d10), regular"),
    R3S1("Warrior", "Attack with axe, 2d10, regular"),
    R3S2("Mechanist", "Attack with gun, 2d6, regular");
    public final String name;
    public final String description;

    Specialities(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
