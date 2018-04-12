
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        Game newRpg = new Game();
        newRpg.start();
        newRpg.chooseLeader();
        newRpg.displayTeamInfo();
        newRpg.turn();
    }
}
