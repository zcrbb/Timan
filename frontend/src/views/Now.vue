<template>
  <div>
    <!-- <p>{{stop}}</p> -->
    <Countdown :stopProp="stop"  :timeProp="70" ></Countdown>
    <v-btn @click="stop = !stop">Stop</v-btn>
  </div>
</template>
<script>
import Countdown from '../components/DurationDown'

export default {
  data: function() {
    return {
      stop: false,
    }
  },
  components: { Countdown }
}
</script>