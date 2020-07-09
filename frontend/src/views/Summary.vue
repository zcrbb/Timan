<template>
  <v-container>
    <v-row class="text-center" ailgn="end" justify="center">
      <v-col
        class="text-center text-h4 text-uppercase purple--text text--lighten-2"
        cols="12"
      >You have done {{thingsMember}} things</v-col>
      <v-col cols="12" style="height: 100px;"></v-col>
      <v-col cols="3"></v-col>
      <v-col cols="5">
        <v-card>
          <div class="purple--text" justify="start">Time:</div>
          <div>Days:{{allTime.day}}, Hours: {{allTime.hour}}, Mins: {{allTime.min}}</div>
        </v-card>
      </v-col>
      <v-col cols="3"></v-col>
      <v-col cols="2" v-for="(value, key,index) in attrs" :key="index">
        <v-card>
          <div class="purple--text" justify="start">{{`${value}: ` }}</div>
          <div>{{allAttrs[value]}}</div>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  name: "Summary",
  data() {
    return {
      thingsMember: this.getIsDone().length,
      dayAll: "",
      attrs: {
        urgency: "urgency",
        interest: "interest",
        mental: "mental",
        physical: "physical",
        patient: "patient"
      }
    };
  },
  methods: {
    ...mapGetters(["getIsDone", "getIsProcessing", "getAllThings"])
  },
  computed: {
    allTime() {
      let arr = this.getIsDone();
      let day = 0;
      let hour = 0;
      let min = 0;
      for (let index = 0; index < arr.length; index++) {
        let thing = arr[index];
        if (
          thing.time != "" ||
          thing.time != null ||
          thing.time != "undefined"
        ) {
          let timeArr = thing.time.split(":");
          hour += parseInt(timeArr[0]);
          min += parseInt(timeArr[1]);
        }
      }
      let hourLast = parseInt(min / 60);
      min %= 60;
      hour += hourLast;
      day = parseInt(hour / 24);
      hour %= 24;
      let dataTime = {
        day,
        hour,
        min
      };
      return dataTime;
    },

    allAttrs() {
      let attrsAdd = {
        urgency: 0,
        interest: 0,
        mental: 0,
        physical: 0,
        patient: 0
      };
      // things[]
      let arr = this.getIsDone();
      // 遍历 arr
      for (let index = 0; index < arr.length; index++) {
        let thing = arr[index];
        attrsAdd.urgency += thing.urgency;
        attrsAdd.interest += thing.interest;
        attrsAdd.mental += thing.mental;
        attrsAdd.physical += thing.physical;
        attrsAdd.patient += thing.patientTotal;
      }
      console.log(attrsAdd);
      return attrsAdd;
    }
  }
};
</script>

<style>
</style>