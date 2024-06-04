package depaul.edu.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import depaul.edu.Authentication.UserFileReaderWriter;

class UserFileReaderWriterTest {

	@Test
	void testLoadUserNames() {
		assertTrue(UserFileReaderWriter.loadUserNames() instanceof ArrayList<String>);
	}

}
