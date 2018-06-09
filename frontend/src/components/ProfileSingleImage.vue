<template>
<div>
  
<router-link :to="{name: 'Profile', params: {imageId: imageId}}" tag="img" class="insta-img" :src="imageLink">
</router-link>

</div>
</template>

<script>  
  import links from '../links';

  export default {
    name: "ProfileSingleImage",
    props:['imageId'],
    computed:{
      imageLink:function(){
        console.log(links.url+'/image/'+this.imageId);
        return links.url+'/image/'+this.imageId;
      }
    }
  };


</script>
