# 자동차 경주

## 🚀 기능 요구사항
초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.


## 1단계 - 기능 구현 목록
- [x] 사용자가 잘못된 값을 입력 처리 하기
    - [x] `IllegalArgumentException`를 발생
    - [x] 에러 발생시점부터 입력 다시 받기
    - [x] “[ERROR]“로 시작하는 에러 메시지를 출력
- [x] 각 자동차들의 이름을 입력 받는다.
    - [X] 자동차들의 이름 입력은 ',' 으로 각 자동차를 구분한다.
    - [X] 각 자동차의 이름 길이는 1 ~ 5 사이의 길이로 구성되어야 한다.
    - [x] 자동차의 입력은 빈 입력을 허용하지 않는다.
    - [x] 자동차명의 이름 입력에 ',' 의 단독 입력은 허용하지 않는다.
- [x] 자동차 경주 게임의 시도할 횟수(라운드)를 입력 받는다.
    - [X] 시도할 횟수는 숫자 형태로만 입력을 허용한다.
    - [X] 숫자는 1 이상의 숫자를 허용한다.
    - [X] 빈칸 입력을 허용하지 않는다.
- [x] 레이싱 게임을 플레이한다.
    - [X] 자동차 전진을 위해서 숫자 값을 통해 전진을 수행한다.
        - [X] 값은 랜덤한 값으로 생성하며 0 ~ 9 사이의 값으로 생성 할 수 있다.
        - [X] 값이 4이상인 경우만 자동차가 전진할 수 있다.
        - [x] 각 자동차는 모두 다른 랜덤 값을 가진다.
    - [x] 한번의 라운드가 끝나면 카운트를 감소한다.
- [x] 매 경주당 결과 출력하는 기능
    - [x] 각 자동차별 결과(자동차 이름과 전진 거리)를 반환해주는 기능
    - [x] 경주당 결과를 출력하는 기능.
- [x] 자동차 경주 게임을 완료한 후 누가 우승했는지 알려주는 기능
    - [x] 가장 많은 전진을 한 자동차를 구하는 기능
    - [x] 우승은 한개 이상이다.
    - [x] 우승이 여러개일 경우 `, `를 이용하여 구분하여 문자열 반환 기능


<br>

## 2단계 - 기능 구현 목록

### 리팩토링 요구사항
* 핵심 비지니스 로직을 가지는 객체를 domain 패키지, UI 관련한 객체를 view 패키지에 구현한다.
* MVC 패턴 기반으로 리팩토링해 view 패키지의 객체가 domain 패키지 객체에 의존할 수 있지만, domain 패키지의 객체는 view 패키지 객체에 의존하지 않도록 구현한다.

### 도메인별 역할

#### View
* `InputView`: 입력에 대한 책임을 가지고 요구조건에 적힌 입력 검증의 책임을 가진다.
* `OutputView`: 출력에 대한 책임을 가지고 요구조건에 적힌 출력의 형식을 제공하는 책임을 가진다.

#### Domain
* `Car`: 자동차에 대한 책임을 가지며 자동차의 이름, 현재 위치에 대한 정보를 가진다.
* `Name`: 자동차의 이름에 대한 책임을 가지며 자동차 이름에 대한 요구조건의 검증 책임을 가진다.
* `Position`: 자동차의 현재 위치에 대한 책임을 가지며 자동차 현재 위치에 대한 요구조건의 검증 책임을 가진다.
* `Cars`: 자동차들의 대한 책임을 가지며 자동차들의 전체 움직임과 자동차들에 대한 요구조건의 검증 책임을 가진다.
* `Round`: 자동차 경주 게임의 라운드별 횟수에 대한 책임을 가지며 자동차 라운드별 횟수에 대한 요구조건의 검증 책임을 가진다.
* `RacingGame`: 자동차 경주 게임에 대한 책임을 가지며 자동차 게임이 진행되기 위한 기능을 수행한다.
* `NumberGeneratePolicy`: 자동차의 이동 값 생성에 대한 전략의 책임을 가진다.
* `RandomGeneratePolicy`: 자동차 이동 값에 대한 랜던 값 생성의 책임을 가진다.

#### Controller
* `RacingGameController`: 자동차 경주 게임을 제어하기 위한 책임을 지며 비즈니스 로직과 UI를 연결하는 기능을 수행한다.