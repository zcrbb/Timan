<template>
  <v-overlay>
    <v-card class="mx-auto" max-width="50vw">
      <v-card-text>
        <div>Word of the Day</div>
        <p class="display-1 text--primary"></p>
        <p>adjective</p>
        <div class="text--primary">
          well meaning and kindly.
          <br />"a benevolent smile"
        </div>
      </v-card-text>
      <v-card-actions>
        <v-btn text color="accent">Cancel</v-btn>
        <v-btn text color="success">Submit</v-btn>
      </v-card-actions>
    </v-card>
  </v-overlay>
</template>

<script>
export default {
name="Status",
data() {
  return {
    
  }
},
}
</script>

<style>
</style>