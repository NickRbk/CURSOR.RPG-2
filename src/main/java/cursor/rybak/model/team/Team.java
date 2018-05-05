package cursor.rybak.model.team;

import cursor.rybak.game.UserInteraction;
import cursor.rybak.model.maze.Maze;
import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.model.race.RaceInitValues;
import cursor.rybak.model.room.Room;
import cursor.rybak.view.BattleMessage;
import cursor.rybak.view.TeamMessage;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Team implements LevelUp {
    private static final int TEAM_MEMBERS = 3;
    private List<AbstractRace> heroes;
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
    private List<AbstractRace> createTeam() {
        List<AbstractRace> selectedHeroes = UserInteraction.askHeroes(TEAM_MEMBERS);
        selectedHeroes.get(0).setLeader();
        return selectedHeroes;
    }

    public Room enterToMaze(Maze maze) {
        maze.getStartRoom().setTeam(this);
        return maze.getStartRoom();
    }

    //=====================================================================
    public Room move(Room currentRoom, String moveOption) {
        int index = Integer.parseInt(moveOption) - 1;
        escapeFromRoom(currentRoom);
        Room nextRoom = enterToRoom(currentRoom, index);

        this.heroes.forEach(AbstractRace::regeneration); // trigger regeneration mode

        return nextRoom;
    }

    private void escapeFromRoom(Room currentRoom) {
        currentRoom.setTeam(null);
        currentRoom.setPrevious(null);
    }

    private Room enterToRoom(Room currentRoom, int index) {
        Room nextRoom = currentRoom.getChainedTo().get(index);
        nextRoom.setTeam(this);
        nextRoom.setPrevious(currentRoom);

        setMonsters(nextRoom);

        return nextRoom;
    }

    private void setMonsters(Room nextRoom) {
        if (nextRoom.isMonsterPresent()
                && nextRoom.getEnemies() == null) {

            Room.setMonsters(LevelMathUtil.getAverage(this.getHeroes()), nextRoom);
        }
    }
    //=====================================================================

    /**
     * Level up method
     */
    public void tryLevelUp() {
        List<AbstractRace> heroesLevelUp = new ArrayList<>();

        this.heroes.forEach(hero -> {
            int prevLevelPoints = hero.getPrevLevelPoints();

            int levelUpPoints = hero.getLevel() == 1
                    ? prevLevelPoints
                    : levelUpPoints(this.getHeroes(), prevLevelPoints);

            if (isPossibleToLevelUp(hero, levelUpPoints)) {
                heroesLevelUp.add(hero);
                BattleMessage.printUpgradeHero(hero);
                levelUpHero(hero, levelUpPoints);
                UserInteraction.distributePoints(hero);
            }
        });

        if (heroesLevelUp.size() > 0) TeamMessage.printTeamInfo(this);
    }

    private boolean isPossibleToLevelUp(AbstractRace hero, int levelUpPoints) {
        return hero.getXp() >= levelUpPoints
                && hero.getLevel() < RaceInitValues.maxLevel;
    }

    private void levelUpHero(AbstractRace hero, int levelUpPoints) {
        hero.setXp(hero.getXp() - levelUpPoints);
        hero.setLevel(hero.getLevel() + 1);
        hero.setPrevLevelPoints(levelUpPoints);

        hero.setSp(RaceInitValues.sp);
    }
    //=====================================================================


    @Override
    public String toString() {
        return String.format("\n\t%s team, members: %d\n\t\t--> %s",
                name, heroes.size(), printTeamMembers());
    }

    /**
     * return String of all members name in team
     *
     * @return members name in team
     */
    public String printTeamMembers() {
        List<String> heroesInfo = this.heroes
                .stream()
                .map(hero -> String.format("%s (%.0f HP, Lvl %d)",
                        hero.getHeroName(), hero.getHealth(), hero.getLevel()))
                .collect(Collectors.toList());

        return String.join(", ", heroesInfo);
    }
}
