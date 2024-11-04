# Composition manager (Lab 5 Java Software Development)

This project manages a collection of music compositions, allowing for calculating the total duration of an album, sorting compositions by style, and searching for compositions within a specified duration range. It demonstrates object-oriented programming concepts in Java, including class inheritance, polymorphism, and exception handling.

## Assignment

Determine **C13** as the remainder of dividing the student's record book number 13879064 by 13.

Based on **C13**, determine the assignment variant:

| C13 | Assignment Variant                                                                                                                                                                        |
|-----|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 4   | Define a hierarchy of musical compositions. Record an album. Calculate the album's duration. Rearrange the compositions on the disc based on their style. Find compositions matching a given track length range. |

**Variant:**

- **C13 = 4**: Define a hierarchy of musical compositions.

## Features

- **MusicComposition Class**: Represents a general music composition with attributes like title, duration, and style.
- **Derived Classes**:
  - **RockSong**: Represents rock music compositions.
  - **JazzPiece**: Represents jazz music compositions.
  - **ClassicalPiece**: Represents classical music compositions.
- **Album Class**:
  - **Calculate Total Duration**: Computes the total duration of all compositions in the album.
  - **Sort Compositions by Style**: Rearranges compositions based on their musical style.
  - **Find Compositions by Duration Range**: Searches for compositions within a specified duration range.
- **Exception Handling**: Handles any exceptions that may occur during the execution of the code.
- **Documentation**: The code is thoroughly documented for clarity and understanding.
- **Code Standards**: Adheres to Java Code Conventions (or Google Java Style Guide).

## Requirements

- **Java Development Kit (JDK) 8** or higher installed on your system.
- **Git** (optional, for cloning the repository).

## How to Run

### Clone the Repository (Optional)

If the project is hosted on GitHub, clone it using:

```bash
git clone https://github.com/yourusername/music-album-management.git
cd music-album-management/src
```

Alternatively, you can download the source code files directly.

### Compile the Source Code

Open a terminal or command prompt in the project directory and compile the Java files:

```bash
javac *.java
```

### Run the Program

After successful compilation, run the program using:

```bash
java Main
```

## Usage Instructions

1. **Starting the Program**:
   - Run `java Main` in your terminal.

2. **Program Execution**:
   - The program initializes an `Album` object and adds various `MusicComposition` objects to it.
   - It calculates the total duration of the album and displays it.
   - Sorts the compositions in the album by their musical style and displays the sorted list.
   - Finds compositions within a specified duration range and displays them.
   - Demonstrates playing all compositions in the album.

3. **Results Display**:
   - The total duration of the album is displayed in seconds.
   - The sorted list of compositions by style is displayed.
   - The list of compositions within the specified duration range is displayed.
   - Each composition is "played," demonstrating polymorphism.

## Example Output

```
Total album duration: 1750 seconds.

Compositions sorted by style:
Classical: Symphony No.5
Jazz: Smooth Jazz
Jazz: Jazz Fusion
Rock: Rock Anthem
Rock: Rock Ballad

Compositions between 200 and 500 seconds:
Smooth Jazz - 250 seconds (Jazz)
Jazz Fusion - 400 seconds (Jazz)
Rock Anthem - 300 seconds (Rock)
Rock Ballad - 200 seconds (Rock)

Playing all compositions:
Playing classical piece: Symphony No.5
Playing jazz piece: Smooth Jazz
Playing jazz piece: Jazz Fusion
Playing rock song: Rock Anthem
Playing rock song: Rock Ballad
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
