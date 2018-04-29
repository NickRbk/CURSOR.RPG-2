
## Good ‘ol RPG

#### Description

This is a console game in which the user choose team of heroes
of particular Race (_Elf, Human, Dwarf_).

Each hero has some specific features (specialities), which have their own advantages.

In team _**one Hero is a leader**_, and others are team-members.

Hero start game from _**Level 1**_ with 10XP and can improve himself 
up to _**Level 10**_.

In one move character can do one action, which chosen from set of actions
for particular hero.

The team will be fight against monsters in some fabulous location.

In case of a leader's death or if we find special item "the Great Crystal", the game will end.

#### Prerequisites:
- install [Maven](https://maven.apache.org/download.cgi). 

App better used in terminal full-screen mode in conventional terminal)

#### How to start up ?
- git clone
- build the maven project ```mvn package```
- start app with the below cmd
          
            java -jar target/GoodOldRpg-1.0-SNAPSHOT.jar
