#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    
    sort(citations.rbegin(), citations.rend());
    int siz = citations.size();
    
    for(int i = 1; i<=siz; i++) {
        int count = 0;//배열 내 i 이상인 개수
        for(int j = 0; j<siz; j++) {
            if(citations[j] < i) {
                break;
            }
            count++;
        }
        if(count >= i)
            answer = max(i, answer);
        else break;
    }
    return answer;
}