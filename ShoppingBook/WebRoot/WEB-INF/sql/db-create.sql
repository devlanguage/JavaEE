#创建数据库
create database ShoppingBook;
use ShoppingBook;

#1.用户表tb_user:
create table tb_user
(
    id int primary key auto_increment,   #用户ID
    name varchar(30) not null,            #用户名
    password varchar(16) not null,       #密码
    email varchar(50) not null,              #邮箱
	trueName varchar(40) not null,          #昵称
    sex varchar(30),            #性别
    birthday varchar(20),        #生日
	address varchar(100),          #住址
	postcode varchar(10),           #邮编
	phone varchar(15),             #固定电话
	mphone varchar(15),          #手机
   	 question varchar(30) not null,        #问题
   	 answer varchar(30) not null,        #答案
	img varchar(100) ,                  #用户头像
	 score int default 1000                #积分 初始化为1000  不让用户填写 系统自动添加
);

#2.大类表
create table tb_superType
  (
    superTypeId int primary key auto_increment,     #大类Id
    typeName varchar(50)                        #大类名
  );
  
 

#3.小类表
create table tb_subType
  (
     subTypeId int primary key auto_increment,         #小类id
     superTypeId int,                             #大类id
     subTypeName varchar(50),                    #小类名
     foreign key(superTypeId) references tb_superType(superTypeId)        #设置外键
  );
  
  create table tb_subType
  (
     subTypeId int primary key auto_increment,         
     superTypeId int,                              
     subTypeName varchar(50),                    
     foreign key(superTypeId) references tb_superType(superTypeId)      
  );


#4.书表
  create table tb_book                 
(
  bookId int primary key auto_increment,        #书号
  superTypeId int,                              #大类ID                    
  subTypeId int,                                #小类ID                      
  bookName varchar(200),						#书名
  ISBN varchar(20),                             #ISBN号  流水号
  introduce text,                               #书本简介                             
  price float,                                  #原价                          
  nowPrice float,                               #现价                     
  picture varchar(200),  						#图片
  pages int,									#页数
  publisher varchar(40),						#出版社
  author varchar(20),                           #作者              
  inTime timestamp,                             #入库时间                         
  newBooks int,                                 #是否新品                    
  saleBooks int,                                #是否打折品                    
  hostBooks int,                                #是否热卖品  
  specialBooks int,                             #是否是特种书
  bookNum  int,                                 #书的数量                      
  foreign key(subTypeId ) references tb_subType(subTypeId),
  foreign key(superTypeId) references tb_superType (superTypeId)
 );
 
#5.书信息
create table tb_inform
(
   informId int primary key auto_increment,
   informTitle varchar(30),
   informContent varchar(30),
   informTime timestamp
);


#6.订单表

  create table tb_order
  (
    orderId int primary key auto_increment,  #订单id
name varchar(20),                            #用户名
realName varchar(20),                        #-真实姓名
    address varchar(20),                     #详细住址
    postcode varchar(10),                    #邮编
    email varchar(20),                       #邮箱
    orderDate timestamp,                     #下订单时间
    flag int                                  #是否发货 0 未发货 1 发货 2 货物冻结
  );
  
   

#7.订单详细信息
create table tb_orderItem
  (
    orderItemId int primary key auto_increment, #订单项id 
    orderId int,                                #订单id
    bookId int,                                 #书号
    bookName varchar(50),                       #书名
    price float,                                #价格
    bookNum int,                                #书的数量
    foreign key(orderId) references tb_order(orderId),
    foreign key(bookId) references tb_book(bookId)
  );

#8.留言板

create table tb_note 
(
  id int primary key auto_increment,       #-用户id
  title varchar(20) not null ,             #标题
  author varchar(20) not null ,            #用户名
  content varchar(50) not null ,           #内容
  ly_time timestamp,                       #留言时间
  imgs varchar(50)                         #用户头像
);  
create table tb_note 
(
  id int primary key auto_increment,       
  title varchar(20) not null ,              
  noteName varchar(20) not null ,            
  content varchar(50) not null ,            
  ly_time timestamp,                    
  imgs varchar(20)                     
);

#9.管理员表
create table tb_admin
(
	Name varchar(20),
	Password varchar(20)
);

commit;

#10.初始化数据
insert into tb_admin value('admin','123');

insert into tb_superType values(null,'IT技术');
insert into tb_superType values(null,'文学');
insert into tb_superType values(null,'艺术');
  
insert into tb_subType values(null,1,'程序设计');
insert into tb_subType values(null,1,'网络技术');
insert into tb_subType values(null,1,'计算机基础');
insert into tb_subType values(null,2,'中国文学');
insert into tb_subType values(null,2,'外国文学');
insert into tb_subType values(null,3,'油画');
insert into tb_subType values(null,3,'水彩');
insert into tb_subType values(null,3,'雕刻');
  	
insert into tb_book values(null,1,1,'皇帝柠檬2','200907046','《皇帝与柠檬经济学中的人性》讲述了：皇帝和柠檬有什么关系？如果我们把皇帝和大臣之间的关系看作一种交易，皇帝和大臣的关系就是柠檬市场，由于信息的不对称而引发种种问题。现实中许多我们认为很抽象很感性的事物，实际上都有其理性的根源....',25,16.8,'images/book1.jpg',320,'文学出版社','布鲁斯',null,1,1,0,0,120); 
insert into tb_book values(null,1,1,'我们的杜拉拉2','200907047','《我们的杜拉拉》收录了李可独家访谈，柳传志、徐静蕾、姚晨、赵赵、郎平以及千万读者感动热评，杜拉拉经典语录....',36,22.4,'images/book5.jpg',230,'新华出版社','爱死布鲁斯',null,0,1,0,1,120); 
insert into tb_book values(null,1,1,'佐藤可士和的超整理术2','200907048','《佐藤可士和的超整理术》：如果说原研哉奠定了无印良品的设计哲学的话,那佐藤可士和就创造了UNIQLO优衣库的视觉精神,而现在UNIQLO已经成为了一个新的日本设计象征....',56,49.8,'images/book3.jpg',412,'新华出版社','桑德勒',null,0,1,1,1,120); 
insert into tb_book values(null,1,1,'EnglishBook2','200907049','This is the Asian adaptation of N. Gregory Mankiw s market leading textbook Principles of Economics. While maintaining all the strengths of the original book, Professor Euston Quah and Dr. Peter Wilson have provided materials and examples that are most relevant to students in Asia.',39,37.4,'images/book9.jpg',502,'新华出版社','希特勒桑德勒',null,1,1,1,1,120); 
insert into tb_book values(null,1,1,'晚间西红柿减肥','9787531723950','本书是日本销量第一的美容减肥畅销书，上市3个月狂卖85万册。本书作者，“日本第一的西红柿博士”——唐泽明告诉大家，西红柿减肥好吃、轻松、易瘦、健康、美肤，在3个月内减掉11斤并且使肌肤回到21岁时的状态。不管大家是否爱吃西红柿，晚间西红柿减肥都能持续下去，因为晚间西红柿有如下秘诀：清清爽爽的血液、滑溜溜的肌肤、美美地吃、舒舒服服、瘦！来自西红柿的美丽瘦身+美肤过程，你一定要亲身体验一番哦',22,11.6,'images/1.jpg',128,'北方文艺出版社','（日）唐泽明　著，周晓晗　译',null,1,1,1,1,120); 
insert into tb_book values(null,1,1,'晚间西红柿','9787531723987','本书是日本销量第一的美容减肥畅销书，上市3个月狂卖85万册。本书作者，“日本第一的西红柿博士”——唐泽明告诉大家，西红柿减肥好吃、轻松、易瘦、健康、美肤，在3个月内减掉11斤并且使肌肤回到21岁时的状态。不管大家是否爱吃西红柿，晚间西红柿减肥都能持续下去，因为晚间西红柿有如下秘诀：清清爽爽的血液、滑溜溜的肌肤、美美地吃、舒舒服服、瘦！来自西红柿的美丽瘦身+美肤过程，你一定要亲身体验一番哦',54,46.6,'images/7.jpg',128,'北方文艺出版社','（日）唐泽明　著，周晓晗　译',null,1,1,1,1,120); 
insert into tb_book values(null,1,1,'西红柿','97875317239657','本书是日本销量第一的美容减肥畅销书，上市3个月狂卖85万册。本书作者，“日本第一的西红柿博士”——唐泽明告诉大家，西红柿减肥好吃、轻松、易瘦、健康、美肤，在3个月内减掉11斤并且使肌肤回到21岁时的状态。不管大家是否爱吃西红柿，晚间西红柿减肥都能持续下去，因为晚间西红柿有如下秘诀：清清爽爽的血液、滑溜溜的肌肤、美美地吃、舒舒服服、瘦！来自西红柿的美丽瘦身+美肤过程，你一定要亲身体验一番哦',34,26.6,'images/8.jpg',128,'北方文艺出版社','（日）唐泽明　著，周晓晗　译',null,1,1,1,1,120); 
insert into tb_book values(null,1,1,'西红柿平','978753176657','本书是日本销量第一的美容减肥畅销书，上市3个月狂卖85万册。本书作者，“日本第一的西红柿博士”——唐泽明告诉大家，西红柿减肥好吃、轻松、易瘦、健康、美肤，在3个月内减掉11斤并且使肌肤回到21岁时的状态。不管大家是否爱吃西红柿，晚间西红柿减肥都能持续下去，因为晚间西红柿有如下秘诀：清清爽爽的血液、滑溜溜的肌肤、美美地吃、舒舒服服、瘦！来自西红柿的美丽瘦身+美肤过程，你一定要亲身体验一番哦',44,36.6,'images/9.jpg',128,'北方文艺出版社','（日）唐泽明　著，周晓晗　译',null,1,1,1,1,120); 
insert into tb_book values(null,1,1,'郎咸平说','9787531723951','在本书中，郎咸平教授谈兴甚浓，兴致盎然，语言大胆诙谐，而且看问题一针见血，直达事件最真实层面。从3.14事件中CNN对中国的诋毁、到汶川大地震的众志成城；从大众对奥运经济的过度期盼到奥运礼仪的中华风采；还有海峡两岸对台湾现状的真实解读，功夫熊猫凸显的文化融合以及诸葛亮能否成为优秀的企业家；郎教授都做了最真切的解读，全部都是在电视、平面媒体上闻所未闻的观点，这是在郎教授对东西两种文化体系透彻理解的基础上并且从社会民众中的普遍的小细节中展示出大事件的根本趋势',25,13.6,'images/2.jpg',128,'北方文艺出版社','郎咸平',null,1,1,1,1,120); 
insert into tb_book values(null,1,1,'郎咸平说234','97875317239511','在本书中，郎咸平教授谈兴甚浓，兴致盎然，语言大胆诙谐，而且看问题一针见血，直达事件最真实层面。从3.14事件中CNN对中国的诋毁、到汶川大地震的众志成城；从大众对奥运经济的过度期盼到奥运礼仪的中华风采；还有海峡两岸对台湾现状的真实解读，功夫熊猫凸显的文化融合以及诸葛亮能否成为优秀的企业家；郎教授都做了最真切的解读，全部都是在电视、平面媒体上闻所未闻的观点，这是在郎教授对东西两种文化体系透彻理解的基础上并且从社会民众中的普遍的小细节中展示出大事件的根本趋势',25,13.6,'images/3.jpg',128,'北方文艺出版社','郎咸平',null,1,1,1,1,120); 
insert into tb_book values(null,1,1,'郎咸平说6767','97875317239512','在本书中，郎咸平教授谈兴甚浓，兴致盎然，语言大胆诙谐，而且看问题一针见血，直达事件最真实层面。从3.14事件中CNN对中国的诋毁、到汶川大地震的众志成城；从大众对奥运经济的过度期盼到奥运礼仪的中华风采；还有海峡两岸对台湾现状的真实解读，功夫熊猫凸显的文化融合以及诸葛亮能否成为优秀的企业家；郎教授都做了最真切的解读，全部都是在电视、平面媒体上闻所未闻的观点，这是在郎教授对东西两种文化体系透彻理解的基础上并且从社会民众中的普遍的小细节中展示出大事件的根本趋势',25,13.6,'images/4.jpg',128,'北方文艺出版社','郎咸平',null,1,1,1,1,120); 
insert into tb_book values(null,1,1,'郎咸平说897','97875317239514','在本书中，郎咸平教授谈兴甚浓，兴致盎然，语言大胆诙谐，而且看问题一针见血，直达事件最真实层面。从3.14事件中CNN对中国的诋毁、到汶川大地震的众志成城；从大众对奥运经济的过度期盼到奥运礼仪的中华风采；还有海峡两岸对台湾现状的真实解读，功夫熊猫凸显的文化融合以及诸葛亮能否成为优秀的企业家；郎教授都做了最真切的解读，全部都是在电视、平面媒体上闻所未闻的观点，这是在郎教授对东西两种文化体系透彻理解的基础上并且从社会民众中的普遍的小细节中展示出大事件的根本趋势',34,23.6,'images/5.jpg',128,'北方文艺出版社','郎咸平',null,1,1,1,1,120); 
insert into tb_book values(null,1,1,'郎咸平说455','97875317239517','在本书中，郎咸平教授谈兴甚浓，兴致盎然，语言大胆诙谐，而且看问题一针见血，直达事件最真实层面。从3.14事件中CNN对中国的诋毁、到汶川大地震的众志成城；从大众对奥运经济的过度期盼到奥运礼仪的中华风采；还有海峡两岸对台湾现状的真实解读，功夫熊猫凸显的文化融合以及诸葛亮能否成为优秀的企业家；郎教授都做了最真切的解读，全部都是在电视、平面媒体上闻所未闻的观点，这是在郎教授对东西两种文化体系透彻理解的基础上并且从社会民众中的普遍的小细节中展示出大事件的根本趋势',39,37.6,'images/6.jpg',128,'北方文艺出版社','郎咸平',null,1,1,1,1,120); 
 
  
  
insert into tb_book values(null,1,1,'晚间西红柿减肥','9787531723950','本书是日本销量第一的美容减肥畅销书，上市3个月狂卖85万册。本书作者，日本第一的西红柿博士--唐泽明告诉大家，西红柿减肥好吃、轻松、易瘦、健康、美肤，在3个月内减掉11斤并且使肌肤回到21岁时的状态。不管大家是否爱吃西红柿，晚间西红柿减肥都能持续下去，因为晚间西红柿有如下秘诀：清清爽爽的血液、滑溜溜的肌肤、美美地吃、舒舒服服、瘦！来自西红柿的美丽瘦身+美肤过程，你一定要亲身体验一番哦',22,11.6,'images/1.jpg',128,'北方文艺出版社','（日）唐泽明　著，周晓晗　译',null,1,1,1,1,120); 
insert into tb_book values(null,1,1,'晚间西红柿','9787531723987','本书是日本销量第一的美容减肥畅销书，上市3个月狂卖85万册。本书作者，日本第一的西红柿博士”--唐泽明告诉大家，西红柿减肥好吃、轻松、易瘦、健康、美肤，在3个月内减掉11斤并且使肌肤回到21岁时的状态。不管大家是否爱吃西红柿，晚间西红柿减肥都能持续下去，因为晚间西红柿有如下秘诀：清清爽爽的血液、滑溜溜的肌肤、美美地吃、舒舒服服、瘦！来自西红柿的美丽瘦身+美肤过程，你一定要亲身体验一番哦',54,46.6,'images/7.jpg',128,'北方文艺出版社','（日）唐泽明　著，周晓晗　译',null,1,1,1,1,120); 
insert into tb_book values(null,1,1,'西红柿','97875317239657','本书是日本销量第一的美容减肥畅销书，上市3个月狂卖85万册。本书作者，日本第一的西红柿博士”--唐泽明告诉大家，西红柿减肥好吃、轻松、易瘦、健康、美肤，在3个月内减掉11斤并且使肌肤回到21岁时的状态。不管大家是否爱吃西红柿，晚间西红柿减肥都能持续下去，因为晚间西红柿有如下秘诀：清清爽爽的血液、滑溜溜的肌肤、美美地吃、舒舒服服、瘦！来自西红柿的美丽瘦身+美肤过程，你一定要亲身体验一番哦',34,26.6,'images/8.jpg',128,'北方文艺出版社','（日）唐泽明　著，周晓晗　译',null,1,1,1,1,120); 
insert into tb_book values(null,1,1,'西红柿平','978753176657','本书是日本销量第一的美容减肥畅销书，上市3个月狂卖85万册。本书作者，日本第一的西红柿博士”--唐泽明告诉大家，西红柿减肥好吃、轻松、易瘦、健康、美肤，在3个月内减掉11斤并且使肌肤回到21岁时的状态。不管大家是否爱吃西红柿，晚间西红柿减肥都能持续下去，因为晚间西红柿有如下秘诀：清清爽爽的血液、滑溜溜的肌肤、美美地吃、舒舒服服、瘦！来自西红柿的美丽瘦身+美肤过程，你一定要亲身体验一番哦',44,36.6,'images/9.jpg',128,'北方文艺出版社','（日）唐泽明　著，周晓晗　译',null,1,1,1,1,120); 
  
