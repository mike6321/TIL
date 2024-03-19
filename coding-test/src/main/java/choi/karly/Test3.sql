-- 건물 정보
CREATE TABLE BUILDING (
                          CODE VARCHAR(255) NOT NULL,
                          NAME VARCHAR(255) NOT NULL,
                          PRIMARY KEY (CODE)
)
;
-- 시간표 정보
CREATE TABLE TIMETABLE (
                           CODE VARCHAR(255) NOT NULL,
                           DAY VARCHAR(10) NOT NULL,
                           STARTTIME TIME  NOT NULL,
                           ENDTIME TIME  NOT NULL,
                           PRIMARY KEY (CODE)
)
;

-- 강의실 정보
CREATE TABLE CLASSROOM (
                           CODE VARCHAR(255) NOT NULL,
                           NAME VARCHAR(255) NOT NULL,
                           BUILDINGCODE VARCHAR(255) NOT NULL,
                           FOREIGN KEY(BUILDINGCODE) REFERENCES BUILDING(CODE),
                           PRIMARY KEY (CODE)
)
;

-- 예약 정보
CREATE TABLE BOOK (
                      BOOKNUM INT AUTO_INCREMENT,
                      CLASSROOMCODE VARCHAR(255) NOT NULL,
                      TIMETABLECODE VARCHAR(255) NOT NULL,
                      BOOKER VARCHAR(255) NOT NULL,
                      PRIMARY KEY (BOOKNUM),
                      FOREIGN KEY(CLASSROOMCODE) REFERENCES CLASSROOM(CODE),
                      FOREIGN KEY(TIMETABLECODE) REFERENCES TIMETABLE(CODE),
                      UNIQUE (CLASSROOMCODE, TIMETABLECODE)
)
;
