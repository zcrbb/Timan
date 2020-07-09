<template>
  <div>
    <v-form>
      <v-container>
        <!-- <p>{{thing}}</p> -->
        <h2 class="text-center py-5 grey--text text--darken-1">Add a New Thing</h2>
        <v-row justify="center" class="mx-auto">
          <!-- 时间名称 -->
          <v-col cols="9">
            <v-text-field v-model="thing.thing" label="Thing" outlined autofocus clearable></v-text-field>
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
              max="7"
              min="0"
              thumb-label="always"
              v-model="thing.patient"
              prepend-icon="mdi-bee-flower "
            ></v-slider>
          </v-col>
          <!-- 事件时长 -->
          <v-col cols="6" class="pl-15">
            <v-subheader style="font-size:1.2em">duration</v-subheader>
            <v-time-picker
              width="300"
              v-model="thing.time"
              format="24hr"
              scrollable
              :landscape="$vuetify.breakpoint.smAndUp"
            ></v-time-picker>
          </v-col>
          <!-- DDL -->
          <v-col cols="6" class="text-center">
            <v-subheader style="font-size:1.2em">DDL</v-subheader>
            <v-date-picker v-model="thing.ddl" elevation="15" full-width></v-date-picker>
          </v-col>

          <!-- 备注 -->
          <v-col cols="6" class="pt-12">
            <v-textarea
              class="pt-2"
              height="380"
              filled
              label="Remarks"
              auto-grow
              style="font-size:1.2em"
              v-model="thing.remark"
            ></v-textarea>
          </v-col>

          <v-col cols="12" class="text-center pa-16">
            <v-btn rounded width="500" color="indigo" dark to="/add" @click="save(thing)">Start</v-btn>
          </v-col>
          {{thing}}
        </v-row>
      </v-container>
    </v-form>
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
        done: false
      }
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
      thing.duration = 0;
      thing.thingId = this.getNowIndex;
      thing.isShow = false;
      thing.done = false;
      this.addThing(thing);
      this.thing = {};
    }
  }
};
</script>

<style>
</style>