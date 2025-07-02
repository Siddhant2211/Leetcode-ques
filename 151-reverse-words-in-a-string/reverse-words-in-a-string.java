class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        s = s.replaceAll("\\s+", " ");
        String ans = "";
        String temp = "";
        for(char ch : s.toCharArray()){
            if(ch != ' ') temp += ch;
            else{
                if(!ans.equals("")) ans = temp + " " + ans;
                else ans = temp;
                temp = "";
            }
        }

        if(!temp.equals("")){
            if(!ans.equals("")) ans = temp + " " + ans;
            else ans = temp;
        }

        return ans;
    }
}