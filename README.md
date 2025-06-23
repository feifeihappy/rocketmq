# RocketMQ源码学习

## 初识RocketMQ

[官网RocketMQ 架构 4.x](https://rocketmq.apache.org/zh/docs/4.x/introduction/02whatis)

- NameServer
    - 是一个简单的 Topic 路由注册中心，支持 Topic、Broker 的动态注册与发现
- Broker
    - 主要负责消息的存储、投递和查询以及服务高可用保证。
- 队列：
    - 为了消息写入能力的水平扩展，RocketMQ 对 Topic进行了分区，这种操作被称为队列（MessageQueue）。
- ConsumerGroup的概念：
    - 为了消费能力的水平扩展，ConsumerGroup的概念应运而生。

- 官网已经把RocketMQ概念讲的很清楚了，不在此处赘述，其他概念可移步官网。

### RocketMQ 消息模型
- ![img.png](img.png)

# 参考文档：

官网

- [初识RocketMQ](https://rocketmq.apache.org/zh/docs/4.x/introduction/02whatis)

RocketMQ源码-程序猿阿越

- [RocketMQ4源码（一）NameServer](https://juejin.cn/post/7257307209721167930)

勇哥Java实战

- [勇哥Java实战-](https://javayong.cn/)

- [RocketMQ4.X 设计精要](https://mp.weixin.qq.com/s/aMSa5GKloN2_lsMHRpGiOA)


## 生产者、消费者

- springboot- 模块 : [rocketmq-test-zpf](rocketmq-test-zpf)
- 访问失败的问题 

  - `Send [3] times, still failed, cost connect to <10.101.251.30:10911> failed`
- 修改 broker.conf： 

  - `brokerIP1=10.24.99.61`
- 参考:
  - [Docker部署RocketMQ踩坑记录](https://www.cnblogs.com/kendoziyu/p/15210806.html)
  - [RocketMQ 源码解析之 源代码环境搭建](https://blog.csdn.net/u012410733/article/details/122094431)

## CAP 理论（分布式基础理论）

* 一致性（Consistency） : 所有节点访问的数据副本，都是相同的。
* 可用性（Availability）: 非故障的节点在合理的时间内返回合理的响应（不是错误或者超时的响应）。
* 分区容错性（Partition Tolerance） : 分布式系统出现网络分区的时候，仍然能够对外提供服务。

**CAP 理论中分区容错性 P 是一定要满足的，在此基础上，只能满足可用性 A 或者一致性 C。**

**选择 CP(一致性) 还是 AP （可用性） 的关键在于当前的业务场景，没有定论，比如对于需要确保强一致性的场景如银行一般会选择保证 CP 。**

**总结：如果系统发生“分区”，我们要考虑选择 CP 还是 AP。如果系统没有发生“分区”的话，我们要思考如何保证 CA 。**


> 参考[CAP & BASE理论详解](https://javaguide.cn/distributed-system/protocol/cap-and-base-theorem.html#%E7%AE%80%E4%BB%8B)
