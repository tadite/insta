<template>
  <div v-if="imageChunks.length==0">
    There is no photos yet.
  </div>
  <div v-else>
    <div v-for="imageChunk in imageChunks" class="tile is-ancestor">
      <div class="tile is-parent is-paddingless">
        <article v-for="imageId in imageChunk" class="tile is-child pd5">
          <figure class="image is-square pb30">
            <ProfileSingleImage v-if="imageId" :imageId="imageId" />
          </figure>
        </article>
      </div>
    </div>
  </div>
</template>

<script>  
  import ProfileSingleImage from "./ProfileSingleImage.vue"

  export default {
    name: "ProfileImageTile",
    props: ['imageIds'],
    computed: {
      isEmpty(){
        return this.imageIds.length==0;
      },
      imageChunks: function () {
        var arrays = [], size = 3;
        while (this.imageIds.length%3!=0)
            this.imageIds.push(false);

        while (this.imageIds.length > 0)
          arrays.push(this.imageIds.splice(0, size));

        console.log(this.imageIds.length);
        return arrays;
      }
    },
    components: {
      ProfileSingleImage
    }
  };



</script>
