/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : shoppingbook
Target Host     : localhost:3306
Target Database : shoppingbook
Date: 2011-05-12 09:10:51
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `Name` varchar(20) NOT NULL,
  `Password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('admin', '123');

-- ----------------------------
-- Table structure for tb_book
-- ----------------------------
DROP TABLE IF EXISTS `tb_book`;
CREATE TABLE `tb_book` (
  `bookId` int(11) NOT NULL AUTO_INCREMENT,
  `superTypeId` int(11) DEFAULT NULL,
  `subTypeId` int(11) DEFAULT NULL,
  `bookName` varchar(200) DEFAULT NULL,
  `ISBN` varchar(20) DEFAULT NULL,
  `introduce` text,
  `price` float DEFAULT NULL,
  `nowPrice` float DEFAULT NULL,
  `picture` varchar(200) DEFAULT NULL,
  `pages` int(11) DEFAULT NULL,
  `publisher` varchar(40) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `inTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `newBooks` int(11) DEFAULT NULL,
  `saleBooks` int(11) DEFAULT NULL,
  `hostBooks` int(11) DEFAULT NULL,
  `specialBooks` int(11) DEFAULT NULL,
  `bookNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`bookId`),
  KEY `subTypeId` (`subTypeId`),
  KEY `superTypeId` (`superTypeId`),
  CONSTRAINT `tb_book_ibfk_1` FOREIGN KEY (`subTypeId`) REFERENCES `tb_subtype` (`subTypeId`),
  CONSTRAINT `tb_book_ibfk_2` FOREIGN KEY (`superTypeId`) REFERENCES `tb_supertype` (`superTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_book
-- ----------------------------
INSERT INTO `tb_book` VALUES ('1', '1', '1', '鐨囧笣鏌犳2', '200907046', '銆婄殗甯濅笌鏌犳缁忔祹瀛︿腑鐨勪汉鎬с�嬭杩颁簡锛氱殗甯濆拰鏌犳鏈変粈涔堝叧绯伙紵濡傛灉鎴戜滑鎶婄殗甯濆拰澶ц嚕涔嬮棿鐨勫叧绯荤湅浣滀竴绉嶄氦鏄擄紝鐨囧笣鍜屽ぇ鑷ｇ殑鍏崇郴灏辨槸鏌犳甯傚満锛岀敱浜庝俊鎭殑涓嶅绉拌�屽紩鍙戠绉嶉棶棰樸�傜幇瀹炰腑璁稿鎴戜滑璁や负寰堟娊璞″緢鎰熸�х殑浜嬬墿锛屽疄闄呬笂閮芥湁鍏剁悊鎬х殑鏍规簮....', '25', '16.8', 'images/book1.jpg', '320', '鏂囧鍑虹増绀�', '甯冮瞾鏂�', '2011-05-12 08:54:57', '1', '1', '0', '0', '120');
INSERT INTO `tb_book` VALUES ('2', '1', '1', '鎴戜滑鐨勬潨鎷夋媺2', '200907047', '銆婃垜浠殑鏉滄媺鎷夈�嬫敹褰曚簡鏉庡彲鐙璁胯皥锛屾煶浼犲織銆佸緪闈欒暰銆佸鏅ㄣ�佽档璧点�侀儙骞充互鍙婂崈涓囪鑰呮劅鍔ㄧ儹璇勶紝鏉滄媺鎷夌粡鍏歌褰�....', '36', '22.4', 'images/book5.jpg', '230', '鏂板崕鍑虹増绀�', '鐖辨甯冮瞾鏂�', '2011-05-12 08:54:57', '0', '1', '0', '1', '120');
INSERT INTO `tb_book` VALUES ('3', '1', '1', '浣愯棨鍙＋鍜岀殑瓒呮暣鐞嗘湳2', '200907048', '銆婁綈钘ゅ彲澹拰鐨勮秴鏁寸悊鏈�嬶細濡傛灉璇村師鐮斿搲濂犲畾浜嗘棤鍗拌壇鍝佺殑璁捐鍝插鐨勮瘽,閭ｄ綈钘ゅ彲澹拰灏卞垱閫犱簡UNIQLO浼樿。搴撶殑瑙嗚绮剧,鑰岀幇鍦║NIQLO宸茬粡鎴愪负浜嗕竴涓柊鐨勬棩鏈璁¤薄寰�....', '56', '49.8', 'images/book3.jpg', '412', '鏂板崕鍑虹増绀�', '妗戝痉鍕�', '2011-05-12 08:54:57', '0', '1', '1', '1', '120');
INSERT INTO `tb_book` VALUES ('4', '1', '1', 'EnglishBook2', '200907049', 'This is the Asian adaptation of N. Gregory Mankiw s market leading textbook Principles of Economics. While maintaining all the strengths of the original book, Professor Euston Quah and Dr. Peter Wilson have provided materials and examples that are most relevant to students in Asia.', '39', '37.4', 'images/book9.jpg', '502', '鏂板崕鍑虹増绀�', '甯岀壒鍕掓寰峰嫆', '2011-05-12 08:54:57', '1', '1', '1', '1', '120');
INSERT INTO `tb_book` VALUES ('5', '1', '1', '閮庡捀骞宠', '9787531723951', '鍦ㄦ湰涔︿腑锛岄儙鍜稿钩鏁欐巿璋堝叴鐢氭祿锛屽叴鑷寸泿鐒讹紝璇█澶ц儐璇欒皭锛岃�屼笖鐪嬮棶棰樹竴閽堣琛�锛岀洿杈句簨浠舵渶鐪熷疄灞傞潰銆備粠3.14浜嬩欢涓瑿NN瀵逛腑鍥界殑璇嬫瘉銆佸埌姹跺窛澶у湴闇囩殑浼楀織鎴愬煄锛涗粠澶т紬瀵瑰ゥ杩愮粡娴庣殑杩囧害鏈熺浖鍒板ゥ杩愮ぜ浠殑涓崕椋庨噰锛涜繕鏈夋捣宄′袱宀稿鍙版咕鐜扮姸鐨勭湡瀹炶В璇伙紝鍔熷か鐔婄尗鍑告樉鐨勬枃鍖栬瀺鍚堜互鍙婅钁涗寒鑳藉惁鎴愪负浼樼鐨勪紒涓氬锛涢儙鏁欐巿閮藉仛浜嗘渶鐪熷垏鐨勮В璇伙紝鍏ㄩ儴閮芥槸鍦ㄧ數瑙嗐�佸钩闈㈠獟浣撲笂闂绘墍鏈椈鐨勮鐐癸紝杩欐槸鍦ㄩ儙鏁欐巿瀵逛笢瑗夸袱绉嶆枃鍖栦綋绯婚�忓交鐞嗚В鐨勫熀纭�涓婂苟涓斾粠绀句細姘戜紬涓殑鏅亶鐨勫皬缁嗚妭涓睍绀哄嚭澶т簨浠剁殑鏍规湰瓒嬪娍', '25', '13.6', 'images/2.jpg', '128', '鍖楁柟鏂囪壓鍑虹増绀�', '閮庡捀骞�', '2011-05-12 08:54:58', '1', '1', '1', '1', '120');
INSERT INTO `tb_book` VALUES ('6', '1', '1', '閮庡捀骞宠234', '97875317239511', '鍦ㄦ湰涔︿腑锛岄儙鍜稿钩鏁欐巿璋堝叴鐢氭祿锛屽叴鑷寸泿鐒讹紝璇█澶ц儐璇欒皭锛岃�屼笖鐪嬮棶棰樹竴閽堣琛�锛岀洿杈句簨浠舵渶鐪熷疄灞傞潰銆備粠3.14浜嬩欢涓瑿NN瀵逛腑鍥界殑璇嬫瘉銆佸埌姹跺窛澶у湴闇囩殑浼楀織鎴愬煄锛涗粠澶т紬瀵瑰ゥ杩愮粡娴庣殑杩囧害鏈熺浖鍒板ゥ杩愮ぜ浠殑涓崕椋庨噰锛涜繕鏈夋捣宄′袱宀稿鍙版咕鐜扮姸鐨勭湡瀹炶В璇伙紝鍔熷か鐔婄尗鍑告樉鐨勬枃鍖栬瀺鍚堜互鍙婅钁涗寒鑳藉惁鎴愪负浼樼鐨勪紒涓氬锛涢儙鏁欐巿閮藉仛浜嗘渶鐪熷垏鐨勮В璇伙紝鍏ㄩ儴閮芥槸鍦ㄧ數瑙嗐�佸钩闈㈠獟浣撲笂闂绘墍鏈椈鐨勮鐐癸紝杩欐槸鍦ㄩ儙鏁欐巿瀵逛笢瑗夸袱绉嶆枃鍖栦綋绯婚�忓交鐞嗚В鐨勫熀纭�涓婂苟涓斾粠绀句細姘戜紬涓殑鏅亶鐨勫皬缁嗚妭涓睍绀哄嚭澶т簨浠剁殑鏍规湰瓒嬪娍', '25', '13.6', 'images/3.jpg', '128', '鍖楁柟鏂囪壓鍑虹増绀�', '閮庡捀骞�', '2011-05-12 08:54:58', '1', '1', '1', '1', '120');
INSERT INTO `tb_book` VALUES ('7', '1', '1', '閮庡捀骞宠6767', '97875317239512', '鍦ㄦ湰涔︿腑锛岄儙鍜稿钩鏁欐巿璋堝叴鐢氭祿锛屽叴鑷寸泿鐒讹紝璇█澶ц儐璇欒皭锛岃�屼笖鐪嬮棶棰樹竴閽堣琛�锛岀洿杈句簨浠舵渶鐪熷疄灞傞潰銆備粠3.14浜嬩欢涓瑿NN瀵逛腑鍥界殑璇嬫瘉銆佸埌姹跺窛澶у湴闇囩殑浼楀織鎴愬煄锛涗粠澶т紬瀵瑰ゥ杩愮粡娴庣殑杩囧害鏈熺浖鍒板ゥ杩愮ぜ浠殑涓崕椋庨噰锛涜繕鏈夋捣宄′袱宀稿鍙版咕鐜扮姸鐨勭湡瀹炶В璇伙紝鍔熷か鐔婄尗鍑告樉鐨勬枃鍖栬瀺鍚堜互鍙婅钁涗寒鑳藉惁鎴愪负浼樼鐨勪紒涓氬锛涢儙鏁欐巿閮藉仛浜嗘渶鐪熷垏鐨勮В璇伙紝鍏ㄩ儴閮芥槸鍦ㄧ數瑙嗐�佸钩闈㈠獟浣撲笂闂绘墍鏈椈鐨勮鐐癸紝杩欐槸鍦ㄩ儙鏁欐巿瀵逛笢瑗夸袱绉嶆枃鍖栦綋绯婚�忓交鐞嗚В鐨勫熀纭�涓婂苟涓斾粠绀句細姘戜紬涓殑鏅亶鐨勫皬缁嗚妭涓睍绀哄嚭澶т簨浠剁殑鏍规湰瓒嬪娍', '25', '13.6', 'images/4.jpg', '128', '鍖楁柟鏂囪壓鍑虹増绀�', '閮庡捀骞�', '2011-05-12 08:54:58', '1', '1', '1', '1', '120');
INSERT INTO `tb_book` VALUES ('8', '1', '1', '閮庡捀骞宠897', '97875317239514', '鍦ㄦ湰涔︿腑锛岄儙鍜稿钩鏁欐巿璋堝叴鐢氭祿锛屽叴鑷寸泿鐒讹紝璇█澶ц儐璇欒皭锛岃�屼笖鐪嬮棶棰樹竴閽堣琛�锛岀洿杈句簨浠舵渶鐪熷疄灞傞潰銆備粠3.14浜嬩欢涓瑿NN瀵逛腑鍥界殑璇嬫瘉銆佸埌姹跺窛澶у湴闇囩殑浼楀織鎴愬煄锛涗粠澶т紬瀵瑰ゥ杩愮粡娴庣殑杩囧害鏈熺浖鍒板ゥ杩愮ぜ浠殑涓崕椋庨噰锛涜繕鏈夋捣宄′袱宀稿鍙版咕鐜扮姸鐨勭湡瀹炶В璇伙紝鍔熷か鐔婄尗鍑告樉鐨勬枃鍖栬瀺鍚堜互鍙婅钁涗寒鑳藉惁鎴愪负浼樼鐨勪紒涓氬锛涢儙鏁欐巿閮藉仛浜嗘渶鐪熷垏鐨勮В璇伙紝鍏ㄩ儴閮芥槸鍦ㄧ數瑙嗐�佸钩闈㈠獟浣撲笂闂绘墍鏈椈鐨勮鐐癸紝杩欐槸鍦ㄩ儙鏁欐巿瀵逛笢瑗夸袱绉嶆枃鍖栦綋绯婚�忓交鐞嗚В鐨勫熀纭�涓婂苟涓斾粠绀句細姘戜紬涓殑鏅亶鐨勫皬缁嗚妭涓睍绀哄嚭澶т簨浠剁殑鏍规湰瓒嬪娍', '34', '23.6', 'images/5.jpg', '128', '鍖楁柟鏂囪壓鍑虹増绀�', '閮庡捀骞�', '2011-05-12 08:54:58', '1', '1', '1', '1', '120');
INSERT INTO `tb_book` VALUES ('9', '1', '1', '閮庡捀骞宠455', '97875317239517', '鍦ㄦ湰涔︿腑锛岄儙鍜稿钩鏁欐巿璋堝叴鐢氭祿锛屽叴鑷寸泿鐒讹紝璇█澶ц儐璇欒皭锛岃�屼笖鐪嬮棶棰樹竴閽堣琛�锛岀洿杈句簨浠舵渶鐪熷疄灞傞潰銆備粠3.14浜嬩欢涓瑿NN瀵逛腑鍥界殑璇嬫瘉銆佸埌姹跺窛澶у湴闇囩殑浼楀織鎴愬煄锛涗粠澶т紬瀵瑰ゥ杩愮粡娴庣殑杩囧害鏈熺浖鍒板ゥ杩愮ぜ浠殑涓崕椋庨噰锛涜繕鏈夋捣宄′袱宀稿鍙版咕鐜扮姸鐨勭湡瀹炶В璇伙紝鍔熷か鐔婄尗鍑告樉鐨勬枃鍖栬瀺鍚堜互鍙婅钁涗寒鑳藉惁鎴愪负浼樼鐨勪紒涓氬锛涢儙鏁欐巿閮藉仛浜嗘渶鐪熷垏鐨勮В璇伙紝鍏ㄩ儴閮芥槸鍦ㄧ數瑙嗐�佸钩闈㈠獟浣撲笂闂绘墍鏈椈鐨勮鐐癸紝杩欐槸鍦ㄩ儙鏁欐巿瀵逛笢瑗夸袱绉嶆枃鍖栦綋绯婚�忓交鐞嗚В鐨勫熀纭�涓婂苟涓斾粠绀句細姘戜紬涓殑鏅亶鐨勫皬缁嗚妭涓睍绀哄嚭澶т簨浠剁殑鏍规湰瓒嬪娍', '39', '37.6', 'images/6.jpg', '128', '鍖楁柟鏂囪壓鍑虹増绀�', '閮庡捀骞�', '2011-05-12 08:54:58', '1', '1', '1', '1', '120');
INSERT INTO `tb_book` VALUES ('10', '1', '1', '鏅氶棿瑗跨孩鏌垮噺鑲�', '9787531723950', '鏈功鏄棩鏈攢閲忕涓�鐨勭編瀹瑰噺鑲ョ晠閿�涔︼紝涓婂競3涓湀鐙傚崠85涓囧唽銆傛湰涔︿綔鑰咃紝鏃ユ湰绗竴鐨勮タ绾㈡熆鍗氬＋--鍞愭辰鏄庡憡璇夊ぇ瀹讹紝瑗跨孩鏌垮噺鑲ュソ鍚冦�佽交鏉俱�佹槗鐦︺�佸仴搴枫�佺編鑲わ紝鍦�3涓湀鍐呭噺鎺�11鏂ゅ苟涓斾娇鑲岃偆鍥炲埌21宀佹椂鐨勭姸鎬併�備笉绠″ぇ瀹舵槸鍚︾埍鍚冭タ绾㈡熆锛屾櫄闂磋タ绾㈡熆鍑忚偉閮借兘鎸佺画涓嬪幓锛屽洜涓烘櫄闂磋タ绾㈡熆鏈夊涓嬬璇�锛氭竻娓呯埥鐖界殑琛�娑层�佹粦婧滄簻鐨勮倢鑲ゃ�佺編缇庡湴鍚冦�佽垝鑸掓湇鏈嶃�佺槮锛佹潵鑷タ绾㈡熆鐨勭編涓界槮韬�+缇庤偆杩囩▼锛屼綘涓�瀹氳浜茶韩浣撻獙涓�鐣摝', '22', '11.6', 'images/1.jpg', '128', '鍖楁柟鏂囪壓鍑虹増绀�', '锛堟棩锛夊攼娉芥槑銆�钁楋紝鍛ㄦ檽鏅椼��璇�', '2011-05-12 09:04:05', '1', '1', '1', '1', '120');
INSERT INTO `tb_book` VALUES ('11', '1', '1', '鏅氶棿瑗跨孩鏌�', '9787531723987', '鏈功鏄棩鏈攢閲忕涓�鐨勭編瀹瑰噺鑲ョ晠閿�涔︼紝涓婂競3涓湀鐙傚崠85涓囧唽銆傛湰涔︿綔鑰咃紝鏃ユ湰绗竴鐨勮タ绾㈡熆鍗氬＋鈥�--鍞愭辰鏄庡憡璇夊ぇ瀹讹紝瑗跨孩鏌垮噺鑲ュソ鍚冦�佽交鏉俱�佹槗鐦︺�佸仴搴枫�佺編鑲わ紝鍦�3涓湀鍐呭噺鎺�11鏂ゅ苟涓斾娇鑲岃偆鍥炲埌21宀佹椂鐨勭姸鎬併�備笉绠″ぇ瀹舵槸鍚︾埍鍚冭タ绾㈡熆锛屾櫄闂磋タ绾㈡熆鍑忚偉閮借兘鎸佺画涓嬪幓锛屽洜涓烘櫄闂磋タ绾㈡熆鏈夊涓嬬璇�锛氭竻娓呯埥鐖界殑琛�娑层�佹粦婧滄簻鐨勮倢鑲ゃ�佺編缇庡湴鍚冦�佽垝鑸掓湇鏈嶃�佺槮锛佹潵鑷タ绾㈡熆鐨勭編涓界槮韬�+缇庤偆杩囩▼锛屼綘涓�瀹氳浜茶韩浣撻獙涓�鐣摝', '54', '46.6', 'images/7.jpg', '128', '鍖楁柟鏂囪壓鍑虹増绀�', '锛堟棩锛夊攼娉芥槑銆�钁楋紝鍛ㄦ檽鏅椼��璇�', '2011-05-12 09:04:05', '1', '1', '1', '1', '120');
INSERT INTO `tb_book` VALUES ('12', '1', '1', '瑗跨孩鏌�', '97875317239657', '鏈功鏄棩鏈攢閲忕涓�鐨勭編瀹瑰噺鑲ョ晠閿�涔︼紝涓婂競3涓湀鐙傚崠85涓囧唽銆傛湰涔︿綔鑰咃紝鏃ユ湰绗竴鐨勮タ绾㈡熆鍗氬＋鈥�--鍞愭辰鏄庡憡璇夊ぇ瀹讹紝瑗跨孩鏌垮噺鑲ュソ鍚冦�佽交鏉俱�佹槗鐦︺�佸仴搴枫�佺編鑲わ紝鍦�3涓湀鍐呭噺鎺�11鏂ゅ苟涓斾娇鑲岃偆鍥炲埌21宀佹椂鐨勭姸鎬併�備笉绠″ぇ瀹舵槸鍚︾埍鍚冭タ绾㈡熆锛屾櫄闂磋タ绾㈡熆鍑忚偉閮借兘鎸佺画涓嬪幓锛屽洜涓烘櫄闂磋タ绾㈡熆鏈夊涓嬬璇�锛氭竻娓呯埥鐖界殑琛�娑层�佹粦婧滄簻鐨勮倢鑲ゃ�佺編缇庡湴鍚冦�佽垝鑸掓湇鏈嶃�佺槮锛佹潵鑷タ绾㈡熆鐨勭編涓界槮韬�+缇庤偆杩囩▼锛屼綘涓�瀹氳浜茶韩浣撻獙涓�鐣摝', '34', '26.6', 'images/8.jpg', '128', '鍖楁柟鏂囪壓鍑虹増绀�', '锛堟棩锛夊攼娉芥槑銆�钁楋紝鍛ㄦ檽鏅椼��璇�', '2011-05-12 09:04:05', '1', '1', '1', '1', '120');
INSERT INTO `tb_book` VALUES ('13', '1', '1', '瑗跨孩鏌垮钩', '978753176657', '鏈功鏄棩鏈攢閲忕涓�鐨勭編瀹瑰噺鑲ョ晠閿�涔︼紝涓婂競3涓湀鐙傚崠85涓囧唽銆傛湰涔︿綔鑰咃紝鏃ユ湰绗竴鐨勮タ绾㈡熆鍗氬＋鈥�--鍞愭辰鏄庡憡璇夊ぇ瀹讹紝瑗跨孩鏌垮噺鑲ュソ鍚冦�佽交鏉俱�佹槗鐦︺�佸仴搴枫�佺編鑲わ紝鍦�3涓湀鍐呭噺鎺�11鏂ゅ苟涓斾娇鑲岃偆鍥炲埌21宀佹椂鐨勭姸鎬併�備笉绠″ぇ瀹舵槸鍚︾埍鍚冭タ绾㈡熆锛屾櫄闂磋タ绾㈡熆鍑忚偉閮借兘鎸佺画涓嬪幓锛屽洜涓烘櫄闂磋タ绾㈡熆鏈夊涓嬬璇�锛氭竻娓呯埥鐖界殑琛�娑层�佹粦婧滄簻鐨勮倢鑲ゃ�佺編缇庡湴鍚冦�佽垝鑸掓湇鏈嶃�佺槮锛佹潵鑷タ绾㈡熆鐨勭編涓界槮韬�+缇庤偆杩囩▼锛屼綘涓�瀹氳浜茶韩浣撻獙涓�鐣摝', '44', '36.6', 'images/9.jpg', '128', '鍖楁柟鏂囪壓鍑虹増绀�', '锛堟棩锛夊攼娉芥槑銆�钁楋紝鍛ㄦ檽鏅椼��璇�', '2011-05-12 09:04:05', '1', '1', '1', '1', '120');

-- ----------------------------
-- Table structure for tb_inform
-- ----------------------------
DROP TABLE IF EXISTS `tb_inform`;
CREATE TABLE `tb_inform` (
  `informId` int(11) NOT NULL AUTO_INCREMENT,
  `informTitle` varchar(30) DEFAULT NULL,
  `informContent` varchar(30) DEFAULT NULL,
  `informTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`informId`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_inform
-- ----------------------------

-- ----------------------------
-- Table structure for tb_note
-- ----------------------------
DROP TABLE IF EXISTS `tb_note`;
CREATE TABLE `tb_note` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  `author` varchar(20) NOT NULL,
  `content` varchar(50) NOT NULL,
  `ly_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `imgs` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_note
-- ----------------------------

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `realName` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `postcode` varchar(10) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `orderDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_order
-- ----------------------------

-- ----------------------------
-- Table structure for tb_orderitem
-- ----------------------------
DROP TABLE IF EXISTS `tb_orderitem`;
CREATE TABLE `tb_orderitem` (
  `orderItemId` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) DEFAULT NULL,
  `bookId` int(11) DEFAULT NULL,
  `bookName` varchar(50) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `bookNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderItemId`),
  KEY `orderId` (`orderId`),
  KEY `bookId` (`bookId`),
  CONSTRAINT `tb_orderitem_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `tb_order` (`orderId`),
  CONSTRAINT `tb_orderitem_ibfk_2` FOREIGN KEY (`bookId`) REFERENCES `tb_book` (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_orderitem
-- ----------------------------

-- ----------------------------
-- Table structure for tb_subtype
-- ----------------------------
DROP TABLE IF EXISTS `tb_subtype`;
CREATE TABLE `tb_subtype` (
  `subTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `superTypeId` int(11) DEFAULT NULL,
  `subTypeName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`subTypeId`),
  KEY `superTypeId` (`superTypeId`),
  CONSTRAINT `tb_subtype_ibfk_1` FOREIGN KEY (`superTypeId`) REFERENCES `tb_supertype` (`superTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_subtype
-- ----------------------------
INSERT INTO `tb_subtype` VALUES ('1', '1', '绋嬪簭璁捐');
INSERT INTO `tb_subtype` VALUES ('2', '1', '缃戠粶鎶�鏈�');
INSERT INTO `tb_subtype` VALUES ('3', '1', '璁＄畻鏈哄熀纭�');
INSERT INTO `tb_subtype` VALUES ('4', '2', '涓浗鏂囧');
INSERT INTO `tb_subtype` VALUES ('5', '2', '澶栧浗鏂囧');
INSERT INTO `tb_subtype` VALUES ('6', '3', '娌圭敾');
INSERT INTO `tb_subtype` VALUES ('7', '3', '姘村僵');
INSERT INTO `tb_subtype` VALUES ('8', '3', '闆曞埢');

-- ----------------------------
-- Table structure for tb_supertype
-- ----------------------------
DROP TABLE IF EXISTS `tb_supertype`;
CREATE TABLE `tb_supertype` (
  `superTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`superTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_supertype
-- ----------------------------
INSERT INTO `tb_supertype` VALUES ('1', 'IT鎶�鏈�');
INSERT INTO `tb_supertype` VALUES ('2', '鏂囧');
INSERT INTO `tb_supertype` VALUES ('3', '鑹烘湳');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `password` varchar(16) NOT NULL,
  `email` varchar(50) NOT NULL,
  `trueName` varchar(40) NOT NULL,
  `sex` varchar(30) DEFAULT NULL,
  `birthday` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `postcode` varchar(10) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `mphone` varchar(15) DEFAULT NULL,
  `question` varchar(30) NOT NULL,
  `answer` varchar(30) NOT NULL,
  `img` varchar(100) DEFAULT NULL,
  `score` int(11) DEFAULT '1000',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
