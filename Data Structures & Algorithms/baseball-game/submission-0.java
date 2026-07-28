class Solution {
    public int calPoints(String[] operations) {
                Stack<Integer> stack = new Stack<>();

        for(String op: operations){
            if(op.equals("+")){
                int top = stack.pop();
                int newScore = top + stack.peek();
                stack.push(top);
                stack.push(newScore);
            }else if(op.equals("D")){
                int top = stack.peek();
                stack.push(top*2);            
            }else if(op.equals("C")){
                stack.pop();
            }else{
                stack.push(Integer.parseInt(op));
            }
        }


        int total=0;
        for(int score : stack){
            total += score;
        }
        return total;
        
    }
}