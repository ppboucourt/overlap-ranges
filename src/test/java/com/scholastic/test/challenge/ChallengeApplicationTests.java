package com.scholastic.test.challenge;

import com.scholastic.test.challenge.domain.Pair;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChallengeApplicationTests {

//    Injecting the service
    @Autowired
    private PairServiceImpl pairService;

    private List<List<Pair>> lists;
    private List<List<Pair>> expected;


    @Test
    @Before
	public void contextLoads() {

        expected = new ArrayList<>();
        lists = new ArrayList<>();

        List<Pair> expected1 = new ArrayList<>();
        expected1.add(new Pair(2, 22));
        expected1.add(new Pair(100, 200));

        List<Pair> list1 = new ArrayList<>();
        list1.add(new Pair(2, 5));
        list1.add(new Pair(15, 22));
        list1.add(new Pair(100, 200));
        list1.add(new Pair(4, 16));
        list1.add(new Pair(150, 200));

        List<Pair> expected2 = new ArrayList<>();
        expected2.add(new Pair(1, 100));

        List<Pair> list2 = new ArrayList<>();
        list2.add(new Pair(1, 100));
        list2.add(new Pair(2, 5));
        list2.add(new Pair(50, 60));
        list2.add(new Pair(89, 99));

        expected.add(expected1);
        expected.add(expected2);
        lists.add(list1);
        lists.add(list2);

//        {[1, 100], [2, 5], [50, 60], [89, 99]}
//        {[24, 58], [14, 26], [1, 2], [56, 80]}

	}


//expected.get(0).get(0).getFirst() == ((Pair) actual.get(0)).getFirst()
	@Test
	public void removeOverlapValues() {
        for (int i = 0; i < lists.size(); i++) {
            List<Pair> result = pairService.removeOverlapValues(lists.get(i));
            for (int j = 0; j < result.size() ; j++) {
                assertThat(result.get(j).getFirst(), is(expected.get(i).get(j).getFirst()));
                assertThat(result.get(j).getSecond(), is(expected.get(i).get(j).getSecond()));
            }
        }
    }

}

