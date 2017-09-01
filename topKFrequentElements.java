class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> bucket = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!bucket.containsKey(nums[i])) {
                bucket.put(nums[i], 0);
            }
            bucket.put(nums[i], bucket.get(nums[i]) + 1);
        }
        
        List<Integer>[] frequency = new List[nums.length + 1];
        
        for(int key: bucket.keySet()) {
            if(frequency[bucket.get(key)] == null) {
                frequency[bucket.get(key)] = new ArrayList<Integer>();
            }
            frequency[bucket.get(key)].add(key);
        }
        
        for(int i = frequency.length - 1; i >= 0; i--) {
            int j = 0;
            while(result.size() < k  && frequency[i] != null && j < frequency[i].size() ) {
                result.add(frequency[i].get(j));
                
                j++;
            }
        }
        
        return result;
    }
}
