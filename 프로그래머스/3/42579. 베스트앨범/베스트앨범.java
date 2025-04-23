import java.util.*;

class Solution {
    static Map<String, Integer> hm = new HashMap<>();
    static class Music implements Comparable<Music>{
        String genre;
        int count;
        int idx;
        
        Music(String genre, int count, int idx) {
            this.genre = genre;
            this.count = count;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(Music m) {
            return Integer.compare(m.count, this.count);
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        int n = genres.length;
        
        // 장르별 총 재생 횟수를 Map에 먼저 저장
        for (int i = 0; i < n; i++) {
            hm.put(genres[i], hm.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        int cnt = hm.size();
        Map<String, Integer> idxMap = new HashMap<>();
        // 장르별 인덱스가 필요하므로 따로 구해놓기
        int idx = 0;
        for (String key : hm.keySet()) {
            idxMap.put(key, idx++);
        }
        
        // 리스트에 같은 장르별로 순서대로 저장
        
        List<Music>[] list = new ArrayList[cnt];
        for (int i = 0; i < cnt; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            String g = genres[i];
            int p = plays[i];
            
            idx = idxMap.get(g); // 장르별 인덱스
            Music m = new Music(g, p, i);
            list[idx].add(m);
        }
        
        // 각 장르별로 나눠놓은 리스트를 정렬
        for (int i = 0; i < cnt; i++) {
           list[i].sort(null);
        }
        // 장르 정렬
        List<String> sortedGenres = new ArrayList<>(hm.keySet());
        sortedGenres.sort((a, b) -> hm.get(b) - hm.get(a));
        
        List<Integer> answerList = new ArrayList<>();
        
        for (String key : sortedGenres) {
            idx = idxMap.get(key);
            for (int i = 0; i < list[idx].size(); i++) {
                if (i == 2) break;
                answerList.add(list[idx].get(i).idx);
            }
        }
        
        return answerList.stream().mapToInt(i->i).toArray();
    }
}