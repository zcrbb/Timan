<template>
  <div>
    <v-overlay :absolute="false" opacity="0.5" :value="isAlert">
      <v-card class="mx-auto" max-width="344" light>
        <v-card-text>
          <div>Warning</div>
          <h3>please complete your thing</h3>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="white" class="grey--text" @click="isAlert = false">ok</v-btn>
        </v-card-actions>
      </v-card>
    </v-overlay>
    <v-container>
      <!-- <p>{{thing}}</p> -->
      <h2 class="text-center py-5 grey--text text--darken-1">Add a New Thing</h2>
      <v-row class="mx-auto">
        <!-- 时间名称 -->
        <v-col cols="12">
          <v-text-field
            :rules="thingRules"
            v-model="thing.thing"
            label="Thing"
            outlined
            autofocus
            clearable
          ></v-text-field>
        </v-col>
        <!-- 事件紧要度 -->
        <v-col cols="6" class="pa-3">
          <v-subheader style="font-size:1.2em">urgency</v-subheader>
          <v-slider
            class="pt-7"
            step="1"
            thumb-label="always"
            v-model="thing.urgency"
            prepend-icon="mdi-timeline-alert"
            max="5"
            min="0"
          ></v-slider>
        </v-col>
        <!-- 事件兴趣度 -->
        <v-col cols="6" class="pa-3">
          <v-subheader style="font-size:1.2em">interest</v-subheader>
          <v-slider
            class="pt-7"
            step="1"
            max="5"
            min="0"
            thumb-label="always"
            v-model="thing.interest"
            prepend-icon="mdi-heart"
          ></v-slider>
        </v-col>

        <!-- 事件精神消耗值 -->
        <v-col cols="6" class="pa-3">
          <v-subheader style="font-size:1.2em">mental</v-subheader>
          <v-slider
            class="pt-7"
            step="1"
            max="5"
            min="0"
            thumb-label="always"
            v-model="thing.mental"
            prepend-icon="mdi-face"
          ></v-slider>
        </v-col>
        <!-- 事件体力消耗值 -->
        <v-col cols="6" class="pa-3">
          <v-subheader style="font-size:1.2em">physical</v-subheader>
          <v-slider
            class="pt-7"
            step="1"
            max="5"
            min="0"
            thumb-label="always"
            v-model="thing.physical"
            prepend-icon="mdi-run"
          ></v-slider>
        </v-col>
        <!-- 事件耐心消耗值 -->
        <v-col cols="6" class="pa-3">
          <v-subheader style="font-size:1.2em">patient</v-subheader>
          <v-slider
            class="pt-7"
            step="1"
            min="0"
            max="7"
            thumb-label="always"
            v-model="thing.patient"
            prepend-icon="mdi-bee-flower"
          ></v-slider>
        </v-col>
        <!-- 事件是否为周期性 -->
        <v-col cols="2" class="pa-3">
          <v-subheader></v-subheader>
          <!-- <v-subheader style="font-size:1.2em">is periodic?</v-subheader> -->
          <v-checkbox v-model="isPeriodic" label="Periodic"></v-checkbox>
        </v-col>

        <v-col cols="4" v-show="isPeriodic">
          <v-subheader style="font-size:1.2em">Once every {{thing.frequency}} days</v-subheader>
          <v-slider
            class="pt-7"
            step="1"
            max="7"
            min="1"
            thumb-label="always"
            v-model="thing.frequency"
            prepend-icon="mdi-alarm-bell"
          ></v-slider>
        </v-col>

        <!-- 事件时长 -->
        <v-col cols="6" class="pl-15">
          <v-subheader style="font-size:1.2em">time</v-subheader>
          <v-time-picker
            rules="timeRules"
            v-model="thing.time"
            format="24hr"
            scrollable
            :landscape="$vuetify.breakpoint.smAndUp"
          ></v-time-picker>
        </v-col>
        <!-- DDL -->
        <v-col cols="6">
          <v-subheader style="font-size:1.2em">DDL</v-subheader>
          <v-date-picker v-model="thing.ddl" full-width></v-date-picker>
        </v-col>

        <v-col cols="6" class="text-center">
          <v-subheader style="font-size:1.2em">Choose a color for it</v-subheader>
          <v-spacer></v-spacer>
          <v-color-picker mode="rgba" v-model="thing.color" class="ml-15"></v-color-picker>
        </v-col>

        <!-- 备注 -->
        <v-col cols="6" class="pt-12" justify="center">
          <v-textarea
            class="pt-2"
            rows="10"
            filled
            label="Remarks"
            auto-grow
            style="font-size:1.2em"
            v-model="thing.remark"
          ></v-textarea>
        </v-col>

        <v-col cols="12" class="text-center pa-16">
          <v-btn rounded block color="indigo" dark @click="save(thing)">Start</v-btn>
        </v-col>
        <v-col cols="12" class="mx-auto">
          <v-btn class="mx-auto" small outlined @click="thing={}">clear all</v-btn>
        </v-col>

        <v-card>isPeriodic: {{isPeriodic}}</v-card>
        <v-card>{{thing}}</v-card>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import { mapMutations } from "vuex";
let key = "Aruix-timan";

export default {
  data() {
    return {
      // v-model绑定的格式, 不是存储格式
      thing: {
        thingId: "",
        thing: "",
        urgency: "",
        interest: "",
        mental: "",
        physical: "",
        patient: "",
        time: "",
        duration: "",
        ddl: "",
        remark: "",
        isShow: false,
        done: false,
        color: "",
        frequency: ""
      },
      isPeriodic: false,
      thingRules: [
        value => !!value || "Required.",
        value => (value && value.length >= 3) || "Min 3 characters"
      ],
      timeRules: [value => !!value || "Required."],
      // items: ["Once", "Periodic"],
      isAlert: false
    };
  },
  computed: {
    getNowIndex() {
      return this.$store.state.things.length;
    }
  },
  methods: {
    ...mapMutations(["addThing"]),
    save: function(thing) {
      if (this.thing.time == "" || this.thing.thing == "") {
        this.isAlert = true;
        return;
      }
      if (thing.frequency == "") {
        thing.frequency = 0;
      }
      thing.duration = 0;
      thing.thingId = this.getNowIndex;
      thing.stop = true;
      thing.isShow = false;
      thing.done = false;
      this.addThing(thing);
      this.thing = {};
      this.thing.color = "";
    }
  }
};
</script>

<style>
</style>