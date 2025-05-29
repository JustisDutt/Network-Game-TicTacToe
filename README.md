# TicTacToeNetwork

A networked Tic-Tac-Toe game implemented in Java using TCP sockets and Java Swing for the GUI. This project allows two players to play Tic-Tac-Toe over a network, with one acting as the server and the other as the client.

## Features
- **Networked Gameplay**: Players can connect over a TCP network (local or remote).
- **GUI**: Built with Java Swing using WindowBuilder in Eclipse.
- **Game Logic**: Supports win/draw detection, replay functionality, and real-time board updates.
- **Multithreading**: Uses separate threads for client and server to handle network communication.

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- Eclipse IDE with WindowBuilder plugin installed
- Basic understanding of Java Swing and TCP sockets

## Project Structure
TicTacToeNetwork/
├── src/
│   └── tictactoeNetwork/
│       ├── TicTacToe.java        # Common variables and methods
│       ├── TicTacToeClient.java  # Client logic
│       ├── TicTacToeServer.java  # Server logic
│       ├── TicTacToeGUI.java     # GUI implementation
├── README.md
└── LICENSE 


## Setup Instructions
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/JustisDutt/TicTacToeNetwork.git
   cd TicTacToeNetwork
2. Import into Eclipse:
Open Eclipse and select File > Import > General > Existing Projects into Workspace.
Choose the TicTacToeNetwork directory and import the project.

4. Install WindowBuilder (if not already installed):
5. 
6. Run the Application:
Open two Eclipse windows (or two instances of the program).
In one window, run TicTacToeGUI.java as the server:
Enter a port number (e.g., 50000) in the MyPort field and click Run Server.
In the other window, run TicTacToeGUI.java as the client:
Enter the server’s IP (e.g., 127.0.0.1 for localhost) and port (e.g., 50000), then click Connect.

8. Play the game! The client uses "O", and the server uses "X".



License
MIT License

Acknowledgments
Created by Danny Kim
Built following the tutorial for networked Tic-Tac-Toe using TCP sockets
