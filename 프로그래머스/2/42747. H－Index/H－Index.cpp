#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    
    sort(citations.rbegin(), citations.rend());
    int siz = citations.size();
    
    //0부터 올라가면서 확인하기
    //5 4 3 2 1
    //1
    //2
    //3
    for(int i = 1; i<=siz; i++) {
        int count = 0;
        for(int j = 0; j<siz; j++) {
            if(citations[j] < i) {
                break;
            }
            count++;
        }
        if(count >= i)
            answer = max(i, answer);
    }
    return answer;
}