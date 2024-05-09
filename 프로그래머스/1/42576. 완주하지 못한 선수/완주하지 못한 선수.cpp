#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

unordered_map<string, int> um;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    
    for (auto person : participant) {
        if(um[person]>0) {
            um[person]++;
        }
        else
            um[person] = 1;
    }
    
    for (auto person : completion) {
        um[person]--;
    }
    
    for (auto person : participant) {
        if(um[person]) {
            answer = person;
            return answer;
        }
    }
    
    
}