package cursor.rybak.model.room;

import cursor.rybak.view.MagicColors;
import lombok.Getter;

@Getter
public enum RoomDescription implements MagicColors {

    START_POINT(CYAN + "\tYou're in Game, welcome! It's dark around... but doesn't matter.\n" +
            "\tYou must know only a few things... here live monsters and\n" +
            "\tyou run away from here, if you find the key)\n" +
            "\tBe careful, good luck!" + RESET, "START POINT"),

    LOCATION1(CYAN + "\tThere is too much water. TEAM, we need to get out of here" + RESET, "Location #1"),

    LOCATION2(CYAN + "\tA terrible place... what a noise here!!" + RESET, "Location #2"),

    LOCATION3(CYAN + "\t...the flour creaks.. Nice))" + RESET, "Location #3"),

    LOCATION4(CYAN + "\tSo low ceiling, what dwarf lived here!" + RESET, "Location #4"),

    LOCATION5(CYAN + "\tSuspicious silence... But I must escape from here!" + RESET, "Location #5"),

    LOCATION6(CYAN + "\tHow strange this picture hangs here.. em..\n" +
            "\t No,no,no, I'm very suspicious..)\n" +
            "\tYeah,I'm in a normal conventional.. bunker" + RESET, "Location #6"),

    LOCATION7(CYAN + "\tThese inscriptions strain me. Why? Why all rooms named by indexes!\n" +
            "\tMaybe it's key to my freedom..." + RESET, "Location #7"),

    LOCATION8(CYAN + "\t'You are in hell'.. very positive text on wall..\n" +
            "\tBut who left it here !?" + RESET, "Location #8"),

    LOCATION9(CYAN + "\tIt becomes stuffy... but I feel that exit is close.. I hope" + RESET, "Location #9"),

    LOCATION10(CYAN + "\tWow, laboratory! And what equipment are here!\n" +
            "\tTEAM, do not be distracted!" + RESET, "Location #10"),

    LOCATION11(CYAN + "\tWhat contrasts, it becomes cool.. Why I didn't take a jacket!" + RESET, "Location #11"),

    LOCATION12(CYAN + "\tWell, some interesting table and some letter... 'We have cookies'\n" +
            "\tWhat?! Someone is mocking us! But who?" + RESET, "Location #12"),

    LOCATION13(CYAN + "\tWow, what the furniture. The one who lived here had a good taste))" + RESET, "Location #13"),

    LOCATION14(CYAN + "\tCasino in the bunker?)) Really? TEAM, do not spend all money))" + RESET, "Location #14"),

    LOCATION15(CYAN + "\tThis is good place to rest, quietly here. TEAM, set up a camp!" + RESET, "Location #15"),

    LOCATION16(CYAN + "\tWalls, stones, a lot of dust..." + RESET, "Location #16"),

    LOCATION17(CYAN + "\tRoom of mirrors, I hate that!" + RESET, "Location #17"),

    LOCATION18(CYAN + "\tIt seems like a classroom... who was taught here?" + RESET, "Location #18"),

    LOCATION19(CYAN + "\tOval cabinet, cool) But from where the rats are here\n" +
            "\tWhat they eat?" + RESET, "Location #19"),

    LOCATION20(CYAN + "\tSome enormous footprints, this is alarming..." + RESET, "Location #20"),

    END_POINT(PURPLE + "\n\n\t================================" +
            "\n\n\tCongratulations!!! You are free!" +
            "\n\n\t================================\n" + RESET, "END POINT");

    private String description;
    private String label;

    RoomDescription(String description, String label) {
        this.description = description;
        this.label = label;
    }
}
