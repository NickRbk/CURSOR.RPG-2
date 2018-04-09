I tried to make it so that it was easy to add a new race and new paramete.
at this moment there are 3 races and 2 specialities.
________________________________________________________________________
### Good ‘ol RPG
We must fighting against monsters in Labyrint.
For do this we have to take a team of three characters, one of them is a leader.
In the event of a leader's death or if we find item the Great Crystall  - the game will end.
The team can be compiled from the characters of three races: Elf, Human, Dwarf.
each race have a speciality each of which has its own advantages.
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

