<h1 align="center">데이터 수집과 예측 프로젝트 백엔드 💻 </h1>

## 🛠️ 기술 스택

<img src="https://img.shields.io/badge/springboot-6DB33F?style=flat-square&logo=SpringBoot&logoColor=white" /> 
<img src="https://img.shields.io/badge/springsecurity-6DB33F?style=round&logo=springsecurity&logoColor=white" />
<img src="https://img.shields.io/badge/Java Persisitence API-6DB33F?style=round&logo=&logoColor=white" />
<img src="https://img.shields.io/badge/jsonwebtokens-000000?style=round&logo=jsonwebtokens&logoColor=white" /> 
<img src="https://img.shields.io/badge/gradle-02303A?style=round&logo=gradle&logoColor=white" /> 
<img src="https://img.shields.io/badge/mysql-4479A1?style=round&logo=mysql&logoColor=white" />

## 🤹🏻 기술 스택 선정 이유

- SpringBoot : Java를 사용한 프로젝트를 빠른 시간안에 만들 수 있어서
- Springsecurity : 로그인과 권한에 따른 페이지 제어를 위해서
- Java Persisitence API : DB 생성과 CRUD를 일회성이 아닌
- JsonWebTokens : 유저의 권한 수준과 로그인 유무를 확인하기 위해서
- gradle : maven 보다 좋은가?
- mysql : RDBMS를 통해 정형화되고 일정한 데이터를 받기위해서

## 📌 프로젝트 목표

```sh
1. 데이터 크롤링 데이터를 DB에 저장한다

2. 저장된 데이터를 AI 학습과 그래프로 만들기위해
원하는 만큼의 데이터를 불러올수 있다
```

## 📄 ERD

<center>
    <img src="./img/ERD.png" />
</center>

## 🔍 Overview

### 1. 데이터 저장

\*저장

- Java code로 SQL문을 실행 할 수있도록 JPA를 사용하여 DB에 저장한다

<br>

### 2. 데이터 조회

JPA를 사용하여 DB에서 조회한다<br>
입력 받은 Date를 기준으로 오늘 날까지의 모든 데이터를 불러오도록 <br>Between연산을 실행한다

<br>

### 3. 로그인 회원가입

JWT을 사용하여 서버에 부담을 줄이는 인증 방식을 사용한다

<br>

<!-- ### 4. 멤버쉽

<center>
    <img src="./img/pic1.png" />
</center>
권한 수준을 확인하여 AI 데이터를 볼 수 있도록 한다

<br> -->
