package com.scholastic.test.challenge;

import com.scholastic.test.challenge.domain.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PairServiceImpl {

    /**
     * Design an algorithm and write code to identify
     * the overlapping intervals for the following sequence
     * of pairs: {[2, 5], [100, 200], [15, 22], [4, 16]}.
     * The output should be: {[2, 22], [100, 200]}
     *
     * {[2, 5], [4, 16], [15, 22], [100, 200]}
     *
     * i = 4
     * pivot = 22
     * j = 4
     * {[2, 22]}
     */

    public List<Pair> removeOverlapValues(List<Pair> list) {

        list.sort(Comparator.comparingInt(Pair::getFirst));
        List<Pair> result = new ArrayList<>();

        int count;
        for (int i = 0; i < list.size(); i = count) {
            Pair newPair = new Pair();
            int j = i+1;
            while (j < list.size()) {
                if(list.get(i).getSecond() >= list.get(j).getFirst()) {
                    newPair.setFirst(list.get(i).getFirst());
                    newPair.setSecond(Math.max(list.get(i).getSecond(), list.get(j).getSecond()));
                } else {
                    if(newPair.getSecond() >= list.get(j).getFirst()) {
                        newPair.setSecond(Math.max(newPair.getSecond(), list.get(j).getSecond()));
                    } else {
                        newPair.setFirst(list.get(i).getFirst());
                        newPair.setSecond(Math.max(newPair.getSecond(), list.get(i).getSecond()));
                        break;
                    }
                }
                j++;
            }
            result.add(newPair);
            count = j;
        }
        return result;
    }
}
