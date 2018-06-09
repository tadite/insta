<template>
<div>
  
<router-link :to="{name: 'Profile', params: {imageId: imageId}}" tag="img" class="insta-img" :src="imageLink">
  
  </router-link>
<a v-if="editing" class="delete insta-img-cross is-medium"></a>
</div>
</template>

<script>  
  export default {
    name: "ProfileSingleImage",
    props:['imageId'],
    computed:{
      imageLink:function(){
        return 'https://picsum.photos/300/300?random='+this.imageId;
      }
    }
  };


</script>
