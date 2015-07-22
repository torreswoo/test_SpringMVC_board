# test_SpringMVC_board

http://courspick.blogspot.kr/2015/04/spring-mvc-project.html


# Spring MVC의 특징
- Controller의 특징은 URL과 메서드를 직접연결하는 것 => REST
- Controller의 역할 : 1.URL요청으러부터 가져옴 / 2.비즈니스로직의 메서드를 실행 / 3.View이름을 반환


# Spring MVC 설정
- beans-biz.xml : 비즈니스 로직의 Bean정의파일
- beans-webmvc.xml : springMVC의 Bean정의파일
- mvc-dispatcher-servlet.xml
- web.xml

# 프로젝트 package구조
- web(프리젠테이션) -> controller
- biz(비즈니스로직) -> service / domain