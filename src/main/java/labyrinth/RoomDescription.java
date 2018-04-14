package labyrinth;

public enum RoomDescription {
    START("Start",
            "Maybe it`s better to go back until it`s too late ?",
            "The room whose walls are coated with the crystals. In a settlement nearby residents call them \"Amelit\"" +
                    ". It`s unknown how they have appeared and how they grow. They are glowing a bit. As there are " +
                    "lots of crystals in the room, we can inspect it. On the opposite side of the room there is " +
                    "a door. What are you going to do?"),
    EXIT("Exit",
            "it looks like an exit is here.",
            "Oh, we have passed the dungeon. You are standing in front of the exit from this unpleasant place. " +
                    "Maybe you will change your mind and go back?"),
    R0("DarkRoom.",
            "Сome up and open the dark door",
            "There are few Amelit in the room , but it`s still enough to look around. According to the web, " +
                    "nobody has been here for a long time..."),

    R1("Skeleton room.",
               "Come up to the bloody door.",
               "The room is full of bones. It seems like somebody intentionally throws off them here. They even " +
               "cut off the passage. Yet we have managed to get to the end of the room. Where to go now?"),

    R2("Regular room.",
               "Open the ordinary door.",
               "We have entered the ordinary room. Unlike the others there is no terrible smell here. But heaven " +
                       "knows what we can do here. "),

    R3("Room in smoke",
               "Smoke comes from behind the door.",
               "There is a fire here ! Everything in  smoke, nothing is visible and it`s difficult to breathe." +
                       " Our team is losing the health! We must get out of here immediately."),

    R4("Broken door.",
               "Climb through the broken door.",
               "The entire width of the passage is an abyss. You have thrown the stone there and it seems like it " +
                       "hasn't fallen yet. You have passed the bridge. Where to go next?"),

    R5("Light room.",
               "Hurry up, behind that door the light is visible.",
               "Oh, fresh air and the sunlight is shining through the crack in the ceiling. We can relax. " +
                       "You have recovered. It's time to go further"),

    R6("Vine room.",
               "hmm .. the smell of alcohol. Let's go here.",
               "You're got to the somebody's cache with wine. But who decided to place it here? Concerning to the " +
                       "skeleton at the table with the broken glass, there has been nobody for several years.  " +
                       "Let's take few barrels and go further"),

    R7("wet room.",
               "Open the rusty door.",
               "It's dark here. Something is  rustling above. Bang! A slug fell on the team member's head and took " +
                       "the half of his health.  Be careful"),

    R8("Crystal room.",
               "Go through the crack in the wall.",
               "You got into the cave full of Amelit, so it can be well seen the path to the other end of the cave. " +
                       "It is heard strange sounds here, it seems like there is something large. According to the " +
                       "Elves, the Crystal Dragon lives in this cave. Isn't it him?"),

    R9("Goblins' town.",
               "Go through the wooden wicket.",
               "It's another spacious  cave.  It looks like  orcs or goblins live in this cave but now there is " +
                       "nobody here. It's better go out of here."),

    R10("Склеп",
                "Піти у прохід біля tombstone.",
                "багато трупів, дуже багато, мені туд не подобається. здається он той ворухнувся, чи той. " +
                        "Мерщій звідси"),

    R11("Озеро",
                "Піти у прохід у стіні. ",
                "Величезна пещера повністю занята озером. Щось світиться у глибину. ви подумали - полюбому амеліт. " +
                        "Що ж він таке?");

    public String name;
    public String doorSignboard;
    public String description;

    RoomDescription(String name, String doorSignboard, String description) {
        this.description = description;
        this.doorSignboard = doorSignboard;
        this.name = name;

    }
}
