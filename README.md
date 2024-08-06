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



# MyBatis
1. 추가하기

![image](https://github.com/user-attachments/assets/d25e8c20-3d17-4b7f-9c0d-777dfaea2d60)

2. 마이바티스에 위에꺼 두개 필요한데 pdf 8강꺼 복붙함

![image](https://github.com/user-attachments/assets/9d2c416a-6b4e-4487-9036-e923ebadabad)

3. 세션팩토리 context.xml에 추가

![image](https://github.com/user-attachments/assets/b9117c7d-e11b-42a1-94b2-7601bda5b9ea)
![image](https://github.com/user-attachments/assets/e347d635-e33d-4f56-a07c-74f32997ac16)
![image](https://github.com/user-attachments/assets/a41cd316-b889-4e8c-9337-76af5d5a734b)

4.인터페이스 만들어서 사용하기
TestMapper인터페이스 만들어서 @Mapper 적어놓기, 

![image](https://github.com/user-attachments/assets/9a48471b-633e-4f3f-94bf-d5979e5c8a48)
![image](https://github.com/user-attachments/assets/ba15377d-08ca-47fc-9938-999787ce7459)



#AOP
쓰고싶으면 라이브러리 있어야한다

![image](https://github.com/user-attachments/assets/8390c75f-de8c-43be-bc14-5cd054af77c3)

13강에서 의존성 복붙

![image](https://github.com/user-attachments/assets/14371f14-8bc0-4377-88c2-c861f6ab112e)

root aspect-context.xml 경로추가 > LogAdvice 클래스



# SpringBoot

https://brave-planarian-384.notion.site/6c60785d267a439fb34ccb5953b08424?v=c6de239fb45b41019d14a6191f0e8a51

1. STS에서 프로젝트 다 close 하고


2. ![image](https://github.com/user-attachments/assets/f0a66341-c4df-4672-8dd6-90fbd4a94e52)

3. 이번엔 2버전 사용할건데 나중에 바꾼다
4. ![image](https://github.com/user-attachments/assets/e4a450c4-f1d4-4b63-b94a-7fe12320f3da)
5. ![image](https://github.com/user-attachments/assets/517e7b1c-a48b-495f-b144-2e749bf5747d)
6. 3버전으로 만들어서 오류나면 2.7.18 버전으로 고쳐준다. 아래 자바 컴파일은 11
7. 컨트롤러 만들어서 확인
8. ![image](https://github.com/user-attachments/assets/a15c2ede-156a-40c2-ae4e-fa6d1f12c645)

# 인텔리제이로 하기(community version)
1. 커뮤버전 다운
2. ![image](https://github.com/user-attachments/assets/6a4c6570-b11e-456a-bdb0-c1093465a51e)

3. 인텔리는 노션 참고해서 하기
4. 실행할때 UI바뀌는 옵션은 문제생기면 원복할것


# MySQL 설치하기(oracle 대신)
![image](https://github.com/user-attachments/assets/1d1b641d-5457-4542-b822-8c7ff3a033bb)
![image](https://github.com/user-attachments/assets/ebf9893b-2d7b-4f41-88a7-d6631c7d325e)

1. MySQL 검색 > 용량 큰것 다운
2. 실행 > 커스텀
3. ![image](https://github.com/user-attachments/assets/925a61b1-c6fa-49bf-8924-ca7b6fd5bb74)
4. execute >next
5. ![image](https://github.com/user-attachments/assets/f48ac897-ce03-4799-b5d8-852c33831c67) 확인
6. 




