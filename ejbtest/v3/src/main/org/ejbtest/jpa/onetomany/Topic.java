/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file org.jpa.onetomany.Topic.java is
 * created on 2008-7-15
 */
package org.ejbtest.jpa.onetomany;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 */
@Entity(name = "jpa_otm_topic")
// �? @Entity：将领域对象标注为一个实体，表示�?要保存到数据库中，默认情况下类名即为表名，�?�过name属�?�显式指定表名，如①处的name =
// "T_TOPIC"，表示Topic保存到T_TOPIC表中�?
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// 对于继承的实体，在javax.persistence.InheritanceType定义�?3种映射策略，�?
// �?
// SINGLE_TABLE�?
// 父子类都保存到同�?个表中，通过字段值进行区分�?�这是我们Topic实体�?采用的策略，Topic和PollTopic都保存到同一张表中，通过TOPIC_TYPE字段进行区分，Topic在T_TOPIC表中对应TOPIC_TYPE=1的记录，而PollTopic对应TOPIC_TYPE=2的记录（稍后在PollTopic实体中指定）；区别的字段通过@DiscriminatorColumn说明，如②所示，区分字段对应该实体的值�?�过@DiscriminatorValue指定，如③所示；
// �? JOINED�? 父子类相同的部分保存在同�?个表中，不同的部分分�?存放，�?�过表连接获取完整数据；
// �? TABLE_PER_CLASS：每�?个类对应自己的表，一般不推荐采用这种方式�?
@DiscriminatorColumn(name = "TOPIC_TYPE", discriminatorType = DiscriminatorType.STRING, length = 20)
@DiscriminatorValue(value = "Topic")
public class Topic {
    
    @Id
//    @TableGenerator(name="hibernate_sequence",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE/*, generator="hibernate_sequence"*/ )    
    // @GeneratedValue：主键的产生策略，�?�过strategy属�?�指定�?�默认情况下，JPA自动选择�?个最适合底层数据库的主键生成策略，如SqlServer对应identity，MySql对应auto
    // increment。在javax.persistence.GenerationType中定义了以下几种可供选择的策略：
    // �? 1) IDENTITY：表自增键字段，Oracle不支持这种方式；
    // �? 2) AUTO�? JPA自动选择合�?�的策略，是默认选项�?
    // �? 3) SEQUENCE：�?�过序列产生主键，�?�过@SequenceGenerator注解指定序列名，MySql不支持这种方式；
    // �? 4)
    // TABLE：�?�过表产生主键，框架借由表模拟序列产生主键，使用该策略可以使应用更易于数据库移植�?
    // 不同的JPA实现商生成的表名是不同的，如OpenJPA生成 openjpa_sequence_table�?
    // Hibernate生成�?个hibernate_sequences表，// 而TopLink则生成sequence表�?�这些表都具有一个序列名和对应�?�两个字段，如SEQ_NAME和SEQ_COUNT�?
    // create table hibernate_sequences(
    // SEQUENCE_NAME varchar2(100),
    // SEQUENCE_NEXT_HI_VALUE number
    //);
    @Column(name = "TOPIC_ID")
    @SequenceGenerator(name="", sequenceName="d")
    
    private int topicId;

    @Column(name = "TOPIC_TITLE", length = 100)
    private String topicTitle;

    @Column(name = "TOPIC_TIME")
    @Temporal(TemporalType.DATE)
    private java.util.Date topicTime;

    @Column(name = "TOPIC_VIEWS")
    private int topicViews;

}
