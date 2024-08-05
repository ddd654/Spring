# Spring
Spring study

# Spring 설정하기
인터넷에서 스프링 sts 검색
윈도우 버전 받아서 course 폴더안에 workspace 폴더 또 만들어서
이클립스 창 비슷한것 열어서 경로 설정해줌
열었으면 Help 텝에서 marketplace > web 검색해서 두번쨰꺼 다운 설치

Java EE 로 바꿨다
Create a simple project check
그룹 = 패키지명
아티팩트 = 이름

# Spring 부가 설명
프로젝트를 개발하면 > 빌드 과정(ex Maven, gradle) > 배포 하게된다
의존성 라이브러리는 잘못 받아지면 지우고 다시 받을 수 있다 
Maven Dependencies 에 경로 있음

빨간줄뜨면 할 것

![image](https://github.com/user-attachments/assets/222351f0-4ee7-401f-a79d-73e5de183b4a)


# 스프링 동작 구조
![image](https://github.com/user-attachments/assets/a1c964e7-1b9f-41d2-bd8d-46de8ec3e023)

DispatcherServlet 에서 전부 받아서 처리
응답은 항상 포워드

![image](https://github.com/user-attachments/assets/09b6c953-4ea8-4df0-8b7c-683c79ae4fc9)

위 그림은 응답 순서


# Spring DB 연결하기
1. 메이븐 레포 > ojdbc8 > 21.5 버전

![image](https://github.com/user-attachments/assets/3dfcaaa7-94eb-4587-991c-cef92c4b1be2)
   
2. pom에 추가

3. hikariCP 검색 = 커넥션 풀임 > 2.7.8 > 복붙해서 폼에 추가

![image](https://github.com/user-attachments/assets/d901bbe3-da3b-454b-a688-7f6789a0eddb)


4.spring jdbc > 아무버전 > ${org.springframework-version} 버전 태그안에 바꿔 넣기
![image](https://github.com/user-attachments/assets/1264543d-e89c-4f7e-b47e-ec6e7e4c7cdf)

5. 3개 받고 메이븐업뎃

6. context.xml 가서 db 커넥션풀을 만든다
7. pdf에서 나와있는데 value 값들은 바뀌게 된다

![image](https://github.com/user-attachments/assets/90ee36e9-3a9e-4608-a9cc-60e4c6f330b1)


9. 부분 테스트 코드 쓰기
src/test/java 폴더에서 패키지안 JdbcTest 클래스 만들어서 > Run As 실행하기

![image](https://github.com/user-attachments/assets/bc8731de-d53a-46d4-b542-d1c1f2d7656c)

11. db 정보는 텍스트로 외부 리소스 파일로 관리된다

12. application.properties 파일 만들어서 데이터 베이스 만들기, context.xml에 pdf에서 id = DBproperties 복붙
    
![image](https://github.com/user-attachments/assets/59b94387-3b52-49e8-8116-41cadd8f025e)

bean의 value 값들을 바꿔준다  ex) ${ds.username} > JdbcTest 자바파일이 실행되야한다


12. 
13. 



























#기술 블로그 생각해보기
