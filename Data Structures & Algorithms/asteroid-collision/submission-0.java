class Solution {
    public int[] asteroidCollision(int[] asteroids) {
                Stack<Integer> stack = new Stack<>();

        for(int asteroid : asteroids){
            boolean destroyed = false;

            //olny process collision if current goes left and top goes right
            while(!stack.isEmpty() && asteroid <0 && stack.peek() >0){

                int top = stack.peek();

                if(Math.abs(asteroid) > top){
                    stack.pop();
                }else if(Math.abs(asteroid) == top){
                    stack.pop();
                    destroyed = true;
                    break;
                }else{
                    destroyed = true;
                    break;
                }

            }

            if(!destroyed)
                stack.push(asteroid);
        }

        //convert stack to array

        int[] result = new int[stack.size()];

        for(int i = stack.size()-1 ;i>=0;i--){
            result[i] = stack.pop();
        }

        return result;
    }
}