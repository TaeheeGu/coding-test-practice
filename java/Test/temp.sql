
CREATE TABLE "SPECIAL_EXTRA_CHARGE_RATE" (
                                             "ID"	NUMBER(38, 0)		NOT NULL,
                                             "AUTO_FUNCTION_ID"	NUMBER(38, 0)		NOT NULL,
                                             "PRIVATELY_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA_ID"	NUMBER(38, 0)		NOT NULL,
                                             "CORPORATION_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA_ID"	NUMBER(38, 0)		NOT NULL,
                                             "Field"	VARCHAR(255)		NULL
);

COMMENT ON COLUMN "SPECIAL_EXTRA_CHARGE_RATE"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "SPECIAL_EXTRA_CHARGE_RATE"."AUTO_FUNCTION_ID" IS '자동함수 ID';

COMMENT ON COLUMN "SPECIAL_EXTRA_CHARGE_RATE"."PRIVATELY_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA_ID" IS '개인소유 그룹점수 최고할증률 변동데이터 ID';

COMMENT ON COLUMN "SPECIAL_EXTRA_CHARGE_RATE"."CORPORATION_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA_ID" IS '법인소유 그룹점수 최고할증률 변동데이터 ID';

CREATE TABLE "PRIVATELY_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA" (
                                                                                       "ID"	NUMBER(38, 0)		NOT NULL,
                                                                                       "NAME"	VARCHAR(255)		NULL,
                                                                                       "A_GROUP_CHARGE_RATE_SUM"	NUMBER		NULL,
                                                                                       "A_GROUP_TARGET_CONTRACT_ONE_CHARGE_RATE"	NUMBER		NULL,
                                                                                       "A_GROUP_TARGET_CONTRACT_TWO_CHARGE_RATE"	NUMBER		NULL,
                                                                                       "A_GROUP_TARGET_CONTRACT_THREE_CHARGE_RATE"	NUMBER		NULL,
                                                                                       "E_GROUP_CHARGE_RATE_SUM"	NUMBER		NULL,
                                                                                       "E_GROUP_TARGET_CONTRACT_ONE_CHARGE_RATE"	NUMBER		NULL,
                                                                                       "E_GROUP_PREVIOUS_ACCIDENT_CNT"	NUMBER(38, 0)		NULL
);

COMMENT ON COLUMN "PRIVATELY_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "PRIVATELY_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA"."NAME" IS '분류명';

COMMENT ON COLUMN "PRIVATELY_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA"."A_GROUP_CHARGE_RATE_SUM" IS 'A 그룹 총 합산';

COMMENT ON COLUMN "PRIVATELY_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA"."A_GROUP_TARGET_CONTRACT_ONE_CHARGE_RATE" IS '1. 위장사고 야기자';

COMMENT ON COLUMN "PRIVATELY_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA"."A_GROUP_TARGET_CONTRACT_TWO_CHARGE_RATE" IS '2. 자동차를 이용하여 범죄행위를 한 경우';

COMMENT ON COLUMN "PRIVATELY_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA"."A_GROUP_TARGET_CONTRACT_THREE_CHARGE_RATE" IS '3. 피공제자를 변경함으로써 할증된 공제료(공제가입자 특성요율을 포함)를 적용할 수 없는 경우';

COMMENT ON COLUMN "PRIVATELY_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA"."E_GROUP_CHARGE_RATE_SUM" IS 'E그룹 총 합산';

COMMENT ON COLUMN "PRIVATELY_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA"."E_GROUP_TARGET_CONTRACT_ONE_CHARGE_RATE" IS '직전 1년간 사고건수가 n건을 초과하는 경우(건당)';

COMMENT ON COLUMN "PRIVATELY_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA"."E_GROUP_PREVIOUS_ACCIDENT_CNT" IS '직전 사고 건수';

CREATE TABLE "CORPORATION_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA" (
                                                                                         "ID"	NUMBER(38, 0)		NOT NULL,
                                                                                         "NAME"	VARCHAR(255)		NULL,
                                                                                         "MAXIMUM_EXTRA_CHARGE_RATE"	NUMBER		NULL
);

COMMENT ON COLUMN "CORPORATION_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "CORPORATION_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA"."NAME" IS '분류명';

COMMENT ON COLUMN "CORPORATION_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA"."MAXIMUM_EXTRA_CHARGE_RATE" IS '최고할증률';

CREATE TABLE "INSURED_CHARACTERISTICS_RATE" (
                                                "ID"	NUMBER(38, 0)		NOT NULL,
                                                "AUTO_FUNCTION_ID"	NUMBER(38, 0)		NOT NULL,
                                                "SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA_ID"	NUMBER(38, 0)		NOT NULL
);

COMMENT ON COLUMN "INSURED_CHARACTERISTICS_RATE"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "INSURED_CHARACTERISTICS_RATE"."AUTO_FUNCTION_ID" IS '자동함수 ID';

COMMENT ON COLUMN "INSURED_CHARACTERISTICS_RATE"."SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA_ID" IS '공제가입경력요율 변동데이터  ID';

CREATE TABLE "SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA" (
                                                              "ID"	NUMBER(38, 0)		NOT NULL,
                                                              "NAME"	VARCHAR(255)		NULL
);

COMMENT ON COLUMN "SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA"."NAME" IS '분류명';

CREATE TABLE "SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA_VALUE" (
                                                                    "ID"	NUMBER(38, 0)		NOT NULL,
                                                                    "SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA_ID"	NUMBER(38, 0)		NOT NULL,
                                                                    "JOIN_DURATION"	VARCHAR(255)		NULL,
                                                                    "OWNED_TYPE"	VARCHAR(255)		NULL,
                                                                    "PURPOSE_TYPE"	VARCHAR(255)		NULL,
                                                                    "VEHICLE_TYPE"	VARCHAR(255)		NULL,
                                                                    "VALUE"	NUMBER		NULL
);

COMMENT ON COLUMN "SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA_VALUE"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA_VALUE"."SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA_ID" IS '공제가입경력요율 변동데이터  ID';

COMMENT ON COLUMN "SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA_VALUE"."JOIN_DURATION" IS '공제가입 경과기간/최초가입자 또는 1년미만, 1년이상 2년미만, 2년 이상 3년 미만, 3년 이상';

COMMENT ON COLUMN "SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA_VALUE"."OWNED_TYPE" IS '차량 소유/개인소유, 법인소유';

COMMENT ON COLUMN "SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA_VALUE"."PURPOSE_TYPE" IS '차량 용도/유상운송, 기타';

COMMENT ON COLUMN "SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA_VALUE"."VEHICLE_TYPE" IS '차종/소형A, 소형B, 중형, 대형';

COMMENT ON COLUMN "SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA_VALUE"."VALUE" IS '요율값';

CREATE TABLE "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE" (
                                                         "ID"	NUMBER(38, 0)		NOT NULL,
                                                         "AUTO_FUNCTION_ID"	NUMBER(38, 0)		NOT NULL,
                                                         "INHERITED_INSURANCE_GRADE_VARIABLE_DATA_ID"	NUMBER(38, 0)		NOT NULL,
                                                         "EVALUATION_PERIOD_VARIABLE_DATA_ID"	NUMBER(38, 0)		NOT NULL,
                                                         "NEW_ACCIDENT_SCORE_VARIABLE_DATA_ID"	NUMBER(38, 0)		NOT NULL,
                                                         "FOLLOW_UP_ACTION_SCORE_VARIABLE_DATA_ID"	NUMBER(38, 0)		NOT NULL,
                                                         "ACCIDENT_CAUSE_SCORE_VARIABLE_DATA_ID"	NUMBER(38, 0)		NOT NULL,
                                                         "DEFAULT_AND_NEW_CONTRACT_APPLIED_GRADE_VARIABLE_DATA_ID"	NUMBER(38, 0)		NOT NULL,
                                                         "RENEWAL_CONTRACT_EVALUATION_STANDARD_VARIABLE_DATA_ID"	NUMBER(38, 0)		NOT NULL,
                                                         "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_ID"	NUMBER(38, 0)		NOT NULL,
                                                         "RENEWAL_CONTRACT_APPLIED_RATE_EXP_PERIOD_VARIABLE_DATA_ID"	NUMBER(38, 0)		NOT NULL,
                                                         "RANGE_RATE_VARIABLE_DATA_ID"	NUMBER(38, 0)		NOT NULL
);

COMMENT ON COLUMN "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE"."AUTO_FUNCTION_ID" IS '자동함수 ID';

COMMENT ON COLUMN "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE"."INHERITED_INSURANCE_GRADE_VARIABLE_DATA_ID" IS '손해보험사 적용등급 승계 변동데이터 ID';

COMMENT ON COLUMN "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE"."EVALUATION_PERIOD_VARIABLE_DATA_ID" IS '평가대상기간 변동데이터 ID';

COMMENT ON COLUMN "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE"."NEW_ACCIDENT_SCORE_VARIABLE_DATA_ID" IS '사고발생점수 변동데이터 ID';

COMMENT ON COLUMN "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE"."FOLLOW_UP_ACTION_SCORE_VARIABLE_DATA_ID" IS '사고후속조치 점수 변동데이터 ID';

COMMENT ON COLUMN "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE"."ACCIDENT_CAUSE_SCORE_VARIABLE_DATA_ID" IS '사고원인별 점수 변동데이터 ID';

COMMENT ON COLUMN "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE"."DEFAULT_AND_NEW_CONTRACT_APPLIED_GRADE_VARIABLE_DATA_ID" IS '기본등급 및 신규계약 적용등급 변동데이터 ID';

COMMENT ON COLUMN "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE"."RENEWAL_CONTRACT_EVALUATION_STANDARD_VARIABLE_DATA_ID" IS '갱신계약 평가기준 변동데이터 ID';

COMMENT ON COLUMN "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE"."APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_ID" IS '적용등급 및 일반등급별 적용률 변동데이터 ID';

COMMENT ON COLUMN "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE"."RENEWAL_CONTRACT_APPLIED_RATE_EXP_PERIOD_VARIABLE_DATA_ID" IS '갱신계약 적용등급 유효기간 변동데이터 ID';

COMMENT ON COLUMN "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE"."RANGE_RATE_VARIABLE_DATA_ID" IS '범위요율 변동데이터 ID';

CREATE TABLE "NEW_ACCIDENT_SCORE_VARIABLE_DATA" (
                                                    "ID"	NUMBER(38, 0)		NOT NULL,
                                                    "NAME"	VARCHAR(255)		NULL,
                                                    "NEW_ACCIDENT_SCORE_OVER_FIFTY"	NUMBER(38, 0)		NULL,
                                                    "NEW_ACCIDENT_SCORE_UNDER_FIFTY"	NUMBER(38, 0)		NULL,
                                                    "DEFAULT_SCORE_OVER_FIFTY"	NUMBER(38, 0)		NULL,
                                                    "DEFAULT_SCORE_UNDER_FIFTY"	NUMBER(38, 0)		NULL,
                                                    "ADDITIONAL_VICTIM_PROPERTY_SCORE_OVER_FIFTY"	NUMBER(38, 0)		NULL,
                                                    "ADDITIONAL_VICTIM_PROPERTY_SCORE_UNDER_FIFTY"	NUMBER(38, 0)		NULL
);

COMMENT ON COLUMN "NEW_ACCIDENT_SCORE_VARIABLE_DATA"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "NEW_ACCIDENT_SCORE_VARIABLE_DATA"."NAME" IS '분류명';

COMMENT ON COLUMN "NEW_ACCIDENT_SCORE_VARIABLE_DATA"."NEW_ACCIDENT_SCORE_OVER_FIFTY" IS '사고발생점수-자기과실50%이상';

COMMENT ON COLUMN "NEW_ACCIDENT_SCORE_VARIABLE_DATA"."NEW_ACCIDENT_SCORE_UNDER_FIFTY" IS '사고발생점수-자기과실50%미만';

COMMENT ON COLUMN "NEW_ACCIDENT_SCORE_VARIABLE_DATA"."DEFAULT_SCORE_OVER_FIFTY" IS '기본점수-자기과실50%이상';

COMMENT ON COLUMN "NEW_ACCIDENT_SCORE_VARIABLE_DATA"."DEFAULT_SCORE_UNDER_FIFTY" IS '기본점수-자기과실50%미만';

COMMENT ON COLUMN "NEW_ACCIDENT_SCORE_VARIABLE_DATA"."ADDITIONAL_VICTIM_PROPERTY_SCORE_OVER_FIFTY" IS '추가점수-자기과실50%이상';

COMMENT ON COLUMN "NEW_ACCIDENT_SCORE_VARIABLE_DATA"."ADDITIONAL_VICTIM_PROPERTY_SCORE_UNDER_FIFTY" IS '추가점수-자기과실50%미만';

CREATE TABLE "FOLLOW_UP_ACTION_SCORE_VARIABLE_DATA" (
                                                        "ID"	NUMBER(38, 0)		NOT NULL,
                                                        "NAME"	VARCHAR(255)		NULL,
                                                        "FOLLOW_UP_ACTION_SCORE_OVER_FIFTY"	NUMBER(38, 0)		NULL,
                                                        "FOLLOW_UP_ACTION_SCORE_UNDER_FIFTY"	NUMBER(38, 0)		NULL,
                                                        "PHOTO_SUBMIT_SCORE_OVER_FIFTY"	NUMBER(38, 0)		NULL,
                                                        "PHOTO_SUBMIT_SCORE_UNDER_FIFTY"	NUMBER(38, 0)		NULL
);

COMMENT ON COLUMN "FOLLOW_UP_ACTION_SCORE_VARIABLE_DATA"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "FOLLOW_UP_ACTION_SCORE_VARIABLE_DATA"."NAME" IS '분류명';

COMMENT ON COLUMN "FOLLOW_UP_ACTION_SCORE_VARIABLE_DATA"."FOLLOW_UP_ACTION_SCORE_OVER_FIFTY" IS '사고후속조치점수-자기과실50%이상';

COMMENT ON COLUMN "FOLLOW_UP_ACTION_SCORE_VARIABLE_DATA"."FOLLOW_UP_ACTION_SCORE_UNDER_FIFTY" IS '사고후속조치점수-자기과실50%미만';

COMMENT ON COLUMN "FOLLOW_UP_ACTION_SCORE_VARIABLE_DATA"."PHOTO_SUBMIT_SCORE_OVER_FIFTY" IS '사고현장사진촬영및제출-자기과실50%이상';

COMMENT ON COLUMN "FOLLOW_UP_ACTION_SCORE_VARIABLE_DATA"."PHOTO_SUBMIT_SCORE_UNDER_FIFTY" IS '사고현장사진촬영및제출-자기과실50%미만';

CREATE TABLE "ACCIDENT_CAUSE_SCORE_VARIABLE_DATA" (
                                                      "ID"	NUMBER(38, 0)		NOT NULL,
                                                      "NAME"	VARCHAR(255)		NULL,
                                                      "ACCIDENT_CAUSE_SCORE_ONE"	NUMBER(38, 0)		NULL,
                                                      "ACCIDENT_CAUSE_SCORE_TWO"	NUMBER(38, 0)		NULL,
                                                      "ACCIDENT_CAUSE_SCORE_THREE"	NUMBER(38, 0)		NULL
);

COMMENT ON COLUMN "ACCIDENT_CAUSE_SCORE_VARIABLE_DATA"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "ACCIDENT_CAUSE_SCORE_VARIABLE_DATA"."NAME" IS '분류명';

COMMENT ON COLUMN "ACCIDENT_CAUSE_SCORE_VARIABLE_DATA"."ACCIDENT_CAUSE_SCORE_ONE" IS '사고원인점수1';

COMMENT ON COLUMN "ACCIDENT_CAUSE_SCORE_VARIABLE_DATA"."ACCIDENT_CAUSE_SCORE_TWO" IS '사고원인점수2';

COMMENT ON COLUMN "ACCIDENT_CAUSE_SCORE_VARIABLE_DATA"."ACCIDENT_CAUSE_SCORE_THREE" IS '사고원인점수3';

CREATE TABLE "DEFAULT_AND_NEW_CONTRACT_APPLIED_GRADE_VARIABLE_DATA" (
                                                                        "ID"	NUMBER(38, 0)		NOT NULL,
                                                                        "NAME"	VARCHAR(255)		NULL,
                                                                        "DEFAULT_GRADE"	NUMBER(38, 0)		NULL,
                                                                        "NEW_CONTRACT_APPLIED_GRADE"	NUMBER(38, 0)		NULL
);

COMMENT ON COLUMN "DEFAULT_AND_NEW_CONTRACT_APPLIED_GRADE_VARIABLE_DATA"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "DEFAULT_AND_NEW_CONTRACT_APPLIED_GRADE_VARIABLE_DATA"."NAME" IS '분류명';

COMMENT ON COLUMN "DEFAULT_AND_NEW_CONTRACT_APPLIED_GRADE_VARIABLE_DATA"."DEFAULT_GRADE" IS '기본등급';

COMMENT ON COLUMN "DEFAULT_AND_NEW_CONTRACT_APPLIED_GRADE_VARIABLE_DATA"."NEW_CONTRACT_APPLIED_GRADE" IS '신규계약 적용등급';

CREATE TABLE "RENEWAL_CONTRACT_EVALUATION_STANDARD_VARIABLE_DATA" (
                                                                      "ID"	NUMBER(38, 0)		NOT NULL,
                                                                      "NAME"	VARCHAR(255)		NULL,
                                                                      "DISCOUNT_STANDARD_GRADE"	NUMBER(38, 0)		NULL,
                                                                      "EXTRA_CHARGE_STANDARD_RATE"	NUMBER		NULL
);

COMMENT ON COLUMN "RENEWAL_CONTRACT_EVALUATION_STANDARD_VARIABLE_DATA"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "RENEWAL_CONTRACT_EVALUATION_STANDARD_VARIABLE_DATA"."NAME" IS '분류명';

COMMENT ON COLUMN "RENEWAL_CONTRACT_EVALUATION_STANDARD_VARIABLE_DATA"."DISCOUNT_STANDARD_GRADE" IS '무사고 할인 할인기준등급';

COMMENT ON COLUMN "RENEWAL_CONTRACT_EVALUATION_STANDARD_VARIABLE_DATA"."EXTRA_CHARGE_STANDARD_RATE" IS '사고 할증 할증기준요율';

CREATE TABLE "RENEWAL_CONTRACT_APPLIED_RATE_EXP_PERIOD_VARIABLE_DATA" (
                                                                          "ID"	NUMBER(38, 0)		NOT NULL,
                                                                          "NAME"	VARCHAR(255)		NULL,
                                                                          "EXP_PERIOD_ONE_RENEWAL_CONTRACT_GRADE_FROM"	VARCHAR(255)		NULL,
                                                                          "EXP_PERIOD_ONE_RENEWAL_CONTRACT_GRADE_TO"	VARCHAR(255)		NULL,
                                                                          "EXP_PERIOD_ONE_PREVIOUS_CONTRACT_GRADE_FROM"	VARCHAR(255)		NULL,
                                                                          "EXP_PERIOD_ONE_PREVIOUS_CONTRACT_GRADE_TO"	VARCHAR(255)		NULL,
                                                                          "EXP_PERIOD_TWO_RENEWAL_CONTRACT_GRADE_FROM"	VARCHAR(255)		NULL,
                                                                          "EXP_PERIOD_TWO_RENEWAL_CONTRACT_GRADE_TO"	VARCHAR(255)		NULL,
                                                                          "EXP_PERIOD_TWO_PREVIOUS_CONTRACT_GRADE_FROM"	VARCHAR(255)		NULL,
                                                                          "EXP_PERIOD_TWO_PREVIOUS_CONTRACT_GRADE_TO"	VARCHAR(255)		NULL,
                                                                          "EXP_PERIOD_THREE_RENEWAL_CONTRACT_GRADE_FROM"	VARCHAR(255)		NULL,
                                                                          "EXP_PERIOD_THREE_RENEWAL_CONTRACT_GRADE_TO"	VARCHAR(255)		NULL,
                                                                          "EXP_PERIOD_FOUR_RENEWAL_CONTRACT_GRADE_FROM"	VARCHAR(255)		NULL,
                                                                          "EXP_PERIOD_FOUR_RENEWAL_CONTRACT_GRADE_TO"	VARCHAR(255)		NULL
);

COMMENT ON COLUMN "RENEWAL_CONTRACT_APPLIED_RATE_EXP_PERIOD_VARIABLE_DATA"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "RENEWAL_CONTRACT_APPLIED_RATE_EXP_PERIOD_VARIABLE_DATA"."NAME" IS '분류명';

COMMENT ON COLUMN "RENEWAL_CONTRACT_APPLIED_RATE_EXP_PERIOD_VARIABLE_DATA"."EXP_PERIOD_ONE_RENEWAL_CONTRACT_GRADE_FROM" IS '유효기간1 갱신계약 적용등급 FROM';

COMMENT ON COLUMN "RENEWAL_CONTRACT_APPLIED_RATE_EXP_PERIOD_VARIABLE_DATA"."EXP_PERIOD_ONE_RENEWAL_CONTRACT_GRADE_TO" IS '유효기간1 갱신계약 적용등급 TO';

COMMENT ON COLUMN "RENEWAL_CONTRACT_APPLIED_RATE_EXP_PERIOD_VARIABLE_DATA"."EXP_PERIOD_ONE_PREVIOUS_CONTRACT_GRADE_FROM" IS '유효기간1 전계약 적용등급 FROM';

COMMENT ON COLUMN "RENEWAL_CONTRACT_APPLIED_RATE_EXP_PERIOD_VARIABLE_DATA"."EXP_PERIOD_ONE_PREVIOUS_CONTRACT_GRADE_TO" IS '유효기간1 전계약 적용등급 TO';

COMMENT ON COLUMN "RENEWAL_CONTRACT_APPLIED_RATE_EXP_PERIOD_VARIABLE_DATA"."EXP_PERIOD_TWO_RENEWAL_CONTRACT_GRADE_FROM" IS '유효기간2 갱신계약 적용등급 FROM';

COMMENT ON COLUMN "RENEWAL_CONTRACT_APPLIED_RATE_EXP_PERIOD_VARIABLE_DATA"."EXP_PERIOD_TWO_RENEWAL_CONTRACT_GRADE_TO" IS '유효기간2 갱신계약 적용등급 TO';

COMMENT ON COLUMN "RENEWAL_CONTRACT_APPLIED_RATE_EXP_PERIOD_VARIABLE_DATA"."EXP_PERIOD_TWO_PREVIOUS_CONTRACT_GRADE_FROM" IS '유효기간2 전계약 적용등급 FROM';

COMMENT ON COLUMN "RENEWAL_CONTRACT_APPLIED_RATE_EXP_PERIOD_VARIABLE_DATA"."EXP_PERIOD_TWO_PREVIOUS_CONTRACT_GRADE_TO" IS '유효기간2 전계약 적용등급 TO';

COMMENT ON COLUMN "RENEWAL_CONTRACT_APPLIED_RATE_EXP_PERIOD_VARIABLE_DATA"."EXP_PERIOD_THREE_RENEWAL_CONTRACT_GRADE_FROM" IS '유효기간3 갱신계약 적용등급 FROM';

COMMENT ON COLUMN "RENEWAL_CONTRACT_APPLIED_RATE_EXP_PERIOD_VARIABLE_DATA"."EXP_PERIOD_THREE_RENEWAL_CONTRACT_GRADE_TO" IS '유효기간3 갱신계약 적용등급 TO';

COMMENT ON COLUMN "RENEWAL_CONTRACT_APPLIED_RATE_EXP_PERIOD_VARIABLE_DATA"."EXP_PERIOD_FOUR_RENEWAL_CONTRACT_GRADE_FROM" IS '유효기간4 갱신계약 적용등급 FROM';

COMMENT ON COLUMN "RENEWAL_CONTRACT_APPLIED_RATE_EXP_PERIOD_VARIABLE_DATA"."EXP_PERIOD_FOUR_RENEWAL_CONTRACT_GRADE_TO" IS '유효기간4 갱신계약 적용등급 TO';

CREATE TABLE "EVALUATION_PERIOD_VARIABLE_DATA" (
                                                   "ID"	NUMBER(38, 0)		NOT NULL,
                                                   "NAME"	VARCHAR(255)		NULL,
                                                   "EVALUATION_PERIOD_ONE_DATE_A"	NUMBER(38, 0)		NULL,
                                                   "EVALUATION_PERIOD_ONE_DATE_B"	NUMBER(38, 0)		NULL,
                                                   "EVALUATION_PERIOD_TWO_DATE_A"	NUMBER(38, 0)		NULL,
                                                   "EVALUATION_PERIOD_THREE_DATE_A"	NUMBER(38, 0)		NULL
);

COMMENT ON COLUMN "EVALUATION_PERIOD_VARIABLE_DATA"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "EVALUATION_PERIOD_VARIABLE_DATA"."NAME" IS '분류명';

COMMENT ON COLUMN "EVALUATION_PERIOD_VARIABLE_DATA"."EVALUATION_PERIOD_ONE_DATE_A" IS '기본 평가대상기간 전전계약 공제기간 만료일';

COMMENT ON COLUMN "EVALUATION_PERIOD_VARIABLE_DATA"."EVALUATION_PERIOD_ONE_DATE_B" IS '기본 평가대상기간 전계약 공제기간 만료일';

COMMENT ON COLUMN "EVALUATION_PERIOD_VARIABLE_DATA"."EVALUATION_PERIOD_TWO_DATE_A" IS '전전계약 공제만료일붜 전계약 공제기간 초일 2년 초과 경우';

COMMENT ON COLUMN "EVALUATION_PERIOD_VARIABLE_DATA"."EVALUATION_PERIOD_THREE_DATE_A" IS '전계약이 신계약인 경우';

CREATE TABLE "RANGE_RATE_VARIABLE_DATA" (
                                            "ID"	NUMBER(38, 0)		NOT NULL,
                                            "NAME"	VARCHAR(255)		NULL
);

COMMENT ON COLUMN "RANGE_RATE_VARIABLE_DATA"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "RANGE_RATE_VARIABLE_DATA"."NAME" IS '분류명';

CREATE TABLE "RANGE_RATE_VARIABLE_DATA_VALUE" (
                                                  "ID"	NUMBER(38, 0)		NOT NULL,
                                                  "RANGE_RATE_VARIABLE_DATA_ID"	NUMBER(38, 0)		NOT NULL,
                                                  "OWNED_TYPE"	VARCHAR(255)		NULL,
                                                  "PURPOSE_TYPE"	VARCHAR(255)		NULL,
                                                  "VEHICLE_TYPE"	VARCHAR(255)		NULL,
                                                  "DRIVER_LIMITED_TYPE"	VARCHAR(255)		NULL,
                                                  "AGE_LIMITED_TYPE"	VARCHAR(255)		NULL,
                                                  "AGE_RANGE_TYPE"	VARCHAR(255)		NULL,
                                                  "GRADE"	VARCHAR(255)		NULL,
                                                  "VALUE"	NUMBER		NULL
);

COMMENT ON COLUMN "RANGE_RATE_VARIABLE_DATA_VALUE"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "RANGE_RATE_VARIABLE_DATA_VALUE"."RANGE_RATE_VARIABLE_DATA_ID" IS '범위요율 변동데이터 ID';

COMMENT ON COLUMN "RANGE_RATE_VARIABLE_DATA_VALUE"."OWNED_TYPE" IS '차량 소유/개인소유, 법인소유';

COMMENT ON COLUMN "RANGE_RATE_VARIABLE_DATA_VALUE"."PURPOSE_TYPE" IS '차량 용도/유상운송, 기타';

COMMENT ON COLUMN "RANGE_RATE_VARIABLE_DATA_VALUE"."VEHICLE_TYPE" IS '차종/ 소형A, 소형B, 중형, 대형';

COMMENT ON COLUMN "RANGE_RATE_VARIABLE_DATA_VALUE"."DRIVER_LIMITED_TYPE" IS '운전자한정';

COMMENT ON COLUMN "RANGE_RATE_VARIABLE_DATA_VALUE"."AGE_LIMITED_TYPE" IS '연령한정/전연령, 19세 이상, 21세 이상, 24세 이상, 26세 이상, 30세 이상, 35세 이상';

COMMENT ON COLUMN "RANGE_RATE_VARIABLE_DATA_VALUE"."AGE_RANGE_TYPE" IS '연령범위/20세 이하, 22~24세, 25~30세, 31~35세, 36~43세, 44~49세, 50~55세, 56~70세. 71세 이상';

COMMENT ON COLUMN "RANGE_RATE_VARIABLE_DATA_VALUE"."GRADE" IS '등급';

COMMENT ON COLUMN "RANGE_RATE_VARIABLE_DATA_VALUE"."VALUE" IS '요율값';

CREATE TABLE "INHERITED_INSURANCE_GRADE_VARIABLE_DATA" (
                                                           "ID"	NUMBER(38, 0)		NOT NULL,
                                                           "NAME"	VARCHAR(255)		NULL
);

COMMENT ON COLUMN "INHERITED_INSURANCE_GRADE_VARIABLE_DATA"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "INHERITED_INSURANCE_GRADE_VARIABLE_DATA"."NAME" IS '분류명';

CREATE TABLE "INHERITED_INSURANCE_GRADE_VARIABLE_DATA_VALUE" (
                                                                 "ID"	NUMBER(38, 0)		NOT NULL,
                                                                 "INHERITED_INSURANCE_GRADE_VARIABLE_DATA_ID"	NUMBER(38, 0)		NOT NULL,
                                                                 "INSURANCE_GRADE"	VARCHAR(255)		NULL,
                                                                 "PRIVATELY_OWNED_PAID_TRANSPORTATION_GRADE"	VARCHAR(255)		NULL,
                                                                 "PRIVATELY_OWNED_OTHER_GRADE"	VARCHAR(255)		NULL,
                                                                 "CORPORATION_OWNED_PAID_TRANSPORTATION_GRADE"	VARCHAR(255)		NULL,
                                                                 "CORPORATION_OWNED_OTHER_GRADE"	VARCHAR(255)		NULL
);

COMMENT ON COLUMN "INHERITED_INSURANCE_GRADE_VARIABLE_DATA_VALUE"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "INHERITED_INSURANCE_GRADE_VARIABLE_DATA_VALUE"."INHERITED_INSURANCE_GRADE_VARIABLE_DATA_ID" IS '손해보험사 적용등급 승계 변동데이터 ID';

COMMENT ON COLUMN "INHERITED_INSURANCE_GRADE_VARIABLE_DATA_VALUE"."INSURANCE_GRADE" IS '손해보험사 등급';

COMMENT ON COLUMN "INHERITED_INSURANCE_GRADE_VARIABLE_DATA_VALUE"."PRIVATELY_OWNED_PAID_TRANSPORTATION_GRADE" IS '개인소유(유상운송) 등급';

COMMENT ON COLUMN "INHERITED_INSURANCE_GRADE_VARIABLE_DATA_VALUE"."PRIVATELY_OWNED_OTHER_GRADE" IS '개인소유(기타) 등급';

COMMENT ON COLUMN "INHERITED_INSURANCE_GRADE_VARIABLE_DATA_VALUE"."CORPORATION_OWNED_PAID_TRANSPORTATION_GRADE" IS '법인소유(유상운송) 등급';

COMMENT ON COLUMN "INHERITED_INSURANCE_GRADE_VARIABLE_DATA_VALUE"."CORPORATION_OWNED_OTHER_GRADE" IS '법인소유(기타) 등급';

CREATE TABLE "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA" (
                                                                           "ID"	NUMBER(38, 0)		NOT NULL,
                                                                           "NAME"	VARCHAR(255)		NULL
);

COMMENT ON COLUMN "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA"."NAME" IS '분류명';

CREATE TABLE "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_VALUE" (
                                                                                 "ID"	NUMBER(38, 0)		NOT NULL,
                                                                                 "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_ID"	NUMBER(38, 0)		NOT NULL,
                                                                                 "NORMAL_GRADE"	NUMBER(38, 0)		NULL,
                                                                                 "APPLIED_GRADE_FROM"	NUMBER(38, 0)		NULL,
                                                                                 "APPLIED_GRADE_TO"	NUMBER(38, 0)		NULL,
                                                                                 "PRIVATELY_OWNED_PAID_TRANSPORTATION_APPLIED_RATE"	NUMBER		NULL,
                                                                                 "PRIVATELY_OWNED_OTHER_APPLIED_RATE"	NUMBER		NULL,
                                                                                 "CORPORATION_OWNED_PAID_TRANSPORTATION_APPLIED_RATE"	NUMBER		NULL,
                                                                                 "CORPORATION_OWNED_OTHER_APPLIED_RATE"	NUMBER		NULL,
                                                                                 "LEASE_VEHICLE_APPLIED_RATE"	NUMBER		NULL
);

COMMENT ON COLUMN "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_VALUE"."ID" IS 'SEQUENCE';

COMMENT ON COLUMN "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_VALUE"."APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_ID" IS '적용등급 및 일반등급별 적용률 변동데이터 ID';

COMMENT ON COLUMN "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_VALUE"."NORMAL_GRADE" IS '일반등급';

COMMENT ON COLUMN "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_VALUE"."APPLIED_GRADE_FROM" IS '적용등급 FROM';

COMMENT ON COLUMN "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_VALUE"."APPLIED_GRADE_TO" IS '적용등급 TO';

COMMENT ON COLUMN "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_VALUE"."PRIVATELY_OWNED_PAID_TRANSPORTATION_APPLIED_RATE" IS '개인소유(유상운송) 적용률';

COMMENT ON COLUMN "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_VALUE"."PRIVATELY_OWNED_OTHER_APPLIED_RATE" IS '개인소유(기타) 적용률';

COMMENT ON COLUMN "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_VALUE"."CORPORATION_OWNED_PAID_TRANSPORTATION_APPLIED_RATE" IS '법인소유(유상운송) 적용률';

COMMENT ON COLUMN "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_VALUE"."CORPORATION_OWNED_OTHER_APPLIED_RATE" IS '법인소유(기타) 적용률';

COMMENT ON COLUMN "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_VALUE"."LEASE_VEHICLE_APPLIED_RATE" IS '대여(리스) 차량 적용률';

ALTER TABLE "SPECIAL_EXTRA_CHARGE_RATE" ADD CONSTRAINT "PK_SPECIAL_EXTRA_CHARGE_RATE" PRIMARY KEY (
                                                                                                   "ID"
    );

ALTER TABLE "PRIVATELY_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA" ADD CONSTRAINT "PK_PRIVATELY_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA" PRIMARY KEY (
                                                                                                                                                                                       "ID"
    );

ALTER TABLE "CORPORATION_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA" ADD CONSTRAINT "PK_CORPORATION_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA" PRIMARY KEY (
                                                                                                                                                                                           "ID"
    );

ALTER TABLE "INSURED_CHARACTERISTICS_RATE" ADD CONSTRAINT "PK_INSURED_CHARACTERISTICS_RATE" PRIMARY KEY (
                                                                                                         "ID"
    );

ALTER TABLE "SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA" ADD CONSTRAINT "PK_SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA" PRIMARY KEY (
                                                                                                                                     "ID"
    );

ALTER TABLE "SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA_VALUE" ADD CONSTRAINT "PK_SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA_VALUE" PRIMARY KEY (
                                                                                                                                                 "ID"
    );

ALTER TABLE "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE" ADD CONSTRAINT "PK_INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE" PRIMARY KEY (
                                                                                                                           "ID"
    );

ALTER TABLE "NEW_ACCIDENT_SCORE_VARIABLE_DATA" ADD CONSTRAINT "PK_NEW_ACCIDENT_SCORE_VARIABLE_DATA" PRIMARY KEY (
                                                                                                                 "ID"
    );

ALTER TABLE "FOLLOW_UP_ACTION_SCORE_VARIABLE_DATA" ADD CONSTRAINT "PK_FOLLOW_UP_ACTION_SCORE_VARIABLE_DATA" PRIMARY KEY (
                                                                                                                         "ID"
    );

ALTER TABLE "ACCIDENT_CAUSE_SCORE_VARIABLE_DATA" ADD CONSTRAINT "PK_ACCIDENT_CAUSE_SCORE_VARIABLE_DATA" PRIMARY KEY (
                                                                                                                     "ID"
    );

ALTER TABLE "DEFAULT_AND_NEW_CONTRACT_APPLIED_GRADE_VARIABLE_DATA" ADD CONSTRAINT "PK_DEFAULT_AND_NEW_CONTRACT_APPLIED_GRADE_VARIABLE_DATA" PRIMARY KEY (
                                                                                                                                                         "ID"
    );

ALTER TABLE "RENEWAL_CONTRACT_EVALUATION_STANDARD_VARIABLE_DATA" ADD CONSTRAINT "PK_RENEWAL_CONTRACT_EVALUATION_STANDARD_VARIABLE_DATA" PRIMARY KEY (
                                                                                                                                                     "ID"
    );

ALTER TABLE "RENEWAL_CONTRACT_APPLIED_RATE_EXP_PERIOD_VARIABLE_DATA" ADD CONSTRAINT "PK_RENEWAL_CONTRACT_APPLIED_RATE_EXP_PERIOD_VARIABLE_DATA" PRIMARY KEY (
                                                                                                                                                             "ID"
    );

ALTER TABLE "EVALUATION_PERIOD_VARIABLE_DATA" ADD CONSTRAINT "PK_EVALUATION_PERIOD_VARIABLE_DATA" PRIMARY KEY (
                                                                                                               "ID"
    );

ALTER TABLE "RANGE_RATE_VARIABLE_DATA" ADD CONSTRAINT "PK_RANGE_RATE_VARIABLE_DATA" PRIMARY KEY (
                                                                                                 "ID"
    );

ALTER TABLE "RANGE_RATE_VARIABLE_DATA_VALUE" ADD CONSTRAINT "PK_RANGE_RATE_VARIABLE_DATA_VALUE" PRIMARY KEY (
                                                                                                             "ID"
    );

ALTER TABLE "INHERITED_INSURANCE_GRADE_VARIABLE_DATA" ADD CONSTRAINT "PK_INHERITED_INSURANCE_GRADE_VARIABLE_DATA" PRIMARY KEY (
                                                                                                                               "ID"
    );

ALTER TABLE "INHERITED_INSURANCE_GRADE_VARIABLE_DATA_VALUE" ADD CONSTRAINT "PK_INHERITED_INSURANCE_GRADE_VARIABLE_DATA_VALUE" PRIMARY KEY (
                                                                                                                                           "ID"
    );

ALTER TABLE "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA" ADD CONSTRAINT "PK_APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA" PRIMARY KEY (
                                                                                                                                                               "ID"
    );

ALTER TABLE "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_VALUE" ADD CONSTRAINT "PK_APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_VALUE" PRIMARY KEY (
                                                                                                                                                                           "ID"
    );

ALTER TABLE "SPECIAL_EXTRA_CHARGE_RATE" ADD CONSTRAINT "FK_AUTO_FUNCTION_TO_SPECIAL_EXTRA_CHARGE_RATE_1" FOREIGN KEY (
                                                                                                                      "AUTO_FUNCTION_ID"
    )
    REFERENCES "AUTO_FUNCTION" (
                                "ID"
        );

ALTER TABLE "SPECIAL_EXTRA_CHARGE_RATE" ADD CONSTRAINT "FK_PRIVATELY_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA_TO_SPECIAL_EXTRA_CHARGE_RATE_1" FOREIGN KEY (
                                                                                                                                                                            "PRIVATELY_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA_ID"
    )
    REFERENCES "PRIVATELY_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA" (
                                                                                      "ID"
        );

ALTER TABLE "SPECIAL_EXTRA_CHARGE_RATE" ADD CONSTRAINT "FK_CORPORATION_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA_TO_SPECIAL_EXTRA_CHARGE_RATE_1" FOREIGN KEY (
                                                                                                                                                                              "CORPORATION_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA_ID"
    )
    REFERENCES "CORPORATION_OWNED_GROUP_SCORE_MAXIMUM_EXTRA_CHARGE_RATE_VARIABLE_DATA" (
                                                                                        "ID"
        );

ALTER TABLE "INSURED_CHARACTERISTICS_RATE" ADD CONSTRAINT "FK_AUTO_FUNCTION_TO_INSURED_CHARACTERISTICS_RATE_1" FOREIGN KEY (
                                                                                                                            "AUTO_FUNCTION_ID"
    )
    REFERENCES "AUTO_FUNCTION" (
                                "ID"
        );

ALTER TABLE "INSURED_CHARACTERISTICS_RATE" ADD CONSTRAINT "FK_SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA_TO_INSURED_CHARACTERISTICS_RATE_1" FOREIGN KEY (
                                                                                                                                                         "SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA_ID"
    )
    REFERENCES "SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA" (
                                                             "ID"
        );

ALTER TABLE "SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA_VALUE" ADD CONSTRAINT "FK_SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA_TO_SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA_VALUE_1" FOREIGN KEY (
                                                                                                                                                                                                 "SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA_ID"
    )
    REFERENCES "SUBSCRIPTION_EXPERIENCE_RATE_VARIABLE_DATA" (
                                                             "ID"
        );

ALTER TABLE "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE" ADD CONSTRAINT "FK_AUTO_FUNCTION_TO_INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE_1" FOREIGN KEY (
                                                                                                                                              "AUTO_FUNCTION_ID"
    )
    REFERENCES "AUTO_FUNCTION" (
                                "ID"
        );

ALTER TABLE "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE" ADD CONSTRAINT "FK_INHERITED_INSURANCE_GRADE_VARIABLE_DATA_TO_INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE_1" FOREIGN KEY (
                                                                                                                                                                        "INHERITED_INSURANCE_GRADE_VARIABLE_DATA_ID"
    )
    REFERENCES "INHERITED_INSURANCE_GRADE_VARIABLE_DATA" (
                                                          "ID"
        );

ALTER TABLE "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE" ADD CONSTRAINT "FK_EVALUATION_PERIOD_VARIABLE_DATA_TO_INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE_1" FOREIGN KEY (
                                                                                                                                                                "EVALUATION_PERIOD_VARIABLE_DATA_ID"
    )
    REFERENCES "EVALUATION_PERIOD_VARIABLE_DATA" (
                                                  "ID"
        );

ALTER TABLE "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE" ADD CONSTRAINT "FK_NEW_ACCIDENT_SCORE_VARIABLE_DATA_TO_INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE_1" FOREIGN KEY (
                                                                                                                                                                 "NEW_ACCIDENT_SCORE_VARIABLE_DATA_ID"
    )
    REFERENCES "NEW_ACCIDENT_SCORE_VARIABLE_DATA" (
                                                   "ID"
        );

ALTER TABLE "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE" ADD CONSTRAINT "FK_FOLLOW_UP_ACTION_SCORE_VARIABLE_DATA_TO_INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE_1" FOREIGN KEY (
                                                                                                                                                                     "FOLLOW_UP_ACTION_SCORE_VARIABLE_DATA_ID"
    )
    REFERENCES "FOLLOW_UP_ACTION_SCORE_VARIABLE_DATA" (
                                                       "ID"
        );

ALTER TABLE "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE" ADD CONSTRAINT "FK_ACCIDENT_CAUSE_SCORE_VARIABLE_DATA_TO_INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE_1" FOREIGN KEY (
                                                                                                                                                                   "ACCIDENT_CAUSE_SCORE_VARIABLE_DATA_ID"
    )
    REFERENCES "ACCIDENT_CAUSE_SCORE_VARIABLE_DATA" (
                                                     "ID"
        );

ALTER TABLE "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE" ADD CONSTRAINT "FK_DEFAULT_AND_NEW_CONTRACT_APPLIED_GRADE_VARIABLE_DATA_TO_INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE_1" FOREIGN KEY (
                                                                                                                                                                                     "DEFAULT_AND_NEW_CONTRACT_APPLIED_GRADE_VARIABLE_DATA_ID"
    )
    REFERENCES "DEFAULT_AND_NEW_CONTRACT_APPLIED_GRADE_VARIABLE_DATA" (
                                                                       "ID"
        );

ALTER TABLE "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE" ADD CONSTRAINT "FK_RENEWAL_CONTRACT_EVALUATION_STANDARD_VARIABLE_DATA_TO_INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE_1" FOREIGN KEY (
                                                                                                                                                                                   "RENEWAL_CONTRACT_EVALUATION_STANDARD_VARIABLE_DATA_ID"
    )
    REFERENCES "RENEWAL_CONTRACT_EVALUATION_STANDARD_VARIABLE_DATA" (
                                                                     "ID"
        );

ALTER TABLE "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE" ADD CONSTRAINT "FK_APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_TO_INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE_1" FOREIGN KEY (
                                                                                                                                                                                        "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_ID"
    )
    REFERENCES "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA" (
                                                                          "ID"
        );

ALTER TABLE "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE" ADD CONSTRAINT "FK_RENEWAL_CONTRACT_APPLIED_RATE_EXP_PERIOD_VARIABLE_DATA_TO_INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE_1" FOREIGN KEY (
                                                                                                                                                                                       "RENEWAL_CONTRACT_APPLIED_RATE_EXP_PERIOD_VARIABLE_DATA_ID"
    )
    REFERENCES "RENEWAL_CONTRACT_APPLIED_RATE_EXP_PERIOD_VARIABLE_DATA" (
                                                                         "ID"
        );

ALTER TABLE "INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE" ADD CONSTRAINT "FK_RANGE_RATE_VARIABLE_DATA_TO_INDIVIDUAL_DISCOUNT_EXTRA_CHARGE_RATE_1" FOREIGN KEY (
                                                                                                                                                         "RANGE_RATE_VARIABLE_DATA_ID"
    )
    REFERENCES "RANGE_RATE_VARIABLE_DATA" (
                                           "ID"
        );

ALTER TABLE "RANGE_RATE_VARIABLE_DATA_VALUE" ADD CONSTRAINT "FK_RANGE_RATE_VARIABLE_DATA_TO_RANGE_RATE_VARIABLE_DATA_VALUE_1" FOREIGN KEY (
                                                                                                                                           "RANGE_RATE_VARIABLE_DATA_ID"
    )
    REFERENCES "RANGE_RATE_VARIABLE_DATA" (
                                           "ID"
        );

ALTER TABLE "INHERITED_INSURANCE_GRADE_VARIABLE_DATA_VALUE" ADD CONSTRAINT "FK_INHERITED_INSURANCE_GRADE_VARIABLE_DATA_TO_INHERITED_INSURANCE_GRADE_VARIABLE_DATA_VALUE_1" FOREIGN KEY (
                                                                                                                                                                                        "INHERITED_INSURANCE_GRADE_VARIABLE_DATA_ID"
    )
    REFERENCES "INHERITED_INSURANCE_GRADE_VARIABLE_DATA" (
                                                          "ID"
        );

ALTER TABLE "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_VALUE" ADD CONSTRAINT "FK_APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_TO_APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_VALUE_1" FOREIGN KEY (
                                                                                                                                                                                                                                        "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA_ID"
    )
    REFERENCES "APPLIED_RATE_BY_DEFAULT_AND_APPLIED_GRADE_VARIABLE_DATA" (
                                                                          "ID"
        );

