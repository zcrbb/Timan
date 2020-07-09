import Vue from "vue";
import VueRouter, { RouteConfig } from "vue-router";
import Home from "../views/Home.vue";

Vue.use(VueRouter);

const routes: Array<RouteConfig> = [
  {
    path: "/auth",
    name: "Login",
    component: () => import("../views/Login.vue"),
  },
  {
    path: "/index",
    name: "Index",
    component: () => import("../views/index.vue"),
  },
  {
    path: "/debugger",
    name: "Debugger",
    component: () => import("../views/Debugger.vue"),
  },
  {
    path: "/add",
    name: "Add",
    component: () => import("../views/Add.vue"),
  },
  {
    path: "/summary",
    name: "Summary",
    component: () => import("../views/Summary.vue"),
  },
  {
    path: "/home",
    name: "Home",
    component: Home,
  },
  {
    path: "/now",
    name: "Now",
    component: () => import("../views/Now.vue"),
  },
  {
    path: "/change",
    name: "Change",
    component: () => import("../views/Add.vue"),
  },
  {
    path: "/setting",
    name: "Settings",
    component: () => import("../views/Setting.vue"),
  },
  {
    path: "/past",
    name: "Past",
    component: () => import("../views/Past.vue"),
  },
];

const router = new VueRouter({
  mode: "history",
  routes,
});

export default router;
