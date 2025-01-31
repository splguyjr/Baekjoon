#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> dots) {
    double answer = 0;
    sort(dots.begin(), dots.end());
    int x = abs(dots[1][1] - dots[0][1]);
    int y = abs(dots[2][0] - dots[1][0]);
    answer = x * y;
    return answer;
}