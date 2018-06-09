<template>

<div class="modal" v-bind:class="{ 'is-active': isActive }">
  <div class="modal-background" @click="$router.go(-1)"></div>
  <div class="modal-content">
    <p class="image is-4by3">
      <img v-if="isActive"  :src="imageLink" alt="">
    </p>
  </div>
  <button class="modal-close is-large" @click="$router.go(-1)" aria-label="close"></button>
</div>

</template>

<script>
export default {
  props:['imageId'],
  computed:{
      isActive: function(){
          return this.imageId!=undefined;
      },
      imageLink:function(){
        return 'https://picsum.photos/300/300?random='+this.imageId;
      }
  },
  created() {
    // use $route.params.id to get the item for that ID from whereever you have stored all the items.
    
  }
}
</script>