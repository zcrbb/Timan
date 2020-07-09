<template>
  <v-container>
    <!-- {{doneThings}} -->
    <v-row align="start" justify="space-around">
      <v-col cols="3" v-for="thing in doneThings" :key="thing.thing">
        <v-card>
          <v-card-title>{{thing.thing}}</v-card-title>
          <v-card-subtitle>
            <v-icon small>mdi-star</v-icon>
            {{thing.urgency}}
          </v-card-subtitle>
          <v-card-actions>
            <v-btn icon link large @click="deleteThing(thing)">
              <v-icon>mdi-trash-can</v-icon>
            </v-btn>
            <v-btn icon link large @click="changeDone(thing)">
              <v-icon>mdi-play</v-icon>
            </v-btn>
            <v-spacer></v-spacer>
            <!-- <v-btn icon @click="changeShow(index)"> -->
            <v-btn icon @click="thing.isShow = !thing.isShow">
              <v-icon>{{ thing.isShow ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
            </v-btn>
          </v-card-actions>
          <v-expand-transition>
            <div v-show="thing.isShow">
              <v-divider></v-divider>
              <v-container>
                <v-row>
                  <v-col v-for="(attr,index) in attrs" :key="index">
                    <v-card outlined rounded class="pa-3">
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
import { mapGetters, mapMutations } from "vuex";
export default {
  name: "past",
  data() {
    return {
      doneThings: this.getIsDone(),
      attrs: [
        "interest",
        "mental",
        "physical",
        "patient",
        "duration",
        "time",
        "ddl"
      ]
    };
  },
  methods: {
    ...mapGetters(["getIsDone"]),
    ...mapMutations(["changeDone", "deleteThing"]),
    changeShow(index) {
      this.doneThings[index].isShow = !this.doneThings[index].isShow;
      console.log("method: changeShow");
    }
  }
};
</script>

<style>
</style>