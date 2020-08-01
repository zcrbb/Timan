<template>
  <v-container>
    <v-row align="start" justify="space-around" transition="scale-transition">
      <!-- 提示没有 TODOs -->
      <v-col v-show="things.length==0" cols="8" transition="scale-transition">
        <v-card transition="scale-transition">
          <v-card-title>There is nothing in your list, please add one</v-card-title>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="orange" text route to="/add">add</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>

      <!-- 现在正在进行的, 为了确保进行中的只有一项 -->
        <v-col cols="12" v-show="JSON.stringify(centerThing) !== '{}'">
          <v-card>
            <v-card-title>{{centerThing.thing}}</v-card-title>
            <v-card-subtitle>
              <v-icon small>mdi-star</v-icon>
              {{centerThing.urgency}}
            </v-card-subtitle>
            <!-- 时间进度条 -->
            <v-progress-linear :color="centerThing.color" :buffer-value="100" stream></v-progress-linear>

            <v-card-actions>
              <v-btn icon link large route to="/change">
                <v-icon>mdi-pen</v-icon>
              </v-btn>
              <v-btn icon link large @click="deleteThing(centerThing);reloadThings()">
                <v-icon>mdi-trash-can</v-icon>
              </v-btn>

              <v-btn icon link large @click="changeDone(centerThing);reloadThings()">
                <v-icon>mdi-check</v-icon>
              </v-btn>
              <!-- <v-btn icon link large @click="addToCenter(thing)">
              <v-icon>{{thing.stop?"mdi-play":"mdi-pause"}}</v-icon>
              </v-btn>-->

              <v-spacer></v-spacer>

              <v-btn icon @click="centerThing.isShow=!centerThing.isShow">
                <v-icon>{{ centerThing.isShow ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
              </v-btn>
            </v-card-actions>

            <v-expand-transition>
              <div v-show="centerThing.isShow">
                <v-divider></v-divider>
                <v-container>
                  <v-row>
                    <v-col v-for="(attr,index) in attrs" :key="index">
                      <v-card rounded class="pa-3">
                        <div class="purple--text text-center">{{attrs[index]}}</div>
                        <div class="text-center">{{centerThing[attr]}}</div>
                      </v-card>
                    </v-col>
                    <v-col cols="12" class="pl-5 pr-5 pt-5 mb-n5">
                      <v-textarea v-model="centerThing.remark" auto-grow outlined rows="5"></v-textarea>
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
      ],
      centerThing: {},
      submitStatus: false,
      // stop: true
    };
  },
  methods: {
    ...mapGetters(["getIsProcessing"]),
    ...mapMutations(["deleteThing", "editThing", "changeDone", "clearAll"]),
    changeShow(index) {
      this.things[index].isShow = !this.things[index].isShow;
      console.log("method: changeShow");
    },
    reloadThings() {
      this.things = this.getIsProcessing();
    },
    addToCenter(thing) {
      this.centerThing = thing;
    }
  }
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
  // methods: {
  //   startCounting(thing, counting) {
  //     let timeArr = thing.time.split(":");
  //     let hour = parseInt(timeArr[0]);
  //     let min = parseInt(timeArr[1]);
  //     let timeObj = tto(timeStr);
  //     return timeObj.hour * 60 + timeObj.min;

  //     console.log("开始了!");
  //     let processing = 0;
  //     thing.counting = setInterval(() => {
  //       if (thing.time - thing.duration > 0) {
  //         thing.duration++;
  //         console.log("duration: " + thing.duration);
  //         processing = parseInt((thing.duration * 100) / thing.time);
  //         console.log("processing: " + processing);
  //       } else {
  //         console.log("time out");
  //         clearInterval(counting);
  //         return;
  //       }
  //     }, 1000);
  //   },
  //   stopCounting(counting) {
  //     clearInterval(counting);
  //     console.log("stopInterval");
  //   }
  // },

  // computed: {
  //   startCounting() {
  //     (thing, counting) => {
  //       console.log("开始了!");
  //       let processing = 0;
  //       thing.counting = setInterval(() => {
  //         if (thing.time - thing.duration > 0) {
  //           thing.duration++;
  //           console.log("duration: " + thing.duration);
  //           processing = parseInt((thing.duration * 100) / thing.time);
  //           console.log("processing: " + processing);
  //           //
  //           // setTimeout(() => {
  //           //   clearInterval(counting);
  //           //   console.log("停止了");
  //           // }, 2000);
  //         } else {
  //           console.log("time out");
  //           clearInterval(counting);
  //           return;
  //         }
  //       }, 1000);
  //     };
  //   },
  //   stopCounting() {
  //     counting => {
  //       clearInterval(counting);
  //       console.log("stopInterval");
  //     };
  //   }
  // },
});
</script>

<style>
</style>