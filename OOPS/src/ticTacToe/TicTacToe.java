package ticTacToe;

import java.util.Scanner;

public class TicTacToe {

	private Player player1, player2;
	private Board board;

	public void startGame() {
		Scanner s = new Scanner(System.in);
		// players input
		player1 = takePlayerInput(1);
		player2 = takePlayerInput(2);
		while (player2.getSymbol() == player1.getSymbol()) {
			System.out.println("Symbol already taken !! Pick another symbol !!");
			System.out.println("Enter another symbol: ");
			char symbol = s.next().charAt(0);
			player2.setSymbol(symbol);
		}

		// create board
		board = new Board(player1.getSymbol(), player2.getSymbol());

		// conduct the game
		boolean player1Turn = true;
		int status = Board.INCOMPLETE;
		while (status == Board.INCOMPLETE || status == Board.INVALID) {
			if (player1Turn) {
				System.out.println("Player 1 - " + player1.getName() + "'s turn");
				System.out.println("Enter x: ");
				int x = s.nextInt();
				System.out.println("Enter y: ");
				int y = s.nextInt();
				status = board.move(player1.getSymbol(), x, y);
				if (status != Board.INVALID) {

					player1Turn = false;
					board.print();
				} else {
					System.out.println("Invalid Move !! Try Again !!");
				}

			} else {
				System.out.println("Player 2 - " + player2.getName() + "'s turn");
				System.out.println("Enter x: ");
				int x = s.nextInt();
				System.out.println("Enter y: ");
				int y = s.nextInt();
				status = board.move(player2.getSymbol(), x, y);
				if (status != Board.INVALID) {
					player1Turn = true;
					board.print();
				} else {
					System.out.println("Invalid Move !! Try Again !!");
				}

			}
		}

		// conclusion
		if (status == Board.PLAYER_1_WINS) {
			System.out.println("Player 1 - " + player1.getName() + " WINS !!");
		} else if (status == Board.PLAYER_2_WINS) {
			System.out.println("Player 2 - " + player2.getName() + " WINS !!");
		} else {
			System.out.println("!! DRAW !!");
		}
	}

	private Player takePlayerInput(int num) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Player " + num + " name: ");
		String name = s.nextLine();
		System.out.println("Enter Player " + num + " symbol: ");
		char symbol = s.next().charAt(0);
		Player p = new Player(name, symbol);
		return p;
	}

	public static void main(String[] args) {
		TicTacToe t = new TicTacToe();
		t.startGame();
	}
}
