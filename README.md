# Scheduler
This open Source Scheduler can schedule classes with multiple or single sections with no collision.
  

This Scheduler uses 24-hour clock system
The input should follow the format (please check the example below afterwards): 
1-number of your class
2-Name of the first class
3-Wheter or not the class is elective (yes/no)
4-number of the sections your class has
5-the day and hour of the first section
6-repeat the same process, beginning from the 4th step, if multiple sections exist
7-repeat the same process, beginning from the 2th step, if multiple classes exist
8-enter a late hour

Writing your input somewhere in this format then copying and pasting them as the program input is suggested.

Abbreviations: 
Sunday -> Sunday or su
Monday -> Monday or Mo
Tuesday -> Tuesday or Tu
Wednesday -> Wednesday or We
Thursday -> Thursday or Th
Friday -> Friday or Fr
Saturday -> Saturday or st

5
CMPE 326
no
5
Mo 13 - 15 We 11 - 12
Mo 09 - 11 We 12 - 13
Tu 11 - 13 We 13 - 14
Tu 13 - 14 Th 09 - 11
Mo 11 - 13 Tu 14 - 15
CMPE 382
no
5
Tu 13 - 15 We 14 - 15
We 13 - 14 Th 12 - 14
Tu 09 - 11 Th 11 - 12
Mo 15 - 17 We 14 - 15
Tu 13 - 15 We 13 - 14
SENG 214
no
5
Tu 15 - 17 Th 16 - 17
We 09 - 11 Th 17 - 18
Tu 11 - 13 We 13 - 14
Th 11 - 14
Mo 13 - 15 We 11 - 12
ITA 101
yes
3
Tu 15 - 18
Th 13 - 16
Fr 12 - 15
CMPE 327
yes
1
We 11 - 14
13