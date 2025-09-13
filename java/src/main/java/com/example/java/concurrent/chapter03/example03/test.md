graph TD
A[시작] --> B(상품 데이터 입력<br>(전체 또는 변경분));

    B -- 전체 색인 --> C{전체 색인 로직};
    B -- 부분 색인 --> M{부분 색인 로직};

    C --> D(메모리 Set & S3 임시 저장소 초기화);
    D --> E[모든 상품 순회];
    E --> F{마스터코드<br>Set에 존재?};

    F -- 존재 (중복) --> G(Slack 알림<br>중복 상품 정보);
    G --> E; // 다음 상품 처리

    F -- 미존재 (고유) --> H(마스터코드 Set에 추가);
    H --> I(S3 임시 저장소 적재<br>MC | 상품번호 | 상품명);
    I --> J(EP 전송<br>A/U + MC | 상품코드 | 상품명);
    J --> E; // 다음 상품 처리

    E --> K{모든 상품 처리 완료?};
    K -- Yes --> L(S3에 임시 저장소 내용 저장<br>(전체 갱신));
    K -- No --> E;

    L --> Z(종료);

    M --> N(S3에서 마스터코드 정보 로드<br>MC -> {상품번호, 상품명});
    N --> O[변경 상품 순회];
    O --> P{마스터코드<br>S3에 존재?};

    P -- 미존재 --> Q(EP 전송<br>A/U + MC | 상품코드 | 상품명); // S3 업데이트 로직 필요 (명시되지 않음)
    Q --> O; // 다음 상품 처리

    P -- 존재 --> R{S3 상품번호 ==<br>입력 상품번호?};

    R -- Yes --> S(EP 전송<br>U + MC | 상품코드 | 상품명);
    S --> O; // 다음 상품 처리

    R -- No --> T(Slack 알림<br>중복(충돌) 상품 정보<br>(입력 상품 vs S3 상품));
    T --> U(EP 전송<br>D (입력 상품)); // 입력 상품은 중복으로 간주하여 D 전송
    U --> O; // 다음 상품 처리

    O --> V{모든 변경 상품 처리 완료?};
    V -- Yes --> Z;
    V -- No --> O;

    Z[종료];

    %% 스타일링 (선택 사항)
    classDef decision fill:#f9f,stroke:#333,stroke-width:2px;
    classDef process fill:#ccf,stroke:#333,stroke-width:2px;
    classDef data fill:#cfc,stroke:#333,stroke-width:2px;
    classDef startend fill:#ff9,stroke:#333,stroke-width:2px;
    classDef alert fill:#fcc,stroke:#333,stroke-width:2px;

    class C,M decision;
    class D,E,H,I,J,N,O,Q,S,U process;
    class F,K,P,R,V decision;
    class G,T alert;
    class A,Z startend;
