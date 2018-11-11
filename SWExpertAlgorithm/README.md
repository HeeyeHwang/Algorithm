# Programming Summary
SW Expert Academy에 있는 프로그래밍 강의 공부 내용 


<br/>


<br/>


- [SW 문제해결 기본-Array1](#sw-문제해결-기본-array1)
  * [1. Algorithm이란](#algorithm이란)
  * [2. Array에 대해서 배워보기](#array란)
  * [3. Exhaustive Search](#exhaustive-search)
  * [4. Greedy Algorithm](#greedy-algorithm)
  * [5. Sort (Bubble, Counting)](#sort)
  


<br/>


## SW 문제해결 기본-Array1

<br/>

### Algorithm이란


* 알고리즘이란?
  + 유한한 단계를 통해 문제를 해결하기 위한 절차나 방법
  + 컴퓨터가 어떤 일은 수행하기 위한 단계적 방법, 어떠한 문제를 해결하기 위한 절차

* 수도코드(Pseudo Code)
  + 특정 프로그래밍 언어의 문법을 따라 씌여진 것이 아니라, 일반적인 언어로 코드를 흉내 내어 알고리즘을 써 놓은 코드

* 순서도
  + 프로그램이나 작업의 진행 흐름을 순서에 따라 여러가지 기호나 문자로 나타낸 도표


* 무엇이 좋은 알고리즘일까?
  + 정확성 : 얼마나 정확하게 동작하는가
  + 작업량 : 얼마나 적은 연산으로 원하는 결과를 얻어내는가
  + 메모리 사용량 : 얼마나 적은 메모리를 사용하는가
  + 단순성 : 얼마나 단순한가
  + 최적성 : 더 이상 개선할 여지 없이 최적화되었는가

* 시간 복잡도(Time Complexity)
  + 실제 걸리는 시간을 측정
  + 실행되는 명령문의 개수를 계산

* 빅오 표기법
  + 시간 복잡도 함수 중에서 가장 큰 영향력을 주는 n에 대한 항만을 표시
  + 계수는 생략하여 표시
  <pre><code>O(3n + 2) = O(3n) = O(n)</code>
  <code>O(2n^2 + 10n + 100) = O(n^2)</code>
  <code>O(4) = O(1)</code>
  </pre>

<br/>

### Array란


* Array이란?
  + 일정한 자료형의 변수들을 하나의 이름으로 열거하여 사용하는 자료구조

<br/>

### Exhaustive Search


* Exhaustive Search(완전 검색)이란?
  + Brute-force 혹은 Generate-and-Test 기법
  + 문제의 해법으로 생각할 수 있는 모든 경우의 수를 나열해보고 확인하는 기법
  + 수행 속도 느리나, 해답을 찾아내지 못할 확률이 작음
  + 주어진 문제를 풀 때, 우선 완전 검색으로 접근하여 해답 도출 후 성능 개선을 위해 다른 Algorithm을 사용하고 해답을 확인하는 것이 바람직
  
* Baby-gin 게임
  + 한 개의 run과 한 개의 triplete 숫자 6개를 baby-gin이라고 함.
    + run : 123, 678
    + triplete : 555, 666
  + 고려할 수 있는 모든 경우의 수 생성 후, 앞/뒤 3자리씩 잘라 run과 triplete 여부 검사 -> 최종 baby-gin 판단

* 순열이란?
  + 서로 다른 것들 중 몇개를 뽑아서 한 줄로 나열하는 것
  + nPr, nPn=n!
  

<br/>

### Greedy Algorithm


* Greedy Algorithm(탐욕 알고리즘)이란?
  + 최적해를 구하는 데 사용되는 근시안적인 방법
  + 그 순간에 최적이라고 생각되는 것을 선택해 나가는 방식으로 진행하여 최종적인 해답에 도달
  + 각 선택의 시점에서 이루어지는 결정은 지역적으로 최적이나, 그것들을 계속 수집하여 최종적인 해답을 만들었다고 하여 최적이라는 보장은 없음
  + 일반적으로, 머리속에 떠오르는 생각을 검증 없이 바로 구현하면 Greedy 접근이 됨
  
* 수행 과정
  1. 해 선택
     + 현재 상태에서 부분 문제의 최적 해를 구한 뒤, 이를 부분해 집합(Solution Set)에 추가 함
  2. 실행 가능성 검사
     + 새로운 부분 해 집합이 실행 가능한지를 확인. 곧, 문제의 제약 조건을 위반하지 않는지를 검사함
  3. 해 검사
     + 새로운 부분 해 집합이 문제의 해가 되는지를 확인. 아직 전체 문제의 해가 완성되지 않았다면 1의 해 선택부터 다시 시작함
     
* 거스름돈 줄이기
  + 어떻게 하면 손님에게 거스름돈으로 주는 지폐와 동전의 개수를 최소한으로 줄일 수 있을까?
  + 해 선택 : 가장 단위가 큰 동전을 하나 골라 거스름돈에 추가
  + 실행 가능성 검사 : 거스름돈이 손님에게 내드려야 할 액수 초과하는지 확인. 초과하면 추가한 동전 빼고, 1로 돌아가 현재보다 한 단계 적은 단위의 동전을 추가
  + 해 검사 : 내드려야 하는 거스름돈과 같은 지 확인. 액수가 모자라면 다시 1로 돌아가 반복.

* Baby-gin에 대해 Greedy Algorithm 적용하기
  1. 6개의 숫자는 6자리의 정수 값으로 입력됨
  2. COUNTS Array의 각 원소를 체크해 run과 triplete 및 Baby-gin 여부를 판단
  ![Baby-gin-Greedy](https://github.com/heeyeah/AlgorithmPractice/blob/master/SWExpertAlgorithm/img/Greedy-baby-gin.PNG)
  
* Greedy Algorithm은 해답을 찾아내지 못하는 경우가 존재할 수도 있음


<br/>


### Sort

* Sort(정렬)란?
  + 2개 이상의 자료를 특정 기준에 의해 작은 값부터 큰 값(오름차순, ascending), 혹은 그 반대의 순서대로(내림차순, descending) 재배열하는 것
  + 키 : 정렬하는 기준이 되는 특정 값
  
* Sort 종류
  + Bubble Sort (버블 정렬)
    + 인접한 두 개의 원소를 비교하며 자리를 계속 교환하는 방식
    + 시간 복잡도 O(n^2)
    + 인접한 두 개의 원소를 비교하며 첫 번째 원소를 마지막까지 비교해 정렬하는 방식.
     <pre>
     <code>
     for i from n-1 to 0 decreasing by 1 {
       for j from 0 to i {
         if(a[j] > a[j+1]) then {
           TEMP <- a[j];
           a[j] <- a[j+1];
           a[j+1] <- TEMP;
         }
       }
     }
     </code>
     </pre>
     
     
  + Counting Sort (카운팅 정렬)
    + 항목들의 순서를 결정하기 위해 집합에 각 항목이 몇개씩 있는지 세는 작업을 하여, 선형 시간에 정렬하는 효율적인 Algorithm
    + 제한 사항
      + 정수나 정수로 표현할 수 있는 자료에 대해서만 적용 가능. 각 항목의 발생 회수를 기록하기 위해, 정수 항목으로 인덱스되는 카운트들의 Array(배열)을 사용하기 때문
      + 카운트들을 위한 충분한 공간을 할당하려면 집합 내의 가장 큰 정수를 알아야 함  
    + 시간 복잡도 O(n+k) : n은 항목의 개수, k는 정수의 최대값
    + 과정
    <pre>
    <code>
      ARRAYS {0, 4, 1, 3, 1, 2, 4, 1}
      --> COUNTS 배열에 발생 횟수를 세서 저장
      --> COUNTS {1, 3, 1, 1, 2}
      
      --> 정렬된 집합에서 각 항목의 앞에 위치할 항목의 개수를 반영하기 위해 COUNTS의 원소를 조정
      --> COUNTS {1, 3, 1, 1, 2}
      --> COUNTS {1, 4, 5, 6, 8}
     
      --> TEMP - 정렬 배열
      --> ARRAYS의 마지막 원소부터 생각해보자.
      1. ARRAYS[7] = 1, COUNTS[1] = 4 --> TEMP[4-1] = 1 저장 & COUNTS[1] = COUNTS[1] -1 = 3;
      2. ARRAYS[6] = 4, COUNTS[4] = 8 --> TEMP[8-1] = 4 저장 & COUNTS[4] = COUNTS[4] -1 = 7;
      ...
      이렇게 TEMP ARRAYS 다 돌면 TEMP 채워지면서 정렬!
      
    </code>
    <code>
      Counting_Sort(A, B, k)
      //A [1..n] -- 입력 Array(1 to k)
      //B [1..n] -- 정렬된 Array
      //C [1..k] -- COUNTS Array
 
     for i = 1 to k do
       C[i] = 0
       
     for j = 1 to n do
       C[A[j]] = C[A[j]] + 1
       
     for i = 2 to k do
       C[i] = C[i] + C[i-1]
       
     for j = n to 1 do
       B[C[A[j]]] = A[j]
       C[A[j]] = C[A[j]] - 1
    </code>
    </pre>
    
  + Selection Sort (선택 정렬)
  + Quick Sort (퀵 정렬)
  + Insertion Sort (삽입 정렬)
  + Merge Sort (병합 정렬)


* Sort 비교

  ![SORT 비교](https://github.com/heeyeah/AlgorithmPractice/blob/master/SWExpertAlgorithm/img/Sort-Chart.PNG "출처 : SW Expert Academy")


<br/>

#### Reference
[SW Expert Academy](https://swexpertacademy.com/)
 - [Programming Intermediate](https://swexpertacademy.com/main/learn/course/subjectList.do?courseId=AVuPDN86AAXw5UW6)
