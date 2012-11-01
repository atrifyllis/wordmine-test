package gr.aadroid.wordminer.test.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;



import gr.aadroid.framework.Game;
import gr.aadroid.wordminer.WordMinerGame;
import gr.aadroid.wordminer.model.Level;
import gr.aadroid.wordminer.model.LevelFactory;
import android.test.ActivityInstrumentationTestCase2;
import static org.mockito.Mockito.*;

public class LevelFactoryTests extends ActivityInstrumentationTestCase2<WordMinerGame> {

	String levelsString;

	public LevelFactoryTests() {
		super(WordMinerGame.class);
	}

	public void setUp() {
		System.setProperty("dexmaker.dexcache", this.getActivity().getCacheDir().toString());
		levelsString = "[{\"number\":1,\"timeBarStepTime\":500000000,\"timeBarMaxTime\":600,\"targetGoldPoints\":1,\"goldPoints\":[{\"row\":5,\"column\":2}],\"bombPoints\":[{\"row\":2,\"column\":1},{\"row\":1,\"column\":4},{\"row\":4,\"column\":4}],\"stalagmitePoints\":[{\"row\":4,\"column\":0},{\"row\":5,\"column\":0},{\"row\":6,\"column\":0},{\"row\":4,\"column\":1},{\"row\":3,\"column\":4},{\"row\":6,\"column\":4}],\"goldCarts\":[{\"row\":8,\"column\":0},{\"row\":8,\"column\":2}],\"maxScore\":10000,\"bronzeThreshold\":30,\"silverThreshold\":20,\"goldThreshold\":5,\"scoreDecreaseStep\":100},{\"number\":2,\"timeBarStepTime\":400000000,\"timeBarMaxTime\":600,\"targetGoldPoints\":1,\"goldPoints\":[{\"row\":5,\"column\":2}],\"bombPoints\":[{\"row\":2,\"column\":3},{\"row\":2,\"column\":4},{\"row\":1,\"column\":5},{\"row\":1,\"column\":6}],\"stalagmitePoints\":[{\"row\":4,\"column\":3},{\"row\":4,\"column\":4},{\"row\":4,\"column\":5},{\"row\":4,\"column\":6}],\"goldCarts\":[{\"row\":8,\"column\":2}],\"maxScore\":10000,\"bronzeThreshold\":15,\"silverThreshold\":10,\"goldThreshold\":3,\"scoreDecreaseStep\":100}]";
	}

	public void testParseGSONFirstLevel() {
		Level level_1 = LevelFactory.parseGSON(levelsString, 1);
		assertEquals(600, level_1.getTimeBarMaxTime());
	}

	public void testGetLevelsCount() {
		int levelsCount = LevelFactory.getLevelsCount(levelsString);
		assertEquals(2, levelsCount);
	}
	
	public void testReadJSONLevels() throws IOException{
		
		//TODO: cannot mock file reading create integration test
		
	}

}
