
# Composition Manager (Lab 6 Java Software Development)

This project manages a collection of music compositions using a custom list implementation. It allows for adding, removing, and accessing compositions, calculating the total duration, and demonstrates advanced object-oriented programming concepts in Java, including custom collection implementation, class inheritance, polymorphism, and exception handling.

## Assignment

Determine **C2** as the remainder of dividing the student's record book number **13879064** by 2, and **C3** as the remainder of dividing the student's record book number **13879064** by 3.

- **C2 = 13879064 % 2 = 0**
- **C3 = 13879064 % 3 = 2**

Based on **C2**, determine the interface the collection implements:

| C2 | Interface |
|----|-----------|
| 0  | List      |

Based on **C3**, determine the internal structure of the collection:

| C3 | Internal Structure of the Collection |
|----|--------------------------------------|
| 2  | Doubly linked list                   |

**Variant:**

- **C2 = 0**: The collection implements the `List` interface.
- **C3 = 2**: The collection uses a doubly linked list as its internal structure.

## Features

- **MusicCompositionList Class**:
    - Implements the `List<MusicComposition>` interface.
    - Uses a doubly linked list as the internal data structure.
    - Implements all methods of the `List` interface.
    - Provides three constructors:
        - **Empty Constructor**: Initializes an empty list.
        - **Single Object Constructor**: Initializes the list with a single `MusicComposition` object.
        - **Collection Constructor**: Initializes the list with a collection of `MusicComposition` objects.

- **MusicComposition Class**: Represents a general music composition with attributes like title, duration, and style.

- **Derived Classes**:
    - **RockSong**: Represents rock music compositions.
    - **JazzPiece**: Represents jazz music compositions.
    - **ClassicalPiece**: Represents classical music compositions.

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
git clone https://github.com/HlibPavlyk/composition-manager.git
cd composition-manager
```

Alternatively, you can download the source code files directly.

### Switch to the Desired Branch

If your solution is on a different branch (e.g., `modified`), switch to that branch:

```bash
git checkout modified
cd src
```

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
    - The program initializes a `MusicCompositionList` object and demonstrates various operations:
        - **Adding Compositions**: Adds compositions to the list using different constructors.
        - **Combining Lists**: Merges multiple `MusicCompositionList` instances into one.
        - **Removing a Composition**: Removes a specified composition from the list.
        - **Checking for a Composition**: Checks if the list contains a specific composition.
        - **Accessing by Index**: Retrieves and sets compositions at specific indices.
        - **Calculating Total Duration**: Calculates the total duration of all compositions in the list.

3. **Results Display**:
    - Displays the list of all compositions.
    - Shows the list after removing a composition.
    - Indicates whether a specific composition exists in the list.
    - Displays the composition at a specific index.
    - Shows the list after setting a new composition at a specific index.
    - Displays the total duration of all compositions.

## Example Output

```
All compositions in the list:
Rock: Rock Anthem (300 seconds)
Jazz: Smooth Jazz (250 seconds)
Classical: Symphony No.5 (600 seconds)
Rock: Rock Ballad (200 seconds)
Jazz: Jazz Fusion (400 seconds)
Classical: Piano Sonata No.16 (500 seconds)

Total duration of compositions in the list: 2250 seconds

After removing Rock Ballad:
Rock: Rock Anthem
Jazz: Smooth Jazz
Classical: Symphony No.5
Jazz: Jazz Fusion
Classical: Piano Sonata No.16

List contains 'Symphony No.5': true

Composition at index 2: Symphony No.5

After setting a new composition at index 2:
Rock: Rock Anthem
Jazz: Smooth Jazz
Rock: New Rock Song
Jazz: Jazz Fusion
Classical: Piano Sonata No.16
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
