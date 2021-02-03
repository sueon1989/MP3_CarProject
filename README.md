# MIT 프로젝트 

# mp3_carProject


# 개발배경

위치/기상정보에 따른 차량관리 및 주행거리에 따른 차량 점검목록에 대한 정보 및 서비스 부족

실생활에서 적용 가능한 각종 정보와 데이터를 분석하여 의미있는 정보를 제공하고자 함.



# 개발목표

IoT를 통해 디바이스 데이터를 사용, 분석, 표시하는 웹 애플리케이션 개발

사용자의 주행거리 & 기상 기후 변화에 맞는 차량점검 리스트에 대한 지식 및 정보 제공 서비스

기후 변화 및 교통사고 데이터를 제공함으로 교통사고 감소에 기여

차종, 지역별 커뮤니티 활성화로 인한 정보교류의 장을 제공하는 서비스


# 개발 개요

“차량관리 서비스” 는 자동차에 GPS 센서를 부착하여 사용자의 주행거리를 자동으로 저장함으로써 주행거리에 따른 차량관리에 대한 정보를 사용자에게 제공한다. 

또한 기상변화 및 사고예방 데이터제공으로 인한  교통사고율 감소 및 예방을 기대할 수 있다. 

차종별 , 지역별 커뮤니티 통해 사용자들의 정보와 지식 , 무료나눔 등 커뮤니티를 활성화 할 수 있다.

# 개발 내용

- 서버 구성 -

형상 관리 서버: Git, Trello 
웹 서버: Tomcat
데이터 베이스: MariaDB

- 하드웨어 구성 -

NodeMCU (ESP8266MOD)
GPS (UART GPS NEO-6M)


사용자 인증 (회원가입/로그인/로그아웃/회원정보 관리 등)
차계부 관리 (차량 점검 비용/내역)
실시간 위치 데이터를 활용한 주행거리 자동 입력 [GPS]
실시간 기상 정보에 따른 차량 점검 Tip 알림 [기상청API]
계절별 차량 점검 Tip 알림
추천 드라이브 코스 안내


# 개발 일정

2021년 1월 8일 ~ 12일 : 사용자 인증 테스트 (완료)
			       -로그인 인증, 회원가입, ID,PW 찾기

2021년 1월 8일 ~ 20일 :  마이페이지 구현 (완료)
			       -내 정보 보기, 수정,삭제, 회원 탈퇴, 내 차량 정보 보기, 수정

2021년 1월 8일 ~ 25일 : 차량 관리 (v1 완료)
			       - 차량 등록 / 수정 / 차계부 관리

2021년 1월 8일 ~ 25일:  기상정보 구현 (v1 완료)
			       - 주간 일기예보, 실시간 기상정보, 기상정보에 따른 차량점검 방법 등

2021년 1월 15일 ~ 25일: GPS 하드웨어 구현 (v1 완료)
			- 현재 위치정보, 이동거리 표시 등

2021년 1월 25 ~ 26일: 서버 구축 및 프로젝트 (v1 완료)



