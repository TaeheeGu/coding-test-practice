-- 직원 Table

CREATE TABLE "DEPARTMENT" (
                              "ID"	NUMBER(38, 0)		NOT NULL,
                              "NM"	VARCHAR(255)		NULL,
                              "CREATED_AT"	TIMESTAMP		NULL,
                              "UPDATED_AT"	TIMESTAMP		NULL
);

COMMENT ON COLUMN "DEPARTMENT"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "DEPARTMENT"."NM" IS '*NAME / 부서 이름';

ALTER TABLE "DEPARTMENT" ADD CONSTRAINT "PK_DEPARTMENT" PRIMARY KEY (
                                                                     "ID"
    );

CREATE TABLE "JOB_TITLE" (
                             "ID"	NUMBER(38, 0)		NOT NULL,
                             "NM"	VARCHAR(255)		NULL,
                             "CREATED_AT"	TIMESTAMP		NULL,
                             "UPDATED_AT"	TIMESTAMP		NULL
);

COMMENT ON COLUMN "JOB_TITLE"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "JOB_TITLE"."NM" IS '*NAME / 직책 이름';

ALTER TABLE "JOB_TITLE" ADD CONSTRAINT "PK_JOB_TITLE" PRIMARY KEY (
                                                                   "ID"
    );

CREATE TABLE "JOB_POSITION" (
                                "ID"	NUMBER(38, 0)		NOT NULL,
                                "NM"	VARCHAR(255)		NULL,
                                "CREATED_AT"	TIMESTAMP		NULL,
                                "UPDATED_AT"	DATE		NULL
);

COMMENT ON COLUMN "JOB_POSITION"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "JOB_POSITION"."NM" IS '*NAME / 직위 이름';

ALTER TABLE "JOB_POSITION" ADD CONSTRAINT "PK_JOB_POSITION" PRIMARY KEY (
                                                                         "ID"
    );

CREATE TABLE "EMPLOYEE" (
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

COMMENT ON COLUMN "EMPLOYEE"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "EMPLOYEE"."DEPT_ID" IS '*DEPARTMENT ID / 부서 ID';

COMMENT ON COLUMN "EMPLOYEE"."JBPS_ID" IS '*JOB POSITION ID / 직위 ID';

COMMENT ON COLUMN "EMPLOYEE"."JBTTL_ID" IS '*JOB TITLE ID / 직책 ID';

COMMENT ON COLUMN "EMPLOYEE"."NO" IS '*NUMBER / 직원 번호(사번)';

COMMENT ON COLUMN "EMPLOYEE"."NM" IS '*NAME / 직원 이름';

COMMENT ON COLUMN "EMPLOYEE"."FXNO" IS '*FAX NUMBER / 팩스 번호';

COMMENT ON COLUMN "EMPLOYEE"."EML" IS '*EMAIL / 이메일';

COMMENT ON COLUMN "EMPLOYEE"."TEL" IS '*TEL / 연락처';

ALTER TABLE "EMPLOYEE" ADD CONSTRAINT "PK_EMPLOYEE" PRIMARY KEY (
                                                                 "ID"
    );

ALTER TABLE "EMPLOYEE" ADD CONSTRAINT "FK_DEPARTMENT_TO_EMPLOYEE_1" FOREIGN KEY (
                                                                                 "DEPT_ID"
    )
    REFERENCES "DEPARTMENT" (
                             "ID"
        );

ALTER TABLE "EMPLOYEE" ADD CONSTRAINT "FK_JOB_POSITION_TO_EMPLOYEE_1" FOREIGN KEY (
                                                                                   "JBPS_ID"
    )
    REFERENCES "JOB_POSITION" (
                               "ID"
        );

ALTER TABLE "EMPLOYEE" ADD CONSTRAINT "FK_JOB_TITLE_TO_EMPLOYEE_1" FOREIGN KEY (
                                                                                "JBTTL_ID"
    )
    REFERENCES "JOB_TITLE" (
                            "ID"
        );

CREATE TABLE "UNION_EMPLOYEE_REL" (
                                      "ID"	NUMBER(38, 0)		NOT NULL,
                                      "UNION_ID"	NUMBER(38, 0)		NOT NULL,
                                      "EMP_ID"	NUMBER(38, 0)		NOT NULL,
                                      "CREATED_AT"	TIMESTAMP		NULL,
                                      "UPDATED_AT"	TIMESTAMP		NULL
);

COMMENT ON COLUMN "UNION_EMPLOYEE_REL"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "UNION_EMPLOYEE_REL"."UNION_ID" IS '*UNION ID / 조합원 ID';

COMMENT ON COLUMN "UNION_EMPLOYEE_REL"."EMP_ID" IS '*EMPLOYEE ID / 직원 ID';

ALTER TABLE "UNION_EMPLOYEE_REL" ADD CONSTRAINT "PK_UNION_EMPLOYEE_REL" PRIMARY KEY (
                                                                                     "ID"
    );

ALTER TABLE "UNION_EMPLOYEE_REL" ADD CONSTRAINT "FK_UNION_TO_UNION_EMPLOYEE_REL_1" FOREIGN KEY (
                                                                                                "UNION_ID"
    )
    REFERENCES "UNION" (
                        "ID"
        );

ALTER TABLE "UNION_EMPLOYEE_REL" ADD CONSTRAINT "FK_EMPLOYEE_TO_UNION_EMPLOYEE_REL_1" FOREIGN KEY (
                                                                                                   "EMP_ID"
    )
    REFERENCES "EMPLOYEE" (
                           "ID"
        );

-- 고객 Table

CREATE TABLE "CUSTOMER" (
                            "ID"	NUMBER(38, 0)		NOT NULL,
                            "TY"	VARCHAR(255)		NULL,
                            "CD"	VARCHAR(255)		NULL,
                            "CREATED_AT"	TIMESTAMP		NULL,
                            "UPDATED_AT"	TIMESTAMP		NULL
);

COMMENT ON COLUMN "CUSTOMER"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "CUSTOMER"."TY" IS '*TYPE / 고객 유형 / 종사자 , 조합원 , 미가입';

COMMENT ON COLUMN "CUSTOMER"."CD" IS '*CODE / 고객 코드';

ALTER TABLE "CUSTOMER" ADD CONSTRAINT "PK_CUSTOMER" PRIMARY KEY (
                                                                 "ID"
    );

CREATE TABLE "UNION" (
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

COMMENT ON COLUMN "UNION"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "UNION"."CUST_ID" IS '*CUSTOMER ID / 고객ID';

COMMENT ON COLUMN "UNION"."CD" IS '*CODE / 조합원 코드';

COMMENT ON COLUMN "UNION"."JOIN_DT" IS '*JOIN DATE / 가입일';

COMMENT ON COLUMN "UNION"."INVST_YN" IS '*INVESTMENT Y/N / 출자 여부';

COMMENT ON COLUMN "UNION"."BRNO" IS '*BUSINESS REGISTRATION NUMBER / 사업자 등록 번호';

COMMENT ON COLUMN "UNION"."RPRS_NM" IS '*REPRESENTATIVE NAME / 대표자 이름';

COMMENT ON COLUMN "UNION"."OPBIZ_YMD" IS '*OPENING OF BUSINESS YEAR MONTH DAY / 개업연월일, YYYYMMDD';

COMMENT ON COLUMN "UNION"."CORP_NM" IS '*CORPORATION NAME / 법인이름';

COMMENT ON COLUMN "UNION"."TY" IS '*TYPE / 유형';

COMMENT ON COLUMN "UNION"."ADDR" IS '*ADDERSS / 주소';

ALTER TABLE "UNION" ADD CONSTRAINT "PK_UNION" PRIMARY KEY (
                                                           "ID"
    );

ALTER TABLE "UNION" ADD CONSTRAINT "FK_CUSTOMER_TO_UNION_1" FOREIGN KEY (
                                                                         "CUST_ID"
    )
    REFERENCES "CUSTOMER" (
                           "ID"
        );

CREATE TABLE "PERSONAL_CUSTOMER" (
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

COMMENT ON COLUMN "PERSONAL_CUSTOMER"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "PERSONAL_CUSTOMER"."CUST_ID" IS '*CUSTOMER ID / 고객 ID';

COMMENT ON COLUMN "PERSONAL_CUSTOMER"."GENDER" IS '*GENDER / 성별 / F, M';

COMMENT ON COLUMN "PERSONAL_CUSTOMER"."RRNO" IS '*RESIDENT REGISTRATION NUMBER / 주민등록번호';

COMMENT ON COLUMN "PERSONAL_CUSTOMER"."JOIN_DT" IS '*JOIN DATE /  등록일';

COMMENT ON COLUMN "PERSONAL_CUSTOMER"."TEL" IS '*TELEPHONE / 휴대폰';

COMMENT ON COLUMN "PERSONAL_CUSTOMER"."NM" IS '*NAME / 이름';

COMMENT ON COLUMN "PERSONAL_CUSTOMER"."EML" IS '*EMAIL / 이메일';

ALTER TABLE "PERSONAL_CUSTOMER" ADD CONSTRAINT "PK_PERSONAL_CUSTOMER" PRIMARY KEY (
                                                                                   "ID"
    );

ALTER TABLE "PERSONAL_CUSTOMER" ADD CONSTRAINT "FK_CUSTOMER_TO_PERSONAL_CUSTOMER_1" FOREIGN KEY (
                                                                                                 "CUST_ID"
    )
    REFERENCES "CUSTOMER" (
                           "ID"
        );

CREATE TABLE "RIDER" (
                         "ID"	NUMBER(38, 0)		NOT NULL,
                         "PRCUST_ID"	NUMBER(38, 0)		NOT NULL,
                         "JOB_TY"	VARCHAR(255)		NULL,
                         "RISK_TY"	VARCHAR(255)		NULL,
                         "CREATED_AT"	TIMESTAMP		NULL,
                         "UPDATED_AT"	TIMESTAMP		NULL
);

COMMENT ON COLUMN "RIDER"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "RIDER"."PRCUST_ID" IS '*PERSONAL CUSTOMER ID / 개인 고객 ID';

COMMENT ON COLUMN "RIDER"."JOB_TY" IS '*JOB TYPE / 전업유형 / 전업, 부업';

COMMENT ON COLUMN "RIDER"."RISK_TY" IS '*RISK TYPE / 위험 유형';

ALTER TABLE "RIDER" ADD CONSTRAINT "PK_RIDER" PRIMARY KEY (
                                                           "ID"
    );

ALTER TABLE "RIDER" ADD CONSTRAINT "FK_PERSONAL_CUSTOMER_TO_RIDER_1" FOREIGN KEY (
                                                                                  "PRCUST_ID"
    )
    REFERENCES "PERSONAL_CUSTOMER" (
                                    "ID"
        );

CREATE TABLE "RIDER_UNION_REL" (
                                   "ID"	NUMBER(38, 0)		NOT NULL,
                                   "UNION_ID"	NUMBER(38, 0)		NOT NULL,
                                   "RIDER_ID"	NUMBER(38, 0)		NOT NULL,
                                   "CREATED_AT"	TIMESTAMP		NULL,
                                   "UPDATED_AT"	TIMESTAMP		NULL
);

COMMENT ON COLUMN "RIDER_UNION_REL"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "RIDER_UNION_REL"."UNION_ID" IS '*UNION ID / 조합원 ID';

COMMENT ON COLUMN "RIDER_UNION_REL"."RIDER_ID" IS '*RIDER ID / 라이더 ID';

ALTER TABLE "RIDER_UNION_REL" ADD CONSTRAINT "PK_RIDER_UNION_REL" PRIMARY KEY (
                                                                               "ID"
    );

ALTER TABLE "RIDER_UNION_REL" ADD CONSTRAINT "FK_UNION_TO_RIDER_UNION_REL_1" FOREIGN KEY (
                                                                                          "UNION_ID"
    )
    REFERENCES "UNION" (
                        "ID"
        );

ALTER TABLE "RIDER_UNION_REL" ADD CONSTRAINT "FK_RIDER_TO_RIDER_UNION_REL_1" FOREIGN KEY (
                                                                                          "RIDER_ID"
    )
    REFERENCES "RIDER" (
                        "ID"
        );

CREATE TABLE "TERMS" (
                         "ID"	NUMBER(38, 0)		NOT NULL,
                         "NM"	VARCHAR(255)		NULL,
                         "CD"	VARCHAR(255)		NULL,
                         "CN"	LONG		NULL,
                         "ESNTL_YN"	VARCHAR(1)	DEFAULT "N"	NULL,
                         "CREATED_AT"	TIMESTAMP		NULL,
                         "UPDATED_AT"	TIMESTAMP		NULL
);

COMMENT ON COLUMN "TERMS"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "TERMS"."NM" IS '*NAME / 약관 이름';

COMMENT ON COLUMN "TERMS"."CD" IS '*CODE / 약관 코드';

COMMENT ON COLUMN "TERMS"."CN" IS '*CONTENT / 약관 내용';

COMMENT ON COLUMN "TERMS"."ESNTL_YN" IS '*ESSENTIAL YN / 약관 필수 동의 여부';

ALTER TABLE "TERMS" ADD CONSTRAINT "PK_TERMS" PRIMARY KEY (
                                                           "ID"
    );

CREATE TABLE "CUSTOMER_TERMS_REL" (
                                      "ID"	NUMBER(38, 0)		NOT NULL,
                                      "CUST_ID"	NUMBER(38, 0)		NOT NULL,
                                      "TERMS_ID"	NUMBER(38, 0)		NOT NULL,
                                      "AGRE_DT"	TIMESTAMP		NULL,
                                      "CREATED_AT"	TIMESTAMP		NULL,
                                      "UPDATED_AT"	TIMESTAMP		NULL
);

COMMENT ON COLUMN "CUSTOMER_TERMS_REL"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "CUSTOMER_TERMS_REL"."CUST_ID" IS '*CUSTOMER ID / 고객 ID';

COMMENT ON COLUMN "CUSTOMER_TERMS_REL"."TERMS_ID" IS '*TERMS ID / 약관 ID';

COMMENT ON COLUMN "CUSTOMER_TERMS_REL"."AGRE_DT" IS '*AGREEMENT DATE / 동의 일시';

ALTER TABLE "CUSTOMER_TERMS_REL" ADD CONSTRAINT "PK_CUSTOMER_TERMS_REL" PRIMARY KEY (
                                                                                     "ID"
    );

ALTER TABLE "CUSTOMER_TERMS_REL" ADD CONSTRAINT "FK_CUSTOMER_TO_CUSTOMER_TERMS_REL_1" FOREIGN KEY (
                                                                                                   "CUST_ID"
    )
    REFERENCES "CUSTOMER" (
                           "ID"
        );

ALTER TABLE "CUSTOMER_TERMS_REL" ADD CONSTRAINT "FK_TERMS_TO_CUSTOMER_TERMS_REL_1" FOREIGN KEY (
                                                                                                "TERMS_ID"
    )
    REFERENCES "TERMS" (
                        "ID"
        );

CREATE TABLE "DISCUSSION" (
                              "ID"	NUMBER(38, 0)		NOT NULL,
                              "CUST_ID"	NUMBER(38, 0)		NOT NULL,
                              "NO"	VARCHAR(255)		NULL,
                              "PSBLTY_BGNG_HR"	NUMBER(38, 0)		NULL,
                              "PSBLTY_END_HR"	NUMBER(38, 0)		NULL,
                              "APLY_CN"	LONG		NULL,
                              "APLY_TY"	VARCHAR(255)		NULL,
                              "APLY_DT"	TIMESTAMP		NULL,
                              "STTS"	VARCHAR(255)		NULL,
                              "BGNG_DATE"	TIMESTAMP		NULL,
                              "END_DT"	TIMESTAMP		NULL,
                              "CN"	LONG		NULL,
                              "EMP_ID"	NUMBER(38, 0)		NULL,
                              "EMP_DEPT"	VARCHAR(255)		NULL,
                              "EMP_JBPS"	VARCHAR(255)		NULL,
                              "EMP_JBTTL"	VARCHAR(255)		NULL,
                              "CREATED_AT"	TIMESTAMP		NULL,
                              "UPDATED_AT"	TIMESTAMP		NULL
);

COMMENT ON COLUMN "DISCUSSION"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "DISCUSSION"."CUST_ID" IS '*CUSTOMER ID / 고객 ID';

COMMENT ON COLUMN "DISCUSSION"."NO" IS '*NUMBER / 상담 신청 번호';

COMMENT ON COLUMN "DISCUSSION"."PSBLTY_BGNG_HR" IS '*POSSIBILITY BEGINNING HOUR / 상담 가능 시작 시간';

COMMENT ON COLUMN "DISCUSSION"."PSBLTY_END_HR" IS '*POSSIBILITY END HOUR / 상담 가능 종료 시간';

COMMENT ON COLUMN "DISCUSSION"."APLY_CN" IS '*APPLY CONTENT / 상담 신청 내용';

COMMENT ON COLUMN "DISCUSSION"."APLY_TY" IS '*APPLY TYPE / 상담 신청 유형';

COMMENT ON COLUMN "DISCUSSION"."APLY_DT" IS '*APPLY DATE / 상담 신청 일시';

COMMENT ON COLUMN "DISCUSSION"."STTS" IS '*STATUS / 상담 상태 / 미진행, 완료, ...';

COMMENT ON COLUMN "DISCUSSION"."BGNG_DATE" IS '*BEGINNING DATE / 상담 시작 일시';

COMMENT ON COLUMN "DISCUSSION"."END_DT" IS '*END DATE / 상담 종료 일시';

COMMENT ON COLUMN "DISCUSSION"."CN" IS '*CONTENT / 상담 진행 내용';

COMMENT ON COLUMN "DISCUSSION"."EMP_ID" IS '*EMPLOYEE ID / 담당 직원 ID';

COMMENT ON COLUMN "DISCUSSION"."EMP_DEPT" IS '*EMPLOYEE DEPARTMENT / 담당 직원 부서';

COMMENT ON COLUMN "DISCUSSION"."EMP_JBPS" IS '*EMPLOYEE JOB POSITION / 담당 직원 직위';

COMMENT ON COLUMN "DISCUSSION"."EMP_JBTTL" IS '*EMPLOYEE JOB TITLE / 담당 직원 직책';

ALTER TABLE "DISCUSSION" ADD CONSTRAINT "PK_DISCUSSION" PRIMARY KEY (
                                                                     "ID"
    );

ALTER TABLE "DISCUSSION" ADD CONSTRAINT "FK_CUSTOMER_TO_DISCUSSION_1" FOREIGN KEY (
                                                                                   "CUST_ID"
    )
    REFERENCES "CUSTOMER" (
                           "ID"
        );

CREATE TABLE "VEHICLE" (
                           "ID"	NUMBER(38, 0)		NOT NULL,
                           "CUST_ID"	NUMBER(38, 0)		NOT NULL,
                           "REG_TY"	VARCHAR(255)		NULL,
                           "VHRNO"	VARCHAR(16)		NULL,
                           "VIN"	VARCHAR(17)		NULL,
                           "VHCL_REG_YMD"	TIMESTAMP		NULL,
                           "USG"	VARCHAR(255)		NULL,
                           "ERDR_YN"	VARCHAR(1)	DEFAULT "N"	NULL,
                           "DGST_YN"	VARCHAR(1)	DEFAULT "N"	NULL,
                           "DSPY_YN"	VARCHAR(1)	DEFAULT "N"	NULL,
                           "MCHN_YN"	VARCHAR(1)	DEFAULT "N"	NULL,
                           "STBLT_YN"	VARCHAR(1)	DEFAULT "N"	NULL,
                           "EMRG_GUT_YN"	VARCHAR(1)	DEFAULT "N"	NULL,
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

COMMENT ON COLUMN "VEHICLE"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "VEHICLE"."CUST_ID" IS '*CUSTOMER ID / 고객 ID';

COMMENT ON COLUMN "VEHICLE"."REG_TY" IS '*REGISTRATION TYPE / 등록 유형 / 이륜자동차사용신고필증, 차량/차대번호 등록, 구입예정, ...';

COMMENT ON COLUMN "VEHICLE"."VHRNO" IS '*VEHICLE NUMBER / 차량번호 / 16자리 이내 문자';

COMMENT ON COLUMN "VEHICLE"."VIN" IS '*VEHICLE IDENTIFICATION NUMBER / 차대 번호 / 17자리 이내 문자';

COMMENT ON COLUMN "VEHICLE"."VHCL_REG_YMD" IS '*VEHICLE REGISTRATION YEAR MONTH DAY / 차량 등록일 / YYYYMMDD';

COMMENT ON COLUMN "VEHICLE"."USG" IS '*USAGE / 용도 / 유상운송, 비유상운송 여부';

COMMENT ON COLUMN "VEHICLE"."ERDR_YN" IS '*EVENT DATA RECORDER YN / 블랙박스 여부 / Y, N(DEFAULT)';

COMMENT ON COLUMN "VEHICLE"."DGST_YN" IS '*DANGEROUS ARTICLE YN / 위험물질 여부 / Y, N(DEFAULT)';

COMMENT ON COLUMN "VEHICLE"."DSPY_YN" IS '*DISPLAY YN / 전시차량 여부 / Y, N(DEFALUT)';

COMMENT ON COLUMN "VEHICLE"."MCHN_YN" IS '*MACHINE / 정밀기계 여부 / Y, N(DEFAULT)';

COMMENT ON COLUMN "VEHICLE"."STBLT_YN" IS '*SUITABILITY YN / 요율적합 여부 / Y, N(DEFAULT)';

COMMENT ON COLUMN "VEHICLE"."EMRG_GUT_YN" IS '*EMERGENCY GOING OUT YN / 긴급출동 여부 / Y, N(DEFAULT)';

COMMENT ON COLUMN "VEHICLE"."DSPL" IS '*DISPLACEMENT / 배기량(출력량) / 전기차의 경우 출력량';

COMMENT ON COLUMN "VEHICLE"."FUEL_TY" IS '*FUEL TYPE / 연료 유형 / 휘발유, 경유, 전기, 수소, LPG';

COMMENT ON COLUMN "VEHICLE"."VHCL_TY" IS '*VEHICLE TYPE / 차종';

COMMENT ON COLUMN "VEHICLE"."MAKR_TY" IS '*MAKER TYPE / 제조사 유형 / 국내, 외제';

COMMENT ON COLUMN "VEHICLE"."MAKR" IS '*MAKER / 제조사';

COMMENT ON COLUMN "VEHICLE"."MODEL_NM" IS '*MODEL NAME / 모델 명';

COMMENT ON COLUMN "VEHICLE"."SEG" IS '*SEGMENT / 분류 / 소형, 중형,  대형';

COMMENT ON COLUMN "VEHICLE"."VHCL_AMT" IS '*VEHICLE AMOUNT / 차량 가액 / 보험개발원-차량기준가액표';

COMMENT ON COLUMN "VEHICLE"."MNFTR_YR" IS '*MANUFACT YEAR / 제조년(연식) / YYYY';

COMMENT ON COLUMN "VEHICLE"."VHCL_CD" IS '*VEHICL CODE / 차명코드';

ALTER TABLE "VEHICLE" ADD CONSTRAINT "PK_VEHICLE" PRIMARY KEY (
                                                               "ID"
    );

ALTER TABLE "VEHICLE" ADD CONSTRAINT "FK_CUSTOMER_TO_VEHICLE_1" FOREIGN KEY (
                                                                             "CUST_ID"
    )
    REFERENCES "CUSTOMER" (
                           "ID"
        );

CREATE TABLE "VEHICLE_FILE" (
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

COMMENT ON COLUMN "VEHICLE_FILE"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "VEHICLE_FILE"."VHCL_ID" IS '*VEHICLE ID / 차량 ID';

COMMENT ON COLUMN "VEHICLE_FILE"."TY" IS '*TYPE / 파일 타입 / 이륜자동차사용신고필증, 차량/차대번호';

COMMENT ON COLUMN "VEHICLE_FILE"."ORGNL_NM" IS '*ORIGINAL NAME / 파일 원본 이름';

COMMENT ON COLUMN "VEHICLE_FILE"."PATH" IS '*PATH / 파일 경로';

COMMENT ON COLUMN "VEHICLE_FILE"."EXTN" IS '*EXTENSION / 파일 확장자';

COMMENT ON COLUMN "VEHICLE_FILE"."ULD_DT" IS '*UPLOAD DATE / 업로드 일시';

ALTER TABLE "VEHICLE_FILE" ADD CONSTRAINT "PK_VEHICLE_FILE" PRIMARY KEY (
                                                                         "ID"
    );

ALTER TABLE "VEHICLE_FILE" ADD CONSTRAINT "FK_VEHICLE_TO_VEHICLE_FILE_1" FOREIGN KEY (
                                                                                      "VHCL_ID"
    )
    REFERENCES "VEHICLE" (
                          "ID"
        );

CREATE TABLE "ADDRESS" (
                           "ID"	NUMBER(38, 0)		NOT NULL,
                           "ADDR_TY"	VARCHAR(255)		NULL,
                           "ADDR"	VARCHAR(255)		NULL,
                           "CREATED_AT"	TIMESTAMP		NULL,
                           "UPDATED_ATD"	TIMESTAMP		NULL
);

COMMENT ON COLUMN "ADDRESS"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "ADDRESS"."ADDR_TY" IS '*ADDR TYPE / 자택, 회사, 기타';

COMMENT ON COLUMN "ADDRESS"."ADDR" IS '*ADDRESS / 주소';

ALTER TABLE "ADDRESS" ADD CONSTRAINT "PK_ADDRESS" PRIMARY KEY (
                                                               "ID"
    );

CREATE TABLE "ADDRESS_MEMBER_REL" (
                                      "ID"	NUMBER(38, 0)		NOT NULL,
                                      "ADDR_ID"	NUMBER(38, 0)		NOT NULL,
                                      "PRCUST_ID"	NUMBER(38, 0)		NOT NULL,
                                      "CREATED_AT"	TIMESTAMP		NULL,
                                      "UPDATED_AT"	TIMESTAMP		NULL
);

COMMENT ON COLUMN "ADDRESS_MEMBER_REL"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "ADDRESS_MEMBER_REL"."ADDR_ID" IS '*ADDRESS ID / 주소 ID';

COMMENT ON COLUMN "ADDRESS_MEMBER_REL"."PRCUST_ID" IS '*PERSONAL CUSTOMER ID / 개인고객 ID';

ALTER TABLE "ADDRESS_MEMBER_REL" ADD CONSTRAINT "PK_ADDRESS_MEMBER_REL" PRIMARY KEY (
                                                                                     "ID"
    );

ALTER TABLE "ADDRESS_MEMBER_REL" ADD CONSTRAINT "FK_ADDRESS_TO_ADDRESS_MEMBER_REL_1" FOREIGN KEY (
                                                                                                  "ADDR_ID"
    )
    REFERENCES "ADDRESS" (
                          "ID"
        );

ALTER TABLE "ADDRESS_MEMBER_REL" ADD CONSTRAINT "FK_PERSONAL_CUSTOMER_TO_ADDRESS_MEMBER_REL_1" FOREIGN KEY (
                                                                                                            "PRCUST_ID"
    )
    REFERENCES "PERSONAL_CUSTOMER" (
                                    "ID"
        );


