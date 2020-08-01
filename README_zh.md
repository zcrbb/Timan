# Timan

**_@Effect:_**

事件驱动 + 事件驱动 + 任务驱动 型 交互式 时间管理应用

管理你的精力, 时间 与 事件.

**_@Conceive:_**

1. 根据 事件的特性 自身的精神状况和身体状况 来自动安排你下一步要做什么. 例如: 你觉得没有**精力**去接着学一些费脑筋的东西, Timan 会安排一些简单易完成的任务给你做. 如果你觉得现在想挑战一下自己, Timan 会给你安排一些困难的事情. 当然这些事情都在你的任务表上.

2. 每一个事件都有一个进度条. 可以更直观的看出来任务进行到哪一步了.

3. 让网页变得自动更新, 我已经做到了!

4. 长短期的任务管理, 类似于事件提醒功能. 比如: 提醒你要给母亲买礼物啦, 今天是母亲节! 你要给朋友送礼物啦!

5. 通过交互式的询问, 确定你现在的状态. happy (mental status)? tired (patient)? full of energy (mental status)? hungry (physical status)?

**_@Architecture:_**

Frontend: Vuejs + Vuex + Vue router + Vuetify

Backend: Spring boot + Spring Security + JPA?? + Something else I do not decide.

**_@Usage_**


### 事件属性

```TypeScript
{
  // 每个事件的基础 id
  thingId: number;
  // 事件名称
  thing: string;
  // 事件紧急度
  urgency: number;
  // 四个要素, 用于统计, 每个都是1-5
  interest: number;
  mental: number;
  physical: number;
  patient: number;
  // 总共的时间
  time: string;
  // 进行过的时间
  duration: string;
  // ddl
  ddl: string;
  // 备注
  remark: string;
  // 是否展开
  isShow: false;
  // 是否完成
  done: boolean;
  // 完成时间, (点击完成的时间)
  doneDate: string;
  // 连续事件频率
  frequency: number;
  // 事件颜色
  color: string;
}
```
