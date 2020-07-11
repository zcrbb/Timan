<template>
  <v-container>
    <v-row align="start" justify="space-around">
      <v-col v-show="things.length==0" cols="6">
        <v-card>
          <v-card-title>There is nothing in your list, please add one</v-card-title>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="orange" text route to="/add">add</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
      <v-col cols="6" v-for="(thing, index) in things" :key="thing.thing">
        <v-card>
          <v-card-title>{{thing.thing}}</v-card-title>
          <v-card-subtitle>
            <v-icon small>mdi-star</v-icon>
            {{thing.urgency}}
          </v-card-subtitle>
          <!-- 时间进度条 -->
          <!-- <v-progress-linear color="primary" :buffer-value="100" stream></v-progress-linear> -->

          <v-card-actions>
            <v-btn icon link large route to="/change">
              <v-icon>mdi-pen</v-icon>
            </v-btn>
            <v-btn icon link large @click="deleteThing(thing);reloadThings()">
              <v-icon>mdi-trash-can</v-icon>
            </v-btn>

            <v-btn icon link large @click="changeDone(thing);reloadThings()">
              <v-icon>mdi-check</v-icon>
            </v-btn>
            <v-btn icon link large @click="stop = !stop">
              <v-icon>{{stop?"mdi-play":"mdi-pause"}}</v-icon>
            </v-btn>

            <v-spacer></v-spacer>

            <v-btn icon @click="changeShow(index)">
              <v-icon>{{ thing.isShow ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
            </v-btn>
          </v-card-actions>

          <v-expand-transition>
            <div v-show="thing.isShow">
              <v-divider></v-divider>
              <v-container>
                <v-row>
                  <v-col v-for="(attr,index) in attrs" :key="index">
                    <v-card rounded class="pa-3">
                      <div class="purple--text text-center">{{attrs[index]}}</div>
                      <div class="text-center">{{thing[attr]}}</div>
                    </v-card>
                  </v-col>
                  <v-col cols="12" class="pl-5 pr-5 pt-5 mb-n5">
                    <v-textarea v-model="thing.remark" auto-grow outlined rows="5"></v-textarea>
                  </v-col>
                </v-row>
              </v-container>
            </div>
          </v-expand-transition>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import Vue from "vue";
import { mapGetters, mapMutations } from "vuex";
// import { ttm } from "../utils/utils";

export default Vue.extend({
  name: "Home",
  data() {
    return {
      things: this.getIsProcessing(),
      attrs: [
        "interest",
        "mental",
        "physical",
        "patient",
        "duration",
        "time",
        "ddl"
      ]
      // stop: true,

      // durationDown: 0,
      // timeDown: 0,
      // processing: 0
    };
  },
  // created() {
  // setInterval(() => {
  //   if (!this.stop && this.durationDown <= this.timeDown) {
  //     this.durationDown++;
  //   }
  //   console.log("execute!");
  // }, 1000);
  // },
  // computed: {
  // durationProcess() {
  //   return thing => {
  //     this.durationDown = parseInt(thing.duration);
  //     this.timeDown = parseInt(thing.time);
  //     this.processing = parseInt(
  //       ((this.timeDown - this.durationDown) * 100) / this.timeDown
  //     );
  //   };
  // }
  // },

  methods: {
    ...mapGetters(["getIsProcessing"]),
    ...mapMutations(["deleteThing", "editThing", "changeDone", "clearAll"]),
    changeShow(index) {
      this.things[index].isShow = !this.things[index].isShow;
      console.log("method: changeShow");
    },
    reloadThings() {
      this.things = this.getIsProcessing();
    }
  }
});
</script>

<style>
</style>