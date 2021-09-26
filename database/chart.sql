--테이블 생성
CREATE TABLE chart(   
music_no number(5),
music_rank number(2),
music_name varchar2(100),
artist_name varchar2(100),
album_name varchar2(100),
like_count number(6)
);

--시퀀스 생성
CREATE SEQUENCE chart_seq;

--정보 입력
insert into chart values(chart_seq.nextval, 1 , 'STAY' , 'The Kid LAROI, Justin Bieber' ,'Stay' ,149477);
insert into chart values(chart_seq.nextval, 2,'신호등','이무진','신호등',213673);
insert into chart values(chart_seq.nextval, 3,'Permission to Dance','방탄소년단','Butter / Permission to Dance',175116);
insert into chart values(chart_seq.nextval, 4,'OHAYO MY NIGHT','디핵,파테코','OHAYO MY NIGHT',131563);
insert into chart values(chart_seq.nextval, 5,'Next Level','aespa','Next Level',205743);
insert into chart values(chart_seq.nextval, 6,'Butter','방탄소년단','Butter',243669);
insert into chart values(chart_seq.nextval, 7,'바라만 본다','MSG워너비','MSG워너비 1집',156234);
insert into chart values(chart_seq.nextval, 8,'Weekend','태연(TAEYEON)','Weekend',137153);
insert into chart values(chart_seq.nextval, 9,'낙하 (with 아이유)','AKMU (악뮤)','NEXT EPISODE',123670);
insert into chart values(chart_seq.nextval, 10,'Queendom','Red Velvet (레드벨벳)','Queendom - The 6th Mini Album',91229);

--컬럼 조정
column music_rank format 99;
column music_name format a20;
column artist_name format a10;
column album_name  format a15;

--최종 저장
COMMIT;