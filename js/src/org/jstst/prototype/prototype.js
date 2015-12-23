// 但是所有的对象都可以有prototypes,
// prototypes自己也是对象，那么他也可以有prototypes,这样循环下去就形成了一个prototype链，
// 这个链当他遇到链中队形的prototype是null时中止。(Object的默认的prototype是null)

// Object
var obj = new Object();
// Boolean hasOwnProperty(String name)
// Boolean isPrototypeOf(Object obj)
// Boolean propertyIsEnumerable(String name)
// String toLocaleString()
// String toString()
// String toSource()
// Object valueOf()

obj.field1 = "field_01";
obj["field2"] = "field_02"
obj.method1 = function() {
	return "first_function";
}
// private,public,static,construct的理解
function class1() {
    // private fields
    var m_first = 1;
    var m_second = 2;

    m_third = 3;// 全局变量

    // private method
    var method1 = function() {
        alert(m_first);
    }
    var method2 = function() {
        alert(m_second);
    }

    // public
    this.m_five = 5;// 在公有方法和原型方法中this表示实例对象
    this.method5 = function()// 在公有方法和原型方法中this表示实例对象
    {
        alert(this.m_five);
    }

    // 构造函数用于调用私有函数
    // class1//名字可有可无
    {
        method1();
        method2();
    }
    class1(id, name)
    {
    }
}

// Student
function Student(pId, pName) {
    
	this.pId = pId;
	this.pName = pName;
	this.cources = ["cource01"];
	this.cources.push("cource11", "cource12", 'cource13');
	this.cources.reverse();
	this.cources.push("cource21", "cource22", 'cource23');

	this.getCources = function() {
		return "getCources()"
	}
}
Student.test = function() {

}
Student.prototype.pId = 12;
Student.prototype.pName = "zhangsan";
Student.prototype.getPId = function() {
	return this.pId;
}
Student.prototype.setPid = function(pId) {
	alert("setPid:" + pId)
	this.pId = pId;
}
Student.prototype.getPName = function() {
	return "PName=" + this.pName;
}
// Extend: 最基本的用法 把ClassA的一个实例赋值给ClassB, ClassB就继承了ClassA的所有属性
// UnderGraduate
function UnderGraduate() {
}
UnderGraduate.prototype = new Student("UnderGraduate_iD", "UnderGraduate_name");