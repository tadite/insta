<template>
<div>

{{imageId}}
</div>
</template>

<script>  
  export default {
    name: "SingleImagePage",
    props:['imageId'],
    created:function(){
      this.comment='test';
      console.log('fetch image '+this.imageId);
    },
    computed:{
      imageLink:function(){
        return 'https://picsum.photos/300/300?random='+this.imageId;
      }
    },
    data: function () {
      return {
        comment: false
      }
    }
  };


</script>
