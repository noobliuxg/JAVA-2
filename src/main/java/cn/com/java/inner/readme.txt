1.内部类：成员内部类，静态内部类，方法内部类，匿名内部类
    成员内部类：
            1.定义在一个类里面的非static修饰的类，例子：Outer：外部类，PrivateInner,DefaultInner,ProtectedInner,PublicInner都是内部类，并且内部类可以使用任意修饰符修饰，pulibc,protected,default,private
            2.创建一个成员内部类，可以采用：外部类的实例.new 内部类Class()创建，例子：this.new PrivateInner(),this.new DefaultInner(),this.new ProtectedInner(),this.PublicInner();
            3.内部类中可以无条件地访问外部类的所有属性和方法，注意，若成员内部类的属性名或方法名与外部类属性名或方法名相同，默认访问的是自己成员内部类的属性或方法名，若要使访问的属性或方法为外部类，必须加上Outer.this.属性名,Outer.this.方法名
            4.外部类不能直接访问内部类中的所有非static的属性和方法，必须通过内部类的实例来访问
    static内部类：
            1.定义在一个类了面用static修修饰的类，例子：StaticOuter:外部类，StaticInner：静态内部类
            2.创建一个static内部类，使用：外部类.static内部类 = new 外部类.static内部类()创建
            3.static内部类中可以直接的访问外部类的static方法和属性，但是不能直接访问非static变量的属性和方法。
                若static内部类中的属性名或者方法名与外部类相同时，在static内部类中访问这些相同的static属性和方法时，默认访问的是自己的static属性和方法，若要访问的是外部类的static属性和方法时，可以使用：OuterClassName.out_static_field/OuterClassName.out_static_methodName()：来访问外部类的static属性和方法
            4.static内部类中不能直接访问外部类的非static的属性和方法。
                若一定要在static内部类中访问非static变量修饰的方法和属性，可以采用在内部类中OuterClassName outer = new OuterClassName();outer.no_static_field,outer_no_static_methodName();
    method内部类：
            1.定义在外部类中的一个方法的类
            2.注意事项：method内部类，只能在method方法体内使用，故：method内部类不能使用static修饰和不能使用访问修饰符

    匿名内部类：
            1.不能有名称的内部类，比如：new Thread(new Runnable(){ public void run(){}})
            2.注意：
                使用匿名内部类时，我们必须是继承一个类或者实现一个接口，但是两者不可兼得，同时也只能继承一个类或者实现一个接口。
                匿名内部类中是不能定义构造函数的。
                匿名内部类中不能存在任何的静态成员变量和静态方法。
                匿名内部类为局部内部类（即方法内部类），所以局部内部类的所有限制同样对匿名内部类生效。
                匿名内部类不能是抽象的，它必须要实现继承的类或者实现的接口的所有抽象方法。















