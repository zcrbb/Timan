<template>
  <div id="app-4">
    <ol>
      <li :key="todo" v-for="todo in todos">{{ todo.text }}</li>
    </ol>
  </div>
</template>

<script>
export default {
  name: "app-4",
  data:()=>({
    todos: [
      { text: "学习 JavaScript" },
      { text: "学习 Vue" },
      { text: "整个牛项目" }
    ]
  })
};
</script>

<style>
</style>