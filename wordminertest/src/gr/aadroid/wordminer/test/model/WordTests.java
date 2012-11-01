package gr.aadroid.wordminer.test.model;

import java.util.ArrayList;

import gr.aadroid.wordminer.WordMinerGame;
import gr.aadroid.wordminer.model.Cell;
import gr.aadroid.wordminer.model.DefaultCell;
import gr.aadroid.wordminer.model.Position;
import gr.aadroid.wordminer.model.Word;
import android.test.ActivityInstrumentationTestCase2;

public class WordTests extends ActivityInstrumentationTestCase2<WordMinerGame> {

	Word wordToTest;
	Cell cell_0_1_epsilon;

	public WordTests() {
		super(WordMinerGame.class);
	}

	public void setUp() throws Exception {
		super.setUp();
		wordToTest = new Word();
		Cell cell_0_0_taf = new DefaultCell(new Position(0, 0), "Τ", 0);
		cell_0_1_epsilon = new DefaultCell(new Position(0, 1), "Ε", 0);
		Cell cell_0_2_sigma = new DefaultCell(new Position(0, 2), "Σ", 0);
		Cell cell_0_3_taf = new DefaultCell(new Position(0, 3), "Τ", 0);
		ArrayList<Cell> wordCells = new ArrayList<Cell>();
		wordCells.add(cell_0_0_taf);
		wordCells.add(cell_0_1_epsilon);
		wordCells.add(cell_0_2_sigma);
		wordCells.add(cell_0_3_taf);
		wordToTest.setCells(wordCells);
	}

	public void testGetWordAsString() {
		String wordAsString = wordToTest.getWordAsString();
		assertEquals("ΤΕΣΤ", wordAsString);
	}

	public void testFindCell() {
		int positionOfCellInWord = wordToTest.findCell(cell_0_1_epsilon);
		assertEquals(1, positionOfCellInWord);
	}
}
