I tried to make it so that it was easy to add a new race and a parameter.
Now there are 3 races and 2 specialities.

________________________________________________________________________
## Good ‘ol RPG
We must fight against monsters in the Labyrinth.
For doing this we need a team of three characters, one of them is a leader.
In case of a leader's death or if we find special item "the Great Crystal", the game will end.
The team can be compiled from the characters of three races: Elf, Human, Dwarf.
Each race have a specialities which have treir own advantages.
### Hero Races and specialities
 - __Elf__ впливові, гарно володіють магією і мають найкращу витривалість, проте мала кількість хп
   - mage:
imposition of an improvement on the character of his unit
can hold wizard Stuff (attack d6)
can have various spells (requires mana consumption):
Fireball (45 mp) 3d10, cd (calldown) 3 turns (not moving turns, but battle phase turns)
Spell Shield (15 mp), block 60 dmg till destruction, cd 2 turns
Frost Bolt (20 mp), 2d6, cd 1 turn
Dispell (20 mp), dispells any spell, cd 3 turns
Stone Gaze (20 mp), transform enemy into stone for 2 turns, cd 4 turns.
   -gunslinger:
        Shoot from the bow – regular attack (damage 2d6)
        attack the enemy with dagger (d6)
        can have spell skills (requires mana consumption):
      -Multishot (30 mp) – attack 1 additional target, cd 2 turns
      -RapidFire(30 mp) – attack single target with 1 additional attack, cd 3 turns
      -BullsEye(40 mp) – archer takes aim and deal crit damage to sinle target 3d10, cd 3 turns
 - __Human__ середній вплив середня магія невелика виносливість
 - __Dwarf__ мала ініціатива і слабка магія , але велике здоровя і витривалість
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
 - __Stamina__ вона впливає на кількість і відновлення здоровя (1 stamina point = 2 hp, 4 stamina point=1 hp regeneration). 
 - __Intellect__ вона впливає на кількість і відновлення мани (1 intelect point = 2 mp, 4 intelect point = 1 mp regeneration).
 - __Agility__  вона впливає на 4 rp per 1 agility point, chance to avoid hit 1% per 2 points
 - __Concentration__ 1 hp, 1,5 mp/1 rp regen per turn for 1 consentartion point, 1 turn cd decresion per 25 points
 ### Start stats for each race:
  Race  |  Charisma | Stamina | Intellect | Agility | Concentration  
------- | --------- | ------- | --------- | ------- | -------------   
  Elf | 15 | 10 | 25 | 22 | 18
  Human | 10 | 30 | 20 | 15 | 15
  Dwarf | 5 | 45 | 15 | 20 | 5 
  
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
 
#### __stuff__
 - [unicode symbols](https://unicode-table.com/ru/#box-drawing)
