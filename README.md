# Technical Test: Shopping Cart Implementation

This repository contains my solution to a technical test focused on implementing a shopping cart system in Java. The objective was to create a set of classes and interfaces adhering to specified requirements and functionalities.

## Project Structure

- **src/main/java**: Contains the main Java source code implementing the shopping cart system.
- **src/test/java**: Contains JUnit test cases to verify the correctness of the implemented classes and methods.
- **README.md**: Provides an overview of the project, instructions on how to compile and run the tests using Maven, and additional information about the technical test.

## Implementation Details

The shopping cart system consists of several core classes and interfaces:
- `CarrinhoCompras`: Manages the shopping cart for each customer, allowing them to add items, calculate the total value, and more.
- `Produto`: Represents products that can be added to the shopping cart, identified by a unique code.
- `Item`: Represents individual items added to the shopping cart, including details such as the product, unit price, and quantity.

The implementation adheres to specific guidelines and requirements outlined in the technical test instructions. Maven is used for project management and dependency resolution.

## How to Run

To compile and run the tests using Maven, follow these steps:
1. Ensure you have Java Development Kit (JDK) installed on your system.
2. Clone this repository to your local machine.
3. Navigate to the project directory in your terminal or command prompt.
4. Run the command `mvn compile` to compile the project.
5. Run the command `mvn test` to execute the test cases.

## Feedback and Contributions

Feedback, suggestions, and contributions to improve the implementation are welcome! Feel free to open an issue or pull request if you have any ideas or improvements to share.
