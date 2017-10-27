// medium


class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill)
    {
        Map<Integer, List<Integer>> map = new HashMap<>();
        // init
        for (int i = 0; i < ppid.size(); i++)
        {
            int parent = ppid.get(i);
            int child = pid.get(i);

            map.computeIfAbsent(parent, k->new ArrayList<>()).add(child);
        }

        // result list
        List<Integer> res = new ArrayList<>();
        Queue<Integer> que = new ArrayDeque<>();
        // init
        que.offer(kill);
        while (!que.isEmpty())
        {
            int p = que.poll();
            res.add(p);
            // no child?
            if (map.containsKey(p))
            {
                que.addAll(map.get(p));
            }
        }

        return res;
    }
}
