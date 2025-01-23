#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(int a, int b) {
    string c = to_string(a);
    string d = to_string(b);
    
    if (c[0] != d[0])  return c[0] > d[0];
    return c + d > d + c;
}


string solution(vector<int> numbers) {
    string answer = "";
    
    sort(numbers.begin(), numbers.end(), compare);
    
    bool check = false;
    
    for (int i = 0; i < numbers.size(); i++) {
        answer += to_string(numbers[i]);
        if (numbers[i] != 0) {
            check = true;
        }
    }
    
    if(check) return answer;
    else return "0";
}