## 🤝 미니 프로젝트
### NEEDMONEY 💰 
당신을 위한 대출상품 추천 앱 NEED MONEY

## 🛠 기술 스택
- Front 
  - React.js
  - Create React App
  - Redux Tool Kit
  - React-Router
  - Styled Component
  - Axios
  - Eslint
  
- Back
  - Java 17
  - Spring Boot , JPA
  - Gradle
  - MySQL
  - AWS EC2 , ROUTE 53
  - Docker
    
<br>

## 📌 프로젝트 개요
#### 프로젝트 기간
- 2022 . 08 . 23 ~ 2022 . 09 . 06

#### 프로젝트 목표
- 프론트엔드와 백엔드 협업으로 대출 상품 어플리케이션 개발

#### 프로젝트 히스토리
<a href="https://www.notion.so/81378e58f37346c69565fe626c82d728
">노션</a>

<a href="https://github.com/BullWooStar/team5-mini-project
">FE github</a>

<a href="https://github.com/iheese/FinProductReco
">BE github</a>

<br>

## 🙋🏻 팀원 소개

### Frontend

| 양예진       | 최효근               | 이화정                | 조현재 | 최수연                                       
| --------------------------------------------------- | ------------------------------------------- | ------------------------------------------------- | ------------------------------------------------- | ------------------------------------------------- 
|  [@yejine2](https://github.com/yejine2)  | [@BullWooStar](https://github.com/BullWooStar)  | [@Hwa-J](https://github.com/Hwa-J)  | [@guswowh](https://github.com/guswowh)| [@boksooni](https://github.com/boksooni)|
 
### Backend

| 이현승       | 강소영               | 박중후                |                                
| --------------------------------------------------- | ------------------------------------------- | ------------------------------------------------- | 
|  [@iheese](https://github.com/iheese)  | [@soyoungkangme](https://github.com/soyoungkangme)  | [@wndgndi](https://github.com/wndgndi)  | 


<br>

## 🌳 프로젝트 기획

<a href="https://www.figma.com/file/0p2dpZN4JOwjtmxjuON2SX/5%EC%A1%B0?node-id=0%3A1
">와이어프레임</a>


<img width="800" alt="스크린샷 2022-09-06 오후 5 08 06" src="https://user-images.githubusercontent.com/99630188/188581501-c53e48bd-4bcf-4ebd-9f9a-d72e64d711e4.png">

<a href="https://www.figma.com/file/qDSvNjjgCBk8ez7YzfzGlx?embed_host=notion&kind=&node-id=0%3A1&viewer=1
">유저 플로우</a>

<img width="800" alt="스크린샷 2022-09-06 오후 5 07 42" src="https://user-images.githubusercontent.com/99630188/188581534-6d9e7f75-989d-45c7-8a7a-209dedd10824.png">

<br />

## 프로젝트 내용

### ⭐️ 주요 기능

<img width="500" alt="스크린샷 2022-09-06 오후 4 46 59" src="https://user-images.githubusercontent.com/99630188/188577064-5339135d-f054-4526-af11-866b9c033923.png">

홈페이지 화면


<br />

#### 로그인 / 회원가입
![스크린샷 2022-09-07 오후 3 52 11](https://user-images.githubusercontent.com/99096272/188809113-a1e396e2-393a-49c2-a468-538f920da867.png)
![스크린샷 2022-09-07 오후 3 51 52](https://user-images.githubusercontent.com/99096272/188809057-6b65a764-4e4a-4ced-b40d-f56b8a34d2f3.png)

- 회원가입시 password는 jbcrypt로 암호화되어 저장되고 로그인시 복호화하여 사용됩니다.  
- 로그인시 JWT 토큰 값을 헤더에 담아 보내주고 클라이언트의 쿠키에 저장합니다.
- 로그인 실패 시 홈페이지, 로그인, 로그아웃 페이지 이외에는 접근하지 못합니다.
- 이 후 JWT 토큰의 유효시간은 1시간이며 토큰값을 헤더에 담아 추가적인 정보를 요청할 수 있습니다.
- 추후에 Username을 제외한 개인정보는 수정할 수 있습니다.
 
 <br />

 #### 회원 맞춤 추천 상품
 
![스크린샷 2022-09-06 오후 11 49 01](https://user-images.githubusercontent.com/85099612/188666223-3b348a87-41a2-425d-a1e2-db0a5ca4dc44.png)

- 회원가입시 입력했던 나이, 직업을 바탕으로 회원에게 맞는 추천상품을 출력합니다.
- 추천상품의 총 합을 구해서 신청가능한 대출 상품 종합을 회원에게 보여줍니다


<br />

#### 모든 상품 및 검색 상품

<img width="500" alt="스크린샷 2022-09-06 오후 4 52 22" src="https://user-images.githubusercontent.com/99630188/188578175-09b8596a-de36-4c1a-8118-cc7416eca338.png">

- 전체상품으로는 신청할 수 있는 모든 상품을 볼 수 있고 검색 상품으로는 상품의 이름을 검색하면 해당 이름이 들어간 모든 상품을 볼 수 있습니다.
- 필터로는 직업별로 상품을 분류하고 대출금액, 금리 별로 오름,내림차순을 할 수 있습니다.


<br />

#### 프로모션 상품

<img width="500" alt="스크린샷 2022-09-06 오후 4 58 48" src="https://user-images.githubusercontent.com/99630188/188579517-0cb36dff-c1f8-4c71-848f-c633314b5938.png">

- 프로모션 상품으로는 무작위로 뽑은 랜덤 추천 상품을 보여줍니다.


<br />

#### 장바구니

<img width="500" alt="스크린샷 2022-09-06 오후 4 59 37" src="https://user-images.githubusercontent.com/99630188/188579769-88378a9f-3501-419e-bcaa-bb4710518611.png">

<img width="500" alt="스크린샷 2022-09-06 오후 4 59 42" src="https://user-images.githubusercontent.com/99630188/188579787-46501108-25ce-4948-861c-e149640966d5.png">

- 상품페이지의 상품카드에서 + 버튼을 누르면 개인 카트에 상품이 추가가 됩니다.
- 전체삭제 및 개별 삭제가 가능하며 신청하기 완료시 장바구니가 비워집니다.

