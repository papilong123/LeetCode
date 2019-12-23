public class Solution {

    private List<List<Integer>> res=new ArrayList<>();
    private int len;
    private int[] candidates;

    private void findcombination(int residue,int start,Stack<Integer> pre){
        if(residue==0){
            res.add(new ArrayList<>(pre));
            return;
        }

        for(int i=start ; i<len && residue-candidates[i]>=0;i++){
            pre.add(candidates[i]);
            findcombination(residue - candidates[i],i,pre);
            pre.pop();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates,int target){
        int len=candidates.length;
        if(len==0){
            return res;
        }
        Arrays.sort(candidates);
        this.len=len;
        this.candidates=candidates;
        findcombination(target,0,new Stack<>());
        return res;
    }

    public static void main(String[] arg){
        int[] candidates={2,3,6,7};
        int target=7;
        Solution solution=new Solution();
        List<List<Integer>> combinationSum= solution.combinationSum(candidates,target);
        System.out.println(combinationSum);
    }

}
