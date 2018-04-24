package cursor.rybak.model.team;

import cursor.rybak.game.UserInteraction;
import cursor.rybak.model.race.AbstractRace;
import lombok.Getter;

@Getter
public class Team {
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
