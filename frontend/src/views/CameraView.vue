<script>
import { ref } from 'vue';
import { Camera, CameraResultType } from '@capacitor/camera';

export default {
  setup() {
    const imageUrl = ref(undefined);

    const takePicture = async () => {
      const image = await Camera.getPhoto({
        quality: 90,
        allowEditing: true,
        resultType: CameraResultType.Uri
      });

      imageUrl.value = image.webPath;
    };

    return {
      imageUrl,
      takePicture
    };
  }
};
</script>


<template>
  <div>
    <button @click="takePicture">Take Picture</button>
    <img v-if="imageUrl" :src="imageUrl" />
  </div>
</template>

<style scoped>

</style>