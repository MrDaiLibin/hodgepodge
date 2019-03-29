Java消息服务（JMS）使用Mediator模式和Observer模式来允许应用程序订阅数据并将数据发布到其他应用程序。

使用一个中介的对象，封装一组对象之间的交互，这样这些对象就可以不用彼此耦合。

这个中介者常常起着中间桥梁的作用，使其他的对象可以利用中介者完成某些行为活动，因此它必须对所有的参与活动的对象了如指掌！

1 当一组对象要进行沟通或者业务上的交互，但是其关系却又很复杂混乱时，可以采用此模式。

2 当一个对象与其他的对象要进行紧密的交互，但又想服用该对象而不依赖其他的对象时。

3 想创造一个运行于多个类之间的对象，又不想生成新的子类时。