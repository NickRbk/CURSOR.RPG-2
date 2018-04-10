package enemy;

public enum EnemyType {
    T11("UNDEAD", "Skeleton", 10, 40, 6, 5),
    T12("UNDEAD", "Sceleton Chief", 15, 60, 6, 10),
    T13("UNDEAD", "Zombie", 5, 80, 6, 15),
    T14("UNDEAD", "Banshee", 15, 75, 10, 18),
    T15("UNDEAD", "Litch", 20, 100, 26, 25),
    T16("UNDEAD", "Bone Dragon", 50, 550, 31, 300),
    T21("ORKOIDS", "Goblin", 20, 35, 6, 10),
    T22("ORKOIDS", "Ork", 30, 100, 26, 18),
    T23("ORKOIDS", "Ork Shaman", 35, 80, 26, 22),
    T24("ORKOIDS", "Ork Warlord", 50, 150, 26, 40),
    T25("ORKOIDS", "Ogre", 5, 300, 21, 100),
    T26("ORKOIDS", "Unstable Alchemist", 25, 15, 1, 5);/*
    T31("UNDEAD","Skeleton",10,40,6,5),
    T32("UNDEAD","Sceleton Chief",15,60,6,10),
    T33("UNDEAD","Zombie",5,80,6,15),
    T34("UNDEAD","Banshee",15,75,10,18),
    T35("UNDEAD","Litch",20,100,26,25),
    T36("UNDEAD","Unstable Alchemist",50,550,31,300),*/
    private String race;
    private String type;
    private int initiative;
    private float hp;
    private int damage;
    private int cost;

    EnemyType(String race, String type, int initiative, float hp, int damage, int cost) {
        this.race = race;
        this.type = type;
        this.initiative = initiative;
        this.hp = hp;
        this.damage = damage;
        this.cost = cost;
    }
}
