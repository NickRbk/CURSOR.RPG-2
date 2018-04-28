package cursor.rybak.model.team;

import cursor.rybak.game.UserInteraction;
import cursor.rybak.model.maze.Maze;
import cursor.rybak.model.race.RaceInitValues;
import cursor.rybak.model.room.Room;
import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.view.BattleMessage;
import lombok.Getter;

import java.util.Arrays;

@Getter
public class Team implements GameCalc {
    private static final int TEAM_MEMBERS = 3;
    private AbstractRace[] heroes;
    private String name;

    public Team(String name) {
        heroes = createTeam();
        this.name = name;
    }

    /**
     * create Team
     *
     * @return array of members team
     */
    private AbstractRace[] createTeam() {
        AbstractRace[] selectedHeroes = UserInteraction.askHeroes(TEAM_MEMBERS);
        selectedHeroes[0].setLeader();
        return selectedHeroes;
    }

    public Room enterToMaze(Maze maze) {
        maze.getStartRoom().setTeam(this);
        return maze.getStartRoom();
    }

    public Room move(Room currentRoom, String moveOption) {
        int index = Integer.parseInt(moveOption) - 1;
        currentRoom.setTeam(null);
        currentRoom.setPrevious(null);

        Room nextRoom = currentRoom.getChainedTo()[index];
        nextRoom.setTeam(this);
        nextRoom.setPrevious(currentRoom);
        nextRoom.setChecked(true);

        tryLevelUp();

        return nextRoom;
    }


    /**
     * Level up method
     */
    private void tryLevelUp() {
        Arrays.stream(heroes)
                .forEach(hero -> {
                    int prevLevelPoints = hero.getPrevLevelPoints();

                    int levelUpPoints = hero.getLevel() == 1
                            ? RaceInitValues.initLevelUpPoints
                            : levelUpPoints(this, prevLevelPoints);

                    if(hero.getXp() >= levelUpPoints && hero.getLevel() < RaceInitValues.maxLevel) {
                        BattleMessage.printUpgradeHero(hero);

                        hero.setXp( hero.getXp() - levelUpPoints );
                        hero.setLevel( hero.getLevel() + 1 );
                        hero.setPrevLevelPoints( levelUpPoints );

                        hero.setSp(RaceInitValues.sp);
                        UserInteraction.distributePoints(hero);
                    }
                });
    }


    @Override
    public String toString() {
        return String.format("\n\t%s team, members: %d\n\t\t--> %s",
                name, heroes.length, printTeamMembers());
    }

    /**
     * return String of all members name in team
     *
     * @return members name in team
     */
    private String printTeamMembers() {
        String[] heroesName = new String[heroes.length];

        for (int i = 0; i < heroes.length; i++) {
            heroesName[i] = String.format("%s (%.0f)", heroes[i].getHeroName(), heroes[i].getHealth());
        }

        return String.join(", ", heroesName);
    }
}
