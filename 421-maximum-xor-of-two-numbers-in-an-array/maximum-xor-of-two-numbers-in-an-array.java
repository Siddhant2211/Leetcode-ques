class Nod{
    Nod [] links;

    Nod(){
        links = new Nod [2];
    }

    boolean containsKey(int bit){
        return links [bit] != null;
    }

    Nod get(int bit){
        return links [bit];
    }

    void put(int bit, Nod node){
        links [bit] = node;
    }
}



class Trie{
    Nod root;

    Trie(){
        root = new Nod();
    }

    void insert(int num){
        Nod node = root;
        for(int i = 31; i >= 0; i--){
            int bit = (num >> i) & 1;

            if(!node.containsKey(bit)){
                node.put(bit, new Nod());
            }

            node = node.get(bit);
        }
    }

    int getMax(int num){
        Nod node = root;
        int max = 0;
        for(int i = 31; i >= 0; i--){
            int bit = (num >> i) & 1;
            if(node.containsKey(1 - bit)){
                max |= (1 << i);
                node = node.get(1 - bit);
            }
            else{
                node = node.get(bit);
            }
        }
        return max;
    }
}



class Solution {





    public int findMaximumXOR(int[] nums) {
        int max = 0;

        Trie trie = new Trie();
        for(int i : nums){
            trie.insert(i);
        }


        for(int i : nums){
            max = Math.max(max, trie.getMax(i));
        }
        
        return max;
    }
}