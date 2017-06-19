package com.sss.game;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 *  This program takes input positions for knight piece for two players. Player can't set the knight in the bottom right corner of the chess board.
 *  The program ends when any knight reaches the bottom right corner of the chess board.  
 *  @author Saikumar Divvela   
 */
public class ChessBoard {
	public static final int BOARD_WIDTH = 8;
	public static final int BOARD_HEIGHT = 8;
	private List<Square> squares = new LinkedList<Square>();
	private Square source1,source2,dest;
	
	public ChessBoard() throws Exception{
		init();
		dest = new Square(8,1);
		//System.out.println(dest.toString());
	}
	
	/**
	 * Initialized the 8 by 8 chess board with blank pieces. 
	 * @throws Exception
	 */
	private void init() throws Exception{
		for(int i=1;i<=BOARD_WIDTH;i++){
			for(int j=1;j<=BOARD_HEIGHT;j++){
				squares.add(new Square(i,j));
			}
		}
	}
	
	
	/**
	 * Reads the position of knight for two players. Finds the best path from source to destination (H1) and each player players one after one.
	 * If the next move of any player can't be performed as the target square is not empty then the path is recalculated.
	 * @throws IllegalArgumentException
	 */
	public void play() throws IllegalArgumentException{
		info();
		
		System.out.println("Enter the position of knight for player 1. Use chess notation.");
		String move1 = readMove();
		source1 = new Square(move1,PieceType.KNIGHT);
		
		System.out.println("Enter the position of knight for player 2. Use chess notation.");
		String move2 = readMove();
		source2 = new Square(move2,PieceType.KNIGHT);
		
		if(move1.equalsIgnoreCase(move2)){
			throw new IllegalArgumentException("Invalid location. The square "+move2+" is not blank. Please place the knight in empty square in chess borad other than H1.");
		}
		
		// caluclate the best path for player1 and player2
		LinkedList<Square> path1 = findBestSolution(source1);
		LinkedList<Square> path2 = findBestSolution(source2);
		
		//System.out.println("size "+path1.size()+" "+path1);
		//System.out.println("size "+path2.size()+" "+path2);
		
		while(path1.size() > 1 && path2.size() >1){
			// For player1  move the piece to next location in path. If the next location is not empty then recalculate the path. 
			Square p1FirstStep = path1.get(0);
			Square p1NextStep = path1.get(1);
			while(!move(p1FirstStep,p1NextStep)){
				path1 = findBestSolution(p1FirstStep);
				p1FirstStep = path1.get(0);
				p1NextStep = path1.get(1);
			}
			
			path1.remove(0);
			System.out.println("Player1 START: "+p1FirstStep.getChessNotation()+" END: "+p1NextStep.getChessNotation());
			
			// For player2  move the piece to next location in path. If the next location is not empty then recalculate the path for player2.
			Square p2FirstStep = path2.get(0);
			Square p2NextStep = path2.get(1);
			while(!move(p2FirstStep,p2NextStep)){
				path2 = findBestSolution(p2FirstStep);
				p2FirstStep = path2.get(0);
				p2NextStep = path2.get(1);
			}
			path2.remove(0);
			System.out.println("Player2 START: "+p2FirstStep.getChessNotation()+" END: "+p2NextStep.getChessNotation());
		}
		
		if(path1.size()==1){
			System.out.println("Player1 wins !!!!");
		} else if(path2.size()==1){
			System.out.println("Player2 wins !!!!");
		}
	}
	
	/**
	 * Moves the piece in the source square to destination square only if the destination square is empty.
	 * Returns true if the piece is moved to destination square otherwise false is returned.
	 * @param source
	 * @param destination
	 * @return
	 */
	private boolean move(Square source, Square destination){
		Square square1 = getSquare(source.getX(),source.getY());
		Square square2 = getSquare(destination.getX(),destination.getY());
		if(square2.getPiece() == PieceType.BLANK){
			square1.setPiece(square1.getPiece());
			return true;
		}
		return false;
	}
	
	/**
	 * Finds all possible solutions from source to destination (H1) and find the shortest path. This uses DFS algorithm to calculate the different possible paths. 
	 * @param source
	 * @return
	 */
	private LinkedList<Square> findBestSolution(Square source){
		LinkedList<LinkedList<Square>> solutions = new LinkedList<LinkedList<Square>>();
		Set<Square> visited = new LinkedHashSet<Square>();
		Stack<LinkedList<Square>> stack = new Stack<LinkedList<Square>>();
		LinkedList<Square> bestPath = new LinkedList<Square>();
		
		
		LinkedList<Square> firstPath = new LinkedList<Square>();
		firstPath.add(source);
		stack.add(firstPath);
		while(!stack.isEmpty()){
			LinkedList<Square> currentPath = stack.pop();
			Square currentSquare = currentPath.getLast();
			if(currentSquare.matches(dest)){
				solutions.add(currentPath);
				//System.out.println("Solution found...."+currentPath);
				if(bestPath.size() == 0) {
					bestPath = currentPath;
				} else if(currentPath.size() < bestPath.size()) {
					bestPath = currentPath;
				}
			}
			
			if (!visited.contains(currentSquare)){
				visited.add(currentSquare);
				for(Square temp: getLegalMoviesforKnight(currentSquare)){
					LinkedList<Square> nextPath = new LinkedList<Square>();
					nextPath.addAll(currentPath);
					nextPath.addLast(temp);
					stack.push(nextPath);
					/*
					System.out.println("Path ");
					for(Square sq: nextPath){
						System.out.println(sq);
					}
					*/
				}
			}
		}
		return bestPath;
	}
	/**
	 * Return the square present in the given location
	 * @param x
	 * @param y
	 * @return
	 */
	private Square getSquare(int x,int y){
		for(Square square:squares){
			if(square.matches(x,y)){
				return square;
			}
		}
		return null;
	}
	/**
	 * Function returns all possible legal moves for the knight based on its location.
	 * Knight can have maximum 8 different moves. Some moves are invalid if the move crosses board boundary or target square is not blank
	 * @param source
	 * @return
	 */
	public List<Square> getLegalMoviesforKnight(Square source){
		List<Square> moves = new LinkedList<Square>();
	
		Square square = getSquare(source.getX()+1,source.getY()-2);
		if (square != null && square.getPiece() == PieceType.BLANK){
			moves.add(square);
		}
		square = getSquare(source.getX()-1,source.getY()-2);
		if (square != null && square.getPiece() == PieceType.BLANK){
			moves.add(square);
		}
		square = getSquare(source.getX()-1,source.getY()+2);
		if (square != null && square.getPiece() == PieceType.BLANK){
			moves.add(square);
		}
		square = getSquare(source.getX()+1,source.getY()+2);
		if (square != null && square.getPiece() == PieceType.BLANK){
			moves.add(square);
		}
		square = getSquare(source.getX()+2,source.getY()-1);
		if (square != null && square.getPiece() == PieceType.BLANK){
			moves.add(square);
		}
		square = getSquare(source.getX()-2,source.getY()-1);
		if (square != null && square.getPiece() == PieceType.BLANK){
			moves.add(square);
		}
		square = getSquare(source.getX()+2,source.getY()+1);
		if (square != null && square.getPiece() == PieceType.BLANK){
			moves.add(square);
		}
		square = getSquare(source.getX()-2,source.getY()+1);
		if (square != null && square.getPiece() == PieceType.BLANK){
			moves.add(square);
		}
		return moves;
	}
	
	/**
	 * Reads the input location in chess notation for Knight
	 * @return
	 */
	private String readMove(){
		Scanner scanner = new Scanner(System.in);
		String input = null;
		while (input == null || input.equals("")){
			input = scanner.nextLine();
			input = input.trim();
			if( ! (input.length() ==2)){
				System.out.println("Invalid location"+input+". Valid location examples A1 B2 C3 etc. Please try again.");
				input = null;
			} else if(input.length() ==2 && (input.charAt(0) < 'A' || input.charAt(0) > 'H' || input.charAt(1) < '1' || 
					input.charAt(1) > '8')) {
				System.out.println("Invalid location"+input+". Valid location examples A1 B2 C3 etc. Please try again.");
				input = null;
			} else if (input.length() ==2 && input.equalsIgnoreCase(dest.getChessNotation())){
				System.out.println("Invalid location"+input+". You can't place the knight in H1. Please try again.");
				input = null;
			}
		}
		//System.out.println(input);
		return input;
	}
	
	public static void info(){
		System.out.println("********** Help  ********** ");
		System.out.println("This program takes position of knight for two players and displays the moves for player1 and player2."
				+ "The first player whose knight reaches bottom right corner of the chess borad wins the math."
				+ "Player can't keep the Knight in location H1");
		System.out.println("Please enter the inputs in chess notations. For example A1 indicates cell 1 1 (1st row and 1st column) and  C5 indicates cell 3 5 (5th row and 3rd column)");
	}
	
	public static void main(String args[]) throws Exception{
		//new ChessBoard().play();
		Class classObj = ChessBoard.class;
		System.out.println(classObj);
		System.out.println(classObj.getClassLoader());
		System.out.println(classObj.getClass());
		System.out.println(classObj.getName());
		/*
		List<Square> paths = new ChessBoard().findBestSolution(new Square("F3"));
		System.out.println("Final path");
		for(Square sq: paths){
			System.out.println(sq);
		}*/
	}
}

/**
 * This class represents a square in chess board.
 * @author Saikumar Divvela
 *
 */
class Square {
	private int x;
	private int y;
	private String chessNotation;
	private PieceType piece;
	
	public Square(int hx,int hy) throws IllegalArgumentException{
		if( hx > ChessBoard.BOARD_WIDTH  || hy > ChessBoard.BOARD_HEIGHT){
			throw new IllegalArgumentException("Invalid location x "+x+" y "+y);
		}
		this.x = hx;
		this.y = hy;
		this.chessNotation = String.valueOf((char)('@'+x))+ String.valueOf(y);
		this.piece = PieceType.BLANK;
	}
	
	public Square(int hx,int hy,PieceType piece) throws IllegalArgumentException{
		this(hx,hy);
		this.piece = piece;
	}
	
	public Square(String str) throws IllegalArgumentException{
		if(str == null ){
			throw new IllegalArgumentException("Invalid location "+str);
		}
		
		str = str.trim().toUpperCase();
		
		if( ! (str.length() == 2) ){
			throw new IllegalArgumentException("Invalid location "+str);
		}
		
		if(str.charAt(0) <'A' || str.charAt(0) >'H' || str.charAt(1) < '1' || str.charAt(1) > '8'){
			throw new IllegalArgumentException("Invalid location "+str);
		}
		
		this.chessNotation = str;
		this.x = str.charAt(0) - 64;
		this.y = str.charAt(1) - 48;
		this.piece = PieceType.BLANK;
	}
	
	public Square(String str,PieceType piece) throws IllegalArgumentException{
		this(str);
		this.piece = piece;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public PieceType getPiece() {
		return piece;
	}

	public void setPiece(PieceType piece) {
		this.piece = piece;
	}

	public String getChessNotation(){
		return this.chessNotation;
	}
	
	public boolean matches(Square sq){
		return (this.x == sq.x && this.y == sq.y);
	}

	public boolean matches(int x,int y){
		return (this.x==x && this.y==y);
	}
	@Override
	public String toString() {
		return "Square [x=" + x + ", y=" + y + ", chessNotation="
				+ chessNotation + ", piece=" + piece + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Square other = (Square) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
}

/**
 * Enum class contains different piece types in chess board.
 * @author Saikumar Divvela
 *
 */
enum PieceType {
	KNIGHT ("N"),
	BLANK ("");
	private String chessNotation;
	PieceType(String s){
		this.chessNotation = s;
	}
	public String getChessNotation(){
		return this.chessNotation;
	}
}