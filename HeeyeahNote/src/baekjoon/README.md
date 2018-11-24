### 알고리즘 문제 목록
#### [포도주 시식](https://github.com/heeyeah/AlgorithmPractice/blob/master/HeeyeahNote/src/baekjoon/P2156_drinkWine.java) - Dynamic Programming

##### 풀이법
* 시작점
  
  DP 문제에서 답 도출할 때, i번째 (혹은 i, j번째) 일 때 최적의 답을 구하고 저장해서 그 값을 쓰는 방식인 것 같아서
  
  1. Result 배열 만듦
  2. 1차원 배열인지 (i), 2차원 배열인지(i, j) 더 필요한 지 고민
  3. 잘 모르겠음
  4. 1차원으로 잡아보고 값이 더 필요하다 싶으면 2차원으로 잡기로 함

* 1차시도
  
  기준 점이 되는 i ( i=0일 때, 1번째 잔)를 선택했을 때, 이전 잔을 선택한 값, 아닌 값 두 개를 비교해 MAX 값 저장
	
  예제는 답이 잘 나와서 제출했는데, 오답…………


* 2차시도

	기준 점이 되는 i를 선택했을 때의 MAX 값은 맞는데, 이 값을 i-1의 MAX 값과 비교해야 함 ( R[i-1]값보다 R[i]이 작으면, i를 선택하지 않는 게 최선의 선택)
  
  통과

##### 참고
- http://new93helloworld.tistory.com/220
- https://www.zerocho.com/category/Algorithm/post/584b979a580277001862f182


#### [ABCDE](https://github.com/heeyeah/AlgorithmPractice/blob/master/HeeyeahNote/src/baekjoon/P13023_ABCDE.java) - Graph, DFS

##### 풀이법



##### 참고
- http://wookje.dance/2017/04/18/boj-13023-ABCDE/


#### [가장 긴 증가하는 부분 수열](https://github.com/heeyeah/AlgorithmPractice/blob/master/HeeyeahNote/src/baekjoon/P11053_LongSequence.java) - Dynamic Programming

##### 풀이법