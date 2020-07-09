<template>
  <div>
    <!-- 侧边导航 -->
    <v-navigation-drawer v-model="drawer" app clipped>
      <v-list>
        <!-- 主页: 看现在正在进行的所有项目 -->
        <v-list-item link router to="/home">
          <v-list-item-action>
            <v-icon>mdi-home</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>Home</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <!-- 现在: 现在所进行的事情 -->
        <!-- <v-list-item link router to="/now">
          <v-list-item-action>
            <v-icon>mdi-timer</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>Now</v-list-item-title>
          </v-list-item-content>
        </v-list-item>-->

        <!-- 添加页: 添加新项目 -->
        <v-list-item link router to="/add">
          <v-list-item-action>
            <v-icon>mdi-plus</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>Add</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <!-- 完成页: 已经完成的 -->
        <v-list-item link router to="/past">
          <v-list-item-action>
            <v-icon>mdi-check-all</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>Past</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <!-- 统计页: 统计过去所有的细节 -->
        <v-list-item link router to="/summary">
          <v-list-item-action>
            <v-icon>mdi-poll-box</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>Summary</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <!-- 设置页: 用于设置计算方法, 账户情况 -->
        <v-list-item link router to="/setting">
          <v-list-item-action>
            <v-icon>mdi-cog</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>Setting</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
      <!-- 退出登录 -->
      <template v-slot:append>
        <div class="pa-2">
          <v-btn block link router to="/auth" depressed class="primary">Logout</v-btn>
        </div>
      </template>
    </v-navigation-drawer>

    <!-- 顶部导航 -->
    <v-app-bar app color="indigo" dark clipped-left>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>Timan</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn depressed text-color="white" color="indigo" href="http://aruix.world/blog">Bolg</v-btn>
    </v-app-bar>

    <!-- 脚注 -->
    <v-footer color="indigo" app>
      <span class="white--text">Aruix &copy; 2020</span>
    </v-footer>
  </div>
</template>

<script>
export default {
  name: "NavBar",
  data: () => ({
    drawer: null
  })
};
</script>