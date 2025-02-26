#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> name, vector<int> yearning, vector<vector<string>> photo) {
    vector<int> answer;
    
    for(vector<string> x : photo) {
        int ans = 0;
        for(string p : x) {
            for(int i = 0; i < name.size(); i++) {
                if (p == name[i]) {
                    ans += yearning[i];
                    break;
                }
            }
        }
        answer.push_back(ans);
    }
    return answer;
}