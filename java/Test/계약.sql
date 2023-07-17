
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

CREATE TABLE "DISCUSSION" (
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

CREATE TABLE "TERMS" (
                         "ID"	NUMBER(38, 0)		NOT NULL,
                         "NM"	VARCHAR(255)		NULL,
                         "CD"	VARCHAR(255)		NULL,
                         "CN"	VARCHAR(2000)		NULL,
                         "ESNTL_YN"	VARCHAR(1)	DEFAULT 'N'	NULL,
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

CREATE TABLE "VEHICLE" (
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

CREATE TABLE "CONTRACT_DESIGN" (
                                   "ID"	NUMBER(38, 0)		NOT NULL,
                                   "CUST_ID"	NUMBER(38, 0)		NOT NULL,
                                   "NO"	VARCHAR(255)		NULL,
                                   "VL"	VARCHAR(4000)		NULL,
                                   "DESIGN_STTS"	VARCHAR(255)		NULL,
                                   "CREATED_AT"	TIMESTAMP		NULL,
                                   "UPDATED_AT"	TIMESTAMP		NULL
);

COMMENT ON COLUMN "CONTRACT_DESIGN"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "CONTRACT_DESIGN"."CUST_ID" IS '*CUSTOMER ID / 고객 ID';

COMMENT ON COLUMN "CONTRACT_DESIGN"."NO" IS 'UNIQUE *NUMBER / 설계번호';

COMMENT ON COLUMN "CONTRACT_DESIGN"."VL" IS '*VALUE / 설계 JSON';

COMMENT ON COLUMN "CONTRACT_DESIGN"."DESIGN_STTS" IS '*DESIGN STATUS / 설계 상태 / 설계중, 보완요청, 심사중, 청약접수';

ALTER TABLE "CONTRACT_DESIGN" ADD CONSTRAINT "PK_CONTRACT_DESIGN" PRIMARY KEY (
                                                                               "ID"
    );

ALTER TABLE "CONTRACT_DESIGN" ADD CONSTRAINT "FK_CUSTOMER_TO_CONTRACT_DESIGN_1" FOREIGN KEY (
                                                                                             "CUST_ID"
    )
    REFERENCES "CUSTOMER" (
                           "ID"
        );

CREATE TABLE "CONTRACT_DESIGN_FILE" (
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

COMMENT ON COLUMN "CONTRACT_DESIGN_FILE"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "CONTRACT_DESIGN_FILE"."CTRT_DESIGN_ID" IS '*CONTRACT DESIGN ID / 계약설계 ID';

COMMENT ON COLUMN "CONTRACT_DESIGN_FILE"."PATH" IS '*PATH / 저장경로';

COMMENT ON COLUMN "CONTRACT_DESIGN_FILE"."ORGNL_NM" IS '*ORIGINAL NAME / 원본이름';

COMMENT ON COLUMN "CONTRACT_DESIGN_FILE"."TY" IS '*TYPE / 파일 유형';

COMMENT ON COLUMN "CONTRACT_DESIGN_FILE"."EXTN" IS '*EXTENSION / 파일 확장자';

COMMENT ON COLUMN "CONTRACT_DESIGN_FILE"."ULD_DT" IS '*UPLOAD DATE / 업로드 일시';

ALTER TABLE "CONTRACT_DESIGN_FILE" ADD CONSTRAINT "PK_CONTRACT_DESIGN_FILE" PRIMARY KEY (
                                                                                         "ID"
    );

ALTER TABLE "CONTRACT_DESIGN_FILE" ADD CONSTRAINT "FK_CONTRACT_DESIGN_TO_CONTRACT_DESIGN_FILE_1" FOREIGN KEY (
                                                                                                              "CTRT_DESIGN_ID"
    )
    REFERENCES "CONTRACT_DESIGN" (
                                  "ID"
        );

CREATE TABLE "ADDRESS_CONTRACT_CUSTOMER_REL" (
                                                 "ID"	NUMBER(38, 0)		NOT NULL,
                                                 "CTRT_CUST_ID"	NUMBER(38, 0)		NOT NULL,
                                                 "ADDR_ID"	NUMBER(38, 0)		NOT NULL,
                                                 "CREATED_AT"	TIMESTAMP		NULL,
                                                 "UPDATED_AT"	TIMESTAMP		NULL
);

COMMENT ON COLUMN "ADDRESS_CONTRACT_CUSTOMER_REL"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "ADDRESS_CONTRACT_CUSTOMER_REL"."CTRT_CUST_ID" IS '*CONTRACT CUSTOMER ID / 계약 고객 ID';

COMMENT ON COLUMN "ADDRESS_CONTRACT_CUSTOMER_REL"."ADDR_ID" IS '*ADDRESS ID / 주소 ID';

ALTER TABLE "ADDRESS_CONTRACT_CUSTOMER_REL" ADD CONSTRAINT "PK_ADDRESS_CONTRACT_CUSTOMER_REL" PRIMARY KEY (
                                                                                                           "ID"
    );

ALTER TABLE "ADDRESS_CONTRACT_CUSTOMER_REL" ADD CONSTRAINT "FK_CONTRACT_CUSTOMER_REL_TO_ADDRESS_CONTRACT_CUSTOMER_REL_1" FOREIGN KEY (
                                                                                                                                      "CTRT_CUST_ID"
    )
    REFERENCES "CONTRACT_CUSTOMER_REL" (
                                        "ID"
        );

ALTER TABLE "ADDRESS_CONTRACT_CUSTOMER_REL" ADD CONSTRAINT "FK_ADDRESS_TO_ADDRESS_CONTRACT_CUSTOMER_REL_1" FOREIGN KEY (
                                                                                                                        "ADDR_ID"
    )
    REFERENCES "ADDRESS" (
                          "ID"
        );

CREATE TABLE "CONTRACT_CUSTOMER_REL" (
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

COMMENT ON COLUMN "CONTRACT_CUSTOMER_REL"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "CONTRACT_CUSTOMER_REL"."CTRT_ID" IS '*CONTRACT ID / 꼐약 ID';

COMMENT ON COLUMN "CONTRACT_CUSTOMER_REL"."CUST_ID" IS '*CUSTOMER ID / 고객 ID';

COMMENT ON COLUMN "CONTRACT_CUSTOMER_REL"."TY" IS '*TYPE / 계약자, 피공제자';

COMMENT ON COLUMN "CONTRACT_CUSTOMER_REL"."TY_CD" IS '*TYPE CODE / 유형 코드';

COMMENT ON COLUMN "CONTRACT_CUSTOMER_REL"."REL" IS '*RELATION / 본인, 부모, ... (계약자와 관계)';

COMMENT ON COLUMN "CONTRACT_CUSTOMER_REL"."REL_CD" IS '*RELATION CODE / 관계 코드';

ALTER TABLE "CONTRACT_CUSTOMER_REL" ADD CONSTRAINT "PK_CONTRACT_CUSTOMER_REL" PRIMARY KEY (
                                                                                           "ID"
    );

ALTER TABLE "CONTRACT_CUSTOMER_REL" ADD CONSTRAINT "FK_CONTRACT_TO_CONTRACT_CUSTOMER_REL_1" FOREIGN KEY (
                                                                                                         "CTRT_ID"
    )
    REFERENCES "CONTRACT" (
                           "ID"
        );

ALTER TABLE "CONTRACT_CUSTOMER_REL" ADD CONSTRAINT "FK_CUSTOMER_TO_CONTRACT_CUSTOMER_REL_1" FOREIGN KEY (
                                                                                                         "CUST_ID"
    )
    REFERENCES "CUSTOMER" (
                           "ID"
        );

CREATE TABLE "CONTRACT_VEHICLE_REL" (
                                        "ID"	NUMBER(38, 0)		NOT NULL,
                                        "CTRT_ID"	NUMBER(38, 0)		NOT NULL,
                                        "VHCL_ID"	NUMBER(38, 0)		NOT NULL,
                                        "CREATED_AT"	TIMESTAMP		NULL,
                                        "UPDATED_AT"	TIMESTAMP		NULL
);

COMMENT ON COLUMN "CONTRACT_VEHICLE_REL"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "CONTRACT_VEHICLE_REL"."CTRT_ID" IS '*CONTRACT ID / 계약 ID';

COMMENT ON COLUMN "CONTRACT_VEHICLE_REL"."VHCL_ID" IS '*VEHICLE ID / 차량 ID';

ALTER TABLE "CONTRACT_VEHICLE_REL" ADD CONSTRAINT "PK_CONTRACT_VEHICLE_REL" PRIMARY KEY (
                                                                                         "ID"
    );

ALTER TABLE "CONTRACT_VEHICLE_REL" ADD CONSTRAINT "FK_CONTRACT_TO_CONTRACT_VEHICLE_REL_1" FOREIGN KEY (
                                                                                                       "CTRT_ID"
    )
    REFERENCES "CONTRACT" (
                           "ID"
        );

ALTER TABLE "CONTRACT_VEHICLE_REL" ADD CONSTRAINT "FK_VEHICLE_TO_CONTRACT_VEHICLE_REL_1" FOREIGN KEY (
                                                                                                      "VHCL_ID"
    )
    REFERENCES "VEHICLE" (
                          "ID"
        );

CREATE TABLE "CONTRACT" (
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

COMMENT ON COLUMN "CONTRACT"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "CONTRACT"."CTRT_NO" IS 'UNIQUE *CONTRACT NUMBER / 계약 번호';

COMMENT ON COLUMN "CONTRACT"."CTRT_DT" IS '*CONTRACT DATE / 계약 일';

COMMENT ON COLUMN "CONTRACT"."INSRNC_PD" IS '*INSURANCE PERIOD / 보험기간 / MM';

COMMENT ON COLUMN "CONTRACT"."INSRNC_BGNG_YMD" IS '*INSURANCE BEGINNING YEAR MONTH DATE / 보험(공제) 시작 일자 / YYYYMMDD';

COMMENT ON COLUMN "CONTRACT"."INSRNC_END_YMD" IS '*INSURANCE END YEAR MONTH DATE / 보험(공제) 종료 일자 / YYYYMMDD';

COMMENT ON COLUMN "CONTRACT"."INSRNC_RT" IS '*INSURANCE RATE / 요율 / 부동 소수점';

COMMENT ON COLUMN "CONTRACT"."DSCNT_EXCG_DGRD" IS '*DISCOUNT  EXTRA CHARGE GRADE / 할인할증 등급';

COMMENT ON COLUMN "CONTRACT"."PAY_UNIT" IS '*PAY UNIT / 납입 단위 / 일시납 = 1, 2회납 = 2, ...';

COMMENT ON COLUMN "CONTRACT"."TOT_INSRNC_PRMUM" IS '*TOTAL INSURANCE PREMIUM / 총 보험료 / 계약상 발생한 총 보험료';

COMMENT ON COLUMN "CONTRACT"."INSRNC_PRMUM" IS '*INSURANCE PREMIUM / 실납입 총 보험료';

COMMENT ON COLUMN "CONTRACT"."CTRT_AMT" IS '*CONTRACT AMOUNT / 가입금';

COMMENT ON COLUMN "CONTRACT"."CTRT_AMT_YN" IS '*CONTRACT AMOUNT YN / 가입금 납입 여부 / Y , N(DEFAULT)';

COMMENT ON COLUMN "CONTRACT"."ATMC_RENW_YN" IS '*AUTOMATIC RENEWAL YN / 자동갱신 여부 / Y , N(DEFAULT)';

COMMENT ON COLUMN "CONTRACT"."CTRT_STTS" IS '*CONTRACT STATUS / 계약 상태 / 정상계약, 해지취소, 만기';

COMMENT ON COLUMN "CONTRACT"."INSRNC_HIST_GRD" IS '*INSURANCE HISTORY GRADE / 이전 보험 적용 등급';

COMMENT ON COLUMN "CONTRACT"."INSRNC_HIST_YN" IS '*INSURANCE HISTORY YN / 가입 이력 여부 / Y , N(DEFAULT)';

COMMENT ON COLUMN "CONTRACT"."INSRNC_HIST_PD" IS '*INSURANCE HISTORY PERIOD / 이전 보험 가입 기간';

ALTER TABLE "CONTRACT" ADD CONSTRAINT "PK_CONTRACT" PRIMARY KEY (
                                                                 "ID"
    );

CREATE TABLE "ENDORSE" (
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

COMMENT ON COLUMN "ENDORSE"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "ENDORSE"."CTRT_ID" IS '*CONTRACT ID / 계약 ID';

COMMENT ON COLUMN "ENDORSE"."NO" IS '*NUMBER / 배서 번호';

COMMENT ON COLUMN "ENDORSE"."TY" IS '*TYPE / 배서 타입 / 취소, 축소, 확대, ..,';

COMMENT ON COLUMN "ENDORSE"."APLY_DT" IS '*APPLY DATE / 배서 신청 일자';

COMMENT ON COLUMN "ENDORSE"."APLCN_DT" IS '*APPLICATION DATE / 배서 적용 일자';

COMMENT ON COLUMN "ENDORSE"."EMP_ID" IS '*EMPLOYEE ID / 담당 직원 ID';

COMMENT ON COLUMN "ENDORSE"."EMP_NM" IS '*EMPLOYEE  NAME / 담당 직원 이름';

COMMENT ON COLUMN "ENDORSE"."EMP_DEPT" IS '*EMPLOYEE DEPARTMENT / 담당 직원 부서';

COMMENT ON COLUMN "ENDORSE"."EMP_JBPS" IS '*EMPLOYEE JOB POSITION / 담당 직원 직책';

COMMENT ON COLUMN "ENDORSE"."EMP_JBTTL" IS '*EMPLOYEE JOB TITLE / 담당 직원 직책';

COMMENT ON COLUMN "ENDORSE"."RMRK" IS '*REMARKS / 비고 / 추가 설명을 위한 JSON';

COMMENT ON COLUMN "ENDORSE"."RVW_STTS" IS '*REVIEW STATUS / 심사 상태 / 심사요청, 심사중. 승인, 반려,...';

COMMENT ON COLUMN "ENDORSE"."RVW_RSN" IS '*REVIEW REASON / 심사 사유';

ALTER TABLE "ENDORSE" ADD CONSTRAINT "PK_ENDORSE" PRIMARY KEY (
                                                               "ID"
    );

ALTER TABLE "ENDORSE" ADD CONSTRAINT "FK_CONTRACT_TO_ENDORSE_1" FOREIGN KEY (
                                                                             "CTRT_ID"
    )
    REFERENCES "CONTRACT" (
                           "ID"
        );

CREATE TABLE "ENDORSE_CHANGE" (
                                  "ID"	NUMBER(38, 0)		NOT NULL,
                                  "ENDRS_ID"	NUMBER(38, 0)		NOT NULL,
                                  "TBL_NM"	VARCHAR(255)		NULL,
                                  "COL_NM"	VARCHAR(255)		NULL,
                                  "BFR_VL"	VARCHAR(255)		NULL,
                                  "AFTR_VL"	VARCHAR(255)		NULL,
                                  "CREATED_AT"	DATE		NULL,
                                  "UPDATED_AT"	DATE		NULL
);

COMMENT ON COLUMN "ENDORSE_CHANGE"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "ENDORSE_CHANGE"."ENDRS_ID" IS '*ENDORSE ID / 배서 ID';

COMMENT ON COLUMN "ENDORSE_CHANGE"."TBL_NM" IS '*TABLE NAME / 변경 테이블 명';

COMMENT ON COLUMN "ENDORSE_CHANGE"."COL_NM" IS '*COLUMN NAME / 변경 컬럼 명';

COMMENT ON COLUMN "ENDORSE_CHANGE"."BFR_VL" IS '*BEFORE VALUE / 배서 전 값';

COMMENT ON COLUMN "ENDORSE_CHANGE"."AFTR_VL" IS '*AFTER VALUE / 배서 후 값';

ALTER TABLE "ENDORSE_CHANGE" ADD CONSTRAINT "PK_ENDORSE_CHANGE" PRIMARY KEY (
                                                                             "ID"
    );

ALTER TABLE "ENDORSE_CHANGE" ADD CONSTRAINT "FK_ENDORSE_TO_ENDORSE_CHANGE_1" FOREIGN KEY (
                                                                                          "ENDRS_ID"
    )
    REFERENCES "ENDORSE" (
                          "ID"
        );

CREATE TABLE "INSURANCE_HISTORY" (
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

COMMENT ON COLUMN "INSURANCE_HISTORY"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "INSURANCE_HISTORY"."CTRT_ID" IS '*CONTRACT ID / 계약 ID';

COMMENT ON COLUMN "INSURANCE_HISTORY"."INSRNC_PD" IS '*INSURANCE PERIOD / 보험가입 기간 / MM';

COMMENT ON COLUMN "INSURANCE_HISTORY"."INSRNC_BGNG_YMD" IS '*INSURANCE BEGINNING YEAR MONTH DAY / 이전 보험 시작 일자 / YYYYMMDD';

COMMENT ON COLUMN "INSURANCE_HISTORY"."INSRNC_END_YMD" IS '*INSURANCE END YEAR MONTH DAY / 이전 보험 종료 일자 / YYYYMMDD';

COMMENT ON COLUMN "INSURANCE_HISTORY"."GRD" IS '*GRADE / 이전 보험 할인할증 등급';

COMMENT ON COLUMN "INSURANCE_HISTORY"."GRD_DOC_PATH" IS '*GRADE DOCUMENT / 적용등급확인서 저장 URL';

COMMENT ON COLUMN "INSURANCE_HISTORY"."GRD_DOC_ORGNL_NM" IS '*GRADE DOCUMENT ORIGINAL NAME / 적용등급확인서 원본 이름';

COMMENT ON COLUMN "INSURANCE_HISTORY"."GRD_DOC_EXTN" IS '*GRADE DOCUMENT EXTENSION / 적용등급확인서 파일 확장자';

COMMENT ON COLUMN "INSURANCE_HISTORY"."GRD_DOC_ULD_DT" IS '*GRADE DOCUMENT UPLOAD DATE / 적용등급확인서 업로드 일시';

ALTER TABLE "INSURANCE_HISTORY" ADD CONSTRAINT "PK_INSURANCE_HISTORY" PRIMARY KEY (
                                                                                   "ID"
    );

ALTER TABLE "INSURANCE_HISTORY" ADD CONSTRAINT "FK_CONTRACT_TO_INSURANCE_HISTORY_1" FOREIGN KEY (
                                                                                                 "CTRT_ID"
    )
    REFERENCES "CONTRACT" (
                           "ID"
        );


