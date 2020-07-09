<template>
  <v-app>
    <!-- 是登录/注册页面的时候, 才没有 nav-bar -->
    <nav-bar v-if="isAuthPage"></nav-bar>
    <v-main>
      <router-view></router-view>
    </v-main>
  </v-app>
</template>

<script lang="ts">
import Vue from "vue";
import NavBar from "@/components/NavBar.vue";

export default Vue.extend({
  name: "App",
  props: {
    source: String
  },
  components: {
    NavBar
  },
  computed: {
    isAuthPage() {
      return this.$route.path != "/auth";
      console.log(this.$route.path);
    }
  }
});
</script>
