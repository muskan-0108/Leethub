class MyStack {
    Queue<Integer> q = new LinkedList<>();
    //using i queue
    //push efficient push O(1),pop,peek O(n)

    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        for(int i=1;i<q.size();i++){
            q.add(q.remove());
        }
        int val = q.remove();
        return val;
    }
    
    public int top() {
        //peek 1 2 3 4-> 4
        for(int i=1;i<q.size();i++){
            q.add(q.remove());
        }
        // 4 1 2 3
        int val = q.peek();//4
        q.add(q.remove());
        return val;
    }
    
    public boolean empty() {
        if(q.size()==0) return true;
        else return false;
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */