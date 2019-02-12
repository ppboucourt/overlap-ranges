# Cities Connection Challenge

The challenge consist in remove the overlaps pair of numbers in a list of pairs.


## Development

AS part of the solution I had created a class Pair:
    
    class Pair {
        int first;
        int second
        .
        .
    }

The class represent the logic design for two pairs of numbers

The code in PairServiceImpl remove the overlaps pairs and return a list 
with the final values with a time complexity of **O(n^2)** where **n** is 
the number of pairs in the list.   
    
    

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
