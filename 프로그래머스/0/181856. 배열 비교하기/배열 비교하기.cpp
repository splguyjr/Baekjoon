#include <string>
#include <vector>

using namespace std;

int sum(vector<int> v) {
    int sum = 0;
    
    for(int i = 0; i < v.size(); i++) {
        sum += v[i];
    }
    
    return sum;
}

int solution(vector<int> arr1, vector<int> arr2) {
    int answer = 0;
    
    if (arr1.size() != arr2.size()) {
        return arr1.size() > arr2.size() ? 1 : -1;
    }
    
    int sum1 = sum(arr1);
    int sum2 = sum(arr2);
    
    if(sum1 == sum2) {
        answer = 0;
    }
    
    else {
        answer = sum1 > sum2 ? 1 : -1;
    }
    
    return answer;
}