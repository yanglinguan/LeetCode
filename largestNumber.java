class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "0";
        PriorityQueue<Integer> maxHeap = new PriorityQueue(nums.length, new Comparator<Integer>() {
            public int compare(Integer n1, Integer n2) {
                int[] digits1 = Integer.toString(n1).chars().map(c -> c-='0').toArray();
                int[] digits2 = Integer.toString(n2).chars().map(c -> c-='0').toArray();
                
                int minSize = digits1.length > digits2.length ? digits2.length : digits1.length;
                
                int maxSize = digits1.length + digits2.length - minSize;
                
                for(int i = 0; i < minSize; i++) {
                    if (digits2[i] > digits1[i]) {
                        return 1;
                    } else if (digits2[i] < digits1[i]) {
                        return -1;
                    }
                }
                
                int j = 0;
                int i = 0;
                for(i = minSize; i < maxSize; ) {
                    if(digits1.length < digits2.length) {
                        if(digits2[i] > digits1[j]) {
                            return 1;
                        } else if( digits2[i] < digits1[j]) {
                            return -1;
                        } else {
                            j++;
                            j %= minSize;
                            if(i + 1 == maxSize) {
                                if(digits2[i] > digits1[j]){
                                    return 1;
                                } else {
                                    return -1;
                                }
                            } 
                            i++;
                        }
                    } else {
                        if (digits2[j] > digits1[i]) {
                            return 1;
                        } else if(digits2[j] < digits1[i]) {
                            return -1;
                        } else {
                            j++;
                            j %= minSize;
                            if(i + 1 == maxSize) {
                                if(digits2[j] > digits1[i]){
                                    return 1;
                                } else {
                                    return -1;
                                }
                            } 
                            i++;
                            
                        }
                    }
                }
                if( j > 0 ) {
                    if(digits1.length < digits2.length) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
                return 0;
            }
        });
        
        StringBuilder s = new StringBuilder();
        
        for(int i: nums) {
            maxHeap.offer(i);
        }
        
        if(maxHeap.peek() == 0) return "0";
        
        while(!maxHeap.isEmpty()) {
            s.append(maxHeap.poll());
        }
        
        return s.toString();
    }
}
