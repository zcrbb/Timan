<template>
  <div>
    <!-- <p>time: {{time}}</p>
    <p>timeProp: {{timeProp}}</p>
    <p>stop: {{stop}}</p>
    <p>stopProp:{{stopProp}}</p>-->
    <ul class="vuejs-countdown">
      <li>
        <p class="digit">{{ hours | twoDigits }}</p>
        <p class="text">{{ hours > 1 ? 'hours' : 'hour' }}</p>
      </li>
      <li>
        <p class="digit">{{ minutes | twoDigits }}</p>
        <p class="text">min</p>
      </li>
      <li>
        <p class="digit">{{ seconds | twoDigits }}</p>
        <p class="text">Sec</p>
      </li>
    </ul>
  </div>
</template>

<script>
let interval = null;
export default {
  name: "time-down",
  props: {
    timeProp: {
      // 这是传进来的时间,
      type: Number,
      default: 0
    },
    stopProp: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      time: "",
      stop: ""
    };
  },

  created() {
    this.time = this.timeProp;
    this.stop = this.stopProp;
    interval = setInterval(() => {
      if (!this.stopProp && this.time > 0) {
        this.time--;
      }
    }, 1000);
  },

  computed: {
    seconds() {
      return Math.trunc(this.time) % 60;
    },
    minutes() {
      return Math.trunc(this.time / 60) % 60;
    },
    hours() {
      return Math.trunc(this.time / 60 / 60) % 24;
    },
    updateTime() {
      this.time = this.timeProp;
    },
    updateStop() {
      this.stop = this.stopProp;
    }
  },
  filters: {
    twoDigits(value) {
      if (value.toString().length <= 1) {
        return "0" + value.toString();
      }
      return value.toString();
    }
  },
  destroyed() {
    clearInterval(interval);
  }
};
</script>
<style>
.vuejs-countdown {
  padding: 0;
  margin: 0;
}
.vuejs-countdown li {
  display: inline-block;
  margin: 0 8px;
  text-align: center;
  position: relative;
}
.vuejs-countdown li p {
  margin: 0;
}
.vuejs-countdown li:after {
  content: ":";
  position: absolute;
  top: 0;
  right: -13px;
  font-size: 32px;
}
.vuejs-countdown li:first-of-type {
  margin-left: 0;
}
.vuejs-countdown li:last-of-type {
  margin-right: 0;
}
.vuejs-countdown li:last-of-type:after {
  content: "";
}
.vuejs-countdown .digit {
  font-size: 32px;
  font-weight: 600;
  line-height: 1.4;
  margin-bottom: 0;
  color: #1976d2;
}
.vuejs-countdown .text {
  text-transform: uppercase;
  margin-bottom: 0;
  font-size: 10px;
}
</style>



