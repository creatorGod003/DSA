class palidrome{

    public static void main(String[] args){

        String s = "abac";
        System.out.println(palidrome(s, 0));

    }

    public static boolean palidrome(String s, int i){
        
        if(i>=s.length()/2){
            return true;
        }

        if(s.charAt(i)==s.charAt(s.length()-i-1)){
            return palidrome(s, i+1) ;
        }
        else return false;

    }

}