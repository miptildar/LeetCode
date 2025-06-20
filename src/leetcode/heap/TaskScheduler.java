package leetcode.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TaskScheduler {

    public static void main(String[] args) {
        new TaskScheduler().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
    }

    Job[] heap;
    int size;

    List<Integer> buckets = new ArrayList<>();
    int singleBucketSize = 0;
    Map<Character, Integer> lastBucketForJobMap = new HashMap<>();

    public int leastInterval(char[] tasks, int n) {
        singleBucketSize = n + 1;

        Map<Character, Integer> counterMap = new HashMap<>();
        for (int i=0; i<tasks.length; i++) {
            int count = counterMap.getOrDefault(tasks[i], 0) + 1;
            counterMap.put(tasks[i], count);
        }

        heap = new Job[counterMap.size() + 1];

        for (Map.Entry<Character, Integer> entry : counterMap.entrySet()) {
            add(new Job(entry.getKey(), entry.getValue()));
        }

        Job job = getMax();
        while(job != null) {

            job.count--;
            if (job.count > 0) {
                add(job);
            }

            // distribute a job in the available bucket (create new if necessary)
            while (true) {
                int lastBucketForJob = lastBucketForJobMap.getOrDefault(job.type, -1);
                int newBucketForJob = lastBucketForJob + 1;

                // check if necessary to create a new bucket
                if (newBucketForJob == buckets.size()) {
                    buckets.add(0);
                }

                int busySlots = buckets.get(newBucketForJob);
                if (busySlots < singleBucketSize) {
                    busySlots++;
                    buckets.set(newBucketForJob, busySlots);

                    lastBucketForJobMap.put(job.type, newBucketForJob);
                    break;
                } else {
                    lastBucketForJobMap.put(job.type, newBucketForJob);
                }
            }

            job = getMax();
        }

        int bucketsCount = buckets.size();
        return (bucketsCount - 1) * singleBucketSize + buckets.get(bucketsCount - 1);
    }

    void add(Job value) {
        size++;
        heap[size] = value;

        int index = size;
        while (index > 1) {
            int parent = size / 2;
            if (heap[parent].count < heap[index].count) {
                Job temp = heap[parent];
                heap[parent] = heap[index];
                heap[index] = temp;
                index = parent;
            } else {
                break;
            }
        }
    }

    Job getMax() {
        if (size == 0) {
            return null;
        }

        Job max = heap[1];
        heap[1] = heap[size];
        size--;

        int index = 1;
        while (index <= size / 2) {

            int left = index*2;
            int right = index*2 +1;

            if (heap[left].count > heap[index].count || heap[right].count > heap[index].count) {

                if (heap[left].count > heap[right].count) {
                    Job temp = heap[left];
                    heap[left] = heap[index];
                    heap[index] = temp;
                    index = left;
                } else {
                    Job temp = heap[right];
                    heap[right] = heap[index];
                    heap[index] = temp;
                    index = right;
                }
            } else {
                break;
            }
        }

        return max;
    }

    private static class Job {
        char type;
        int count;
        Job(char type, int count) {
            this.type = type;
            this.count = count;
        }
    }
}
