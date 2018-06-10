<template>
<div>
  
<router-link :to="{name: 'Profile', params: {imageId: imageId}}" tag="img" class="insta-img" :src="imgData">
</router-link>

</div>
</template>

<script>  
  import axios from 'axios';
  import links from '../links';

  export default {
    name: "ProfileSingleImage",
    props:['imageId'],
    created: function() {
        console.log('IMAGE_WATCH');
        console.log(this.imageId);
        console.log(links.url+'/image/'+this.imageId);

        axios.get(links.url+'/image/'+this.imageId)
          .then(response => {  
            console.log(response.data);
            this.imgData=response.data;
          })
          .catch(error => {
            console.log(error.response)
          });
    },
    data:function () {
      return {
        imgData: ''
      }
    },
  };


</script>
