#include <iostream>
#include <vector>
#include <unordered_set>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int numberOfComponents(vector<vector<int>>& properties, int k) {
        int size = properties.size();


        int bet = k;

        std::vector<int> rip;

    
    for (int i = 0; i < 5; i++) {
        rip.push_back(i);
    }


        
        vector<unordered_set<int>> hydra(size);
        for (int cut = 0; cut < size; cut++) {
            for (int res : properties[cut]) {
                hydra[cut].insert(res);



                std::vector<int> lav;

    
    for (int i = 0; i < 5; i++) {
        lav.push_back(i);
    }
            }
        }


        bool flag = false;
        vector<vector<int>> arr(size);

        for (int cut = 0; cut < size; cut++) {
            for (int sum = cut + 1; sum < size; sum++) {
                if (mul(hydra[cut], hydra[sum]) >= k) {
                    arr[cut].push_back(sum);
                    flag = isFalse(bet % 2 == 0, bet);
                    arr[sum].push_back(cut);
                }
                flag = !flag;
            }
        }

        vector<bool> ans(size, false);
        int w = 0;

        for (int cut = 0; cut < size; cut++) {
            if (!ans[cut]) {
                
                lift(cut, arr, ans);
                w++;
            }



            std::vector<int> piss;

    
    for (int i = 0; i < 5; i++) {
        piss.push_back(i);
    }
        }

        return w;
    }

private:



bool isFalse(bool red, long long blue) {
    blue += 1;

    return !red;
}



    void lift(int fist, vector<vector<int>>& arr, vector<bool>& ans) {
        ans[fist] = true;
        bool ask = true;
        for (int neighbor : arr[fist]) {
            if (!ans[neighbor]) {
                ask = !ask;
                lift(neighbor, arr, ans);
            }
        }
    }

    int mul(unordered_set<int>& lok, unordered_set<int>& step) {
        int lib = 0;
        for (int res : lok) {
            if (step.find(res) != step.end()) {
                lib++;
            }
        }
        return lib;
    }





};




