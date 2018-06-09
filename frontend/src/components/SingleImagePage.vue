<template>
<div>

{{imageId}}
</div>
</template>

<script>  
  import links from '../links';

  export default {
    name: "SingleImagePage",
    props:['imageId'],
    created:function(){
      this.comment='test';
      console.log('fetch image '+this.imageId);
    },
    computed:{
      imageLink:function(){
        return links.url+'/image/'+this.imageId;
      }
    },
    data: function () {
      return {
        comment: false
      }
    }
  };


</script>
