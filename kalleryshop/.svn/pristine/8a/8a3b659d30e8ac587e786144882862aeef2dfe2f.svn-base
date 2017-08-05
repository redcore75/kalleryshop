package kr.co.redcore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import kr.co.redcore.service.AuthNumService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:/spring/appDaemon/daemon-context.xml", "classpath:/spring/root-context.xml", "classpath:/spring/jdbc-context.xml" })
public class TestEqualLists {
	private static final Logger logger = LoggerFactory.getLogger(TestEqualLists.class);

	//@Autowired
	//private AuthNumService authNumService;

	public TestEqualLists() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void test_equalLists() {
		List listOne = new ArrayList(Arrays.asList("a", "b", "c", "d", "e", "f", "g"));
		List listTwo = new ArrayList(Arrays.asList("a", "b", "d", "e", "f", "gg", "h"));

		if (equalLists(listOne, listTwo) == false) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		List listThree = new ArrayList(Arrays.asList("a", "b", "c", "d", "e", "f", "g"));
		List listFour = new ArrayList(Arrays.asList("a", "b", "d", "c", "e", "g", "f"));

		if (equalLists(listThree, listFour) == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		List listFive = new ArrayList(Arrays.asList("a", "b", "c", "d", "e", "f", "g"));
		List listSix = new ArrayList(Arrays.asList("a", "b", "d", "c", "e", "g"));

		if (equalLists(listFive, listSix) == false) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		List listSeven = new ArrayList(Arrays.asList("a", "b", "c", "d", "e", "f"));
		List listEight = new ArrayList(Arrays.asList("c", "b", "a", "f", "e", "d", "aa"));

		if (equalLists(listSeven, listEight) == true) {
			Assert.assertTrue(true);
		}
	}

	public boolean equalLists(List<String> src1, List<String> src2) {
		// Check for sizes and nulls
		if (src1 == null && src2 == null)
			return true;

		if ((src1 == null && src2 != null) || (src1 != null && src2 == null) || (src1.size() != src2.size())) {
			return false;
		}

		// Sort and compare the two lists
		Collections.sort(src1);
		Collections.sort(src2);

		return src1.equals(src2);
	}
}
