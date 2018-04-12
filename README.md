I tried to make it so that it was easy to add a new race and a parameter.
Now there are 3 races and 2 specialities.

________________________________________________________________________
### Good ‘ol RPG
We must fight against monsters in the Labyrinth.
For doing this we need a team of three characters, one of them is a leader.
In case of a leader's death or if we find special item "the Great Crystal", the game will end.
The team can be compiled from the characters of three races: Elf, Human, Dwarf.
Each race have a specialities which have treir own advantages.
#### Start stats for each race:
  Race  |  Charisma | Stamina | Intellect | Agility | Concentration  
------- | --------- | ------- | --------- | ------- | -------------   
  Elf | 15 | 10 | 25 | 22 | 18
  Human | 10 | 30 | 20 | 15 | 15
  Dwarf | 5 | 45 | 15 | 20 | 5 
#### Hero parameters
##### Main
 - __Health__
 - __Manna__
 - __Level__
 - __isLeader__
 - __Health__
 ##### Regular
 - __Race__
 - __Charisma__
 - __Stamina__
 - __isLeader__
 - __Intellect__
 - __Agility__
 - __Concentration__
__algorithm of actions:__
 - greetings
 - repeat 3 times:
   - a)choose race
   - b)choose speciality
 - choose leader
 - display info of chosen characters
#### how to start
 - download or git clone
 - in directory with pom file: mvn package
 - java -cp target/GoodOldRpg-1.0-SNAPSHOT.jar Main
#### \*.txt files
 - __names__ list with 10 names for each race.
 - __Race__ list with race names.
 - __Race1__ List with first race specialities.
 - __Race1p__ List with first race parameters.
