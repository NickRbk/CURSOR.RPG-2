package cursor.rybak.view;

import cursor.rybak.model.room.Room;

import java.util.List;

public class MazeMessage implements MagicColors {

    /**
     * ask about next move
     *
     * @param room current room
     * @return string of options
     */
    public static String getAndAskMoveOptions(Room room) {
        System.out.format("\n\t\t%sChoose move option from the list above:%s ", GREEN, RESET);

        StringBuilder options = new StringBuilder();
        for (int i = 0; i < room.getChainedTo().size(); i++) options.append(i + 1);
        return options.toString();
    }


    public static void printNeighbors(Room room) {
        System.out.print(CYAN + "\t\tAhh, What we see here..? " + RESET);
        List<Room> chainedTo = room.getChainedTo();

        if (chainedTo.size() == 1) {
            System.out.format(RED + " Its deadlocked, move back.. " + RESET + "(1)");
        } else {
            printChainedRoom(room.getPrevious(), chainedTo);
        }
    }


    /**
     * Print chained room info
     * (helper method for 'printNeighbors')
     *
     * @param previousRoom previous room
     * @param chainedTo    chained room
     */
    private static void printChainedRoom(Room previousRoom, List<Room> chainedTo) {
        chainedTo.forEach(chainedRoom -> {
            int index = getRoomIndex(chainedTo, chainedRoom) + 1;

            if (chainedRoom.equals(previousRoom)) {
                System.out.format("\n\t\t%d -> %s(back)%s %s%s%s",
                        index, RED, RESET, CYAN, chainedRoom.getLabel(), RESET);
            } else {
                checkRoom(chainedRoom, index);
            }
        });
    }


    /**
     * mark visited room
     * (helper method for 'printChainedRoom')
     *
     * @param chainedRoom neighbor room
     * @param index       it's index
     */
    private static void checkRoom(Room chainedRoom, int index) {
        if (chainedRoom.isChecked()) {
            System.out.format("\n\t\t%d -> %s%s%s",
                    index, GREEN, chainedRoom.getLabel(), RESET);
        } else {
            System.out.format("\n\t\t%d -> %s%s%s",
                    index, CYAN, chainedRoom.getLabel(), RESET);
        }
    }


    /**
     * get index of analyzed room in array of chained rooms
     * (needed to print options, helper method for 'printChainedRoom')
     *
     * @param chainedTo array of chained rooms
     * @param room      analyzed room
     * @return index
     */
    private static int getRoomIndex(List<Room> chainedTo, Room room) {
        return chainedTo.indexOf(room);
    }
}
