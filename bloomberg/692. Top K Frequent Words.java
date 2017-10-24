// medium


// simple to do
class Solution {
    public List<String> topKFrequent(String[] words, int k)
    {
        // store word and frequency pair
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words)
        {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> {
            // compare by key
            if (a.getValue() == b.getValue())
            {
                // compareTo method
                return  a.getKey().compareTo(b.getKey()) >= 0? -1 : 1;
            }
            // compare by frequency
            return a.getValue() - b.getValue();
        });
        // put Map.entry object into pq
        // keep the pq size as k
        for (Map.Entry<String, Integer> e : freq.entrySet())
        {
            pq.offer(e);
            if (pq.size() > k) { pq.poll(); }
        }

        List<String> res = new LinkedList<>();
        while (!pq.isEmpty())
        {
            // insert at head
            // add method!
            res.add(0, pq.poll().getKey());
        }

        return res;
    }
}
