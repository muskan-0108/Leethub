class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        return findidx(nums,target,0,new ArrayList<>());   
    }
    List<Integer> findidx(int[] arr,int target,int idx,List<Integer> list){     
        if(idx>=arr.length) return list;
        if(arr[idx]==target){
             list.add(idx);    
        }
        return findidx(arr,target,idx+1,list);
    }
}