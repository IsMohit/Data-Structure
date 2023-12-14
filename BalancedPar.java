class SNode{
    SNode next;
    char data;

    SNode(char data){
        this.data=data;
        next=null;
    }
}
class StackSt{
    SNode top;
    StackSt(){
        top = null;
    }

    public void push(char ch){
        SNode newnode = new SNode(ch);

        if(top == null){
            top = newnode;
            return;
        }
        newnode.next =top;
        top = newnode;
    }


    public boolean isEmpty(){
        return top == null;
    }

    public char pop(){
        if (isEmpty()) {
            return 'c';
        }
        
        top =top.next;
        return 'c';
    }
}

public class BalancedPar {

    public static boolean checkParentheses(String str){
        StackSt stack = new StackSt();

        for(int i = 0 ; i < str.length() ; i++){
            char tmp = str.charAt(i);
            if(tmp == '(' || tmp == '[' || tmp == '{'){
                stack.push(tmp);
                continue;
            }


            if(stack.isEmpty()){
                return false;
            }

            char check;
            switch (tmp) {
                case ')':
                check = stack.pop();
                if(check == '{' || check == '[')
                return false;
                    break;

                case '}':
                check = stack.pop();
                if(check == '[' || check == '(')
                return false;
                break;

                case ']':
                check = stack.pop();
                if(check == '(' || check == '{')
                return false;
                break;
            }

            
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "()({})";
        if(checkParentheses(str)){
            System.out.println(str+" is Balanced !! ");
        }
        else{
            System.out.println(str+" is not Balanced !! ");
        }
    }
}
