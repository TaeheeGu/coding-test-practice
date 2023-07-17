
-----------------------------------------CREATE DEPARTMENT-----------------------------------------
CREATE TABLE FINTECH."DEPARTMENT" ( 
                              "ID"	NUMBER(38, 0)		NOT NULL, 
                              "NM"	VARCHAR(255)		NULL, 
                              "CREATED_AT"	TIMESTAMP		NULL, 
                              "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."DEPARTMENT"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."DEPARTMENT"."NM" IS '*NAME / 부서 이름'; 
 
 

-----------------------------------------CREATE JOB_TITLE-----------------------------------------
CREATE TABLE FINTECH."JOB_TITLE" ( 
                             "ID"	NUMBER(38, 0)		NOT NULL, 
                             "NM"	VARCHAR(255)		NULL, 
                             "CREATED_AT"	TIMESTAMP		NULL, 
                             "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."JOB_TITLE"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."JOB_TITLE"."NM" IS '*NAME / 직책 이름'; 
 
 

-----------------------------------------CREATE JOB_POSITION-----------------------------------------
CREATE TABLE FINTECH."JOB_POSITION" ( 
                                "ID"	NUMBER(38, 0)		NOT NULL, 
                                "NM"	VARCHAR(255)		NULL, 
                                "CREATED_AT"	TIMESTAMP		NULL, 
                                "UPDATED_AT"	DATE		NULL 
); 
 
COMMENT ON COLUMN FINTECH."JOB_POSITION"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."JOB_POSITION"."NM" IS '*NAME / 직위 이름'; 
 
 

-----------------------------------------CREATE EMPLOYEE-----------------------------------------
CREATE TABLE FINTECH."EMPLOYEE" ( 
                            "ID"	NUMBER(38, 0)		NOT NULL, 
                            "DEPT_ID"	NUMBER(38, 0)		NOT NULL, 
                            "JBPS_ID"	NUMBER(38, 0)		NOT NULL, 
                            "JBTTL_ID"	NUMBER(38, 0)		NOT NULL, 
                            "NO"	NUMBER(38, 0)		NULL, 
                            "NM"	VARCHAR(255)		NULL, 
                            "FXNO"	VARCHAR(255)		NULL, 
                            "EML"	VARCHAR(255)		NULL, 
                            "TEL"	VARCHAR(255)		NULL, 
                            "CREATED_AT"	TIMESTAMP		NULL, 
                            "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."EMPLOYEE"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."EMPLOYEE"."DEPT_ID" IS '*DEPARTMENT ID / 부서 ID'; 
 
COMMENT ON COLUMN FINTECH."EMPLOYEE"."JBPS_ID" IS '*JOB POSITION ID / 직위 ID'; 
 
COMMENT ON COLUMN FINTECH."EMPLOYEE"."JBTTL_ID" IS '*JOB TITLE ID / 직책 ID'; 
 
COMMENT ON COLUMN FINTECH."EMPLOYEE"."NO" IS '*NUMBER / 직원 번호(사번)'; 
 
COMMENT ON COLUMN FINTECH."EMPLOYEE"."NM" IS '*NAME / 직원 이름'; 
 
COMMENT ON COLUMN FINTECH."EMPLOYEE"."FXNO" IS '*FAX NUMBER / 팩스 번호'; 
 
COMMENT ON COLUMN FINTECH."EMPLOYEE"."EML" IS '*EMAIL / 이메일'; 
 
COMMENT ON COLUMN FINTECH."EMPLOYEE"."TEL" IS '*TEL / 연락처'; 
 
 

-----------------------------------------CREATE UNION_EMPLOYEE_REL-----------------------------------------
CREATE TABLE FINTECH."UNION_EMPLOYEE_REL" ( 
                                      "ID"	NUMBER(38, 0)		NOT NULL, 
                                      "UNION_ID"	NUMBER(38, 0)		NOT NULL, 
                                      "EMP_ID"	NUMBER(38, 0)		NOT NULL, 
                                      "CREATED_AT"	TIMESTAMP		NULL, 
                                      "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."UNION_EMPLOYEE_REL"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."UNION_EMPLOYEE_REL"."UNION_ID" IS '*UNION ID / 조합원 ID'; 
 
COMMENT ON COLUMN FINTECH."UNION_EMPLOYEE_REL"."EMP_ID" IS '*EMPLOYEE ID / 직원 ID'; 
 
 

-----------------------------------------CREATE CUSTOMER-----------------------------------------
CREATE TABLE FINTECH."CUSTOMER" ( 
                            "ID"	NUMBER(38, 0)		NOT NULL, 
                            "TY"	VARCHAR(255)		NULL, 
                            "CD"	VARCHAR(255)		NULL, 
                            "CREATED_AT"	TIMESTAMP		NULL, 
                            "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."CUSTOMER"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."CUSTOMER"."TY" IS '*TYPE / 고객 유형 / 종사자 , 조합원 , 미가입'; 
 
COMMENT ON COLUMN FINTECH."CUSTOMER"."CD" IS '*CODE / 고객 코드'; 
 
 

-----------------------------------------CREATE PERSONAL_CUSTOMER-----------------------------------------
CREATE TABLE FINTECH."PERSONAL_CUSTOMER" ( 
                                     "ID"	NUMBER(38, 0)		NOT NULL, 
                                     "CUST_ID"	NUMBER(38, 0)		NOT NULL, 
                                     "GENDER"	VARCHAR(1)		NULL, 
                                     "RRNO"	VARCHAR(255)		NULL, 
                                     "JOIN_DT"	TIMESTAMP		NULL, 
                                     "TEL"	VARCHAR(255)		NULL, 
                                     "NM"	VARCHAR(255)		NULL, 
                                     "EML"	VARCHAR(255)		NULL, 
                                     "CREATED_AT"	TIMESTAMP		NULL, 
                                     "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."PERSONAL_CUSTOMER"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."PERSONAL_CUSTOMER"."CUST_ID" IS '*CUSTOMER ID / 고객 ID'; 
 
COMMENT ON COLUMN FINTECH."PERSONAL_CUSTOMER"."GENDER" IS '*GENDER / 성별 / F, M'; 
 
COMMENT ON COLUMN FINTECH."PERSONAL_CUSTOMER"."RRNO" IS '*RESIDENT REGISTRATION NUMBER / 주민등록번호'; 
 
COMMENT ON COLUMN FINTECH."PERSONAL_CUSTOMER"."JOIN_DT" IS '*JOIN DATE /  등록일'; 
 
COMMENT ON COLUMN FINTECH."PERSONAL_CUSTOMER"."TEL" IS '*TELEPHONE / 휴대폰'; 
 
COMMENT ON COLUMN FINTECH."PERSONAL_CUSTOMER"."NM" IS '*NAME / 이름'; 
 
COMMENT ON COLUMN FINTECH."PERSONAL_CUSTOMER"."EML" IS '*EMAIL / 이메일'; 
 
 

-----------------------------------------CREATE UNION-----------------------------------------
CREATE TABLE FINTECH."UNION" ( 
                         "ID"	NUMBER(38, 0)		NOT NULL, 
                         "CUST_ID"	NUMBER(38, 0)		NOT NULL, 
                         "CD"	VARCHAR(255)		NULL, 
                         "JOIN_DT"	TIMESTAMP		NULL, 
                         "INVST_YN"	VARCHAR(1)		NULL, 
                         "BRNO"	VARCHAR(255)		NULL, 
                         "RPRS_NM"	VARCHAR(255)		NULL, 
                         "OPBIZ_YMD"	TIMESTAMP		NULL, 
                         "CORP_NM"	VARCHAR(255)		NULL, 
                         "TY"	VARCHAR(255)		NULL, 
                         "ADDR"	VARCHAR(255)		NULL, 
                         "CREATED_AT"	TIMESTAMP		NULL, 
                         "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."UNION"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."UNION"."CUST_ID" IS '*CUSTOMER ID / 고객ID'; 
 
COMMENT ON COLUMN FINTECH."UNION"."CD" IS '*CODE / 조합원 코드'; 
 
COMMENT ON COLUMN FINTECH."UNION"."JOIN_DT" IS '*JOIN DATE / 가입일'; 
 
COMMENT ON COLUMN FINTECH."UNION"."INVST_YN" IS '*INVESTMENT Y/N / 출자 여부'; 
 
COMMENT ON COLUMN FINTECH."UNION"."BRNO" IS '*BUSINESS REGISTRATION NUMBER / 사업자 등록 번호'; 
 
COMMENT ON COLUMN FINTECH."UNION"."RPRS_NM" IS '*REPRESENTATIVE NAME / 대표자 이름'; 
 
COMMENT ON COLUMN FINTECH."UNION"."OPBIZ_YMD" IS '*OPENING OF BUSINESS YEAR MONTH DAY / 개업연월일, YYYYMMDD'; 
 
COMMENT ON COLUMN FINTECH."UNION"."CORP_NM" IS '*CORPORATION NAME / 법인이름'; 
 
COMMENT ON COLUMN FINTECH."UNION"."TY" IS '*TYPE / 유형'; 
 
COMMENT ON COLUMN FINTECH."UNION"."ADDR" IS '*ADDERSS / 주소'; 
 
 

-----------------------------------------CREATE RIDER_UNION_REL-----------------------------------------
CREATE TABLE FINTECH."RIDER_UNION_REL" ( 
                                   "ID"	NUMBER(38, 0)		NOT NULL, 
                                   "UNION_ID"	NUMBER(38, 0)		NOT NULL, 
                                   "RIDER_ID"	NUMBER(38, 0)		NOT NULL, 
                                   "CREATED_AT"	TIMESTAMP		NULL, 
                                   "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."RIDER_UNION_REL"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."RIDER_UNION_REL"."UNION_ID" IS '*UNION ID / 조합원 ID'; 
 
COMMENT ON COLUMN FINTECH."RIDER_UNION_REL"."RIDER_ID" IS '*RIDER ID / 라이더 ID'; 
 
 

-----------------------------------------CREATE RIDER-----------------------------------------
CREATE TABLE FINTECH."RIDER" ( 
                         "ID"	NUMBER(38, 0)		NOT NULL, 
                         "PRCUST_ID"	NUMBER(38, 0)		NOT NULL, 
                         "JOB_TY"	VARCHAR(255)		NULL, 
                         "RISK_TY"	VARCHAR(255)		NULL, 
                         "CREATED_AT"	TIMESTAMP		NULL, 
                         "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."RIDER"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."RIDER"."PRCUST_ID" IS '*PERSONAL CUSTOMER ID / 개인 고객 ID'; 
 
COMMENT ON COLUMN FINTECH."RIDER"."JOB_TY" IS '*JOB TYPE / 전업유형 / 전업, 부업'; 
 
COMMENT ON COLUMN FINTECH."RIDER"."RISK_TY" IS '*RISK TYPE / 위험 유형'; 
 
 

-----------------------------------------CREATE DISCUSSION-----------------------------------------
CREATE TABLE FINTECH."DISCUSSION" ( 
                              "ID"	NUMBER(38, 0)		NOT NULL, 
                              "CUST_ID"	NUMBER(38, 0)		NOT NULL, 
                              "NO"	VARCHAR(255)		NULL, 
                              "PSBLTY_BGNG_HR"	NUMBER(38, 0)		NULL, 
                              "PSBLTY_END_HR"	NUMBER(38, 0)		NULL, 
                              "APLY_CN"	VARCHAR(2000)		NULL, 
                              "APLY_TY"	VARCHAR(255)		NULL, 
                              "APLY_DT"	TIMESTAMP		NULL, 
                              "STTS"	VARCHAR(255)		NULL, 
                              "BGNG_DATE"	TIMESTAMP		NULL, 
                              "END_DT"	TIMESTAMP		NULL, 
                              "CN"	VARCHAR(2000)		NULL, 
                              "EMP_ID"	NUMBER(38, 0)		NULL, 
                              "EMP_DEPT"	VARCHAR(255)		NULL, 
                              "EMP_JBPS"	VARCHAR(255)		NULL, 
                              "EMP_JBTTL"	VARCHAR(255)		NULL, 
                              "CREATED_AT"	TIMESTAMP		NULL, 
                              "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."DISCUSSION"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."DISCUSSION"."CUST_ID" IS '*CUSTOMER ID / 고객 ID'; 
 
COMMENT ON COLUMN FINTECH."DISCUSSION"."NO" IS '*NUMBER / 상담 신청 번호'; 
 
COMMENT ON COLUMN FINTECH."DISCUSSION"."PSBLTY_BGNG_HR" IS '*POSSIBILITY BEGINNING HOUR / 상담 가능 시작 시간'; 
 
COMMENT ON COLUMN FINTECH."DISCUSSION"."PSBLTY_END_HR" IS '*POSSIBILITY END HOUR / 상담 가능 종료 시간'; 
 
COMMENT ON COLUMN FINTECH."DISCUSSION"."APLY_CN" IS '*APPLY CONTENT / 상담 신청 내용'; 
 
COMMENT ON COLUMN FINTECH."DISCUSSION"."APLY_TY" IS '*APPLY TYPE / 상담 신청 유형'; 
 
COMMENT ON COLUMN FINTECH."DISCUSSION"."APLY_DT" IS '*APPLY DATE / 상담 신청 일시'; 
 
COMMENT ON COLUMN FINTECH."DISCUSSION"."STTS" IS '*STATUS / 상담 상태 / 미진행, 완료, ...'; 
 
COMMENT ON COLUMN FINTECH."DISCUSSION"."BGNG_DATE" IS '*BEGINNING DATE / 상담 시작 일시'; 
 
COMMENT ON COLUMN FINTECH."DISCUSSION"."END_DT" IS '*END DATE / 상담 종료 일시'; 
 
COMMENT ON COLUMN FINTECH."DISCUSSION"."CN" IS '*CONTENT / 상담 진행 내용'; 
 
COMMENT ON COLUMN FINTECH."DISCUSSION"."EMP_ID" IS '*EMPLOYEE ID / 담당 직원 ID'; 
 
COMMENT ON COLUMN FINTECH."DISCUSSION"."EMP_DEPT" IS '*EMPLOYEE DEPARTMENT / 담당 직원 부서'; 
 
COMMENT ON COLUMN FINTECH."DISCUSSION"."EMP_JBPS" IS '*EMPLOYEE JOB POSITION / 담당 직원 직위'; 
 
COMMENT ON COLUMN FINTECH."DISCUSSION"."EMP_JBTTL" IS '*EMPLOYEE JOB TITLE / 담당 직원 직책'; 
 
 

-----------------------------------------CREATE TERMS-----------------------------------------
CREATE TABLE FINTECH."TERMS" ( 
                         "ID"	NUMBER(38, 0)		NOT NULL, 
                         "NM"	VARCHAR(255)		NULL, 
                         "CD"	VARCHAR(255)		NULL, 
                         "CN"	VARCHAR(2000)		NULL, 
                         "ESNTL_YN"	VARCHAR(1)	DEFAULT 'N'	NULL, 
                         "CREATED_AT"	TIMESTAMP		NULL, 
                         "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."TERMS"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."TERMS"."NM" IS '*NAME / 약관 이름'; 
 
COMMENT ON COLUMN FINTECH."TERMS"."CD" IS '*CODE / 약관 코드'; 
 
COMMENT ON COLUMN FINTECH."TERMS"."CN" IS '*CONTENT / 약관 내용'; 
 
COMMENT ON COLUMN FINTECH."TERMS"."ESNTL_YN" IS '*ESSENTIAL YN / 약관 필수 동의 여부'; 
 
 

-----------------------------------------CREATE CUSTOMER_TERMS_REL-----------------------------------------
CREATE TABLE FINTECH."CUSTOMER_TERMS_REL" ( 
                                      "ID"	NUMBER(38, 0)		NOT NULL, 
                                      "CUST_ID"	NUMBER(38, 0)		NOT NULL, 
                                      "TERMS_ID"	NUMBER(38, 0)		NOT NULL, 
                                      "AGRE_DT"	TIMESTAMP		NULL, 
                                      "CREATED_AT"	TIMESTAMP		NULL, 
                                      "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."CUSTOMER_TERMS_REL"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."CUSTOMER_TERMS_REL"."CUST_ID" IS '*CUSTOMER ID / 고객 ID'; 
 
COMMENT ON COLUMN FINTECH."CUSTOMER_TERMS_REL"."TERMS_ID" IS '*TERMS ID / 약관 ID'; 
 
COMMENT ON COLUMN FINTECH."CUSTOMER_TERMS_REL"."AGRE_DT" IS '*AGREEMENT DATE / 동의 일시'; 
 
 

-----------------------------------------CREATE VEHICLE-----------------------------------------
CREATE TABLE FINTECH."VEHICLE" ( 
                           "ID"	NUMBER(38, 0)		NOT NULL, 
                           "CUST_ID"	NUMBER(38, 0)		NOT NULL, 
                           "REG_TY"	VARCHAR(255)		NULL, 
                           "VHRNO"	VARCHAR(16)		NULL, 
                           "VIN"	VARCHAR(17)		NULL, 
                           "VHCL_REG_YMD"	TIMESTAMP		NULL, 
                           "USG"	VARCHAR(255)		NULL, 
                           "ERDR_YN"	VARCHAR(1)	DEFAULT 'N'	NULL, 
                           "DGST_YN"	VARCHAR(1)	DEFAULT 'N'	NULL, 
                           "DSPY_YN"	VARCHAR(1)	DEFAULT 'N'	NULL, 
                           "MCHN_YN"	VARCHAR(1)	DEFAULT 'N'	NULL, 
                           "STBLT_YN"	VARCHAR(1)	DEFAULT 'N'	NULL, 
                           "EMRG_GUT_YN"	VARCHAR(1)	DEFAULT 'N'	NULL, 
                           "DSPL"	VARCHAR(255)		NULL, 
                           "FUEL_TY"	VARCHAR(255)		NULL, 
                           "VHCL_TY"	VARCHAR(255)		NULL, 
                           "MAKR_TY"	VARCHAR(255)		NULL, 
                           "MAKR"	VARCHAR(255)		NULL, 
                           "MODEL_NM"	VARCHAR(255)		NULL, 
                           "SEG"	VARCHAR(255)		NULL, 
                           "VHCL_AMT"	NUMBER(38, 0)		NULL, 
                           "MNFTR_YR"	NUMBER(38, 0)		NULL, 
                           "VHCL_CD"	VARCHAR(255)		NULL, 
                           "CREATED_AT"	TIMESTAMP		NULL, 
                           "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."CUST_ID" IS '*CUSTOMER ID / 고객 ID'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."REG_TY" IS '*REGISTRATION TYPE / 등록 유형 / 이륜자동차사용신고필증, 차량/차대번호 등록, 구입예정, ...'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."VHRNO" IS '*VEHICLE NUMBER / 차량번호 / 16자리 이내 문자'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."VIN" IS '*VEHICLE IDENTIFICATION NUMBER / 차대 번호 / 17자리 이내 문자'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."VHCL_REG_YMD" IS '*VEHICLE REGISTRATION YEAR MONTH DAY / 차량 등록일 / YYYYMMDD'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."USG" IS '*USAGE / 용도 / 유상운송, 비유상운송 여부'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."ERDR_YN" IS '*EVENT DATA RECORDER YN / 블랙박스 여부 / Y, N(DEFAULT)'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."DGST_YN" IS '*DANGEROUS ARTICLE YN / 위험물질 여부 / Y, N(DEFAULT)'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."DSPY_YN" IS '*DISPLAY YN / 전시차량 여부 / Y, N(DEFALUT)'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."MCHN_YN" IS '*MACHINE / 정밀기계 여부 / Y, N(DEFAULT)'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."STBLT_YN" IS '*SUITABILITY YN / 요율적합 여부 / Y, N(DEFAULT)'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."EMRG_GUT_YN" IS '*EMERGENCY GOING OUT YN / 긴급출동 여부 / Y, N(DEFAULT)'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."DSPL" IS '*DISPLACEMENT / 배기량(출력량) / 전기차의 경우 출력량'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."FUEL_TY" IS '*FUEL TYPE / 연료 유형 / 휘발유, 경유, 전기, 수소, LPG'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."VHCL_TY" IS '*VEHICLE TYPE / 차종'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."MAKR_TY" IS '*MAKER TYPE / 제조사 유형 / 국내, 외제'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."MAKR" IS '*MAKER / 제조사'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."MODEL_NM" IS '*MODEL NAME / 모델 명'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."SEG" IS '*SEGMENT / 분류 / 소형, 중형,  대형'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."VHCL_AMT" IS '*VEHICLE AMOUNT / 차량 가액 / 보험개발원-차량기준가액표'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."MNFTR_YR" IS '*MANUFACT YEAR / 제조년(연식) / YYYY'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE"."VHCL_CD" IS '*VEHICL CODE / 차명코드'; 
 
 

-----------------------------------------CREATE VEHICLE_FILE-----------------------------------------
CREATE TABLE FINTECH."VEHICLE_FILE" ( 
                                "ID"	NUMBER(38, 0)		NOT NULL, 
                                "VHCL_ID"	NUMBER(38, 0)		NOT NULL, 
                                "TY"	VARCHAR(255)		NULL, 
                                "ORGNL_NM"	VARCHAR(255)		NULL, 
                                "PATH"	VARCHAR(255)		NULL, 
                                "EXTN"	VARCHAR(255)		NULL, 
                                "ULD_DT"	TIMESTAMP		NULL, 
                                "CREATED_AT"	TIMESTAMP		NULL, 
                                "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."VEHICLE_FILE"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE_FILE"."VHCL_ID" IS '*VEHICLE ID / 차량 ID'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE_FILE"."TY" IS '*TYPE / 파일 타입 / 이륜자동차사용신고필증, 차량/차대번호'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE_FILE"."ORGNL_NM" IS '*ORIGINAL NAME / 파일 원본 이름'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE_FILE"."PATH" IS '*PATH / 파일 경로'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE_FILE"."EXTN" IS '*EXTENSION / 파일 확장자'; 
 
COMMENT ON COLUMN FINTECH."VEHICLE_FILE"."ULD_DT" IS '*UPLOAD DATE / 업로드 일시'; 
 
 

-----------------------------------------CREATE ADDRESS-----------------------------------------
CREATE TABLE FINTECH."ADDRESS" ( 
                           "ID"	NUMBER(38, 0)		NOT NULL, 
                           "ADDR_TY"	VARCHAR(255)		NULL, 
                           "ADDR"	VARCHAR(255)		NULL, 
                           "CREATED_AT"	TIMESTAMP		NULL, 
                           "UPDATED_ATD"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."ADDRESS"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."ADDRESS"."ADDR_TY" IS '*ADDR TYPE / 자택, 회사, 기타'; 
 
COMMENT ON COLUMN FINTECH."ADDRESS"."ADDR" IS '*ADDRESS / 주소'; 
 
 

-----------------------------------------CREATE ADDRESS_MEMBER_REL-----------------------------------------
CREATE TABLE FINTECH."ADDRESS_MEMBER_REL" ( 
                                      "ID"	NUMBER(38, 0)		NOT NULL, 
                                      "ADDR_ID"	NUMBER(38, 0)		NOT NULL, 
                                      "PRCUST_ID"	NUMBER(38, 0)		NOT NULL, 
                                      "CREATED_AT"	TIMESTAMP		NULL, 
                                      "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."ADDRESS_MEMBER_REL"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."ADDRESS_MEMBER_REL"."ADDR_ID" IS '*ADDRESS ID / 주소 ID'; 
 
COMMENT ON COLUMN FINTECH."ADDRESS_MEMBER_REL"."PRCUST_ID" IS '*PERSONAL CUSTOMER ID / 개인고객 ID'; 
 
 

-----------------------------------------CREATE CONTRACT_DESIGN-----------------------------------------
CREATE TABLE FINTECH."CONTRACT_DESIGN" ( 
                                   "ID"	NUMBER(38, 0)		NOT NULL, 
                                   "CUST_ID"	NUMBER(38, 0)		NOT NULL, 
                                   "NO"	VARCHAR(255)		NULL, 
                                   "VL"	VARCHAR(4000)		NULL, 
                                   "DESIGN_STTS"	VARCHAR(255)		NULL, 
                                   "CREATED_AT"	TIMESTAMP		NULL, 
                                   "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."CONTRACT_DESIGN"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT_DESIGN"."CUST_ID" IS '*CUSTOMER ID / 고객 ID'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT_DESIGN"."NO" IS 'UNIQUE *NUMBER / 설계번호'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT_DESIGN"."VL" IS '*VALUE / 설계 JSON'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT_DESIGN"."DESIGN_STTS" IS '*DESIGN STATUS / 설계 상태 / 설계중, 보완요청, 심사중, 청약접수'; 
 
 

-----------------------------------------CREATE CONTRACT_DESIGN_FILE-----------------------------------------
CREATE TABLE FINTECH."CONTRACT_DESIGN_FILE" ( 
                                        "ID"	NUMBER(38, 0)		NOT NULL, 
                                        "CTRT_DESIGN_ID"	NUMBER(38, 0)		NOT NULL, 
                                        "PATH"	VARCHAR(255)		NULL, 
                                        "ORGNL_NM"	VARCHAR(255)		NULL, 
                                        "TY"	VARCHAR(255)		NULL, 
                                        "EXTN"	VARCHAR(255)		NULL, 
                                        "ULD_DT"	TIMESTAMP		NULL, 
                                        "CREATED_AT"	TIMESTAMP		NULL, 
                                        "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."CONTRACT_DESIGN_FILE"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT_DESIGN_FILE"."CTRT_DESIGN_ID" IS '*CONTRACT DESIGN ID / 계약설계 ID'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT_DESIGN_FILE"."PATH" IS '*PATH / 저장경로'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT_DESIGN_FILE"."ORGNL_NM" IS '*ORIGINAL NAME / 원본이름'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT_DESIGN_FILE"."TY" IS '*TYPE / 파일 유형'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT_DESIGN_FILE"."EXTN" IS '*EXTENSION / 파일 확장자'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT_DESIGN_FILE"."ULD_DT" IS '*UPLOAD DATE / 업로드 일시'; 
 
 

-----------------------------------------CREATE ADDRESS_CONTRACT_CUSTOMER_REL-----------------------------------------
CREATE TABLE FINTECH."ADDRESS_CONTRACT_CUSTOMER_REL" ( 
                                                 "ID"	NUMBER(38, 0)		NOT NULL, 
                                                 "CTRT_CUST_ID"	NUMBER(38, 0)		NOT NULL, 
                                                 "ADDR_ID"	NUMBER(38, 0)		NOT NULL, 
                                                 "CREATED_AT"	TIMESTAMP		NULL, 
                                                 "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."ADDRESS_CONTRACT_CUSTOMER_REL"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."ADDRESS_CONTRACT_CUSTOMER_REL"."CTRT_CUST_ID" IS '*CONTRACT CUSTOMER ID / 계약 고객 ID'; 
 
COMMENT ON COLUMN FINTECH."ADDRESS_CONTRACT_CUSTOMER_REL"."ADDR_ID" IS '*ADDRESS ID / 주소 ID'; 
 
 

-----------------------------------------CREATE CONTRACT_CUSTOMER_REL-----------------------------------------
CREATE TABLE FINTECH."CONTRACT_CUSTOMER_REL" ( 
                                         "ID"	NUMBER(38, 0)		NOT NULL, 
                                         "CTRT_ID"	NUMBER(38, 0)		NOT NULL, 
                                         "CUST_ID"	NUMBER(38, 0)		NOT NULL, 
                                         "TY"	VARCHAR(255)		NULL, 
                                         "TY_CD"	NUMBER(38, 0)		NULL, 
                                         "REL"	VARCHAR(255)		NULL, 
                                         "REL_CD"	NUMBER(38, 0)		NULL, 
                                         "CREATED_AT"	TIMESTAMP		NULL, 
                                         "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."CONTRACT_CUSTOMER_REL"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT_CUSTOMER_REL"."CTRT_ID" IS '*CONTRACT ID / 꼐약 ID'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT_CUSTOMER_REL"."CUST_ID" IS '*CUSTOMER ID / 고객 ID'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT_CUSTOMER_REL"."TY" IS '*TYPE / 계약자, 피공제자'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT_CUSTOMER_REL"."TY_CD" IS '*TYPE CODE / 유형 코드'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT_CUSTOMER_REL"."REL" IS '*RELATION / 본인, 부모, ... (계약자와 관계)'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT_CUSTOMER_REL"."REL_CD" IS '*RELATION CODE / 관계 코드'; 
 
 

-----------------------------------------CREATE CONTRACT_VEHICLE_REL-----------------------------------------
CREATE TABLE FINTECH."CONTRACT_VEHICLE_REL" ( 
                                        "ID"	NUMBER(38, 0)		NOT NULL, 
                                        "CTRT_ID"	NUMBER(38, 0)		NOT NULL, 
                                        "VHCL_ID"	NUMBER(38, 0)		NOT NULL, 
                                        "CREATED_AT"	TIMESTAMP		NULL, 
                                        "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."CONTRACT_VEHICLE_REL"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT_VEHICLE_REL"."CTRT_ID" IS '*CONTRACT ID / 계약 ID'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT_VEHICLE_REL"."VHCL_ID" IS '*VEHICLE ID / 차량 ID'; 
 
 

-----------------------------------------CREATE CONTRACT-----------------------------------------
CREATE TABLE FINTECH."CONTRACT" ( 
                            "ID"	NUMBER(38, 0)		NOT NULL, 
                            "CTRT_NO"	VARCHAR(255)		NULL, 
                            "CTRT_DT"	TIMESTAMP		NULL, 
                            "INSRNC_PD"	NUMBER(38, 0)		NULL, 
                            "INSRNC_BGNG_YMD"	TIMESTAMP		NULL, 
                            "INSRNC_END_YMD"	TIMESTAMP		NULL, 
                            "INSRNC_RT"	NUMBER		NULL, 
                            "DSCNT_EXCG_DGRD"	VARCHAR(255)		NULL, 
                            "PAY_UNIT"	NUMBER(38, 0)		NULL, 
                            "TOT_INSRNC_PRMUM"	NUMBER(38, 0)		NULL, 
                            "INSRNC_PRMUM"	NUMBER(38, 0)		NULL, 
                            "CTRT_AMT"	NUMBER(38, 0)		NULL, 
                            "CTRT_AMT_YN"	VARCHAR(1)	DEFAULT 'N'	NULL, 
                            "ATMC_RENW_YN"	VARCHAR(1)	DEFAULT 'N'	NULL, 
                            "CTRT_STTS"	VARCHAR(255)		NULL, 
                            "INSRNC_HIST_GRD"	VARCHAR(255)		NULL, 
                            "INSRNC_HIST_YN"	VARCHAR(1)	DEFAULT 'N'	NULL, 
                            "INSRNC_HIST_PD"	NUMBER(38, 0)		NULL, 
                            "CREATED_AT"	TIMESTAMP		NULL, 
                            "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."CONTRACT"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT"."CTRT_NO" IS 'UNIQUE *CONTRACT NUMBER / 계약 번호'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT"."CTRT_DT" IS '*CONTRACT DATE / 계약 일'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT"."INSRNC_PD" IS '*INSURANCE PERIOD / 보험기간 / MM'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT"."INSRNC_BGNG_YMD" IS '*INSURANCE BEGINNING YEAR MONTH DATE / 보험(공제) 시작 일자 / YYYYMMDD'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT"."INSRNC_END_YMD" IS '*INSURANCE END YEAR MONTH DATE / 보험(공제) 종료 일자 / YYYYMMDD'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT"."INSRNC_RT" IS '*INSURANCE RATE / 요율 / 부동 소수점'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT"."DSCNT_EXCG_DGRD" IS '*DISCOUNT  EXTRA CHARGE GRADE / 할인할증 등급'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT"."PAY_UNIT" IS '*PAY UNIT / 납입 단위 / 일시납 = 1, 2회납 = 2, ...'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT"."TOT_INSRNC_PRMUM" IS '*TOTAL INSURANCE PREMIUM / 총 보험료 / 계약상 발생한 총 보험료'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT"."INSRNC_PRMUM" IS '*INSURANCE PREMIUM / 실납입 총 보험료'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT"."CTRT_AMT" IS '*CONTRACT AMOUNT / 가입금'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT"."CTRT_AMT_YN" IS '*CONTRACT AMOUNT YN / 가입금 납입 여부 / Y , N(DEFAULT)'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT"."ATMC_RENW_YN" IS '*AUTOMATIC RENEWAL YN / 자동갱신 여부 / Y , N(DEFAULT)'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT"."CTRT_STTS" IS '*CONTRACT STATUS / 계약 상태 / 정상계약, 해지취소, 만기'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT"."INSRNC_HIST_GRD" IS '*INSURANCE HISTORY GRADE / 이전 보험 적용 등급'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT"."INSRNC_HIST_YN" IS '*INSURANCE HISTORY YN / 가입 이력 여부 / Y , N(DEFAULT)'; 
 
COMMENT ON COLUMN FINTECH."CONTRACT"."INSRNC_HIST_PD" IS '*INSURANCE HISTORY PERIOD / 이전 보험 가입 기간'; 
 
 

-----------------------------------------CREATE ENDORSE-----------------------------------------
CREATE TABLE FINTECH."ENDORSE" ( 
                           "ID"	NUMBER(38, 0)		NOT NULL, 
                           "CTRT_ID"	NUMBER(38, 0)		NOT NULL, 
                           "NO"	NUMBER(38, 0)		NULL, 
                           "TY"	VARCHAR(255)		NULL, 
                           "APLY_DT"	TIMESTAMP		NULL, 
                           "APLCN_DT"	TIMESTAMP		NULL, 
                           "EMP_ID"	NUMBER(38, 0)		NULL, 
                           "EMP_NM"	VARCHAR(255)		NULL, 
                           "EMP_DEPT"	VARCHAR(255)		NULL, 
                           "EMP_JBPS"	VARCHAR(255)		NULL, 
                           "EMP_JBTTL"	VARCHAR(255)		NULL, 
                           "RMRK"	VARCHAR(4000)		NULL, 
                           "RVW_STTS"	VARCHAR(255)		NULL, 
                           "RVW_RSN"	VARCHAR(255)		NULL, 
                           "CREATED_AT"	TIMESTAMP		NULL, 
                           "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."ENDORSE"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."ENDORSE"."CTRT_ID" IS '*CONTRACT ID / 계약 ID'; 
 
COMMENT ON COLUMN FINTECH."ENDORSE"."NO" IS '*NUMBER / 배서 번호'; 
 
COMMENT ON COLUMN FINTECH."ENDORSE"."TY" IS '*TYPE / 배서 타입 / 취소, 축소, 확대, ..,'; 
 
COMMENT ON COLUMN FINTECH."ENDORSE"."APLY_DT" IS '*APPLY DATE / 배서 신청 일자'; 
 
COMMENT ON COLUMN FINTECH."ENDORSE"."APLCN_DT" IS '*APPLICATION DATE / 배서 적용 일자'; 
 
COMMENT ON COLUMN FINTECH."ENDORSE"."EMP_ID" IS '*EMPLOYEE ID / 담당 직원 ID'; 
 
COMMENT ON COLUMN FINTECH."ENDORSE"."EMP_NM" IS '*EMPLOYEE  NAME / 담당 직원 이름'; 
 
COMMENT ON COLUMN FINTECH."ENDORSE"."EMP_DEPT" IS '*EMPLOYEE DEPARTMENT / 담당 직원 부서'; 
 
COMMENT ON COLUMN FINTECH."ENDORSE"."EMP_JBPS" IS '*EMPLOYEE JOB POSITION / 담당 직원 직책'; 
 
COMMENT ON COLUMN FINTECH."ENDORSE"."EMP_JBTTL" IS '*EMPLOYEE JOB TITLE / 담당 직원 직책'; 
 
COMMENT ON COLUMN FINTECH."ENDORSE"."RMRK" IS '*REMARKS / 비고 / 추가 설명을 위한 JSON'; 
 
COMMENT ON COLUMN FINTECH."ENDORSE"."RVW_STTS" IS '*REVIEW STATUS / 심사 상태 / 심사요청, 심사중. 승인, 반려,...'; 
 
COMMENT ON COLUMN FINTECH."ENDORSE"."RVW_RSN" IS '*REVIEW REASON / 심사 사유'; 
 
 

-----------------------------------------CREATE ENDORSE_CHANGE-----------------------------------------
CREATE TABLE FINTECH."ENDORSE_CHANGE" ( 
                                  "ID"	NUMBER(38, 0)		NOT NULL, 
                                  "ENDRS_ID"	NUMBER(38, 0)		NOT NULL, 
                                  "TBL_NM"	VARCHAR(255)		NULL, 
                                  "COL_NM"	VARCHAR(255)		NULL, 
                                  "BFR_VL"	VARCHAR(255)		NULL, 
                                  "AFTR_VL"	VARCHAR(255)		NULL, 
                                  "CREATED_AT"	DATE		NULL, 
                                  "UPDATED_AT"	DATE		NULL 
); 
 
COMMENT ON COLUMN FINTECH."ENDORSE_CHANGE"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."ENDORSE_CHANGE"."ENDRS_ID" IS '*ENDORSE ID / 배서 ID'; 
 
COMMENT ON COLUMN FINTECH."ENDORSE_CHANGE"."TBL_NM" IS '*TABLE NAME / 변경 테이블 명'; 
 
COMMENT ON COLUMN FINTECH."ENDORSE_CHANGE"."COL_NM" IS '*COLUMN NAME / 변경 컬럼 명'; 
 
COMMENT ON COLUMN FINTECH."ENDORSE_CHANGE"."BFR_VL" IS '*BEFORE VALUE / 배서 전 값'; 
 
COMMENT ON COLUMN FINTECH."ENDORSE_CHANGE"."AFTR_VL" IS '*AFTER VALUE / 배서 후 값'; 
 
 

-----------------------------------------CREATE INSURANCE_HISTORY-----------------------------------------
CREATE TABLE FINTECH."INSURANCE_HISTORY" ( 
                                     "ID"	NUMBER(38, 0)		NOT NULL, 
                                     "CTRT_ID"	NUMBER(38, 0)		NOT NULL, 
                                     "INSRNC_PD"	NUMBER(38, 0)		NULL, 
                                     "INSRNC_BGNG_YMD"	TIMESTAMP		NULL, 
                                     "INSRNC_END_YMD"	TIMESTAMP		NULL, 
                                     "GRD"	VARCHAR(255)		NULL, 
                                     "GRD_DOC_PATH"	VARCHAR(255)		NULL, 
                                     "GRD_DOC_ORGNL_NM"	VARCHAR(255)		NULL, 
                                     "GRD_DOC_EXTN"	VARCHAR(255)		NULL, 
                                     "GRD_DOC_ULD_DT"	TIMESTAMP		NULL, 
                                     "CREATED_AT"	TIMESTAMP		NULL, 
                                     "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."INSURANCE_HISTORY"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."INSURANCE_HISTORY"."CTRT_ID" IS '*CONTRACT ID / 계약 ID'; 
 
COMMENT ON COLUMN FINTECH."INSURANCE_HISTORY"."INSRNC_PD" IS '*INSURANCE PERIOD / 보험가입 기간 / MM'; 
 
COMMENT ON COLUMN FINTECH."INSURANCE_HISTORY"."INSRNC_BGNG_YMD" IS '*INSURANCE BEGINNING YEAR MONTH DAY / 이전 보험 시작 일자 / YYYYMMDD'; 
 
COMMENT ON COLUMN FINTECH."INSURANCE_HISTORY"."INSRNC_END_YMD" IS '*INSURANCE END YEAR MONTH DAY / 이전 보험 종료 일자 / YYYYMMDD'; 
 
COMMENT ON COLUMN FINTECH."INSURANCE_HISTORY"."GRD" IS '*GRADE / 이전 보험 할인할증 등급'; 
 
COMMENT ON COLUMN FINTECH."INSURANCE_HISTORY"."GRD_DOC_PATH" IS '*GRADE DOCUMENT / 적용등급확인서 저장 URL'; 
 
COMMENT ON COLUMN FINTECH."INSURANCE_HISTORY"."GRD_DOC_ORGNL_NM" IS '*GRADE DOCUMENT ORIGINAL NAME / 적용등급확인서 원본 이름'; 
 
COMMENT ON COLUMN FINTECH."INSURANCE_HISTORY"."GRD_DOC_EXTN" IS '*GRADE DOCUMENT EXTENSION / 적용등급확인서 파일 확장자'; 
 
COMMENT ON COLUMN FINTECH."INSURANCE_HISTORY"."GRD_DOC_ULD_DT" IS '*GRADE DOCUMENT UPLOAD DATE / 적용등급확인서 업로드 일시'; 
 
 

-----------------------------------------CREATE DAMAGE_EXAMINATION_HISTORY-----------------------------------------
CREATE TABLE FINTECH."DAMAGE_EXAMINATION_HISTORY" ( 
                                              "EXMN_CHG_CNT"	NUMBER(38, 0)		NOT NULL, 
                                              "ACDNT_EXMN_ID"	NUMBER(38, 0)		NOT NULL, 
                                              "ACDNT_RCPT_ID"	NUMBER(38, 0)		NOT NULL, 
                                              "POIPI_YN"	VARCHAR(1)		NULL, 
                                              "NO_PLICE_INVLVM_RESN"	VARCHAR(255)		NULL, 
                                              "ISSU_CNT"	NUMBER(38, 0)		NULL, 
                                              "ACDNT_TY1"	VARCHAR(255)		NULL, 
                                              "ACDBT_TY2"	VARCHAR(255)		NULL, 
                                              "SERIUS_FAULT"	VARCHAR(255)		NULL, 
                                              "VLTN_TYPE"	VARCHAR(255)		NULL, 
                                              "ACDNT_RESN"	VARCHAR(255)		NULL, 
                                              "ROAD_KND"	VARCHAR(255)		NULL, 
                                              "ROAD_TY"	VARCHAR(255)		NULL, 
                                              "WETHR_CND"	VARCHAR(255)		NULL, 
                                              "ROAD_CND"	VARCHAR(255)		NULL, 
                                              "APYD_CHART"	NUMBER(38, 0)		NULL, 
                                              "APYD_RSN"	VARCHAR(255)		NULL, 
                                              "FAULT_DTRMN_STTS"	VARCHAR(255)		NULL, 
                                              "SFOWND_VHCL_FLT_YN"	VARCHAR(1)		NULL, 
                                              "SFOWNED_VHCL_FLT_PT"	NUMBER(38, 0)		NULL, 
                                              "RVW_NM"	VARCHAR(255)		NULL, 
                                              "PRGRS_STAGE"	VARCHAR(255)		NULL, 
                                              "CLMANT"	VARCHAR(255)		NULL, 
                                              "DNT"	VARCHAR(255)		NULL, 
                                              "CLM_CO_RT"	NUMBER(38, 0)		NULL, 
                                              "DNT_CO_RT"	NUMBER(38, 0)		NULL, 
                                              "DCSN_DT"	TIMESTAMP		NULL, 
                                              "DDLN_DT"	TIMESTAMP		NULL, 
                                              "LWST_NO"	VARCHAR(255)		NULL, 
                                              "INDMNTY"	VARCHAR(255)		NULL, 
                                              "PIC_OPNN"	VARCHAR(255)		NULL, 
                                              "INPT_DT"	TIMESTAMP		NULL, 
                                              "FRST_INPT_DT"	TIMESTAMP		NULL, 
                                              "CTRT_CFMNT_DT"	TIMESTAMP		NULL, 
                                              "INPT_EMP_DEPT_NM"	VARCHAR(255)		NULL, 
                                              "INPT_EMP_CNTER"	VARCHAR(255)		NULL, 
                                              "INPT_EMP_PART"	VARCHAR(255)		NULL, 
                                              "INPT_EMP_NM"	VARCHAR(255)		NULL, 
                                              "CREATED_AT"	TIMESTAMP		NULL, 
                                              "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."EXMN_CHG_CNT" IS '* EXAMINATION CHANGE COUNTOUNT / 사고조사 변경회차'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."ACDNT_EXMN_ID" IS '* DAMAGE EXAMINATION ID / 사고조사 ID'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."ACDNT_RCPT_ID" IS '* ACCIDENT RECEIPT ID /사고접수 ID'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."POIPI_YN" IS '* PROOF OF INSURANCE POLICE INVOLVEMENT YES OR NO / 가입사실증명원 경찰 연계 대상 여부'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."NO_PLICE_INVLVM_RESN" IS '* NO POLICE INVOLVEMENT REASON / (가입사실증명원)미연계 사유'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."ISSU_CNT" IS '* ISSUE COUNT / 발급건수 / 가입사실증명원 발급건수 - 외부 API?'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."ACDNT_TY1" IS '* ACCIDENT TYPE1 / 사고유형1 / 추돌'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."ACDBT_TY2" IS '* ACCIDENT TYPE2 / 사고유형2 / 차대차, 차대인...'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."SERIUS_FAULT" IS '* SERIOUS FAULT / 중과실'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."VLTN_TYPE" IS '*VIOLATION TYPE / 위반유형'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."ACDNT_RESN" IS '* ACCIDENT REASON / 사고원인'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."ROAD_KND" IS '* ROAD KIND / 도로종류'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."ROAD_TY" IS '* ROAD TYPE / 도로형태'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."WETHR_CND" IS '* WEATHER CONDITION / 기상상태'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."ROAD_CND" IS '* ROAD CONDITION / 노면상태'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."APYD_CHART" IS '* APPLIED FAULT DETERMINATION RULE NUMBER / 적용도표'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."APYD_RSN" IS '* APPLIED FAULT DETERMINATION RULE REASON / 적용사유'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."FAULT_DTRMN_STTS" IS '* FAULT DETERMINATION STATUS / 과실확정여부(상태)'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."SFOWND_VHCL_FLT_YN" IS '* SELF OWNED VEHICLE FAULT YES OR NO / 자차과실여부'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."SFOWNED_VHCL_FLT_PT" IS '* SELF OWNED VEHICLE FAULT PERCENTAGE / 자차과실율'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."RVW_NM" IS '* REVIEW NUMBER / 구분 심의 번호'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."PRGRS_STAGE" IS '* PROGRESS STAGE / 진행단계'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."CLMANT" IS '* CLAIMANT / 청구인'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."DNT" IS '* DEFENDANT / 피청구인'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."CLM_CO_RT" IS '* CLAIM COST RATIO / 청구값'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."DNT_CO_RT" IS '* DEFENDANT COST RATIO / 피청구값'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."DCSN_DT" IS '* DECISION DATE / 결정일'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."DDLN_DT" IS '* DEADLINE DATE / 마감일'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."LWST_NO" IS '* LAWSUIT NUMBER / 소송번호'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."INDMNTY" IS '* INDEMNITY / 구상'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."PIC_OPNN" IS '* PERSON IN CHARGE OPINION / 담당자 의견'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."INPT_DT" IS '*INPUT DATETIME / 입력 일시'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."FRST_INPT_DT" IS '*FIRST INPUT DATETIME / 최초 입력 일시'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."CTRT_CFMNT_DT" IS '* CONTRACT CONFIRMATION DATETIME / 계약 확정 일시'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."INPT_EMP_DEPT_NM" IS '* INPUT EMPLOYEE DEPARTMENT NAME / 입력자 부서'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."INPT_EMP_CNTER" IS '* INPUT EMPLOYEE CENTER / 입력자 센터'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."INPT_EMP_PART" IS '* INPUT EMPLOYEE PART / 입력자 파트'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."INPT_EMP_NM" IS '* INPUT EMPLOYEE NAME / 입력자 명'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."CREATED_AT" IS '* CREATED_AT / 생성시간'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION_HISTORY"."UPDATED_AT" IS '* UPDATED_AT / 수정시간'; 
 
 

-----------------------------------------CREATE ACCIDENT_RECEIPT_SCREEN_HISTORY-----------------------------------------
CREATE TABLE FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY" ( 
                                                   "CHG_CNT"	NUMBER(38, 0)		NOT NULL, 
                                                   "SCRN"	VARCHAR(255)		NOT NULL, 
                                                   "ACDNT_RCPT_ID"	NUMBER(38, 0)		NOT NULL, 
                                                   "CTRT_ID"	NUMBER(38, 0)		NOT NULL, 
                                                   "CUST_ID"	NUMBER(38, 0)		NULL, 
                                                   "ACDNT_NO"	NUMBER(10, 0)		NOT NULL, 
                                                   "ACDNT_DT"	TIMESTAMP		NULL, 
                                                   "PSN_ACDNT_EXMNR_DEPT_NM"	VARCHAR(255)		NULL, 
                                                   "PSN_ACDNT_EXMNR_CNTER"	VARCHAR(255)		NULL, 
                                                   "PSN_ACDNT_EXMNR_PART"	VARCHAR(255)		NULL, 
                                                   "PSN_ACDNT_EXMNR_NM"	VARCHAR(255)		NULL, 
                                                   "PSN_ACDNT_EXMNR_TEL"	VARCHAR(255)		NULL, 
                                                   "PRPTY_ACDNT_EXMNR_DEPT"	VARCHAR(255)		NULL, 
                                                   "PRPTY_ACDNT_EXMNR_CNTER"	VARCHAR(255)		NULL, 
                                                   "PRPTY_ACDNT_EXMNR_PART"	VARCHAR(255)		NULL, 
                                                   "PRPTY_ACDNT_EXMNR_NM"	VARCHAR(255)		NULL, 
                                                   "PRPTY_ACDNT_EXMNR_TEL"	VARCHAR(255)		NULL, 
                                                   "FRST_RCPT_EMP_DEPT_NM"	VARCHAR(255)		NULL, 
                                                   "FRST_RCPT_EMP_CNTER"	VARCHAR(255)		NULL, 
                                                   "FRST_RCPT_EMP_PART"	VARCHAR(255)		NULL, 
                                                   "FRST_RCPT_EMP_NM"	VARCHAR(255)		NULL, 
                                                   "FRST_RCPT_YMD"	TIMESTAMP		NULL, 
                                                   "INPT_EMP_DEPT_NM"	VARCHAR(255)		NULL, 
                                                   "INPT_EMP_CNTER"	VARCHAR(255)		NULL, 
                                                   "INPT_EMP_PART"	VARCHAR(255)		NULL, 
                                                   "INPT_EMP_NM"	VARCHAR(255)		NULL, 
                                                   "INPT_DT"	TIMESTAMP		NULL, 
                                                   "ACDNT_ADDR"	VARCHAR(255)		NOT NULL, 
                                                   "ACDNT_ADDR_DTL"	VARCHAR(255)		NOT NULL, 
                                                   "PLICE_RPT_YN"	VARCHAR(1)		NULL, 
                                                   "PLICE_STN_NM"	VARCHAR(255)		NULL, 
                                                   "ACDNT_CN"	VARCHAR(255)		NULL, 
                                                   "ACDNT_CNPT"	VARCHAR(255)		NOT NULL, 
                                                   "CNPT_ICNY"	VARCHAR(255)		NULL, 
                                                   "PRF_INSRNC_YN"	VARCHAR(1)		NULL, 
                                                   "FLD_DSP_REQ_YN"	VARCHAR(1)		NOT NULL, 
                                                   "SPC_NT"	VARCHAR(255)		NULL, 
                                                   "SER_FLT_EXPECT"	VARCHAR(255)		NULL, 
                                                   "NTFR_RELS"	VARCHAR(255)		NOT NULL, 
                                                   "NTFR_NM"	VARCHAR(255)		NOT NULL, 
                                                   "NTFR_TEL"	VARCHAR(255)		NOT NULL, 
                                                   "DRVER_RELS"	VARCHAR(255)		NOT NULL, 
                                                   "DRVER_NM"	VARCHAR(255)		NOT NULL, 
                                                   "DRVER_TEL"	VARCHAR(255)		NULL, 
                                                   "DRVER_RRNO"	VARCHAR(255)		NULL, 
                                                   "DLN"	VARCHAR(255)		NULL, 
                                                   "DLN_EXPRY_DT"	TIMESTAMP		NULL, 
                                                   "ACDNT_PLC_LAT"	NUMBER(10, 6)		NULL, 
                                                   "ACDNT_PLC_LOT"	NUMBER(10, 6)		NULL, 
                                                   "PRVC_AGRE_YN"	VARCHAR(1)		NULL, 
                                                   "ACDNT_STTS"	VARCHAR(255)		NULL, 
                                                   "RCPT_CHN"	VARCHAR(255)		NULL, 
                                                   "VLD_CHK_EXCPT_YN"	VARCHAR(1)		NULL, 
                                                   "CREATED_AT"	TIMESTAMP		NULL, 
                                                   "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."CHG_CNT" IS '* CHANGE COUNT / 화면별 변경회차'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."SCRN" IS '* SCREEN / 화면'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."ACDNT_RCPT_ID" IS '* ACCIDENT RECEIPT ID / 사고접수 ID'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."CTRT_ID" IS '* CONTRACT ID / 계약 ID'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."CUST_ID" IS '* CUSTOMER ID / 고객 ID'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."ACDNT_NO" IS '* ACCIDENT NUMBER / 사고번호'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."ACDNT_DT" IS '* ACCIDENT DATETIME  / 사고일시'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."PSN_ACDNT_EXMNR_DEPT_NM" IS '* PERSON ACCIDENT EXAMINER DEPARTMENT NAME / 사고 인조사자 부서'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."PSN_ACDNT_EXMNR_CNTER" IS '* PERSON ACCIDENT EXAMINER CENTER / 사고 인조사자 센터'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."PSN_ACDNT_EXMNR_PART" IS '* PERSON ACCIDENT EXAMINER PART / 사고 인조사자 파트'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."PSN_ACDNT_EXMNR_NM" IS '* PERSON ACCIDENT EXAMINER NAME / 사고 인조사자명'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."PSN_ACDNT_EXMNR_TEL" IS '* PERSON ACCIDENT EXAMINER TEL / 사고 인조사자 전화번호'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."PRPTY_ACDNT_EXMNR_DEPT" IS '* PROPERTY ACCIDENT EXAMINER DEPARTMENT / 사고 물조사자 부서'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."PRPTY_ACDNT_EXMNR_CNTER" IS '* PROPERTY ACCIDENT EXAMINER CENTER / 사고 물조사자 센터'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."PRPTY_ACDNT_EXMNR_PART" IS '* PROPERTY ACCIDENT EXAMINER PART / 사고 물조사자 파트'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."PRPTY_ACDNT_EXMNR_NM" IS '* PROPERTY ACCIDENT EXAMINER NAME / 사고 물조사자명'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."PRPTY_ACDNT_EXMNR_TEL" IS '* PROPERTY ACCIDENT EXAMINER TEL / 사고 물조사자 전화번호'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."FRST_RCPT_EMP_DEPT_NM" IS '* FIRST RECEIPT EMPLOYER DEPARTMENT NAME / 최초 접수 직원 부서'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."FRST_RCPT_EMP_CNTER" IS '* FIRST RECEIPT EMPLOYER CENTER / 최초 접수 직원 센터'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."FRST_RCPT_EMP_PART" IS '* FIRST RECEIPT EMPLOYER PART / 최초 접수 직원 파트'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."FRST_RCPT_EMP_NM" IS '* FIRST RECEIPT EMPLOYER NAME / 최초 접수 직원명'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."FRST_RCPT_YMD" IS '* FIRST RECEIPT YMD / 최초 접수 일시'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."INPT_EMP_DEPT_NM" IS '* INPUT EMPLOYEE DEPARTMENT NAME / 입력자 부서'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."INPT_EMP_CNTER" IS '* INPUT EMPLOYEE CENTER / 입력자 센터'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."INPT_EMP_PART" IS '* INPUT EMPLOYEE PART / 입력자 파트'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."INPT_EMP_NM" IS '* INPUT EMPLOYEE NAME / 입력자 명'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."INPT_DT" IS '* INPUT DATETIME / 입력일시'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."ACDNT_ADDR" IS '* ACCIDENT ADDRESS / 사고주소'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."ACDNT_ADDR_DTL" IS '* ACCIDENT ADDRESS DETAIL / 사고 세부주소'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."PLICE_RPT_YN" IS '* POLICE REPORT YES OR NO / 경찰신고여부 /  Y, N'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."PLICE_STN_NM" IS '* POLICE STATION NAME / 경찰서명'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."ACDNT_CN" IS '* ACCIDENT CONTENT / 사고내용'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."ACDNT_CNPT" IS '* ACCIDENT COUNTER PARTY  / 사고 상대방'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."CNPT_ICNY" IS '* COUNTER PARTY INSURANCE COMPANY / 상대 보험사'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."PRF_INSRNC_YN" IS '* PROOF OF INSURANCE YES OR NO / 가입사실증명원 발급 여부 /  Y, N'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."FLD_DSP_REQ_YN" IS '* FIELD DISPATCH REQUEST YES OR NO / 현장 출동 요청 여부 /  Y, N'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."SPC_NT" IS '* SPECIAL NOTE / 특이사항'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."SER_FLT_EXPECT" IS '* SERIOUS FAULT EXPECTATION / 중과실 예상'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."NTFR_RELS" IS '* NOTIFIER RELATIONSHIP / 통보자 관계'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."NTFR_NM" IS '* NOTIFIER NAME / 통보자명'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."NTFR_TEL" IS '* NOTIFIER TEL / 통보자 휴대폰번호'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."DRVER_RELS" IS '* DRIVER RELATIONSHIP / 운전자 관계'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."DRVER_NM" IS '* DRIVER NAME / 운전자명'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."DRVER_TEL" IS '* DRIVER TEL / 운전자 휴대폰 번호'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."DRVER_RRNO" IS '* DRIVER RESIDENT REGISTRATION NUMBER / 운전자 주민번호'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."DLN" IS '* DRIVER LICENSE NUMBER / 운전자 면허 번호'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."DLN_EXPRY_DT" IS '* DRIVER LICENSE EXPIRATION DATE / 운전자 면허유효일'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."ACDNT_PLC_LAT" IS '* ACCIDENT PLACE LATITUDE / 사고장소 위도'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."ACDNT_PLC_LOT" IS '* ACCIDENT PLACE LOGITUDE / 사고장소 경도'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."PRVC_AGRE_YN" IS '* PRIVACY AGREEMENT YES OR NO / 개인정보동의 여부 /  Y, N'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."ACDNT_STTS" IS '* ACCIDENT STATUS / 사고상태'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."RCPT_CHN" IS '* RECEIPT CHANNEL / 접수채널'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."VLD_CHK_EXCPT_YN" IS '* VALIDITY CHECK EXCEPTION  YES OR NO / 유효성 체크 제외 여부 /  Y, N'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."CREATED_AT" IS '* CREATED_AT / 생성시간'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY"."UPDATED_AT" IS '* UPDATED_AT / 수정시간'; 
 
 

-----------------------------------------CREATE DAMAGE_EXAMINATION-----------------------------------------
CREATE TABLE FINTECH."DAMAGE_EXAMINATION" ( 
                                      "ID"	NUMBER(38, 0)		NOT NULL, 
                                      "ACDNT_RCPT_ID"	NUMBER(38, 0)		NOT NULL, 
                                      "INPT_EMP_ID"	NUMBER(38, 0)		NULL, 
                                      "EXMN_CHG_CNT"	NUMBER(38, 0)		NULL, 
                                      "POIPI_YN"	VARCHAR(1)		NULL, 
                                      "NO_PLICE_INVLVM_RESN"	VARCHAR(255)		NULL, 
                                      "ISSU_CNT"	NUMBER(38, 0)		NULL, 
                                      "ACDNT_TY1"	VARCHAR(255)		NULL, 
                                      "ACDNT_TY2"	VARCHAR(255)		NULL, 
                                      "SERIUS_FAULT"	VARCHAR(255)		NULL, 
                                      "VLTN_TYPE"	VARCHAR(255)		NULL, 
                                      "ACDNT_RESN"	VARCHAR(255)		NULL, 
                                      "ROAD_KND"	VARCHAR(255)		NULL, 
                                      "ROAD_TY"	VARCHAR(255)		NULL, 
                                      "WETHR_CND"	VARCHAR(255)		NULL, 
                                      "ROAD_CND"	VARCHAR(255)		NULL, 
                                      "APYD_CHART"	NUMBER(38, 0)		NULL, 
                                      "APYD_RSN"	VARCHAR(255)		NULL, 
                                      "FAULT_DTRMN_STTS"	VARCHAR(255)		NULL, 
                                      "SFOWND_VHCL_FLT_YN"	VARCHAR(1)		NULL, 
                                      "SFOWNED_VHCL_FLT_PT"	NUMBER(38, 0)		NULL, 
                                      "RVW_NM"	VARCHAR(255)		NULL, 
                                      "PRGRS_STAGE"	VARCHAR(255)		NULL, 
                                      "CLMANT"	VARCHAR(255)		NULL, 
                                      "DNT"	VARCHAR(255)		NULL, 
                                      "CLM_CO_RT"	NUMBER(38, 0)		NULL, 
                                      "DNT_CO_RT"	NUMBER(38, 0)		NULL, 
                                      "DCSN_DT"	TIMESTAMP		NULL, 
                                      "DDLN_DT"	TIMESTAMP		NULL, 
                                      "LWST_NO"	VARCHAR(255)		NULL, 
                                      "INDMNTY"	VARCHAR(255)		NULL, 
                                      "PIC_OPNN"	VARCHAR(255)		NULL, 
                                      "INPT_DT"	TIMESTAMP		NULL, 
                                      "FRST_INPT_DT"	TIMESTAMP		NULL, 
                                      "CTRT_CFMTN_DT"	TIMESTAMP		NULL, 
                                      "CREATED_AT"	TIMESTAMP		NULL, 
                                      "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."ACDNT_RCPT_ID" IS 'UNIQUE * ACCIDENT RECEIPT ID / 사고접수 ID'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."INPT_EMP_ID" IS '* INPUT EMPLOYEE ID / 입력 직원 ID'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."EXMN_CHG_CNT" IS '* EXAMINATION CHANGE COUNT / 조사 변경회차'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."POIPI_YN" IS '* PROOF OF INSURANCE POLICE INVOLVEMENT YES OR NO / 가입사실증명원 경찰 연계 대상 여부'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."NO_PLICE_INVLVM_RESN" IS '* NO POLICE INVOLVEMENT REASON / (가입사실증명원)미연계 사유'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."ISSU_CNT" IS '* ISSUE COUNT / 가입사실증명원 발급건수 - 외부 API?'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."ACDNT_TY1" IS '* ACCIDENT TYPE1 / 사고유형1 / 추돌'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."ACDNT_TY2" IS '* ACCIDENT TYPE2 / 사고유형2 / 차대차, 차대인...'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."SERIUS_FAULT" IS '* SERIOUS FAULT / 중과실'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."VLTN_TYPE" IS '*VIOLATION TYPE / 위반유형'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."ACDNT_RESN" IS '* ACCIDENT REASON / 사고원인'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."ROAD_KND" IS '* ROAD KIND / 도로종류'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."ROAD_TY" IS '* ROAD TYPE / 도로형태'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."WETHR_CND" IS '* WEATHER CONDITION / 기상상태'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."ROAD_CND" IS '* ROAD CONDITION / 노면상태'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."APYD_CHART" IS '* APPLIED CHART / 적용도표'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."APYD_RSN" IS '* APPLIED REASON / 적용사유'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."FAULT_DTRMN_STTS" IS '* FAULT DETERMINATION STATUS / 과실확정여부(상태)'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."SFOWND_VHCL_FLT_YN" IS '* SELF OWNED VEHICLE FAULT YES OR NO / 자차과실여부'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."SFOWNED_VHCL_FLT_PT" IS '* SELF OWNED VEHICLE FAULT PERCENTAGE / 자차과실율'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."RVW_NM" IS '* REVIEW NUMBER / 구분 심의 번호'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."PRGRS_STAGE" IS '* PROGRESS STAGE / 진행단계'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."CLMANT" IS '* CLAIMANT / 청구인'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."DNT" IS '* DEFENDANT / 피청구인'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."CLM_CO_RT" IS '* CLAIM COST RATIO / 청구값'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."DNT_CO_RT" IS '* DEFENDANT COST RATIO / 피청구값'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."DCSN_DT" IS '* DECISION DATE / 결정일'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."DDLN_DT" IS '* DEADLINE DATE / 마감일'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."LWST_NO" IS '* LAWSUIT NUMBER / 소송번호'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."INDMNTY" IS '* INDEMNITY / 구상'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."PIC_OPNN" IS '* PERSON IN CHARGE OPINION / 담당자 의견'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."INPT_DT" IS '*INPUT DATETIME / 입력 일시'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."FRST_INPT_DT" IS '*FIRST INPUT DATETIME / 최초 입력 일시'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."CTRT_CFMTN_DT" IS '* CONTRACT CONFIRMATION DATETIME / 계약 확정 일시'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."CREATED_AT" IS '* CREATED_AT / 생성시간'; 
 
COMMENT ON COLUMN FINTECH."DAMAGE_EXAMINATION"."UPDATED_AT" IS '* UPDATED_AT / 수정시간'; 
 
 

-----------------------------------------CREATE ACCIDENT_RECEIPT-----------------------------------------
CREATE TABLE FINTECH."ACCIDENT_RECEIPT" ( 
                                    "ID"	NUMBER(38, 0)		NOT NULL, 
                                    "CHG_CNT"	NUMBER(38, 0)		NULL, 
                                    "CTRT_ID"	NUMBER(38, 0)		NOT NULL, 
                                    "CUST_ID"	NUMBER(38, 0)		NULL, 
                                    "ACDNT_NO"	NUMBER(10, 0)		NULL, 
                                    "ACDNT_DT"	TIMESTAMP		NULL, 
                                    "PSN_ACDNT_EXMNR_ID"	NUMBER(38, 0)		NULL, 
                                    "PRPTY_ACDNT_EXMNR_ID"	NUMBER(38, 0)		NULL, 
                                    "FRST_RCPT_EMP_ID"	NUMBER(38, 0)		NULL, 
                                    "FRST_RCPT_YMD"	TIMESTAMP		NULL, 
                                    "INPT_EMP_ID"	NUMBER(38, 0)		NULL, 
                                    "INPT_DT"	TIMESTAMP		NULL, 
                                    "ACDNT_ADDR"	VARCHAR(255)		NOT NULL, 
                                    "ACDNT_ADDR_DTL"	VARCHAR(255)		NOT NULL, 
                                    "PLICE_RPT_YN"	VARCHAR(1)	DEFAULT 'N'	NULL, 
                                    "PLICE_STN_NM"	VARCHAR(255)		NULL, 
                                    "ACDNT_CN"	VARCHAR(255)		NULL, 
                                    "ACDNT_CNPT"	VARCHAR(255)		NOT NULL, 
                                    "CNPT_ICNY"	VARCHAR(255)		NULL, 
                                    "PRF_INSRNC_YN"	VARCHAR(1)	DEFAULT 'N'	NULL, 
                                    "FLD_DSP_REQ_YN"	VARCHAR(1)	DEFAULT 'N'	NOT NULL, 
                                    "SPC_NT"	VARCHAR(255)		NULL, 
                                    "SERIUS_FLT_EXPT"	VARCHAR(255)		NULL, 
                                    "NOTF_RELS"	VARCHAR(255)		NOT NULL, 
                                    "NOTF_NM"	VARCHAR(255)		NOT NULL, 
                                    "NOTF_TEL"	VARCHAR(255)		NOT NULL, 
                                    "DRVER_RELS"	VARCHAR(255)		NOT NULL, 
                                    "DRVER_NM"	VARCHAR(255)		NOT NULL, 
                                    "DRVER_TEL"	VARCHAR(255)		NULL, 
                                    "DRVER_RRNO"	VARCHAR(255)		NULL, 
                                    "DLN"	VARCHAR(255)		NULL, 
                                    "DLN_EXPRY_DT"	TIMESTAMP		NULL, 
                                    "ACDNT_PLC_LAT"	NUMBER(10, 6)		NULL, 
                                    "ACDNT_PLC_LOT"	NUMBER(10, 6)		NULL, 
                                    "PRVC_AGRE_YN"	VARCHAR(1)	DEFAULT 'N'	NULL, 
                                    "ACDNT_STTS"	VARCHAR(255)		NULL, 
                                    "RCPT_CHN"	VARCHAR(255)		NULL, 
                                    "VLD_CHK_EXCPT_YN"	VARCHAR(1)	DEFAULT 'N'	NULL, 
                                    "CREATED_AT"	TIMESTAMP		NULL, 
                                    "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."CHG_CNT" IS '* CHANGE COUNT / 변경회차'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."CTRT_ID" IS '* CONTRACT ID / 계약 ID'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."CUST_ID" IS '* CUSTOMER ID / 성명, 코드, 휴대폰, 소속조합'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."ACDNT_NO" IS 'UNIQUE * ACCIDENT NUMBER / 사고번호'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."ACDNT_DT" IS '* ACCIDENT DATETIME / 사고일시'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."PSN_ACDNT_EXMNR_ID" IS '* PERSON ACCIDENT EXAMINER ID / 사고 인조사자 ID'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."PRPTY_ACDNT_EXMNR_ID" IS '* PROPERTY ACCIDENT EXAMINER ID / 사고 물조사자 ID'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."FRST_RCPT_EMP_ID" IS '* FIRST RECEIPT EMPLOYER ID / 최초 접수 직원 ID'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."FRST_RCPT_YMD" IS '* FIRST RECEIPT YMD  / 최초 접수 일시'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."INPT_EMP_ID" IS '* INPUT EMPOLYEEE ID / 입력직원 ID'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."INPT_DT" IS '* INPUT DATETIME / 입력일시'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."ACDNT_ADDR" IS '* ACCIDENT ADDRESS / 사고장소'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."ACDNT_ADDR_DTL" IS '* ACCIDENT ADDRESS DETAIL / 사고 세부주소'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."PLICE_RPT_YN" IS '* POLICE REPORT YES OR NO / 경찰신고여부 /  Y, N(DEFAULT)'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."PLICE_STN_NM" IS '* POLICE STATION NAME / 경찰서명'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."ACDNT_CN" IS '* ACCIDENT CONTENT / 사고내용'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."ACDNT_CNPT" IS '* ACCIDENT COUNTER PARTY / 사고 상대방 / 사고를 당한 상대자'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."CNPT_ICNY" IS '* COUNTER PARTY INSURANCE COMPANY / 존재 문의 - 피해서열 1번 보험사 예정'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."PRF_INSRNC_YN" IS '* PROOF OF INSURANCE YES OR NO / 가입사실증명원 발급 여부 /  Y, N(DEFAULT)'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."FLD_DSP_REQ_YN" IS '* FIELD DISPATCH REQUEST YES OR NO / 현장 출동 요청 여부 /  Y, N(DEFAULT)'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."SPC_NT" IS '* SPECIAL NOTE / 특이사항'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."SERIUS_FLT_EXPT" IS '* SERIOUS FAULT EXPECTATION / 중과실 예상'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."NOTF_RELS" IS '* NOTIFIER RELATIONSHIP / 통보자 관계'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."NOTF_NM" IS '* NOTIFIER NAME / 통보자명'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."NOTF_TEL" IS '* NOTIFIER TEL / 통보자 휴대폰번호'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."DRVER_RELS" IS '* DRIVER RELATIONSHIP / 운전자 관계'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."DRVER_NM" IS '* DRIVER NAME / 운전자명'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."DRVER_TEL" IS '* DRIVER TEL / 운전자 휴대폰 번호'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."DRVER_RRNO" IS '* DRIVER RESIDENT REGISTRATION NUMBER / 운전자 주민번호'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."DLN" IS '* DRIVER LICENSE NUMBER / 운전자 면허번호'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."DLN_EXPRY_DT" IS '* DRIVER LICENSE EXPIRATION DATE / 운전자 면허유효일'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."ACDNT_PLC_LAT" IS '* ACCIDENT PLACE LATITUDE / 사고장소 위도'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."ACDNT_PLC_LOT" IS '* ACCIDENT PLACE LONGITUDE / 사고장소 경도'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."PRVC_AGRE_YN" IS '* PRIVACY AGREEMENT YES OR NO / 개인정보동의 여부 /  Y, N(DEFAULT)'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."ACDNT_STTS" IS '* ACCIDENT STATUS / 사고상태'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."RCPT_CHN" IS '* RECEIPT CHANNEL / 접수채널'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."VLD_CHK_EXCPT_YN" IS '* VALIDITY CHECK EXCEPTION  YES OR NO / 유효성 체크 제외 여부 /  Y, N(DEFAULT)'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."CREATED_AT" IS '* CREATED_AT / 생성시간'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_RECEIPT"."UPDATED_AT" IS '* UPDATED_AT / 수정시간'; 
 
 

-----------------------------------------CREATE OTS_DISPATCH_REPORT-----------------------------------------
CREATE TABLE FINTECH."OTS_DISPATCH_REPORT" ( 
                                       "ID"	NUMBER(38, 0)		NOT NULL, 
                                       "ACDNT_RCPT_ID"	NUMBER(38, 0)		NOT NULL, 
                                       "CREATED_AT"	TIMESTAMP		NULL, 
                                       "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."OTS_DISPATCH_REPORT"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."OTS_DISPATCH_REPORT"."ACDNT_RCPT_ID" IS '* ACCIDENT RECEIPT ID / 사고접수 ID'; 
 
COMMENT ON COLUMN FINTECH."OTS_DISPATCH_REPORT"."CREATED_AT" IS '* CREATED_AT / 생성시간'; 
 
COMMENT ON COLUMN FINTECH."OTS_DISPATCH_REPORT"."UPDATED_AT" IS '* UPDATED_AT / 수정시간'; 
 
 

-----------------------------------------CREATE BIG_ACCIDENT_DETAIL-----------------------------------------
CREATE TABLE FINTECH."BIG_ACCIDENT_DETAIL" ( 
                                       "ID"	NUMBER(38, 0)		NOT NULL, 
                                       "ACDNT_RCPT_ID"	NUMBER(38, 0)		NOT NULL, 
                                       "SC_TY"	VARCHAR(255)		NULL, 
                                       "DMGE_SEQ"	NUMBER(38, 0)		NULL, 
                                       "VICTIM_DMGE_PRPTY"	VARCHAR(255)		NULL, 
                                       "GENDER"	VARCHAR(1)		NULL, 
                                       "AGE"	NUMBER(38, 0)		NULL, 
                                       "DMGE_STTS"	VARCHAR(255)		NULL, 
                                       "HSPTL_RPR_FCTRY"	VARCHAR(255)		NULL, 
                                       "LOSS"	NUMBER(38, 0)		NULL, 
                                       "CREATED_AT"	TIMESTAMP		NULL, 
                                       "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL"."ACDNT_RCPT_ID" IS '* ACCIDENT RECEIPT ID / 사고접수 ID'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL"."SC_TY" IS '* SECURITY TYPE / 담보타입 / 대인, 대물 등등'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL"."DMGE_SEQ" IS '* DAMAGE SEQUENCE / 피해서열'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL"."VICTIM_DMGE_PRPTY" IS '* VICTIM/DAMAGED PROPERTY / 피해자/물'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL"."GENDER" IS '* GENDER / 성별 / M, F'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL"."AGE" IS '* AGE / 나이'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL"."DMGE_STTS" IS '* DAMAGE STATUS / 피해상태'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL"."HSPTL_RPR_FCTRY" IS '* HOSPITAL/REPAIR FACTORY / 병원/정비공장'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL"."LOSS" IS '* LOSS / 손해액'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL"."CREATED_AT" IS '* CREATED_AT / 생성시간'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL"."UPDATED_AT" IS '* UPDATED_AT / 수정시간'; 
 
 

-----------------------------------------CREATE BIG_ACCIDENT_INFO-----------------------------------------
CREATE TABLE FINTECH."BIG_ACCIDENT_INFO" ( 
                                     "ACDNT_RCPT_ID"	NUMBER(38, 0)		NOT NULL, 
                                     "CTRT_ID"	NUMBER(38, 0)		NOT NULL, 
                                     "INPT_EMP_ID"	NUMBER(38, 0)		NULL, 
                                     "BIG_ACDNT_CHG_CNT"	NUMBER(38, 0)		NOT NULL, 
                                     "MAIN_ACDNT_TY"	VARCHAR(255)		NOT NULL, 
                                     "MAIN_ACDNT_TY_DTL"	VARCHAR(255)		NULL, 
                                     "TOT_EXPECT_LOSS"	NUMBER(38, 0)		NULL, 
                                     "VICTIM_CNT"	NUMBER(38, 0)		NULL, 
                                     "PSN_EXPECT_LOSS"	NUMBER(38, 0)		NULL, 
                                     "DMGE_PRPTY_CNT"	NUMBER(38, 0)		NULL, 
                                     "PRPTY_EXPECT_LOSS"	NUMBER(38, 0)		NULL, 
                                     "NOTE"	VARCHAR(255)		NULL, 
                                     "FAULT_YN"	VARCHAR(1)		NULL, 
                                     "FAULT_RT"	NUMBER(38, 0)		NULL, 
                                     "INPT_TIMHDR_ID"	NUMBER(38,0)		NULL, 
                                     "TIMHDR_OPNN"	VARCHAR(255)		NULL, 
                                     "EMP_INPT_YMD"	TIMESTAMP		NULL, 
                                     "TIMHDR_INPT_YMD"	TIMESTAMP		NULL, 
                                     "CREATED_AT"	TIMESTAMP		NULL, 
                                     "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO"."ACDNT_RCPT_ID" IS '* ACCIDENT RECEIPT ID / 사고접수 ID'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO"."CTRT_ID" IS '* CONTRACT ID / 계약 ID'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO"."INPT_EMP_ID" IS '* INPUT EMPLOYEE / 입력직원 ID / 피해내용 입력자 정보'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO"."BIG_ACDNT_CHG_CNT" IS '* BIG ACCIDENT CHANGE COUNT / 대사고 변경회차'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO"."MAIN_ACDNT_TY" IS '* MAIN ACCIDENT TYPE / 주요사고유형'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO"."MAIN_ACDNT_TY_DTL" IS '* MAIN ACCIDENT TYPE DETAIL / 주요사고유형상세'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO"."TOT_EXPECT_LOSS" IS '* TOTAL EXPECTATION LOSS / 총예상손해액'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO"."VICTIM_CNT" IS '* VICTIM COUNT / 피해자건수'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO"."PSN_EXPECT_LOSS" IS '* PERSON EXPECTATION LOSS / 인예상손해액'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO"."DMGE_PRPTY_CNT" IS '* DAMAGED PROPERTY COUNT / 피해물건수'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO"."PRPTY_EXPECT_LOSS" IS '* PROPERTY EXPECTATION LOSS / 물예상손해액'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO"."NOTE" IS '* NOTE / 피해사항'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO"."FAULT_YN" IS '* FAULT YES OR NO / 과실유무'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO"."FAULT_RT" IS '* FAULT RATE / 과실율'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO"."INPT_TIMHDR_ID" IS '* INPUT TEAM HEADER / 입력팀장 ID'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO"."TIMHDR_OPNN" IS '* TEAM HEADER OPINION / 팀장의견란'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO"."EMP_INPT_YMD" IS '* EMPLOYEE INPUT YMD / 직원입력일시'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO"."TIMHDR_INPT_YMD" IS '* TEAM HEADER INPUT YMD / 팀장입력일시'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO"."CREATED_AT" IS '* CREATED_AT / 생성시간'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO"."UPDATED_AT" IS '* UPDATED_AT / 수정시간'; 
 
 

-----------------------------------------CREATE BIG_ACCIDENT_DETAIL_HISTORY-----------------------------------------
CREATE TABLE FINTECH."BIG_ACCIDENT_DETAIL_HISTORY" ( 
                                               "CHG_CNT"	NUMBER(38, 0)		NOT NULL, 
                                               "BIG_ACDNT_DMGE_CN_ID"	NUMBER(38, 0)		NOT NULL, 
                                               "ACDNT_RCPT_ID"	NUMBER(38, 0)		NOT NULL, 
                                               "SC_TY"	VARCHAR(255)		NULL, 
                                               "DMGE_SEQ"	NUMBER(38, 0)		NULL, 
                                               "DMGE_NM"	VARCHAR(255)		NULL, 
                                               "GENDER"	VARCHAR(1)		NULL, 
                                               "AGE"	NUMBER(38, 0)		NULL, 
                                               "DMGE_STTS"	VARCHAR(255)		NULL, 
                                               "HSPTL_RPR_FCTRY"	VARCHAR(255)		NULL, 
                                               "LOSS"	NUMBER(38, 0)		NULL, 
                                               "CREATED_AT"	TIMESTAMP		NULL, 
                                               "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL_HISTORY"."CHG_CNT" IS '* CHANGE_COUNT / 변경회차'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL_HISTORY"."BIG_ACDNT_DMGE_CN_ID" IS '* BIG ACCIDENT DETAIL ID / 대사고 피해내용 ID'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL_HISTORY"."ACDNT_RCPT_ID" IS '* ACCIDENT RECEIPT ID / 사고접수 ID'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL_HISTORY"."SC_TY" IS '*SECURITY TYPE / 담보타입 / 대인, 대물 등등'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL_HISTORY"."DMGE_SEQ" IS '*DEMAGE SEQUNCE / 피해서열'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL_HISTORY"."DMGE_NM" IS '*DEMAGED NAME / 피해자/물'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL_HISTORY"."GENDER" IS '*GENDER / 성별 / M, F'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL_HISTORY"."AGE" IS '*AGE / 나이'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL_HISTORY"."DMGE_STTS" IS '*DAMAGE STATUS / 피해상태'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL_HISTORY"."HSPTL_RPR_FCTRY" IS '*HOSPITAL/REPAIR FACTORY / 병원/정비공장'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL_HISTORY"."LOSS" IS '* LOSS / 손해액'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL_HISTORY"."CREATED_AT" IS '* CREATED_AT / 생성시간'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_DETAIL_HISTORY"."UPDATED_AT" IS '* UPDATED_AT / 수정시간'; 
 
 

-----------------------------------------CREATE BIG_ACCIDENT_INFO_HISTORY-----------------------------------------
CREATE TABLE FINTECH."BIG_ACCIDENT_INFO_HISTORY" ( 
                                             "CHG_CNT"	NUMBER(38, 0)		NOT NULL, 
                                             "ACDNT_RCPT_ID"	NUMBER(38, 0)		NOT NULL, 
                                             "CTRT_ID"	NUMBER(38, 0)		NOT NULL, 
                                             "INPT_EMP_ID"	NUMBER(38, 0)		NULL, 
                                             "BIG_ACDNT_CHG_CNT"	NUMBER(38, 0)		NOT NULL, 
                                             "MAIN_ACDNT_TY"	VARCHAR(255)		NOT NULL, 
                                             "MAIN_ACDNT_TY_DTL"	VARCHAR(255)		NULL, 
                                             "TOT_EXPECT_LOSS"	NUMBER(38, 0)		NULL, 
                                             "VICITIM_CNT"	NUMBER(38, 0)		NULL, 
                                             "PSN_EXPECT_LOSS"	NUMBER(38, 0)		NULL, 
                                             "DMGE_PRPTY_CNT"	NUMBER(38, 0)		NULL, 
                                             "PRPTY_EXPECT_LOSS"	NUMBER(38, 0)		NULL, 
                                             "NOTE"	VARCHAR(255)		NULL, 
                                             "FAULT_YN"	VARCHAR(1)		NULL, 
                                             "FAULT_RT"	NUMBER(38, 0)		NULL, 
                                             "INPT_TIMHDR_ID"	NUMBER(38,0)		NULL, 
                                             "TIMHDER_OPNN"	VARCHAR(255)		NULL, 
                                             "EMP_INPT_YMD"	TIMESTAMP		NULL, 
                                             "TIMHDR_INPT_YMD"	TIMESTAMP		NULL, 
                                             "CREATED_AT"	TIMESTAMP		NULL, 
                                             "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO_HISTORY"."CHG_CNT" IS '* CHANGE_COUNT'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO_HISTORY"."ACDNT_RCPT_ID" IS '* ACCIDENT RECEIPT ID / 사고접수 ID'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO_HISTORY"."CTRT_ID" IS '* CONTRACT ID 피공제자 정보'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO_HISTORY"."INPT_EMP_ID" IS '* INPUT EMPLOYEE ID 피해내용 입력자 정보'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO_HISTORY"."BIG_ACDNT_CHG_CNT" IS '*BIG ACCIDENT CHAGE COUNT ? 변경회차 2개인 이유?'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO_HISTORY"."MAIN_ACDNT_TY" IS 'MAIN ACCIDENT TYPE'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO_HISTORY"."MAIN_ACDNT_TY_DTL" IS 'MAIN ACCIDENT TYPE DETAIL'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO_HISTORY"."TOT_EXPECT_LOSS" IS 'TOTAL EXPECTATION LOSS'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO_HISTORY"."VICITIM_CNT" IS 'VICTIM COUNT'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO_HISTORY"."PSN_EXPECT_LOSS" IS 'PERSON EXPECTATION LOSS'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO_HISTORY"."DMGE_PRPTY_CNT" IS 'DAMAGED PROPERTY COUNT'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO_HISTORY"."PRPTY_EXPECT_LOSS" IS 'PROPERTY EXPECTATION LOSS'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO_HISTORY"."NOTE" IS '피해사항 입력'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO_HISTORY"."FAULT_YN" IS '*FAULT YES OR NO'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO_HISTORY"."FAULT_RT" IS '* FAULT RATE'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO_HISTORY"."INPT_TIMHDR_ID" IS '*INPUT TEAM HEADER'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO_HISTORY"."TIMHDER_OPNN" IS '* TEAM HEADER OPINION'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO_HISTORY"."EMP_INPT_YMD" IS '* EMPLOYEE INPUT YMD'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO_HISTORY"."TIMHDR_INPT_YMD" IS '* TEAM HEADER INPUT YMD'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO_HISTORY"."CREATED_AT" IS '* CREATED_AT / 생성시간'; 
 
COMMENT ON COLUMN FINTECH."BIG_ACCIDENT_INFO_HISTORY"."UPDATED_AT" IS '* UPDATED_AT / 수정시간'; 
 
 

-----------------------------------------CREATE PROOF_OF_INSURANCE_ISSUE-----------------------------------------
CREATE TABLE FINTECH."PROOF_OF_INSURANCE_ISSUE" ( 
                                            "ISSU_SEQ"	NUMBER(38, 0)		NOT NULL, 
                                            "ACDNT_RCPT_ID"	NUMBER(38, 0)		NOT NULL, 
                                            "EMP_ID"	NUMBER(38, 0)		NULL, 
                                            "ISSU_PATH"	VARCHAR(255)		NULL, 
                                            "ISSU_APLCNT_RELS"	VARCHAR(255)		NULL, 
                                            "ISSU_APLCNT_RRNO"	VARCHAR(255)		NULL, 
                                            "ISSU_APLCNT_TEL"	VARCHAR(255)		NULL, 
                                            "ISSU_APLCNT_NO"	VARCHAR(255)		NULL, 
                                            "ISSU_APLCNT_ADDR"	VARCHAR(255)		NULL, 
                                            "ISSU_APLCNT_ADDR_DTL"	VARCHAR(255)		NULL, 
                                            "VICTIM_NM"	VARCHAR(255)		NULL, 
                                            "VICTIM_CNT"	NUMBER(38, 0)		NULL, 
                                            "DMGE_PTY_NM"	VARCHAR(255)		NULL, 
                                            "DMGE_PTY_CNT"	NUMBER(38, 0)		NULL, 
                                            "REISSU_YN"	VARCHAR(1)	DEFAULT 'N'	NULL, 
                                            "REISSU_RESN"	VARCHAR(255)		NULL, 
                                            "INPT_EMP_DEPT_NM"	VARCHAR(255)		NULL, 
                                            "INPT_EMP_CNTER"	VARCHAR(255)		NULL, 
                                            "INPT_EMP_PART"	VARCHAR(255)		NULL, 
                                            "INPT_EMP_NM"	VARCHAR(255)		NULL, 
                                            "INPT_DT"	TIMESTAMP		NULL, 
                                            "CREATED_AT"	TIMESTAMP		NULL, 
                                            "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."ISSU_SEQ" IS '* ISSUE SEQUENCE / 발급서열'; 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."ACDNT_RCPT_ID" IS '* ACCIDENT RECEIPT ID / 사고접수 ID'; 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."EMP_ID" IS '* EMPLOYEE ID / 기간계 직원 ID'; 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."ISSU_PATH" IS '* ISSUE PATH / 발급경로'; 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."ISSU_APLCNT_RELS" IS '* ISSUE APPLICANT RELATIONSHIP / 발급신청자 관계'; 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."ISSU_APLCNT_RRNO" IS '* ISSUE APPLICANT RESIDENT REGISTRATION NUMBER / 발급신청자 주민등록번호'; 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."ISSU_APLCNT_TEL" IS '* ISSUE APPLICANT TEL / 발급신청자 연락처'; 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."ISSU_APLCNT_NO" IS '* ISSUE APPLICANT FX NUMBER / 발급신청자 FAZ 번호'; 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."ISSU_APLCNT_ADDR" IS '* ISSUE APPLICANT ADDRESS / 발급신청자 주소'; 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."ISSU_APLCNT_ADDR_DTL" IS '* ISSUE APPLICANT ADDRESS DETAIL / 발급신청자 세부주소'; 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."VICTIM_NM" IS '* VICTIM NAME / 피해자명'; 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."VICTIM_CNT" IS '* VICTIM COUNT / 피해자 건수'; 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."DMGE_PTY_NM" IS '* DAMAGED PROPERTY NAME / 피해물명'; 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."DMGE_PTY_CNT" IS '* DAMAGED PROPERTHY COUNT / 피해물 건수'; 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."REISSU_YN" IS '* REISSUE YES OR NO / 재발급 여부'; 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."REISSU_RESN" IS '* REISSUE REASON / 재발급 사유'; 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."INPT_EMP_DEPT_NM" IS '*INPUT EMPLOYEE DEPARTMENT NAME / 입력자 부서'; 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."INPT_EMP_CNTER" IS '*INPUT EMPLOYEE CENTER / 입력자 센터'; 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."INPT_EMP_PART" IS '*INPUT EMPLOYEE PART / 입력자 파트'; 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."INPT_EMP_NM" IS '*INPUT EMPLOYEE NAME / 입력자 명'; 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."INPT_DT" IS '* INPUT DATETIME / 입력일시'; 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."CREATED_AT" IS '* CREATED_AT / 생성시간'; 
 
COMMENT ON COLUMN FINTECH."PROOF_OF_INSURANCE_ISSUE"."UPDATED_AT" IS '* UPDATED_AT / 수정시간'; 
 
 

-----------------------------------------CREATE ACCIDENT_VISUAL_EVIDENCE-----------------------------------------
CREATE TABLE FINTECH."ACCIDENT_VISUAL_EVIDENCE" ( 
                                            "ID"	NUMBER(38,0)		NOT NULL, 
                                            "ACDNT_RCPT_ID"	NUMBER(38, 0)		NOT NULL, 
                                            "FILE_PATH"	VARCHAR(255)		NOT NULL, 
                                            "EV_TY"	VARCHAR(255)		NOT NULL, 
                                            "ULD_DT"	TIMESTAMP		NOT NULL, 
                                            "FILE_TY"	INTEGER		NOT NULL, 
                                            "CREATED_AT"	TIMESTAMP		NULL, 
                                            "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_VISUAL_EVIDENCE"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_VISUAL_EVIDENCE"."ACDNT_RCPT_ID" IS '* ACCIDENT RECEIPT ID'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_VISUAL_EVIDENCE"."FILE_PATH" IS '* FILE PATH'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_VISUAL_EVIDENCE"."EV_TY" IS '* EVIDENCE TYPE 후면, 사이드...'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_VISUAL_EVIDENCE"."ULD_DT" IS '* UPLOAD DATE TIME'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_VISUAL_EVIDENCE"."FILE_TY" IS '* FILE DATA TYPE 0: 이미지 1: 동영상'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_VISUAL_EVIDENCE"."CREATED_AT" IS '* CREATED_AT / 생성시간'; 
 
COMMENT ON COLUMN FINTECH."ACCIDENT_VISUAL_EVIDENCE"."UPDATED_AT" IS '* UPDATED_AT / 수정시간'; 
 
 

-----------------------------------------CREATE TOWARD_PERSONNEL-----------------------------------------
CREATE TABLE FINTECH."TOWARD_PERSONNEL" ( 
                                    "ID"	NUMBER(38, 0)		NOT NULL, 
                                    "ACDNT_RCPT_ID"	NUMBER(38, 0)		NOT NULL, 
                                    "PSN_PIC_ID"	NUMBER(38, 0)		NULL, 
                                    "SC_TY"	VARCHAR(255)		NULL, 
                                    "DMGE_SEQ"	NUMBER(38, 0)		NULL, 
                                    "VICTIM_NM"	VARCHAR(255)		NULL, 
                                    "PAY_GRNTE_STTS"	VARCHAR(255)		NULL, 
                                    "VICTIM_TEL"	VARCHAR(255)		NULL, 
                                    "DMGE_TY"	VARCHAR(255)		NULL, 
                                    "SEATBLT_STTS"	VARCHAR(255)		NULL, 
                                    "DMGE_STTS"	VARCHAR(255)		NULL, 
                                    "HSPTL"	VARCHAR(255)		NULL, 
                                    "HSPTL_TEL"	VARCHAR(255)		NULL, 
                                    "OPIC_ACDNT_NO"	VARCHAR(255)		NULL, 
                                    "OPIC_PIC"	VARCHAR(255)		NULL, 
                                    "OPIC_PIC_TEL"	VARCHAR(255)		NULL, 
                                    "AD_RCPT_YN"	VARCHAR(1)	DEFAULT 'N'	NULL, 
                                    "CREATED_AT"	TIMESTAMP		NULL, 
                                    "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL"."ACDNT_RCPT_ID" IS '* ACCIDENT RECEIPT_ID / 사고접수 ID'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL"."PSN_PIC_ID" IS '* PERSON PERSON IN CHARGE ID / 피해자 담당자 ID'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL"."SC_TY" IS '* SECURITY TYPE / 담보 유형'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL"."DMGE_SEQ" IS '* DAMAGE SEQUENCE / 피해서열'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL"."VICTIM_NM" IS '* VICTIM NAME / 피해자명'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL"."PAY_GRNTE_STTS" IS '* PAYMENT GUARANTEE  STATUS / 지급보증 상태'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL"."VICTIM_TEL" IS '* VICTIM TEL / 피해자 연락처'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL"."DMGE_TY" IS '* DAMAGE TYPE / 피해유형'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL"."SEATBLT_STTS" IS '* SEATBELT STATUS / 안전벨트 상태'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL"."DMGE_STTS" IS '* DAMAGE STATUS / 피해상태'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL"."HSPTL" IS '* HOSPITAL / 치료병원'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL"."HSPTL_TEL" IS '* HOSPITAL TEL / 치료병원 연락처'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL"."OPIC_ACDNT_NO" IS '* OTHER PARTY INSURANCE COMPANY ACCIDENT NUMBER / 타사 사고번호'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL"."OPIC_PIC" IS '* OTHER PARTY INSURANCE COMPANY PERSON IN CHARGE / 타사 담당자'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL"."OPIC_PIC_TEL" IS '* OTHER PARTY INSURANCE COMPANY PERSON IN CHARGE TEL / 타사 담당자 연락처'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL"."AD_RCPT_YN" IS '* ADDITIONAL RECEIPT YES OR NO / 추가 접수 여부 /  Y, N(DEFAULT)'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL"."CREATED_AT" IS '* CREATED_AT / 생성시간'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL"."UPDATED_AT" IS '* UPDATED_AT / 수정시간'; 
 
 

-----------------------------------------CREATE PROPERTY_DAMAGE_HISTORY-----------------------------------------
CREATE TABLE FINTECH."PROPERTY_DAMAGE_HISTORY" ( 
                                           "CHG_CNT"	NUMBER(38, 0)		NOT NULL, 
                                           "SC"	VARCHAR(255)		NOT NULL, 
                                           "TWD_PRPTY_ID"	NUMBER(38, 0)		NOT NULL, 
                                           "ACDNT_RCPT_ID"	NUMBER(38, 0)		NOT NULL, 
                                           "PRPTY_PIC_ID"	NUMBER(38, 0)		NULL, 
                                           "DMGE_SEQ"	NUMBER(38, 0)		NULL, 
                                           "SC_TY"	VARCHAR(255)		NULL, 
                                           "VHRNO"	VARCHAR(255)		NULL, 
                                           "VHCL_NM"	VARCHAR(255)		NULL, 
                                           "VHCL_OWNR"	VARCHAR(255)		NULL, 
                                           "VHCL_OWNR_TEL"	VARCHAR(255)		NULL, 
                                           "OPIC_NM"	VARCHAR(255)		NULL, 
                                           "OPIC_ACDNT_NO"	VARCHAR(255)		NULL, 
                                           "OPIC_PIC"	VARCHAR(255)		NULL, 
                                           "OPIC_PIC_TEL"	VARCHAR(255)		NULL, 
                                           "DMGE_DGREE"	VARCHAR(255)		NULL, 
                                           "RPR_TY"	VARCHAR(255)		NULL, 
                                           "RPR_FCTRY"	VARCHAR(255)		NULL, 
                                           "PRP_FCTRY_TEL"	VARCHAR(255)		NULL, 
                                           "RPR_FCTRY_PIC_NM"	VARCHAR(255)		NULL, 
                                           "RPR_FCTRY_PIC_TEL"	VARCHAR(255)		NULL, 
                                           "AD_RCPT_YN"	VARCHAR(1)		NULL, 
                                           "CONTACT_YN"	VARCHAR(1)		NOT NULL, 
                                           "DRVER_NM"	VARCHAR(255)		NULL, 
                                           "FAULT_RT"	NUMBER(38, 0)		NULL, 
                                           "DEL_YN"	VARCHAR(1)		NULL, 
                                           "CREATED_AT"	TIMESTAMP		NULL, 
                                           "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."CHG_CNT" IS '* CHANGE COUNT / 변경 회차'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."SC" IS '* SCREEN / 화면'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."TWD_PRPTY_ID" IS '* TOWARD PROPERTY ID / 대물피해 ID'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."ACDNT_RCPT_ID" IS '* ACCIDENT RECEIPT ID / 사고접수 ID'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."PRPTY_PIC_ID" IS '* PROPERTY  PERSON IN CHARGE ID / 피해물 담당자 ID'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."DMGE_SEQ" IS '* DAMAGE SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."SC_TY" IS '* SECURITY TYPE / 담보 유형'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."VHRNO" IS '* VEHICLE REGISTRATION NUMBER / 차량번호'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."VHCL_NM" IS '* VEHICLE NAME / 차량명'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."VHCL_OWNR" IS '* VEHICLE OWNER / 차량 소유주'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."VHCL_OWNR_TEL" IS '* VEHICLE OWNER TEL / 차량 소유주 연락처'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."OPIC_NM" IS '* OTHER PARTY INSURANCE COMPANY NAME / 타사명'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."OPIC_ACDNT_NO" IS '* OTHER PARTY INSURANCE COMPANY ACCIDENT NUMBER / 타사 사고번호'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."OPIC_PIC" IS '* OTHER PARTY INSURANCE COMPANY PERSON IN CHARGE / 타사 담당자'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."OPIC_PIC_TEL" IS '* OTHER PARTY INSURANCE COMPANY PERSON IN CHARGE TEL / 타사 담당자 연락처'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."DMGE_DGREE" IS '* DAMAGE DEGREE / 파손정도'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."RPR_TY" IS '* REPAIR TYPE / 수리구분'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."RPR_FCTRY" IS '* REPAIR FACTORY / 정비공장'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."PRP_FCTRY_TEL" IS '* REPAIR FACTORY TEL / 정비공장 연락처'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."RPR_FCTRY_PIC_NM" IS '* REPAIR FACTORY PERSON IN CHARGE NAME / 정비공장 담당자'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."RPR_FCTRY_PIC_TEL" IS '* REPAIR FACTORY PERSON IN CHARGE TEL / 정비공장 담당자 연락처'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."AD_RCPT_YN" IS '* ADDITIONAL RECEPTION YES OR NO / 추가접수 여부 /  Y, N'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."CONTACT_YN" IS '* CONTACT YES OR NO / 접촉 여부 /  Y, N'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."DRVER_NM" IS '* DRIVER NAME / 운전자명'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."FAULT_RT" IS '* FAULT RATE/ 과실율'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."DEL_YN" IS '* DELETION YES OR NO / 삭제여부 /  Y, N'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."CREATED_AT" IS '* CREATED_AT / 생성시간'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE_HISTORY"."UPDATED_AT" IS '* UPDATED_AT / 수정시간'; 
 
 

-----------------------------------------CREATE PROPERTY_DAMAGE-----------------------------------------
CREATE TABLE FINTECH."PROPERTY_DAMAGE" ( 
                                   "ID"	NUMBER(38, 0)		NOT NULL, 
                                   "ACDNT_RCPT_ID"	NUMBER(38, 0)		NOT NULL, 
                                   "PRPTY_PIC_ID"	NUMBER(38, 0)		NULL, 
                                   "DMGE_SEQ"	NUMBER(38, 0)		NULL, 
                                   "SC_TY"	VARCHAR(255)		NULL, 
                                   "VHRNO"	VARCHAR(255)		NULL, 
                                   "VHCL_NM"	VARCHAR(255)		NULL, 
                                   "VHCL_OWNR"	VARCHAR(255)		NULL, 
                                   "VHCL_OWNR_TEL"	VARCHAR(255)		NULL, 
                                   "OPIC_NM"	VARCHAR(255)		NULL, 
                                   "OPIC_ACDNT_NO"	VARCHAR(255)		NULL, 
                                   "OPIC_PIC"	VARCHAR(255)		NULL, 
                                   "OPIC_PIC_TEL"	VARCHAR(255)		NULL, 
                                   "DMGE_DGREE"	VARCHAR(255)		NULL, 
                                   "RPR_TY"	VARCHAR(255)		NULL, 
                                   "RPR_FCTRY"	VARCHAR(255)		NULL, 
                                   "PRP_FCTRY_TEL"	VARCHAR(255)		NULL, 
                                   "RPR_FCTRY_PIC_NM"	VARCHAR(255)		NULL, 
                                   "RPR_FCTRY_PIC_TEL"	VARCHAR(255)		NULL, 
                                   "AD_RCPT_YN"	VARCHAR(1)	DEFAULT 'N'	NULL, 
                                   "CONTACT_YN"	VARCHAR(1)		NOT NULL, 
                                   "DRVER_NM"	VARCHAR(255)		NULL, 
                                   "FAULT_RT"	NUMBER(38, 0)		NULL, 
                                   "DEL_YN"	VARCHAR(1)	DEFAULT 'N'	NULL, 
                                   "CREATED_AT"	TIMESTAMP		NULL, 
                                   "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."ACDNT_RCPT_ID" IS '* ACCIDENT RECEIPT ID / 사고접수 ID'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."PRPTY_PIC_ID" IS '* PROPERTY  PERSON IN CHARGE ID / 피해물 담당자 ID'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."DMGE_SEQ" IS '* DAMAGE SEQUENCE / 피해서열'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."SC_TY" IS '* SECURITY TYPE / 담보 유형'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."VHRNO" IS '* VEHICLE NUMBER / 차량번호'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."VHCL_NM" IS '* VEHICLE NAME / 차량명'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."VHCL_OWNR" IS '* VEHICLE OWNER / 차량 소유주'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."VHCL_OWNR_TEL" IS '* VEHICLE OWNER PHONE TEL / 차량 소유주 연락처'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."OPIC_NM" IS '* OTHER PARTY INSURANCE COMPANY NAME / 타사명'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."OPIC_ACDNT_NO" IS '* OTHER PARTY INSURANCE COMPANY ACCIDENT NUMBER / 타사 사고번호'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."OPIC_PIC" IS '* OTHER PARTY INSURANCE COMPANY PERSON IN CHARGE / 타사 담당자'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."OPIC_PIC_TEL" IS '* OTHER PARTY INSURANCE COMPANY PERSON IN CHARGE TEL / 타사 담당자 연락처'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."DMGE_DGREE" IS '* DAMAGE DEGREE / 파손정도'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."RPR_TY" IS '* REPAIR TYPE / 수리구분'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."RPR_FCTRY" IS '* REPAIR FACTORY / 정비공장'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."PRP_FCTRY_TEL" IS '* REPAIR FACTORY PHONE NUMBER / 정비공장 연락처'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."RPR_FCTRY_PIC_NM" IS '* REPAIR FACTORY PERSON IN CHARGE NAME / 정비공장 담당자'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."RPR_FCTRY_PIC_TEL" IS '* REPAIR FACTORY PERSON IN CHARGE  TEL / 정비공장 담당자 연락처'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."AD_RCPT_YN" IS '* ADDITIONAL RECEPTION YES OR NO / 추가 접수 여부 /  Y, N(DEFAULT)'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."CONTACT_YN" IS '* CONTACT YES OR NO / 접촉 여부 /  Y, N'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."DRVER_NM" IS '* DRIVER NAME / 운전자명'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."FAULT_RT" IS '* FAULT RATE / 과실율'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."DEL_YN" IS '* DELETION YES OR NO / 삭제 여부 /  Y, N(DEFAULT)'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."CREATED_AT" IS '* CREATED_AT / 생성시간'; 
 
COMMENT ON COLUMN FINTECH."PROPERTY_DAMAGE"."UPDATED_AT" IS '* UPDATED_AT / 수정시간'; 
 
 

-----------------------------------------CREATE TOWARD_PERSONNEL_HOSPITAL_REL-----------------------------------------
CREATE TABLE FINTECH."TOWARD_PERSONNEL_HOSPITAL_REL" ( 
                                                 "ID"	NUMBER(38, 0)		NOT NULL, 
                                                 "HSPTL_ID"	NUMBER(38, 0)		NOT NULL, 
                                                 "TWD_PSN_ID"	NUMBER(38, 0)		NOT NULL 
); 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HOSPITAL_REL"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HOSPITAL_REL"."HSPTL_ID" IS '* HOSPITAL ID / 병원 ID'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HOSPITAL_REL"."TWD_PSN_ID" IS '* TOWARD PERSONNEL ID / 대인피해 ID'; 
 
 

-----------------------------------------CREATE HOSPITAL-----------------------------------------
CREATE TABLE FINTECH."HOSPITAL" ( 
                            "ID"	NUMBER(38, 0)		NOT NULL, 
                            "HSPTL_NM"	VARCHAR(255)		NULL, 
                            "HSPTL_CD"	VARCHAR(255)		NULL, 
                            "TEL"	VARCHAR(255)		NULL, 
                            "FXNO"	VARCHAR(255)		NULL, 
                            "ADDR"	VARCHAR(255)		NULL, 
                            "ADDR_DTL"	VARCHAR(255)		NULL, 
                            "CCPY_YN"	VARCHAR(1)		NOT NULL, 
                            "HSPTL_GRD"	VARCHAR(255)		NULL, 
                            "CREATED_AT"	TIMESTAMP		NULL, 
                            "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."HOSPITAL"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."HOSPITAL"."HSPTL_NM" IS '* HOSPITAL NAME / 병원명'; 
 
COMMENT ON COLUMN FINTECH."HOSPITAL"."HSPTL_CD" IS '* HOSPITAL CODE / 병원코드'; 
 
COMMENT ON COLUMN FINTECH."HOSPITAL"."TEL" IS '* TEL / 전화번호'; 
 
COMMENT ON COLUMN FINTECH."HOSPITAL"."FXNO" IS '* FAX NUMBER / FAX번호'; 
 
COMMENT ON COLUMN FINTECH."HOSPITAL"."ADDR" IS '* ADDRESS / 주소'; 
 
COMMENT ON COLUMN FINTECH."HOSPITAL"."ADDR_DTL" IS '* ADDRESS DETAIL / 세부주소'; 
 
COMMENT ON COLUMN FINTECH."HOSPITAL"."CCPY_YN" IS '* COOPERATION COMPANY YES OR NO / 협력업체 여부'; 
 
COMMENT ON COLUMN FINTECH."HOSPITAL"."HSPTL_GRD" IS '* HSPTL_GRD / 병원 등급 / 추후 수정 필요'; 
 
COMMENT ON COLUMN FINTECH."HOSPITAL"."CREATED_AT" IS '* CREATED_AT / 생성시간'; 
 
COMMENT ON COLUMN FINTECH."HOSPITAL"."UPDATED_AT" IS '* UPDATED_AT / 수정시간'; 
 
 

-----------------------------------------CREATE PAYMENT_GUARANTEE-----------------------------------------
CREATE TABLE FINTECH."PAYMENT_GUARANTEE" ( 
                                     "ID"	NUMBER(38, 0)		NOT NULL, 
                                     "TWD_PSN_ID"	NUMBER(38, 0)		NOT NULL, 
                                     "HSPTL_ID"	NUMBER(38, 0)		NOT NULL, 
                                     "EMP_ID"	NUMBER(38, 0)		NOT NULL, 
                                     "ISSU_SEQ"	NUMBER(38, 0)		NOT NULL, 
                                     "CHG_CNT"	NUMBER(38, 0)		NOT NULL, 
                                     "PAY_GRNTE_STRT_DT"	TIMESTAMP		NULL, 
                                     "PAY_GRNTE_END_DT"	TIMESTAMP		NULL, 
                                     "PAY_GRNTE_DAYS"	NUMBER(38, 0)		NULL, 
                                     "PAY_GRNTE_NO"	VARCHAR(255)		NULL, 
                                     "NOTE"	VARCHAR(255)		NULL, 
                                     "INPT_DT"	TIMESTAMP		NULL, 
                                     "SP_YN"	VARCHAR(1)		NULL, 
                                     "SP_RESN"	VARCHAR(255)		NULL, 
                                     "SP_DT"	TIMESTAMP		NULL, 
                                     "SP_SN"	VARCHAR(255)		NULL, 
                                     "ISSU_DT"	TIMESTAMP		NULL, 
                                     "PIC_NM"	VARCHAR(255)		NULL, 
                                     "PIC_TEL"	VARCHAR(255)		NULL, 
                                     "ACDNT_DT"	TIMESTAMP		NULL, 
                                     "ACDNT_ADDR"	VARCHAR(255)		NULL, 
                                     "ACDNT_ADDR_DTL"	VARCHAR(255)		NULL, 
                                     "VICTIM_NM"	VARCHAR(255)		NULL, 
                                     "VICTIM_RRNO"	VARCHAR(255)		NULL, 
                                     "VICTIM_GENDER"	VARCHAR(1)		NULL, 
                                     "VICTIM_AGE"	NUMBER(38, 0)		NULL, 
                                     "VICTIM_SC"	VARCHAR(255)		NULL, 
                                     "DMGE_DGREE"	VARCHAR(255)		NULL, 
                                     "LMT_SE"	VARCHAR(255)		NULL, 
                                     "LMT_MNY"	VARCHAR(255)		NULL, 
                                     "INSRNC_CLS"	VARCHAR(255)		NULL, 
                                     "JOIN_SC"	VARCHAR(255)		NULL, 
                                     "INSRNC_STRT_DT"	TIMESTAMP		NULL, 
                                     "INSRNC_END_DT"	TIMESTAMP		NULL, 
                                     "IPS"	VARCHAR(255)		NULL, 
                                     "VHRNO"	VARCHAR(255)		NULL, 
                                     "CREATED_AT"	TIMESTAMP		NULL, 
                                     "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."TWD_PSN_ID" IS '* TOWARD PERSONNEL ID / 대인피해 ID'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."HSPTL_ID" IS '* HOSPITAL ID / 병원 ID'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."EMP_ID" IS '* EMPLOYER ID / 기간계직원 ID'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."ISSU_SEQ" IS '* ISSUE SEQUENCE / 발급서열'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."CHG_CNT" IS '* CHANGE COUNT / 변경회차'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."PAY_GRNTE_STRT_DT" IS '* PAYMENT GUARANTEE START DATE / 지급보증시기'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."PAY_GRNTE_END_DT" IS '* PAYMENT GUARANTEE END DATE / 지급보증종기'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."PAY_GRNTE_DAYS" IS '* PAYMENT GUARANTEE DAYS / 지급보증일수'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."PAY_GRNTE_NO" IS 'UNIQUE * PAYMENT GUARANTEE NUMBER / 지급보증번호'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."NOTE" IS '* NOTE / 비고사항'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."INPT_DT" IS '* INPUT DATETIME / 입력일시'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."SP_YN" IS '* SUSPENSION YES OR NO / 중지여부'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."SP_RESN" IS '* SUSPENSION REASON / 중지사유 / 합의, 기타'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."SP_DT" IS '* SUSPENSION DATETIME / 중지일자 / 년,월일'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."SP_SN" IS '* SUSPENSION SPECIAL NOTE / 중지 특이사항'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."ISSU_DT" IS '* ISSUE DATETIME / 발급일시'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."PIC_NM" IS '* PERSON IN CHARGE NAME / 담당자'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."PIC_TEL" IS '* PERSON IN CHARGE TEL / 담당자 연락처'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."ACDNT_DT" IS '* ACCIDENT DATE / 사고일시'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."ACDNT_ADDR" IS '* ACCIDENT ADDRESS / 사고장소'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."ACDNT_ADDR_DTL" IS '* ACDNT ADDRESS DETAIL / 사고 세부주소'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."VICTIM_NM" IS '* VICTIM NAME / 피해자명'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."VICTIM_RRNO" IS '* VICTIM  RESIDENT REGISTRATION NUMBER / 피해자 주민번호'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."VICTIM_GENDER" IS '* VICTIM GENDER / 피해자  성별 / M, F'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."VICTIM_AGE" IS '* VICTIM AGE / 피해자 연령'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."VICTIM_SC" IS '* SECURITY / 담보'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."DMGE_DGREE" IS '* DAMAGE DEGREE / 피해정도'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."LMT_SE" IS '* LIMIT SECTION / 한도구분'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."LMT_MNY" IS '* LIMIT MONEY / 한도액'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."INSRNC_CLS" IS '* INSURANCE CLASS / 공제종목'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."JOIN_SC" IS '* JOIN SCURITY / 가입담보'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."INSRNC_STRT_DT" IS '* INSURANCE START DATE / 공제시기'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."INSRNC_END_DT" IS '* INSURANCE END DATE / 공제종기'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."IPS" IS '* INSURED PERSON / 피공제자명'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."VHRNO" IS '* VEHICLE REGISTRATION NUMBER / 차량번호'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."CREATED_AT" IS '* CREATED_AT / 생성시간'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE"."UPDATED_AT" IS '* UPDATED_AT / 수정시간'; 
 
 

-----------------------------------------CREATE PAYMENT_GUARANTEE_HISTORY-----------------------------------------
CREATE TABLE FINTECH."PAYMENT_GUARANTEE_HISTORY" ( 
                                             "CHG_CNT"	NUMBER(38, 0)		NOT NULL, 
                                             "PAY_GRNTE_ID"	NUMBER(38, 0)		NOT NULL, 
                                             "TWD_PSN_ID"	NUMBER(38, 0)		NOT NULL, 
                                             "HSPTL_ID"	NUMBER(38, 0)		NOT NULL, 
                                             "EMP_ID"	NUMBER(38, 0)		NOT NULL, 
                                             "ISSU_SEQ"	NUMBER(38, 0)		NOT NULL, 
                                             "PAY_GRNTE_STRT_DT"	TIMESTAMP		NULL, 
                                             "PAY_GRNTE_END_DT"	TIMESTAMP		NULL, 
                                             "PAY_GRNTE_DAYS"	NUMBER(38, 0)		NULL, 
                                             "PAY_GRNTE_NO"	VARCHAR(255)		NULL, 
                                             "NOTE"	VARCHAR(255)		NULL, 
                                             "INPT_DT"	TIMESTAMP		NULL, 
                                             "SP_YN"	VARCHAR(1)		NULL, 
                                             "SP_RESN"	VARCHAR(255)		NULL, 
                                             "SP_DT"	TIMESTAMP		NULL, 
                                             "SP_SN"	VARCHAR(255)		NULL, 
                                             "ISSU_DT"	TIMESTAMP		NULL, 
                                             "PIC_NM"	VARCHAR(255)		NULL, 
                                             "PIC_TEL"	VARCHAR(255)		NULL, 
                                             "ACDNT_DT"	TIMESTAMP		NULL, 
                                             "ACDNT_ADDR"	VARCHAR(255)		NULL, 
                                             "ACDNT_ADDR_DTL"	VARCHAR(255)		NULL, 
                                             "VICTIM_NM"	VARCHAR(255)		NULL, 
                                             "VICTIM_RRNO"	VARCHAR(255)		NULL, 
                                             "VICTIM_GENDER"	VARCHAR(1)		NULL, 
                                             "VICTIM_AGE"	NUMBER(38, 0)		NULL, 
                                             "VICTIM_SC"	VARCHAR(255)		NULL, 
                                             "DMGE_DGREE"	VARCHAR(255)		NULL, 
                                             "LMT_SE"	VARCHAR(255)		NULL, 
                                             "LMT_MNY"	VARCHAR(255)		NULL, 
                                             "INSRNC_CLS"	VARCHAR(255)		NULL, 
                                             "JOIN_SC"	VARCHAR(255)		NULL, 
                                             "INSRNC_STRT_DT"	TIMESTAMP		NULL, 
                                             "INSRNC_END_DT"	TIMESTAMP		NULL, 
                                             "IPS"	VARCHAR(255)		NULL, 
                                             "VHRNO"	VARCHAR(255)		NULL, 
                                             "CREATED_AT"	TIMESTAMP		NULL, 
                                             "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."CHG_CNT" IS '* CHANGE COUNT / 변경회차'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."PAY_GRNTE_ID" IS '* PAYMENT GUARANTEE ID / 지급보증서 ID'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."TWD_PSN_ID" IS '* TOWARD PERSONNEL / 대인피해 ID'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."HSPTL_ID" IS '* HOSPITAL ID / 병원 ID'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."EMP_ID" IS '* EMPLOYER ID / 기간계직원 ID'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."ISSU_SEQ" IS '* ISSUE SEQUENCE / 발급서열'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."PAY_GRNTE_STRT_DT" IS '* PAYMENT GUARANTEE START DATE / 지급보증시기'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."PAY_GRNTE_END_DT" IS '* PAYMENT GUARANTEE END DATE / 지급보증종기'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."PAY_GRNTE_DAYS" IS '* PAYMENT GUARANTEE DAYS / 지급보증일수'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."PAY_GRNTE_NO" IS '* PAYMENT GUARANTEE NUMBER / 지급보증번호'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."NOTE" IS '* NOTE / 비고사항'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."INPT_DT" IS '* INPUT DATETIME / 입력일시'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."SP_YN" IS '* SUSPENSION YES OR NO / 중지여부'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."SP_RESN" IS '* SUSPENSION REASON / 중지사유 / 합의, 기타'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."SP_DT" IS '* SUSPENSION DATETIME / 중지일자 / 년,월일'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."SP_SN" IS '* SPECIAL NOTE / 중지 특이사항'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."ISSU_DT" IS '* ISSUE DATETIME / 발급일시'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."PIC_NM" IS '*PERSON IN CHARGE NAME / 담당자'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."PIC_TEL" IS '*PERSON IN CHARGE TEL / 담당자 연락처'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."ACDNT_DT" IS '*ACCIDENT DATE / 사고일시'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."ACDNT_ADDR" IS '*ACCIDENT ADDRESS / 사고장소'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."ACDNT_ADDR_DTL" IS '*ACCIDENT ADDRESS DETAIL / 사고 세부주소'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."VICTIM_NM" IS '* VICTIM NAME / 피해자명'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."VICTIM_RRNO" IS '*VICTIM RESIDENT REGISTRATION NUMBER / 피해자 주민번호'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."VICTIM_GENDER" IS '*VICTIM GENDER / 피해자  성별 / M, F'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."VICTIM_AGE" IS '*VICTIM AGE / 피해자 연령'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."VICTIM_SC" IS '*SECURITY / 담보'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."DMGE_DGREE" IS '* DAMAGE DEGREE / 피해정도'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."LMT_SE" IS '* LIMIT SECTION / 한도구분'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."LMT_MNY" IS '* LIMIT MONEY / 한도액'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."INSRNC_CLS" IS '* INSURANCE CLASS / 공제종목'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."JOIN_SC" IS '* JOIN SCURITY / 가입담보'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."INSRNC_STRT_DT" IS '* INSURANCE START DATE / 공제시기'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."INSRNC_END_DT" IS '* INSURANCE END DATE / 공제종기'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."IPS" IS '* INSURED PERSON / 피공제자명'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."VHRNO" IS '*VEHICLE REGISTRATION NUMBER / 차량번호'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."CREATED_AT" IS '* CREATED_AT / 생성시간'; 
 
COMMENT ON COLUMN FINTECH."PAYMENT_GUARANTEE_HISTORY"."UPDATED_AT" IS '* UPDATED_AT / 수정시간'; 
 
 

-----------------------------------------CREATE POLICE_AGENCY_INVOLVEMENT-----------------------------------------
CREATE TABLE FINTECH."POLICE_AGENCY_INVOLVEMENT" ( 
                                             "ID"	NUMBER(38, 0)		NOT NULL, 
                                             "ISSU_SEQ"	NUMBER(38, 0)		NOT NULL, 
                                             "ACDNT_RCPT_ID"	NUMBER(38, 0)		NOT NULL, 
                                             "ACDNT_DT"	TIMESTAMP		NULL, 
                                             "VHRNO"	VARCHAR(255)		NULL, 
                                             "DRVER_NM"	VARCHAR(255)		NULL, 
                                             "DRVER_RRNO"	VARCHAR(255)		NULL, 
                                             "INNB"	VARCHAR(255)		NULL, 
                                             "RQSTR_NM"	VARCHAR(255)		NULL, 
                                             "RQST_DT"	TIMESTAMP		NULL, 
                                             "CREATED_AT"	TIMESTAMP		NULL, 
                                             "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."POLICE_AGENCY_INVOLVEMENT"."ID" IS 'SEQUENCE'; 
 
COMMENT ON COLUMN FINTECH."POLICE_AGENCY_INVOLVEMENT"."ISSU_SEQ" IS '* ISSUE SEQUENCE / 발급서열'; 
 
COMMENT ON COLUMN FINTECH."POLICE_AGENCY_INVOLVEMENT"."ACDNT_RCPT_ID" IS '* ACCIDENT RECEIPT ID / 사고접수 ID'; 
 
COMMENT ON COLUMN FINTECH."POLICE_AGENCY_INVOLVEMENT"."ACDNT_DT" IS '* ACCIDENT DATE / 사고일시'; 
 
COMMENT ON COLUMN FINTECH."POLICE_AGENCY_INVOLVEMENT"."VHRNO" IS '* VEHICLE REGISTRATION NUMBER / 차량번호'; 
 
COMMENT ON COLUMN FINTECH."POLICE_AGENCY_INVOLVEMENT"."DRVER_NM" IS '* DRIVER NAME / 운전자명'; 
 
COMMENT ON COLUMN FINTECH."POLICE_AGENCY_INVOLVEMENT"."DRVER_RRNO" IS '* DRIVER  RESIDENT REGISTRATION NUMBER / 운전자 주민번호'; 
 
COMMENT ON COLUMN FINTECH."POLICE_AGENCY_INVOLVEMENT"."INNB" IS '* IDENTIFICATION NUMBER / 고유번호'; 
 
COMMENT ON COLUMN FINTECH."POLICE_AGENCY_INVOLVEMENT"."RQSTR_NM" IS '* REQUESTER NAME / 요청자명'; 
 
COMMENT ON COLUMN FINTECH."POLICE_AGENCY_INVOLVEMENT"."RQST_DT" IS '* REQUEST DATE TIME / 요청일시'; 
 
COMMENT ON COLUMN FINTECH."POLICE_AGENCY_INVOLVEMENT"."CREATED_AT" IS '* CREATED_AT / 생성시간'; 
 
COMMENT ON COLUMN FINTECH."POLICE_AGENCY_INVOLVEMENT"."UPDATED_AT" IS '* UPDATED_AT / 수정시간'; 
 
 

-----------------------------------------CREATE TOWARD_PERSONNEL_HISTORY-----------------------------------------
CREATE TABLE FINTECH."TOWARD_PERSONNEL_HISTORY" ( 
                                            "CHG_CNT"	NUMBER(38, 0)		NOT NULL, 
                                            "TWD_PSN_ID"	NUMBER(38, 0)		NOT NULL, 
                                            "ACDNT_RCPT_ID"	NUMBER(38, 0)		NOT NULL, 
                                            "PSN_PIC_ID"	NUMBER(38, 0)		NULL, 
                                            "SC_TY"	VARCHAR(255)		NULL, 
                                            "DMGE_SEQ"	NUMBER(38, 0)		NULL, 
                                            "VICTIM_NM"	VARCHAR(255)		NULL, 
                                            "PAY_GRNTE_STTS"	VARCHAR(255)		NULL, 
                                            "VICTIM_TEL"	VARCHAR(255)		NULL, 
                                            "DMGE_TY"	VARCHAR(255)		NULL, 
                                            "SEATBLT_STTS"	VARCHAR(255)		NULL, 
                                            "DMGE_STTS"	VARCHAR(255)		NULL, 
                                            "HSPTL"	VARCHAR(255)		NULL, 
                                            "HSPTL_TEL"	VARCHAR(255)		NULL, 
                                            "OPIC_ACDNT_NO"	VARCHAR(255)		NULL, 
                                            "OPIC_PIC"	VARCHAR(255)		NULL, 
                                            "OPIC_PIC_TEL"	VARCHAR(255)		NULL, 
                                            "CURR_VICTIM_STTS"	VARCHAR(255)		NULL, 
                                            "AD_RCPT_YN"	VARCHAR(1)		NULL, 
                                            "CREATED_AT"	TIMESTAMP		NULL, 
                                            "UPDATED_AT"	TIMESTAMP		NULL 
); 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HISTORY"."CHG_CNT" IS '* CHANGE COUNT / 변경회차'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HISTORY"."TWD_PSN_ID" IS '* TOWARD PERSONNEL ID / 대인피해 ID'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HISTORY"."ACDNT_RCPT_ID" IS '* ACCIDENT RECEIPT ID / 사고접수 ID'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HISTORY"."PSN_PIC_ID" IS '* PERSON PERSON IN CHARGE ID / 피해자 담당자 ID'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HISTORY"."SC_TY" IS '* SECURITY TYPE / 담보 유형'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HISTORY"."DMGE_SEQ" IS '* DAMAGE SEQUENCE / 피해서열'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HISTORY"."VICTIM_NM" IS '* VICTIM NAME / 피해자명'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HISTORY"."PAY_GRNTE_STTS" IS '* PAYMENT GUARANTEE  STATUS / 지급보증 상태'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HISTORY"."VICTIM_TEL" IS '* VICTIM TEL / 피해자 연락처'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HISTORY"."DMGE_TY" IS '* DAMAGE TYPE / 피해유형'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HISTORY"."SEATBLT_STTS" IS '* SEATBELT STATUS / 안전벨트 상태'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HISTORY"."DMGE_STTS" IS '* DEMAGE STATUS / 피해상태'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HISTORY"."HSPTL" IS '* HOSPITAL / 치료병원'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HISTORY"."HSPTL_TEL" IS '* HOSPITAL TEL / 치료병원 연락처'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HISTORY"."OPIC_ACDNT_NO" IS '* OTHER PARTY INSURANCE COMPANY ACCIDENT NUMBER / 타사 사고번호'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HISTORY"."OPIC_PIC" IS '* OTHER PARTY INSURANCE COMPANY PERSON IN CHARGE / 타사 담당자'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HISTORY"."OPIC_PIC_TEL" IS '* OTHER PARTY INSURANCE COMPANY PERSON IN CHARGE TEL / 타사 담당자 연락처'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HISTORY"."CURR_VICTIM_STTS" IS '* CURRENT VICTIM STATUS / 현재 상태'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HISTORY"."AD_RCPT_YN" IS '* ADDITIONAL RECEIPT YES OR NO / 추가 접수 여부 /  Y, N'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HISTORY"."CREATED_AT" IS '* CREATED_AT / 생성시간'; 
 
COMMENT ON COLUMN FINTECH."TOWARD_PERSONNEL_HISTORY"."UPDATED_AT" IS '* UPDATED_AT / 수정시간'; 
 
 
-----------------------------------------DEPARTMENT PK SETTING-----------------------------------------
ALTER TABLE FINTECH."DEPARTMENT" ADD CONSTRAINT "PK_DEPARTMENT" PRIMARY KEY (
                                                                     "ID"
    );

-----------------------------------------JOB_TITLE PK SETTING-----------------------------------------
ALTER TABLE FINTECH."JOB_TITLE" ADD CONSTRAINT "PK_JOB_TITLE" PRIMARY KEY (
                                                                   "ID"
    );

-----------------------------------------JOB_POSITION PK SETTING-----------------------------------------
ALTER TABLE FINTECH."JOB_POSITION" ADD CONSTRAINT "PK_JOB_POSITION" PRIMARY KEY (
                                                                         "ID"
    );

-----------------------------------------EMPLOYEE PK SETTING-----------------------------------------
ALTER TABLE FINTECH."EMPLOYEE" ADD CONSTRAINT "PK_EMPLOYEE" PRIMARY KEY (
                                                                 "ID"
    );

-----------------------------------------UNION_EMPLOYEE_REL PK SETTING-----------------------------------------
ALTER TABLE FINTECH."UNION_EMPLOYEE_REL" ADD CONSTRAINT "PK_UNION_EMPLOYEE_REL" PRIMARY KEY (
                                                                                     "ID"
    );

-----------------------------------------CUSTOMER PK SETTING-----------------------------------------
ALTER TABLE FINTECH."CUSTOMER" ADD CONSTRAINT "PK_CUSTOMER" PRIMARY KEY (
                                                                 "ID"
    );

-----------------------------------------PERSONAL_CUSTOMER PK SETTING-----------------------------------------
ALTER TABLE FINTECH."PERSONAL_CUSTOMER" ADD CONSTRAINT "PK_PERSONAL_CUSTOMER" PRIMARY KEY (
                                                                                   "ID"
    );

-----------------------------------------UNION PK SETTING-----------------------------------------
ALTER TABLE FINTECH."UNION" ADD CONSTRAINT "PK_UNION" PRIMARY KEY (
                                                           "ID"
    );

-----------------------------------------RIDER_UNION_REL PK SETTING-----------------------------------------
ALTER TABLE FINTECH."RIDER_UNION_REL" ADD CONSTRAINT "PK_RIDER_UNION_REL" PRIMARY KEY (
                                                                               "ID"
    );

-----------------------------------------RIDER PK SETTING-----------------------------------------
ALTER TABLE FINTECH."RIDER" ADD CONSTRAINT "PK_RIDER" PRIMARY KEY (
                                                           "ID"
    );

-----------------------------------------DISCUSSION PK SETTING-----------------------------------------
ALTER TABLE FINTECH."DISCUSSION" ADD CONSTRAINT "PK_DISCUSSION" PRIMARY KEY (
                                                                     "ID"
    );

-----------------------------------------TERMS PK SETTING-----------------------------------------
ALTER TABLE FINTECH."TERMS" ADD CONSTRAINT "PK_TERMS" PRIMARY KEY (
                                                           "ID"
    );

-----------------------------------------CUSTOMER_TERMS_REL PK SETTING-----------------------------------------
ALTER TABLE FINTECH."CUSTOMER_TERMS_REL" ADD CONSTRAINT "PK_CUSTOMER_TERMS_REL" PRIMARY KEY (
                                                                                     "ID"
    );

-----------------------------------------VEHICLE PK SETTING-----------------------------------------
ALTER TABLE FINTECH."VEHICLE" ADD CONSTRAINT "PK_VEHICLE" PRIMARY KEY (
                                                               "ID"
    );

-----------------------------------------VEHICLE_FILE PK SETTING-----------------------------------------
ALTER TABLE FINTECH."VEHICLE_FILE" ADD CONSTRAINT "PK_VEHICLE_FILE" PRIMARY KEY (
                                                                         "ID"
    );

-----------------------------------------ADDRESS PK SETTING-----------------------------------------
ALTER TABLE FINTECH."ADDRESS" ADD CONSTRAINT "PK_ADDRESS" PRIMARY KEY (
                                                               "ID"
    );

-----------------------------------------ADDRESS_MEMBER_REL PK SETTING-----------------------------------------
ALTER TABLE FINTECH."ADDRESS_MEMBER_REL" ADD CONSTRAINT "PK_ADDRESS_MEMBER_REL" PRIMARY KEY (
                                                                                     "ID"
    );

-----------------------------------------CONTRACT_DESIGN PK SETTING-----------------------------------------
ALTER TABLE FINTECH."CONTRACT_DESIGN" ADD CONSTRAINT "PK_CONTRACT_DESIGN" PRIMARY KEY (
                                                                               "ID"
    );

-----------------------------------------CONTRACT_DESIGN_FILE PK SETTING-----------------------------------------
ALTER TABLE FINTECH."CONTRACT_DESIGN_FILE" ADD CONSTRAINT "PK_CONTRACT_DESIGN_FILE" PRIMARY KEY (
                                                                                         "ID"
    );

-----------------------------------------ADDRESS_CONTRACT_CUSTOMER_REL PK SETTING-----------------------------------------
ALTER TABLE FINTECH."ADDRESS_CONTRACT_CUSTOMER_REL" ADD CONSTRAINT "PK_ADDRESS_CONTRACT_CUSTOMER_REL" PRIMARY KEY (
                                                                                                           "ID"
    );

-----------------------------------------CONTRACT_CUSTOMER_REL PK SETTING-----------------------------------------
ALTER TABLE FINTECH."CONTRACT_CUSTOMER_REL" ADD CONSTRAINT "PK_CONTRACT_CUSTOMER_REL" PRIMARY KEY (
                                                                                           "ID"
    );

-----------------------------------------CONTRACT_VEHICLE_REL PK SETTING-----------------------------------------
ALTER TABLE FINTECH."CONTRACT_VEHICLE_REL" ADD CONSTRAINT "PK_CONTRACT_VEHICLE_REL" PRIMARY KEY (
                                                                                         "ID"
    );

-----------------------------------------CONTRACT PK SETTING-----------------------------------------
ALTER TABLE FINTECH."CONTRACT" ADD CONSTRAINT "PK_CONTRACT" PRIMARY KEY (
                                                                 "ID"
    );

-----------------------------------------ENDORSE PK SETTING-----------------------------------------
ALTER TABLE FINTECH."ENDORSE" ADD CONSTRAINT "PK_ENDORSE" PRIMARY KEY (
                                                               "ID"
    );

-----------------------------------------ENDORSE_CHANGE PK SETTING-----------------------------------------
ALTER TABLE FINTECH."ENDORSE_CHANGE" ADD CONSTRAINT "PK_ENDORSE_CHANGE" PRIMARY KEY (
                                                                             "ID"
    );

-----------------------------------------INSURANCE_HISTORY PK SETTING-----------------------------------------
ALTER TABLE FINTECH."INSURANCE_HISTORY" ADD CONSTRAINT "PK_INSURANCE_HISTORY" PRIMARY KEY (
                                                                                   "ID"
    );

-----------------------------------------DAMAGE_EXAMINATION_HISTORY PK SETTING-----------------------------------------
ALTER TABLE FINTECH."DAMAGE_EXAMINATION_HISTORY" ADD CONSTRAINT "PK_DAMAGE_EXAMINATION_HISTORY" PRIMARY KEY (
                                                                                                     "EXMN_CHG_CNT",
                                                                                                     "ACDNT_EXMN_ID"
    );

-----------------------------------------ACCIDENT_RECEIPT_SCREEN_HISTORY PK SETTING-----------------------------------------
ALTER TABLE FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY" ADD CONSTRAINT "PK_ACCIDENT_RECEIPT_SCREEN_HISTORY" PRIMARY KEY (
                                                                                                               "CHG_CNT",
                                                                                                               "SCRN",
                                                                                                               "ACDNT_RCPT_ID"
    );

-----------------------------------------DAMAGE_EXAMINATION PK SETTING-----------------------------------------
ALTER TABLE FINTECH."DAMAGE_EXAMINATION" ADD CONSTRAINT "PK_DAMAGE_EXAMINATION" PRIMARY KEY (
                                                                                     "ID"
    );

-----------------------------------------ACCIDENT_RECEIPT PK SETTING-----------------------------------------
ALTER TABLE FINTECH."ACCIDENT_RECEIPT" ADD CONSTRAINT "PK_ACCIDENT_RECEIPT" PRIMARY KEY (
                                                                                 "ID"
    );

-----------------------------------------OTS_DISPATCH_REPORT PK SETTING-----------------------------------------
ALTER TABLE FINTECH."OTS_DISPATCH_REPORT" ADD CONSTRAINT "PK_OTS_DISPATCH_REPORT" PRIMARY KEY (
                                                                                       "ID"
    );

-----------------------------------------BIG_ACCIDENT_DETAIL PK SETTING-----------------------------------------
ALTER TABLE FINTECH."BIG_ACCIDENT_DETAIL" ADD CONSTRAINT "PK_BIG_ACCIDENT_DETAIL" PRIMARY KEY (
                                                                                       "ID"
    );

-----------------------------------------BIG_ACCIDENT_INFO PK SETTING-----------------------------------------
ALTER TABLE FINTECH."BIG_ACCIDENT_INFO" ADD CONSTRAINT "PK_BIG_ACCIDENT_INFO" PRIMARY KEY (
                                                                                   "ACDNT_RCPT_ID"
    );

-----------------------------------------BIG_ACCIDENT_DETAIL_HISTORY PK SETTING-----------------------------------------
ALTER TABLE FINTECH."BIG_ACCIDENT_DETAIL_HISTORY" ADD CONSTRAINT "PK_BIG_ACCIDENT_DETAIL_HISTORY" PRIMARY KEY (
                                                                                                       "CHG_CNT",
                                                                                                       "BIG_ACDNT_DMGE_CN_ID"
    );

-----------------------------------------BIG_ACCIDENT_INFO_HISTORY PK SETTING-----------------------------------------
ALTER TABLE FINTECH."BIG_ACCIDENT_INFO_HISTORY" ADD CONSTRAINT "PK_BIG_ACCIDENT_INFO_HISTORY" PRIMARY KEY (
                                                                                                   "CHG_CNT",
                                                                                                   "ACDNT_RCPT_ID"
    );

-----------------------------------------PROOF_OF_INSURANCE_ISSUE PK SETTING-----------------------------------------
ALTER TABLE FINTECH."PROOF_OF_INSURANCE_ISSUE" ADD CONSTRAINT "PK_PROOF_OF_INSURANCE_ISSUE" PRIMARY KEY (
                                                                                                 "ISSU_SEQ",
                                                                                                 "ACDNT_RCPT_ID"
    );

-----------------------------------------ACCIDENT_VISUAL_EVIDENCE PK SETTING-----------------------------------------
ALTER TABLE FINTECH."ACCIDENT_VISUAL_EVIDENCE" ADD CONSTRAINT "PK_ACCIDENT_VISUAL_EVIDENCE" PRIMARY KEY (
                                                                                                 "ID"
    );

-----------------------------------------TOWARD_PERSONNEL PK SETTING-----------------------------------------
ALTER TABLE FINTECH."TOWARD_PERSONNEL" ADD CONSTRAINT "PK_TOWARD_PERSONNEL" PRIMARY KEY (
                                                                                 "ID"
    );

-----------------------------------------PROPERTY_DAMAGE_HISTORY PK SETTING-----------------------------------------
ALTER TABLE FINTECH."PROPERTY_DAMAGE_HISTORY" ADD CONSTRAINT "PK_PROPERTY_DAMAGE_HISTORY" PRIMARY KEY (
                                                                                               "CHG_CNT",
                                                                                               "SC",
                                                                                               "TWD_PRPTY_ID"
    );

-----------------------------------------PROPERTY_DAMAGE PK SETTING-----------------------------------------
ALTER TABLE FINTECH."PROPERTY_DAMAGE" ADD CONSTRAINT "PK_PROPERTY_DAMAGE" PRIMARY KEY (
                                                                               "ID"
    );

-----------------------------------------TOWARD_PERSONNEL_HOSPITAL_REL PK SETTING-----------------------------------------
ALTER TABLE FINTECH."TOWARD_PERSONNEL_HOSPITAL_REL" ADD CONSTRAINT "PK_TOWARD_PERSONNEL_HOSPITAL_REL" PRIMARY KEY (
                                                                                                           "ID"
    );

-----------------------------------------HOSPITAL PK SETTING-----------------------------------------
ALTER TABLE FINTECH."HOSPITAL" ADD CONSTRAINT "PK_HOSPITAL" PRIMARY KEY (
                                                                 "ID"
    );

-----------------------------------------PAYMENT_GUARANTEE PK SETTING-----------------------------------------
ALTER TABLE FINTECH."PAYMENT_GUARANTEE" ADD CONSTRAINT "PK_PAYMENT_GUARANTEE" PRIMARY KEY (
                                                                                   "ID"
    );

-----------------------------------------PAYMENT_GUARANTEE_HISTORY PK SETTING-----------------------------------------
ALTER TABLE FINTECH."PAYMENT_GUARANTEE_HISTORY" ADD CONSTRAINT "PK_PAYMENT_GUARANTEE_HISTORY" PRIMARY KEY (
                                                                                                   "CHG_CNT",
                                                                                                   "PAY_GRNTE_ID"
    );

-----------------------------------------POLICE_AGENCY_INVOLVEMENT PK SETTING-----------------------------------------
ALTER TABLE FINTECH."POLICE_AGENCY_INVOLVEMENT" ADD CONSTRAINT "PK_POLICE_AGENCY_INVOLVEMENT" PRIMARY KEY (
                                                                                                   "ID"
    );

-----------------------------------------TOWARD_PERSONNEL_HISTORY PK SETTING-----------------------------------------
ALTER TABLE FINTECH."TOWARD_PERSONNEL_HISTORY" ADD CONSTRAINT "PK_TOWARD_PERSONNEL_HISTORY" PRIMARY KEY (
                                                                                                 "CHG_CNT",
                                                                                                 "TWD_PSN_ID"
    );


-----------------------------------------EMPLOYEE FK SETTING-----------------------------------------
ALTER TABLE FINTECH."EMPLOYEE" ADD CONSTRAINT "FK_DEPARTMENT_TO_EMPLOYEE_1" FOREIGN KEY ( 
                                                                                 "DEPT_ID" 
    ) 
    REFERENCES FINTECH."DEPARTMENT" ( 
                             "ID" 
        ); 
 

-----------------------------------------EMPLOYEE FK SETTING-----------------------------------------
ALTER TABLE FINTECH."EMPLOYEE" ADD CONSTRAINT "FK_JOB_POSITION_TO_EMPLOYEE_1" FOREIGN KEY ( 
                                                                                   "JBPS_ID" 
    ) 
    REFERENCES FINTECH."JOB_POSITION" ( 
                               "ID" 
        ); 
 

-----------------------------------------EMPLOYEE FK SETTING-----------------------------------------
ALTER TABLE FINTECH."EMPLOYEE" ADD CONSTRAINT "FK_JOB_TITLE_TO_EMPLOYEE_1" FOREIGN KEY ( 
                                                                                "JBTTL_ID" 
    ) 
    REFERENCES FINTECH."JOB_TITLE" ( 
                            "ID" 
        ); 
 

-----------------------------------------UNION_EMPLOYEE_REL FK SETTING-----------------------------------------
ALTER TABLE FINTECH."UNION_EMPLOYEE_REL" ADD CONSTRAINT "FK_UNION_TO_UNION_EMPLOYEE_REL_1" FOREIGN KEY ( 
                                                                                                "UNION_ID" 
    ) 
    REFERENCES FINTECH."UNION" ( 
                        "ID" 
        ); 
 

-----------------------------------------UNION_EMPLOYEE_REL FK SETTING-----------------------------------------
ALTER TABLE FINTECH."UNION_EMPLOYEE_REL" ADD CONSTRAINT "FK_EMPLOYEE_TO_UNION_EMPLOYEE_REL_1" FOREIGN KEY ( 
                                                                                                   "EMP_ID" 
    ) 
    REFERENCES FINTECH."EMPLOYEE" ( 
                           "ID" 
        ); 
 

-----------------------------------------PERSONAL_CUSTOMER FK SETTING-----------------------------------------
ALTER TABLE FINTECH."PERSONAL_CUSTOMER" ADD CONSTRAINT "FK_CUSTOMER_TO_PERSONAL_CUSTOMER_1" FOREIGN KEY ( 
                                                                                                 "CUST_ID" 
    ) 
    REFERENCES FINTECH."CUSTOMER" ( 
                           "ID" 
        ); 
 

-----------------------------------------UNION FK SETTING-----------------------------------------
ALTER TABLE FINTECH."UNION" ADD CONSTRAINT "FK_CUSTOMER_TO_UNION_1" FOREIGN KEY ( 
                                                                         "CUST_ID" 
    ) 
    REFERENCES FINTECH."CUSTOMER" ( 
                           "ID" 
        ); 
 

-----------------------------------------RIDER_UNION_REL FK SETTING-----------------------------------------
ALTER TABLE FINTECH."RIDER_UNION_REL" ADD CONSTRAINT "FK_UNION_TO_RIDER_UNION_REL_1" FOREIGN KEY ( 
                                                                                          "UNION_ID" 
    ) 
    REFERENCES FINTECH."UNION" ( 
                        "ID" 
        ); 
 

-----------------------------------------RIDER_UNION_REL FK SETTING-----------------------------------------
ALTER TABLE FINTECH."RIDER_UNION_REL" ADD CONSTRAINT "FK_RIDER_TO_RIDER_UNION_REL_1" FOREIGN KEY ( 
                                                                                          "RIDER_ID" 
    ) 
    REFERENCES FINTECH."RIDER" ( 
                        "ID" 
        ); 
 
 

-----------------------------------------RIDER FK SETTING-----------------------------------------
ALTER TABLE FINTECH."RIDER" ADD CONSTRAINT "FK_PERSONAL_CUSTOMER_TO_RIDER_1" FOREIGN KEY ( 
                                                                                  "PRCUST_ID" 
    ) 
    REFERENCES FINTECH."PERSONAL_CUSTOMER" ( 
                                    "ID" 
        ); 
 

-----------------------------------------DISCUSSION FK SETTING-----------------------------------------
ALTER TABLE FINTECH."DISCUSSION" ADD CONSTRAINT "FK_CUSTOMER_TO_DISCUSSION_1" FOREIGN KEY ( 
                                                                                   "CUST_ID" 
    ) 
    REFERENCES FINTECH."CUSTOMER" ( 
                           "ID" 
        ); 
 

-----------------------------------------CUSTOMER_TERMS_REL FK SETTING-----------------------------------------
ALTER TABLE FINTECH."CUSTOMER_TERMS_REL" ADD CONSTRAINT "FK_CUSTOMER_TO_CUSTOMER_TERMS_REL_1" FOREIGN KEY ( 
                                                                                                   "CUST_ID" 
    ) 
    REFERENCES FINTECH."CUSTOMER" ( 
                           "ID" 
        ); 
 

-----------------------------------------CUSTOMER_TERMS_REL FK SETTING-----------------------------------------
ALTER TABLE FINTECH."CUSTOMER_TERMS_REL" ADD CONSTRAINT "FK_TERMS_TO_CUSTOMER_TERMS_REL_1" FOREIGN KEY ( 
                                                                                                "TERMS_ID" 
    ) 
    REFERENCES FINTECH."TERMS" ( 
                        "ID" 
        ); 
 

-----------------------------------------VEHICLE FK SETTING-----------------------------------------
ALTER TABLE FINTECH."VEHICLE" ADD CONSTRAINT "FK_CUSTOMER_TO_VEHICLE_1" FOREIGN KEY ( 
                                                                             "CUST_ID" 
    ) 
    REFERENCES FINTECH."CUSTOMER" ( 
                           "ID" 
        ); 
 

-----------------------------------------VEHICLE_FILE FK SETTING-----------------------------------------
ALTER TABLE FINTECH."VEHICLE_FILE" ADD CONSTRAINT "FK_VEHICLE_TO_VEHICLE_FILE_1" FOREIGN KEY ( 
                                                                                      "VHCL_ID" 
    ) 
    REFERENCES FINTECH."VEHICLE" ( 
                          "ID" 
        ); 
 

-----------------------------------------ADDRESS_MEMBER_REL FK SETTING-----------------------------------------
ALTER TABLE FINTECH."ADDRESS_MEMBER_REL" ADD CONSTRAINT "FK_ADDRESS_TO_ADDRESS_MEMBER_REL_1" FOREIGN KEY ( 
                                                                                                  "ADDR_ID" 
    ) 
    REFERENCES FINTECH."ADDRESS" ( 
                          "ID" 
        ); 
 

-----------------------------------------ADDRESS_MEMBER_REL FK SETTING-----------------------------------------
ALTER TABLE FINTECH."ADDRESS_MEMBER_REL" ADD CONSTRAINT "FK_PERSONAL_CUSTOMER_TO_ADDRESS_MEMBER_REL_1" FOREIGN KEY ( 
                                                                                                            "PRCUST_ID" 
    ) 
    REFERENCES FINTECH."PERSONAL_CUSTOMER" ( 
                                    "ID" 
        ); 
 

-----------------------------------------CONTRACT_DESIGN FK SETTING-----------------------------------------
ALTER TABLE FINTECH."CONTRACT_DESIGN" ADD CONSTRAINT "FK_CUSTOMER_TO_CONTRACT_DESIGN_1" FOREIGN KEY ( 
                                                                                             "CUST_ID" 
    ) 
    REFERENCES FINTECH."CUSTOMER" ( 
                           "ID" 
        ); 
 

-----------------------------------------CONTRACT_DESIGN_FILE FK SETTING-----------------------------------------
ALTER TABLE FINTECH."CONTRACT_DESIGN_FILE" ADD CONSTRAINT "FK_CONTRACT_DESIGN_TO_CONTRACT_DESIGN_FILE_1" FOREIGN KEY ( 
                                                                                                              "CTRT_DESIGN_ID" 
    ) 
    REFERENCES FINTECH."CONTRACT_DESIGN" ( 
                                  "ID" 
        ); 
 

-----------------------------------------ADDRESS_CONTRACT_CUSTOMER_REL FK SETTING-----------------------------------------
ALTER TABLE FINTECH."ADDRESS_CONTRACT_CUSTOMER_REL" ADD CONSTRAINT "FK_CONTRACT_CUSTOMER_REL_TO_ADDRESS_CONTRACT_CUSTOMER_REL_1" FOREIGN KEY ( 
                                                                                                                                      "CTRT_CUST_ID" 
    ) 
    REFERENCES FINTECH."CONTRACT_CUSTOMER_REL" ( 
                                        "ID" 
        ); 
 

-----------------------------------------ADDRESS_CONTRACT_CUSTOMER_REL FK SETTING-----------------------------------------
ALTER TABLE FINTECH."ADDRESS_CONTRACT_CUSTOMER_REL" ADD CONSTRAINT "FK_ADDRESS_TO_ADDRESS_CONTRACT_CUSTOMER_REL_1" FOREIGN KEY ( 
                                                                                                                        "ADDR_ID" 
    ) 
    REFERENCES FINTECH."ADDRESS" ( 
                          "ID" 
        ); 
 

-----------------------------------------CONTRACT_CUSTOMER_REL FK SETTING-----------------------------------------
ALTER TABLE FINTECH."CONTRACT_CUSTOMER_REL" ADD CONSTRAINT "FK_CONTRACT_TO_CONTRACT_CUSTOMER_REL_1" FOREIGN KEY ( 
                                                                                                         "CTRT_ID" 
    ) 
    REFERENCES FINTECH."CONTRACT" ( 
                           "ID" 
        ); 
 

-----------------------------------------CONTRACT_CUSTOMER_REL FK SETTING-----------------------------------------
ALTER TABLE FINTECH."CONTRACT_CUSTOMER_REL" ADD CONSTRAINT "FK_CUSTOMER_TO_CONTRACT_CUSTOMER_REL_1" FOREIGN KEY ( 
                                                                                                         "CUST_ID" 
    ) 
    REFERENCES FINTECH."CUSTOMER" ( 
                           "ID" 
        ); 
 

-----------------------------------------CONTRACT_VEHICLE_REL FK SETTING-----------------------------------------
ALTER TABLE FINTECH."CONTRACT_VEHICLE_REL" ADD CONSTRAINT "FK_CONTRACT_TO_CONTRACT_VEHICLE_REL_1" FOREIGN KEY ( 
                                                                                                       "CTRT_ID" 
    ) 
    REFERENCES FINTECH."CONTRACT" ( 
                           "ID" 
        ); 
 

-----------------------------------------CONTRACT_VEHICLE_REL FK SETTING-----------------------------------------
ALTER TABLE FINTECH."CONTRACT_VEHICLE_REL" ADD CONSTRAINT "FK_VEHICLE_TO_CONTRACT_VEHICLE_REL_1" FOREIGN KEY ( 
                                                                                                      "VHCL_ID" 
    ) 
    REFERENCES FINTECH."VEHICLE" ( 
                          "ID" 
        ); 
 

-----------------------------------------ENDORSE FK SETTING-----------------------------------------
ALTER TABLE FINTECH."ENDORSE" ADD CONSTRAINT "FK_CONTRACT_TO_ENDORSE_1" FOREIGN KEY ( 
                                                                             "CTRT_ID" 
    ) 
    REFERENCES FINTECH."CONTRACT" ( 
                           "ID" 
        ); 
 

-----------------------------------------ENDORSE_CHANGE FK SETTING-----------------------------------------
ALTER TABLE FINTECH."ENDORSE_CHANGE" ADD CONSTRAINT "FK_ENDORSE_TO_ENDORSE_CHANGE_1" FOREIGN KEY ( 
                                                                                          "ENDRS_ID" 
    ) 
    REFERENCES FINTECH."ENDORSE" ( 
                          "ID" 
        ); 
 

-----------------------------------------INSURANCE_HISTORY FK SETTING-----------------------------------------
ALTER TABLE FINTECH."INSURANCE_HISTORY" ADD CONSTRAINT "FK_CONTRACT_TO_INSURANCE_HISTORY_1" FOREIGN KEY ( 
                                                                                                 "CTRT_ID" 
    ) 
    REFERENCES FINTECH."CONTRACT" ( 
                           "ID" 
        ); 
 
 

-----------------------------------------DAMAGE_EXAMINATION_HISTORY FK SETTING-----------------------------------------
ALTER TABLE FINTECH."DAMAGE_EXAMINATION_HISTORY" ADD CONSTRAINT "FK_DAMAGE_EXAMINATION_TO_DAMAGE_EXAMINATION_HISTORY_1" FOREIGN KEY ( 
                                                                                                                             "ACDNT_EXMN_ID" 
    ) 
    REFERENCES FINTECH."DAMAGE_EXAMINATION" ( 
                                     "ID" 
        ); 
 

-----------------------------------------DAMAGE_EXAMINATION_HISTORY FK SETTING-----------------------------------------
ALTER TABLE FINTECH."DAMAGE_EXAMINATION_HISTORY" ADD CONSTRAINT "FK_ACCIDENT_RECEIPT_TO_DAMAGE_EXAMINATION_HISTORY_1" FOREIGN KEY ( 
                                                                                                                           "ACDNT_RCPT_ID" 
    ) 
    REFERENCES FINTECH."ACCIDENT_RECEIPT" ( 
                                   "ID" 
        ); 
 

-----------------------------------------ACCIDENT_RECEIPT_SCREEN_HISTORY FK SETTING-----------------------------------------
ALTER TABLE FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY" ADD CONSTRAINT "FK_ACCIDENT_RECEIPT_TO_ACCIDENT_RECEIPT_SCREEN_HISTORY_1" FOREIGN KEY ( 
                                                                                                                                     "ACDNT_RCPT_ID" 
    ) 
    REFERENCES FINTECH."ACCIDENT_RECEIPT" ( 
                                   "ID" 
        ); 
 

-----------------------------------------DAMAGE_EXAMINATION FK SETTING-----------------------------------------
ALTER TABLE FINTECH."DAMAGE_EXAMINATION" ADD CONSTRAINT "FK_ACCIDENT_RECEIPT_TO_DAMAGE_EXAMINATION_1" FOREIGN KEY ( 
                                                                                                           "ACDNT_RCPT_ID" 
    ) 
    REFERENCES FINTECH."ACCIDENT_RECEIPT" ( 
                                   "ID" 
        ); 
 

-----------------------------------------OTS_DISPATCH_REPORT FK SETTING-----------------------------------------
ALTER TABLE FINTECH."OTS_DISPATCH_REPORT" ADD CONSTRAINT "FK_ACCIDENT_RECEIPT_TO_OTS_DISPATCH_REPORT_1" FOREIGN KEY ( 
                                                                                                             "ACDNT_RCPT_ID" 
    ) 
    REFERENCES FINTECH."ACCIDENT_RECEIPT" ( 
                                   "ID" 
        ); 
 

-----------------------------------------BIG_ACCIDENT_DETAIL FK SETTING-----------------------------------------
ALTER TABLE FINTECH."BIG_ACCIDENT_DETAIL" ADD CONSTRAINT "FK_BIG_ACCIDENT_INFO_TO_BIG_ACCIDENT_DETAIL_1" FOREIGN KEY ( 
                                                                                                              "ACDNT_RCPT_ID" 
    ) 
    REFERENCES FINTECH."BIG_ACCIDENT_INFO" ( 
                                    "ACDNT_RCPT_ID" 
        ); 
 

-----------------------------------------BIG_ACCIDENT_INFO FK SETTING-----------------------------------------
ALTER TABLE FINTECH."BIG_ACCIDENT_INFO" ADD CONSTRAINT "FK_ACCIDENT_RECEIPT_TO_BIG_ACCIDENT_INFO_1" FOREIGN KEY ( 
                                                                                                         "ACDNT_RCPT_ID" 
    ) 
    REFERENCES FINTECH."ACCIDENT_RECEIPT" ( 
                                   "ID" 
        ); 
 

-----------------------------------------BIG_ACCIDENT_DETAIL_HISTORY FK SETTING-----------------------------------------
ALTER TABLE FINTECH."BIG_ACCIDENT_DETAIL_HISTORY" ADD CONSTRAINT "FK_BIG_ACCIDENT_DETAIL_TO_BIG_ACCIDENT_DETAIL_HISTORY_1" FOREIGN KEY ( 
                                                                                                                                "BIG_ACDNT_DMGE_CN_ID" 
    ) 
    REFERENCES FINTECH."BIG_ACCIDENT_DETAIL" ( 
                                      "ID" 
        ); 
 

-----------------------------------------BIG_ACCIDENT_DETAIL_HISTORY FK SETTING-----------------------------------------
ALTER TABLE FINTECH."BIG_ACCIDENT_DETAIL_HISTORY" ADD CONSTRAINT "FK_BIG_ACCIDENT_INFO_TO_BIG_ACCIDENT_DETAIL_HISTORY_1" FOREIGN KEY ( 
                                                                                                                              "ACDNT_RCPT_ID" 
    ) 
    REFERENCES FINTECH."BIG_ACCIDENT_INFO" ( 
                                    "ACDNT_RCPT_ID" 
        ); 
 

-----------------------------------------BIG_ACCIDENT_INFO_HISTORY FK SETTING-----------------------------------------
ALTER TABLE FINTECH."BIG_ACCIDENT_INFO_HISTORY" ADD CONSTRAINT "FK_BIG_ACCIDENT_INFO_TO_BIG_ACCIDENT_INFO_HISTORY_1" FOREIGN KEY ( 
                                                                                                                          "ACDNT_RCPT_ID" 
    ) 
    REFERENCES FINTECH."BIG_ACCIDENT_INFO" ( 
                                    "ACDNT_RCPT_ID" 
        ); 
 

-----------------------------------------PROOF_OF_INSURANCE_ISSUE FK SETTING-----------------------------------------
ALTER TABLE FINTECH."PROOF_OF_INSURANCE_ISSUE" ADD CONSTRAINT "FK_ACCIDENT_RECEIPT_TO_PROOF_OF_INSURANCE_ISSUE_1" FOREIGN KEY ( 
                                                                                                                       "ACDNT_RCPT_ID" 
    ) 
    REFERENCES FINTECH."ACCIDENT_RECEIPT" ( 
                                   "ID" 
        ); 
 

-----------------------------------------ACCIDENT_VISUAL_EVIDENCE FK SETTING-----------------------------------------
ALTER TABLE FINTECH."ACCIDENT_VISUAL_EVIDENCE" ADD CONSTRAINT "FK_ACCIDENT_RECEIPT_TO_ACCIDENT_VISUAL_EVIDENCE_1" FOREIGN KEY ( 
                                                                                                                       "ACDNT_RCPT_ID" 
    ) 
    REFERENCES FINTECH."ACCIDENT_RECEIPT" ( 
                                   "ID" 
        ); 
 

-----------------------------------------TOWARD_PERSONNEL FK SETTING-----------------------------------------
ALTER TABLE FINTECH."TOWARD_PERSONNEL" ADD CONSTRAINT "FK_ACCIDENT_RECEIPT_TO_TOWARD_PERSONNEL_1" FOREIGN KEY ( 
                                                                                                       "ACDNT_RCPT_ID" 
    ) 
    REFERENCES FINTECH."ACCIDENT_RECEIPT" ( 
                                   "ID" 
        ); 
 

-----------------------------------------PROPERTY_DAMAGE_HISTORY FK SETTING-----------------------------------------
ALTER TABLE FINTECH."PROPERTY_DAMAGE_HISTORY" ADD CONSTRAINT "FK_PROPERTY_DAMAGE_TO_PROPERTY_DAMAGE_HISTORY_1" FOREIGN KEY ( 
                                                                                                                    "TWD_PRPTY_ID" 
    ) 
    REFERENCES FINTECH."PROPERTY_DAMAGE" ( 
                                  "ID" 
        ); 
 

-----------------------------------------PROPERTY_DAMAGE_HISTORY FK SETTING-----------------------------------------
ALTER TABLE FINTECH."PROPERTY_DAMAGE_HISTORY" ADD CONSTRAINT "FK_ACCIDENT_RECEIPT_TO_PROPERTY_DAMAGE_HISTORY_1" FOREIGN KEY ( 
                                                                                                                     "ACDNT_RCPT_ID" 
    ) 
    REFERENCES FINTECH."ACCIDENT_RECEIPT" ( 
                                   "ID" 
        ); 
 

-----------------------------------------PROPERTY_DAMAGE FK SETTING-----------------------------------------
ALTER TABLE FINTECH."PROPERTY_DAMAGE" ADD CONSTRAINT "FK_ACCIDENT_RECEIPT_TO_PROPERTY_DAMAGE_1" FOREIGN KEY ( 
                                                                                                     "ACDNT_RCPT_ID" 
    ) 
    REFERENCES FINTECH."ACCIDENT_RECEIPT" ( 
                                   "ID" 
        ); 
 

-----------------------------------------TOWARD_PERSONNEL_HOSPITAL_REL FK SETTING-----------------------------------------
ALTER TABLE FINTECH."TOWARD_PERSONNEL_HOSPITAL_REL" ADD CONSTRAINT "FK_HOSPITAL_TO_TOWARD_PERSONNEL_HOSPITAL_REL_1" FOREIGN KEY ( 
                                                                                                                         "HSPTL_ID" 
    ) 
    REFERENCES FINTECH."HOSPITAL" ( 
                           "ID" 
        ); 
 

-----------------------------------------TOWARD_PERSONNEL_HOSPITAL_REL FK SETTING-----------------------------------------
ALTER TABLE FINTECH."TOWARD_PERSONNEL_HOSPITAL_REL" ADD CONSTRAINT "FK_TOWARD_PERSONNEL_TO_TOWARD_PERSONNEL_HOSPITAL_REL_1" FOREIGN KEY ( 
                                                                                                                                 "TWD_PSN_ID" 
    ) 
    REFERENCES FINTECH."TOWARD_PERSONNEL" ( 
                                   "ID" 
        ); 
 

-----------------------------------------PAYMENT_GUARANTEE FK SETTING-----------------------------------------
ALTER TABLE FINTECH."PAYMENT_GUARANTEE" ADD CONSTRAINT "FK_TOWARD_PERSONNEL_TO_PAYMENT_GUARANTEE_1" FOREIGN KEY ( 
                                                                                                         "TWD_PSN_ID" 
    ) 
    REFERENCES FINTECH."TOWARD_PERSONNEL" ( 
                                   "ID" 
        ); 
 

-----------------------------------------PAYMENT_GUARANTEE FK SETTING-----------------------------------------
ALTER TABLE FINTECH."PAYMENT_GUARANTEE" ADD CONSTRAINT "FK_HOSPITAL_TO_PAYMENT_GUARANTEE_1" FOREIGN KEY ( 
                                                                                                 "HSPTL_ID" 
    ) 
    REFERENCES FINTECH."HOSPITAL" ( 
                           "ID" 
        ); 
 

-----------------------------------------PAYMENT_GUARANTEE_HISTORY FK SETTING-----------------------------------------
ALTER TABLE FINTECH."PAYMENT_GUARANTEE_HISTORY" ADD CONSTRAINT "FK_PAYMENT_GUARANTEE_TO_PAYMENT_GUARANTEE_HISTORY_1" FOREIGN KEY ( 
                                                                                                                          "PAY_GRNTE_ID" 
    ) 
    REFERENCES FINTECH."PAYMENT_GUARANTEE" ( 
                                    "ID" 
        ); 
 

-----------------------------------------PAYMENT_GUARANTEE_HISTORY FK SETTING-----------------------------------------
ALTER TABLE FINTECH."PAYMENT_GUARANTEE_HISTORY" ADD CONSTRAINT "FK_TOWARD_PERSONNEL_TO_PAYMENT_GUARANTEE_HISTORY_1" FOREIGN KEY ( 
                                                                                                                         "TWD_PSN_ID" 
    ) 
    REFERENCES FINTECH."TOWARD_PERSONNEL" ( 
                                   "ID" 
        ); 
 

-----------------------------------------PAYMENT_GUARANTEE_HISTORY FK SETTING-----------------------------------------
ALTER TABLE FINTECH."PAYMENT_GUARANTEE_HISTORY" ADD CONSTRAINT "FK_HOSPITAL_TO_PAYMENT_GUARANTEE_HISTORY_1" FOREIGN KEY ( 
                                                                                                                 "HSPTL_ID" 
    ) 
    REFERENCES FINTECH."HOSPITAL" ( 
                           "ID" 
        ); 
 

-----------------------------------------POLICE_AGENCY_INVOLVEMENT FK SETTING-----------------------------------------
ALTER TABLE FINTECH."POLICE_AGENCY_INVOLVEMENT" ADD CONSTRAINT "FK_PROOF_OF_INSURANCE_ISSUE_TO_POLICE_AGENCY_INVOLVEMENT_1" FOREIGN KEY ( 
                                                                                                                                 "ISSU_SEQ",
                                                                                                                                 "ACDNT_RCPT_ID"
    ) 
    REFERENCES FINTECH."PROOF_OF_INSURANCE_ISSUE" ( 
                                           "ISSU_SEQ",
                                           "ACDNT_RCPT_ID"
        );

-----------------------------------------TOWARD_PERSONNEL_HISTORY FK SETTING-----------------------------------------
ALTER TABLE FINTECH."TOWARD_PERSONNEL_HISTORY" ADD CONSTRAINT "FK_TOWARD_PERSONNEL_TO_TOWARD_PERSONNEL_HISTORY_1" FOREIGN KEY ( 
                                                                                                                       "TWD_PSN_ID" 
    ) 
    REFERENCES FINTECH."TOWARD_PERSONNEL" ( 
                                   "ID" 
        ); 
 

-----------------------------------------TOWARD_PERSONNEL_HISTORY FK SETTING-----------------------------------------
ALTER TABLE FINTECH."TOWARD_PERSONNEL_HISTORY" ADD CONSTRAINT "FK_ACCIDENT_RECEIPT_TO_TOWARD_PERSONNEL_HISTORY_1" FOREIGN KEY ( 
                                                                                                                       "ACDNT_RCPT_ID" 
    ) 
    REFERENCES FINTECH."ACCIDENT_RECEIPT" ( 
                                   "ID" 
        ); 
 
-----------------------------------------SEQUENCE SETTING -----------------------------------------

CREATE SEQUENCE FINTECH."DEPARTMENT_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."JOB_TITLE_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."JOB_POSITION_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."EMPLOYEE_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."UNION_EMPLOYEE_REL_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."CUSTOMER_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."PERSONAL_CUSTOMER_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."UNION_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."RIDER_UNION_REL_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."RIDER_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."DISCUSSION_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."TERMS_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."CUSTOMER_TERMS_REL_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."VEHICLE_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."VEHICLE_FILE_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."ADDRESS_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."ADDRESS_MEMBER_REL_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."CONTRACT_DESIGN_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."CONTRACT_DESIGN_FILE_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."ADDRESS_CONTRACT_CUSTOMER_REL_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."CONTRACT_CUSTOMER_REL_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."CONTRACT_VEHICLE_REL_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."CONTRACT_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."ENDORSE_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."ENDORSE_CHANGE_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."INSURANCE_HISTORY_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."DAMAGE_EXAMINATION_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."ACCIDENT_RECEIPT_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."OTS_DISPATCH_REPORT_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."BIG_ACCIDENT_DETAIL_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."ACCIDENT_VISUAL_EVIDENCE_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."TOWARD_PERSONNEL_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."PROPERTY_DAMAGE_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."TOWARD_PERSONNEL_HOSPITAL_REL_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."HOSPITAL_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."PAYMENT_GUARANTEE_SEQ" INCREMENT BY 1 START WITH 1 ORDER;
CREATE SEQUENCE FINTECH."POLICE_AGENCY_INVOLVEMENT_SEQ" INCREMENT BY 1 START WITH 1 ORDER;


-----------------------------------------TABLE COMMENT-----------------------------------------

COMMENT ON TABLE FINTECH."DEPARTMENT" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."JOB_TITLE" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."JOB_POSITION" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."EMPLOYEE" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."UNION_EMPLOYEE_REL" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."CUSTOMER" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."PERSONAL_CUSTOMER" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."UNION" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."RIDER_UNION_REL" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."RIDER" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."DISCUSSION" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."TERMS" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."CUSTOMER_TERMS_REL" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."VEHICLE" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."VEHICLE_FILE" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."ADDRESS" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."ADDRESS_MEMBER_REL" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."CONTRACT_DESIGN" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."CONTRACT_DESIGN_FILE" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."ADDRESS_CONTRACT_CUSTOMER_REL" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."CONTRACT_CUSTOMER_REL" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."CONTRACT_VEHICLE_REL" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."CONTRACT" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."ENDORSE" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."ENDORSE_CHANGE" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."INSURANCE_HISTORY" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."DAMAGE_EXAMINATION_HISTORY" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."ACCIDENT_RECEIPT_SCREEN_HISTORY" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."DAMAGE_EXAMINATION" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."ACCIDENT_RECEIPT" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."OTS_DISPATCH_REPORT" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."BIG_ACCIDENT_DETAIL" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."BIG_ACCIDENT_INFO" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."BIG_ACCIDENT_DETAIL_HISTORY" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."BIG_ACCIDENT_INFO_HISTORY" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."PROOF_OF_INSURANCE_ISSUE" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."ACCIDENT_VISUAL_EVIDENCE" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."TOWARD_PERSONNEL" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."PROPERTY_DAMAGE_HISTORY" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."PROPERTY_DAMAGE" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."TOWARD_PERSONNEL_HOSPITAL_REL" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."HOSPITAL" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."PAYMENT_GUARANTEE" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."PAYMENT_GUARANTEE_HISTORY" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."POLICE_AGENCY_INVOLVEMENT" IS 'TABLE COMMENT 작성';
COMMENT ON TABLE FINTECH."TOWARD_PERSONNEL_HISTORY" IS 'TABLE COMMENT 작성';