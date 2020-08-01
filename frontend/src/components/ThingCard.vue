<template>
  <v-col cols="6">
    <v-card transition="scale-transition">
      <v-card-title>{{thing.thing}}</v-card-title>
      <v-card-subtitle>
        <v-icon small>mdi-star</v-icon>
        {{thing.urgency}}
      </v-card-subtitle>
      <!-- 时间进度条 -->
      <v-progress-linear :color="thing.color" :buffer-value="100" stream></v-progress-linear>
      <v-card-actions>
        <v-btn icon link large @click="deleteThing(thing);reloadThings()">
          <v-icon>mdi-trash-can</v-icon>
        </v-btn>
        <v-btn icon link large @click="changeDone(thing);reloadThings()">
          <v-icon>mdi-check</v-icon>
        </v-btn>
        <v-btn icon link large @click="addToCenter(thing)">
          <!-- @click="thing.stop = !thing.stop;thing.stop?startCounting(thing):stopCounting(thing)" -->
          <v-icon>{{thing.stop?"mdi-play":"mdi-pause"}}</v-icon>
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
</template>

<script>
import { mapGetters, mapMutations } from "vuex";

export default {
  name: "ThingCard",
  props: {
    thing: {}
  },
  methods: {
    ...mapGetters(["getIsProcessing"]),
    ...mapMutations(["deleteThing", "editThing", "changeDone", "clearAll"])
  }
};
</script>

<style>
</style>