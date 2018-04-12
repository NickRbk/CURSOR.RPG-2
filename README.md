I tried to make it so that it was easy to add a new race and a parameter.
Now there are 3 races and 2 specialities.

________________________________________________________________________
## Good ‘ol RPG
We must fight against monsters in the Labyrinth.
For doing this we need a team of three characters, one of them is a leader.
In case of a leader's death or if we find special item "the Great Crystal", the game will end.
The team can be compiled from the characters of three races: Elf, Human, Dwarf.
Each race have a specialities which have treir own advantages.
### Start stats for each race:
  Race  |  Charisma | Stamina | Intellect | Agility | Concentration  
------- | --------- | ------- | --------- | ------- | -------------   
  Elf | 15 | 10 | 25 | 22 | 18
  Human | 10 | 30 | 20 | 15 | 15
  Dwarf | 5 | 45 | 15 | 20 | 5 
### Hero parameters
#### Main
 - __Race__
 - __Name__
 - __Health__
 - __Manna__
 - __Level__ min -1, max -10.
 - __isLeader__ 
 - __Health__
 #### Regular
 - __Charisma__
 - __Stamina__ 2 hp per 1 stamina point, 0,25 hp regen per 1 stamina point
 - __Intellect__ 2 mp – per 1 intelect point, 0,25 mp regen per 1 intelect point
 - __Agility__  4 rp per 1 agility point, chance to avoid hit 1% per 2 points
 - __Concentration__ 1 hp, 1,5 mp/1 rp regen per turn for 1 consentartion point, 1 turn cd decresion per 25 points
### algorithm of actions:
 - greetings
 - repeat 3 times:
   - a)choose race
   - b)choose speciality
 - choose leader
 - display info of chosen characters
### how to start
 - download or git clone
 - in directory with pom file: mvn package
 - java -cp target/GoodOldRpg-1.0-SNAPSHOT.jar Main
#### \*.txt files
 - __names__ list with 10 names for each race.
 - __Race__ list with race names.
 - __Race1__ List with first race specialities.
 - __Race1p__ List with first race parameters.
 
#### __stuff__
 - [unicod symbols](https://unicode-table.com/ru/#box-drawing)
