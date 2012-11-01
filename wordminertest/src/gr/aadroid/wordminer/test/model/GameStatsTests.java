package gr.aadroid.wordminer.test.model;

import gr.aadroid.wordminer.WordMinerGame;
import gr.aadroid.wordminer.model.GameStats;
import gr.aadroid.wordminer.model.Level;
import gr.aadroid.wordminer.model.PersistentGameStats.LevelRank;
import android.test.ActivityInstrumentationTestCase2;

public class GameStatsTests extends ActivityInstrumentationTestCase2<WordMinerGame> {

	Level currentLevel;
	GameStats gstats;

	public GameStatsTests() {
		super(WordMinerGame.class);
	}

	public void setUp() {
		gstats = new GameStats();
		currentLevel = new Level(1);
		currentLevel.setGoldThreshold(10);
		currentLevel.setScoreDecreaseStep(5);
		currentLevel.setMaxScore(1000);
		gstats.levelTime = 9;
	}

	public void testCalculateLevelRankForGold() {
		 gstats.calculateLevelRank(currentLevel);
		assertEquals(LevelRank.GOLD, gstats.levelRank);
	}
	
	public void testCalculateLevelScore(){
		gstats.calculateLevelScore(currentLevel);
		assertEquals(950, gstats.score);
	}
}
