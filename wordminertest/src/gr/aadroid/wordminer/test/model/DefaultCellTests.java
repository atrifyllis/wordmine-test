package gr.aadroid.wordminer.test.model;

import gr.aadroid.wordminer.WordMinerGame;
import gr.aadroid.wordminer.model.Cell;
import gr.aadroid.wordminer.model.DefaultCell;
import gr.aadroid.wordminer.model.Position;
import android.test.ActivityInstrumentationTestCase2;

public class DefaultCellTests extends ActivityInstrumentationTestCase2<WordMinerGame> {

	Cell testCell;

	public DefaultCellTests() {
		super(WordMinerGame.class);
	}

	public void setUp() {
		testCell = new DefaultCell();
		testCell.position = new Position(3, 3);
		testCell.setLetter("Κ");
	}

	public void testIsEqual() {
		Cell cellToCompare = new DefaultCell(new Position(3, 3), "Κ", 0);
		assertTrue(testCell.isEqual(cellToCompare));
	}

	public void testCopyOperationCopiesAllPropertiesOfCellCorrectly() {
		Cell copiedCell = testCell.copy();
		assertEquals(0, copiedCell.position.getX());
		assertEquals(0, copiedCell.position.getY());
		assertEquals(3, copiedCell.position.getRow());
		assertEquals(3, copiedCell.position.getColumn());
		assertEquals("Κ", copiedCell.getLetter());
		assertEquals(0, copiedCell.getShiftCells());
	}
}
