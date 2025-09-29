package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FlattenNestedListIterator implements Iterator<Integer> {

    List<Integer> flatList = new ArrayList<>();

    int index = 0;

    FlattenNestedListIterator(List<NestedInteger> nestedList) {
        for (NestedInteger item : nestedList) flattenList(item);
    }

    @Override
    public Integer next() {
        Integer x = flatList.get(index);
        index++;
        return x;
    }

    @Override
    public boolean hasNext() {
        return index < flatList.size();
    }

    private void flattenList(NestedInteger current) {
        if (current.isInteger()) {
            flatList.add(current.getInteger());
            return;
        }

        for (NestedInteger item : current.getList()) {
            if (item.isInteger()) flatList.add(item.getInteger());
            else flattenList(item);
        }
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
