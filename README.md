# ***스프링 핵심 원리 - 기본편****

### 김영한 강사님의 스프링 핵심원리 기본편 강의를 듣고 작성한 코드입니다.
- 출처 : [스프링 핵심 원리 - 기본편](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8/dashboard)

# 학습내용 정리(강의를 듣고 정리한 내용입니다.)

# ****스프링 핵심 원리 - 기본편****

## 1. 객체 지향 설계와 스프링

### 스프링이란?

- 스프링 DI컨테이너, AOP. 이벤트 등을 제공하고
- 그외에 스프링 부트, 스프링 배치, 스프링 시큐리티 등 다양한 기능을 제공하는 프레임워크 이다.

### 스프링사용하면 편리한이란?

- 단독 스프링애플리케이션 쉽게 생성
- 서버 내장기능
- 빌드 구성을 위한 스타터 제공
- 써드파티 자동구성

### 스프링 단어 자체가 의미하는 것은?

- 스프링 DI 컨테이너 기술
- 스프링 프레임워크
- 스프링 부트, 프레임워크 등을 포함한 스프링 생태계

### 스프링의 핵심 개념은?

- 자바의 특징인 객체 지향 언어를 스플이은 좋은 객체 지향을 할 수 있도록 도와준다.

### 객체 지향의 특징은?

- 추상화
- 캡슐화
- 상속
- 다형성

### 역할과 구현 분리

- 다형성을 통해 역할과 구현을 분리해서 구현할 수 있다.
- 역할과 구현을 분리 시 여러 장점이 있다.
    - 클라이언트는 대상의 역할(인터페이스)만 알면 된다.
    - 클라이언트는 구현 대상의 내부 구조를 몰라도 된다.
    - 클라이언트는 구현 대상의 내부 구조가 변경되어도 영향 받지 않는다.
    - 클라이언트는 구현 대상 자체를 변경해도 영향을 받지 않는다.

### 스프링 관점의 객체 지향

- 스프링은 다형성을 극대화해서 이용할 수 있게 해준다.
- 스프링에서 IOC, DI은 다형성을 활용해서 역할과 구현을 편리하게 다룰 수 있도록 해준다.

### 객체지향  5원칙 SOLID

- SRP → 단일 책임 원칙 (single responsibility principle)
- OCP → 개방-폐쇄 원칙 (Open/closed principle)
- LSP → 리스코프 치환 원칙 (Liskov substitution principle)
- ISP → 인터페이스 분리 원칙 (Interface segregation principle)
- DIP → 의존관계 역전 원칙 (Dependency inversion principle)

### SRP → 단일 책임 원칙 (single responsibility principle) 이란?

- 한 클래스는 하나의 책임만 가져야 한다.
- 하나의 책임은 각 문맥과 상황에 따라 유동적인 의미이다.
- 변경이 있을 때 파급효과가 적어야 단일 책임 원칙을 잘 따른것이다.

### OCP → 개방-폐쇄 원칙 (Open/closed principle) 이란?

- 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.
- 다형성을 주로 사용한다.

### LSP → 리스코프 치환 원칙 (Liskov substitution principle)

- 객체는 프로그램 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야한다.

### ISP → 인터페이스 분리 원칙 (Interface segregation principle)

- 특정 클라이언트를 위한 범용 인터페이스보단 여러개의 인터페이스가 낫다.
- 예로) 자동차 인테페이스보다 → 운전 인터페이스, 정비 인터페이스 이렇게 나눈다.
- 인터페이스가 명확해지고, 대체 가능성이 높아진다.

### DIP → 의존관계 역전 원칙 (Dependency inversion principle)

- 구체화에 의존하면 안되고 추상화에 의존해야 한다.
- 즉, 구현 클래스에 의존하지 않고 인터페이스에 의존해야 한다.
- 즉, 역할에 의존하게 해야한다는 것이다.

### 다형성의 한계

- 다형성 만으로는 OCP와 DIP를 지킬 수 없다.
- 스프링은 DI 컨테이너와 D기능을 제공하여 OCP, DIP를 가능하게 지원한다.

## 2. 스프링 핵심 원리 이해1 - 예제 만들기

### 비즈니스 요구사항 및 다이어그램

- 회원 가입 및 조회기능을 갖고
- 회원에 따른 할인 정책을 갖는 기능이다.
- 아래의 다이어그램으로 구현할 수 있다.
- 
![image](https://user-images.githubusercontent.com/76714485/234502252-d3f9c28a-f8c8-4b6e-b840-cc9630df8c7b.png)

![image](https://user-images.githubusercontent.com/76714485/234502303-70c3cb8e-e11b-4274-8d7a-a10a46c5e903.png)

## 3. 스프링 핵심 원리 이해2 - 객체 지향 원리 적용

### 새로운 할인정책 개발

- 새로운 요구사항으로 RateDiscountPolicy를 요구한다.

### 새로운 할인정책 개발

- OrderServiceImpl 코드를 변경해야 한다.

```java
public class OrderServiceImpl implements OrderService{
  //private final DiscountPolicy discountPolicy = new FixDisountPolicy();
  private final DiscountPolicy discountPolicy = new RateDisountPolicy();
}
```

### 새로운 할인정책 적용의 문제점

![image](https://user-images.githubusercontent.com/76714485/234502370-89835e63-59cf-4680-aac6-0a7e257206ad.png)

- 역할과 구현 분리는 문제가 되지 않는다.
- 다형성 활용도 하였고, 인터페이스와 구현 객체도 분리해서 문제되지 않는다.
- DIP위반 →
    - OrderServiceImpl은 추상(인터페이스) DiscountPolicy에도 의존하지만,
    - OrderServiceImpl은 구체(구현)클래스 FixDisountPolicy, RateDisountPolicy에도 의존한다.
- OCP 위반 →
    - 현재 코드는 기능을 확장해서 변경하면, 클라이언트 코드에 영향을 준다.
    - 즉, FixDiscountPolicy 를 RateDiscountPolicy 로 변경하는 순간 OrderServiceImpl의 코드도 함께 변경해야 한다.

### 문제점 극복법

- 클라이언트인  OrderServiceImpl가 아래코드처럼 인터페이스에만 의존하게 해야한다.

```java
public class OrderServiceImpl implements OrderService{
 private DiscountPolicy discountPolicy;
}
```

- 애플리케이션의 전체 동작 방식을 구성하기 위해, 구현 객체를 생성하고, 연결하는 책임을 갖는 AppConfig를 생성한다. 아래의 코드와 같다.

```java
public class AppConfig {

 public OrderService orderService() {
  return new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());
 }

}
```

- AppConfig는 생성한 객체 인스턴스 레퍼런스를 생성자를 통해서 주입해준다.
- 이러면 더이상 OrderServiceImpl은 인터페이스에만 의존하게 된다.

### 새로운 OrderService 다이어그램

![image](https://user-images.githubusercontent.com/76714485/234502416-afc75c20-fb44-4aec-8099-f446937a9ab1.png)
### 제어의 역전 (IoC)- 위의 예시를 통한

- 기존은 클라이언트 구현 객체가 스스로 필요한 서버 구현 객체를 생성하고 연결했다.
- 하지만 AppConfig가 등장한 이후 구현 객체는 자신의 로직을 실행하는 역할만 담당한다.
- 프로그램의 제어 흐름은 AppConfig가 가져간다.
- 즉, OrderServiceImpl은 인터페이스를 호출하지만 어떤 구현객체인지 모르고, OrderServiceImpl도 AppConfig가 담당한다.
- 이렇게 프로그램의 제어 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것을 제어의 역전(IoC)라고 한다.

### 의존관계 주입(DI)

- 의존관계는 정적인 클래스 의존관계와, 실행시점에 결정되는 동적인 객체 의존관계 둘을 분리해서 생각해야 한다.
- 애플리케이션 실행 시점(런타임)에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 클라이언트와 서버의 실제 의존관계가 연결 되는 것을 의존관계 주입이라 한다.
- 의존관계 주입을 사용하면 클라이언트 코드를 변경하지 않고, 클라이언트가 호출하는 대상의 타입 인스턴스를 변경할 수 있다.

## 4. 스프링 컨테이너와 스프링 빈

### 스프링으로 전환

- AppConfig에 AppConfig클래스에 @Configuration을 통해 설정을 구성한다는 어노테이션을 추가한다.
- 그리고 각 메서드에 @Bean을 붙혀 각 메서드를 스프링 컨테이너에 스프링 빈으로 등록한다.

```java
// AppConfig

@Configuration
public class AppConfig{

 @Bean
 public OrderService orderService() {
  return new OrderServiceImpl(memberRepository(), discountPolicy());
 }

 @Bean
 public DiscountPolicy discountPolicy() {
  return new RateDiscountPolicy();
 }
...
}
```

- 기존 AppConfig객체를 생성 후 객체에서 메서드를 실행하는 방식은 제거 한다.
- 그대신 AnnotationConfigApplicationContext(AppConfig.class)을 통해 ApplicationContext 객체를 받는다.
- ApplicationContext 를 스프링 컨테이너라 한다.
- applicationContext.getBean()메서드를 통해 스프링컨테이너에서 등록된 빈을 찾아서 사용할 수 있다.
- 아래의 코드는 OrderApp파일의 일부이다.

```java
public class OrderApp {

 public static void main(String[] args) {
  // AppConfig appConfig = new AppConfig();
  // MemberService memberService = appConfig.memberService();
  // OrderService orderService = appConfig.orderService();

  ApplicationContext applicationContext = 
   new AnnotationConfigApplicationContext(AppConfig.class);

  OrderService orderService = 
   applicationContext.getBean("orderService",OrderService.class);
...

}
```

### 스프링 컨테이너 생성과정

- new AnnotationConfigApplicationContext(AppConfig.class)를 통해서 스프링 컨테이너를 생성하고 AppConfig.class에 구성정보를 지정한다.
- 스프링 컨테이너 내에는 빈이름 - 빈객체 형태로 빈이 저장되어 있다.
- 보통 빈이름은 메소드 이름을 사용하나, 직접 지정도 가능하다.

### 스프링 컨테이너에 등록된 빈 조회

- **모든 빈 출력**
    - ac.getBeanDefinitionNames()을 통해 모든 빈 이름을 조회가능하다.
    - 조회된 빈이름으로 ac.getBean()을 통해 빈을 조회한다.
    - getRole()을 통해 스프링 스프링 내부 빈인지 사용자 지정빈인지 구분가능하다.
- **일반적인 빈 조회 방법**
    - 빈조회는 일반적으로 두가지 방법이 존재한다.
    - ac.getBean(빈이름, 타입) → 빈이름과 타입을 통한 빈조회
    - ac.getBean(타입) → 타입을 통한 빈조회
- **타입이 동일한 빈이 있는경우**
    - 동일한 타입이 있을 시 ac.getBean(타입) 으로 조회시 중복오류가 발생한다.
    - 동일한 타입이 있는경우 ac.getBean(빈이름, 타입)으로 특정해서 빈을 조회해야한다.
    - ac.getBeansOfType(MemberRepository.class); 으로 해당 타입의 모든 빈 조회가능하다.

### BeanFactory와  ApplicationContext

![image](https://user-images.githubusercontent.com/76714485/234502457-ec083119-d581-406a-b398-dc090828c0f3.png)

- **BeanFactory**
    - 스프링 컨테이너의 최상위 인터페이스다.
    - getBean()을 제공한다.
- **ApplicationContext**
    - BeanFactory가 제공하지 않는 여러 부가기능을 제공한다.
    - 메시지소스를 활용한 국제화 기능
    - 환경변수
    - 애플리케이션 이벤트
    - 편리한 리소스 조회

### 스프링 빈 설정 메타 정보 - BeanDefinition

- BeanDefinition은 빈 설정 메타정보이다.
- 스프링 컨테이너는 이 메타정보를 기반으로 스프링 빈을 생성한다.

## 5. 싱글톤 컨테이너

### 싱글톤 패턴의 문제점

- 싱글톤 패턴 구현 코드가 많이 들어간다.
- 의존관계상 클라이언트가 구체 클래스에 의존한다. → DIP 위반
- 클라이언트가 구체 클래스에 의존해서 OCP 원칙을 위반할 가능성이 높다
- 테스트가 어렵다.
- 내부 속성 변경 및 초기화가 어렵다.
- 유연성이 떨어지고, 안티패턴이라 불리기도한다.

### 스프링컨테이너 - 싱글톤 컨테이너

- 스프링 컨테이너는 싱글톤 패턴 문제점을 해결하면서 객체를 싱글톤으로 관리하다.
- 스프링 빈이 싱글톤으로 관리된다.
- 싱글톤 컨테이너로 DIP, OCP, 테스트, private 생성자로 부터 싱글톤 사용가능하다.

### 싱글톤 방식의 문제점, 주의점

- 객체 상태를 stateless하게 설계해야한다.
    - 특정 클라이언트에 의존적인 필드가 있으면 안된다.
    - 특정 클라이언트가 값을 변경할 수 있는 필드가 있으면 안된다.
    - 가급적 읽기만 해야한다.
    - 필드대신 자바에서 공유되지 않는 지역변수, 파라미터, ThreadLocal을 사용해야 한다.

### @Configuration과 바이트코드

- 스프링은 클래스의 바이트코드를 조작하는 라이브러리를 사용한다.
- 동일한 빈을 중복해서 호출해도 @Configuratio의 바이트코드 조작 라이브러리르 통해 싱글톤으로 호출한다.
- 단 @Bean만 사용하면 싱글톤을 보장하진 않는다.

## 6. 컴포넌트 스캔

### 컴포넌트 스캔, 의존관계 자동 주입

- 설정정보에 @Bean을 나열해서 매번 빈을 등록하기 번거롭다.
- 그래서 스프링은 설정 정보가 없어도 자동으로 스프링 빈을 등록하는 컴포넌트 스캔이 있다.
- 또한 @Autowired를 통해 의존관계를 자동 주입할 수 있다.

### 컴포넌트 스캔

- @ComponentScan를 통해서 컴포넌트 스캔이 가능하다.
- 추가적으로 각 클래스에 @Component를 추가해서 컴포넌트 대상이 되도록한다.
- @Compnent붙은 클래스를 스프링 빈으로 등록한다.
- 빈 이름 전략
    - 클래스명을 사용하되 맨앞글자는 소문자이다.
    - @Component("memberService2") 이렇게 직접 지정가능하다.
- basePackage 설정으로 탐색 범위를 설정가능하다.
- @Component, @Controlller, @Service, @Repository, @Configuration 도 스캔 대상이 된다.

### @Autowired 의존관계 자동 주입

- 메소드 앞에 @Autowired를 붙히면 여러 의존관계를 한번에 주입받을 수 있다.
- 즉, getBean()과 동일하다 할 수 있다.

### 컴퍼넌트 스캔 중복 충돌

- 컴포넌트 스캔에 의해 스프링 빈이 등록될때, 이름이 같으면 스프링은 오류를 발생시킨다.
- 단, 자동 등록과, 수동등록의 빈이름이 중복될경우 수동 등록에 우선권이 있다.

## 7. 의존관계 자동 주입

### 다양한 의존관계 주입법

- 의존관계 주입은 크게 4가지 방법이 있다.
- 생성자 주입
- 수정자 주입(setter)
- 필드 주입
- 일반 메서드 주입

### 생성자 주입

- 생성자를 통해 의존 관계를 주입 받는 방법이다.
- 생성자 호출시점에 딱 1번만 호출되는 것이 보장된다.
- 불편, 필수 의존관계에 사용된다.
- 생성자가 1개면 @Autowired를 생략할 수 있다.

### 수정자 주입(setter)

- 수정자 메서드를 통해 의존관계를 주입하는 방법이다.
- 선택, 변경이 가능성이 있는 의존관계에 사용된다.

### 필드 주입

- 이름그대로 필드에 바로 주입하는 방법이다.
- 외부에서 변경이 불가능해서 테스트하기 힘들다는 단점이 있다.
- 또한 DI 프레임워크가 없으면 아무것도 할 수 없는 의존적이다.
- 사용을 권장하지 않는다.

### 일반 메서드 주입

- init()과 같은 메서드를 만들어서 주입하는 방법이다.
- 한번에 여러 필드를 주입받을 수 있다.

### 옵션 처리

- 스프링 빈이 있는지 여부에 따른 값 처리방법이 여러개 있다.
- @Autowired(required=false) → 자동 주입할 빈이 없으면 메서드 자체가 호출 안된다.
- @Nullable → 자동 주입할 빈이 없으면 null이 입력된다.
- Optional<> → 자동 주입할 빈이 없으면 Optional.empty가 입력된다.

### 적합한 자동주입 방법은?

- 일반적으로 생성자 주입을 권장한다.
- 대부분의 의존관계는 주입 일어나면 변경할 일이 없고, 불변해야한다.
- 수정자 주입은 public로 열어둬야하고 실수로 변경 가능하다.
- 생성자 주입은 불변하게 설계할 수 있다.

### 룸복이란?

- 생성자, 수정자, 등을 자동을 생성해주는 라이브러리이다.
- @RequiredArgsConstructor 기능 사용시 final이 붙은 필드를 모아서 생성자를 자동으로 만들어준다.
- @Getter, @Setter 을 사용해서 게터, 세터를 자동으로 만들어준다.

### @Autowired (자동 의존관계 주입)사용시 중복 문제 처리

- @Autowired는 타입으로 빈을 조회하고, 빈이 중복 시 중복문제가 발생할 수 있다.
- **@Autowired 필드명 매칭**
    - @Autowired가 처음 타입으로 매칭을 시도하고 여러개 중복될시 필드 이름, 파라미터 이름으로 빈 이름을 추가 매칭한다.
- **@Qualifier 사용**
    - 빈 등록시 @Qualifier를 사용하고 주입시에도 사용해준다.
- **@Primary**
    - 빈 등록 시 @Primary를 사용해서 우선순위를 정할 수 있다.

### 자동 빈등록 VS수동 빈등록

- 우선은 자동 주입 및 자동 등록을 선호하는 추세이다.
- 자동은 → 업무 로직 빈에 주로 사용되고
- 수동은 → 기술 지원 로직 빈에 사용되서 명확하게 드러내는 것이 좋다.

## 8. 빈 생명주기 콜백

### 스프링빈의 이벤트 라이프사이클

- 스프링은 의존관계 주입이 완료되면 스프링 빈에게 콜백 메서드를 통해서 초기화 시점을 알려주는 기능을 제공한다.
- 스프링은 스프링 컨테이너가 종료되기 직전에 소멸 콜백을 준다.
- 스프링 빈의 이벤트 라이프사이클 순서
    1. 스프링 컨테이너 생성
    2. 스프링 빈 생성
    3. 의존관계 주입
    4. 초기화 콜백
    5. 사용
    6. 소멸전 콜백
    7. 스프링 콜백
- 초기화 콜백 → 빈이 생성되고, 빈의 의존관계 주입이 완료된 후 호출한다.
- 소멸전 콜백 → 빈이 소멸되기 직전에 호출한다.

### 스프링의 빈 생명주기 콜백 방법

- 인터페이스(InitializingBean, DisposableBean)
- 설정 정보에 초기화 메서드, 종료 메서드 지정
- @PostConstruct, @PreDestroy 애노테이션 지원

### InitializingBean, DisposableBean 인터페이스

- InitializingBean 인터페이스의 afterPropertiesSet()메서드를 오버라이드 해서 초기화를 할 수 있다.
- DisposableBean 인터페이스의 destroy()메서드를 오버라이드 해서 초기화를 할 수 있다.
- 단점으로는
    - 스프링 전용 인터페이스여서 의존적이다.
    - 초기화, 소멸 메서드의 이름을 변경할 수 없다.
    - 코드를 고칠 수 없는 외부라이브러리에 적용할 수 없다.

### 설정 정보에 초기화 메서드, 종료 메서드 지정

- 설정정보에 @Bean(initMethod = "init", destroyMethod = "close")처럼 초기화 소멸 메서드를 지정할 수 있다.
- 메서드 이름이 자유롭다.
- 스프링 빈이 스프링 코드에 의존하지 않는다.
- 외부 라이브러리에 적용 가능하다.
- destroyMethod 속성은 기본적으로 close, shutdown을 기본값으로 추론한다.

### @PostConstruct, @PreDestroy 애노테이션 지원

- @PostConstruct, @PreDestroy해당 어노테이션을 초기화 메소드와 소멸 메소드에 추가하여 적용 가능하다.
- 최신 스프링이 가장 권장하는 방법이다.
- 편리하고 자바 표준이여서 스프링에 의존적이지 않다.
- 단, 외부라이브러리에는 적용하지 못한다. → @Bean의 initMethod, destroyMethod 속성 사용.

## 9. 빈 스코프

### 스프링의 스코프 종류

- 싱글톤 →
    - 기본 스코프이다.
    - 스프링 컨테이너의 시작과 종료까지 유지되는 가장 넓은 범위의 스코프이다.
- 프로토 타입 →
    - 스프링 컨테이너는 프로토타입 빈의 생성과 의존관계 주입까지만 관여하고 더는 관리하지 안흔 매우 짧은 범위의 스코프이다.
- 웹 관련 스코프 →
    - request : 웹 요청이 들어오고 나갈때 까지 유지되는 스코프이다.
    - session : 웹 세션이 생성되고 종료될 때 까지 유지되는 스코프이다.
    - applicaion : 웹의 서블릿 컨텍스트와 같은 범위로 유지되는 스코프이다.

### 빈 스코프 등록법

- @Scope(”prototype”) 처럼 Scope어노테이션을 통해 등록 가능하다.

### 프로토타입 스코프란?

- 프로토타입 스코프를 스프링 컨테이너에 조회하면 스프링 컨테이너는 항상 새로운 인스턴스를 생성해서 반환한다.
- 스프링 컨테이너는 프로토타입 빈을 생성하고, 의존관계 주입, 초기화까지만 처리한다.
- 즉 종료 메서드는 호출되지 않는다.

### Provider란?

- 지정한 빈을 컨테이너에서 대신 찾아주는 DL서비스를 제공하는것이 바로 Provider이다.

### 웹 스코프란?

- 웹 스코프는 웹 환경에서만 동작하는 스코프이다.
- 웹 스코프는 프로토타입과 다르게 스프링이 해당 스코프의 종료시점까지 관리한다.
- 종류로는 request, session, application, websocket가 있다.
    - request → HTTP 요청 하나가 들어오고 나갈때 까지 유지되는 스코프이다. 각각의 HTTP 요청마다 별도의 빈 인스턴스가 생성되고, 관리된다.
    - session → HTTP Session과 동일한 생명주기를 가지는 스코프이다.
    - application→ 서블릿 컨텍스트와 동일한 생명주기를 가지는 스코프이다.
    - websocket → 웹 소켓과 동일한 생명주기를 가지는 스코프이다.

### 프록시 객체

- @Scope의 proxyMode = ScopedProxyMode.TARGET_CLASS)를 설정하면 스프링 컨테이너는 가짜 프록시 객체를 생성한다.
- 가짜 프록시 객체는 요청이 오면 그때 내부에서 진짜 빈을 요청하는 위임 로직이 들어있다.
- 프록시 객체덕분에 클라이언트는 마치 싱글톤 빈을 사용하듯이 편리하게 request scope를 사용할 수 있다.
