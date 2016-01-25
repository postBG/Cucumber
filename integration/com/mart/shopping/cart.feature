Feature:구매 금액 합계

Scenario:구매 금액 합계
	Given '길동'이는 구매가 준비됨
	When 길동이가 400 원짜리 렛츠비 12개를 담았다.
	Then 렛츠비 가격은 4800원이다.
	And 총 합계는 4800원이다.
	When 길동이가 2000 원짜리 꼬깔콘 2개를 담았다.
	Then 꼬깔콘 가격은 4000원이다.
	And 총 합계는 8800원이다.
	
Scenario:총합계가 10000원 이상이면 구매시 10% 할인
	Given '길동'이는 구매가 준비됨
	When 길동이가 2500 원짜리 렛츠비 4개를 담았다.
	Then 렛츠비 가격은 10000원이다.
	And 총 합계는 9000원이다.
	When 길동이가 1000 원짜리 꼬깔콘 5개를 담았다.
	Then 꼬깔콘 가격은 5000원이다.
	And 총 합계는 13500원이다.