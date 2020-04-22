# Robotic Rover

## Description
A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth.  
A rover's position and location is represented by a combination of x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.  
In order to control a rover, NASA sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right respectively, without moving from its current spot. 'M' means move forward one grid point, and maintain the same heading.  
Assume that the square directly North from (x, y) is (x, y+1).

See full description in [link](Mars%20rover.docx)

## Prerequisites
Please install following dependencies before building
 - Kotlin 1.3
 - Java 8
 - Gradle 6.3

## How to build
Build project into execution file  
In terminal, run
```
$ gradle build
```

## How to run
Execution file locates in `build/libs` with jar format, run it with Java  
In terminal, run
```
$ cd build/libs
$ java -jar RoboticRover.jar
```
Then you should see following message
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
Done!

## Test
In terminal, run
```
$ gradle test
```
Including unit tests & integration tests
### Unit tests [link](src/test/java/com/snooper/service)
Service implementation tests
  
### Integration tests [link](src/test/java/com/snooper/ApplicationIntegrationTests.kt)
Main function integration tests

Test result:
![test result](test-result.png)

## Code Structure
In `src` folder
`Application` main function  
`/constant` enum types  
`/dto` models  
`/exception` exceptions  
`/service` logic implementation

###### Any question please email please contact (xxx@gmail.com). Thanks