# 37-SOPKATHON-SERVER-iOS1

37기 솝커톤 iOS 1팀 서버 레포지토리입니다.

## Git Convention
| **Type**    | **설명**          |
|------------|-------------------|
| `Feat`     | 기능 추가          |
| `Chore`    | 사소한 수정        |
| `Fix`      | 오류 수정          |
| `Refactor` | 리팩토링           |
| `Hotfix`   | 긴급한 버그 수정        |
| `Docs`     | 문서 수정          |
| `Deploy`   | 배포 관련          |
| `Test`     | 테스트 관련        |


- 커밋 메시지 : `[작업] #이슈번호 description` ex) [Feat] #1 회원가입 기능 구현

## Branch Rule
- `main` : 안정화된 운영 서버
- `develop` : 개발 서버
- 기능 브랜치 : develop에서 분기하여 개별 작업을 수행하는 브랜치
- 브랜치 네이밍 : `작업/#이슈번호-description` ex) feat/#1-signup

## Architecture
```shell
src
└── main
    ├── java
    │   └── org
    │       └── sopt
    │           └── 37-sopkathon
    │               ├── domain
    │                   └── user
    │                       ├── entity
    │                           └── User.class
    │                       ├── errorcode
    │                           └── UserErrorCode.class
    │                       ├── repository
    │                           └── UserRepository.class
    │                       └── service
    │                           └── UserService.class
    │               └── global
    │                   ├── annotation
    │                   ├── config
    │                   ├── WebConfig.java
    │                   ├── dto
    │                   ├── exception
    │                   └── Application.java


```
