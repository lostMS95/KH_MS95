-- kh라는 사용자에게 로그인 권한(create session)을 부여(grant)
grant create session to kh;

-- kh라는 사용자에게 로그인 권한을 회수(revoke)
revoke create session from kh;

-- kh라는 사용자에게 connect, resource 권한객체를 부여
grant connect, resource to kh;

-- 12c 이상에서의 기본 권한 부여
grant connect, resource, unlimited tablespace to kh;

--현재 유저 확인
SHOW USER;