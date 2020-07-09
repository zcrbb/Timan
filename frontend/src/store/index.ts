import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

// 默认到处, 不用写到 store 里面的
export const STORAGE_KEY = "Aruix-timan";

export interface Thing {
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
}

export interface State {
  things: Thing[];
}
// 插件
const localStoragePlugin = (store: {
  // 当 store 初始化后调用
  subscribe: (
    arg0: (mutation: any, { things }: { things: Thing[] }) => void
  ) => void;
}) => {
  // 每次 mutation 之后调用
  store.subscribe((mutation, { things }) => {
    window.localStorage.setItem(STORAGE_KEY, JSON.stringify(things));
  });
};

// save(state) {
//   localStorage.setItem(STORAGE_KEY, JSON.stringify(state.things));
// },
// // 把 localstorage 中的 things 放到 state 里面
// fetch(state) {
//   let things = JSON.parse(
//     localStorage.getItem(STORAGE_KEY || "[]") || "[]"
//   );
//   state.things = things;
// },

export default new Vuex.Store<State>({
  state: {
    things: JSON.parse(localStorage.getItem(STORAGE_KEY) || "[]"),
  },

  mutations: {
    // 增
    addThing(state, thing: Thing) {
      state.things.push(thing);
    },

    // 删
    deleteThing(state, thing) {
      state.things.splice(state.things.indexOf(thing), 1);
    },
    // 改
    editThing(state, thing) {
      const index = state.things.indexOf(thing);
      state.things.splice(index, 1, thing);
    },
    // 设为做完
    changeDone(state, thing) {
      const index = state.things.indexOf(thing);
      let thingState = state.things[index].done;
      state.things[index].done = !thingState;
    },
    // 设为没做完
    processingThing(state, thing) {
      const index = state.things.indexOf(thing);
      state.things[index].done = false;
    },
    // 清除所有
    clearAll(state) {
      state.things = [];
      localStorage.clear();
    },
  },
  getters: {
    getAllThings: (state) => state.things,
    getIsDone: (state) => {
      return state.things.filter((thing) => thing.done == true);
    },
    getIsProcessing: (state) => {
      return state.things.filter((thing) => thing.done == false);
    },
  },
  actions: {},
  modules: {},
  plugins: [localStoragePlugin],
});
