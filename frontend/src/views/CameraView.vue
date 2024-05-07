<script>
  import {notesStore} from "@/store/modules/notes.js";

  export default {
    data() {
      const store = notesStore();
      return {
        store,
      }
    },
    methods: {
      photoTakenEvent({ blob, image_data_url }) {
        this.$emit('photoTaken', { blob, image_data_url })
        this.store.photoTaken = true;
        this.store.photo_url = image_data_url;
        console.log(this.store.photo_url);
        this.$router.go(-1);
      },
    },
    mounted() {
      this.store.photoTaken = false;
    }
  }
</script>

<template>
  <WebCamUI :fullscreenState="true"  @photoTaken="photoTakenEvent" />
</template>

<style scoped>

</style>