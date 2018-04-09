I tried to make it so that it was easy to add a new race and a parameter.
Now there are 3 races and 2 specialities.
```java
algorythm of actions:
```
 - greetings
 - repeat 3 times:
 - a)choose race
 - b)choose speciality
 - choose leader
 - display info of choosen characters
________________________________________________________________________
### Good ‘ol RPG
We must fight against monsters in the Labyrinth.
For doing this we need a team of three characters, one of them is a leader.
In case of a leader's death or if we find special item "the Great Crystall", the game will end.
The team can be compiled from the characters of three races: Elf, Human, Dwarf.
Each race have a specialities whitch have treir own advantages.
#### Start stats for each race:
```java
┌────────┬──────────┬─────────┬───────────┬─────────┬───────────────┐
│  Race  │ Charisma │ Stamina │ Intellect │ Agility │ Concentration │ 
├────────┼──────────┼─────────┼───────────┼─────────┼───────────────┤    
│ Elf    │    15    │    10   │    25     │   22    │      18       │
├────────┼──────────┼─────────┼───────────┼─────────┼───────────────┤ 
│ Human  │    10    │    30   │    20     │   15    │      15       │
├────────┼──────────┼─────────┼───────────┼─────────┼───────────────┤ 
│ Dwarf  │     5    │    45   │    15     │   20    │       5       │
└────────┴──────────┴─────────┴───────────┴─────────┴───────────────┘
```

#### how to start
 - download or git clone
 - in directory with pom file: mvn package
 - java -cp target/GoodOldRpg-1.0-SNAPSHOT.jar Main

