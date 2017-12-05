/**
 * 内部类与嵌套类
 */
class Main{
    val field:String="field string"
    companion object {
        val TAG =this::class.simpleName

    }
    init {
        val static=StaticClass()
        val inner=InnerClass("new inner")
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
    }
}