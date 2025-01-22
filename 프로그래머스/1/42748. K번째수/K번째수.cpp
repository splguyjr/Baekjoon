#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int a,b,c;
vector<int> answer;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    for (int i = 0; i< commands.size(); i++) {
        a = commands[i][0];
        b = commands[i][1];
        c = commands[i][2];
        
        vector<int> v;
        for(int j = a-1; j < b; j++) {
            v.push_back(array[j]);
        }
        sort(v.begin(), v.end());
        
        answer.push_back(v[c-1]);
    }
    return answer;
}