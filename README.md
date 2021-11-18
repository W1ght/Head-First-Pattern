# Head First 设计模式

#### 介绍
《Head First 设计模式》这本书自己写的 demo 和笔记



#### 目的

1. 代码重用性
2. 可读性
3. 可扩展性
4. 可用性
5. 使程序呈现高内聚，低耦合的特性



####  设计原则

* 多用组合，少用继承
* 针对接口编程，而不是针对实现编程
* 封装变化
* 为了交互对象之间的松耦合设计而努力
* 类应该对扩展开放，对修改关闭
* 依赖倒置原则：要依赖抽象，不要依赖具体类
* 最少知识原则：只和你的密友谈话
* 好莱坞原则：别调用（打电话给）我们，我们会调用（打电话给）你
* 单一职责：一个类应该只是一个引起变化的原因



#### 模式

* 策略模式——定义算法族，分别封装起来，让他们之间可以相互替换，此模式让算法的变化独立于使用算法的客户
* 观察者模式——在对象之间定义一对多的依赖，这样一来，当一个对象改变状态。依赖它的对象都会收到通知，并自动更新（Java Swing）
* 装饰者模式——动态地将责任附加到对象上。若要扩展功能，装饰者提供了比继承更有弹性的替代方案（Java IO）
* 工厂方法模式——定义了一个创建对象的接口，但由子类决定要实例化的类是哪一个。工厂方法让类把实例化推迟到子类
* 抽象工厂模式——提供一个接口，用于创建相关或依赖对象的家族，而不需要明确指定具体类
* 单例模式——确保一个类只有一个实例，并提供一个全局访问点
* 命令模式——将“请求”封装成对象，以便使用不同的请求、队列或者日志参数化其他对象。命令模式也支持可撤销的操作
* 适配器模式——将一个类的接口，转换成客户期望的另一个接口。适配器让原本接口不兼容的类可以合作无间
* 外观模式——提供一个统一的接口，用来访问系统中的一群接口。外观定义一个高层接口，让子系统更容易使用
* 模板方法模式——在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类可以在不改变算法结构的情况下，重新定义算法中的某些步骤（Arrays.sort()）
* 迭代器模式——提供一种方法顺序访问一个聚合对象中的各个元素，而不暴露其内部的表示（Java Collection）
* 组合模式——允许你将对象组合成树形结构来表现“整体/部分”层次结构。组合能让客户以一致的方式处理个别对象以及对象组合
* 状态模式——允许对象在内部状态改变时改变它的行为，对象看起来好像修改了它的类



#### 避免违反依赖倒置的原则

* 变量不可以持有具体类的引用
* 不要让类派生自具体类
* 不要覆盖基类中已经实现的方法



#### 关于枚举单例

1. 首先，在枚举中我们明确了构造方法限制为私有，在我们访问枚举实例时会执行构造方法。
2. 同时每个枚举实例都是static final类型的，也就表明只能被实例化一次。在调用构造方法时，我们的单例被实例化.
3. 也就是说，因为enum中的实例被保证只会被实例化一次，所以我们的INSTANCE也被保证实例化一次。 

* Enum这个类的声明 `public abstract class Enum<E extends Enum<E>> implements Comparable<E>, Serializable`。枚举提供了序列化机制，具体使用在网络连接，数据库连接，线程池等等。


> 单元素的枚举类型已经成为实现Singleton的最佳方法。		——《Effective Java》



#### 关于空对象 (null object)

在命令模式中 NoCommand 对象是一个空对象。当你不想返回一个有意义的对象时，空对象就很有用。客户可以将处理 null 的职责转移给空对象。举例来说，遥控器不可能一出厂就设置有意义的命令对象，所以提供了 NoCommand 对象作为替代品，当调用 execute() ，这种对象什么都不做

在许多设计模式中，都会看到空对象的使用。甚至有些时候，空对象也被视为一种设计模式



#### 关于组合对象

* 每个组合对象都可以表示“整体/部分”，对于用户是透明的（即对着接口编程而不用关心有些对象行为不太一样）
* 为了保持透明性，组合内所有的对象都必须实现相同的接口（违反了单一职责，但为了透明算是个折中的方案）
* 这个时候有些方法是没意义的，可以返回 null 或者 false。那么就要对这些情况进行判断
* 也可以抛出异常，那么客户就要对该异常进行处理
* 组合和叶节点通常是树形结构也算是层次结构
* 如果这个组合结构太过于复杂，可以考虑实现缓存，保存临时结果，省去遍历的开支

