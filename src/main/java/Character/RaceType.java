package Character;

public enum RaceType {
    T1("Elf",15,10,25,22,18),T2("Human",10,30,20,15,15),T3("Dwarf",5,45,15,20,5);
    private String type;
    private int charisma;
    private int stamina;
    private int intelect;
    private int agility;
    private int concentration;
    RaceType(String type,int charisma,int stamina,int intelect,int agility,int concentration){
        this.type=type;
        this.charisma=charisma;
        this.stamina=stamina;
        this.intelect=intelect;
        this.agility=agility;
        this.concentration=concentration;
    }
}
