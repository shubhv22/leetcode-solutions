class Solution {
    public boolean isPalindrome(int x) {
        int rev = 0, rem, temp=x;
        while (x != 0){
            rem = x % 10;
            rev = rev * 10 + rem;
            x = x/10;
        }
        if (temp==0){
            return true;
        }
        if (temp == rev && temp > 0){
            return true;
        }
        else{
            return false;
        }
}
    public void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPalindrome(n));
        sc.close();
    }
}