### Vuex

从 vuex 中获取状态:

```js
state: {
STORAGE_KEY: "Aruix-timan",
nowThing: 0,
changeIndex: 1,
things: [],
},

```

当在组件中用 computed 属性来取值的时候, 好像是会自动更新的... 也就是说 state 是响应式的, computed 也是响应式的.

```js
export default:{
    computed:{
        nowThing(){
            // <!-- 获取到值 -->
            return this.$store.state.nowThing
        }
    }
}
```

### mapstate 辅助函数:

当一个组件需要获取多个状态的时候, 用 mapstate 就可以帮助生成计算属性(从 state)

```js
computed: mapState([
  // 映射 this.count 为 store.state.count
  // 相当于是: `count: state => state.count,`
  "count",
]);
```

### store 的计算属性就是 getter!!!

就是用来对存储的数据进行一行操作的. 就像计算属性一样，getter 的返回值会根据它的依赖被缓存起来，且只有当它的依赖值发生了改变才会被重新计算。

相当于就是把

```js
// 这是普通的组件里的计算属性
computed: {
  doneTodosCount () {
    return this.$store.state.todos.filter(todo => todo.done).length
    // .length就是取长度, 没有小括号, 因为不是函数, 只是数组的一个属性
  }
}

// store 里面的 getter属性
const store = new Vuex.Store({
  state: {
    todos: [
      { id: 1, text: '...', done: true },
      { id: 2, text: '...', done: false }
    ]
  },
  getters: {
      doneTodos: state => {
          return state.todos.filter(todo => todo.done)
    },
      // 接受别的getters传进来的值
      // 这个里面还是又操作的, 我现在才明白过来....
      // 前面是属性名, 调用的时候不带括号, 后面的参数是匿名函数的箭头函数
      // 后面的参数是不需要填进去的
    doneTodosCount: (state, getters) => {
        return getters.doneTodos.length
    }

  }
})
```

在别的组件里可以用 `this.$store.getters.doneTodos` 直接获取返回值. 他就是一个属性, 而不是函数, 要想给他传参, 需要用到下面的办法:

```js
// vuex里面
getters: {
  // ...这就是函数套函数了.... 所以他能传参
  getTodoById: (state) => (id) => {
    return state.todos.find((todo) => todo.id === id);
  };
}
// 其他组件里面的调用:
this.$store.getters.getTodoById(2); // -> { id: 2, text: '...', done: false }
```

需要注意的是, getters 不能修改 store

### mapGetters 我还没懂

### Mutation 是更改 store 里面信息的唯一方法

```js
// 最基础的 mutation 用法
const store = new Vuex.Store({
  state: {
    count: 1,
  },
  mutations: {
    // 无参数
    increment(state) {
      // 变更状态
      state.count++;
    },
    // 带一个参数
    increment(state, n) {
      state.count += n;
    },
    // 带一个对象
    increment(state, payload) {
      state.count += payload.amount;
    },
  },
});

// 别的地方调用:
// 无参数
this.$store.commit("increment");
// 带一个参数
this.$store.commit("increment", 10);
// 带一个对象
this.$store.commit("increment", {
  amount: 10,
});
// 带一个对象的另一种写法
this.$store.commit({
  type: "increment",
  amount: 10,
});
```

### 给对象添加新属性

这个我当时很久都没有解决... 没想到官方文档就有, 我是直接把新属性挂上了, 但是貌似不要那样做, 不能使监视状态的 Vue 组件会自动更新.

使用 `Vue.set(obj, 'newProp', 123)` 在对象上添加新属性

### 在组件中提交 Mutation ...mapMutations 我还没学会, 但是看起来是用来简化代码格式的, 不是很重要

# 回调 同步 异步

具体我只看了一点, 下面是讲解, 还不错我还没看完

https://juejin.im/post/5dc1474df265da4d1518ee76

用异步是为了不让 js 等待, 可以等数据传过来之后再运算, 同步就是等数据到之后再算, 所以慢, 就是整个过程都卡在那, 他在发请求, 整个等待相应的过程所有人都等着

### Action

Action 提交的是 mutation，而不是直接变更状态。

Action 可以包含任意异步操作。

```js
const store = new Vuex.Store({
  state: {
    count: 0,
  },
  mutations: {
    increment(state) {
      state.count++;
    },
  },
  // 感觉 action 就是把 mutations 封装了一下
  actions: {
    //   这种写法我没看懂
    increment(context) {
      context.commit("increment");
    },
  },
  // 参数解构写法
  increment({ commit }) {
    commit("increment");
  },
});

// 在别的组件里面使用 actions
this.$store.dispatch("increment");
```

actions 的异步写法:

```js
actions: {
  incrementAsync ({ commit }) {
    // 这就是异步操作的象征
    setTimeout(() => {
      commit('increment')
    }, 1000)
  }
}
///////////////////////
// 在别的组件中的调用方式
///////////////////////

// 以载荷形式分发
store.dispatch('incrementAsync', {
  amount: 10
})

// 以对象形式分发
store.dispatch({
  type: 'incrementAsync',
  amount: 10
})
```

actions 很多地方我还没有看懂, 因为我没有写过很多异步操作.... 原来只是了解过而已...


### nginx

nginx -t 看配置文件在哪

```
server {
    listen       80;
    server_name  localhost;

    location / {
        # root代表项目的根目录
        root   E:\Work\Workspace;
        # index代表默认的入口文件
        index  index.html index.htm;
    }

    error_page   500 502 503 504  /50x.html;
    location = /50x.html {
        root   html;
    }
}
```

### UI ICONS

### 组件之间通信

vue的设计理念是单向数据流，不建议在子组件直接更改父级的数据,

未在父组件data中声明的对象属性，子组件无法获取更新内容。

这有一个例子, 但是我还没看懂/....

```vue
// Father组件
<template>
  <div class="father">
    <Child 
      :msg='msg' 
      :changeMsg='handleChangeMsg'
      />
  </div>
</template>

<script>
import Child from './Child.vue'

export default {
    name: 'father',
    data() {
        return {
            msg: 'msg'
        }
    },
    methods: {
        handleChangeMsg(value) {
            this.msg = value
        }
    },
    components: {
        Child
    }
}
</script>

// Child组件

<template>
  <div class="child">
    <h3>String使用：</h3>
    <div>
      {{msg}}
    </div>
    <button @click="handleChangeMsg">修改父组件的msg</button>
  </div>
</template>

<script>
export default {
  name: 'Child',
  props: {
    msg: {
      type: String,
      default: ''
    },
    changeMsg: {
      type: Function,
      default: () => {}
    }
  },
  methods: {
      handleChangeMsg() {
        // this.msg = 'a' // 控制台会报错
        
        // 可以使用父组件给的方法来改数据
        this.changeMsg('hello world')
      }
  }
}
</script>
```

### props和$emit

$emit的使用场景主要是在子组件要传参数给父组件，通过$emit来触发父组件给的监听器。

```vue
Father组件
<template>
  <div class="father">
    {{value}}
    <Child v-on:change="handleChange" :value='value' />
  </div>
</template>

<script>
import Child from './Child.vue'

export default {
    name: 'father',
    data() {
        return {
            value: ''
        }
    },
    methods: {
        handleChange(value) {
          this.value = value
        }
    },
    components: {
        Child
    }
}
</script>
复制代码Child组件
<template>
    <div class="child">
        <input type="text" :value="value" @change="_change">
    </div>
</template>

<script>
export default {
    name: 'Child',
    props: {
        value: String
    },
    methods: {
        _change(e) {
            this.$emit('change', e.target.value)
        }
    }
}
</script>
```

我们需要的投资人是: 了解该项目的技术是依靠区块链的慈善查询工具, 利用区块链的不可修改性和区中心化的性质, 让捐款人的每一笔善款都清晰可见. 外围技术栈为wix, java spring, 具有开发周期快, 产品易上线的特性, 同时具有很高的可靠性, 外围服务的运行安全稳定.


