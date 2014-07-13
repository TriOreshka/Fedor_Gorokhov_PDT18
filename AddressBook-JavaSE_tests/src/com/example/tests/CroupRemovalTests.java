package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.fw.RAND;
import com.example.utils.SortedListOf;

public class CroupRemovalTests extends TestBase {

	@Test
	public void deleteSomeGroup() throws Exception {
		// save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
		int index = RAND.getIntRand(oldList.size() - 1);
		// actions
		app.getGroupHelper().deleteGroup(index);
		// save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
		// compare states
		assertThat(newList, equalTo(oldList.without(index)));
	}
}
