# Robotic Rover

## Problem definition
A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth.
A rover's position and location is represented by a combination of x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.
In order to control a rover, NASA sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right respectively, without moving from its current spot. 'M' means move forward one grid point, and maintain the same heading.

See full requirement in [link](Mars%20rover.docx)

## Prerequisites
 - Kotlin 1.3
 - Java 8
 - Gradle 6.3

## Build
```
$ gradle build
```

## Run

```
$ cd build/libs
$ java -jar RoboticRover.jar
```
Then you will see 
```
=== Input ===
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
=== Output ===
1 3 N
5 1 E
```

## Test
```
$ gradle test
```

### Unit tests [link](src/test/java/com/snooper/service)  
### Integration tests [link](src/test/java/com/snooper/ApplicationIntegrationTests.kt)

![test result](test-result.png)

## Code Structure
In `src` folder
`Application` main function  
`/constant` enum types  
`/dto` models  
`/exception` exceptions  
`/service` logic implementation