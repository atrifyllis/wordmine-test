package gr.aadroid.wordminer.test.model;

import java.util.ArrayList;

import gr.aadroid.wordminer.WordMinerGame;
import gr.aadroid.wordminer.model.Cell;
import gr.aadroid.wordminer.model.DefaultCell;
import gr.aadroid.wordminer.model.Position;
import gr.aadroid.wordminer.model.WordGrid;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.view.SurfaceView;

public class WordGridTests extends ActivityInstrumentationTestCase2<WordMinerGame> {

	WordGrid grid;
	private Position position_3_3;
	DefaultCell cell_3_3_Omega;
	
	public WordGridTests() {
		super(WordMinerGame.class);
	}



	@Override
	public void setUp() throws Exception {
		super.setUp();
		position_3_3 = new Position(3, 3);
		grid = new WordGrid(7);
		cell_3_3_Omega = new DefaultCell(position_3_3, "Ω", 1);
		grid.setCellAtPosition(cell_3_3_Omega, position_3_3);
	}

	public void testGetSizeReturnsCorrectGridSize() {
		assertEquals(7, grid.getSize());
	}

	public void testRetrieveCellRetrievesCorrectCellLetter() {
		Cell tempCell = grid.retrieveCell(position_3_3);
		assertEquals("Ω", tempCell.getLetter());
	}
	
	public void testRemoveCell(){
		int success = grid.removeCell(position_3_3);
		assertEquals(0, success);
		assertEquals(" ", grid.retrieveCell(position_3_3).getLetter());
	}
	
	public void testSetCellAtPosition(){
		cell_3_3_Omega = new DefaultCell(position_3_3, "Ω", 1);
		grid.setCellAtPosition(cell_3_3_Omega, position_3_3);
		assertEquals("Different cell instances", cell_3_3_Omega, grid.retrieveCell(position_3_3));
		assertEquals("Ω", grid.retrieveCell(position_3_3).getLetter());
	}
	
	public void testIsCellAdjacent(){
		Cell adjacentCell = grid.retrieveCell(new Position(3, 4));
		assertTrue(grid.isCellAdjacent(cell_3_3_Omega, adjacentCell));
	}
	
	public void testIsCellInPosition(){
		assertTrue(grid.isCellInPosition(cell_3_3_Omega, position_3_3));
	}
	
	public void testGetColumn(){
		ArrayList<Cell> column_3 = grid.getColumn(3);
		assertEquals(cell_3_3_Omega, column_3.get(3));
		assertEquals("Ω", column_3.get(3).getLetter());
	}
}
