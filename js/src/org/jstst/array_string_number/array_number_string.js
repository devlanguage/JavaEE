// 但是所有的对象都可以有prototypes,
// prototypes自己也是对象，那么他也可以有prototypes,这样循环下去就形成了一个prototype链，
// 这个链当他遇到链中队形的prototype是null时中止。(Object的默认的prototype是null)

// Object
var obj = new Object();// prototype
// constructor
//
// Boolean hasOwnProperty(String name)
// Boolean isPrototypeOf(Object obj)
// Boolean propertyIsEnumerable(String name)
// String toLocaleString()
// String toString()
// String toSource()
// Object valueOf()

var array1 = new Array(); // new Array(size);
// //相信每位从强类型的编程语言学习javascript时,绝对会以为上面这种操作感到惊讶,
// float数据也作数组的下标了,事实上并非如您所想javascript在您是用负数,浮点数,(或布尔型,对象,其他值时),javascript会将它转换为一个字符串
// 用生成的字符串作为对象的属性名字,而不是定义了一个新的数组元素上面的实例事实就是为a 创建了一个名为:"1.23"的属性.
array1[1.23] = "asdfadf";
array1[0] = 0;
// Number push(elments...): 将一个或多个新元素附加到数组的尾部，然后返回数组的新长度。
// Number pop(): 将删除数组的最后一个元素，坚守数组的长度，返回他删除的值。
array1.push(10, 12, 18, 11);
array1.concat(100, [ 101, 102 ]);
array1.sort( function(a, b) {
	return a - b;
});
// 通过设置数组的length属性能过截断数组的长度。array[3]==undefined)
array1.length = 18;

// Array concat(elements or array): 将多个数组（也可以是字符串）连接为一个数组；
// String join(separator) : 这个字符串将数组的每一个元素值连接在一起，中间用 separator 隔开

// Object shift(): 删除并返回数组的第一个元素，然后将后面的所有元素都向前移动以填补第一个元素留下的空白。
// Number unshift(item..):
// 将一个或多个元素添加到数组元素的头部，然后把已有的元素移动到下标最大的位置已腾出空间它返回的是主族的新长度。

// slice(start,end)方法：返回的数组包含有第一个参数指定的元素和那个元素开始到第二个参数指定的元素为止的元素但不包含第二个参数所指定的元素。
var array2 = array1.slice(0, array1.length - 1);
// splice(start, deletedSize, addedElement...)
// splice函数第一个参数指定了要插入或删除的元素在数组中的位置。第二个参数指定了要从数组中删除的元个数
// 在第二参数之后可以有任意多个参数，它们指定的是从第一个参数指定的位置处插入的元素。第一个元素及后续元素，做出相应的移动。
。