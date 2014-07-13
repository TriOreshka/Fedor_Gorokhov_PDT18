package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.fw.RAND;
import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group) throws Exception {
		// save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
		int index = RAND.getIntRand(oldList.size() - 1);
		// actions
		app.getGroupHelper().modifyGroup(index, group);
		// save new state & compare states
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
		assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
	}
}