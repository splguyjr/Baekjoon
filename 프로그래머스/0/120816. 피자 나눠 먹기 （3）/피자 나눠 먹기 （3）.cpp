#include <string>
#include <vector>

using namespace std;

int solution(int slice, int n) {
    int answer;
    if(n % slice) answer = n / slice + 1;
    else answer = n / slice;
    return answer;
}