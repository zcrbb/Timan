<template>
  <div>
    <h1>Methods</h1>
    <v-btn v-on:click="a++">Add to A</v-btn>
    <v-btn v-on:click="b++">Add to B</v-btn>
    <p>Age + A = {{ addToAmethod() }}</p>
    <p>Age + B = {{ addToBmethod() }}</p>
    <v-divider></v-divider>
    <h1>Computed Properties</h1>
    <v-btn v-on:click="c++">Add to C</v-btn>
    <v-btn v-on:click="d++">Add to D</v-btn>
    <!-- <p>Age + C = {{ addToAcomputed }}</p>
    <p>Age + D = {{ addToBcomputed }}</p> -->
    <v-divider></v-divider>
    <v-btn v-on:click="e++">Add to E</v-btn>
    <!-- <p>{{ifitchange}}</p> -->
    <p>{{e}}</p>
  </div>
</template>

<script>
export default {
  name: "Debugger",
  data() {
    return {
      a: 0,
      b: 0,
      c: 0,
      d: 0,
      e: 0,
      ageM: 20,
      ageC: 20
    };
  },

  methods: {
    addToAmethod: function() {
      console.log("add To A method");
      return this.a + this.ageM;
    },
    addToBmethod: function() {
      console.log("add To B method");
      return this.b + this.ageM;
    }
  },
  computed: {
    addToAcomputed: function() {
      console.log("add To A computed");
      return this.c + this.ageC;
    },
    addToBcomputed: function() {
      console.log("add To B computed");
      return this.d + this.ageC;
    },
    ifitchange() {
      let ans = this.e;
      console.log("e is changed to: " + this.e);
      return this.e;
    }
  }
};
</script>

<style>
</style>