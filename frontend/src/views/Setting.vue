<template>
  <v-container>
    <v-row>
      <v-col justify="center">
        <!-- <v-btn color="orange lighten-2"  @click="overlay = !overlay">Show Overlay</v-btn>
        <v-overlay :absolute="absolute" :opacity="opacity" :value="overlay">
          <v-btn color="orange lighten-2" @click="overlay = false">Hide Overlay</v-btn>
        </v-overlay>-->
        <v-btn @click="overlay = !overlay" class="warning">
          <v-icon>mdi-delete-forever</v-icon>
          <span>forget your permisson</span>
        </v-btn>
      </v-col>
      <v-overlay :absolute="absolute" :opacity="opacity" :value="overlay">
        <v-card class="mx-auto" max-width="344" light>
          <v-card-text>
            <div>Warning</div>
            <h3>This will delete your past all thing</h3>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="warning" @click="clearAll(); overlay = false">Yes</v-btn>
            <v-btn color="white" class="grey--text" @click="overlay = false">Cancel</v-btn>
          </v-card-actions>
        </v-card>
      </v-overlay>
    </v-row>
  </v-container>
</template>

<script>
import { mapMutations } from "vuex";
export default {
  data() {
    return {
      absolute: false,
      opacity: 0.5,
      overlay: false
    };
  },
  methods: {
    ...mapMutations(["clearAll"])
  }
};
</script>

<style>
</style>