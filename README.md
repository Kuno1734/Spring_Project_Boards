# Spring_Project_Boards
### API 기능 정리

1. 전체 게시글 목록 조회 API
    - 제목, 작성자명, 작성 내용, 작성 날짜를 조회하기
    - 작성 날짜 기준 내림차순으로 정렬하기
    
2. 게시글 작성 API 
    - 제목, 작성자명, 비밀번호, 작성 내용을 저장하고
    - 저장된 게시글을 Client 로 반환하기
    
3. 선택한 게시글 조회 API 
    - 선택한 게시글의 제목, 작성자명, 작성 날짜, 작성 내용을 조회하기 
    (검색 기능이 아닙니다. 간단한 게시글 조회만 구현해주세요
    
4. 선택한 게시글 수정 API
    - 수정을 요청할 때 수정할 데이터와 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 한 후
    - 제목, 작성자명, 작성 내용을 수정하고 수정된 게시글을 Client 로 반환하기
    
5. 선택한 게시글 삭제 API
    - 삭제를 요청할 때 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 한 후
    - 선택한 게시글을 삭제하고 Client 로 성공했다는 표시 반환하기
    
### Use Case 작성
<p align= center><img width="703" alt="스크린샷 2023-02-08 시간: 11 46 34" src="https://user-images.githubusercontent.com/121773974/217415847-8dcb308c-64d2-459f-bcd0-56b2f410b834.png"></p>
 
### API 명세서 작성

<p align=center><img width="818" alt="스크린샷 2023-02-08 시간: 11 00 06" src="https://user-images.githubusercontent.com/121773974/217409491-b405742d-1d3d-47d3-bab7-7610bb76a627.png" width=80%></p>

### 1. 수정, 삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body)
* param. - 데이터의 수정과 삭제에서 대상의 id값을 받아와야 하므로 `@Pathvariable`로 id를 받을 수 있도록 사용
* body - 데이터의 수정과 삭제에서 각각 지정된 데이터를 받야 하므로 `@RequestBody`를 통해 데이터를 전달

### 2. 어떤 상황에 어떤 방식의 request를 써야하나요?
* GET - Param방식을 통해 특정한 값을 받아온다.
* POST - RequestBody에 전송할 데이터를 넣어서 보내준다.
* PUT - Param을 통해서 특정 id값에 대한 데이터를 requestBody(수정내용)에 넣은 데이터로 수정할 때 사용.
* DELETE - Param을 통해서 특정 id값에 대한 데이터 제거를위한 정보를 RequestBody(Password 와 같은)에 넣어서 전송. 

### 3. RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?
* RESTful AIP에 대한 설명 참조 https://aws.amazon.com/ko/what-is/restful-api/
* boards 라는 균일한 리소스 중심으로 작성하였습니다.

### 4. 적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service)
* Controller - 맴핑을 통한 메서드 호출.
* Service - 호출된 메서드를 구현, Repository를 통해 데이터를 가져오거나 저장하는 로직 수행
* Repository - 데이터베이스에 저장,조회.

### 5. API 명세서 작성 가이드라인을 검색하여 직접 작성한 API 명세서와 비교해보세요!
* `Method`,`Url`,`Request`,`Response`로 작성.
* 검색 후 비교하니 추가적으로 기능에대한 설명을 추가하면 좋을것 같습니다.


