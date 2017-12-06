/**
 * 内部类与嵌套类
 */

/**
 * sealed修饰的类默认为open，而且子类只能作为嵌套类或内部类集成
 * sealed类的构造方法都是私有的，不能被实例化
 */
sealed class Main{
    /**
     * 可变属性，set方法私有，不能在类的外部修改该属性
     */
    var field:String="field string"
        private  set

    companion object {
        val TAG =this::class.simpleName

    }
    init {
        StaticClass()
        InnerClass("new inner")
        InnerClass()
        InnerClass("key",99)
    }

    /**
     * 嵌套类，相当于java中的静态内部类
     */
    class StaticClass{
        init {
            println(Main.TAG)
        }
    }

    /**
     * 内部类，需要inner关键词修饰
     */
    inner class InnerClass(val para:String){

        init {
            println(para)

            /**
             * 内部类访问外部类
             */
            println(this@Main.field)
        }

        /**
         * 主构造的初始化函数可以有多个
         */
        init {
            println("init method no.2")
        }

        /**
         * 从构造方法 ，必须显式调用主构造或父类构造
         */
        constructor():this(""){
            println(para)
        }

        constructor(key:String="keyTest", value:Int):this(""){
            println(key+":"+value)
        }
    }
    interface Foo{
        /**
         * 接口中的方法可以有默认实现
         */
        fun foo():Unit= print("123")
    }

    /**
     * 继承sealed类，接口没有构造，所以不用在继承时显式调用构造
     */
    inner class Child :Main(),Foo
    class Child2:Main()
}