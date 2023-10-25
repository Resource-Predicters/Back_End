<h1 align="center">~~~ 프로젝트 프론트엔드 💻 </h1>

## 🛠️ 기술 스택

[[뱃지 만드는 방법은 여기 참조]](https://velog.io/@shlee327/shield.io-%EB%A7%88%ED%81%AC%EB%8B%A4%EC%9A%B4-%EB%B0%B0%EC%A7%80-%EB%A7%8C%EB%93%A4%EA%B8%B0)

각 프로젝트의 뱃지는 프로젝트에서 사용한 기술들만 나열  
현재는 많이 쓸만한 것들을 그냥 다 추가해둔 상태

<img src="https://img.shields.io/badge/springboot-6DB33F?style=flat-square&logo=SpringBoot&logoColor=white" /> 
<img src="https://img.shields.io/badge/springsecurity-6DB33F?style=round&logo=springsecurity&logoColor=white" />
<img src="https://img.shields.io/badge/Java Persisitence API-6DB33F?style=round&logo=springsecurity&logoColor=white" />
<img src="https://img.shields.io/badge/jsonwebtokens-000000?style=round&logo=jsonwebtokens&logoColor=white" /> 
<img src="https://img.shields.io/badge/gradle-02303A?style=round&logo=gradle&logoColor=white" /> 
<img src="https://img.shields.io/badge/mysql-4479A1?style=round&logo=mysql&logoColor=white" />

## 🤹🏻 기술 스택 선정 이유

- SpringBoot : Java를 사용한 프로젝트를 빠른 시간안에 만들 수 있어서
- Springsecurity : 로그인과 권한에 따른 페이지 제어를 위해서
- Java Persisitence API :
- JsonWebTokens : 유저의 권한 수준과 로그인 유무를 확인하기 위해서
- gradle : maven 보다 좋은가?
- mysql : RDBMS를 통해 정형화되고 일정한 데이터를 받기위해서

## 📌 프로젝트 목표

```sh
1. 데이터 크롤링 데이터를 DB에 저장한다

2. 저장된 데이터를 AI 학습과 그래프로 만들기위해
원하는 만큼의 데이터를 불러올수 있다
```

## 📄 UI/UX 설계도

[[설계도 확인할 수 있는 링크 또는 그림]](www.naver.com)

## 🔍 Overview

### 1. 데이터 저장

<center>
    <img src="./img/pic2.png" />
</center>
JPA를 사용하여 DB에 저장한다

<br>

### 2. 데이터 불러오기

<center>
    <img src="./img/pic1.png" />
</center>
JPA를 사용하여 DB에서 불러온다
날짜 데이터를 받아 날짜 기준에 맞게 불러올 수 있다

<br>

### 3. 로그인 회원가입

<center>
    <img src="./img/pic1.png" />
</center>
Springsecurity를 사용하여 암호화와 토큰이 있을 경우에만 페이지를 볼 수 있도록 한다

<br>

### 4. 멤버쉽

<center>
    <img src="./img/pic1.png" />
</center>
권한 수준을 확인하여 AI 데이터를 볼 수 있도록 한다

<br>
