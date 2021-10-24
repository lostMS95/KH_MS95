/*
    오라클에는 HR이라는 연습 계정이 있다
    
    이 계정은 최초에는 잠김 상태이므로 잠금을 풀어줘야 한다.
*/

alter user hr account unlock;

alter user hr identified by hr;