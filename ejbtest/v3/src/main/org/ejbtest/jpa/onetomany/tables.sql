drop table jpa_otm_topic;
drop table jpa_otm_polloption;
drop table hibernate_sequences;

create table jpa_otm_topic(
   topic_id number primary key,
   topic_title varchar2(200),
   topic_type varchar2(50),
   topic_time date,
   topic_views integer,
   multiple number(1,0),
   MAX_CHOICES integer
);
create table jpa_otm_polloption(
   option_id number primary key,
   option_item varchar2(200),
   topic_id number
);

create table hibernate_sequences(
	SEQUENCE_NAME varchar2(100),
	SEQUENCE_NEXT_HI_VALUE number
);